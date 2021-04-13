package com.spring.service;

import java.util.List;

import com.spring.entity.Reclamation;

public interface IReclamationService {
	List<Reclamation> retrieveAllReclamations();
	Reclamation addReclamation(Reclamation reclamation);
	Reclamation updateReclamation(Reclamation reclamation);
	void deleteReclamation(Long id);
	Reclamation retrieveReclamation(Long id);
	List<Reclamation> retrieveAllReclamation();
}
