package com.example.demo;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		System.out.println("Hello Springboot");
		SpringApplication.run(DemoApplication.class, args);
		System.out.println("Hello Springboot");
				}
}