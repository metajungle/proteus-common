package com.iai.proteus.common.ows.v1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * OWS Service Provider 
 * 
 * @author Jakob Henriksson
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class ServiceProvider {
	
	private final String ows = "http://www.opengis.net/ows/1.1";
	
	@XmlElement(name="ProviderName", namespace=ows, required=true)
	private String providerName;

	@XmlElement(name="ProviderSite", namespace=ows, required=true)
	private ProviderSite providerSite;
	
	@XmlElement(name="ServiceContact", namespace=ows, required=true)
	private ServiceContact serviceContact;

	public String getProviderName() {
		return providerName;
	}

	public ProviderSite getProviderSite() {
		return providerSite;
	}

	public ServiceContact getServiceContact() {
		return serviceContact;
	}
	
}
