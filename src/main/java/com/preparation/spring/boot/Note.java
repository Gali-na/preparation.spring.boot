package com.preparation.spring.boot;

import lombok.Data;
import lombok.NoArgsConstructor;

//content - контент нотатки. Рядок (String).
@Data
@NoArgsConstructor
public class Note {
    private long id;

    private String title;

    private String content;

    public long getId() {
        return id;
    }

    public void setId(long id) throws NoteExeption {
        if(id<=0){
            throw new NoteExeption ("id is not valid");
        }
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) throws NoteExeption {
        if (title==null|| title.isEmpty()){
            throw new NoteExeption("title is not valid");
        }
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) throws NoteExeption {
        if ( content ==null || content.isEmpty()){
            throw new NoteExeption("contect is not valid");
        }
        this.content = content;
    }

}
