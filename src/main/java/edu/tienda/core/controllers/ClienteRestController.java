package edu.tienda.core.controllers;

import edu.tienda.core.domain.Cliente;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteRestController {

    private List<Cliente> clientes = new ArrayList<>(Arrays.asList(
            new Cliente("arm","1234","Armstrong"),
            new Cliente("ald","1234","Aldrin"),
            new Cliente("col","1234","Collins"),
            new Cliente("bol","1234","Bola")
    ));

    @GetMapping()
    public List<Cliente> getClientes(){
        return clientes;
    }

    @GetMapping("/{username}")
    public Cliente getCliente (@PathVariable String username){
      return clientes.stream().filter(cliente -> cliente.getUsername().equalsIgnoreCase(username)).
              findFirst().orElseThrow();
    }

    @PostMapping()
    public Cliente altaCliente(@RequestBody Cliente cliente){
        clientes.add(cliente);
        return cliente;
    }

    @PutMapping()
    public Cliente modificacionCliente (@RequestBody Cliente cliente){
        Cliente clienteEncontrado = clientes.stream().filter(cli -> cli.getUsername().equalsIgnoreCase(cliente.getUsername())).findFirst().orElseThrow();
        clienteEncontrado.setPassword(cliente.getPassword());
        clienteEncontrado.setNombre(cliente.getNombre());
        return clienteEncontrado;
    }

    @DeleteMapping("/{username}")
    public void deleteCliente (@PathVariable String username){
        Cliente clienteEncontrado = clientes.stream().filter(cli -> cli.getUsername().equalsIgnoreCase(username)).findFirst().orElseThrow();
        clientes.remove(clienteEncontrado);

    }


}
