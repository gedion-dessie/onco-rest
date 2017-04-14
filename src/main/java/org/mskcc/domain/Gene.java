package org.mskcc.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by gedionz on 4/13/17.
 */
public class Gene {
	private long entrezGeneId;
	
	private String hugoSymbol;
	private String name;
	private String curatedIsoform;
	private String curatedRefSeq;
	private Set<String> geneAliases = new HashSet<>();
	private boolean oncogene;
	private boolean tsg;
	
	public Gene() {
		
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
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCuratedIsoform() {
		return curatedIsoform;
	}
	
	public void setCuratedIsoform(String curatedIsoform) {
		this.curatedIsoform = curatedIsoform;
	}
	
	public String getCuratedRefSeq() {
		return curatedRefSeq;
	}
	
	public void setCuratedRefSeq(String curatedRefSeq) {
		this.curatedRefSeq = curatedRefSeq;
	}
	
	public Set<String> getGeneAliases() {
		return geneAliases;
	}
	
	public void addGeneAlias(String geneAlias) {
		geneAliases.add(geneAlias);
	}
	
	public boolean isOncogene() {
		return oncogene;
	}
	
	public void setOncogene(boolean oncogene) {
		this.oncogene = oncogene;
	}
	
	public boolean isTsg() {
		return tsg;
	}
	
	public void setTsg(boolean tsg) {
		this.tsg = tsg;
	}
	
	
}
