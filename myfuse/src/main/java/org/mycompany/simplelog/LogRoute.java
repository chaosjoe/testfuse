package org.mycompany.simplelog;

import java.time.LocalDateTime;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LogRoute extends RouteBuilder {

	@Autowired
	private GetCurrentTimeBean getCurrentTimeBean;
	
	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		from("timer:logger")
		.log("${body}")
		.transform().constant("time now is " + LocalDateTime.now())
		.log("${body}")
		.bean(getCurrentTimeBean, "getCurrentTime")
		.log("${body}")
		.process(new SimpleLoggingProcess())
		.to("log:logger");
	}
}


class SimpleLoggingProcess implements Processor {
	Logger logger = LoggerFactory.getLogger(SimpleLoggingProcess.class);
	
	@Override
	public void process(Exchange exchange) throws Exception {
		// TODO Auto-generated method stub
		logger.info("SimpleLoggingProcess + {}", exchange.getMessage().getBody());
	}
	
}

