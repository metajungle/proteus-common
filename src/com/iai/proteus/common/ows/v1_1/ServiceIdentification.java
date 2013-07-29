package com.iai.proteus.common.ows.v1_1;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;


/**
 * OWS Service Identification 
 * 
 * @author Jakob Henriksson
 *
 */
public class ServiceIdentification {
	
	private final String ows = "http://www.opengis.net/ows/1.1";
	
	
	@XmlElement(name="Title", namespace=ows, required=true)
	protected String title;
	
	@XmlElement(name="Abstract", namespace=ows, required=true)
	protected String _abstract;

	@XmlElement(name="Keywords", namespace=ows, required=true)
	protected Keywords _keywords;

	@XmlElement(name="ServiceType", namespace=ows, required=true)
	protected ServiceType serviceType;

	@XmlElement(name="ServiceTypeVersion", namespace=ows, required=true)
	protected String serviceTypeVersion;

	@XmlElement(name="Fees", namespace=ows, required=true)
	protected String fees;

	@XmlElement(name="AccessConstraints", namespace=ows, required=true)
	protected String accessConstraints;

	public String getTitle() {
		return title;
	}
	
	public String getAbstract() {
		return _abstract;
	}

	public Keywords _getKeywords() {
		return _keywords;
	}
	
	public List<String> getKeywords() {
		return _getKeywords().getKeywords();
	}

	public ServiceType getServiceType() {
		return serviceType;
	}

	public String getServiceTypeVersion() {
		return serviceTypeVersion;
	}

	public String getFees() {
		return fees;
	}

	public String getAccessConstraints() {
		return accessConstraints;
	}
}
