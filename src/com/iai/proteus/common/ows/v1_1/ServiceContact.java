package com.iai.proteus.common.ows.v1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * OWS Service Contact 
 * 
 * @author Jakob Henriksson
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class ServiceContact {
	
	private final String ows = "http://www.opengis.net/ows/1.1";
	
	@XmlElement(name="IndividualName", namespace=ows, required=true)
	private String individualName;
	
	@XmlElement(name="PositionName", namespace=ows, required=false)
	private String positionName;
	
	@XmlElement(name="ContactInfo", namespace=ows, required=true)
	private ContactInfo contactInfo;

	public String getIndividualName() {
		return individualName;
	}
	
	public String getPositionName() {
		return positionName;
	}

	public ContactInfo getContactInfo() {
		return contactInfo;
	}
	
}
