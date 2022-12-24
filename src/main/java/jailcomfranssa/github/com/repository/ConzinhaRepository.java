package jailcomfranssa.github.com.repository;

import jailcomfranssa.github.com.model.entity.Cozinha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConzinhaRepository extends JpaRepository<Cozinha, Long> {
}
