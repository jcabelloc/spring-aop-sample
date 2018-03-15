package edu.tamu.jcabelloc.springaopsample;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import edu.tamu.jcabelloc.springaopsample.service.ExchangeRateService;

public class AroundSampleApp {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SampleConfig.class);
		
		ExchangeRateService exchangeRateService = context.getBean("exchangeRateService", ExchangeRateService.class);
		
		System.out.println("\n\n The exchange rate is " + exchangeRateService.getRate());
		
		context.close();
	}
}
