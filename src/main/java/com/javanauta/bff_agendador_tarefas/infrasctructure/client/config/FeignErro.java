package com.javanauta.bff_agendador_tarefas.infrasctructure.client.config;

import com.javanauta.bff_agendador_tarefas.infrasctructure.exceptions.BusinessException;
import com.javanauta.bff_agendador_tarefas.infrasctructure.exceptions.ConflictExceptions;
import com.javanauta.bff_agendador_tarefas.infrasctructure.exceptions.IllegalArgumentException;
import feign.Response;
import feign.codec.ErrorDecoder;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class FeignErro implements ErrorDecoder {


    @Override
    public Exception decode(String methodKey, Response response) {


        String mensagemError = mensagemError(response);

        switch (response.status()) {
            case 409:
                return new ConflictExceptions("Erro " + mensagemError);
            case 403:
                return new ConflictExceptions("Erro " + mensagemError);
            case 401:
                return new ConflictExceptions("Erro " + mensagemError);
            case 400:
                return new IllegalArgumentException("Erro " +  mensagemError);
            default:
                return new BusinessException("Erro " + mensagemError);


        }


    }

    private String mensagemError(Response response) {

        try {
            if (Objects.isNull(response.body())) {
                return "";
            }
            return new String(response.body().asInputStream().readAllBytes(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

