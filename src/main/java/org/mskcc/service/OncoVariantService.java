package org.mskcc.service;

import org.mskcc.domain.OncoVariant;

import java.util.List;

/**
 * Created by gedionz on 4/13/17.
 */
public interface OncoVariantService {
	List<OncoVariant> getVariants(long geneId);
	List<OncoVariant> getVariantsPaginated(long entrezGeneId, int start, int size);
	OncoVariant getByAlteration(String alteration);
	void save(OncoVariant oncoVariant);
	
}
