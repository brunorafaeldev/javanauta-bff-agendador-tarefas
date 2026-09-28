package com.javanauta.bff_agendador_tarefas.infrasctructure.exceptions;

public class ResourceNotFoundExpection extends RuntimeException {

    public ResourceNotFoundExpection(String mensage) {
        super(mensage);
    }

    public ResourceNotFoundExpection(String mensage, Throwable throwable) {
        super(mensage, throwable);

    }


}
