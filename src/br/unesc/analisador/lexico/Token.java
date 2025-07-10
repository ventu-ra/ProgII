package br.unesc.analisador.lexico;

public class Token {

    private String palavra;
    private Integer codigo;

    public Token(String palavra, Integer codigo) {
        this.palavra = palavra;
        this.codigo = codigo;
    }

    public String getPalavra() {
        return palavra;
    }

    public Integer getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return "Token{" + "palavra=" + palavra + ", codigo=" + codigo + '}';
    }
}
