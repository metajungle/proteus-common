package com.iai.proteus.common.ows.v1_1;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * OWS Allowed Values 
 * 
 * @author Jakob Henriksson
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class AllowedValues {
	
	private final String ows = "http://www.opengis.net/ows/1.1";
	
	@XmlElement(name="Value", namespace=ows, required=true)
	protected List<String> values;
	
	/**
	 * Constructor 
	 */
	public AllowedValues() {
		values = new ArrayList<>();
	}
	
	public List<String> getValues() {
		return values;
	}

}
