package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.entity.Reclamation;
import com.spring.service.IReclamationService;

@RestController
public class ReclamationController {
	@Autowired
	IReclamationService reclamationService;
 
	@GetMapping("/retrieve-all-reclamations")
	@ResponseBody
	public List<Reclamation> getReclamations(){
		
		List<Reclamation> list = reclamationService.retrieveAllReclamations();
		return list;}
		

		
		@PostMapping("/add-reclamation")
		@ResponseBody
		public Reclamation addReclamation(@RequestBody Reclamation reclamation) {
		return reclamationService.addReclamation(reclamation);

		}

		// http://localhost:8081/SpringMVC/servlet/remove-reclamation/{reclamation-id}
		@DeleteMapping("/remove-reclamation/{reclamation-id}")
		@ResponseBody
		public void removeReclamation(@PathVariable("reclamation-id") Long reclamationId) {
			reclamationService.deleteReclamation(reclamationId);  
		}
		
		// http://localhost:8081/SpringMVC/servlet/modify-reclamation
		@PutMapping("/modify-reclamation")
		@ResponseBody
		public Reclamation modifyReclamation(@RequestBody Reclamation reclamation) {
		return reclamationService.updateReclamation(reclamation);
		}



}
