package org.mskcc.domain;

/**
 * Created by gedionz on 4/13/17.
 */
public class Link {
	private String href;
	private String rel;
	
	public Link() {
	}
	
	public Link(String rel, String href) {
		this.href = href;
		this.rel = rel;
	}
	
	public String getHref() {
		return href;
	}
	
	public void setHref(String href) {
		this.href = href;
	}
	
	public String getRel() {
		return rel;
	}
	
	public void setRel(String rel) {
		this.rel = rel;
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;
		
		Link link = (Link) o;
		
		return href != null ? href.equals(link.href) : link.href == null;
	}
	
	@Override
	public int hashCode() {
		return href != null ? href.hashCode() : 0;
	}
}
