package com.javanauta.bff_agendador_tarefas.infrasctructure.exceptions;

public class ConflictExceptions extends RuntimeException {

        public ConflictExceptions(String messagem) {
            super(messagem);
        }
        public ConflictExceptions(String messagem, Throwable throwable) {
            super(messagem);
        }
}
