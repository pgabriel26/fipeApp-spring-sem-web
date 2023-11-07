package br.com.alura.fipeApp.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public class Veiculo {
    private Integer tipoVeiculo;
    private Double valor;
    private String marca;
    private String modelo;
    private String anoModelo;
    private String combustivel;
    private String codigoFipe;
    private String mesReferencia;
    private String siglaCombustivel;

    public Veiculo(DadosVeiculo dado) {
        this.tipoVeiculo = dado.tipoVeiculo();
        this.valor = Double.valueOf(dado.valor().substring(2).replace(".","").replace(",", "."));
        this.marca = dado.marca();
        this.modelo = dado.modelo();
        this.anoModelo = dado.anoModelo();
        this.combustivel = dado.combustivel();
        this.codigoFipe = dado.codigoFipe();
        this.mesReferencia = dado.mesReferencia();
        this.siglaCombustivel = dado.siglaCombustivel();
    }

    public Integer getTipoVeiculo() {
        return tipoVeiculo;
    }

    public Double getValor() {
        return valor;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getAnoModelo() {
        return anoModelo;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public String getCodigoFipe() {
        return codigoFipe;
    }

    public String getMesReferencia() {
        return mesReferencia;
    }

    public String getSiglaCombustivel() {
        return siglaCombustivel;
    }

    @Override
    public String toString() {
        return  "Valor: R$" + valor +
                " Marca: '" + marca + '\'' +
                " Modelo: '" + modelo + '\'' +
                " Ano: '" + anoModelo + '\'' +
                " Combustivel: '" + combustivel + '\'' +
                " Codigo Fipe: '" + codigoFipe + '\'';
    }
}
