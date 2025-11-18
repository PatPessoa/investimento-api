package br.com.pat.investimento_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class TelemetriaResponse {

    private List<ItemTelemetria> servicos;

    @Data
    @AllArgsConstructor
    public static class ItemTelemetria {
        private String nome;
        private Long quantidadeChamadas;
        private Integer mediaTempoRespostaMs;
    }
}