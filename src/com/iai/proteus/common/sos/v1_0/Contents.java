package com.iai.proteus.common.sos.v1_0;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Contents {
	
	private final String sos = "http://www.opengis.net/sos/1.0";

	@XmlElement(name="ObservationOfferingList", namespace=sos, required=true)
	protected ObservationOfferingList observationOfferingList;

	public ObservationOfferingList getObservationOfferingList() {
		return observationOfferingList;
	}
	
	/**
	 * Utility method to return all observation offerings 
	 * 
	 * @return
	 */
	public List<ObservationOffering> getObservationOfferings() {
		ObservationOfferingList list = getObservationOfferingList();
		if (list != null) {
			return list.getObservationOfferings();	
		}
		return new ArrayList<ObservationOffering>();
	}
}
