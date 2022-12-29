package jailcomfranssa.github.com.repository;

import jailcomfranssa.github.com.model.entity.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {

    @Query("from Restaurante where nome like %:nome% and cozinha.id = :cozinhaId")
    List<Restaurante> consultarNome(String nome, Long cozinhaId);
    List<Restaurante> consultarPorNome(String nome, @Param("id") Long cozinhaId);
    List<Restaurante> findByTaxaFreteBetween(BigDecimal taxaInicial, BigDecimal taxaFinal);
    List<Restaurante> findByNomeContainsAndCozinhaId(String nome, Long cozinhaId);
    Optional<Restaurante> findFirstByNome(String nome);
    List<Restaurante> findTop2ByNomeContaining(String nome);
    boolean existsByNome(String nome);
    int countByCozinhaId(Long cozinhaId);

}













































