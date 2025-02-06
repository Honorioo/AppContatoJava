package br.com.vh.AppContatos.resource;

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
	
	/*@Autowired
	private ContatosRepository contatoRepository;*/

	
	@GetMapping//http://localhost:8080/api
	public String getApi() {
		return "Api funcionando";
	}
		

	@GetMapping("listar")
	@ResponseStatus(HttpStatus.OK)
	public List<Contato> listar(){
		//List<Contato> listProdutos = contatoRepository.findAll();		
		return contatoService.listCtt();
	}	
	
	/*@PostMapping("cadastrar")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Contato> salvarContato(@RequestBody Contato contato) {
	    Contato novoContato = contatoService.saveCtt(contato);
	    return ResponseEntity.status(HttpStatus.CREATED).body(novoContato);
	}*/

	@PostMapping("cadastrar")
	@ResponseStatus(HttpStatus.CREATED)
	public Contato salvarContato(@RequestBody Contato contato) {
	    return contatoService.saveCtt(contato);

	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void removerCliente(@PathVariable("id") Long id) {
		contatoService.searchById(id).map(contato -> {
			contatoService.removeId(contato.getId());
			return Void.TYPE;
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contato não encontrado"));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> atualizarContato(@PathVariable("id") Long id, @RequestBody Contato contato) {
	    Optional<Contato> updatedContato = contatoService.savePutCtt(id, contato);

	    return updatedContato
	            .map(value -> ResponseEntity.ok().body(value)) 
	            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contato não encontrado"));
	}

	
	
}
