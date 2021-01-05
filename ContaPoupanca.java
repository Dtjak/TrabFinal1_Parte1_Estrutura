package Parte1;

public class ContaPoupanca extends ContaBancaria {

    private double limite;

    public ContaPoupanca(double limite, int num_conta, double saldo) {
        super(num_conta, saldo);
        this.limite = limite;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }
}
