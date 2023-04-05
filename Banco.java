import java.util.ArrayList;
import java.util.Scanner;

public class Banco {

    static ArrayList<ContaBancaria> contas = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean continuar = true;

        while (continuar) {
            System.out.println("Menu de opções:");
            System.out.println("a) Incluir nova conta bancária");
            System.out.println("b) Incluir nova conta poupança");
            System.out.println("c) Incluir nova conta corrente");
            System.out.println("d) Sacar valor de uma conta");
            System.out.println("e) Depositar valor em uma conta");
            System.out.println("f) Atualizar valor de todas as contas poupança");
            System.out.println("g) Mostrar saldo de todas as contas");
            System.out.println("h) Sair do programa");
            System.out.println("Escolha uma opção:");

            String opcao = scanner.nextLine();

            switch (opcao.toLowerCase()) {
                case "a":
                    criarContaBancaria();
                    break;
                case "b":
                    criarContaPoupanca();
                    break;
                case "c":
                    criarContaCorrente();
                    break;
                case "d":
                    sacarValor();
                    break;
                case "e":
                    depositarValor();
                    break;
                case "f":
                    atualizarContasPoupanca();
                    break;
                case "g":
                    mostrarSaldoTodasContas();
                    break;
                case "h":
                    continuar = false;
                    System.out.println("Programa encerrado.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    public static void criarContaBancaria() {  
        System.out.println("Informe o nome do cliente:");
        String nome = scanner.nextLine();
        System.out.println("Informe o número da conta:");
        int numero = scanner.nextInt();
        System.out.println("Informe o saldo inicial:");
        double saldo = scanner.nextDouble();
        scanner.nextLine();
        ContaBancaria contaBancaria = new ContaBancaria(nome, numero, saldo);
        contas.add(contaBancaria);
        System.out.println("Conta bancária criada com sucesso!");
    }

    public static void criarContaPoupanca() {   
        System.out.println("Informe o nome do cliente:");
        String nome = scanner.nextLine();
        System.out.println("Informe o número da conta:");
        int numero = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Informe o saldo inicial:");
        double saldo = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Informe a taxa de rendimento:");
        double taxaRendimento = scanner.nextDouble();
        scanner.nextLine(); 
        ContaPoupanca contaPoupanca = new ContaPoupanca(nome, numero, saldo, taxaRendimento);
        contas.add(contaPoupanca);
        System.out.println("Conta poupança criada com sucesso!");
    }
    
    

    public static void criarContaCorrente() {   
        System.out.println("Informe o nome do cliente:");
        String nome = scanner.nextLine();
        System.out.println("Informe o número da conta:");
        int numero = scanner.nextInt();
        System.out.println("Informe o saldo inicial:");
        double saldo = scanner.nextDouble();
        System.out.println("Informe o limite:");
        double limite = scanner.nextDouble();
        scanner.nextLine(); 
        ContaEspecial contaEspecial = new ContaEspecial(nome, numero, saldo, limite);
        contas.add(contaEspecial);
        System.out.println("Conta corrente criada com sucesso!");
    }
    

    public static void sacarValor() {
        System.out.println("Informe o número da conta:");
        int numero = scanner.nextInt();
        System.out.println("Informe o valor a ser sacado:");
        double valor = scanner.nextDouble();
        scanner.nextLine();
        boolean encontrou = false;
        for (ContaBancaria conta : contas) {
            if (conta.getNumeroConta() == numero) {
                if (conta.saca(valor)) {
                    System.out.println("Saque efetuado com sucesso!");
                } else {
                    System.out.println("Saldo insuficiente!");
                }
                encontrou = true;
                break;
            }
        }
        if (!encontrou) {
            System.out.println("Conta não encontrada!");
        }
    }

    public static void depositarValor() {
        System.out.println("Informe o número da conta:");
        int numero = scanner.nextInt();
        System.out.println("Informe o valor a ser depositado:");
        double valor = scanner.nextDouble();
        scanner.nextLine();
        boolean encontrou = false;
        for (ContaBancaria conta : contas) {
            if (conta.getNumeroConta() == numero) {
                conta.deposita(valor);
                System.out.println("Depósito efetuado com sucesso!");
                encontrou = true;
                break;
            }
        }
        if (!encontrou) {
            System.out.println("Conta não encontrada!");
        }
    }

    public static void atualizarContasPoupanca() {
        for (Conta conta : contas) {
            if (conta instanceof ContaPoupanca) {
                ContaPoupanca contaPoupanca = (ContaPoupanca) conta;
                double rendimento = contaPoupanca.getSaldo() * 0.01; // Rendimento de 1%
                contaPoupanca.deposita(rendimento);
            }
        }
        System.out.println("Contas poupança atualizadas com sucesso!");
    }

    public static void mostrarSaldoTodasContas() {
  
    }
}
