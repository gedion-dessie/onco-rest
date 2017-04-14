package org.mskcc.dao;

import org.mskcc.domain.OncoGene;

import java.util.List;

/**
 * Created by gedionz on 4/13/17.
 */
public interface OncoGeneDAO extends GenericDAO<OncoGene> {
	List<OncoGene> findAllPaginated(int start, int size);
}
