package Parte1;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<ContaBancaria> contas = new ArrayList<>(10);
        Banco banco = new Banco(contas);
        double valor;
        int num_conta;

        int op = 0;
        do {
            System.out.print("1 - Criar conta\n"
                    + "2 - Selecionar conta\n"
                    + "3 - Remover conta\n"
                    + "4 - Gerar Relatório\n"
                    + "5 - Finalizar\n"
                    + "Informe a operação desejada: ");
            op = input.nextInt();
            switch (op) {
                case 1: //Criar conta
                    System.out.print("1 - Corrente\n2 - Poupança\nInforme o tipo de conta: ");
                    int tipo = input.nextInt();
                    System.out.print("Informe o número da conta: ");
                    num_conta = input.nextInt();
                    System.out.print("Informe o saldo da conta: ");
                    double saldo = input.nextDouble();
                    switch (tipo) {
                        case 1:
                            System.out.print("Informe a taxa de operação da conta em reais: ");
                            double taxa_op = input.nextDouble();
                            ContaCorrente cc = new ContaCorrente(taxa_op, num_conta, saldo);
                            banco.inserir(cc);
                            System.out.println("Conta criada com sucesso");
                            break;
                        case 2:
                            System.out.print("Informe o limite da conta: ");
                            double limite = input.nextDouble();
                            ContaPoupanca cp = new ContaPoupanca(limite, num_conta, saldo);
                            banco.inserir(cp);
                            System.out.println("Conta criada com sucesso");
                            break;
                        default:
                            System.out.println("Tipo de conta inválida");
                    }
                    break;
                case 2: //Selecionar conta
                    System.out.print("\nInforme o número da conta: ");
                    num_conta = input.nextInt();
                    try {
                        ContaBancaria conta = banco.procurarConta(num_conta);
                        int op_conta = 0;
                        do {
                            System.out.print("1 - Depositar\n"
                                    + "2 - Sacar\n"
                                    + "3 - Transferir\n"
                                    + "4 - Gerar relatório\n"
                                    + "5 - Retornar ao menu anterior\n"
                                    + "Informe a operação desejada: ");
                            op_conta = input.nextInt();
                            switch (op_conta) {
                                case 1:
                                    System.out.print("Informe o valor do depósito: ");
                                    valor = input.nextDouble();
                                    conta.depositar(valor);
                                    System.out.println("Depósito efetuado.");
                                    break;
                                case 2:
                                    System.out.print("Informe o valor do saque: ");
                                    valor = input.nextDouble();
                                    if (conta.sacar(valor) == true) {
                                        System.out.println("Saque efetuado.");
                                    } else {
                                        System.out.println("Valor de saque indisponível\n"
                                                + "Saldo: " + conta.getSaldo() + "\n"
                                                + "Valor de saque inserido: " + valor + "\n");
                                    }
                                case 3:
                                    System.out.print("Informe o número da conta que receberá a transferência: ");
                                    num_conta = input.nextInt();
//                                    try{
//                                        ContaBancaria conta_recebe = banco.procurarConta(num_conta);
//                                    } 
                                    System.out.print("Informe o valor da transferência: ");
                                    valor = input.nextDouble();
                                    conta.transferir(valor, conta);
                            }
                        } while (op_conta != 5);
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Conta Inexistente");
                    }
                    break;

                default:
                    System.out.println("Operação Inválida");
                    break;
            }
        } while (op != 5);
    }
}
