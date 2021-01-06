package Parte1;

//Para C. Corrente, informa: número, saldo e taxa
//Para C. Poupança, informa: número, saldo e limite



public class Relatorio {
    public Relatorio() {}
    
    public void mostrarDadosCC(ContaCorrente conta) {
        System.out.println("DADOS DA CONTA"
                + "\nNúmero: " + conta.getNum_conta()
                + "\nSaldo: " + conta.getSaldo()
                + "\nTaxa: " + conta.getTaxa_op());
    }
    
    public void mostrarDadosCP(ContaPoupanca conta) {
        System.out.println("DADOS DA CONTA"
                + "\nNúmero: " + conta.getNum_conta()
                + "\nSaldo: " + conta.getSaldo()
                + "\nLimite: " + conta.getLimite());
    }
}
