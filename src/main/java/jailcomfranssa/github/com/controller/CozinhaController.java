package jailcomfranssa.github.com.controller;

import jailcomfranssa.github.com.model.entity.Cozinha;
import jailcomfranssa.github.com.model.wrapper.CozinhasWrapper;
import jailcomfranssa.github.com.service.CozinhaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/cozinhas",
        produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
public class CozinhaController {

    private final CozinhaService cozinhaService;

    @Autowired
    public CozinhaController(CozinhaService cozinhaService) {
        this.cozinhaService = cozinhaService;
    }

    @GetMapping()
    public ResponseEntity<List<Cozinha>> listar(@RequestParam(value = "nome", required = false) String nome){
        return new ResponseEntity<>(cozinhaService.listar(nome),HttpStatus.OK);
    }
//    @GetMapping()
//    public CozinhasWrapper listarXml(){
//        return new CozinhasWrapper(cozinhaService.listar());
//    }
    @PostMapping()
    public ResponseEntity<Cozinha> save(@RequestBody Cozinha cozinha){
        Cozinha cozinhaSave = cozinhaService.save(cozinha);
        return new ResponseEntity<>(cozinhaSave, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Cozinha>> listById(@PathVariable Long id){
        return new ResponseEntity<>(cozinhaService.listarPorId(id),HttpStatus.OK);

    }
    @PutMapping("/{id}")
    public ResponseEntity<Cozinha> update(@PathVariable Long id, @RequestBody Cozinha cozinha){
        return new ResponseEntity<>(cozinhaService.atualizar(cozinha,id),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        return new ResponseEntity<>(cozinhaService.deletar(id),HttpStatus.NO_CONTENT);

    }
}





















































