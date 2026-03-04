package br.com.project.system.bank;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Conta> contas = new ArrayList<>();
        boolean rodando = true;

        while (rodando) {
            System.out.println("\n=== Sistema Bancário ===");
            System.out.println("1 - Criar Conta");
            System.out.println("2 - Depositar");
            System.out.println("3 - Sacar");
            System.out.println("4 - Mostrar Extrato");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    System.out.println("=== Criar Conta Corrente ===");

                    System.out.print("Nome do cliente: ");
                    String nome = scanner.nextLine();

                    System.out.print("CPF do cliente: ");
                    String cpf = scanner.nextLine();

                    System.out.print("Email do cliente: ");
                    String email = scanner.nextLine();

                    System.out.print("Limite do cheque especial: ");
                    double limite = Double.parseDouble(scanner.nextLine());

                    System.out.print("Taxa de saque: ");
                    double taxa = Double.parseDouble(scanner.nextLine());

                    Cliente cliente = new Cliente(nome, cpf, email);
                    int numeroConta = contas.size() + 1;

                    ContaCorrente cc = new ContaCorrente(numeroConta, cliente, limite, taxa);
                    contas.add(cc);

                    System.out.println("Conta criada com sucesso! Número da conta: " + numeroConta);
                    break;

                case 2:
                    System.out.print("Número da conta para depósito: ");
                    int numeroContaDep = Integer.parseInt(scanner.nextLine());
                    Conta contaDep = contas.stream()
                            .filter(c -> c.getNumeroConta() == numeroContaDep)
                            .findFirst().orElse(null);

                    if (contaDep != null) {
                        System.out.print("Valor a depositar: ");
                        double valorDep = Double.parseDouble(scanner.nextLine());
                        contaDep.depositar(valorDep);
                        System.out.println("Depósito realizado com sucesso!");
                    } else {
                        System.out.println("Conta não encontrada!");
                    }
                    break;

                case 3:
                    System.out.print("Número da conta para saque: ");
                    int numeroContaSac = Integer.parseInt(scanner.nextLine());
                    Conta contaSac = contas.stream()
                            .filter(c -> c.getNumeroConta() == numeroContaSac)
                            .findFirst().orElse(null);

                    if (contaSac != null) {
                        System.out.print("Valor a sacar: ");
                        double valorSac = Double.parseDouble(scanner.nextLine());
                        contaSac.sacar(valorSac);
                    } else {
                        System.out.println("Conta não encontrada!");
                    }
                    break;

                case 4:
                    System.out.print("Número da conta para extrato: ");
                    int numeroContaExt = Integer.parseInt(scanner.nextLine());
                    Conta contaExt = contas.stream()
                            .filter(c -> c.getNumeroConta() == numeroContaExt)
                            .findFirst().orElse(null);

                    if (contaExt != null) {
                        contaExt.mostrarExtrato();
                    } else {
                        System.out.println("Conta não encontrada!");
                    }
                    break;

                case 5:
                    rodando = false;
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }

        scanner.close();
    }
}