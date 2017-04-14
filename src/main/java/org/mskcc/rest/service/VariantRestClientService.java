package org.mskcc.rest.service;

import org.mskcc.domain.Variant;
import org.mskcc.rest.RestHttpHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * Created by gedionz on 4/13/17.
 */
@Component
public class VariantRestClientService {
	
	@Autowired
	private RestHttpHeader restHttpHeader;
	
	public List<Variant> getVariants(String url) {
		RestTemplate restTemplate = restHttpHeader.getRestTemplate();
		Variant[] variants = restTemplate.exchange(url, HttpMethod.GET, restHttpHeader.getHttpEntity(), Variant[].class).getBody();
		
		return Arrays.asList(variants);
	}
}
