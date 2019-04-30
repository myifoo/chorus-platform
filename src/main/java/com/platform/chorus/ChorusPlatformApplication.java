package com.platform.chorus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ChorusPlatformApplication {
    static final Logger logger = LoggerFactory.getLogger(ChorusPlatformApplication.class);
    static ApplicationContext context;

	@Bean
	public ExitCodeGenerator exitCodeGenerator() {
		return ()->1;
	}

	public static void main(String[] args) {
        context = SpringApplication.run(ChorusPlatformApplication.class, args);
	}

	static public void exit() {
        System.exit(SpringApplication.exit(context));
    }
}
