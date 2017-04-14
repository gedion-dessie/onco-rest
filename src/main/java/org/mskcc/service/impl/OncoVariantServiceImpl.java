package org.mskcc.service.impl;

import org.mskcc.dao.OncoVariantDAO;
import org.mskcc.domain.OncoVariant;
import org.mskcc.service.OncoVariantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by gedionz on 4/13/17.
 */
@Service
@Transactional
public class OncoVariantServiceImpl implements OncoVariantService {
	
	
	@Autowired
	private OncoVariantDAO oncoVariantDAO;
	

	
	@Override
	public List<OncoVariant> getVariants(long entrezGeneId) {
		return oncoVariantDAO.findByEntrezGeneId(entrezGeneId);
	}
	
	@Override
	public List<OncoVariant> getVariantsPaginated(long entrezGeneId, int start, int size) {
		return oncoVariantDAO.findPaginatedVariants(entrezGeneId, start, size);
	}
	
	@Override
	public OncoVariant getByAlteration(String alteration) {
		return oncoVariantDAO.findByAlteration(alteration);
	}
	
	@Override
	public void save(OncoVariant oncoVariant) {
		oncoVariantDAO.save(oncoVariant);
	}
}
