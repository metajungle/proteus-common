package com.iai.proteus.common.sos.v1_0;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class ObservationOfferingList {
	
	private final String sos = "http://www.opengis.net/sos/1.0";

	@XmlElement(name="ObservationOffering", namespace=sos)
	protected List<ObservationOffering> observationOfferings; 
	
	public ObservationOfferingList() {
		observationOfferings = new ArrayList<>();
	}
	
	public List<ObservationOffering> getObservationOfferings() {
		return observationOfferings;
	}
	
}
