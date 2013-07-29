package com.iai.proteus.common.sos.v1_0;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.iai.proteus.common.ows.v1_1.ServiceIdentification;
import com.iai.proteus.common.ows.v1_1.ServiceProvider;

@XmlRootElement(name="Capabilities", namespace="http://www.opengis.net/sos/1.0")
public class Capabilities {
	
	private final String ows = "http://www.opengis.net/ows/1.1";
	private final String sos = "http://www.opengis.net/sos/1.0";

	@XmlElement(name="ServiceIdentification", namespace=ows, required=true)
	private ServiceIdentification serviceIdentification;

	@XmlElement(name="ServiceProvider", namespace=ows, required=true)
	private ServiceProvider serviceProvider;

//	@XmlElement(name="OperationsMetadata", namespace=ows, required=true)
//	private OperationsMetadata operationsMetadata;
	
	@XmlElement(name="Contents", namespace=sos, required=true)
	private Contents contents;
	
	
	public ServiceIdentification getServiceIdentification() {
		return serviceIdentification;
	}

	public ServiceProvider getServiceProvider() {
		return serviceProvider;
	}
	
//	public OperationsMetadata getOperationsMetadata() {
//		return operationsMetadata;
//	}
	
	public Contents getContents() {
		return contents; 
	}
	
	/**
	 * Utility method to return all observation offerings 
	 * 
	 * @return
	 */
	public List<ObservationOffering> getObservationOfferings() {
		Contents contents = getContents();
		if (contents != null) {
			return contents.getObservationOfferings();	
		}
		return new ArrayList<ObservationOffering>();
	}	
	
}
