package com.iai.proteus.common;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.stream.StreamSource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.iai.proteus.common.ows.v1_1.Address;
import com.iai.proteus.common.ows.v1_1.ServiceContact;
import com.iai.proteus.common.ows.v1_1.ServiceIdentification;
import com.iai.proteus.common.ows.v1_1.ServiceProvider;
import com.iai.proteus.common.sos.v1_0.Capabilities;
import com.iai.proteus.common.sos.v1_0.ObservationOffering;


public class SosParsingCapabilitiesTest {
	
	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}
	
	/**
	 * Parses SOS Capabilities document from the given location  
	 * 
	 * @param location
	 * @return
	 */
	private Capabilities parseCapabilities(String location) {
		
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
			System.err.println("E: " + e.getMessage());
			fail("JAXBException thrown");
		} catch (XMLStreamException e) {
			System.err.println("E: " + e.getMessage());
			fail("XMLStreamException thrown");
		}
		
		return null;
	}

	/**
	 * Parsing the NDBC SOS capabilities document 
	 * 
	 */
	@Test
	public void testNdbcSosCapabilities() {
		
		Capabilities capabilities = 
				parseCapabilities("resources/sos-capabilities/sos-ndbc-capabilities.xml");
		
		assertThat(capabilities, is(not(nullValue())));

		/*
		 * Service Identification
		 */
		
        ServiceIdentification si = capabilities.getServiceIdentification();
        assertThat(si, is(not(nullValue())));
        
        assertThat(si.getTitle(), is("National Data Buoy Center SOS"));
        assertThat(si.getAbstract(), is("National Data Buoy Center SOS"));
        
        assertThat(si.getKeywords(), hasSize(16));
        assertThat(si.getKeywords().get(3), is("Moored Buoy"));
        assertThat(si.getKeywords().get(15), is("Winds"));
        
        assertThat(si.getServiceType().getServiceType(), is("OGC:SOS"));
        assertThat(si.getServiceType().getCodeSpace(), is("http://opengeospatial.net"));
        assertThat(si.getServiceTypeVersion(), is("1.0.0"));
        assertThat(si.getFees(), is("NONE"));
        assertThat(si.getAccessConstraints(), is("NONE"));
        
		/*
		 * Service Provider
		 */
        
        ServiceProvider sp = capabilities.getServiceProvider();
        assertThat(sp, is(not(nullValue())));
        assertThat(sp.getProviderName(), is("National Data Buoy Center"));
        assertThat(sp.getProviderSite().getProviderSite(), is("http://sdf.ndbc.noaa.gov/"));
        
        ServiceContact sc = sp.getServiceContact();
        assertThat(sc, is(not(nullValue())));
        assertThat(sc.getIndividualName(), is("Webmaster"));
        assertThat(sc.getContactInfo().getPhone().getVoice(), is("228-688-2805"));
        
        Address ad = sc.getContactInfo().getAddress();
        assertThat(ad, is(not(nullValue())));
        assertThat(ad.getDeliveryPoint(), is("Bldg. 3205"));
        assertThat(ad.getCity(), is("Stennis Space Center"));
        assertThat(ad.getAdministrativeArea(), is("MS"));
        assertThat(ad.getPostalCode(), is("39529"));
        assertThat(ad.getCountry(), is("USA"));
        assertThat(ad.getEmail(), is("webmaster.ndbc@noaa.gov"));
        
		/*
		 * Operations Metadata
		 */
        
		/*
		 * Contents
		 */
        List<ObservationOffering> offerings = capabilities.getObservationOfferings();
        assertThat(offerings, hasSize(838));
        
        ObservationOffering offering = offerings.get(0);
        assertThat(offering, is(not(nullValue())));
        
        assertThat(offering.getId(), is("network-all"));
        assertThat(offering.getName(), is("urn:ioos:network:noaa.nws.ndbc:all"));
        assertThat(offering.getProcedures(), hasSize(837));
        assertThat(offering.getProcedures().get(0).getProcedure(), 
        		is("urn:ioos:station:wmo:0y2w3"));
        assertThat(offering.getObservedProperties(), hasSize(9));
        assertThat(offering.getObservedProperties().get(0).getObservedProperty(), 
        		is("http://mmisw.org/ont/cf/parameter/air_temperature"));
        assertThat(offering.getFeaturesOfInterest(), hasSize(1335));
        assertThat(offering.getFeaturesOfInterest().get(0).getFeatureOfInterest(), 
        		is("urn:cgi:Feature:CGI:EarthOcean"));
        
        assertThat(offering.getResponseFormats(), hasSize(6));
        assertThat(offering.getResultModel(), is("om:ObservationCollection"));
        assertThat(offering.getResponseMode(), is("inline"));
        
        // bounding box
        assertThat(offering.getBoundedBy().getEnvelope().getSrsName(), 
        		is("http://www.opengis.net/def/crs/EPSG/0/4326"));
        assertThat(offering.getBoundedBy().getEnvelope().getLowerCorner(), 
        		is("-77.466 -179.995"));
        assertThat(offering.getBoundedBy().getEnvelope().getUpperCorner(), 
        		is("80.81 180"));
        
        // time 
        assertThat(offering.getTime().getBeginPosition(), 
        		is("2006-07-27T21:10:00Z"));
        assertThat(offering.getTime().getEndPosition(), is(nullValue()));
        
	}

	/**
	 * Parsing the PacIOOS SOS capabilities document 
	 * 
	 */
	@Test
	public void testPacIoosSosCapabilities() {
		
		Capabilities capabilities = 
				parseCapabilities("resources/sos-capabilities/sos-pacioos-capabilities.xml");
		
		assertThat(capabilities, is(not(nullValue())));
		
		/*
		 * Service Identification
		 */
		
        ServiceIdentification si = capabilities.getServiceIdentification();
        assertThat(si, is(not(nullValue())));
        
        assertThat(si.getTitle(), is("PacIOOS Water Quality Buoy AW: Ala Wai, Oahu, Hawaii"));
        assertThat(si.getAbstract(), is("University of Hawaii"));
        
        assertThat(si.getKeywords(), hasSize(1));
        assertThat(si.getKeywords().get(0), is(""));
        
        assertThat(si.getServiceType().getServiceType(), is("OGC:SOS"));
        assertThat(si.getServiceType().getCodeSpace(), is("http://opengeospatial.net"));
        assertThat(si.getServiceTypeVersion(), is("1.0.0"));
        assertThat(si.getFees(), is("NONE"));
        assertThat(si.getAccessConstraints(), is("The data may be used and redistributed for free but is not intended for legal use, since it may contain inaccuracies. Neither the data Contributor, University of Hawaii, PacIOOS, NOAA, State of Hawaii nor the United States Government, nor any of their employees or contractors, makes any warranty, express or implied, including warranties of merchantability and fitness for a particular purpose, or assumes any legal liability for the accuracy, completeness, or usefulness, of this information."));
        
		/*
		 * Service Provider
		 */
        
        ServiceProvider sp = capabilities.getServiceProvider();
        assertThat(sp, is(not(nullValue())));
        assertThat(sp.getProviderName(), is("buoy"));
        assertThat(sp.getProviderSite().getProviderSite(), is("http://pacioos.org"));
        
        ServiceContact sc = sp.getServiceContact();
        assertThat(sc, is(not(nullValue())));
        assertThat(sc.getIndividualName(), is(""));
        assertThat(sc.getPositionName(), is(""));
        assertThat(sc.getContactInfo().getPhone().getVoice(), is(""));
        
        Address ad = sc.getContactInfo().getAddress();
        assertThat(ad, is(not(nullValue())));
        assertThat(ad.getDeliveryPoint(), is(""));
        assertThat(ad.getCity(), is(""));
        assertThat(ad.getAdministrativeArea(), is(""));
        assertThat(ad.getPostalCode(), is(""));
        assertThat(ad.getCountry(), is(""));
        assertThat(ad.getEmail(), is(""));
        
		/*
		 * Operations Metadata
		 */
        
		/*
		 * Contents
		 */
        List<ObservationOffering> offerings = capabilities.getObservationOfferings();
        assertThat(offerings, hasSize(2));
        
        ObservationOffering offering = offerings.get(0);
        assertThat(offering, is(not(nullValue())));
        
        assertThat(offering.getId(), is("network-all"));
        assertThat(offering.getName(), is("urn:ioos:network:org.pacioos:all"));
        assertThat(offering.getProcedures(), hasSize(2));
        assertThat(offering.getProcedures().get(0).getProcedure(), 
        		is("urn:ioos:network:org.pacioos:all"));
        assertThat(offering.getObservedProperties(), hasSize(18));
        assertThat(offering.getObservedProperties().get(0).getObservedProperty(), 
        		is("temp_raw"));
        assertThat(offering.getFeaturesOfInterest(), hasSize(1));
        assertThat(offering.getFeaturesOfInterest().get(0).getFeatureOfInterest(), 
        		is("urn:ioos:station:org.pacioos:WQBAW"));
        
        assertThat(offering.getResponseFormats(), hasSize(2));
        assertThat(offering.getResultModel(), is("om:ObservationCollection"));
        assertThat(offering.getResponseMode(), is("inline"));
        
        // bounding box
        assertThat(offering.getBoundedBy().getEnvelope().getSrsName(), 
        		is("http://www.opengis.net/def/crs/EPSG/0/4326"));
        assertThat(offering.getBoundedBy().getEnvelope().getLowerCorner(), 
        		is("21.27989959716797 -157.84800720214844"));
        assertThat(offering.getBoundedBy().getEnvelope().getUpperCorner(), 
        		is("21.27999959716797 -157.84790720214843"));
        
        // time 
        assertThat(offering.getTime().getBeginPosition(), 
        		is("2008-06-06T10:00:00Z"));
        assertThat(offering.getTime().getEndPosition(),
        		is("2013-06-19T09:40:00Z"));        
        
	}	
	
}
