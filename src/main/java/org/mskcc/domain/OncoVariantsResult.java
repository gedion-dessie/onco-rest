package org.mskcc.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by gedionz on 4/13/17.
 */
public class OncoVariantsResult {
	
	private OncoGene oncoGene;
	private Set<Link> links = new HashSet<>();
	private List<OncoVariant> oncoVariants = new ArrayList<>();
	
	public OncoVariantsResult() {
		
	}
	
	public OncoGene getOncoGene() {
		return oncoGene;
	}
	
	public void setOncoGene(OncoGene oncoGene) {
		this.oncoGene = oncoGene;
	}
	
	public List<OncoVariant> getOncoVariants() {
		return oncoVariants;
	}
	
	public Set<Link> getLinks() {
		return links;
	}
	
}
