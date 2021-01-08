package Parte1;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<ContaBancaria> contas = new ArrayList<>(10);
        Banco banco = new Banco();
        Relatorio relatorio = new Relatorio();
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
                            ContaCorrente cc = new ContaCorrente(taxa_op, num_conta, saldo); //não posso ter vários objetos com nome "cc"
                            banco.inserirCC(cc);
                            System.out.println("Conta criada com sucesso");
                            break;
                        case 2:
                            System.out.print("Informe o limite da conta: ");
                            double limite = input.nextDouble();
                            ContaPoupanca cp = new ContaPoupanca(limite, num_conta, saldo);
                            banco.inserirCP(cp);
                            System.out.println("Conta criada com sucesso");
                            break;
                        default:
                            System.out.println("Tipo de conta inválida");
                    }
                    break;
                case 2: //Selecionar conta
                    System.out.print("1 - Corrente\n2 - Poupança\nInforme o tipo de conta: ");
                    tipo = input.nextInt();
                    System.out.print("\nInforme o número da conta: ");
                    num_conta = input.nextInt();
                    try {
                        switch (tipo) {
                            case 1: 
                                ContaCorrente conta_corrente = banco.procurarContaC(num_conta);
                                int op_contaC = 0;
                                do {
                                    System.out.print("1 - Depositar\n"
                                            + "2 - Sacar\n"
                                            + "3 - Transferir\n"
                                            + "4 - Gerar relatório\n"
                                            + "5 - Retornar ao menu anterior\n"
                                            + "Informe a operação desejada: ");
                                    op_contaC = input.nextInt();
                                    switch (op_contaC) {
                                        case 1:
                                            System.out.print("Informe o valor do depósito: ");
                                            valor = input.nextDouble();
                                            conta_corrente.depositar(valor);
                                            System.out.println("Depósito efetuado.");
                                            break;
                                        case 2:
                                            System.out.print("Informe o valor do saque: ");
                                            valor = input.nextDouble();
                                            if (conta_corrente.sacar(valor) == true) {
                                                System.out.println("Saque efetuado.");
                                            } else {
                                                System.out.println("Valor de saque indisponível\n"
                                                        + "Saldo: " + conta_corrente.getSaldo() + "\n"
                                                        + "Valor de saque inserido: " + valor + "\n");
                                            }
                                            break;
//                                        case 3:
//                                            System.out.print("Informe o número da conta que receberá a transferência: ");
//                                            num_conta = input.nextInt();
//                                            try{
//                                                ContaBancaria conta_recebe = banco.procurarConta(num_conta);
//                                            } 
//                                            System.out.print("Informe o valor da transferência: ");
//                                            valor = input.nextDouble();
//                                            conta_corrente.transferir(valor, conta);
//                                            break;
                                    }
                                } while (op_contaC != 5);
                            case 2:
                                ContaPoupanca conta_poupanca = banco.procurarContaP(num_conta);
                                int op_contaP = 0;
                                do {
                                    System.out.print("1 - Depositar\n"
                                            + "2 - Sacar\n"
                                            + "3 - Transferir\n"
                                            + "4 - Gerar relatório\n"
                                            + "5 - Retornar ao menu anterior\n"
                                            + "Informe a operação desejada: ");
                                    op_contaP = input.nextInt();
                                    switch (op_contaP) {
                                        case 1:
                                            System.out.print("Informe o valor do depósito: ");
                                            valor = input.nextDouble();
                                            conta_poupanca.depositar(valor);
                                            System.out.println("Depósito efetuado.");
                                            break;
                                        case 2:
                                            System.out.print("Informe o valor do saque: ");
                                            valor = input.nextDouble();
                                            if (conta_poupanca.sacar(valor) == true) {
                                                System.out.println("Saque efetuado.");
                                            } else {
                                                System.out.println("Valor de saque indisponível\n"
                                                        + "Saldo: " + conta_poupanca.getSaldo() + "\n"
                                                        + "Valor de saque inserido: " + valor + "\n");
                                            }
                                            break;
//                                        case 3:
//                                            System.out.print("Informe o número da conta que receberá a transferência: ");
//                                            num_conta = input.nextInt();
//        //                                    try{
//        //                                        ContaBancaria conta_recebe = banco.procurarConta(num_conta);
//        //                                    } 
//                                            System.out.print("Informe o valor da transferência: ");
//                                            valor = input.nextDouble();
//                                            conta_poupanca.transferir(valor, conta);
//                                            break;
                                    }
                                } while (op_contaP != 5);
                            default:
                                System.out.println("Tipo de conta inválida");
                        }
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Conta Inexistente");
                    }
                    break;
                case 3: //Excluir conta
                    System.out.print("\nInforme o número da conta: ");
                    num_conta = input.nextInt();
                    ContaCorrente removidaC = banco.procurarContaC(num_conta);
                    if (removidaC != null) {
                        banco.removerCC(removidaC);
                        System.out.println("Conta removida com sucesso");
                    }
                    else {
                        ContaPoupanca removidaP = banco.procurarContaP(num_conta);
                        if (removidaP != null) {
                            banco.removerCP(removidaP);
                            System.out.println("Conta removida com sucesso");
                        }
                        else
                            System.out.println("Conta inexistente");
                    }
                    break;
                case 4: //Gerar relatório
                    System.out.print("\nContas Corrente");
                    for(int i = 0; i < banco.getContasC().size(); i++) {
                        relatorio.mostrarDados(banco.getContasC().get(i));
                    }
                    System.out.print("\nContas Poupança");
                    for(int i = 0; i < banco.getContasP().size(); i++) {
                        relatorio.mostrarDadosCP(banco.getContasP().get(i));
                    }
                    break;
                default:
                    System.out.println("Operação Inválida");
                    break;
            }
        } while (op != 5);
    }
}
