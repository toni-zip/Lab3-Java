/*
Antonio Francisco Lacerda Pereira 10436919
Henrique Totti Ulbricht Lapa 10436584
*/
package dev.toni;
public class Main {
    public static void main(String[] args) {
        
        boolean usarBancoDeDados = true; 

        GerenciadorNomes gerenciador;

        if (usarBancoDeDados) {
            System.out.println("Usando GerenciadorNomesBD (Banco de Dados)");
            gerenciador = new GerenciadorNomesBD(); 
        } else {
            System.out.println("Usando GerenciadorNomesMem (Memória)");
            gerenciador = new GerenciadorNomesMem(); 
        }

       
        Ihm ihm = new Ihm(gerenciador);
        ihm.dialogar();
    }
}