package dari.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import dari.entity.LigneCommand;
import dari.entity.StateCommand;
import dari.entity.SurveillanceCommand;
import dari.service.ISurveillanceCommandService;

@Controller
public class SurveillanceCommandController {
	
		@Autowired
		ISurveillanceCommandService surveillanceCommandService;
		
		@GetMapping("/detailsCommand/{idCommand}")
		@ResponseBody
		public ResponseEntity<Object> detailsCommand(@PathVariable("idCommand") Long idCommand){
		try{
		 return new ResponseEntity<Object>(surveillanceCommandService.detailsCommand(idCommand),HttpStatus.OK);
		    }
		 catch (Exception e){
		return new	ResponseEntity<>(e.getMessage() , HttpStatus.EXPECTATION_FAILED);
			}
		}
		
		@DeleteMapping("/deleteCommand/{idCommand}")
		@ResponseBody
		public ResponseEntity<Object> removeCommand(@PathVariable("idCommand") Long idCommand){
		try{
		surveillanceCommandService.removeCommand(idCommand);
		return new ResponseEntity<Object>("the command has been successfully removed :)",HttpStatus.OK);
		}
		catch (Exception e){
		return new	ResponseEntity<>(e.getMessage() , HttpStatus.EXPECTATION_FAILED);
		}
		}
	
		@PostMapping("/AddDevis/{idClient}")
		@ResponseBody
		public ResponseEntity<Object> addDevis(@RequestBody List<LigneCommand> lc, @PathVariable("idClient") Long idClient) {
	    try{
		return new ResponseEntity<Object>(surveillanceCommandService.demandeDevis(lc, idClient),HttpStatus.OK);
		}
		catch (Exception e){
		return new	ResponseEntity<>(e.getMessage() , HttpStatus.EXPECTATION_FAILED);
		}
		}
		
		@PutMapping("/ReponseDevis")
		@ResponseBody
		public SurveillanceCommand ReponseDevis(@RequestBody Long idCommand , @RequestBody String description , @RequestBody double bonus ) {
			return	surveillanceCommandService.ReponseDevis(idCommand, description, bonus);
		}
		
		@PutMapping("/requestPasseCommand")
		@ResponseBody
		public SurveillanceCommand requestPasseCommand(@RequestBody Long idCommand) {
			return	surveillanceCommandService.requestPasseCommand(idCommand);
		}
		
		@PutMapping("/responsePasseCommand")
		@ResponseBody
		public SurveillanceCommand responsePasseCommand(@RequestBody Long idCommand ,@RequestBody String description ) {
			return	surveillanceCommandService.responsePasseCommand(idCommand, description);
		}
		
		@GetMapping("/afficherRequestDevisClient/{idClient}")
		@ResponseBody
		public List<SurveillanceCommand> afficherRequestDevisClient(@PathVariable("idClient") Long idClient){
			return surveillanceCommandService.displayCommandClientByState(idClient, StateCommand.DEVIS, false);
		}
		
		@GetMapping("/afficherResponseDevisClient/{idClient}")
		@ResponseBody
		public List<SurveillanceCommand> afficherResponseDevisClient(@PathVariable("idClient") Long idClient){
			return surveillanceCommandService.displayCommandClientByState(idClient, StateCommand.DEVIS,true);
		}
				
		@GetMapping("/afficherRequestDevisAgent/{idAgent}")
		@ResponseBody
		public List<SurveillanceCommand> afficherRequestDevisAgent(@PathVariable("idAgent") Long idAgent){
			return surveillanceCommandService.displayCommandAgentByState(idAgent, StateCommand.DEVIS, false);
		}
		
		@GetMapping("/afficherReponseDevisAgent/{idAgent}")
		@ResponseBody
		public List<SurveillanceCommand> afficherResponseDevisAgent(@PathVariable("idAgent") Long idAgent){
			return surveillanceCommandService.displayCommandAgentByState(idAgent, StateCommand.DEVIS, true);
		}
		
		@GetMapping("/afficherRequestPassCommandClient/{idClient}")
		@ResponseBody
		public List<SurveillanceCommand> afficherRequestPassCommandClient(@PathVariable("idClient") Long idClient){
			return surveillanceCommandService.displayCommandClientByState(idClient, StateCommand.PASSECOMMAND, false);
		}
		
		@GetMapping("/afficherRequestPassCommandAgent/{idAgent}")
		@ResponseBody
		public List<SurveillanceCommand> afficherRequestPassCommandAgent(@PathVariable("idAgent") Long idAgent){
			return surveillanceCommandService.displayCommandAgentByState(idAgent, StateCommand.PASSECOMMAND, false);
		}
		
		@GetMapping("/afficherResponsePassCommandClient/{idClient}")
		@ResponseBody
		public List<SurveillanceCommand> afficherResponsePassCommandClient(@PathVariable("idClient") Long idClient){
			return surveillanceCommandService.displayCommandClientByState(idClient, StateCommand.PASSECOMMAND,true);
		}
		
		@GetMapping("/afficherResponsePassCommandAgent/{idAgent}")
		@ResponseBody
		public List<SurveillanceCommand> afficherResponsePassCommandAgent(@PathVariable("idAgent") Long idAgent){
			return surveillanceCommandService.displayCommandAgentByState(idAgent, StateCommand.PASSECOMMAND, true);
		}
		
		@GetMapping("/afficherAnnulerPassCommandClient/{idClient}")
		@ResponseBody
		public List<SurveillanceCommand> afficherAnnulerPassCommandClient(@PathVariable("idClient") Long idClient){
			return surveillanceCommandService.displayCommandClientByState(idClient, StateCommand.ANNULER,true);
		}
		
		@GetMapping("/afficherAnnulerPassCommandAgent/{idAgent}")
		@ResponseBody
		public List<SurveillanceCommand> afficherAnnulerPassCommandAgent(@PathVariable("idAgent") Long idAgent){
			return surveillanceCommandService.displayCommandAgentByState(idAgent, StateCommand.ANNULER, true);
		}
		
		@GetMapping("/afficherOKCommandClient/{idClient}")
		@ResponseBody
		public List<SurveillanceCommand> afficherOKCommandClient(@PathVariable("idClient") Long idClient){
			return surveillanceCommandService.displayCommandClientByState(idClient, StateCommand.OK,true);
		}
		
		@GetMapping("/afficheeOkCommandAgent/{idAgent}")
		@ResponseBody
		public List<SurveillanceCommand> afficherOkCommandAgent(@PathVariable("idAgent") Long idAgent){
			return surveillanceCommandService.displayCommandAgentByState(idAgent, StateCommand.OK, true);
		}
		
		

}
