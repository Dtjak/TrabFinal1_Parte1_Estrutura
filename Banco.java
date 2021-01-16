package Parte1;

import java.util.ArrayList;

public class Banco {

    private ArrayList<ContaCorrente> contas_c = new ArrayList<>(10);
    private ArrayList<ContaPoupanca> contas_p = new ArrayList<>(10);
    //uma lista para cada tipo de conta
    
    public Banco(ArrayList<ContaCorrente> contas_c, ArrayList<ContaPoupanca> contas_p) {
        this.contas_c = contas_c;
        this.contas_p = contas_p;
    }

    public void inserirCC(ContaCorrente conta) {
        getContas_c().add(conta);
    }

    public void inserirCP(ContaPoupanca conta) {
        getContas_p().add(conta);
    }

    public void removerCC(ContaCorrente conta) {
        getContas_c().remove(conta);
    }

    public void removerCP(ContaPoupanca conta) {
        getContas_p().remove(conta);
    }

    public ContaCorrente procurarContaC(int num_conta) {
        ContaCorrente conta = null; //para retornar null caso nenhuma conta seja encontrada
        for (int i = 0; i < getContas_c().size(); i++) { //percorre a lista de contas e compara o número de conta inserido com os das contas na lista
            if (getContas_c().get(i).getNum_conta() == num_conta) { //se encontrar o número da conta correspondente, passa os dados da conta
                conta = getContas_c().get(i);
            }
        }
        return conta;
    }

    public ContaPoupanca procurarContaP(int num_conta) {
        ContaPoupanca conta = null;
        for (int i = 0; i < getContas_p().size(); i++) {
            if (getContas_p().get(i).getNum_conta() == num_conta) {
                conta = getContas_p().get(i);
            }
        }
        return conta;
    }

    public ArrayList<ContaPoupanca> getContas_p() {
        return contas_p;
    }

    public void setContas_p(ArrayList<ContaPoupanca> contas_p) {
        this.contas_p = contas_p;
    }

    public ArrayList<ContaCorrente> getContas_c() {
        return contas_c;
    }

    public void setContas_c(ArrayList<ContaCorrente> contas_c) {
        this.contas_c = contas_c;
    }

}
