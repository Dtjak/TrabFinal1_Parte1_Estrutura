package Parte1;

public abstract class ContaBancaria {

    private int num_conta;
    private double saldo;

    public ContaBancaria(int num_conta, double saldo) {
        this.num_conta = num_conta;
        this.saldo = saldo;
    }

    public abstract Boolean sacar(double valor);

    public abstract void depositar(double valor);

    public abstract void transferir(double valor, ContaBancaria conta);

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
