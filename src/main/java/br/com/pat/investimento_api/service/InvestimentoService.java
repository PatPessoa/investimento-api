package br.com.pat.investimento_api.service;

import br.com.pat.investimento_api.dto.SimulacaoRequest;
import br.com.pat.investimento_api.dto.SimulacaoResponse;
import br.com.pat.investimento_api.entity.Produto;
import br.com.pat.investimento_api.entity.Simulacao;
import br.com.pat.investimento_api.repository.ProdutoRepository;
import br.com.pat.investimento_api.repository.SimulacaoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class InvestimentoService {

    private final ProdutoRepository produtoRepository;
    private final SimulacaoRepository simulacaoRepository;

    public InvestimentoService(ProdutoRepository produtoRepository, SimulacaoRepository simulacaoRepository) {
        this.produtoRepository = produtoRepository;
        this.simulacaoRepository = simulacaoRepository;
    }

    public SimulacaoResponse simular(SimulacaoRequest pedido) {
        List<Produto> produtos = produtoRepository.findAll();

        Produto produtoEscolhido = null;
        for (Produto p : produtos) {
            if (p.getTipo().equalsIgnoreCase(pedido.getTipoProduto())) {
                produtoEscolhido = p;
                break;
            }
        }

        if (produtoEscolhido == null) {
            produtoEscolhido = produtos.get(0);
        }

        double tempoEmAnos = pedido.getPrazoMeses() / 12.0;
        double lucro = pedido.getValor() * produtoEscolhido.getRentabilidade() * tempoEmAnos;
        double valorFinal = pedido.getValor() + lucro;

        Simulacao novaSimulacao = new Simulacao();
        novaSimulacao.setClienteId(pedido.getClienteId());
        novaSimulacao.setValorInvestido(pedido.getValor());
        novaSimulacao.setValorFinal(valorFinal);
        novaSimulacao.setPrazoMeses(pedido.getPrazoMeses());
        novaSimulacao.setProdutoNome(produtoEscolhido.getNome());
        novaSimulacao.setDataSimulacao(LocalDateTime.now());

        simulacaoRepository.save(novaSimulacao);

        SimulacaoResponse.ProdutoValidado produtoDto = new SimulacaoResponse.ProdutoValidado(
                produtoEscolhido.getId(),
                produtoEscolhido.getNome(),
                produtoEscolhido.getTipo(),
                produtoEscolhido.getRentabilidade(),
                produtoEscolhido.getRisco()
        );

        SimulacaoResponse.ResultadoSimulacao resultadoDto = new SimulacaoResponse.ResultadoSimulacao(
                valorFinal,
                produtoEscolhido.getRentabilidade(),
                pedido.getPrazoMeses()
        );

        return new SimulacaoResponse(produtoDto, resultadoDto, LocalDateTime.now());
    }

    public List<Simulacao> listarTodasSimulacoes() {
        return simulacaoRepository.findAll();
    }
}