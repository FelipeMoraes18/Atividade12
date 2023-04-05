class ContaBancaria extends Conta {
    public ContaBancaria(String nome, int numero, double saldo) {
        super(nome, numero, saldo);
    }
    public void creditar(double valor) {
        saldo += valor;
    }
}