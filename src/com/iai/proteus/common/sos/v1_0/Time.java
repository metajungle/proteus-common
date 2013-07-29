package com.iai.proteus.common.sos.v1_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import com.iai.proteus.common.gml.TimePeriod;

/**
 * SOS Time 
 * 
 * @author Jakob Henriksson
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Time {
	
	private final String gml = "http://www.opengis.net/gml";
	
	@XmlElement(name="TimePeriod", namespace=gml, required=true)
	protected TimePeriod timePeriod;
	
	public TimePeriod getTimePeriod() {
		return timePeriod;
	}
}
