package com.iai.proteus.common.sos.v1_0;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import com.iai.proteus.common.gml.BoundedBy;

/**
 * SOS Observation Offering
 * 
 * @author Jakob Henriksson
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class ObservationOffering {

	private final String gml = "http://www.opengis.net/gml";
	private final String sos = "http://www.opengis.net/sos/1.0";

	@XmlAttribute(name="id", namespace=gml, required=true)
	protected String id;
	
	@XmlElement(name="description", namespace=gml, required=true)
	protected String description;

	@XmlElement(name="name", namespace=gml, required=true)
	protected String name;
	
	@XmlElement(name="srsName", namespace=gml, required=true)
	protected String srsName;
	
	@XmlElement(name="boundedBy", namespace=gml, required=false)
	protected BoundedBy boundedBy;

	@XmlElement(name="time", namespace=sos, required=true)
	protected Time time;
	
	@XmlElement(name="procedure", namespace=sos, required=true)
	protected List<Procedure> procedures;
	
	@XmlElement(name="observedProperty", namespace=sos, required=true)
	protected List<ObservedProperty> observedProperties;

	@XmlElement(name="featureOfInterest", namespace=sos, required=true)
	protected List<FeatureOfInterest> featuresOfInterest;

	@XmlElement(name="responseFormat", namespace=sos, required=true)
	protected List<String> responseFormats;
	
	@XmlElement(name="resultModel", namespace=sos, required=true)	
	protected String resultModel;
	
	// TODO: is this a valid element in the standard? See PacIOOS
	@XmlElement(name="responseModel", namespace=sos, required=true)	
	protected String responseModel;

	@XmlElement(name="responseMode", namespace=sos, required=true)	
	protected String responseMode;

	/**
	 * Constructor
	 */
	public ObservationOffering() {
		procedures = new ArrayList<>();
		observedProperties = new ArrayList<>();
		featuresOfInterest = new ArrayList<>();
		responseFormats = new ArrayList<>();
	}
	
	public String getId() {
		return id;
	}
			
	public String getDescription() {
		return description;
	}

	public String getName() {
		return name;
	}

	public String getSrsName() {
		return srsName;
	}
	
	public BoundedBy getBoundedBy() {
		return boundedBy;
	}
	
	public Time getTime() {
		return time;
	}

	public List<Procedure> getProcedures() {
		return procedures;
	}

	public List<ObservedProperty> getObservedProperties() {
		return observedProperties;
	}

	public List<FeatureOfInterest> getFeaturesOfInterest() {
		return featuresOfInterest;
	}
	
	public List<String> getResponseFormats() {
		return responseFormats;
	}

	public String getResultModel() {
		if (resultModel != null) {
			return resultModel;
		}
		// fall back 
		return getResponseModel();
	}

	/**
	 * TODO: is it called 'sos:responseModel' or 'sos:resultModel' ? 
	 * 
	 * @return
	 */
	public String getResponseModel() {
		return responseModel;
	}
	
	public String getResponseMode() {
		return responseMode;
	}
	
}
