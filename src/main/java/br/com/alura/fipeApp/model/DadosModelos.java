package br.com.alura.fipeApp.model;

import java.util.List;

public record DadosModelos(List<DadosMontadora> modelos,
                           List<DadosMontadora> anos) {
}
