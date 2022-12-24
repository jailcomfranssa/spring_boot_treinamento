package jailcomfranssa.github.com.controller;

import jailcomfranssa.github.com.model.entity.Cozinha;
import jailcomfranssa.github.com.service.CozinhaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/cozinhas",
        produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
public class CozinhaController {

    private CozinhaService cozinhaService;

    @Autowired
    public CozinhaController(CozinhaService cozinhaService) {
        this.cozinhaService = cozinhaService;
    }

    @GetMapping()
    public List<Cozinha> listar(){
        return cozinhaService.listar();
    }
}





















































