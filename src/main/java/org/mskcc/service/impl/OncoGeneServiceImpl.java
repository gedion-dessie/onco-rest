package org.mskcc.service.impl;

import org.mskcc.dao.OncoGeneDAO;
import org.mskcc.domain.OncoGene;
import org.mskcc.exception.DataNotFoundException;
import org.mskcc.service.OncoGeneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by gedionz on 4/13/17.
 */
@Service
@Transactional
public class OncoGeneServiceImpl implements OncoGeneService {
	
	
	@Autowired
	private OncoGeneDAO oncoGeneDAO;
	
	
	@Override
	public List<OncoGene> getAll() {
		return oncoGeneDAO.findAll();
	}
	
	@Override
	public List<OncoGene> getAllPaginated(int start, int size) {
		return oncoGeneDAO.findAllPaginated(start, size);
	}
	
	
	@Override
	public OncoGene get(long id) {
		OncoGene oncoGene = oncoGeneDAO.find(id);
		if(oncoGene == null) {
			throw new DataNotFoundException("Gene with id " + id + " is not found!");
		}
		return oncoGene;
	}
	
	@Override
	public void save(OncoGene oncoGene) {
		oncoGeneDAO.save(oncoGene);
	}
	
	@Override
	public void remove(long id) {
		oncoGeneDAO.delete(id);
	}
	
	@Override
	public void remove(OncoGene oncoGene) {
		oncoGeneDAO.delete(oncoGene);
	}
	
	@Override
	public OncoGene update(OncoGene oncoGene) {
		return oncoGeneDAO.update(oncoGene);
	}
	
	
	
}
