package dev.toni;
public class Main {
    public static void main(String[] args) {
    GerenciadorNomes gNomes = new GerenciadorNomesMem();
    Ihm ihm = new Ihm(gNomes);
    ihm.dialogar();
    }
}