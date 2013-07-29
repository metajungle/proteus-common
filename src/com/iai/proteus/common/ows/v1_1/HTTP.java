package com.iai.proteus.common.ows.v1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * OWS HTTP 
 * 
 * @author Jakob Henriksson
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class HTTP {
	
	private final String ows = "http://www.opengis.net/ows/1.1";
	
	@XmlElement(name="Get", namespace=ows, required=true)
	protected Get get;

	@XmlElement(name="Post", namespace=ows, required=true)
	protected Post post;

	public Get getGet() {
		return get;
	}
	
	/**
	 * Utility method 
	 * 
	 * @return
	 */
	public String getGetValue() {
		if (get != null) {
			return get.getGet();
		}
		return null;
	}

	public Post getPost() {
		return post;
	}
	
	/**
	 * Utility method 
	 * 
	 * @return
	 */
	public String getPostValue() {
		if (post != null) {
			return post.getGet();
		}
		return null;
	}	
}
