package com.projectx.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.projectx.application.converter.LookForHelpConverter;
import com.projectx.application.dto.LookForHelpDTO;
import com.projectx.application.model.LookForHelp;
import com.projectx.application.repository.LookForHelpRepository;

@Service
public class LookForHelpService {

	private final LookForHelpRepository repository;
	private LookForHelpConverter converter;
	
	LookForHelpService(LookForHelpRepository repository, LookForHelpConverter converter) {
		this.repository = repository;
		this.converter = converter;
	}
	
	//returns list of all users
	public List<LookForHelpDTO> all(){
		List<LookForHelp> entities = repository.findAll();
		return converter.entityToDTO(entities);
	}
	
	//adds a single user
	public LookForHelpDTO newLookForHelp(LookForHelpDTO dto) {
		LookForHelp user = converter.dtoToEntity(dto);
		user = repository.save(user);
		return converter.entityToDTO(user);
	}
	
	//gets a user by ID
	public LookForHelpDTO single(Long id) {
		LookForHelp user = repository.findById(id).orElse(null);
		return converter.entityToDTO(user);
	}
	
	//replace user
	public LookForHelpDTO replaceLookForHelp(LookForHelpDTO dto, Long id) {
		LookForHelp newuser = converter.dtoToEntity(dto);
		return repository.findById(id)
				.map(user -> {
					user.setId(newuser.getId());
					user.setProductid(newuser.getProductid());
					user.setUserid(newuser.getUserid());
					return converter.entityToDTO(repository.save(user));
				})
				.orElseGet(() -> {
					newuser.setId(id);
					return converter.entityToDTO(repository.save(newuser));
				});
	}
	
	//delete user
	public void deleteLookForHelp(Long id) {
		repository.deleteById(id);
	}
	
	
	
	
	
	
}
