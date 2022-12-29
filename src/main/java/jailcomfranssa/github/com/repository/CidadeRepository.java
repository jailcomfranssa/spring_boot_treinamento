package jailcomfranssa.github.com.repository;

import jailcomfranssa.github.com.model.entity.Cidade;
import lombok.extern.java.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {
}
