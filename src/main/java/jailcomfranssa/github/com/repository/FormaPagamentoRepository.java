package jailcomfranssa.github.com.repository;

import jailcomfranssa.github.com.model.entity.FormaPagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormaPagamentoRepository extends JpaRepository<FormaPagamento,Long> {
}
