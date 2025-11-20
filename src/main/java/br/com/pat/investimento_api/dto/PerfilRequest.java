package br.com.pat.investimento_api.dto;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.util.List;

@Data
public class PerfilRequest {

    @NotNull(message = "O ID do cliente é obrigatório")
    private Long clienteId;

    @NotNull(message = "A tolerância ao risco é obrigatória")
    private Integer toleranciaRisco;

    @NotNull(message = "O horizonte de investimento é obrigatório")
    private Integer horizonte;

    @NotNull(message = "O conhecimento financeiro é obrigatório")
    private Integer conhecimentoFinanceiro;

    @NotNull(message = "O objetivo é obrigatório")
    private Integer objetivo;

    @NotNull(message = "A situação financeira é obrigatória")
    private Integer situacaoFinanceira;

    @AssertTrue(message = "Os valores de pontuação devem ser apenas 0, 10 ou 20")
    public boolean isPontuacoesValidas() {
        List<Integer> permitidos = List.of(0, 10, 20);

        try {
            return permitidos.contains(toleranciaRisco) &&
                    permitidos.contains(horizonte) &&
                    permitidos.contains(conhecimentoFinanceiro) &&
                    permitidos.contains(objetivo) &&
                    permitidos.contains(situacaoFinanceira);
        } catch (NullPointerException e) {
            return false;
        }
    }
}