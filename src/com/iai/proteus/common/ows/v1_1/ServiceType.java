package com.iai.proteus.common.ows.v1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

/**
 * OWS Service Type 
 * 
 * @author Jakob Henriksson 
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class ServiceType {
	
	@XmlAttribute
	protected String codeSpace;
	
	@XmlValue
	protected String serviceType;

	public String getCodeSpace() {
		return codeSpace;
	}

	public String getServiceType() {
		return serviceType;
	}
	
}
