package com.iai.proteus.common.ows.v1_1;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * OWS Parameter 
 * 
 * @author Jakob Henriksson
 *
 */
@XmlAccessorType(XmlAccessType.NONE)
public class Parameter {
	
	private final String ows = "http://www.opengis.net/ows/1.1";
	
	@XmlAttribute(name="name", required=true)
	protected String attrName;
	
	@XmlElement(name="AllowedValues", namespace=ows, required=true)
	protected AllowedValues allowedValues;
	
	public String getAttrName() {
		return attrName;
	}
	
	/**
	 * Utility method 
	 * 
	 * @return
	 */
	public String getName() {
		return getAttrName();
	}
	
	public AllowedValues getAllowedValues() {
		return allowedValues;
	}

	/**
	 * Utility method
	 * 
	 */
	public List<String> getAllowedValuesList() {
		if (allowedValues != null) {
			return allowedValues.getValues();
		}
		// default
		return new ArrayList<String>();
	}
}
