package com.javanauta.bff_agendador_tarefas.business.dto.out;

import com.fasterxml.jackson.annotation.JsonFormat;

import com.javanauta.bff_agendador_tarefas.business.enums.StatusNotificacaoEnum;
import lombok.*;

import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TarefasDTOResponse {



        private String id;
        private String nomeTarefa;
        private String descricaoTarefa;
        @JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
        private LocalDateTime dataCriacaoTarefa;
        @JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
        private LocalDateTime dataEvento;
        private String emailUsuario;
        @JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
        private LocalDateTime dataAlteracaoTarefa;
        private StatusNotificacaoEnum statusNotificacaoEnum;



    }

