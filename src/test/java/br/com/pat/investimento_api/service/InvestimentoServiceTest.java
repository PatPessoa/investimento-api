package br.com.pat.investimento_api.service;

import br.com.pat.investimento_api.dto.SimulacaoRequest;
import br.com.pat.investimento_api.dto.SimulacaoResponse;
import br.com.pat.investimento_api.entity.Produto;
import br.com.pat.investimento_api.repository.ProdutoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class InvestimentoServiceTest {

    @Autowired
    InvestimentoService service;

    @Autowired
    ProdutoRepository produtoRepository;

    @Test
    void deveCalcularSimulacaoCorretamente() {
        Produto p = new Produto();
        p.setNome("CDB Teste");
        p.setTipo("CDB");
        p.setRentabilidade(0.12);
        p.setRisco("Baixo");
        p.setPrazoMinimo(12);
        produtoRepository.save(p);

        SimulacaoRequest req = new SimulacaoRequest();
        req.setClienteId(1L);
        req.setValor(1000.0);
        req.setPrazoMeses(12);
        req.setTipoProduto("CDB");

        SimulacaoResponse resp = service.simular(req);

        assertEquals(1120.0, resp.getResultadoSimulacao().getValorFinal());
    }
}