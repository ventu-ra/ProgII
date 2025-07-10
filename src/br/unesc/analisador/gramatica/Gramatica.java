package br.unesc.analisador.gramatica;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Gramatica {
    public static final Map<String, Integer> TERMINAIS_E_NAO_TERMINAIS = new HashMap<String, Integer>();
    public static final Map<String, String> GRAMATICA = new HashMap<String, String>();

    static {
        // palavras reservadas, que podem ser utilizadas (terminais)
        // Código < 52
        TERMINAIS_E_NAO_TERMINAIS.put("PROGRAM", 1);
        TERMINAIS_E_NAO_TERMINAIS.put("LABEL", 2);
        TERMINAIS_E_NAO_TERMINAIS.put("CONST", 3);
        TERMINAIS_E_NAO_TERMINAIS.put("VAR", 4);
        TERMINAIS_E_NAO_TERMINAIS.put("PROCEDURE", 5);
        TERMINAIS_E_NAO_TERMINAIS.put("BEGIN", 6);
        TERMINAIS_E_NAO_TERMINAIS.put("END", 7);
        TERMINAIS_E_NAO_TERMINAIS.put("INTEGER", 8);
        TERMINAIS_E_NAO_TERMINAIS.put("ARRAY", 9);
        TERMINAIS_E_NAO_TERMINAIS.put("OF", 10);
        TERMINAIS_E_NAO_TERMINAIS.put("CALL", 11);
        TERMINAIS_E_NAO_TERMINAIS.put("GOTO", 12);
        TERMINAIS_E_NAO_TERMINAIS.put("IF", 13);
        TERMINAIS_E_NAO_TERMINAIS.put("THEN", 14);
        TERMINAIS_E_NAO_TERMINAIS.put("ELSE", 15);
        TERMINAIS_E_NAO_TERMINAIS.put("WHILE", 16);
        TERMINAIS_E_NAO_TERMINAIS.put("DO", 17);
        TERMINAIS_E_NAO_TERMINAIS.put("REPEAT", 18);
        TERMINAIS_E_NAO_TERMINAIS.put("UNTIL", 19);
        TERMINAIS_E_NAO_TERMINAIS.put("READLN", 20);
        TERMINAIS_E_NAO_TERMINAIS.put("WRITELN", 21);
        TERMINAIS_E_NAO_TERMINAIS.put("OR", 22);
        TERMINAIS_E_NAO_TERMINAIS.put("AND", 23);
        TERMINAIS_E_NAO_TERMINAIS.put("NOT", 24);
        TERMINAIS_E_NAO_TERMINAIS.put("IDENTIFICADOR", 25);
        // <!-- Nome de variáveis, qualquer nome -->
        TERMINAIS_E_NAO_TERMINAIS.put("INTEIRO", 26);
        // <!-- números inteiros 0..9 -->
        TERMINAIS_E_NAO_TERMINAIS.put("FOR", 27);
        TERMINAIS_E_NAO_TERMINAIS.put("TO", 28);
        TERMINAIS_E_NAO_TERMINAIS.put("CASE", 29);
        // <!-- simbolos especiais -->
        TERMINAIS_E_NAO_TERMINAIS.put("+", 30);
        TERMINAIS_E_NAO_TERMINAIS.put("-", 31);
        TERMINAIS_E_NAO_TERMINAIS.put("*", 32);
        TERMINAIS_E_NAO_TERMINAIS.put("/", 33);
        TERMINAIS_E_NAO_TERMINAIS.put("[", 34);
        TERMINAIS_E_NAO_TERMINAIS.put("]", 35);
        TERMINAIS_E_NAO_TERMINAIS.put("(", 36);
        TERMINAIS_E_NAO_TERMINAIS.put(")", 37);
        TERMINAIS_E_NAO_TERMINAIS.put(":=", 38);
        TERMINAIS_E_NAO_TERMINAIS.put(":", 39);
        TERMINAIS_E_NAO_TERMINAIS.put("=", 40);
        TERMINAIS_E_NAO_TERMINAIS.put(">", 41);
        TERMINAIS_E_NAO_TERMINAIS.put(">=", 42);
        TERMINAIS_E_NAO_TERMINAIS.put("<", 43);

        // <!-- Sinal de menor -->
        TERMINAIS_E_NAO_TERMINAIS.put("<=", 44);
        // <!-- Sinal de menor ou igual -->
        TERMINAIS_E_NAO_TERMINAIS.put("<>", 45);
        // <!-- Sinal de diferente -->
        TERMINAIS_E_NAO_TERMINAIS.put(",", 46);
        TERMINAIS_E_NAO_TERMINAIS.put(";", 47);
        TERMINAIS_E_NAO_TERMINAIS.put("LITERAL", 48);
        // <!-- Exemplo: 'TEXTO CORRIDO' -->
        TERMINAIS_E_NAO_TERMINAIS.put(".", 49);
        TERMINAIS_E_NAO_TERMINAIS.put("..", 50);
        TERMINAIS_E_NAO_TERMINAIS.put("$", 51);

        // <!- símbolo para finalização do programa -->
        // simbolos não terminais (que possuem deriações em outros blocos)
        TERMINAIS_E_NAO_TERMINAIS.put("PROGRAMA", 52);
        TERMINAIS_E_NAO_TERMINAIS.put("BLOCO", 53);
        TERMINAIS_E_NAO_TERMINAIS.put("DCLROT", 54);
        TERMINAIS_E_NAO_TERMINAIS.put("LID", 55);
        TERMINAIS_E_NAO_TERMINAIS.put("REPIDENT", 56);
        TERMINAIS_E_NAO_TERMINAIS.put("DCLCONST", 57);
        TERMINAIS_E_NAO_TERMINAIS.put("LDCONST", 58);
        TERMINAIS_E_NAO_TERMINAIS.put("DCLVAR", 59);
        TERMINAIS_E_NAO_TERMINAIS.put("LDVAR", 60);
        TERMINAIS_E_NAO_TERMINAIS.put("TIPO", 61);
        TERMINAIS_E_NAO_TERMINAIS.put("DCLPROC", 62);
        TERMINAIS_E_NAO_TERMINAIS.put("DEFPAR", 63);
        TERMINAIS_E_NAO_TERMINAIS.put("CORPO", 64);
        TERMINAIS_E_NAO_TERMINAIS.put("REPCOMANDO", 65);
        TERMINAIS_E_NAO_TERMINAIS.put("COMANDO", 66);
        TERMINAIS_E_NAO_TERMINAIS.put("RCOMID", 67);
        TERMINAIS_E_NAO_TERMINAIS.put("RVAR", 68);
        TERMINAIS_E_NAO_TERMINAIS.put("PARAMETROS", 69);
        TERMINAIS_E_NAO_TERMINAIS.put("REPPAR", 70);
        TERMINAIS_E_NAO_TERMINAIS.put("ELSEPARTE", 71);
        TERMINAIS_E_NAO_TERMINAIS.put("VARIAVEL", 72);
        TERMINAIS_E_NAO_TERMINAIS.put("VARIAVEL1", 73);
        TERMINAIS_E_NAO_TERMINAIS.put("REPVARIAVEL", 74);
        TERMINAIS_E_NAO_TERMINAIS.put("ITEMSAIDA", 75);
        TERMINAIS_E_NAO_TERMINAIS.put("REPITEM", 76);
        TERMINAIS_E_NAO_TERMINAIS.put("EXPRESSAO", 77);
        TERMINAIS_E_NAO_TERMINAIS.put("REPEXPSIMP", 78);
        TERMINAIS_E_NAO_TERMINAIS.put("EXPSIMP", 79);
        TERMINAIS_E_NAO_TERMINAIS.put("REPEXP", 80);
        TERMINAIS_E_NAO_TERMINAIS.put("TERMO", 81);
        TERMINAIS_E_NAO_TERMINAIS.put("REPTERMO", 82);
        TERMINAIS_E_NAO_TERMINAIS.put("FATOR", 83);
        TERMINAIS_E_NAO_TERMINAIS.put("CONDCASE", 84);
        TERMINAIS_E_NAO_TERMINAIS.put("CONTCASE", 85);
        TERMINAIS_E_NAO_TERMINAIS.put("RPINTEIRO", 86);
        TERMINAIS_E_NAO_TERMINAIS.put("SEMEFEITO", 87);

        // montagem da gramatica / tabela de parsing
        // GRAMATICA.put("52,1", "PROGRAM|IDENTIFICADOR|;|BLOCO|.");
        // GRAMATICA.put("53,4", "DCLROT|DCLCONST|DCLVAR|DCLPROC|CORPO");
        // GRAMATICA.put("59,4", "VAR|LID|:|TIPO|;|LDVAR");
        // GRAMATICA.put("55,25", "IDENTIFICADOR|REPIDENT");
        // GRAMATICA.put("56,46", ",|IDENTIFICADOR|REPIDENT");
        // GRAMATICA.put("61,8", "INTEGER");
        // GRAMATICA.put("64,6", "BEGIN|COMANDO|REPCOMANDO|END");
        // GRAMATICA.put("66,25", "IDENTIFICADOR|RCOMID");
        // GRAMATICA.put("67,38", "RVAR|:=|EXPRESSAO");
        // GRAMATICA.put("77,26", "EXPSIMP|REPEXPSIMP");
        // GRAMATICA.put("79,26", "TERMO|REPEXP");
        // GRAMATICA.put("81,26", "FATOR|REPTERMO");
        // GRAMATICA.put("83,26", "INTEIRO");
        // GRAMATICA.put("65,47", ";|COMANDO|REPCOMANDO");
        // GRAMATICA.put("66,18", "REPEAT|COMANDO|UNTIL|EXPRESSAO");
        // GRAMATICA.put("66,6", "CORPO");
        // GRAMATICA.put("66,21", "WRITELN|(|ITEMSAIDA|REPITEM|)");
        // GRAMATICA.put("75,25", "EXPRESSAO");
        // GRAMATICA.put("77,25", "EXPSIMP|REPEXPSIMP");
        // GRAMATICA.put("79,25", "TERMO|REPEXP");
        // GRAMATICA.put("81,25", "FATOR|REPTERMO");
        // GRAMATICA.put("83,25", "|VARIAVEL");
        // GRAMATICA.put("72,25", "IDENTIFICADOR|VARIAVEL1");
        // GRAMATICA.put("76,46", ",|ITEMSAIDA|REPITEM");
        // GRAMATICA.put("78,41", ">|EXPSIMP");
        GRAMATICA.put("52,1", "PROGRAM|IDENTIFICADOR|;|BLOCO|.");
        GRAMATICA.put("53,2", "DCLROT|DCLCONST|DCLVAR|DCLPROC|CORPO");
        GRAMATICA.put("53,3", "DCLROT|DCLCONST|DCLVAR|DCLPROC|CORPO");
        GRAMATICA.put("53,4", "DCLROT|DCLCONST|DCLVAR|DCLPROC|CORPO");
        GRAMATICA.put("53,5", "DCLROT|DCLCONST|DCLVAR|DCLPROC|CORPO");
        GRAMATICA.put("53,6", "DCLROT|DCLCONST|DCLVAR|DCLPROC|CORPO");
        GRAMATICA.put("54,2", "LABEL|LID|;");
        GRAMATICA.put("54,3", null);
        GRAMATICA.put("54,4", null);
        GRAMATICA.put("54,5", null);
        GRAMATICA.put("54,6", null);
        GRAMATICA.put("55,25", "IDENTIFICADOR|REPIDENT");
        GRAMATICA.put("56,39", null);
        GRAMATICA.put("56,46", ",|IDENTIFICADOR|REPIDENT");
        GRAMATICA.put("56,47", null);
        GRAMATICA.put("57,3", "CONST|IDENTIFICADOR|=|INTEIRO|;|LDCONST");
        GRAMATICA.put("57,4", null);
        GRAMATICA.put("57,5", null);
        GRAMATICA.put("57,6", null);
        GRAMATICA.put("58,25", "IDENTIFICADOR|=|INTEIRO|;|LDCONST");
        GRAMATICA.put("58,4", null);
        GRAMATICA.put("58,5", null);
        GRAMATICA.put("58,6", null);
        GRAMATICA.put("59,4", "VAR|LID|:|TIPO|;|LDVAR");
        GRAMATICA.put("59,5", null);
        GRAMATICA.put("59,6", null);
        GRAMATICA.put("60,25", "LID|:|TIPO|;|LDVAR");
        GRAMATICA.put("60,5", null);
        GRAMATICA.put("60,6", null);
        GRAMATICA.put("61,8", "INTEGER");
        GRAMATICA.put("61,9", "ARRAY|[|INTEIRO|..|INTEIRO|]|OF|INTEGER");
        GRAMATICA.put("62,5", "PROCEDURE|IDENTIFICADOR|DEFPAR|;|BLOCO|;|DCLPROC");
        GRAMATICA.put("62,6", null);
        GRAMATICA.put("63,36", "(|LID|:|INTEGER|)");
        GRAMATICA.put("63,39", null);
        GRAMATICA.put("64,6", "BEGIN|COMANDO|REPCOMANDO|END");
        GRAMATICA.put("65,47", ";|COMANDO|REPCOMANDO");
        GRAMATICA.put("65,7", null);
        GRAMATICA.put("66,11", "CALL|IDENTIFICADOR|PARAMETROS");
        GRAMATICA.put("66,12", "GOTO|IDENTIFICADOR");
        GRAMATICA.put("66,13", "IF|EXPRESSAO|THEN|COMANDO|ELSEPARTE");
        GRAMATICA.put("66,15", null);
        GRAMATICA.put("66,16", "WHILE|EXPRESSAO|DO|COMANDO");
        GRAMATICA.put("66,18", "REPEAT|COMANDO|UNTIL|EXPRESSAO");
        GRAMATICA.put("66,19", null);
        GRAMATICA.put("66,20", "READLN|(|VARIAVEL|REPVARIAVEL|)");
        GRAMATICA.put("66,21", "WRITELN|(|ITEMSAIDA|REPITEM|)");
        GRAMATICA.put("66,25", "IDENTIFICADOR|RCOMID");
        GRAMATICA.put("66,27", "FOR|IDENTIFICADOR|:=|EXPRESSAO|TO|EXPRESSAO|DO|COMANDO");
        GRAMATICA.put("66,29", "CASE|EXPRESSAO|OF|CONDCASE|END");
        GRAMATICA.put("66,47", null);
        GRAMATICA.put("66,6", "CORPO");
        GRAMATICA.put("66,7", null);
        GRAMATICA.put("67,34", "RVAR|:=|EXPRESSAO");
        GRAMATICA.put("67,38", "RVAR|:=|EXPRESSAO");
        GRAMATICA.put("67,39", ":|COMANDO");
        GRAMATICA.put("68,34", "[|EXPRESSAO|]");
        GRAMATICA.put("68,38", null);
        GRAMATICA.put("69,15", null);
        GRAMATICA.put("69,19", null);
        GRAMATICA.put("69,36", "(|EXPRESSAO|REPPAR|)");
        GRAMATICA.put("69,47", null);
        GRAMATICA.put("69,7", null);
        GRAMATICA.put("70,37", null);
        GRAMATICA.put("70,46", ",|EXPRESSAO|REPPAR");
        GRAMATICA.put("71,15", "ELSE|COMANDO");
        GRAMATICA.put("71,19", null);
        GRAMATICA.put("71,47", null);
        GRAMATICA.put("71,7", null);
        GRAMATICA.put("72,25", "IDENTIFICADOR|VARIAVEL1");
        GRAMATICA.put("73,10", null);
        GRAMATICA.put("73,14", null);
        GRAMATICA.put("73,15", null);
        GRAMATICA.put("73,17", null);
        GRAMATICA.put("73,19", null);
        GRAMATICA.put("73,22", null);
        GRAMATICA.put("73,23", null);
        GRAMATICA.put("73,28", null);
        GRAMATICA.put("73,30", null);
        GRAMATICA.put("73,31", null);
        GRAMATICA.put("73,32", null);
        GRAMATICA.put("73,33", null);
        GRAMATICA.put("73,34", "[|EXPRESSAO|]");
        GRAMATICA.put("73,35", null);
        GRAMATICA.put("73,37", null);
        GRAMATICA.put("73,40", null);
        GRAMATICA.put("73,41", null);
        GRAMATICA.put("73,42", null);
        GRAMATICA.put("73,43", null);
        GRAMATICA.put("73,44", null);
        GRAMATICA.put("73,45", null);
        GRAMATICA.put("73,46", null);
        GRAMATICA.put("73,47", null);
        GRAMATICA.put("73,7", null);
        GRAMATICA.put("74,37", null);
        GRAMATICA.put("74,46", ",|VARIAVEL|REPVARIAVEL");
        GRAMATICA.put("75,24", "EXPRESSAO");
        GRAMATICA.put("75,25", "EXPRESSAO");
        GRAMATICA.put("75,26", "EXPRESSAO");
        GRAMATICA.put("75,30", "EXPRESSAO");
        GRAMATICA.put("75,31", "EXPRESSAO");
        GRAMATICA.put("75,36", "EXPRESSAO");
        GRAMATICA.put("75,48", "LITERAL");
        GRAMATICA.put("76,37", null);
        GRAMATICA.put("76,46", ",|ITEMSAIDA|REPITEM");
        GRAMATICA.put("77,24", "EXPSIMP|REPEXPSIMP");
        GRAMATICA.put("77,25", "EXPSIMP|REPEXPSIMP");
        GRAMATICA.put("77,26", "EXPSIMP|REPEXPSIMP");
        GRAMATICA.put("77,30", "EXPSIMP|REPEXPSIMP");
        GRAMATICA.put("77,31", "EXPSIMP|REPEXPSIMP");
        GRAMATICA.put("77,36", "EXPSIMP|REPEXPSIMP");
        GRAMATICA.put("78,10", null);
        GRAMATICA.put("78,14", null);
        GRAMATICA.put("78,15", null);
        GRAMATICA.put("78,17", null);
        GRAMATICA.put("78,19", null);
        GRAMATICA.put("78,28", null);
        GRAMATICA.put("78,35", null);
        GRAMATICA.put("78,37", null);
        GRAMATICA.put("78,40", "=|EXPSIMP");
        GRAMATICA.put("78,41", ">|EXPSIMP");
        GRAMATICA.put("78,42", ">=|EXPSIMP");
        GRAMATICA.put("78,43", "<|EXPSIMP");
        GRAMATICA.put("78,44", "<=|EXPSIMP");
        GRAMATICA.put("78,45", "<>|EXPSIMP");
        GRAMATICA.put("78,46", null);
        GRAMATICA.put("78,47", null);
        GRAMATICA.put("78,7", null);
        GRAMATICA.put("79,24", "TERMO|REPEXP");
        GRAMATICA.put("79,25", "TERMO|REPEXP");
        GRAMATICA.put("79,26", "TERMO|REPEXP");
        GRAMATICA.put("79,30", "+|TERMO|REPEXP");
        GRAMATICA.put("79,31", "-|TERMO|REPEXP");
        GRAMATICA.put("79,36", "TERMO|REPEXP");
        GRAMATICA.put("80,10", null);
        GRAMATICA.put("80,14", null);
        GRAMATICA.put("80,15", null);
        GRAMATICA.put("80,17", null);
        GRAMATICA.put("80,19", null);
        GRAMATICA.put("80,22", "OR|TERMO|REPEXP");
        GRAMATICA.put("80,28", null);
        GRAMATICA.put("80,30", "+|TERMO|REPEXP");
        GRAMATICA.put("80,31", "-|TERMO|REPEXP");
        GRAMATICA.put("80,35", null);
        GRAMATICA.put("80,37", null);
        GRAMATICA.put("80,40", null);
        GRAMATICA.put("80,41", null);
        GRAMATICA.put("80,42", null);
        GRAMATICA.put("80,43", null);
        GRAMATICA.put("80,44", null);
        GRAMATICA.put("80,45", null);
        GRAMATICA.put("80,46", null);
        GRAMATICA.put("80,47", null);
        GRAMATICA.put("80,7", null);
        GRAMATICA.put("81,24", "FATOR|REPTERMO");
        GRAMATICA.put("81,25", "FATOR|REPTERMO");
        GRAMATICA.put("81,26", "FATOR|REPTERMO");
        GRAMATICA.put("81,36", "FATOR|REPTERMO");
        GRAMATICA.put("82,10", null);
        GRAMATICA.put("82,14", null);
        GRAMATICA.put("82,15", null);
        GRAMATICA.put("82,17", null);
        GRAMATICA.put("82,19", null);
        GRAMATICA.put("82,22", null);
        GRAMATICA.put("82,23", "AND|FATOR|REPTERMO");
        GRAMATICA.put("82,28", null);
        GRAMATICA.put("82,30", null);
        GRAMATICA.put("82,31", null);
        GRAMATICA.put("82,32", "*|FATOR|REPTERMO");
        GRAMATICA.put("82,33", "/|FATOR|REPTERMO");
        GRAMATICA.put("82,35", null);
        GRAMATICA.put("82,37", null);
        GRAMATICA.put("82,40", null);
        GRAMATICA.put("82,41", null);
        GRAMATICA.put("82,42", null);
        GRAMATICA.put("82,43", null);
        GRAMATICA.put("82,44", null);
        GRAMATICA.put("82,45", null);
        GRAMATICA.put("82,46", null);
        GRAMATICA.put("82,47", null);
        GRAMATICA.put("82,7", null);
        GRAMATICA.put("83,24", "NOT|FATOR");
        GRAMATICA.put("83,25", "VARIAVEL");
        GRAMATICA.put("83,26", "INTEIRO");
        GRAMATICA.put("83,36", "(|EXPRESSAO|)");
        GRAMATICA.put("84,26", "INTEIRO|RPINTEIRO|:|COMANDO|CONTCASE");
        GRAMATICA.put("85,47", ";|CONDCASE");
        GRAMATICA.put("85,7", null);
        GRAMATICA.put("86,39", null);
        GRAMATICA.put("86,46", ",|INTEIRO|RPINTEIRO");
    }

    public static String getBuscarPalavraPeloCodigo(Integer codigo) {
        if (codigo == null) {
            return null;
        }
        for (Map.Entry<String, Integer> entry : TERMINAIS_E_NAO_TERMINAIS.entrySet()) {
            if (entry.getValue().compareTo(codigo) == 0) {
                return entry.getKey();
            }
        }
        return null;
    }

    /**
     * Este mtodo retorna uma lista com os cdigos equivalentes as palavras que
     * foram derivadas
     */
    public static Integer[] geraDadosCruzamentoTabParsingToken(String str) {
        if ((str != null) && (str.length() != 0) && !"null".equals(str)) {
            StringTokenizer strTokenizer = new StringTokenizer(str, "|");
            Integer[] dados = new Integer[strTokenizer.countTokens()];
            int i = 0;

            while (strTokenizer.hasMoreTokens()) {
                String palavra = strTokenizer.nextToken();
                dados[i++] = TERMINAIS_E_NAO_TERMINAIS.get(palavra);
            }

            return dados;
        }

        return null;
    }
}
