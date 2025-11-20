package br.com.pat.investimento_api.service;

import br.com.pat.investimento_api.dto.PerfilRequest;
import br.com.pat.investimento_api.dto.PerfilResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class RecomendacaoServiceTest {

    @Autowired
    RecomendacaoService service;

    @Test
    void deveIdentificarPerfilModerado() {
        PerfilRequest questionario = new PerfilRequest();
        questionario.setClienteId(1L);
        questionario.setToleranciaRisco(10);
        questionario.setHorizonte(10);
        questionario.setConhecimentoFinanceiro(10);
        questionario.setObjetivo(0);
        questionario.setSituacaoFinanceira(0);

        PerfilResponse resp = service.identificarPerfil(questionario);

        assertEquals("Moderado", resp.getPerfil());
    }
}