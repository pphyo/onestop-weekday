package com.jdc.location.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.location.model.LocationBusinessException;
import com.jdc.location.model.dto.DivisionDTO;
import com.jdc.location.model.dto.TownshipDTO;
import com.jdc.location.model.dto.form.TownshipForm;
import com.jdc.location.model.entity.Township;
import com.jdc.location.model.repo.DivisionRepo;
import com.jdc.location.model.repo.TownshipRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TownshipService {
	
	private final TownshipRepo repo;
	private final DivisionRepo divRepo;

	public TownshipDTO findById(int id) {
		return TownshipDTO.from(
				repo.findById(id).orElseThrow(() -> {
					throw new LocationBusinessException("No township found with ID %d.".formatted(id));
				})
				);
	}

	@Transactional
	public TownshipDTO create(TownshipForm form) {
		return TownshipDTO.from(
				repo.save(form.entity(id -> divRepo.findById(id)))
				);
	}

	@Transactional
	public TownshipDTO update(int id, TownshipForm form) {
		return TownshipDTO.from(
				repo.findById(id).map(t -> {
					t.setName(form.name());
					t.setBurmese(form.burmese());
					t.setDivision(divRepo.findById(form.divisionId()).get());
					return t;
				}).get()
				);
	}

	public List<TownshipDTO> search(Optional<String> region, Optional<Integer> division, Optional<String> keyword) {
		Specification<Township> regSpec = 
			region.isEmpty() ? Specification.where(null) : 
				(root, query, cb) -> 
					cb.equal(root.get("region"), region.get());
			
		Specification<Township> divSpec = 
			division.isEmpty() ? Specification.where(null) : 
				(root, query, cb) -> 
					cb.equal(root.get("division"), division.get());
					
		Specification<Township> kwSpec = 
			keyword.isEmpty() ? Specification.where(null) : 
				(root, query, cb) ->
					cb.or(
						cb.like(cb.lower(root.get("name")), keyword.get().toLowerCase().concat("%")),
						cb.like(root.get("burmese"), keyword.get().concat("%"))
						);
					
		return repo.findAll(regSpec.and(divSpec).and(kwSpec))
				.stream().map(t -> 
						new TownshipDTO(
								t.getId(), 
								t.getName(), 
								t.getBurmese(), 
								DivisionDTO.from(t.getDivision()))).toList();

	}

}






