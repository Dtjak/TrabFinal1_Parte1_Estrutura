package Parte1;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<ContaCorrente> contas_c = new ArrayList<>(10);
        ArrayList<ContaPoupanca> contas_p = new ArrayList<>(10);
        Banco banco = new Banco(contas_c, contas_p);
        Relatorio relatorio = new Relatorio();

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
                    System.out.print("\n1 - Corrente\n2 - Poupança\nInforme o tipo de conta: ");
                    int tipo = input.nextInt();
                    System.out.print("\nInforme o número da conta: ");
                    int num_conta = input.nextInt();
                    System.out.print("Informe o saldo da conta: ");
                    double saldo = input.nextDouble();
                    switch (tipo) {
                        case 1:
                            System.out.print("Informe a taxa de operação da conta em reais: ");
                            double taxaDeOperacao = input.nextDouble();
                            ContaCorrente cc = new ContaCorrente(taxaDeOperacao, num_conta, saldo);
                            banco.inserirCC(cc);
                            System.out.println("Conta criada com sucesso\n");
                            break;
                        case 2:
                            System.out.print("Informe o limite da conta: ");
                            double limite = input.nextDouble();
                            ContaPoupanca cp = new ContaPoupanca(limite, num_conta, saldo);
                            banco.inserirCP(cp);
                            System.out.println("Conta criada com sucesso\n");
                            break;
                        default:
                            System.out.println("Tipo de conta inválida");
                    }
                    break;
                case 2: //Selecionar conta
                    if (contas_c.isEmpty() == false && contas_p.isEmpty() == false) {
                        System.out.print("1 - Corrente\n2 - Poupança\nInforme o tipo de conta: ");
                        int sel_tipo = input.nextInt();
                        System.out.print("\nInforme o número da conta: ");
                        int sel_num_conta = input.nextInt();
                        switch (sel_tipo) {
                            case 1:
                                if (contas_c.isEmpty() == false) {
                                    ContaCorrente sel_cc = banco.procurarContaC(sel_num_conta);
                                    if (sel_cc != null) {
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
                                                case 1: //Depositar cc
                                                    System.out.print("Informe o valor do depósito: ");
                                                    double sel_valor = input.nextDouble();
                                                    sel_cc.depositar(sel_valor);
                                                    System.out.println("Depósito efetuado.");
                                                    break;
                                                case 2: //Sacar cc
                                                    System.out.print("Informe o valor do saque: ");
                                                    sel_valor = input.nextDouble();
                                                    if (sel_cc.sacar(sel_valor) == true) {
                                                        System.out.println("Saque efetuado.");
                                                    } else {
                                                        System.out.println("Valor de saque indisponível\n"
                                                                + "Saldo: " + sel_cc.getSaldo() + "\n"
                                                                + "Valor de saque inserido: " + sel_valor + "\n");
                                                    }
                                                    break;
                                                case 3: //Transferir cc
                                                    System.out.print("Informe o número da conta que receberá a transferência: ");
                                                    int recebe_num_conta = input.nextInt();
                                                    ContaBancaria conta_c_recebe = banco.procurarContaC(recebe_num_conta);
                                                    ContaBancaria conta_p_recebe = banco.procurarContaP(recebe_num_conta);
                                                    if (conta_c_recebe != null) {
                                                        System.out.print("Informe o valor da transferência: ");
                                                        double transf_valor = input.nextDouble();
                                                        sel_cc.transferir(transf_valor, conta_c_recebe);
                                                    } else if (conta_p_recebe != null) {
                                                        System.out.print("Informe o valor da transferência: ");
                                                        double transf_valor = input.nextDouble();
                                                        sel_cc.transferir(transf_valor, conta_p_recebe);
                                                    }
                                                    break;
                                                case 4:
                                                    relatorio.mostrarDadosCC(sel_cc);
                                                    break;
                                                case 5:
                                                    break;
                                                default:
                                                    System.out.println("Operação Inválida");
                                            }
                                        } while (op_contaC != 5);
                                    } else {
                                        System.out.println("Conta Inexistente");
                                    }
                                } else {
                                    System.out.println("Não há contas corrente registradas");
                                }
                                break;
                            case 2: //ContaPoupança
                                if (contas_p.isEmpty() == false) {
                                    ContaPoupanca sel_cp = banco.procurarContaP(sel_num_conta);
                                    if (sel_cp != null) {
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
                                                case 1: //Depositar cp
                                                    System.out.print("Informe o valor do depósito: ");
                                                    double sel_valor = input.nextDouble();
                                                    sel_cp.depositar(sel_valor);
                                                    System.out.println("Depósito efetuado.");
                                                    break;
                                                case 2: //Sacar cp
                                                    System.out.print("Informe o valor do saque: ");
                                                    sel_valor = input.nextDouble();
                                                    if (sel_cp.sacar(sel_valor) == true) {
                                                        System.out.println("Saque efetuado.");
                                                    } else {
                                                        System.out.println("Valor de saque indisponível\n"
                                                                + "Saldo: " + sel_cp.getSaldo() + "\n"
                                                                + "Valor de saque inserido: " + sel_valor + "\n");
                                                    }
                                                    break;
                                                case 3: //Transferir cp
                                                    System.out.print("Informe o número da conta que receberá a transferência: ");
                                                    int recebe_num_conta = input.nextInt();
                                                    ContaBancaria conta_c_recebe = banco.procurarContaC(recebe_num_conta);
                                                    ContaBancaria conta_p_recebe = banco.procurarContaP(recebe_num_conta);
                                                    if (conta_c_recebe != null) {
                                                        System.out.print("Informe o valor da transferência: ");
                                                        double transf_valor = input.nextDouble();
                                                        sel_cp.transferir(transf_valor, conta_c_recebe);
                                                    } else if (conta_p_recebe != null) {
                                                        System.out.print("Informe o valor da transferência: ");
                                                        double transf_valor = input.nextDouble();
                                                        sel_cp.transferir(transf_valor, conta_p_recebe);
                                                    }
                                                    break;
                                                case 4:
                                                    relatorio.mostrarDadosCP(sel_cp);
                                                    break;
                                                case 5:
                                                    break;
                                            }
                                        } while (op_contaP != 5);
                                    } else {
                                        System.out.println("Conta Inexistente");
                                    }
                                } else {
                                    System.out.println("Não há contas poupança registradas");
                                }
                                break;
                            default: //Selecionando tipo de conta conta
                                System.out.println("Tipo de conta inválida");
                        }
                        break;
                    } else {
                        System.out.println("Não há contas registradas");
                    }
                case 3: //Excluir conta
                    if (contas_c.isEmpty() == false && contas_p.isEmpty() == false) {
                        System.out.print("\nInforme o número da conta que deseja excluir: ");
                        int del_num_conta = input.nextInt();
                        ContaCorrente removidaC = banco.procurarContaC(del_num_conta);
                        ContaPoupanca removidaP = banco.procurarContaP(del_num_conta);
                        if (removidaC != null) {
                            banco.removerCC(removidaC);
                            System.out.println("Conta removida com sucesso");
                        } else if (removidaP != null) {
                            banco.removerCP(removidaP);
                            System.out.println("Conta removida com sucesso");
                        } else {
                            System.out.println("Conta inexistente");
                        }
                    } else {
                        System.out.println("Não há contas registradas");
                    }
                    break;
                case 4: //Gerar relatório
                    if (contas_c.isEmpty() == false && contas_p.isEmpty() == false) {
                        System.out.print("\n=====Contas Corrente=====\n");
                        for (int i = 0; i < banco.getContas_c().size(); i++) {
                            relatorio.mostrarDadosCC(banco.getContas_c().get(i));
                            System.out.println();
                        }
                        System.out.print("\n=====Contas Poupança=====\n");
                        for (int i = 0; i < banco.getContas_p().size(); i++) {
                            relatorio.mostrarDadosCP(banco.getContas_p().get(i));
                            System.out.println();
                        }
                    } else {
                        System.out.println("Não há contas registradas");
                    }
                    break;
                case 5:
                    System.out.println("Aplicação encerrada");
                default:
                    System.out.println("Operação Inválida");
                    break;
            }
        } while (op != 5);
    }
}
