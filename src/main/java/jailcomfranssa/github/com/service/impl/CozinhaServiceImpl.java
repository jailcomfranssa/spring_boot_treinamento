package jailcomfranssa.github.com.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import jailcomfranssa.github.com.model.entity.Cozinha;
import jailcomfranssa.github.com.repository.CozinhaRepository;
import jailcomfranssa.github.com.service.CozinhaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CozinhaServiceImpl implements CozinhaService {

    private final CozinhaRepository repository;

    @Autowired
    public CozinhaServiceImpl(CozinhaRepository repository) {
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
        Optional<Cozinha> cozinha = repository.findById(id);
        if (cozinha.isEmpty()){
            throw new RuntimeException("Não encontrado cozinha com Id: " + id);
        }
        return cozinha;
    }

    @Override
    public Cozinha atualizar(Cozinha cozinha, Long id) {
        Optional<Cozinha> cozinhaData = listarPorId(id);
        if (cozinhaData.isPresent()){
            Cozinha _cozinha = cozinhaData.get();
            _cozinha.setNome(cozinha.getNome());
            return repository.save(_cozinha);
        }else {
            throw new RuntimeException("Cozinha Id: "+ id + "Não encontrada");
        }

    }

    @Override
    public String deletar(Long id) {
        Optional<Cozinha> cozinha = listarPorId(id);
        if (cozinha.isEmpty()){
            throw new RuntimeException("Não encontrado cozinha com Id: " + id);
        }
        repository.deleteById(id);
        return "";
    }

    @Override
    public Cozinha atualizarParcial(Map<String, Object> campos, Long id) {
        Optional<Cozinha> cozinhaOptional = listarPorId(id);
        if (cozinhaOptional.isEmpty()){
            throw new RuntimeException("Não encontrado cozinha com Id: " + id);
        }
        merge(campos,cozinhaOptional);

        return null;
    }

    private void merge(Map<String, Object> camposOrigem, Optional<Cozinha> cozinha){

        ObjectMapper objectMapper = new ObjectMapper();
        Cozinha cozinhaOrigem = objectMapper.convertValue(camposOrigem, Cozinha.class);

        camposOrigem.forEach((nomePropriedade, valorPropriedade)->{
            Field field = ReflectionUtils.findField(Cozinha.class, nomePropriedade);
            assert field != null;
            field.setAccessible(true);

            Object novoValor = ReflectionUtils.getField(field, cozinhaOrigem);

            ReflectionUtils.setField(field, cozinha, novoValor);

        });

    }
}

















































