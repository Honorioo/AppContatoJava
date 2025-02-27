package br.com.vh.AppContatos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vh.AppContatos.dto.MalaDiretaDto;
import br.com.vh.AppContatos.model.Pessoa;
import br.com.vh.AppContatos.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	
	public Pessoa saveUsuario(Pessoa pessoa){
		if(pessoa.getNome() == null) {
			System.out.println("O nome está vazio.");
			return null;
		}
		
		if(pessoa.getEndereco() == null) {
			System.out.println("Endereço está vazio.");
			return null;
		}
		
		if(pessoa.getCidade() == null) {
			System.out.println("Campo cidade está vazio");
			return null;
		}
		
		if(pessoa.getCep() == null) {
			System.out.println("CEP está vazio");
			return null;
		}
		
		if(pessoa.getUf() == null) {
			System.out.println("UF está vazio");
			return null;
		}
		
		try {
			return pessoaRepository.save(pessoa);
		}catch (Exception e) {
			System.out.println("Erro ao inserir Pessoa " + 
					pessoa.toString() + ": " + e.getMessage());
			return null;
		}
	}

	
	
	public Optional<MalaDiretaDto> updateUsuario(Pessoa pessoa) {
	    return pessoaRepository.findById(pessoa.getId()).map(usuarioEncontrado -> {
	        usuarioEncontrado.setNome(pessoa.getNome());
	        usuarioEncontrado.setEndereco(pessoa.getEndereco());
	        usuarioEncontrado.setCidade(pessoa.getCidade());
	        usuarioEncontrado.setCep(pessoa.getCep());
	        usuarioEncontrado.setUf(pessoa.getUf());

	        Pessoa usuarioAtualizado = pessoaRepository.save(usuarioEncontrado);
	        return MalaDiretaDto.fromEntity(usuarioAtualizado); 
	    });
	}

	
	public List<MalaDiretaDto> listPessoa() {
	    return pessoaRepository.findAll()
	        .stream()
	        .map(MalaDiretaDto::fromEntity)
	        .toList();
	}
		
	public Optional<MalaDiretaDto> searchByIdPessoa(Long id) {
	    return pessoaRepository.findById(id)
	        .map(MalaDiretaDto::fromEntity);
	}
	
	public void removeIdPessoa(Long id) {
		pessoaRepository.deleteById(id);
	}

	
}
