package dev.toni;
import static java.lang.System.out;
import java.util.Scanner;
import java.util.List;

public class Ihm {
    private final GerenciadorNomes gerenciador;
    private final Scanner entrada = new Scanner(System.in);
    public Ihm(GerenciadorNomes g) {
    gerenciador = g;
 }
public void dialogar() {
    
    boolean sair = false;
    while (!sair) {
    out.println("\n>> MENU PRINCIPAL:");
    out.println("(1) Listar nomes");
    out.println("(2) Adicionar Nome");
    out.println("(3) Sair");
    out.print("Escolha uma opção: ");
    String op = entrada.nextLine();
    
    switch (op) {
    case "1" -> listar();
    case "2" -> adicionar();
    case "3" -> sair = true;
    default -> out.print("Opção inválida!");
    }
}
    out.println("Fim do programa!");
 }
private void listar() {
    List<String> nomes = gerenciador.obterNomes();
    out.println("\n>> Lista dos nomes:");
    for (String nome : nomes) {
    out.println(nome);
    }
}
 
private void adicionar() {
    out.print("\n>> Digite o novo nome: ");
    String novoNome = entrada.nextLine();
    gerenciador.adicionarNome(novoNome);
    }
}