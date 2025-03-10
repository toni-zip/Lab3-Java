/*
Antonio Francisco Lacerda Pereira 10436919
Henrique Totti Ulbricht Lapa 10436584
*/
package dev.toni;
import java.util.List;

public interface GerenciadorNomes {
    int MAX_CARACTERES_NOMES = 20;
    List<String> obterNomes();
    void adicionarNome(String nome);
}