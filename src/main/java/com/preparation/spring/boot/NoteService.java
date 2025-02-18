package com.preparation.spring.boot;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class NoteService {
    //List<Note> listAll() - повертає список всіх нотаток

    //Note add(Note note) - додає нову нотатку, генеруючи для цієї
    // нотатки унікальний (випадковий) числовий ідентифікатор, повертає
    // цю ж нотатку з згенерованим ідентифікатором.

    //void deleteById(long id) - видаляє нотатку з вказаним ідентифікатором.
    // Якщо нотатки з ідентифікатором немає - викидає виключення.

    //void update(Note note) - шукає нотатку по note.id. Якщо нотатка є -
    // оновлює для неї title та content. Якщо нотатки немає - викидає виключення.

    //Note getById(long id) - повертає нотатку по її ідентифікатору.
    // Якщо нотатки немає - викидає виключення.

    private Map<Long, Note> notes = new HashMap<>();
    private Random random = new Random();

    List<Note> listAll() {
        List <Note>noteList= new ArrayList<>();
        notes.forEach(((id,note)->noteList.add(note)));
        return noteList;
    }
    public Note add(Note note) throws NoteExeption {
        long newId = random.nextLong(1, Long.MAX_VALUE);
        while (notes.containsKey(newId)) {
            newId = random.nextLong();
        }
        note.setId(newId);
        notes.put(newId, note);
        return note;
    }

    void deleteById(long id) throws NoteExeption {
        validateId(id);
        notes.remove(id);

    }

    void update(Note note) throws NoteExeption {
        validateId(note.getId());
        Note updateNote = new Note();
        updateNote.setContent(note.getContent());
        updateNote.setTitle(note.getTitle());
        notes.put(note.getId(), updateNote);

    }

    Note getById(long id) throws NoteExeption {
        validateId(id);
        return notes.get(id);
    }

    private void validateId(long id) throws NoteExeption {
        if (id <= 0 || !notes.containsKey(id)) {
            throw new NoteExeption("Id is not exist");
        }
    }

}
