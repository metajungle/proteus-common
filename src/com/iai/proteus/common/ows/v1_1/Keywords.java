package com.iai.proteus.common.ows.v1_1;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * OWS Keywords 
 * 
 * @author Jakob Henriksson
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Keywords {

	@XmlElement(name="Keyword", namespace="http://www.opengis.net/ows/1.1")
	private List<String> keywords;
	
	/**
	 * Constructor 
	 * 
	 */
	public Keywords() {
		keywords = new ArrayList<>();
	}

	public List<String> getKeywords() {
		return keywords;
	}
}
