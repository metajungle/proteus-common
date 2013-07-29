package com.iai.proteus.common.gml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * GML Time Period 
 * 
 * @author Jakob Henriksson
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class TimePeriod {

	private final String gml = "http://www.opengis.net/gml";

	@XmlElement(name="beginPosition", namespace=gml, required=true)
	protected String beginPosition;
	
	@XmlElement(name="endPosition", namespace=gml, required=true)	
	protected String endPosition;

	public String getBeginPosition() {
		return beginPosition;
	}

	public String getEndPosition() {
		return endPosition;
	}
}
