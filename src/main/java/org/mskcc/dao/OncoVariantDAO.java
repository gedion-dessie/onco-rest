package org.mskcc.dao;

import org.mskcc.domain.OncoVariant;

import java.util.List;

/**
 * Created by gedionz on 4/13/17.
 */
public interface OncoVariantDAO extends GenericDAO<OncoVariant> {
	List<OncoVariant> findByEntrezGeneId(long entrezGeneId);
	List<OncoVariant> findPaginatedVariants(long entrezGeneId, int start, int size);
	OncoVariant findByAlteration(String alteration);
}
