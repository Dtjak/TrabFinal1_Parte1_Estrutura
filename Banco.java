package Parte1;

import java.util.ArrayList;

public class Banco {

    private ArrayList<ContaPoupanca> contas_p = new ArrayList<>(10);
    private ArrayList<ContaCorrente> contas_c = new ArrayList<>(10);

    public Banco() {}

    public void inserirCC(ContaCorrente conta) {
        getContasC().add(conta);
    }
    
    public void inserirCP(ContaPoupanca conta) {
        getContasP().add(conta);
    }

    public void removerCC(ContaCorrente conta) {
        getContasC().remove(conta);
    }
    
    public void removerCP(ContaPoupanca conta) {
        getContasP().remove(conta);
    }

    public ContaCorrente procurarContaC(int num_conta) {
        ContaCorrente conta = null;
        for (int i = 0; i < getContasC().size(); i++) {
            if (getContasC().get(i).getNum_conta() == num_conta) {
                conta = getContasC().get(i);
            }
        }
        return conta;
    }
    
    public ContaPoupanca procurarContaP(int num_conta) {
        ContaPoupanca conta = null;
        for (int i = 0; i < getContasP().size(); i++) {
            if (getContasP().get(i).getNum_conta() == num_conta) {
                conta = getContasP().get(i);
            }
        }
        return conta;
    }

    public ArrayList<ContaCorrente> getContasC() {
        return contas_c;
    }

    public void setContasC(ArrayList<ContaCorrente> contas) {
        this.contas_c = contas;
    }
    
    public ArrayList<ContaPoupanca> getContasP() {
        return contas_p;
    }

    public void setContasP(ArrayList<ContaPoupanca> contas) {
        this.contas_p = contas;
    }
}
