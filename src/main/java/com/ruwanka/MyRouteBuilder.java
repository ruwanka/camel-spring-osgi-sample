package com.ruwanka;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.spring.SpringRouteBuilder;
import org.springframework.stereotype.Component;

/**
 * RouteBuilder class that configures routes in camel context
 * @author Ruwanka
 *
 */
@Component
public class MyRouteBuilder extends SpringRouteBuilder {

	private static final String SOURCE_FOLDER = "camel/source-folder";
    private static final String DESTINATION_FOLDER = "camel/destination-folder";
	
	@Override
	public void configure() throws Exception {
		from("file://" + SOURCE_FOLDER + "?delete=true")
		.process(new FileProcessor())
		.to("file://" + DESTINATION_FOLDER);
	}

}