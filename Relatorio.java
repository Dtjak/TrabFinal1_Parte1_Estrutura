package Parte1;

//Para C. Corrente, informa: número, saldo e taxa
//Para C. Poupança, informa: número, saldo e limite



public class Relatorio {
    public Relatorio() {}
    
    public void mostrarDadosCC(ContaCorrente conta) {
        System.out.printf("DADOS DA CONTA\nNúmero da Conta: %d\nSaldo: R$ %.2f\nLimite: R$ %.2f\n",conta.getNum_conta(),conta.getSaldo(),conta.getTaxaDeOperacao());
    }
    
    public void mostrarDadosCP(ContaPoupanca conta) {
        System.out.printf("DADOS DA CONTA\nNúmero da Conta: %d\nSaldo: R$ %.2f\nLimite: R$ %.2f\n",conta.getNum_conta(),conta.getSaldo(),conta.getLimite());
    }
}
