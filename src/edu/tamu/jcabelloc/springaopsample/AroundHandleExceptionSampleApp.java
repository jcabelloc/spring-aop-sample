package edu.tamu.jcabelloc.springaopsample;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import edu.tamu.jcabelloc.springaopsample.service.ExchangeRateService;

public class AroundHandleExceptionSampleApp {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SampleConfig.class);
		
		ExchangeRateService exchangeRateService = context.getBean("exchangeRateService", ExchangeRateService.class);
		
		boolean flagException = true;
		
		String rate = exchangeRateService.getRate(flagException);
		
		System.out.println("\n\n The exchange rate is: " + rate);
		
		context.close();
	}
}
