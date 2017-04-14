package org.mskcc.domain;

/**
 * Created by gedionz on 4/13/17.
 */
public class Consequence {
	
	private String term;
	private boolean isGenerallyTruncating;
	private String description;
	
	public Consequence() {
	}
	
	public String getTerm() {
		return term;
	}
	
	public void setTerm(String term) {
		this.term = term;
	}
	
	public boolean isGenerallyTruncating() {
		return isGenerallyTruncating;
	}
	
	public void setGenerallyTruncating(boolean generallyTruncating) {
		isGenerallyTruncating = generallyTruncating;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
}
