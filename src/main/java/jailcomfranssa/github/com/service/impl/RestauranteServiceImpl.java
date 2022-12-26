package jailcomfranssa.github.com.service.impl;

import jailcomfranssa.github.com.model.entity.Cozinha;
import jailcomfranssa.github.com.model.entity.Restaurante;
import jailcomfranssa.github.com.repository.RestauranteRepository;
import jailcomfranssa.github.com.service.CozinhaService;
import jailcomfranssa.github.com.service.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestauranteServiceImpl implements RestauranteService {

    private final RestauranteRepository repository;
    private final CozinhaService cozinhaService;

    @Autowired
    public RestauranteServiceImpl(RestauranteRepository repository, CozinhaService cozinhaService) {
        this.repository = repository;
        this.cozinhaService = cozinhaService;
    }

    @Override
    public Restaurante save(Restaurante restaurante) {
        Long cozinhaId = restaurante.getCozinha().getId();
        Optional<Cozinha> cozinha = cozinhaService.listarPorId(cozinhaId);
        if (cozinha.isPresent()){
            restaurante.setCozinha(cozinha.get());
            return repository.save(restaurante);
        }else {
            throw new RuntimeException("Não encontrado cozinha com Id: " + cozinhaId);
        }
    }

    @Override
    public List<Restaurante> listar() {
        return null;
    }

    @Override
    public Optional<Restaurante> listarPorId(Long id) {
        return Optional.empty();
    }

    @Override
    public Restaurante atualizar(Long id, Restaurante restaurante) {
        return null;
    }

    @Override
    public String deletar(Long id) {
        return null;
    }
}
