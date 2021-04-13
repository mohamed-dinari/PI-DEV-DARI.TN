package com.spring.service;

import org.springframework.stereotype.Service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.spring.service.IReclamationService;

import com.spring.service.ReclamationService;

import com.spring.entity.Reclamation;

import com.spring.repository.ReclamationRepository;

@Service
public class ReclamationService implements IReclamationService { 
	
	@Autowired
	ReclamationRepository reclamationRepository;

	private static final Logger L =LogManager.getLogger(ReclamationService.class);
	@Override
	public Reclamation addReclamation(Reclamation reclamation){
		return reclamationRepository.save(reclamation);
	}
		@Override
		public Reclamation updateReclamation(Reclamation reclamation){
			return reclamationRepository.save(reclamation);
		}
		@Override
		public Reclamation retrieveReclamation(Long id){
			return reclamationRepository.findById(id).get();
		}
	@Override
	public List<Reclamation> retrieveAllReclamation() {
			List<Reclamation> reclamations =(List<Reclamation>) reclamationRepository.findAll();
			
			for (Reclamation reclamation : reclamations) {
				L.info("reclamation +++: "+ reclamation);
				
			}
		return reclamations;
	
	}
	@Override
	public void deleteReclamation(Long id) {
		reclamationRepository.deleteById(id);
		
	}
	@Override
	public List<Reclamation> retrieveAllReclamations() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
