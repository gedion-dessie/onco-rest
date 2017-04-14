package org.mskcc.rest.service;

import org.mskcc.domain.Gene;
import org.mskcc.rest.RestHttpHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * Created by gedionz on 4/13/17.
 */
@Component
public class GeneRestClientService {
	
	@Autowired
	private RestHttpHeader restHttpHeader;
	
	public List<Gene> getGenes(String url) throws HttpClientErrorException{
		RestTemplate restTemplate = restHttpHeader.getRestTemplate();
		Gene[] genes= restTemplate.exchange(url, HttpMethod.GET, restHttpHeader.getHttpEntity(), Gene[].class).getBody();
		return Arrays.asList(genes);
	}
	
	public Gene getGene(String url) throws HttpClientErrorException {
		RestTemplate restTemplate = restHttpHeader.getRestTemplate();
		Gene gene = restTemplate.exchange(url, HttpMethod.GET, restHttpHeader.getHttpEntity(), Gene.class).getBody();
		return gene;
	}
	
}
