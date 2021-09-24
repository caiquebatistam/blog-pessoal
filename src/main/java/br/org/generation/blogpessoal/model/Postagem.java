package br.org.generation.blogpessoal.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity // Gera tabela
@Table(name = "tb_postagens") //Definir nome da tabela // anotação nunca vai ter ;
public class Postagem {

	@Id // Chave Primária
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment -> mesma coisa do mySQL
	private long id;
	
	
	@NotNull(message = "O atributo titulo é obrigatório!")
	@Size(min = 5, max = 100, message = "O Atributo titulo deve ter no mínimo 5 e no máximo 100 caracteres!")
	private String titulo;
	
	@NotNull(message = "O atributo texto é obrigatório!")
	@Size(min = 10, max = 1000, message = "O Atributo texto deve ter no mínimo 10 e no máximo 1000 caracteres!")
	private String texto;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date data = new java.sql.Date(System.currentTimeMillis());
	
	
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	
	
	
	
}
