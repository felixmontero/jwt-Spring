package com.esliceu.jwt;

import com.esliceu.jwt.interceptors.TokenInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class JwtApplication implements WebMvcConfigurer {
	@Autowired
	TokenInterceptor tokenInterceptor;

	public static void main(String[] args) {
		SpringApplication.run(JwtApplication.class, args);
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(tokenInterceptor)
				.addPathPatterns("/private/**");
	}
}
