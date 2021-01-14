package Parte1;

public class ContaCorrente extends ContaBancaria {

    private double taxaDeOperacao;

    public ContaCorrente(double taxaDeOperacao, int num_conta, double saldo) {
        super(num_conta, saldo);
        this.taxaDeOperacao = taxaDeOperacao;
    }

    @Override
    public Boolean sacar(double valor) {
        if (getSaldo() > valor + getTaxaDeOperacao()) {
            setSaldo(getSaldo() - valor - getTaxaDeOperacao());
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void depositar(double valor) {
        setSaldo(getSaldo() + valor - getTaxaDeOperacao());
    }

    @Override
    public void transferir(double valor, ContaBancaria conta) {
        if (sacar(valor) == true) {
            conta.depositar(valor);
        } else {
            System.out.println("Saldo insuficiente para transferência");
        }
    }

    public double getTaxaDeOperacao() {
        return taxaDeOperacao;
    }

    public void setTaxaDeOperacao(double taxaDeOperacao) {
        this.taxaDeOperacao = taxaDeOperacao;
    }

}
