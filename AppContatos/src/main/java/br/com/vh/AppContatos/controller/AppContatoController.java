package br.com.vh.AppContatos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.vh.AppContatos.model.Contato;
import br.com.vh.AppContatos.service.ContatoService;
import io.swagger.v3.oas.annotations.Operation;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/contato")
public class AppContatoController {
	
	@Autowired
	private ContatoService contatoService;
	
	@Operation(summary = "Busca pela lista de contatos com as Pessoas associadas")
	@GetMapping
	public ResponseEntity<List<Contato>> list(){
		List<Contato> listContato = contatoService.listCtt();		
		if(listContato == null) {
			return ResponseEntity.badRequest().build();
		}
		if(listContato.size() == 0) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(listContato);
	}	
	
	@Operation(summary = "Busca pelo Contato por ID com as Pessoas associadas")
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Contato>> findById(@PathVariable Long id){
		Optional<Contato> idContato = contatoService.searchById(id);
		if(idContato == null) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(idContato);
		}
	}
	
	@Operation(summary = "Criação do Contato, não esqueça de passar o ID da Pessoa que será associada")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Contato> saveContact(@RequestBody Contato contato) {
		Contato newCtt = contatoService.saveCtt(contato);
		if(newCtt == null) {
			return ResponseEntity.notFound().build();
		}
		else {
			return ResponseEntity.ok(newCtt);
		}
	}
	
	@Operation(summary = "Deleta o Contato")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		contatoService.removeId(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT); //204
	}
	
	@Operation(summary = "Atualiza o Contato, não se esqueça de passar o ID do contato que deseja ser apagado")
	@PutMapping("/{id}")
	public ResponseEntity<Contato> updateContact(@RequestBody Contato contato) {
	    Contato updatedContato = contatoService.uptade(contato);
	    if(updatedContato == null) {
	    	return ResponseEntity.badRequest().build();
	    }else {
	    	return ResponseEntity.ok(updatedContato);
	    }
	}

}
