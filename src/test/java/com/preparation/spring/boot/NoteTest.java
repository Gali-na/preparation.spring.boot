package com.preparation.spring.boot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

public class NoteTest {
    private Note note;

    @BeforeEach
    void setUp() {
        note = new Note();
    }

    @Test
    void getId() {
        try {
            note.setId(4);
        } catch (NoteExeption e) {
            System.out.println(e.getMessage());
        }
        assertEquals(note.getId(), 4);
    }

    @Test
    void setId_shouldThrowException_whenIdNegative() {
        assertThrowsExactly(NoteExeption.class, () -> note.setId(-1));
    }

    @Test
    void setId_shouldThrowException_whenIdNull() {
        assertThrowsExactly(NoteExeption.class, () -> note.setId(0));

    }

    @Test
    void getTitle() {
        try {
            note.setTitle("Hello");
        } catch (NoteExeption e) {
            System.out.println(e.getMessage());
        }
        assertEquals(note.getTitle(), "Hello");
    }

    @Test
    void setTitle_shouldThrowException_whenTitleNull() {
        assertThrowsExactly(NoteExeption.class, () -> note.setTitle(null));
    }

    @Test
    void setTitle_shouldThrowException_whenTitleEmpty() {
        assertThrowsExactly(NoteExeption.class, () -> note.setTitle(""));
    }

    @Test
    void getContent() {
        try {
            note.setContent("The first context");
        } catch (NoteExeption e) {
            System.out.println(e.getMessage());
        }
        assertEquals(note.getContent(), "The first context");

    }

    @Test
    void setContent_shouldThrowException_whenTitleEmpty() {
        assertThrowsExactly(NoteExeption.class, () -> note.setTitle(""));
    }

    @Test
    void setContent_shouldThrowException_whenTitleNull() {
        assertThrowsExactly(NoteExeption.class, () -> note.setTitle(null));
    }
}

