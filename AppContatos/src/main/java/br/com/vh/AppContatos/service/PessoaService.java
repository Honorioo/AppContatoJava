package br.com.vh.AppContatos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vh.AppContatos.model.Pessoa;
import br.com.vh.AppContatos.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	
	public Pessoa saveUsuario(Pessoa pessoa){
		if(pessoa.getName() == null) {
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
	
	
	public Pessoa uptadeUsuario(Pessoa pessoa) {
		Optional<Pessoa> findUsuario = pessoaRepository.findById(pessoa.getId());
			
		if(findUsuario.isPresent()) {
			Pessoa uptdUsuario = findUsuario.get(); //setId
			uptdUsuario.setName(pessoa.getName());
			uptdUsuario.setEndereco(pessoa.getEndereco());
			uptdUsuario.setCidade(pessoa.getCidade());
			uptdUsuario.setCep(pessoa.getCep());
			uptdUsuario.setUf(pessoa.getUf());
			return pessoaRepository.save(uptdUsuario); //UPDATE
		}
		return pessoaRepository.save(pessoa); //INSERT		
	}
	
	public List<Pessoa> listUsuario(){
		return pessoaRepository.findAll();
	}
	
	public Optional<Pessoa> searchByIdUsuario(Long id){
		return pessoaRepository.findById(id);
	}
	
	public void removeIdUsuario(Long id) {
		pessoaRepository.deleteById(id);
	}
	
	
}
