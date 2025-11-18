package br.com.pat.investimento_api.controller;

import br.com.pat.investimento_api.dto.TelemetriaResponse;
import br.com.pat.investimento_api.repository.SimulacaoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/telemetria")
public class TelemetriaController {

    private final SimulacaoRepository simulacaoRepository;

    public TelemetriaController(SimulacaoRepository simulacaoRepository) {
        this.simulacaoRepository = simulacaoRepository;
    }

    @GetMapping
    public TelemetriaResponse gerarRelatorio() {
        long totalSimulacoes = simulacaoRepository.count();

        long totalPerfis = PerfilController.contadorConsultasPerfil;

        TelemetriaResponse.ItemTelemetria item1 = new TelemetriaResponse.ItemTelemetria(
                "simular-investimento",
                totalSimulacoes,
                150
        );

        TelemetriaResponse.ItemTelemetria item2 = new TelemetriaResponse.ItemTelemetria(
                "perfil-risco",
                totalPerfis,
                80
        );

        return new TelemetriaResponse(List.of(item1, item2));
    }
}