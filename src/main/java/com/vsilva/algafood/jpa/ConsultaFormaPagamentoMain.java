package com.vsilva.algafood.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.vsilva.algafood.AlgafoodApiApplication;
import com.vsilva.algafood.domain.model.FormaPagamento;
import com.vsilva.algafood.domain.repository.FormaPagamentoRepository;

public class ConsultaFormaPagamentoMain {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);
        
        FormaPagamentoRepository formaPagamentoRepository = applicationContext.getBean(FormaPagamentoRepository.class);
        
        List<FormaPagamento> todasFormasPagamentos = formaPagamentoRepository.todos();
        
        for (FormaPagamento formaPagamento : todasFormasPagamentos) {
            System.out.println(formaPagamento.getDescricao());
        }
    }
}
