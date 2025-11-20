package br.com.pat.investimento_api.dto;

import lombok.Data;

@Data
public class PerfilRequest {
    private Long clienteId;
    private Integer toleranciaRisco;
    private Integer horizonte;
    private Integer conhecimentoFinanceiro;
    private Integer objetivo;
    private Integer situacaoFinanceira;
}