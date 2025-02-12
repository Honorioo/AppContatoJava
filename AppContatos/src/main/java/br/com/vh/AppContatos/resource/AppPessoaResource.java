package br.com.vh.AppContatos.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

import br.com.vh.AppContatos.dto.MalaDiretaDto;
import br.com.vh.AppContatos.model.Pessoa;
import br.com.vh.AppContatos.service.PessoaService;

@RestController
@RequestMapping("api/pessoa")
public class AppPessoaResource {

	@Autowired
	private PessoaService pessoaService;
	
	@GetMapping
	public ResponseEntity<List<MalaDiretaDto>> listUsuario(){
		List<Pessoa> listUsuario = pessoaService.listUsuario();		
		if(listUsuario == null) {
			return ResponseEntity.badRequest().build();
		}
		if(listUsuario.size() == 0) {
			return ResponseEntity.notFound().build();
		}
		
	    List<MalaDiretaDto> malaDiretaList = new ArrayList<>();
 
	
		for(Pessoa pessoa : listUsuario) {
			
			String enderecoCompleto = pessoa.getEndereco() + " - " 
					  + pessoa.getCep()    + " - " 
					  + pessoa.getCidade() + "/" 
					  + pessoa.getUf();
			
		    MalaDiretaDto malaDiretaDto = new MalaDiretaDto(
			        pessoa.getId(), 
			        pessoa.getName(), 
			        enderecoCompleto
			    );
		    
		    malaDiretaList.add(malaDiretaDto);
		}
	    
		return ResponseEntity.ok(malaDiretaList);
	}

	@GetMapping("/maladireta/{id}")
	public ResponseEntity<MalaDiretaDto> findById(@PathVariable Long id){
		Optional<Pessoa> idUsuario = pessoaService.searchByIdUsuario(id);
		if(idUsuario == null) {
			return ResponseEntity.notFound().build();
		}
		
		Pessoa pessoa = idUsuario.get();
		
		String enderecoCompleto = pessoa.getEndereco() + " - " 
								  + pessoa.getCep()    + " - " 
								  + pessoa.getCidade() + "/" 
								  + pessoa.getUf();
		
	    MalaDiretaDto malaDiretaDto = new MalaDiretaDto(
		        pessoa.getId(), 
		        pessoa.getName(), 
		        enderecoCompleto
		    );
		    
		return ResponseEntity.ok(malaDiretaDto);
	}
	
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
	

	@PutMapping
	public ResponseEntity<Pessoa> updateContact(@RequestBody Pessoa pessoa) {
	    Pessoa updatedUsuario = pessoaService.uptadeUsuario(pessoa);
	    if(updatedUsuario == null) {
	    	return ResponseEntity.badRequest().build();
	    }else {
	    	return ResponseEntity.ok(updatedUsuario);
	    }
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		pessoaService.removeIdUsuario(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT); //204
	}
	
}
