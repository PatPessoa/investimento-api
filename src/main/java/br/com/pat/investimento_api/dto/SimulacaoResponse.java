package br.com.pat.investimento_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class SimulacaoResponse {

    private ProdutoValidado produtoValidado;
    private ResultadoSimulacao resultadoSimulacao;
    private LocalDateTime dataSimulacao;

    @Data
    @AllArgsConstructor
    public static class ProdutoValidado {
        private Long id;
        private String nome;
        private String tipo;
        private Double rentabilidade;
        private String risco;
    }

    @Data
    @AllArgsConstructor
    public static class ResultadoSimulacao {
        private Double valorFinal;
        private Double rentabilidadeEfetiva;
        private Integer prazoMeses;
    }
}