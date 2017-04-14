package org.mskcc.domain;

/**
 * Created by gedionz on 4/13/17.
 */
public class Variant {
	
	private Gene gene;
	private Consequence consequence;
	private String alteration;
	private String name;
	private String refResidues;
	private int proteinStart;
	private int proteinEnd;
	private String variantResidues;
	
	public Variant() {
	}
	
	public Gene getGene() {
		return gene;
	}
	
	public void setGene(Gene gene) {
		this.gene = gene;
	}
	
	public Consequence getConsequence() {
		return consequence;
	}
	
	public void setConsequence(Consequence consequence) {
		this.consequence = consequence;
	}
	
	public String getAlteration() {
		return alteration;
	}
	
	public void setAlteration(String alteration) {
		this.alteration = alteration;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getRefResidues() {
		return refResidues;
	}
	
	public void setRefResidues(String refResidues) {
		this.refResidues = refResidues;
	}
	
	public int getProteinStart() {
		return proteinStart;
	}
	
	public void setProteinStart(int proteinStart) {
		this.proteinStart = proteinStart;
	}
	
	public int getProteinEnd() {
		return proteinEnd;
	}
	
	public void setProteinEnd(int proteinEnd) {
		this.proteinEnd = proteinEnd;
	}
	
	public String getVariantResidues() {
		return variantResidues;
	}
	
	public void setVariantResidues(String variantResidues) {
		this.variantResidues = variantResidues;
	}
}
