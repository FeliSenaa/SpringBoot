package edu.tienda.core.controllers;

import edu.tienda.core.domain.Cliente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class ClienteRestController {

    private List<Cliente> clientes = new ArrayList<>(Arrays.asList(
            new Cliente("arm","1234","Armstrong"),
            new Cliente("ald","1234","Aldrin"),
            new Cliente("col","1234","Collins"),
            new Cliente("bol","1234","Bola")
    ));

    @GetMapping("/clientes")
    public List<Cliente> getClientes(){
        return clientes;
    }

    @GetMapping("/clientes/{username}")
    public Cliente getCliente (@PathVariable String username){
      return clientes.stream().filter(cliente -> cliente.getUsername().equalsIgnoreCase(username)).findFirst().orElseThrow();
    }
}
