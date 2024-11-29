package com.ParkCore.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ParkCore.service.ZipCodeStackApi;

import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;


@Configuration
public class ZipCodeStackApiConfiguration {
	
	@Value("${zipcodestack.api.url}")
    String url;

    @Bean
    public ZipCodeStackApi zipCodeStackApi() {
        return Feign.builder()
                .decoder(new JacksonDecoder())
                .encoder(new JacksonEncoder())
                .target(ZipCodeStackApi.class, url);
    }
	
	
}
