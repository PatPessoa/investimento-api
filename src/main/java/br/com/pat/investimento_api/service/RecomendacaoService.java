package br.com.pat.investimento_api.service;

import br.com.pat.investimento_api.dto.PerfilResponse;
import br.com.pat.investimento_api.entity.Produto;
import br.com.pat.investimento_api.repository.ProdutoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RecomendacaoService {

    private final ProdutoRepository produtoRepository;

    public RecomendacaoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public PerfilResponse identificarPerfil(br.com.pat.investimento_api.dto.PerfilRequest req) {

        int score = req.getToleranciaRisco()
                + req.getHorizonte()
                + req.getConhecimentoFinanceiro()
                + req.getObjetivo()
                + req.getSituacaoFinanceira();

        String perfil;
        String descricao;

        if (score <= 20) {
            perfil = "Conservador";
            descricao = "Busca segurança e evita volatilidade.";
        } else if (score <= 40) {
            perfil = "Moderado";
            descricao = "Aceita algum risco por retornos melhores.";
        } else {
            perfil = "Agressivo";
            descricao = "Aceita volatilidade para tentar retornos altos.";
        }

        return new PerfilResponse(req.getClienteId(), perfil, score, descricao);
    }
    public List<Produto> recomendarProdutos(String perfil) {
        if ("Conservador".equalsIgnoreCase(perfil)) {
            return produtoRepository.findByRisco("Baixo");
        }
        else if ("Agressivo".equalsIgnoreCase(perfil)) {
            return produtoRepository.findByRisco("Alto");
        }
        return produtoRepository.findAll();
    }
}