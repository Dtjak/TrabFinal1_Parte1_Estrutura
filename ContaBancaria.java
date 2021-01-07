package Parte1;

public class ContaBancaria {

    private int num_conta;
    private double saldo;

    public ContaBancaria(int num_conta, double saldo) {
        this.num_conta = num_conta;
        this.saldo = saldo;
    }

    public Boolean sacar(double valor) {
        if (getSaldo() > valor) {
            setSaldo(getSaldo() - valor);
            return true;
        } else {
            return false;
        }
    }

    public void depositar(double valor) {

        setSaldo(getSaldo() + valor);

    }

    public void transferir(double valor, ContaBancaria conta) {
        if (sacar(valor) == true) {
            conta.depositar(valor);
        } else {
            System.out.println("Saldo insuficiente para transferência");
        }
    }

    public int getNum_conta() {
        return num_conta;
    }

    public void setNum_conta(int num_conta) {
        this.num_conta = num_conta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

}
