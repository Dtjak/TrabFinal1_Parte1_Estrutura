package Parte1;

public class ContaPoupanca extends ContaBancaria {

    private double limite;

    public ContaPoupanca(double limite, int num_conta, double saldo) {
        super(num_conta, saldo);
        this.limite = limite;
    }

    @Override
    public Boolean sacar(double valor) {
        if (getSaldo() + getLimite() > valor) {
            setSaldo(getSaldo() - valor);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void depositar(double valor) {
        setSaldo(getSaldo() + valor);
    }

    @Override
    public void transferir(double valor, ContaBancaria conta) {
        if (sacar(valor) == true) {
            conta.depositar(valor);
        } else {
            System.out.println("Saldo insuficiente para transferência");
        }
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }
}
