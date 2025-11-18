package br.com.pat.investimento_api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data // Lombok cria os Getters e Setters
@Entity // Informa ao Spring que isso será uma tabela de BD
public class Produto {

    @Id // ID único
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Gera numeração
    private Long id;

    private String nome;
    private String tipo;
    private Double rentabilidade;
    private String risco;
    private Integer prazoMinimo;
}