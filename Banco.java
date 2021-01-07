package Parte1;

import java.util.ArrayList;

public class Banco {

    private ArrayList<ContaBancaria> contas = new ArrayList<>(10);

    public Banco(ArrayList<ContaBancaria> contas) {
        this.contas = contas;
    }

    public void inserir(ContaBancaria conta) {
        getContas().add(conta);
    }

    public void remover(ContaBancaria conta) {
        getContas().remove(conta);
    }

    public ContaBancaria procurarConta(int num_conta) {
        ContaBancaria conta = null;
        for (int i = 0; i < getContas().size(); i++) {
            if (getContas().get(i).getNum_conta() == num_conta) {
                conta = getContas().get(i);
            }
        }
        return conta;
    }

    public ArrayList<ContaBancaria> getContas() {
        return contas;
    }

    public void setContas(ArrayList<ContaBancaria> contas) {
        this.contas = contas;
    }
}
