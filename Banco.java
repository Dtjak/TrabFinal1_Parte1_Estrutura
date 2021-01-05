package Parte1;

import java.util.ArrayList;

public class Banco {

    private static ArrayList contas = new ArrayList(10);

    public Banco(ArrayList contas) {
        Banco.contas = contas;
    }

    public static void inserir(Object conta) {
        getContas().add(conta);
    }

    public static void remover(Object conta) {
        getContas().remove(conta);
    }

    public static Object procurarConta(int num_conta) {
        return getContas().get(num_conta);
    }

    public static ArrayList getContas() {
        return contas;
    }

    public static void setContas(ArrayList contas) {
        Banco.contas = contas;
    }
}
