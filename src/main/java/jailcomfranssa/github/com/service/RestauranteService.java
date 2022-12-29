package jailcomfranssa.github.com.service;

import jailcomfranssa.github.com.model.entity.Restaurante;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public interface RestauranteService {

    Restaurante save(Restaurante restaurante);
    List<Restaurante> listar();
    Optional<Restaurante> listarPorId(Long id);
    Restaurante atualizar(Long id, Restaurante restaurante);
    String deletar(Long id);
    List<Restaurante> findByTaxaFreteBetween(BigDecimal taxaInicial, BigDecimal taxaFinal);
    List<Restaurante> findByNomeCozinha(String nome, Long cozinhaId);
    Optional<Restaurante> primeiroNome(String nome);
    List<Restaurante> top2PorNome(String nome);
    Boolean existe(String nome);
    Integer contCozinha(Long id);
    List<Restaurante> consultaNome(String nome, Long id);
    List<Restaurante> consultaPorNome(String nome, Long id);
}
