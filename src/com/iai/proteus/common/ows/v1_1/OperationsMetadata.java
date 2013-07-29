package com.iai.proteus.common.ows.v1_1;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * OWS Operations Metadata 
 * 
 * @author Jakob Henriksson 
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class OperationsMetadata {
	
	private final String ows = "http://www.opengis.net/ows/1.1";
	
	@XmlElement(name="Operation", namespace=ows, required=true)
	protected List<Operation> operations;
	
	/**
	 * Constructor
	 */
	public OperationsMetadata() {
		operations = new ArrayList<>();
	}
	
	public List<Operation> getOperations() {
		return operations;
	}
}
