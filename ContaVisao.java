import java.util.Scanner;

public class ContaVisao {
    private Scanner sc;

    public ContaVisao() {
        this.sc = new Scanner(System.in);
    }

    public int mostrarMenu() {
        System.out.println("\n=== Banco Dias ===");
        System.out.println("1. Depositar");
        System.out.println("2. Sacar");
        System.out.println("3. Transferir");
        System.out.println("4. Mostrar Saldo");
        System.out.println("5. Sair");
        System.out.print("Escolha uma opção: ");
        return sc.nextInt(); // Retorna a opção escolhida pelo usuário
    }

    public double solicitarValor(String operacao) {
        System.out.print("Digite o valor para " + operacao + ": ");
        return sc.nextDouble(); // Retorna o valor que o usuário digitou
    }

    public int solicitarNumeroConta() {
        System.out.print("Digite o número da conta: ");
        return sc.nextInt(); // Retorna o número da conta digitado
    }

    public void mostrarMensagem(String mensagem) {
        System.out.println(mensagem);
    }

    public void exibirSaldo(double saldo) {
        System.out.println("Saldo atual: R$" + saldo);
    }
}
