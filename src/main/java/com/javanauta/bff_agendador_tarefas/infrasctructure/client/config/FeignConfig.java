package com.javanauta.bff_agendador_tarefas.infrasctructure.client.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {


    @Bean // o spring vai entender que é uma classe de configuração quando ele rodar
    public FeignErro feignErro() {
        return new FeignErro();
    }


}
