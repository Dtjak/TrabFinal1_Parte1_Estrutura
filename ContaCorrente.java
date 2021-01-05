package Parte1;

public class ContaCorrente extends ContaBancaria {

    private double taxa_op;

    public ContaCorrente(double taxa_op, int num_conta, double saldo) {
        super(num_conta, saldo);
        this.taxa_op = taxa_op;
    }

    public void descontaTaxa() {
        setSaldo(getSaldo() - getTaxa_op());
    }

    public double getTaxa_op() {
        return taxa_op;
    }

    public void setTaxa_op(double taxa_op) {
        this.taxa_op = taxa_op;
    }

}
