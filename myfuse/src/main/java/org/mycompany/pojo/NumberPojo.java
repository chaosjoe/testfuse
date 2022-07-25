package org.mycompany.pojo;

import org.apache.camel.Consume;
import org.apache.camel.Produce;
import org.springframework.stereotype.Component;

@Component
public class NumberPojo {
	
	
	@Produce(uri = "direct:numbers")
	private MagicNumber magic;
	
	@Consume(uri = "direct:numbers", predicate = "${body} < 100")
	public void lowNumber(int number) {
		magic.onMagicNumber("Got a low number " + String.valueOf(number));
	}
	
	@Consume(uri = "direct:numbers", predicate = "${body} >= 100")
	public void hightNumber(int number) {
		magic.onMagicNumber("Got a hight number " + String.valueOf(number));
	}
}
