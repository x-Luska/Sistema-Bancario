public class ModelContaBancaria {
    private double saldo;
    private int numeroConta;
    private UsuarioContaBancaria donoDaConta;

    public ModelContaBancaria(double saldo, int numeroConta, UsuarioContaBancaria donoDaConta) {
        this.saldo = saldo;
        this.numeroConta = numeroConta;
        this.donoDaConta = donoDaConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
        }
    }

    public boolean sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            this.saldo -= valor;
            return true;
        }
        return false;
    }

    public boolean transferir(ModelContaBancaria destino, double valor) {
        if (sacar(valor)) {
            destino.depositar(valor);
            return true;
        }
        return false;
    }
}
