package com.iai.proteus.common.ows.v1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * OWS contact info 
 * 
 * @author Jakob Henriksson
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class ContactInfo {
	
	private final String ows = "http://www.opengis.net/ows/1.1";
	
	@XmlElement(name="Phone", namespace=ows, required=true)
	private Phone phone;
	
	@XmlElement(name="Address", namespace=ows, required=true)
	private Address address;

	public Phone getPhone() {
		return phone;
	}

	public Address getAddress() {
		return address;
	}
}
