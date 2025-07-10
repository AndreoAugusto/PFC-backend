package org.example.services;

import org.example.entidades.Fornecedor;
import org.example.repositories.FornecedorRepository;
import org.example.services.exceptions.ResourceNotFoundException;
import org.example.services.exceptions.ValueBigForAtributeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository repository;

    public List<Fornecedor> findAll()   {
        return repository.findAll();
    }

    public Fornecedor findById(Long id) {
        Fornecedor fornecedor = repository.findById(id).orElse(null);
        if(fornecedor == null)  {
            throw new ResourceNotFoundException(id);
        }
        return fornecedor;
    }

    public Fornecedor insert(Fornecedor obj)    {
        try {
            return obj = repository.save(obj);
        }catch(DataIntegrityViolationException e)   {
            throw new ValueBigForAtributeException(e.getMessage());
        }
    }

    public Fornecedor update(Long id, Fornecedor obj)   {
        try {
            Fornecedor fornecedor = findById(id);

            fornecedor.setNome_forn(obj.getNome_forn());
            fornecedor.setCnpj_forn(obj.getCnpj_forn());
            fornecedor.setTelefone_forn(obj.getTelefone_forn());
            fornecedor.setEmail_forn(obj.getEmail_forn());

            return repository.save(fornecedor);
        }catch(DataIntegrityViolationException e)   {
            throw new ValueBigForAtributeException(e.getMessage());
        }
    }

    public void deteleFornecedor(Long id)   {
        try {
            repository.deleteById(id);
        }catch(EmptyResultDataAccessException e)    {
            throw new ResourceNotFoundException(id);
        }
    }

}
