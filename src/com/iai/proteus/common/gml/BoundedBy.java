package com.iai.proteus.common.gml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * GML Bounded By 
 * 
 * @author Jakob Henriksson
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class BoundedBy {
	
	private final String gml = "http://www.opengis.net/gml";
	
	@XmlElement(name="Envelope", namespace=gml, required=true)
	protected Envelope envelope;
	
	public Envelope getEnvelope() {
		return envelope;
	}
}
