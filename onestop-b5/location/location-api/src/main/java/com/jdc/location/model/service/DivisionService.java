package com.jdc.location.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.jdc.location.model.LocationBusinessException;
import com.jdc.location.model.dto.DivisionDTO;
import com.jdc.location.model.dto.form.DivisionForm;
import com.jdc.location.model.entity.Division;
import com.jdc.location.model.repo.DivisionRepo;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class DivisionService {

	private final DivisionRepo repo;

	public List<String> findAllRegions() {
		return repo.findAllRegions();
	}

	@Transactional
	public DivisionDTO create(DivisionForm form) {
		var entity = repo.save(form.entity());
		return DivisionDTO.from(entity);
	}

	public DivisionDTO findById(int id) {
		return repo.findById(id).map(DivisionDTO::from)
				.orElseThrow(() -> new LocationBusinessException("There is no division with id %d.".formatted(id)));
	}

	@Transactional
	public DivisionDTO update(int id, DivisionForm form) {
		return repo.findById(id).map(entity -> {
			entity.setName(form.name());
			entity.setBurmese(form.burmese());
			entity.setRegion(form.region());
			entity.setCapital(form.capital());
			return DivisionDTO.from(entity);
		})
		.orElseThrow(() -> new LocationBusinessException("There is no division with id %d.".formatted(id)));				
	}

	public List<DivisionDTO> search(Optional<String> region, Optional<String> keyword) {
		return repo.findAll(region(region).and(keyword(keyword)))
				.stream().map(DivisionDTO::from).toList();
	}

	private Specification<Division> region(Optional<String> param) {
		if(param.isPresent() && StringUtils.hasLength(param.get())) {
			return (root, query, cb) -> 
				cb.equal(root.get("region"), param.get());
		}
		return Specification.where(null);
	}

	private Specification<Division> keyword(Optional<String> param) {
		if(param.isPresent() && StringUtils.hasLength(param.get())) {
			return (root, query, cb) -> 
				cb.or(
					// name
					cb.like(cb.lower(root.get("name")), param.get().toLowerCase().concat("%")),
					// burmese
					cb.like(cb.lower(root.get("burmese")), param.get().toLowerCase().concat("%")),
					// capital
					cb.like(cb.lower(root.get("capital")), param.get().toLowerCase().concat("%"))
				);
		}
		return Specification.where(null);
	}
}
