package br.org.generation.blogpessoal.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import br.org.generation.blogpessoal.model.Postagem;
import br.org.generation.blogpessoal.repository.PostagemRepository;


// recebe e responde requisições http
@RestController // declarando que esta classe vai fornecer endpoints
@RequestMapping("/postagens")// Definir nosso endereço, ou seja, destino da nossa requisição
@CrossOrigin(origins = "*", allowedHeaders = "*") // Libera o acesso frontend
public class PostagemController {
	
	@Autowired //
	private PostagemRepository postagemRepository; // -> inst variavel
	
	@GetMapping
	public ResponseEntity <List<Postagem>> getAll()// Entidade de Resposta
	{     // injeção de dependencia
		return ResponseEntity.ok(postagemRepository.findAll()); // equivalente ao MySQL select * from tb_postagens
	}

	@GetMapping("/{id}")
	public ResponseEntity<Postagem> getById(@PathVariable long id) 
	{
	  	return postagemRepository.findById(id)
	  		.map(resposta -> ResponseEntity.ok(resposta))
	  		.orElse(ResponseEntity.notFound().build());
	}
	

	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<Postagem>> getByTitulo(@PathVariable String titulo)
	{
		return ResponseEntity.ok(postagemRepository.findAllByTituloContainingIgnoreCase(titulo));
	}	

	@PostMapping
	public ResponseEntity<Postagem> postPostagem (@RequestBody Postagem postagem)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(postagemRepository.save(postagem));
	}
	
	@PutMapping
	public ResponseEntity<Postagem> putPostagem (@RequestBody Postagem postagem)
	{
		return ResponseEntity.status(HttpStatus.OK).body(postagemRepository.save(postagem));
	}	

	@DeleteMapping("/{id}")
	public void deletePostagem(@PathVariable long id) 
	{
		postagemRepository.deleteById(id);
	}
	
	
	
}













