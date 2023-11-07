package br.com.alura.fipeApp.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public record DadosVeiculo(@JsonAlias("TipoVeiculo") Integer tipoVeiculo,
                           @JsonAlias("Valor") String valor,
                           @JsonAlias("Marca") String marca,
                           @JsonAlias("Modelo") String modelo,
                           @JsonAlias("AnoModelo") String anoModelo,
                           @JsonAlias("Combustivel") String combustivel,
                           @JsonAlias("CodigoFipe") String codigoFipe,
                           @JsonAlias("MesReferencia") String mesReferencia,
                           @JsonAlias("SiglaCombustivel") String siglaCombustivel) {
}
