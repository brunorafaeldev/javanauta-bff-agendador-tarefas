package com.javanauta.bff_agendador_tarefas.business;


import com.javanauta.bff_agendador_tarefas.business.dto.in.TarefasDTORequest;
import com.javanauta.bff_agendador_tarefas.business.dto.out.TarefasDTOResponse;
import com.javanauta.bff_agendador_tarefas.business.enums.StatusNotificacaoEnum;
import com.javanauta.bff_agendador_tarefas.infrasctructure.client.TarefasClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TarefasService {

    private final TarefasClient tarefasClient;

    public TarefasDTOResponse gravarTarefas(TarefasDTORequest dto, String token) {


        return tarefasClient.gravarTarefas(dto, token);


    }

    public List<TarefasDTOResponse> buscaTarefasAgendadasPorPeriodo(LocalDateTime dataInicial,
                                                                    LocalDateTime dataFinal,
                                                                    String token) {

        return tarefasClient.buscaListaTarefasPorPeriodo(dataInicial, dataFinal, token);


    }

    public List<TarefasDTOResponse> buscaTarefasPorEmailUsuario(String token) {


        return tarefasClient.buscaTarefasPorEmail(token);
    }

    public void deletaTarefaPorId(String id, String token) {

        tarefasClient.deletaTarefasPorId(id, token);

    }

    public TarefasDTOResponse alteraStatusTarefa(StatusNotificacaoEnum status, String id, String token) {
        return tarefasClient.alteraStatusNotificacao(status, id, token);

    }

    public TarefasDTOResponse updateTarefas(TarefasDTORequest dto, String id, String token) {
        return tarefasClient.updateTarefas(dto, id, token);


    }

}
