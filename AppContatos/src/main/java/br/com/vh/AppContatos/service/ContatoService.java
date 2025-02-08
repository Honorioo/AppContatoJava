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
		if(contato.getName() == null) {
			
		}
		
		if(contato.getNumberTel() == null) {
			
		}try {
			return contatoRepository.save(contato);
		}catch (Exception e) {
			System.out.println("Erro ao inserir produto " + 
                    contato.toString() + ": " + e.getMessage());
			return null;
		}
		

	}
	
	
	public Contato uptade(Contato contato) {
		Optional<Contato> findContato = contatoRepository.findById(contato.getId());
		
		if(findContato.isPresent()) {
			Contato updProduto = findContato.get(); //setId
			updProduto.setName(contato.getName()); //veio por parametro
			updProduto.setNumberTel(contato.getNumberTel());
			return contatoRepository.save(updProduto); //UPDATE
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
