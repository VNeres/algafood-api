package com.vsilva.algafood.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;
import lombok.EqualsAndHashCode;

//@JsonRootName("gastronomia") // definir o nome no xml
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity /* (name="tab_cozinhas") - se quiser definir o nome da tabela */
public class Cozinha {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	//@JsonIgnore // ignora a propriedade, nao exibindo no retorno da busca
	//@JsonProperty("titulo") // altera o nome da proprieade na exibição do retorno
	@Column(nullable = false) /* (name="nom_cozinha") - se qusier definir o nome da coluna) */
	private String nome;

}
