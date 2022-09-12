package com.microservicos.microservicos.controller;

import com.microservicos.microservicos.service.RabbitMQService;
import constantes.RabbitMQConstantes;
import dto.PrecoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("preco")
public class PrecoController {

    @Autowired
    RabbitMQService rabbitMQService;

    @PutMapping
    private ResponseEntity alteraPreco(@RequestBody PrecoDto precoDto){
        this.rabbitMQService.enviaMensagem(RabbitMQConstantes.FILA_PRECO, precoDto);
        return new ResponseEntity(HttpStatus.OK);
    }

}
