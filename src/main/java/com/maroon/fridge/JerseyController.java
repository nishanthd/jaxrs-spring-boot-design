package com.maroon.fridge;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

/**
 * 
 * @author Nishanth Dharmaraju
 *
 */
@Component
public class JerseyController extends ResourceConfig {

	public JerseyController() {
		register(packages("com.maroon.fridge"));
	}

}
