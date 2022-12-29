package jailcomfranssa.github.com.controller;

import jailcomfranssa.github.com.model.entity.Restaurante;
import jailcomfranssa.github.com.service.CozinhaService;
import jailcomfranssa.github.com.service.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/restaurantes")
public class RestauranteController {

    private final RestauranteService restauranteService;
    private final CozinhaService cozinhaService;

    @Autowired
    public RestauranteController(RestauranteService restauranteService, CozinhaService cozinhaService) {
        this.restauranteService = restauranteService;
        this.cozinhaService = cozinhaService;
    }

    @PostMapping()
    public ResponseEntity<Restaurante> save(@RequestBody Restaurante restaurante){
        return new ResponseEntity<>(restauranteService.save(restaurante), HttpStatus.OK);
    }

    @GetMapping("/por-taxa-frete")
    public ResponseEntity<List<Restaurante>> restaurantesPorTaxaFrete(BigDecimal taxaInicial, BigDecimal taxaFinal){
        return new ResponseEntity<>(restauranteService.findByTaxaFreteBetween(taxaInicial,taxaFinal),HttpStatus.OK);
    }

    @GetMapping("/por-nome/cozinha")
    public ResponseEntity<List<Restaurante>> restaurantePorNomeCozinha(String nome, Long cozinhaId){
        return new ResponseEntity<>(restauranteService.findByNomeCozinha(nome,cozinhaId),HttpStatus.OK);
    }

    @GetMapping("/primeiro-por-nome")
    public ResponseEntity<Optional<Restaurante>> pesquisarPrimeiroPorNome(String nome){
        return new ResponseEntity<>(restauranteService.primeiroNome(nome),HttpStatus.OK);
    }

    @GetMapping("/top2-por-nome")
    public ResponseEntity<List<Restaurante>> top2PorNome(String nome){
        return new ResponseEntity<>(restauranteService.top2PorNome(nome), HttpStatus.OK);

    }

    @GetMapping("existe")
    public ResponseEntity<Boolean> restauranteExiste(String nome){
        return new ResponseEntity<>(restauranteService.existe(nome),HttpStatus.OK);

    }

    @GetMapping("/cont-cozinha")
    public ResponseEntity<Integer> conteCozinha(Long id){
        return new ResponseEntity<>(restauranteService.contCozinha(id),HttpStatus.OK);
    }

    @GetMapping("/consulta-nome")
    public ResponseEntity<List<Restaurante>> consultaNome(String nome, Long id){
        return new ResponseEntity<>(restauranteService.consultaNome(nome, id),HttpStatus.OK);

    }

    @GetMapping("/consulta-por-nome")
    public ResponseEntity<List<Restaurante>> consultaPorNome(String nome, Long id){
        return new ResponseEntity<>(restauranteService.consultaPorNome(nome, id),HttpStatus.OK);

    }
}























