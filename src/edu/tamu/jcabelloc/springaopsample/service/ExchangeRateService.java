package edu.tamu.jcabelloc.springaopsample.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class ExchangeRateService {
	
	public String getRate() {
		
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "3.26";
	}
}
