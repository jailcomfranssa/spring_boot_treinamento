package jailcomfranssa.github.com.repository;

import jailcomfranssa.github.com.model.entity.Cozinha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CozinhaRepository extends JpaRepository<Cozinha, Long> {
    List<Cozinha> findByNome(String nome);
    List<Cozinha> findByNomeContaining(String nome);
}
