package br.com.pat.investimento_api.controller;

import br.com.pat.investimento_api.entity.Produto;
import br.com.pat.investimento_api.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoRepository repositorio;

    // O repositório entrará aqui
    public ProdutoController(ProdutoRepository repositorio) {
        this.repositorio = repositorio;
    }

    @GetMapping
    public List<Produto> listarTodos() {
        return repositorio.findAll();
    }
}