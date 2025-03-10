package dev.toni;
import java.util.List;
import java.util.ArrayList;

public class GerenciadorNomesMem implements GerenciadorNomes {
    private final List<String> nomes = new ArrayList<>();

@Override
    public List<String> obterNomes() {
    return nomes;
}

@Override
    public void adicionarNome(String nome) {
    nomes.add(nome);
    }
}