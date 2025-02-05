package br.com.vh.AppContatos.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.vh.AppContatos.model.Contato;
import br.com.vh.AppContatos.repository.ContatosRepository;
import br.com.vh.AppContatos.service.ContatoService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AppContatoResource {
	
	@Autowired
	private ContatoService contatoService;
	
	@Autowired
	private ContatosRepository contatoRepository;

	
	@GetMapping//http://localhost:8080/api
	public String getApi() {
		return "Api funcionando";
	}
		

	
	@GetMapping("getContatos") //http://localhost:8080/api/getContatos
	public List<Contato> getContatos(){		
		List<Contato> listContatos = new ArrayList<Contato>();
		
		Contato contato = new Contato();
		contato.setName("Vinicius");
		contato.setNumberTel("13 996093979");
		listContatos.add(contato);
		
		Contato contato2 = new Contato();
		contato2.setName("Elisabete");
		contato2.setNumberTel("13 997421710");
		listContatos.add(contato2);
		
		Contato contato3 = new Contato();
		contato3.setName("Rodrigo");
		contato3.setNumberTel("13 996574065");
		listContatos.add(contato3);
		
				
		return listContatos;
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
}
