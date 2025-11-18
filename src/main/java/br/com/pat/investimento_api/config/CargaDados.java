package br.com.pat.investimento_api.config;

import br.com.pat.investimento_api.entity.Produto;
import br.com.pat.investimento_api.repository.ProdutoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CargaDados {

    @Bean
    CommandLineRunner executar(ProdutoRepository repositorio) {
        return args -> {
            // Se já tiver dados, não fará nada p/ não ter duplicidade
            if (repositorio.count() > 0) {
                return;
            }

            Produto p1 = new Produto();
            p1.setNome("CDB Caixa 2026");
            p1.setTipo("CDB");
            p1.setRentabilidade(0.12);
            p1.setRisco("Baixo");
            p1.setPrazoMinimo(12);

            repositorio.save(p1);

            Produto p2 = new Produto();
            p2.setNome("Fundo XPTO");
            p2.setTipo("Fundo");
            p2.setRentabilidade(0.18);
            p2.setRisco("Alto");
            p2.setPrazoMinimo(24);

            repositorio.save(p2);

            System.out.println("---------------------------------");
            System.out.println("PRODUTOS CARREGADOS COM SUCESSO!");
            System.out.println("---------------------------------");
        };
    }
}