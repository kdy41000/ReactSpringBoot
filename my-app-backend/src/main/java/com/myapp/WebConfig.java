package com.myapp;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration   // @Configuration: 스프링 IOC Container에게 해당 클래스를 Bean구성 Class임을 알려주는 것
public class WebConfig implements WebMvcConfigurer{  // WebMvcConfigurer를 상속받으면 @EnableWebMvc가 자동적으로 세팅해주는 설정에 개발자가 원하는 설정을 추가할 수 있게 된다.
	/*
	 	개발 환경에서의 크로스 도메인 이슈를 해결하기 위한 코드로
	 	운영 환경에 배포할 경우에는 15 ~ 18(addCorsMappings메소드)행을 주석 처리합니다.
	 	*크로스 도메인 이슈: 브라우저에서 다른 도메인으로 URL요청을 하는 경우 나타나는 보안문제
	 */
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/api/**").allowCredentials(true);
	}
	
}
