package com.ruwanka;

import org.apache.camel.spring.SpringRouteBuilder;
import org.springframework.stereotype.Component;

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
