package com.iai.proteus.common.ows.v1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * OWS DCP 
 * 
 * @author Jakob Henriksson
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class DCP {
	
	private final String ows = "http://www.opengis.net/ows/1.1";
	
	@XmlElement(name="HTTP", namespace=ows, required=true)
	protected HTTP http;
	
	public HTTP getHttp() {
		return http;
	}
}
