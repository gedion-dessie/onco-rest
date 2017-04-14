package org.mskcc.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by gedionz on 4/13/17.
 */
@Entity(name = "oncoGene")
@Table(name = "onco_gene")
public class OncoGene implements Serializable {

	@Id
	private long entrezGeneId;
	private String hugoSymbol;
	
	@ElementCollection(fetch = FetchType.EAGER)
	private Set<String> geneAliases = new HashSet<>();
	
	@Transient
	private Set<Link> links = new HashSet<>();
	
	public OncoGene() {
	}
	
	public long getEntrezGeneId() {
		return entrezGeneId;
	}
	
	public void setEntrezGeneId(long entrezGeneId) {
		this.entrezGeneId = entrezGeneId;
	}
	
	public String getHugoSymbol() {
		return hugoSymbol;
	}
	
	public void setHugoSymbol(String hugoSymbol) {
		this.hugoSymbol = hugoSymbol;
	}
	
	
	public Set<String> getGeneAliases() {
		return geneAliases;
	}
	
	public Set<Link> getLinks() {
		return links;
	}
	
	
	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;
		
		OncoGene oncoGene = (OncoGene) o;
		
		return entrezGeneId == oncoGene.entrezGeneId;
	}
	
	@Override
	public int hashCode() {
		return (int) (entrezGeneId ^ (entrezGeneId >>> 32));
	}
	
	
}
