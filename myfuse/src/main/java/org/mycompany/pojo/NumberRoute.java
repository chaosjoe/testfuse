package org.mycompany.pojo;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class NumberRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub

		from("timer:number?period=1000")
		.log("log:numbers");
//		.transform().simple("${random(0, 200)}")
//		.to("direct:numbers");
	}

}
