package br.com.vh.AppContatos.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.vh.AppContatos.model.Contato;
//import br.com.vh.AppContatos.repository.ContatosRepository;
import br.com.vh.AppContatos.service.ContatoService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AppContatoResource {
	
	@Autowired
	private ContatoService contatoService;

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
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Contato>> findById(@PathVariable Long id){
		Optional<Contato> idContato = contatoService.searchById(id);
		if(idContato == null) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(idContato);
		}
	}
	
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
	
	/*@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void removeContact(@PathVariable("id") Long id) {
		contatoService.searchById(id).map(contato -> {
			contatoService.removeId(contato.getId());
			return Void.TYPE;
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contact not found"));
	}*/
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		contatoService.removeId(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT); //204
	}
	
	@PutMapping
	public ResponseEntity<Contato> updateContact(@RequestBody Contato contato) {
	    Contato updatedContato = contatoService.uptade(contato);
	    if(updatedContato == null) {
	    	return ResponseEntity.badRequest().build();
	    }else {
	    	return ResponseEntity.ok(updatedContato);
	    }
	}

	
	
	
}
