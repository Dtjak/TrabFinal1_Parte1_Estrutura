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
                    System.out.print("\n1 - Corrente\n"
                            + "2 - Poupança\n"
                            + "Informe o tipo de conta: ");
                    int tipo = input.nextInt();
                    while (tipo != 1 && tipo != 2) { //caso o usuário digite um tipo de conta indisponível, pedir novamente
                        System.out.print("\nTipo de conta inválido.\n"
                                + "1 - Corrente\n"
                                + "2 - Poupança\n"
                                + "Informe o tipo de conta: ");
                        tipo = input.nextInt();
                    }
                    System.out.print("\nInforme o número da conta: ");
                    int num_conta = input.nextInt();
                    while ((tipo == 1 && banco.procurarContaC(num_conta) != null) || (tipo == 2 && banco.procurarContaP(num_conta) != null)) { 
                    /*para verificar se já existe uma conta com o mesmo número digitado para o número da conta sendo criada, 
                    caso exista, pedir outro número*/
                        System.out.print("Número de conta já utilizado.\n\n"
                                + "Informe outro número: ");
                        num_conta = input.nextInt();
                    }
                    while (num_conta <= 0) { //caso o usuário digite um número negativo para a conta, pede novamente, pois não é permitido
                                System.out.print("O número da conta deve ser positivo.\n\n"
                                        + "Informe um número positivo: ");
                                num_conta = input.nextInt();
                            }
                    System.out.print("Informe o saldo da conta: ");
                    double saldo = input.nextDouble();
                    switch (tipo) {
                        case 1:
                            System.out.print("Informe a taxa de operação da conta em reais: ");
                            double taxaDeOperacao = input.nextDouble();
                            while (taxaDeOperacao < 0) { //caso o usuário digite um valor negativo para a taxa, pede novamente, pois não é permitido
                                System.out.print("O valor da taxa de operação deve ser positivo.\n\n"
                                        + "Informe a taxa de operação da conta em reais: ");
                                taxaDeOperacao = input.nextDouble();
                            }
                            ContaCorrente cc = new ContaCorrente(taxaDeOperacao, num_conta, saldo);
                            banco.inserirCC(cc);
                            System.out.println("Conta criada com sucesso.\n");
                            break;
                        case 2:
                            System.out.print("Informe o limite da conta: ");
                            double limite = input.nextDouble();
                            while (limite < 0) { //caso o usuário digite um valor negativo para o limite, pede novamente, pois não é permitido
                                System.out.print("O valor do limite deve ser positivo.\n\n"
                                        + "Informe o limite da conta: ");
                                limite = input.nextDouble();
                            }
                            ContaPoupanca cp = new ContaPoupanca(limite, num_conta, saldo);
                            banco.inserirCP(cp);
                            System.out.println("Conta criada com sucesso.\n");
                            break;
                    }
                    break;

                case 2: //Selecionar
                    if (!contas_c.isEmpty() || !contas_p.isEmpty()) { 
                    //caso não haja nenhuma conta registrada, não é possível selecionar uma conta e já exibe uma mensagem (linhas 323)
                        System.out.print("\nInforme o número da conta: ");
                        int sel_num_conta = input.nextInt();
                        ContaCorrente sel_cc = banco.procurarContaC(sel_num_conta);
                        ContaPoupanca sel_cp = banco.procurarContaP(sel_num_conta);
                        int sel_tipo;
                        if (sel_cc != null && sel_cp != null) { 
                        /*caso haja duas contas de tipos diferentes com o mesmo número, 
                        pede pro usuário informar o tipo da conta que deseja selecionar*/
                            System.out.print("\nHá duas contas com o mesmo número.\n"
                                    + "1 - Conta Corrente\n"
                                    + "2 - Conta Poupança\n"
                                    + "Informe o tipo da conta que deseja selecionar: ");
                            sel_tipo = input.nextInt();
                        } else if (sel_cc == null && sel_cp == null) { 
                        //caso não exista uma conta com o número digitado, exibe a mensagem de conta inexistente(linha 317)
                            sel_tipo = 3;
                        } else if (sel_cc != null) { //se existir uma conta corrente, significa que não existe uma conta poupança com esse número
                            sel_tipo = 1;
                        } else { //se não existir uma conta corrente, significa que há uma conta poupança com esse número
                            sel_tipo = 2;
                        }
                        switch (sel_tipo) {
                            case 1: //menu para conta corrente
                                int op_contaC = 0;
                                do {
                                    System.out.print("\n1 - Depositar\n"
                                            + "2 - Sacar\n"
                                            + "3 - Transferir\n"
                                            + "4 - Gerar relatório\n"
                                            + "5 - Retornar ao menu anterior\n"
                                            + "Informe a operação desejada: ");
                                    op_contaC = input.nextInt();
                                    System.out.println("");
                                    switch (op_contaC) {
                                        case 1: //Depositar cc
                                            System.out.print("Informe o valor do depósito: ");
                                            double sel_valor = input.nextDouble();
                                            while (sel_valor < 0) { //caso o usuário digite um valor negativo, pede novamente, pois não é permitido
                                                System.out.print("O valor do depósito deve ser positivo.\n\n"
                                                        + "Informe o valor do depósito: ");
                                                sel_valor = input.nextDouble();
                                            }
                                            sel_cc.depositar(sel_valor);
                                            System.out.println("Depósito efetuado.");
                                            break;
                                        case 2: //Sacar cc
                                            System.out.print("Informe o valor do saque: ");
                                            sel_valor = input.nextDouble();
                                            while (sel_valor < 0) { //caso o usuário digite um valor negativo, pede novamente, pois não é permitido
                                                System.out.println("O valor do saque deve ser positivo.\n\n"
                                                        + "Informe o valor do saque: ");
                                                sel_valor = input.nextDouble();
                                            }
                                            if (sel_cc.sacar(sel_valor) == true) { //verifica se saque é possível e, se sim, exibe mensagem
                                                System.out.println("Saque efetuado.");
                                            } else {
                                                System.out.println("\nValor de saque indisponível\n" //caso não seja, exibe o saldo disponível
                                                        + "Saldo: " + sel_cc.getSaldo() + "\n"
                                                        + "Valor de saque inserido: " + sel_valor );
                                            }
                                            break;
                                        case 3: //Transferir cc
                                            if (contas_c.size() + contas_p.size() > 1) { 
                                            //verifica se há mais de uma conta no banco, pois, se houver apenas uma, não é possível transferir 
                                                System.out.print("\nInforme o número da conta que receberá a transferência: ");
                                                int recebe_num_conta = input.nextInt();
                                                ContaCorrente conta_c_recebe = banco.procurarContaC(recebe_num_conta);
                                                ContaPoupanca conta_p_recebe = banco.procurarContaP(recebe_num_conta);
                                                int transf_tipo;
                                                if ((conta_c_recebe != null && conta_p_recebe != null) && sel_cc.getNum_conta() != recebe_num_conta) { 
                                                /*caso haja duas contas de tipos diferentes com o mesmo número, 
                                                pede pro usuário informar o tipo da conta para a qual deseja transferir*/
                                                    System.out.print("\nHá duas contas com o mesmo número.\n"
                                                            + "1 - Conta Corrente\n"
                                                            + "2 - Conta Poupança\n"
                                                            + "Informe o tipo da conta que deseja selecionar: ");
                                                    transf_tipo = input.nextInt();
                                                } else if (conta_c_recebe == null && conta_p_recebe == null) {
                                                    transf_tipo = 3;
                                                } else if (conta_p_recebe != null) {
                                                    transf_tipo = 2;
                                                } else {
                                                    transf_tipo = 1;
                                                }
                                                switch (transf_tipo) {
                                                    case 1:
                                                        System.out.print("Informe o valor da transferência: ");
                                                        double transf_valor = input.nextDouble();
                                                        while (transf_valor < 0) { 
                                                        //caso o usuário digite um valor negativo, pede novamente, pois não é permitido
                                                            System.out.print("O valor da transferência deve ser positivo.\n\n"
                                                                    + "Informe o valor da transferência: "); 
                                                            transf_valor = input.nextDouble();
                                                        }
                                                        sel_cc.transferir(transf_valor, conta_c_recebe);
                                                        conta_c_recebe.descontaTaxa();
                                                        System.out.println("Transferência efetuada.");
                                                        break;
                                                    case 2:
                                                        System.out.print("Informe o valor da transferência: ");
                                                        transf_valor = input.nextDouble();
                                                        while (transf_valor < 0) {
                                                            System.out.print("O valor da transferência deve ser positivo.\n\n"
                                                                    + "Informe o valor da transferência: ");
                                                            transf_valor = input.nextDouble();
                                                        }
                                                        sel_cc.transferir(transf_valor, conta_p_recebe);
                                                        System.out.println("Transferência efetuada.");
                                                        break;
                                                    case 3:
                                                        System.out.println("Conta inexistente.");
                                                        break;
                                                    default:
                                                        System.out.println("Tipo de conta inválido.");
                                                }
                                            } else {
                                                System.out.println("Não há outra conta registrada para efetuar uma transferência.");
                                            }
                                            break;
                                        case 4:
                                            relatorio.mostrarDadosCC(sel_cc);
                                            break;
                                        case 5:
                                            System.out.println();
                                            break;
                                        default:
                                            System.out.println("Operação Inválida.");
                                    }
                                } while (op_contaC != 5);
                                break;
                            case 2: //menu para conta poupança
                                int op_contaP = 0;
                                do {
                                    System.out.print("\n1 - Depositar\n"
                                            + "2 - Sacar\n"
                                            + "3 - Transferir\n"
                                            + "4 - Gerar relatório\n"
                                            + "5 - Retornar ao menu anterior\n"
                                            + "Informe a operação desejada: ");
                                    op_contaP = input.nextInt();
                                    System.out.println("");
                                    switch (op_contaP) {
                                        case 1: //Depositar cp
                                            System.out.print("Informe o valor do depósito: ");
                                            double sel_valor = input.nextDouble();
                                            while (sel_valor < 0) {
                                                System.out.print("O valor do depósito deve ser positivo.\n\n"
                                                        + "Informe o valor do depósito: ");
                                                sel_valor = input.nextDouble();
                                            }
                                            sel_cp.depositar(sel_valor);
                                            System.out.println("Depósito efetuado.");
                                            break;
                                        case 2: //Sacar cp
                                            System.out.print("Informe o valor do saque: ");
                                            sel_valor = input.nextDouble();
                                            while (sel_valor < 0) {
                                                System.out.println("O valor do saque deve ser positivo.\n\n"
                                                        + "Informe o valor do saque: ");
                                                sel_valor = input.nextDouble();
                                            }
                                            if (sel_cp.sacar(sel_valor) == true) {
                                                System.out.println("Saque efetuado.");
                                            } else {
                                                System.out.println("\nValor de saque indisponível\n"
                                                        + "Saldo: " + sel_cp.getSaldo() + "\n"
                                                        + "Valor de saque inserido: " + sel_valor);
                                            }
                                            break;
                                        case 3: //Transferir cp
                                            if (contas_c.size() + contas_p.size() > 1) {
                                                System.out.print("\nInforme o número da conta que receberá a transferência: ");
                                                int recebe_num_conta = input.nextInt();
                                                ContaCorrente conta_c_recebe = banco.procurarContaC(recebe_num_conta);
                                                ContaPoupanca conta_p_recebe = banco.procurarContaP(recebe_num_conta);
                                                int transf_tipo;
                                                if ((conta_c_recebe != null && conta_p_recebe != null)&& sel_cc.getNum_conta() != recebe_num_conta) {
                                                    System.out.print("\nHá duas contas com o mesmo número.\n"
                                                            + "1 - Conta Corrente\n"
                                                            + "2 - Conta Poupança\n"
                                                            + "Informe o tipo da conta que deseja selecionar: ");
                                                    transf_tipo = input.nextInt();
                                                } else if (conta_c_recebe == null && conta_p_recebe == null) {
                                                    transf_tipo = 3;
                                                } else if (conta_c_recebe != null) {
                                                    transf_tipo = 1;
                                                } else {
                                                    transf_tipo = 2;
                                                }
                                                switch (transf_tipo) {
                                                    case 1:
                                                        System.out.print("Informe o valor da transferência: ");
                                                        double transf_valor = input.nextDouble();
                                                        while (transf_valor < 0) {
                                                            System.out.print("O valor da transferência deve ser positivo.\n\n"
                                                                    + "Informe o valor da transferência: ");
                                                            transf_valor = input.nextDouble();
                                                        }
                                                        sel_cp.transferir(transf_valor, conta_c_recebe);
                                                        conta_c_recebe.descontaTaxa(); //devolve a taxa de operação da conta destino
                                                        System.out.println("Transferência efetuada.");
                                                        break;
                                                    case 2:
                                                        System.out.print("Informe o valor da transferência: ");
                                                        transf_valor = input.nextDouble();
                                                        while (transf_valor < 0) {
                                                            System.out.print("O valor da transferência deve ser positivo.\n\n"
                                                                    + "Informe o valor da transferência: ");
                                                            transf_valor = input.nextDouble();
                                                        }
                                                        sel_cp.transferir(transf_valor, conta_p_recebe);
                                                        System.out.println("Transferência efetuada.");
                                                        break;
                                                    case 3:
                                                        System.out.println("Conta inexistente.");
                                                        break;
                                                    default:
                                                        System.out.println("Tipo de conta inválido.");
                                                }
                                            } else {
                                                System.out.println("Não há outra conta registrada para efetuar uma transferência.");
                                            }
                                            break;
                                        case 4:
                                            relatorio.mostrarDadosCP(sel_cp);
                                            break;
                                        case 5:
                                            System.out.println();
                                            break;
                                    }
                                } while (op_contaP != 5);
                                break;
                            case 3:
                                System.out.println("Conta inexistente.\n");
                                break;
                            default:
                                System.out.println("Tipo de conta inválido.\n");
                        }
                    } else {
                        System.out.println("Não há contas registradas.\n");
                    }
                    break;

                case 3: //Excluir conta
                    if (!contas_c.isEmpty() || !contas_p.isEmpty()) { //caso não haja nenhuma conta registrada no banco, não é possível excluir
                        System.out.print("Informe o número da conta que deseja excluir: ");
                        int del_num_conta = input.nextInt();
                        ContaCorrente del_cc = banco.procurarContaC(del_num_conta);
                        ContaPoupanca del_cp = banco.procurarContaP(del_num_conta);
                        int del_tipo;
                        if (del_cc != null && del_cp != null) { 
                        /*caso haja duas contas de tipos diferentes com o mesmo número, 
                        pede pro usuário informar o tipo da conta que deseja excluir*/
                            System.out.print("Há duas contas com o mesmo número.\n"
                                    + "1 - Conta Corrente\n"
                                    + "2 - Conta Poupança\n"
                                    + "Informe o tipo da conta que deseja selecionar: ");
                            del_tipo = input.nextInt();
                            System.out.println();
                        } else if (del_cc == null && del_cp == null) {
                            del_tipo = 3;
                        } else if (del_cc != null) {
                            del_tipo = 1;
                        } else {
                            del_tipo = 2;
                        }
                        switch (del_tipo) {
                            case 1:
                                banco.removerCC(del_cc);
                                System.out.println("Conta removida com sucesso.\n");
                                break;
                            case 2:
                                banco.removerCP(del_cp);
                                System.out.println("Conta removida com sucesso.\n");
                                break;
                            case 3:
                                System.out.println("Conta inexistente.\n");
                                break;
                        }
                    } else {
                        System.out.println("Não há contas registradas.\n");
                    }
                    break;

                case 4: //Gerar relatório
                    if (!contas_c.isEmpty() || !contas_p.isEmpty()) { //caso não haja nenhuma conta registrada no banco, não tentará exibir nada
                        if (!contas_c.isEmpty()) { //verifica se há contas corrente para exibir dados
                            System.out.print("\n=====Contas Corrente=====\n");
                            for (int i = 0; i < banco.getContas_c().size(); i++) {
                                relatorio.mostrarDadosCC(banco.getContas_c().get(i));
                                System.out.println();
                            }
                        }
                        if (!contas_p.isEmpty()) {
                            System.out.print("\n=====Contas Poupança=====\n");
                            for (int i = 0; i < banco.getContas_p().size(); i++) {
                                relatorio.mostrarDadosCP(banco.getContas_p().get(i));
                                System.out.println();
                            }
                        }
                    } else {
                        System.out.println("Não há contas registradas.\n");
                    }
                    break;

                case 5: 
                    System.out.println("Aplicação encerrada.\n");
                    break;
                default:
                    System.out.println("Operação Inválida.\n");
            }
        } while (op != 5);
    }
    
}
