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

    public PerfilResponse identificarPerfil(Long clienteId) {
        if (clienteId % 2 == 0) {
            return new PerfilResponse(clienteId, "Conservador", 25, "Prefere segurança.");
        } else {
            return new PerfilResponse(clienteId, "Agressivo", 85, "Busca alta rentabilidade.");
        }
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