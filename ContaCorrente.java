package Parte1;

public class ContaCorrente extends ContaBancaria {

    private double taxaDeOperacao;

    public ContaCorrente(double taxaDeOperacao, int num_conta, double saldo) {
        super(num_conta, saldo);
        this.taxaDeOperacao = taxaDeOperacao;
    }

    @Override
    public Boolean sacar(double valor) {
        if (getSaldo() > valor + getTaxaDeOperacao()) { //deve haver saldo para descontar a taxa de operação 
            setSaldo(getSaldo() - valor - getTaxaDeOperacao()); //desconta valor de saque e taxa de operação
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void depositar(double valor) {
        setSaldo(getSaldo() + valor - getTaxaDeOperacao()); //soma o valor depositado e desconta a taxa de operação
    }

    @Override
    public void transferir(double valor, ContaBancaria conta) {
        if (sacar(valor) == true) { //verifica se é possível fazer saque e, se for possível,
            conta.depositar(valor);  //deposita o valor correspondente na conta direcionada
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
    
    public void descontaTaxa() {
        setSaldo(getSaldo() + getTaxaDeOperacao());
    }

}
