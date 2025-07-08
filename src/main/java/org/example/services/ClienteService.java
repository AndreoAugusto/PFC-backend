package org.example.services;

import org.example.entidades.Cliente;
import org.example.repositories.ClienteRepository;
import org.example.services.exceptions.ResourceNotFoundException;
import org.example.services.exceptions.ValueBigForAtributeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public List<Cliente> findall()  {
        return repository.findAll();
    }

    public Cliente findById(Long id) {
        Cliente cliente = repository.findById(id).orElse(null);
        if (cliente == null) {
            throw new ResourceNotFoundException(id);
        }
        return cliente;
    }

    public Cliente insert(Cliente obj)  {
        try {
            return obj = repository.save(obj);
        }catch (DataIntegrityViolationException e)  {
            throw new ValueBigForAtributeException(e.getMessage());
        }
    }

    public Cliente update(Long id, Cliente obj) {
        try {
            Cliente cliente = findById(id);

            cliente.setNome_cli(obj.getNome_cli());
            cliente.setCpf_cli(obj.getCpf_cli());
            cliente.setTelefone_cli(obj.getTelefone_cli());
            cliente.setEmail_cli(obj.getEmail_cli());

            return repository.save(cliente);
        }catch (DataIntegrityViolationException e)  {
            throw new ValueBigForAtributeException(e.getMessage());
        }
    }

    public void deleteCliente(Long id)  {
        try {
            repository.deleteById(id);
        }catch (EmptyResultDataAccessException e)   {
            throw new ResourceNotFoundException(id);
        }
    }

}
