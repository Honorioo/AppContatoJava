package br.com.vh.AppContatos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vh.AppContatos.model.Contato;
import br.com.vh.AppContatos.repository.ContatosRepository;

@Service
public class ContatoService {
	
	@Autowired
	private ContatosRepository contatoRepository;
	
	public Contato saveCtt(Contato contato) {
		return contatoRepository.save(contato);
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
