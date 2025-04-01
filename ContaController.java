import java.util.HashMap;
import java.util.Map;

public class ContaController {
    private Map<Integer, ModelContaBancaria> contas;
    private ContaVisao visao;

    public ContaController() {
        this.contas = new HashMap<>();
        this.visao = new ContaVisao();
        
        contas.put(1, new ModelContaBancaria(0, 1, new UsuarioContaBancaria("Lucas", "987.654.321-00")));
        contas.put(2, new ModelContaBancaria(0, 2, new UsuarioContaBancaria("João", "123.456.789-00")));
    }

    public void iniciar() {
        while (true) {
            int opcao = visao.mostrarMenu(); 
          
            switch (opcao) {
                case 1 -> depositar();
                case 2 -> sacar();
                case 3 -> transferir();
                case 4 -> mostrarSaldo();
                case 5 -> {
                    visao.mostrarMensagem("Saindo...");
                    return;
                }
                default -> visao.mostrarMensagem("Opção inválida.");
            }
        }
    }

    private void depositar() {
        int numeroConta = visao.solicitarNumeroConta();
        ModelContaBancaria conta = contas.get(numeroConta);

        if (conta != null) {
            double valor = visao.solicitarValor("depositar");
            conta.depositar(valor);
            visao.mostrarMensagem("Depósito realizado com sucesso!");
        } else {
            visao.mostrarMensagem("Conta não encontrada.");
        }
    }

    private void sacar() {
        int numeroConta = visao.solicitarNumeroConta();
        ModelContaBancaria conta = contas.get(numeroConta);

        if (conta != null) {
            double valor = visao.solicitarValor("sacar");
            if (conta.sacar(valor)) {
                visao.mostrarMensagem("Saque realizado com sucesso!");
            } else {
                visao.mostrarMensagem("Saldo insuficiente.");
            }
        } else {
            visao.mostrarMensagem("Conta não encontrada.");
        }
    }

    private void transferir() {
        int origemNum = visao.solicitarNumeroConta();
        ModelContaBancaria origem = contas.get(origemNum);

        if (origem != null) {
            int destinoNum = visao.solicitarNumeroConta();
            ModelContaBancaria destino = contas.get(destinoNum);

            if (destino != null) {
                double valor = visao.solicitarValor("transferir");
                if (origem.transferir(destino, valor)) {
                    visao.mostrarMensagem("Transferência realizada com sucesso!");
                } else {
                    visao.mostrarMensagem("Erro na transferência.");
                }
            } else {
                visao.mostrarMensagem("Conta de destino não encontrada.");
            }
        } else {
            visao.mostrarMensagem("Conta de origem não encontrada.");
        }
    }

    private void mostrarSaldo() {
        int numeroConta = visao.solicitarNumeroConta();
        ModelContaBancaria conta = contas.get(numeroConta);

        if (conta != null) {
            visao.exibirSaldo(conta.getSaldo());
        } else {
            visao.mostrarMensagem("Conta não encontrada.");
        }
    }
}
