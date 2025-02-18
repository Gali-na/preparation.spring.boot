package com.preparation.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {
	//	SpringApplication.run(Main.class, args);

		System.out.println("Hello");

	   Note note = new Note();
	   note.setId(Long.MAX_VALUE+2);
	   note.setContect("sdfdf");
	  // note.setTitle();
		System.out.println(note);
		System.out.println(Long.MAX_VALUE+1);
		System.out.println(Long.MAX_VALUE);

	}

}
