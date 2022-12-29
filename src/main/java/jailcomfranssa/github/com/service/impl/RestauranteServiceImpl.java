package jailcomfranssa.github.com.service.impl;

import jailcomfranssa.github.com.model.entity.Cozinha;
import jailcomfranssa.github.com.model.entity.Restaurante;
import jailcomfranssa.github.com.repository.RestauranteRepository;
import jailcomfranssa.github.com.service.CozinhaService;
import jailcomfranssa.github.com.service.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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

    @Override
    public List<Restaurante> findByTaxaFreteBetween(BigDecimal taxaInicial, BigDecimal taxaFinal) {
        return repository.findByTaxaFreteBetween(taxaInicial,taxaFinal);
    }

    @Override
    public List<Restaurante> findByNomeCozinha(String nome, Long cozinhaId) {
        return repository.findByNomeContainsAndCozinhaId(nome,cozinhaId);
    }

    @Override
    public Optional<Restaurante> primeiroNome(String nome) {
        Optional<Restaurante> restaurante = repository.findFirstByNome(nome);
        if(restaurante.isEmpty()){
            throw new RuntimeException("Não encontrado Restaurante com nome: " + nome);
        }
        return restaurante;
    }

    @Override
    public List<Restaurante> top2PorNome(String nome) {
        return repository.findTop2ByNomeContaining(nome);
    }

    @Override
    public Boolean existe(String nome) {
        return repository.existsByNome(nome);
    }

    @Override
    public Integer contCozinha(Long id) {
        return repository.countByCozinhaId(id);
    }

    @Override
    public List<Restaurante> consultaNome(String nome, Long id) {
        return repository.consultarNome(nome,id);
    }

    @Override
    public List<Restaurante> consultaPorNome(String nome, Long id) {
        return repository.consultarPorNome(nome,id);
    }

    @Override
    public List<Restaurante> find(String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal) {
        return repository.find(nome,taxaFreteInicial,taxaFreteFinal);
    }
}
