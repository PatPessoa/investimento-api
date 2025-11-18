package br.com.pat.investimento_api.dto;

import lombok.Data;

@Data
public class SimulacaoRequest {
    private Long clienteId;
    private Double valor;
    private Integer prazoMeses;
    private String tipoProduto;
}