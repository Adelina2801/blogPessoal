package com.generation.blogpessoal.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity    // Indicar que a classe é uma tabela
@Table (name = "tb_postagens") //Indica o nome da tabela bd
public class Postagem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Auto incremento
	private Long id;
	
	@NotBlank(message = "Este campo é obrigatório") // Titulo da Posta
	@Size(min =  5, max = 100, message = "Digite no minimo 5 e no máximo 100 caracteres.")
	private String titulo;
	
	@NotBlank(message = "Este campo é obrigatório") // Titulo da Posta
	@Size(min =  10, max = 1000, message = "Digite no minimo 10 e no máximo 1000 caracteres.")
	private String texto;
	
	@UpdateTimestamp   // Ela vai atualizar o horário conforme banco de dados, data e hs do computador
	private LocalDateTime data;
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Tema tema;
	
	public Tema getTema() {
		return tema; 
	}
	public void setTema(Tema tema) {
		this.tema = tema;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	public LocalDateTime getData() {
		return data;
	}
	public void setData(LocalDateTime data) {
		this.data = data;
	} // 10/10/25 18:25:58
	
	

	
}
	
	