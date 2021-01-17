package Parte1;

//Para C. Corrente, informa: número, saldo e taxa
//Para C. Poupança, informa: número, saldo e limite

public class Relatorio {
    
    public Relatorio() {}
    
    public void mostrarDadosCC(ContaCorrente conta) {
        System.out.printf("DADOS DA CONTA\n"
                + "Número da Conta: %d\n"
                + "Saldo: R$ %.2f\n"
                + "Taxa: R$ %.2f\n",conta.getNum_conta(),conta.getSaldo(),conta.getTaxaDeOperacao());
        //printf apenas para imprimir valores em reais com duas casas decimais 
    }
    
    public void mostrarDadosCP(ContaPoupanca conta) {
        System.out.printf("DADOS DA CONTA\n"
                + "Número da Conta: %d\n"
                + "Saldo: R$ %.2f\n"
                + "Limite: R$ %.2f\n",conta.getNum_conta(),conta.getSaldo(),conta.getLimite());
    }
    
}
