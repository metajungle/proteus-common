package com.iai.proteus.common.gml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

/**
 * GML Time Period End Position 
 * 
 * @author Jakob Henriksson
 *
 */
@XmlAccessorType(XmlAccessType.NONE)
public class EndPosition {

	@XmlAttribute(name="indeterminatePosition", required=false)
	protected String attrIndeterminatePosition;
	
	@XmlValue
	protected String value;

	public String getAttrIndeterminatePosition() {
		return attrIndeterminatePosition;
	}
	
	public String getValue() {
		return value;
	}
	
	/**
	 * Utility method 
	 * 
	 * @return Null if there is no end position specified
	 */
	public String getEndPosition() {
		String attr = getAttrIndeterminatePosition();
		if (attr != null && attr.equalsIgnoreCase("now")) {
			return null;
		}
		// return value if there is one
		if (value != null && !value.trim().equals("")) {
			return value;
		}
		// default 
		return null;

	}	
}
