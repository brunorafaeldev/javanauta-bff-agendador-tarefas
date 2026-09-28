package com.javanauta.bff_agendador_tarefas.business.dto.in;

import com.fasterxml.jackson.annotation.JsonFormat;

import com.javanauta.bff_agendador_tarefas.business.enums.StatusNotificacaoEnum;
import lombok.*;

import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TarefasDTORequest {




        private String nomeTarefa;
        private String descricaoTarefa;
        @JsonFormat(shape =  JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
        private LocalDateTime dataEvento;



    }

