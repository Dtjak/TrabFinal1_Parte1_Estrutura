package lista_04;

import java.util.Scanner;

public class ContaCorrente { //Q_13

    private String num;
    private double saldo, limite;
    private boolean especial;
    
    public ContaCorrente(String num,double saldo, double limite, boolean especial){
        this.num = num;
        this.saldo = saldo;
        this.limite = limite;
        this.especial = especial;
    }

    public String getNum() {
        return num;
    }
    public void setNum(String num) {
        this.num = num;
    }
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public double getLimite() {
        return limite;
    }
    public void setLimite(double limite) {
        this.limite = limite;
    }
    public boolean isEspecial() {
        return especial;
    }
    public void setEspecial(boolean especial) {
        this.especial = especial;
    }
    
    public void deposito(){ //função para depositar uma quantia na conta
        Scanner input = new Scanner(System.in);
        System.out.print("Informe o valor de depósito: ");
        double deposito = input.nextDouble();
        //setSaldo(getSaldo()+deposito);
        saldo +=deposito;
        System.out.println(saldo);
    }
    
    public void saque(){ //função para sacar uma quantia da conta verificando se valor do saque é possível de acordo com o limite e o saldo
        Scanner input = new Scanner(System.in);
        System.out.print("Informe o valor de saque: ");
        double saque = input.nextDouble();
        if(saque>saldo+limite){
            System.out.println("Saque Inválido: valor excede limite da sua conta");
        } else if(saque<=saldo){
            saldo -=saque;
            System.out.println("Saldo restante: R$ "+saldo);
        } else if(saque-saldo<=limite){
            saque -=saldo;
            saldo = -saque;
            System.out.println("Saldo restante: R$ 0,00\n"
                    + "Valor excedente: R$ "+saque);
//exibe o valor excedente do saque retirado, valor que será descontado no próximo depósito
        }
    }
}
