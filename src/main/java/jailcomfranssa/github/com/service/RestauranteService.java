package jailcomfranssa.github.com.service;

import jailcomfranssa.github.com.model.entity.Restaurante;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface RestauranteService {

    Restaurante save(Restaurante restaurante);
    List<Restaurante> listar();
    Optional<Restaurante> listarPorId(Long id);
    Restaurante atualizar(Long id, Restaurante restaurante);
    String deletar(Long id);
}
