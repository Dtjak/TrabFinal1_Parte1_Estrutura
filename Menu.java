package Parte1;

import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int op = input.nextInt();
        switch (op) {
            case 1: //Criar conta
                System.out.print("1 - Corrente\n2 - Poupança\nInforme o tipo de conta: ");
                int tipo = input.nextInt();
                System.out.print("Informe o número da conta: ");
                int num_conta = input.nextInt();
                System.out.print("Informe o saldo da conta: ");
                double saldo = input.nextDouble();
                switch (tipo) {
                    case 1:
                        System.out.print("Informe a taxa de operação da conta em reais: ");
                        double taxa_op = input.nextDouble();
                        ContaCorrente cc = new ContaCorrente(taxa_op, num_conta, saldo);
                        Banco.inserir(cc);
                        break;
                    case 2:
                        System.out.print("Informe a taxa de operação da conta em reais: ");
                        double limite = input.nextDouble();
                        ContaPoupanca cp = new ContaPoupanca(limite,num_conta,saldo);
                        Banco.remover(cp);
                        break;
                    default:
                        System.out.println("Tipo de conta inválida");
                }

        }
    }
}
