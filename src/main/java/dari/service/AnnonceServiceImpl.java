package dari.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dari.entity.AnnonceImmobilier;
import dari.entity.AnnonceRegion;
import dari.entity.AnnonceType;
import dari.entity.Client;
import dari.entity.TypeTransaction;
import dari.repository.AnnonceRepository;
import dari.repository.ClientRepository;

@Service
public class AnnonceServiceImpl implements IAnnonceService {
	@Autowired
	AnnonceRepository ar;
	@Autowired
	ClientRepository cr;
	
	private static final Logger L =LogManager.getLogger(AnnonceServiceImpl.class);
	
	
	@Override
	public AnnonceImmobilier addAnnonce(long id,AnnonceImmobilier annonce) {
		Client c = cr.findById(id).get();
		annonce.setClient(c);
		return ar.save(annonce);
	}
	@Override
	public List<AnnonceImmobilier> retrieveAllAnnonces() {
		
		List<AnnonceImmobilier> annonces =(List<AnnonceImmobilier>) ar.findAll();
		
		for(AnnonceImmobilier annonce : annonces  ){
			L.info("annonce +++"+ annonce ) ;
		}
			return annonces;
	}

	/*@Override
	public AnnonceImmobilier addAnnonce(long id_client,AnnonceImmobilier annonce) {
		Client a = new Client();
		Client c = (Client) cr.findById(id_client).get();
		a.setIdClient(id_client);a.setAdresseEmail(c.getAdresseEmail());a.setTel(c.getTel());
		annonce.setClient(a);
		//String s = "+216" + c.getTel();
		//sendSms(s, "+18479735081", "You have requested to add a property");
		return annonceRepository.save(annonce);
		}*/

	@Override
	public AnnonceImmobilier retrieveAnnonce(long annonce_ref) {
		
		return ar.findById(annonce_ref).get();
	}

	@Override
	public void deleteAnnonce(long annonce_ref) {
		ar.deleteById(annonce_ref);
	}

	@Override
	public AnnonceImmobilier updateAnnonce(AnnonceImmobilier annonce) {
		return ar.save(annonce);
	}

	@Override
	public List<AnnonceImmobilier> retrieveAnnonceByRegion(AnnonceRegion region) {
		
		return ar.retrieveByRegion(region);
	}

	@Override
	public List<AnnonceImmobilier> retrieveAnnonceByType(AnnonceType type) {	
		return ar.retrieveByType(type);
	}

	@Override
	public List<AnnonceImmobilier> retrieveAnnonceByPrixMax(long prixMax) {

		return ar.retrieveByPrixMax(prixMax);
	}

	@Override
	public List<AnnonceImmobilier> retrieveAnnonceByPrixMin(long prixMin) {
	
		return ar.retrieveByPrixMin(prixMin);
	}

	@Override
	public List<AnnonceImmobilier> retrieveAnnonceByTypeTrans(TypeTransaction typeTrans) {

		return ar.retrieveByTypeTrans(typeTrans);
	}

	@Override
	public long StatByRegion(AnnonceRegion region) {
		
		return ar.statByRegion(region);
	}

	/*@Override
	public long StatByPrixMax(long prixMax) {
		return annonceRepository.stateByPrixMax(prixMax);
	}
	@Override
	public long StatByPrixMin(long prixMin) {
		return annonceRepository.stateByPrixMin(prixMin);
	}*/

	@Override
	public long StatByType(AnnonceType type) {
		return ar.statByType(type);
	}

	@Override
	public long StatByTypeTrans(TypeTransaction typeTrans) {

		return ar.statByTypeTrans(typeTrans);
	}


}
