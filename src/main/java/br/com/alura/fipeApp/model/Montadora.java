package br.com.alura.fipeApp.model;

public class Montadora {
    String nome;
    Integer codigo;
    String codigoAno;

    public Montadora(DadosMontadora dado) {
        this.nome = dado.nome();
        try {
            this.codigo = Integer.valueOf(dado.codigo());
        } catch (NumberFormatException e) {
            this.codigoAno = dado.codigo();
        }
    }
    public String getNome() {
        return nome;
    }

    public String getCodigoAno() {
        return codigoAno;
    }
    public Integer getCodigo() {
        return codigo;
    }
    @Override
    public String toString() {
        if (codigoAno != null){
            return "Codigo Ano: " + codigoAno + " Nome: " + nome + '\'';
        }
        return codigo + " '" + nome + '\'';
    }
}
