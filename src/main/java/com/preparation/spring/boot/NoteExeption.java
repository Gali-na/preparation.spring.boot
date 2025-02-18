package com.preparation.spring.boot;

public class NoteExeption extends Exception{
    public NoteExeption() {
        super();
    }

    public NoteExeption(String message) {
        super(message);
    }

    public NoteExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public NoteExeption(Throwable cause) {
        super(cause);
    }

    protected NoteExeption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
