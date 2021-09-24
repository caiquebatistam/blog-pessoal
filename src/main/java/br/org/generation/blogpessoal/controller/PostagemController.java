package br.org.generation.blogpessoal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.generation.blogpessoal.model.Postagem;
import br.org.generation.blogpessoal.repository.PostagemRepository;


// recebe e responde requisições http
@RestController
@RequestMapping("/postagens")// Definir nosso endereço, ou seja, destino da nossa requisição
@CrossOrigin(origins = "*", allowedHeaders = "*") // Libera o acesso frontend
public class PostagemController {
	
	@Autowired
	private PostagemRepository postagemRepository;
	
	@GetMapping
	public ResponseEntity <List<Postagem>> getAl()// Entidade de Resposta
	{     // injeção de dependencia
		return ResponseEntity.ok(postagemRepository.findAll()); // equivalente ao MySQL select * from tb_postagens
	}

}













