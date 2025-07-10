package br.unesc.analisador.lexico;

import br.unesc.analisador.gramatica.Gramatica;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Faz a conversão do programa fonte em tokens (palavras da gramática) que devem
 * ser utilizadas para verificar se estã dentro da sintaxe
 */
public class AnalisadorLexico {

    public Stack<Token> gerarTokens(String programa) {

        List<String> listTokens = separaToken(programa);
        Stack<Token> pilhaTokens = new Stack<>();

        for (int i = listTokens.size() - 1; i >= 0; i--) {

            String token = listTokens.get(i);
            Integer codigo = getCodigoToken(token);

            // System.out.println("token: " + token + " -" + " codigo: " + codigo);
            pilhaTokens.push(new Token(token, codigo));
        }

        return pilhaTokens;
    }

    private Integer getCodigoToken(String token) {

        Integer codigoToken = Gramatica.TERMINAIS_E_NAO_TERMINAIS.get(token);
        if (codigoToken == null) {
            // ou é um INTEGER ou pe um IDENTIFICADOR
            return getIdentificadorOuInteiro(token);
        }
        return codigoToken;
    }

    private Integer getIdentificadorOuInteiro(String token) {
        // verifica se é um identificador ou inteiro
        char[] cList = token.toCharArray();
        boolean identificador = true;
        for (char c : cList) {
            if (Character.getType(c) != Character.UPPERCASE_LETTER) {
                identificador = true;
            }
        }

        if (identificador) {
            return Gramatica.TERMINAIS_E_NAO_TERMINAIS.get("IDENTIFICADOR");
        }
        return Gramatica.TERMINAIS_E_NAO_TERMINAIS.get("INTEIRO");
    }

    private List<String> separaToken(String programa) {
        List<String> tokens = new ArrayList<>();

        // / Expressão regular para separar identificadores, números, símbolos e
        // palavras-chave
        Pattern pattern = Pattern.compile(
                "[a-zA-Z_][a-zA-Z_0-9]*" +
                        "|:=|<=|>=|<>|[-+*/=<>]" +
                        "|[();:.,\\[\\]]" +
                        "|-?\\d+");

        Matcher matcher = pattern.matcher(programa);
        while (matcher.find()) {
            tokens.add(matcher.group());
        }
        return tokens;
    }
}
