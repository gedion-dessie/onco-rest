package org.mskcc.dao.impl;

import org.mskcc.dao.OncoVariantDAO;
import org.mskcc.domain.OncoVariant;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by gedionz on 4/13/17.
 */
@Repository
public class OncoVariantDAOImpl extends GenericDAOImpl<OncoVariant>  implements OncoVariantDAO{
	
	public OncoVariantDAOImpl() {
		super.setDaoType(OncoVariant.class);
	}
	
	@Override
	public List<OncoVariant> findByEntrezGeneId(long entrezGeneId) {
		return entityManager.createNamedQuery("findByEntrezGeneId", OncoVariant.class)
				.setParameter("entrezGeneId", entrezGeneId)
				.getResultList();
	}
	
	@Override
	public List<OncoVariant> findPaginatedVariants(long entrezGeneId, int start, int size) {
		Query query = entityManager.createQuery(" from oncoVariant");
		return query.setFirstResult(start).setMaxResults(size).getResultList();
	}
	
	@Override
	public OncoVariant findByAlteration(String alteration) {
		List<OncoVariant> oncoVariants = entityManager.createNamedQuery("findByAlteration")
				.setParameter("alteration", alteration).getResultList();
		OncoVariant oncoVariant = null;
		if(oncoVariants.size() > 0) {
			oncoVariant = oncoVariants.get(0);
		}
		return oncoVariant;
	}
}
