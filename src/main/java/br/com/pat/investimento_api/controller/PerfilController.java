package br.com.pat.investimento_api.controller;

import br.com.pat.investimento_api.dto.PerfilResponse;
import br.com.pat.investimento_api.entity.Produto;
import br.com.pat.investimento_api.service.RecomendacaoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class PerfilController {

    private final RecomendacaoService service;

    public static long contadorConsultasPerfil = 0;

    public PerfilController(RecomendacaoService service) {
        this.service = service;
    }

    @PostMapping("/perfil-risco")
    public PerfilResponse analisarPerfil(@RequestBody br.com.pat.investimento_api.dto.PerfilRequest questionario) {
        contadorConsultasPerfil++;

        return service.identificarPerfil(questionario);
    }

    @GetMapping("/produtos-recomendados/{perfil}")
    public List<Produto> recomendar(@PathVariable String perfil) {
        return service.recomendarProdutos(perfil);
    }
}