package org.shiro.model;

public class Feed {

	private String resource;
	private MetaInfo meta;
	private Analysis analysis;

	public Analysis getAnalysis() {
		return analysis;
	}

	public void setAnalysis(Analysis analysis) {
		this.analysis = analysis;
	}

	public MetaInfo getMeta() {
		return meta;
	}

	public void setMeta(MetaInfo meta) {
		this.meta = meta;
	}

	public String getResource() {
		return resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
	}

}
