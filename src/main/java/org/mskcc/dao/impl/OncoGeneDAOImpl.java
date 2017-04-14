package org.mskcc.dao.impl;

import org.mskcc.dao.OncoGeneDAO;
import org.mskcc.domain.OncoGene;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by gedionz on 4/13/17.
 */
@Repository
public class OncoGeneDAOImpl extends GenericDAOImpl<OncoGene> implements OncoGeneDAO {
	public OncoGeneDAOImpl() {
		super.setDaoType(OncoGene.class);
	}
	
	@Override
	public List<OncoGene> findAllPaginated(int start, int size) {
		Query query = entityManager.createQuery(" from oncoGene");
		return query.setFirstResult(start).setMaxResults(size).getResultList();
	}
}
