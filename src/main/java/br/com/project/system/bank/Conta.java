package br.com.project.system.bank;

import java.util.ArrayList;

public abstract class Conta {
    private int numeroConta;
    private double saldo;
    private Cliente titular;
    private ArrayList<String> extrato;

    public Conta(int numeroConta, Cliente titular) {
        this.numeroConta = numeroConta;
        this.titular = titular;
        this.saldo = 0.0;
        this.extrato = new ArrayList<>();
    }

    // Getters e Setters
    public int getNumeroConta() {
        return numeroConta;
    }
    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }
    protected void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Cliente getTitular() {
        return titular;
    }
    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    public ArrayList<String> getExtrato() {
        return extrato;
    }
    protected void setExtrato(ArrayList<String> extrato) {
        this.extrato = extrato;
    }

    // Operações
    public void registrarOperacao(String operacao) {
        extrato.add(operacao);
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            registrarOperacao("Depósito de R$" + valor + " realizado.");
        } else {
            System.out.println("Valor inválido para depósito!");
        }
    }

    public void mostrarExtrato() {
        System.out.println("=== Extrato da conta nº " + numeroConta + " - Titular: " + titular.getName() + " ===");
        if (extrato.isEmpty()) {
            System.out.println("Nenhuma operação realizada ainda.");
        }
        for (String op : extrato) {
            System.out.println(op);
        }
    }

    public abstract void sacar(double valor);
}