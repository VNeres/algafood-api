package com.vsilva.algafood.api.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.vsilva.algafood.domain.model.Cozinha;

import lombok.Data;
import lombok.NonNull;

@JsonRootName("cozinhas")
@Data
public class CozinhaXmlWrapper {
	
	@JsonProperty("cozinha")
	@JacksonXmlElementWrapper(useWrapping = false)
	@NonNull
	private List<Cozinha> cozinhas;

}
