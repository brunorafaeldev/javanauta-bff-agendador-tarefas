package com.javanauta.bff_agendador_tarefas.infrasctructure.exceptions;

import javax.naming.AuthenticationException;

public class UnauthorizedException extends RuntimeException {

    public UnauthorizedException(String mensage) {super(mensage);}

    public UnauthorizedException(String mensage, Throwable throwable) {

        super (mensage);
    }
}
