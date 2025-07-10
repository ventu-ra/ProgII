package br.unesc.analisador;

import br.unesc.analisador.sintatico.AnalisadorSintatico;
import br.unesc.analisador.lexico.AnalisadorLexico;
import br.unesc.analisador.lexico.Token;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Stack;

/**
 * Programação Orientada a Objetos
 * Estrutura de Dados I
 *
 *
 */
public class MainCompilador {

    public static void main(String[] args) {
        new MainCompilador().executar();
    }

    public void executar() {
        System.out.println();
        Path exemplo = Paths.get("test", "exemplo2.txt");
        // - Programa a ser analisado
        try {

            String programa = Files.readString(exemplo);
            // Remove comentários estilo Pascal: (* ... *), incluindo múltiplas linhas
            programa = programa.replaceAll("(?s)\\(\\*.*?\\*\\)", "");
            programa = programa.replaceAll("\\(\\*.*?\\*\\)", " ");

            Stack<Token> tokens = new AnalisadorLexico().gerarTokens(programa);

            while (tokens.isEmpty()) {
                System.out.println(tokens.pop());
            }

            new AnalisadorSintatico().analisar(tokens);

        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo: " + exemplo);
            e.printStackTrace();
        }
        // String programa1 = "PROGRAM NOMEPROGRAMA ; "
        // + "VAR "
        // + " X , Y , Z : INTEGER ; "
        // + "BEGIN "
        // + " X := 10 ; "
        // + " Y := 20 ; "
        // + " Z := 30 ; "

        // + " REPEAT "
        // + " BEGIN "
        // + " WRITELN ( X , Y , Z ) ; "
        // + " END "
        // + " UNTIL X > 10 ; "
        // + " .";

        // String p = "PROGRAM TESTE123;"

        // + "CONST"
        // + "a = -100;"
        // + "b = -200;"
        // + "VAR "
        // + "a, Y, Z : INTEGER;"
        // + "BEGIN"
        // + "Z := 0;"
        // + "END.";

        // Stack<Token> tokens = new AnalisadorLexico().gerarTokens(programa);
        // while (!tokens.isEmpty()) {
        // System.out.println(tokens.pop());
        // }

        // new AnalisadorSintatico().analisar(tokens);
    }
}
