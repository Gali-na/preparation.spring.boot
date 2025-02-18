package com.preparation.spring.boot;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class NoteServiceTest {
    Note note;
    NoteService noteService;

    @BeforeEach
    void setUp() {
        noteService = new NoteService();
        note = new Note();
        try {
            note.setContent("Hello it's my first content");
            note.setTitle("The first");
        } catch (NoteExeption e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void listAll_shouldGetNotEmptyList() {
        try {
            noteService.add(note);
        } catch (NoteExeption e) {
            System.out.println(e.getMessage());
        }
        assertEquals(1, noteService.listAll().size());

    }

    @Test
    void add_shouldGetNoteWithIdPоsitive() {
        Note noteTest = null;
        try {
            noteTest = noteService.add(note);
        } catch (NoteExeption e) {
            System.out.println(e.getMessage());
        }
        assertTrue(noteTest.getId() > 0);
    }

    @Test
    void add_shouldAddNoutInBD() {
        Note noteTest = null;
        int sizeNoteServiceStart = noteService.listAll().size();
        try {
            noteTest = noteService.add(note);
        } catch (NoteExeption e) {
            System.out.println(e.getMessage());
        }
        int sizeNoteServiceFinish = noteService.listAll().size();
        assertTrue(sizeNoteServiceStart + 1 == sizeNoteServiceFinish);
    }

    @Test
    void deleteById_shouldThrowException_whenIdNotExist() {
        try {
            noteService.add(note);
        } catch (NoteExeption e) {
            System.out.println(e.getMessage());
        }
        List<Note> notes = noteService.listAll();
        List<Long> listId = new ArrayList<>();
        for (Note noteCurrent : notes) {
            listId.add(noteCurrent.getId());
        }
        Random random = new Random();
        Long idNotExist = random.nextLong();

        while (listId.contains(idNotExist)) {
            idNotExist = random.nextLong();
        }
        long lastVersionId = idNotExist;
        assertThrowsExactly(NoteExeption.class, () -> noteService.deleteById(lastVersionId));
    }

    @Test
    void deleteById_shouldDeleteId_whenIdValid() throws NoteExeption {
        try {
            noteService.add(note);
        } catch (NoteExeption e) {
            System.out.println(e.getMessage());
        }
        int sizeNoteServiceStart = noteService.listAll().size();
        noteService.deleteById(note.getId());
        int sizeNoteServiceFinish = noteService.listAll().size();
        assertTrue(sizeNoteServiceStart - 1 == sizeNoteServiceFinish);
    }

    @Test
    void update_shouldThrowException_whenIdNotExist() throws NoteExeption {
        try {
            noteService.add(note);
        } catch (NoteExeption e) {
            System.out.println(e.getMessage());
        }
        List<Note> notes = noteService.listAll();
        List<Long> listId = new ArrayList<>();
        for (Note noteCurrent : notes) {
            listId.add(noteCurrent.getId());
        }
        Random random = new Random();
        Long idNotExist = random.nextLong();

        while (listId.contains(idNotExist)) {
            idNotExist = random.nextLong();
        }
        Note note = new Note();
        note.setId(idNotExist);

        long lastVersionId = idNotExist;
        assertThrowsExactly(NoteExeption.class, () -> noteService.update(note));
    }

    @Test
    void update_shouldUpdateNote_whenIdExist() throws NoteExeption {
        Note note = new Note();
        note.setContent("context");
        note.setTitle("title");
        try {
            noteService.add(note);
        } catch (NoteExeption e) {
            System.out.println(e.getMessage());
        }
        note.setContent("updated context");
        note.setTitle("updated title");
        noteService.update(note);
        assertEquals("updated context", noteService.getById(note.getId()).getContent());
        assertEquals("updated title", noteService.getById(note.getId()).getTitle());
    }

    @Test
    void getById_shouldThrowException_whenIdNotExist() {
        try {
            noteService.add(note);
        } catch (NoteExeption e) {
            System.out.println(e.getMessage());
        }
        List<Note> notes = noteService.listAll();
        List<Long> listId = new ArrayList<>();
        for (Note noteCurrent : notes) {
            listId.add(noteCurrent.getId());
        }
        Random random = new Random();
        Long idNotExist = random.nextLong();

        while (listId.contains(idNotExist)) {
            idNotExist = random.nextLong();
        }
        long lastVersionId = idNotExist;
        assertThrowsExactly(NoteExeption.class, () -> noteService.deleteById(lastVersionId));
    }

    @Test
    void getById_shouldGetNote_whenIdExist() throws NoteExeption {
        try {
            noteService.add(note);
        } catch (NoteExeption e) {
            System.out.println(e.getMessage());
        }
        assertEquals(note,noteService.getById(note.getId()));
    }
}