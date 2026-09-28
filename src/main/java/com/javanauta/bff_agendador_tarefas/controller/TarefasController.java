package com.javanauta.bff_agendador_tarefas.controller;


import com.javanauta.bff_agendador_tarefas.business.TarefasService;
import com.javanauta.bff_agendador_tarefas.business.dto.in.TarefasDTORequest;
import com.javanauta.bff_agendador_tarefas.business.dto.out.TarefasDTOResponse;
import com.javanauta.bff_agendador_tarefas.business.enums.StatusNotificacaoEnum;
import com.javanauta.bff_agendador_tarefas.infrasctructure.security.SecurityConfig;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/tarefas")
@RequiredArgsConstructor
@Tag(name = "Tarefas", description = "cadastra tarefas de usuarios")
@SecurityRequirement(name = SecurityConfig.SECURITY_SCHEME)
public class TarefasController {

    private final TarefasService tarefasService;

    @PostMapping
    @Operation(summary = "Salvar tarefas de usuarios", description = "cria uma nova tarefa")
    @ApiResponse(responseCode = "200", description = "tarefa salva com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    @ApiResponse(responseCode = "401", description = "Usuário não encontrado")
    public ResponseEntity<TarefasDTOResponse> gravarTarefas(@RequestBody TarefasDTORequest dto,
                                                            @RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.ok(tarefasService.gravarTarefas(dto, token));
    }

    @GetMapping("/eventos")
    @Operation(summary = "Busca tarefas por período", description = "busca tarefas cadastradas por período")
    @ApiResponse(responseCode = "200", description = "tarefas encontradas")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    @ApiResponse(responseCode = "401", description = "Usuário não encontrado")
    public ResponseEntity<List<TarefasDTOResponse>> buscaListaTarefasPorPeriodo(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicial,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFinal,
            @RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.ok(tarefasService.buscaTarefasAgendadasPorPeriodo(dataInicial, dataFinal, token));

    }

    @GetMapping
    @Operation(summary = "Busca lista tarefas por e-mail de usuário",
                description = "busca tarefas cadastradas por usuário")
    @ApiResponse(responseCode = "200", description = "tarefas encontradas")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    @ApiResponse(responseCode = "403", description = "Email não encontrado")
    @ApiResponse(responseCode = "401", description = "Usuário não encontrado")
    public ResponseEntity<List<TarefasDTOResponse>> buscaTarefasPorEmail(@RequestHeader(name = "Authorization", required = false) String token) {

        return ResponseEntity.ok(tarefasService.buscaTarefasPorEmailUsuario(token));
    }

    @DeleteMapping
    @Operation(summary = "Deletas tarefas cadastradas por ID", description = "deletas tarefas cadastradas por ID")
    @ApiResponse(responseCode = "200", description = "tarefa deletadas")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    @ApiResponse(responseCode = "403", description = "Tarefa Id não encontrado")
    @ApiResponse(responseCode = "401", description = "Usuário não encontrado")
    public ResponseEntity<Void> deletaTarefasPorId(@RequestParam("id") String id,
                                                   @RequestHeader(name = "Authorization", required = false) String token) {

        tarefasService.deletaTarefaPorId(id, token);

        return ResponseEntity.ok().build();
    }

    @PatchMapping
    @Operation(summary = "Altera status de tarefas", description = "altera status de taredas cadastradas")
    @ApiResponse(responseCode = "200", description = "status de tarefa alterado")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    @ApiResponse(responseCode = "403", description = "Tarefa Id não encontrado")
    @ApiResponse(responseCode = "401", description = "Usuário não encontrado")
    public ResponseEntity<TarefasDTOResponse> alteraStatusNotificacao(@RequestParam("status") StatusNotificacaoEnum status,
                                                                      @RequestParam("id") String id,
                                                                      @RequestHeader(name = "Authorization", required = false) String token) {

        return ResponseEntity.ok(tarefasService.alteraStatusTarefa(status, id, token));

    }

    @PutMapping
    @Operation(summary = "Altera dados de tarefas", description = "Altera dados de tarefas cadastradas")
    @ApiResponse(responseCode = "200", description = "tarefa alterada")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    @ApiResponse(responseCode = "403", description = "Tarefa Id não encontrado")
    @ApiResponse(responseCode = "401", description = "Usuário não encontrado")
    public ResponseEntity<TarefasDTOResponse> updateTarefas(@RequestBody TarefasDTORequest dto,
                                                            @RequestParam("id") String id,
                                                            @RequestHeader(name = "Authorization", required = false) String token) {
        return ResponseEntity.ok(tarefasService.updateTarefas(dto, id, token));

    }


}




