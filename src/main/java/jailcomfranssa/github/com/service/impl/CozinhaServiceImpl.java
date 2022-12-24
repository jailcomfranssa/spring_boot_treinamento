package jailcomfranssa.github.com.service.impl;

import jailcomfranssa.github.com.model.entity.Cozinha;
import jailcomfranssa.github.com.repository.ConzinhaRepository;
import jailcomfranssa.github.com.service.CozinhaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CozinhaServiceImpl implements CozinhaService {

    private ConzinhaRepository repository;

    @Autowired
    public CozinhaServiceImpl(ConzinhaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Cozinha save(Cozinha cozinha) {
        return repository.save(cozinha);
    }

    @Override
    public List<Cozinha> listar() {
        return repository.findAll();
    }

    @Override
    public Optional<Cozinha> listarPorId(Long id) {

        return repository.findById(id);
    }

    @Override
    public Cozinha atualizar(Cozinha cozinha, Long id) {
        return null;
    }

    @Override
    public Cozinha deletar(Long id) {
        return null;
    }
}
