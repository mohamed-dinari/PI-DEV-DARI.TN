package dari.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dari.entity.Client;
import dari.entity.LigneCommand;
import dari.entity.StateCommand;
import dari.entity.Surveillance;
import dari.entity.SurveillanceCommand;
import dari.entity.SurveillanceOfficer;
import dari.repository.ClientRepository;
import dari.repository.LigneCommandRepository;
import dari.repository.SurveillanceCommandRepository;
import dari.repository.SurveillanceOfficerRepository;

@Service
public class SurveillanceCommandServiceImpl2 implements ISurveillanceCommandService{
	
	@Autowired
	SurveillanceCommandRepository surveillanceCommandRepository; 
	
	@Autowired
	ClientRepository clientRepository;
	
	@Autowired
	SurveillanceOfficerRepository surveillanceOfficerRepository;
	
	@Autowired
	LigneCommandRepository ligneCommandRepository;

	@Override
	public String generateCodeCommande() {
		// TODO Auto-generated method stub
		return UUID.randomUUID().toString().toUpperCase().substring(0, 18);
	}
	
	@Override
	public void removeCommand(Long idCommand) {
		// TODO Auto-generated method stub
		surveillanceCommandRepository.deleteById(idCommand);			
	}
	
	@Override
	public List<LigneCommand> detailsCommand(Long idCommand) {
		// TODO Auto-generated method stub
		return surveillanceCommandRepository.findById(idCommand).get().getLigneCommands();
	}
	
	@Override
	public boolean verifeCommand(List<LigneCommand> lc) {
		// TODO Auto-generated method stub
		Long idAgent0=ligneCommandRepository.returnIdAgentByLigneCommande(lc.get(0).getIdLigneCommand());
		for (LigneCommand ligneCommand : lc) {
			Long idAgent = ligneCommandRepository.returnIdAgentByLigneCommande(ligneCommand.getIdLigneCommand());
			if(idAgent0 !=idAgent )
			{
				return false;
			}
		}
		return true;
	}
	@Override
	public List<SurveillanceCommand> displayCommandClientByState(Long idClient, StateCommand sc, boolean stateRequest) {
		// TODO Auto-generated method stub
		return surveillanceCommandRepository.afficherCommandClientByPara(idClient, sc, stateRequest);
	}

	@Override
	public List<SurveillanceCommand> displayCommandAgentByState(Long idAgent, StateCommand sc, boolean stateRequest) {
		// TODO Auto-generated method stub
		List<String> codes = surveillanceCommandRepository.trouverCodeCommandeAgent(idAgent);
		List<SurveillanceCommand> liste = new ArrayList<>();
		for (String code : codes) {
			
		liste.add(surveillanceCommandRepository.afficherCommandAgentByPara(code,sc,stateRequest));
			
		}
		return liste;
	}

	@Override
	public SurveillanceCommand demandeDevis(List<LigneCommand> lc, Long idClient) {
		// TODO Auto-generated method stub
		SurveillanceCommand sc = new SurveillanceCommand();
		SurveillanceCommand x =  surveillanceCommandRepository.save(sc);
		x.setCodeCommande(generateCodeCommande());
		x.setDateCammand(new Date());
		x.setStateCommand(StateCommand.DEVIS);
		x.setStaterequest(false);
		x.setFournisseurCommand(surveillanceCommandRepository.findProviderOfCommand(lc.get(0).getIdLigneCommand()));
        double pc=0;
		for (LigneCommand ligneCommand : lc) {
			pc+=ligneCommand.getLignePrice();
			ligneCommand.setSurveillanceCommand(sc);
			ligneCommandRepository.save(ligneCommand);
		}
		x.setPriceCommand(pc);	
		x.setFinalPriceCommand(pc);
		x.setClient(clientRepository.findById(idClient).get());
		return surveillanceCommandRepository.save(x);
	}
	
	@Override
	public SurveillanceCommand ReponseDevis(Long idCommand, String description, double bonus) {
		// TODO Auto-generated method stub
		SurveillanceCommand sc = surveillanceCommandRepository.findById(idCommand).get();
		sc.setDescription(description);
		sc.setDiscountprice(bonus);
		sc.setFinalPriceCommand(sc.getPriceCommand()-sc.getDiscountprice());
		sc.setStaterequest(true);
		surveillanceCommandRepository.save(sc);
		return sc;
	}
	
	@Override
	public SurveillanceCommand requestPasseCommand(Long idCommand) {
		// TODO Auto-generated method stub
		SurveillanceCommand sc = surveillanceCommandRepository.findById(idCommand).get();
		sc.setDateCammand(new Date());
		sc.setStaterequest(false);
		sc.setStateCommand(StateCommand.PASSECOMMAND);
		surveillanceCommandRepository.save(sc);
		return sc;
	}
	
	@Override
	public SurveillanceCommand responsePasseCommand(Long idCommand , String description) {
		// TODO Auto-generated method stub
		SurveillanceCommand sc = surveillanceCommandRepository.findById(idCommand).get();
		sc.setStaterequest(true);
		sc.setDescription(description);
		surveillanceCommandRepository.save(sc);
		return sc;
	}

	@Override
	public void annulerPassCommand(Long idCommand) {
		// TODO Auto-generated method stub
		SurveillanceCommand sc = surveillanceCommandRepository.findById(idCommand).get();
		sc.setStateCommand(StateCommand.ANNULER);
		sc.setStaterequest(true);
		surveillanceCommandRepository.save(sc);
		
	}

	@Override
	public void CommandConfirmer(Long idCommand) {
		// TODO Auto-generated method stub
		SurveillanceCommand sc = surveillanceCommandRepository.findById(idCommand).get();
		sc.setStateCommand(StateCommand.OK);
		sc.setStaterequest(true);
		surveillanceCommandRepository.save(sc);
	}

