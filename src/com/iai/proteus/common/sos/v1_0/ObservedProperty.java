package com.iai.proteus.common.sos.v1_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

/**
 * SOS Observed Property 
 * 
 * @author Jakob Henriksson
 *
 */
@XmlAccessorType(XmlAccessType.NONE)
public class ObservedProperty {

	private final String xlink = "http://www.w3.org/1999/xlink";
	
	@XmlAttribute(name="href", namespace=xlink, required=false)
	protected String attrHref;
	
	@XmlValue
	protected String value;

	public String getAttrHref() {
		return attrHref;
	}
	
	public String getValue() {
		return value;
	}
	
	/**
	 * Utility method 
	 * 
	 * @return
	 */
	public String getObservedProperty() {
		if (attrHref != null)
			return attrHref;
		return value;
	}
}
