package com.javanauta.bff_agendador_tarefas.business;


import com.javanauta.bff_agendador_tarefas.business.dto.in.EnderecoDTORequest;
import com.javanauta.bff_agendador_tarefas.business.dto.in.LoginDTORequest;
import com.javanauta.bff_agendador_tarefas.business.dto.in.TelefoneDTORequest;
import com.javanauta.bff_agendador_tarefas.business.dto.in.UsuarioDTORequest;
import com.javanauta.bff_agendador_tarefas.business.dto.out.EnderecoDTOResponse;
import com.javanauta.bff_agendador_tarefas.business.dto.out.TelefoneDTOResponse;
import com.javanauta.bff_agendador_tarefas.business.dto.out.UsuarioDTOResponse;
import com.javanauta.bff_agendador_tarefas.business.dto.out.ViaCepDTOResponse;
import com.javanauta.bff_agendador_tarefas.infrasctructure.client.UsuarioClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {


    private final UsuarioClient usuarioClient;

    public UsuarioDTOResponse salvarUsuario(UsuarioDTORequest usuarioDTO) {

        return usuarioClient.salvarUsuario(usuarioDTO);
    }

    public String loginUsuario(LoginDTORequest dto) {
        return usuarioClient.login(dto);
    }


    public UsuarioDTOResponse buscarUsuarioPorEmail(String email, String token) {
        return usuarioClient.buscarUsuarioPorEmail(email, token);


    }


    public void deletaUsuarioPorEmail(String email, String token) {

        usuarioClient.deletaUsuarioPorEmail(email, token);

    }

    public UsuarioDTOResponse atualizarDadosUsuario(UsuarioDTORequest dto, String token) {


        return usuarioClient.atualizarDadosUsuario(dto, token);


    }

    public EnderecoDTOResponse atualizarEndereco(EnderecoDTORequest dto, Long id, String token) {

        return usuarioClient.atualizarEndereco(dto, id, token);


    }


    public TelefoneDTOResponse atualizarTelefone(TelefoneDTORequest dto, Long id, String token) {

        return usuarioClient.atualizarTelefone(dto, id, token);


    }


    public EnderecoDTOResponse cadastroEndereco(String token, EnderecoDTORequest dto) {

        return usuarioClient.cadastraEndereco(dto, token);
    }

    public TelefoneDTOResponse cadastroTelefone(TelefoneDTORequest dto, String token) {

        return usuarioClient.cadastroTelefone(dto, token);

    }

    public ViaCepDTOResponse buscarDadosPorCep(String cep) {
        return usuarioClient.buscarDadosPorCep(cep);
    }


}

