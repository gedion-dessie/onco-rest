package org.mskcc.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

/**
 * Created by gedionz on 4/13/17.
 */
@Component
public class RestConfig extends ResourceConfig {
	
	public RestConfig() {
		packages("org.mskcc.rest.resource","org.mskcc.exception");
	}
}
