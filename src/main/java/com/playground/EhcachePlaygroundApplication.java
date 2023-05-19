package com.playground;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({"classpath*:applicationContext-EhcachePlayground.xml"})
public class EhcachePlaygroundApplication {

	public static void main(String[] args) {
		SpringApplication.run(EhcachePlaygroundApplication.class, args);
	}

}
