package jailcomfranssa.github.com.controller;

import jailcomfranssa.github.com.model.entity.Restaurante;
import jailcomfranssa.github.com.service.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/restaurantes")
public class RestauranteController {

    private final RestauranteService restauranteService;

    @Autowired
    public RestauranteController(RestauranteService restauranteService) {
        this.restauranteService = restauranteService;
    }

    @PostMapping()
    public ResponseEntity<Restaurante> save(@RequestBody Restaurante restaurante){
        return new ResponseEntity<>(restauranteService.save(restaurante), HttpStatus.OK);

    }
}
