package br.com.pat.investimento_api.repository;

import br.com.pat.investimento_api.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    java.util.List<Produto> findByRisco(String risco);
}