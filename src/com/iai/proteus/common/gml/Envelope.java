package com.iai.proteus.common.gml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * GML Envelope 
 * 
 * @author Jakob Henriksson
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Envelope {

	private final String gml = "http://www.opengis.net/gml";

	@XmlAttribute(name="srsName", required=true)
	protected String srsName;
	
	@XmlElement(name="lowerCorner", namespace=gml, required=true)
	protected String lowerCorner;
	
	@XmlElement(name="upperCorner", namespace=gml, required=true)	
	protected String upperCorner;

	public String getSrsName() {
		return srsName;
	}

	public String getLowerCorner() {
		return lowerCorner;
	}

	public String getUpperCorner() {
		return upperCorner;
	}
}
