package jailcomfranssa.github.com.repository.spec;

import jailcomfranssa.github.com.model.entity.Restaurante;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.io.Serial;
import java.math.BigDecimal;

public class RestauranteComNomeSemelhanteSpec implements Specification<Restaurante> {
    @Serial
    private static final long serialVersionUID =1L;

    private final String nome;

    public RestauranteComNomeSemelhanteSpec(String nome) {
        this.nome = nome;
    }

    @Override
    public Predicate toPredicate(Root<Restaurante> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.like(root.get("nome"), "%" + nome + "%");
    }
}
































































