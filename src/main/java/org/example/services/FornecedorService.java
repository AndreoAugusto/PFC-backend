package org.example.services;

import org.example.dto.FornecedorDTO;
import org.example.entities.Contato;
import org.example.entities.Endereco;
import org.example.entities.Fornecedor;
import org.example.repositories.EnderecoRepository;
import org.example.repositories.FornecedorRepository;
import org.example.services.exeptions.ResourceNotFoundException;
import org.example.services.exeptions.ValueBigForAtributeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository repository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<Fornecedor> findAll(){
        return repository.findAll();
    }

    public Fornecedor findById(Long id){
        Optional<Fornecedor> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Fornecedor insert(Fornecedor obj){
        try {
            obj.setForId(null);
            obj = repository.save(obj);
            enderecoRepository.saveAll(obj.getEnderecos());
            return obj;
        }catch (DataIntegrityViolationException e){
            throw new ValueBigForAtributeException(e.getMessage());
        }
    }

    public Fornecedor update(Long id, FornecedorDTO objDto){
        try {
            Fornecedor entity = findById(id);
            entity.setForNomeFantasia(objDto.getForNomeFantasia());
            entity.setForCnpj(objDto.getForCnpj());

            Endereco endereco = entity.getEnderecos().get(0);

            endereco.setEndRua(objDto.getEndRua());
            endereco.setEndNumero(objDto.getEndNumero());
            endereco.setEndCidade(objDto.getEndCidade());
            endereco.setEndCep(objDto.getEndCep());
            endereco.setEndEstado(objDto.getEndEstado());

            Contato contato = entity.getContatos().get(0);

            contato.setConCelular(objDto.getConCelular());
            contato.setConTelefoneComercial(objDto.getConTelefoneComercial());
            contato.setConEmail(objDto.getConEmail());

            repository.save(entity);
            return entity;
        }catch (DataIntegrityViolationException e){
            throw new ValueBigForAtributeException(e.getMessage());
        }
    }

    public void deleteFornecedor(Long id){
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id);
        }
    }

    public Fornecedor fromDTO(FornecedorDTO objDto) {
        Fornecedor fornecedor = new Fornecedor(null, objDto.getForNomeFantasia(), objDto.getForCnpj(), objDto.getForRazaoSocial());

        Endereco endereco = new Endereco(null, fornecedor, objDto.getEndRua(), objDto.getEndNumero(), objDto.getEndCidade(), objDto.getEndCep(), objDto.getEndEstado());

        Contato contato = new Contato(null, fornecedor, objDto.getConCelular(), objDto.getConTelefoneComercial(), objDto.getConEmail());

        fornecedor.getEnderecos().add(endereco);
        fornecedor.getContatos().add(contato);

        return  fornecedor;

    }

    public FornecedorDTO toNewDTO(Fornecedor obj){
        FornecedorDTO dto = new FornecedorDTO();

        dto.setForId(obj.getForId());
        dto.setForNomeFantasia(obj.getForNomeFantasia());
        dto.setForCnpj(obj.getForCnpj());
        dto.setForRazaoSocial(obj.getForRazaoSocial());

        Endereco endereco = obj.getEnderecos().get(0);
        dto.setEndRua(endereco.getEndRua());
        dto.setEndNumero(endereco.getEndNumero());
        dto.setEndCidade(endereco.getEndCidade());
        dto.setEndCep(endereco.getEndCep());
        dto.setEndEstado(endereco.getEndEstado());

        Contato contato = obj.getContatos().get(0);
        dto.setConCelular(contato.getConCelular());
        dto.setConTelefoneComercial(contato.getConTelefoneComercial());
        dto.setConEmail(contato.getConEmail());

        return dto;
    }



}
