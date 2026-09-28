package com.javanauta.bff_agendador_tarefas.infrasctructure.exceptions;

public class IllegalArgumentException extends RuntimeException {
    public IllegalArgumentException(String message) {

        super(message);
    }

    public IllegalArgumentException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