	@Override
	public SurveillanceCommand requestRetourCommand(Long idCommand) {
		// TODO Auto-generated method stub
		SurveillanceCommand sc = surveillanceCommandRepository.findById(idCommand).get();
		sc.setStateCommand(StateCommand.AVOIR);
		sc.setStaterequest(false);
		return surveillanceCommandRepository.save(sc);
	}

	@Override
	public SurveillanceCommand responseRetourCommand(Long idCommand , String description , boolean avoir) {
		// TODO Auto-generated method stub
		SurveillanceCommand sc = surveillanceCommandRepository.findById(idCommand).get();
		sc.setStateCommand(StateCommand.AVOIR);
		sc.setStaterequest(true);
		sc.setAvoir(avoir);
		if(avoir=true)
		{
			AvoirClient(idCommand);
			AvoirAgent(idCommand);
		}
		return surveillanceCommandRepository.save(sc);
	}

	@Override
	public Map<SurveillanceOfficer,Double> AvoirClient(Long idCommand) {
		// TODO Auto-generated method stub
		SurveillanceCommand sc = surveillanceCommandRepository.findById(idCommand).get();
		SurveillanceOfficer so = surveillanceCommandRepository.findOfficerOfCommand(idCommand);
		Client c =sc.getClient();
		Map<SurveillanceOfficer,Double> map = c.getAvoirs();
		if(map.containsKey(so)){
			Double valeurs;
			for(Map.Entry<SurveillanceOfficer, Double> m : map.entrySet()){
				if(m.getKey().equals(so)){
					valeurs=m.getValue();
					valeurs+=sc.getFinalPriceCommand();
					map.put(so,valeurs);
					c.setAvoirs(map);
					clientRepository.save(c);}}}
		else{
		map.put(so, sc.getFinalPriceCommand());
		c.setAvoirs(map);
		clientRepository.save(c);}
		return map;
	}

	@Override
	public Map<Client, Double> AvoirAgent(Long idCommand) {
		// TODO Auto-generated method stub
		SurveillanceCommand sc = surveillanceCommandRepository.findById(idCommand).get();
		SurveillanceOfficer so = surveillanceCommandRepository.findOfficerOfCommand(idCommand);
		Client c =sc.getClient();
		Map<Client,Double> map = so.getAvoirs();
		if(map.containsKey(c)){
			Double valeur;
			for (Map.Entry<Client, Double> m : map.entrySet()) {
				if(m.getKey().equals(c)){
				valeur=m.getValue();
				valeur+=sc.getFinalPriceCommand();
				map.put(c, valeur);
				so.setAvoirs(map);
				surveillanceOfficerRepository.save(so);}}}
		else{
		map.put(c, sc.getFinalPriceCommand());
		so.setAvoirs(map);
		surveillanceOfficerRepository.save(so);	}
		return map;
	}

	@Override
	public Map<Surveillance, Integer> statistiquebyllike(Long idAgent) {
		// TODO Auto-generated method stub
		Map<Surveillance, Integer> map =new HashMap<>();
		SurveillanceOfficer so = surveillanceOfficerRepository.findById(idAgent).get();
		List<Surveillance> list = so.getSurveillances();
		for (Surveillance s : list) {
			map.put(s, s.getJaime());
		}
		return map;
	}

	@Override
	public Map<Surveillance, Integer> statistiquebyDesike(Long idAgent) {
		// TODO Auto-generated method stub
		Map<Surveillance, Integer> map =new HashMap<>();
		SurveillanceOfficer so = surveillanceOfficerRepository.findById(idAgent).get();
		List<Surveillance> list = so.getSurveillances();
		for (Surveillance s : list) {
			map.put(s, s.getJaimeplus());
		}
		return map;
	}

	@Override
	public Map<Surveillance, Integer> surveillanceVendre(Long idAgent) {
		// TODO Auto-generated method stub
		Map<Surveillance, Integer> map =new HashMap<>();
		/*SurveillanceOfficer so = surveillanceOfficerRepository.findById(idAgent).get();
		List<Surveillance> list = so.getSurveillances();
		for (Surveillance s : list) {
			map.put(s, surveillanceCommandRepository.statistiquebyStateOK(StateCommand.OK));
		}*/
		return map;
	}

	@Override
	public Map<Surveillance, Integer> surveillanceRetour(Long idAgent) {
		// TODO Auto-generated method stub
		/*Map<Surveillance, Integer> map =new HashMap<>();
		SurveillanceOfficer so = surveillanceOfficerRepository.findById(idAgent).get();
		
		List<String> codes = surveillanceCommandRepository.trouverCodeCommandeAgent(idAgent);
		List<SurveillanceCommand> commands = new ArrayList<>();
		for (String code : codes) {
		commands.add(surveillanceCommandRepository.afficherCommandAgentByPara(code, StateCommand.AVOIR, true));
		}
		
		List<Surveillance> list = so.getSurveillances();
		for (Surveillance s : list) {
			map.put(s,0);
			for (SurveillanceCommand cmmd : commands) {
				List<LigneCommand> ligne =cmmd.getLigneCommands();
				for (LigneCommand lc : ligne) {
					if(lc.getSurveillance().equals(s)){
						map.put(s, surveillanceCommandRepository.statistiquebyStateAvoir(cmmd, true));
					}
				}
			}
		}*/
		return null;
	}

	@Override
	public Map<Date, Double> ventParMois(Long idAgent) {
		// TODO Auto-generated method stub
		return null;
	}

	


	


}
