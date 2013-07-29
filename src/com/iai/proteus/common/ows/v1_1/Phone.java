package com.iai.proteus.common.ows.v1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * An OWS phone 
 * 
 * @author Jakob Henriksson
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Phone {

	private final String ows = "http://www.opengis.net/ows/1.1";
	
	@XmlElement(name="Voice", namespace=ows, required=true)
	private String voice;

	public String getVoice() {
		return voice;
	}
}
