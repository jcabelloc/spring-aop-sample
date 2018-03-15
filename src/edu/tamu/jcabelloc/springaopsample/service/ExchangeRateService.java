package edu.tamu.jcabelloc.springaopsample.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class ExchangeRateService {
	
	public String getRate() {
		
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "3.26";
	}

	public String getRate(boolean flagException) {
		
		if (flagException) {
			throw new RuntimeException("Service Unavailable!!!");
		}
		
		return getRate();
	}
}
