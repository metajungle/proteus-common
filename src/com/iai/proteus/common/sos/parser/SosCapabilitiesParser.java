/*
 * Copyright (C) 2013 Intelligent Automation Inc. 
 * 
 * All Rights Reserved.
 */
package com.iai.proteus.common.sos.parser;

import static org.junit.Assert.fail;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.stream.StreamSource;

import com.iai.proteus.common.sos.v1_0.Capabilities;

/**
 * Parser utility methods for SOS Capabilities documents 
 * 
 * @author jhenriksson
 *
 */
public class SosCapabilitiesParser {
	
	/**
	 * Parses SOS Capabilities document from the given location  
	 * 
	 * @param location
	 * @return
	 */
	public Capabilities parseCapabilities(String location) {
		
		try {
			
			XMLInputFactory xif = XMLInputFactory.newFactory();
	        StreamSource xml = new StreamSource(location);
	        XMLStreamReader xsr = xif.createXMLStreamReader(xml);
	        xsr.nextTag();
			
	        JAXBContext jc = JAXBContext.newInstance(Capabilities.class);
	        Unmarshaller unmarshaller = jc.createUnmarshaller();
	        JAXBElement<Capabilities> jb = unmarshaller.unmarshal(xsr, Capabilities.class);
	        
	        return jb.getValue();
	        
		} catch (JAXBException e) {
			System.err.println("Exception: " + e.getMessage());
			fail("JAXBException thrown");
		} catch (XMLStreamException e) {
			System.err.println("Exception: " + e.getMessage());
			fail("XMLStreamException thrown");
		}
		
		return null;
	}
	

}
