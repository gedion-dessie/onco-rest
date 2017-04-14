package org.mskcc.rest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

/**
 * Created by gedionz on 4/13/17.
 */
@Component
public class RestHttpHeader {
	protected RestTemplate restTemplate;
	
	public RestHttpHeader() {
		restTemplate = new RestTemplate();
	}
	
	public RestTemplate getRestTemplate() {
		return restTemplate;
	}
	
	public HttpHeaders getRequestHeaders() {
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		
		return requestHeaders;
	}
	
	public HttpEntity<?> getHttpEntity() {
		return new HttpEntity<>(getRequestHeaders());
	}
}
