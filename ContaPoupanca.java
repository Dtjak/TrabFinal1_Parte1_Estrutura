package Parte1;

public class ContaPoupanca  extends  ContaBancaria{
    private double limite;
    
    public ContaPoupanca(int a, double b, double c) {
        super(a, b);
        this.limite = c;
    }
    
    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }
}