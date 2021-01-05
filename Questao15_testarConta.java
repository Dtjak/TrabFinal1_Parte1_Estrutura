package lista04_pedrorendeiro;
import java.util.Scanner;

public class Questao15_testarConta {
    public static void main(String[] args) {
        Scanner ent = new Scanner(System.in);
        System.out.println("Entre com as informações da conta");
        System.out.print("Número: ");
        int a = ent.nextInt();
        System.out.print("Saldo: ");
        double b = ent.nextDouble();
        System.out.print("Limite: ");
        double c = ent.nextDouble();
        
        Questao15_Conta contaCorrente = new Questao15_Conta(a, b, c);
        
        System.out.println("\nCONTA CORRENTE"
                + "\nNúmero: " + contaCorrente.getNumero()
                + "\nSaldo: " + contaCorrente.getSaldo()
                + "\nLimite: " + contaCorrente.getLimite()
                + "\nStatus: " + contaCorrente.statusChequeEspecial());
        
        System.out.println("\nSaque um valor: ");
        double saque = ent.nextDouble();
        contaCorrente.Sacar(saque);
        
        System.out.println("Deposite um valor: ");
        double deposito = ent.nextDouble();
        contaCorrente.Depositar(deposito);
        
        System.out.println("\nCONTA CORRENTE"
                + "\nNúmero: " + contaCorrente.getNumero()
                + "\nSaldo: " + contaCorrente.getSaldo()
                + "\nLimite: " + contaCorrente.getLimite()
                + "\nStatus: " + contaCorrente.statusChequeEspecial());
    }
}
