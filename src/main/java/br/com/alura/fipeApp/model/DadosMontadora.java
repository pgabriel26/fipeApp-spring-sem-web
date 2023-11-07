package br.com.alura.fipeApp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosMontadora(String codigo,
                             String nome) {
}
