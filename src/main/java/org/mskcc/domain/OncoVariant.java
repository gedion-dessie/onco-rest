package org.mskcc.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Created by gedionz on 4/13/17.
 */
@Entity(name = "oncoVariant")
@Table(name = "variant")
@NamedQueries({
		@NamedQuery(
				name = "findByEntrezGeneId",
				query = "SELECT v FROM oncoVariant v WHERE v.oncoGene.entrezGeneId = :entrezGeneId"
		),
		@NamedQuery(
				name = "findByAlteration",
				query = "SELECT v FROM oncoVariant v WHERE v.alteration = :alteration"
		)
})

public class OncoVariant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	private long id;
	
	@Column(unique = true)
	private String alteration;
	
	private String consequence;
	private boolean isGenerallyTruncating;
	
	@ManyToOne
	@JoinColumn(name = "oncogene_id")
	@JsonIgnore
	private OncoGene oncoGene;
	
	public OncoVariant() {
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getAlteration() {
		return alteration;
	}
	
	public void setAlteration(String alteration) {
		this.alteration = alteration;
	}
	
	public String getConsequence() {
		return consequence;
	}
	
	public void setConsequence(String consequence) {
		this.consequence = consequence;
	}
	
	public boolean isGenerallyTruncating() {
		return isGenerallyTruncating;
	}
	
	public void setGenerallyTruncating(boolean generallyTruncating) {
		isGenerallyTruncating = generallyTruncating;
	}
	
	public OncoGene getOncoGene() {
		return oncoGene;
	}
	
	public void setOncoGene(OncoGene oncoGene) {
		this.oncoGene = oncoGene;
	}
}
