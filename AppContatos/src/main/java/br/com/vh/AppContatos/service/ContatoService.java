package br.com.vh.AppContatos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vh.AppContatos.model.Contato;
import br.com.vh.AppContatos.model.Pessoa;
import br.com.vh.AppContatos.repository.ContatosRepository;
import br.com.vh.AppContatos.repository.PessoaRepository;

@Service
public class ContatoService {
	
	@Autowired
	private ContatosRepository contatoRepository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
		public Contato saveCtt(Contato contato) {		
		if(contato.getPessoa().getId() != null) {
			Optional<Pessoa> findPessoa = pessoaRepository
					.findById(contato.getPessoa().getId());
			if(findPessoa.isEmpty()) {
				System.out.println("Contato não encontrado");
				return null;
			}else {
				contato.setPessoa(findPessoa.get());
				return contatoRepository.save(contato);
			}			
		}else {
			System.out.println("Contato nulo");
			return null;
		}		
	}
	
		
	public Contato uptade(Contato contato) {
		Optional<Contato> findContato = contatoRepository.findById(contato.getId());
		
		if(findContato.isPresent()) {
			Contato uptdContato = findContato.get(); //setId
			uptdContato.setNome(contato.getNome()); //veio por parametro
			uptdContato.setContato(contato.getContato());
			uptdContato.setTipoContato(contato.getTipoContato());
			return contatoRepository.save(uptdContato); //UPDATE
		}
		return contatoRepository.save(contato); //INSERT		
	}
	
	
	public List<Contato> listCtt(){
		return contatoRepository.findAll();
	}
	
	public Optional<Contato> searchById(Long id){
		return contatoRepository.findById(id);
	}
	
	public void removeId(Long id) {
		contatoRepository.deleteById(id);
	}
}
