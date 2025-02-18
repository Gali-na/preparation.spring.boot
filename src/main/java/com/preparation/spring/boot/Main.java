package com.preparation.spring.boot;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

    public static void main(String[] args) throws NoteExeption {
        //	SpringApplication.run(Main.class, args);

        System.out.println("Hello");

        Note note = new Note();
        note.setContent("Hello it's my first content");
        note.setTitle("The first");

        Note note2 = new Note();
        note2.setContent("Hello it's my second content");
        note2.setTitle("The second");

        NoteService noteService = new NoteService();
        System.out.println( noteService.add(note));
        System.out.println( noteService.add(note2));


    }

}
