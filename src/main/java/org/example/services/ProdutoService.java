package org.example.services;

import org.example.entidades.Cliente;
import org.example.entidades.Fornecedor;
import org.example.entidades.Produto;
import org.example.repositories.ProdutoRepository;
import org.example.services.exceptions.ResourceNotFoundException;
import org.example.services.exceptions.ValueBigForAtributeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public List<Produto> findAll()  {
        return repository.findAll();
    }

    public Produto findById(Long id)    {
        Produto produto = repository.findById(id).orElse(null);
        if(produto == null) {
            throw new ResourceNotFoundException(id);
        }
        return produto;
    }

    public Produto insert(Produto obj)  {
        try {
            return obj = repository.save(obj);
        }catch (DataIntegrityViolationException e)  {
            throw new ValueBigForAtributeException(e.getMessage());
        }
    }

    public Produto update(Long id, Produto obj) {
        try {
            Produto produto = findById(id);

            produto.setNome_prod(obj.getNome_prod());
            produto.setMarca_prod(obj.getMarca_prod());
            produto.setPreco_prod(obj.getPreco_prod());
            produto.setQtde_prod(obj.getQtde_prod());
            produto.setDescricao_prod(obj.getDescricao_prod());

            return repository.save(produto);
        }catch (DataIntegrityViolationException e)  {
            throw new ValueBigForAtributeException(e.getMessage());
        }
    }

    public void deleteProduto(Long id)  {
        try {
            repository.deleteById(id);
        }catch (EmptyResultDataAccessException e)   {
            throw new ResourceNotFoundException(id);
        }
    }


}
