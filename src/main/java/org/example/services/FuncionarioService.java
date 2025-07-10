package org.example.services;

import org.example.entidades.Funcionario;
import org.example.repositories.FuncionarioRepository;
import org.example.services.exceptions.ResourceNotFoundException;
import org.example.services.exceptions.ValueBigForAtributeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    public List<Funcionario> findall()  {
        return repository.findAll();
    }

    public Funcionario findById(Long id)    {
        Funcionario funcionario = repository.findById(id).orElse(null);
        if(funcionario == null) {
            throw new ResourceNotFoundException(id);
        }
        return funcionario;
    }

    public Funcionario insert(Long id, Funcionario obj) {
        try {
            return obj = repository.save(obj);
        }catch (DataIntegrityViolationException e)  {
            throw new ValueBigForAtributeException(e.getMessage());
        }
    }

    public Funcionario update(Long id, Funcionario obj) {
        try {
            Funcionario funcionario = findById(id);

            funcionario.setNome_func(obj.getNome_func());
            funcionario.setCpf_func(obj.getCpf_func());
            funcionario.setCargo_func(obj.getCargo_func());
            return repository.save(funcionario);
        } catch (DataIntegrityViolationException e) {
            throw new ValueBigForAtributeException(e.getMessage());
        }
    }

    public void deleteFuncionario(Long id)  {
        try {
            repository.deleteById(id);
        }catch (DataIntegrityViolationException e) {
            throw new ValueBigForAtributeException(e.getMessage());
        }
    }
}
