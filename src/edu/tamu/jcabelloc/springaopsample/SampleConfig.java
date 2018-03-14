package edu.tamu.jcabelloc.springaopsample;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("edu.tamu.jcabelloc")
public class SampleConfig {

}
