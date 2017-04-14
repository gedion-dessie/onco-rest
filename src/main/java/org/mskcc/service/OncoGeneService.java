package org.mskcc.service;

import org.mskcc.domain.OncoGene;

import java.util.List;

/**
 * Created by gedionz on 4/13/17.
 */
public interface OncoGeneService {
	List<OncoGene> getAll();
	List<OncoGene> getAllPaginated(int start, int size);
	OncoGene get(long id);
	void save(OncoGene oncoGene);
	void remove(long id);
	void remove(OncoGene oncoGene);
	OncoGene update(OncoGene oncoGene);
}
