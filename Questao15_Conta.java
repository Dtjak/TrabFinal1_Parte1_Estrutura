package lista04_pedrorendeiro;

public class Questao15_Conta {
    private int numero;
    private double saldo;
    private double limite;
    private boolean status;
    
    public Questao15_Conta(int a, double b, double c) {
        this.numero = a;
        this.saldo = b;
        this.limite = c;
        this.status = saldo < 0;
    }
    
    public void Sacar (double a) {
        if (a <= saldo + limite) {
            saldo -= a;
            status = saldo < 0;
        }
        else
            System.out.println("Valor indisponível para saque");
        
    }
    
    public void Depositar (double a) {
        saldo += a;
        status = saldo < 0;
    }
    
    public double consultarSaldo () {
        return saldo;
    }
    
    public String statusChequeEspecial () {
        if(status)
            return "Cheque especial em uso";
        else
            return "Saldo normal em uso";
    }
    
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
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

    public boolean getStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
}
