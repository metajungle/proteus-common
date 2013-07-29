package com.iai.proteus.common.ows.v1_1;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * OWS Operation 
 * 
 * @author Jakob Henriksson
 *
 */
@XmlAccessorType(XmlAccessType.NONE)
public class Operation {
	
	private final String ows = "http://www.opengis.net/ows/1.1";
	
	@XmlAttribute(name="name", required=true)
	protected String attrName;
	
	@XmlElement(name="DCP", namespace=ows, required=true)
	protected DCP dcp;
	
	@XmlElement(name="Parameter", namespace=ows, required=true)
	protected List<Parameter> parameters;
	
	/**
	 * Constructor 
	 */
	public Operation() {
		parameters = new ArrayList<Parameter>();
	}

	public String getAttrName() {
		return attrName;
	}
	
	/**
	 * Utility method 
	 * 
	 * @return
	 */
	public String getName() {
		return getAttrName();
	}

	public DCP getDcp() {
		return dcp;
	}

	public List<Parameter> getParameters() {
		return parameters;
	}
}
