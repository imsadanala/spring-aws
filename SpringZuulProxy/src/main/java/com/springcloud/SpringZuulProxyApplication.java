package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.springcloud.filters.CustomFilter;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class SpringZuulProxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringZuulProxyApplication.class, args);
	}
	
	@Bean
	CustomFilter getFilter() {
		return new CustomFilter();
	}

}
