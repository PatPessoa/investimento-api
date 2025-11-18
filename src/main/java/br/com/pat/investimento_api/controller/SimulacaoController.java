package br.com.pat.investimento_api.controller;

import br.com.pat.investimento_api.dto.SimulacaoRequest;
import br.com.pat.investimento_api.dto.SimulacaoResponse;
import br.com.pat.investimento_api.entity.Simulacao;
import br.com.pat.investimento_api.service.InvestimentoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/") // Agora a base é a raiz
public class SimulacaoController {

    private final InvestimentoService service;

    public SimulacaoController(InvestimentoService service) {
        this.service = service;
    }

    // Endpoint 1: Simular (POST /simular-investimento)
    @PostMapping("/simular-investimento")
    public SimulacaoResponse simular(@RequestBody SimulacaoRequest pedido) {
        return service.simular(pedido);
    }

    // Endpoint 2: Histórico (GET /simulacoes)
    @GetMapping("/simulacoes")
    public List<Simulacao> listarHistorico() {
        return service.listarTodasSimulacoes();
    }
}