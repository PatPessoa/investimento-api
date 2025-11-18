package br.com.pat.investimento_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PerfilResponse {
    private Long clienteId;
    private String perfil;
    private Integer pontuacao;
    private String descricao;
}