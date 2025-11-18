package br.com.pat.investimento_api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
public class Simulacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long clienteId;
    private String produtoNome;
    private Double valorInvestido;
    private Double valorFinal;
    private Integer prazoMeses;
    private LocalDateTime dataSimulacao;
}