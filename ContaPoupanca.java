class ContaPoupanca extends Conta {
    private double taxaRendimento;

    public ContaPoupanca(String nome, int numero, double saldo, double taxaRendimento) {
        super(nome, numero, saldo);
        this.taxaRendimento = taxaRendimento;
    }

    public void atualiza(double taxaRendimento) {
        saldo += saldo * taxaRendimento;
    }
    public String toString() {
        return super.toString() +
               ", Taxa de rendimento: " + taxaRendimento + "%";
    }
}