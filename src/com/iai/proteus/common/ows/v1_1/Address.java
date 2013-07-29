package com.iai.proteus.common.ows.v1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * An OWS address 
 * 
 * @author Jakob Henriksson
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Address {
	
	private final String ows = "http://www.opengis.net/ows/1.1";
	
	@XmlElement(name="DeliveryPoint", namespace=ows, required=true)
	private String deliveryPoint;
	
	@XmlElement(name="City", namespace=ows, required=true)
	private String city;
	
	@XmlElement(name="AdministrativeArea", namespace=ows, required=true)
	private String administrativeArea;
	
	@XmlElement(name="PostalCode", namespace=ows, required=true)
	private String postalCode;
	
	@XmlElement(name="Country", namespace=ows, required=true)
	private String country;
	
	@XmlElement(name="ElectronicMailAddress", namespace=ows, required=true)
	private String electronicMailAddress;

	public String getDeliveryPoint() {
		return deliveryPoint;
	}

	public String getCity() {
		return city;
	}

	public String getAdministrativeArea() {
		return administrativeArea;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public String getCountry() {
		return country;
	}

	public String getElectronicMailAddress() {
		return electronicMailAddress;
	}
	
	/**
	 * Utility method for retrieving the 'electronic' mail address
	 * 
	 * @return
	 */
	public String getEmail() {
		return getElectronicMailAddress();
	}
}
