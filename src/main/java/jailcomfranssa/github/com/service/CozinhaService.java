package jailcomfranssa.github.com.service;

import jailcomfranssa.github.com.model.entity.Cozinha;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CozinhaService {

    public Cozinha save(Cozinha cozinha);
    public List<Cozinha> listar();
    public Optional<Cozinha> listarPorId(Long id);
    public Cozinha atualizar(Cozinha cozinha, Long id);
    public Cozinha deletar(Long id);
}
