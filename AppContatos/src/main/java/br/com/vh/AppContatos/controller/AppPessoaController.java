package br.com.vh.AppContatos.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.vh.AppContatos.dto.MalaDiretaDto;
import br.com.vh.AppContatos.model.Pessoa;
import br.com.vh.AppContatos.service.PessoaService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("api/pessoa")
@CrossOrigin(origins = "http://localhost:4200") 
public class AppPessoaController {

	@Autowired
	private PessoaService pessoaService;
	
	@Operation(summary = "Busca pela lista de Pessoas cadastradas")
	@GetMapping
	public ResponseEntity<List<MalaDiretaDto>> listPessoa(){
		List<MalaDiretaDto> listUsuario = pessoaService.listPessoa();		
		if(listUsuario == null) {
			return ResponseEntity.badRequest().build();
		}
		if(listUsuario.size() == 0) {
			return ResponseEntity.notFound().build();
		}
			    
	    return ResponseEntity.ok(listUsuario);
	}
	  
	@Operation(summary = "Busca pela Pessoas por ID")
	@GetMapping("/maladireta/{id}")
	public ResponseEntity<Optional<MalaDiretaDto>> findById(@PathVariable Long id){
		Optional<MalaDiretaDto> idUsuario = pessoaService.searchByIdPessoa(id);
		if(idUsuario == null) {
			return ResponseEntity.notFound().build();
		}
	
		return ResponseEntity.ok(idUsuario);
	}
	
	@Operation(summary = "Criação de Pessoa")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Pessoa> saveContact(@RequestBody Pessoa pessoa) {
		Pessoa newUsuario = pessoaService.saveUsuario(pessoa);
		if(newUsuario == null) {
			return ResponseEntity.notFound().build();
		}
		else {
			return ResponseEntity.ok(newUsuario);
		}
	}
	

	@Operation(summary = "Atualiza Pessoa cadastrada")
	@PutMapping("/{id}")
	public ResponseEntity<MalaDiretaDto> updateContact(@PathVariable Long id, @RequestBody Pessoa pessoa) {
	    Optional<MalaDiretaDto> updatedUsuario = pessoaService.updateUsuario(pessoa);

	    return updatedUsuario
	        .map(ResponseEntity::ok)
	        .orElseGet(() -> ResponseEntity.notFound().build());
	}

	
	@Operation(summary = "Deleta Pessoa cadastrada")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		pessoaService.removeIdPessoa(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT); //204
	}
	
}
