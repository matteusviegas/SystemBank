package br.com.project.system.bank;

public class ContaCorrente extends Conta {

    private double limiteChequeEspecial;
    private double taxaSaque;

    public ContaCorrente(int numeroConta, Cliente titular, double limiteChequeEspecial, double taxaSaque) {
        super(numeroConta, titular);
        this.limiteChequeEspecial = limiteChequeEspecial;
        this.taxaSaque = taxaSaque;
    }

    public double getLimiteChequeEspecial() {
        return limiteChequeEspecial;
    }
    public void setLimiteChequeEspecial(double limiteChequeEspecial) {
        this.limiteChequeEspecial = limiteChequeEspecial;
    }

    public double getTaxaSaque() {
        return taxaSaque;
    }
    public void setTaxaSaque(double taxaSaque) {
        this.taxaSaque = taxaSaque;
    }

    @Override
    public void sacar(double valor) {
        if (valor <= 0) {
            System.out.println("Valor inválido para saque.");
            return;
        }

        double disponivel = getSaldo() + limiteChequeEspecial;
        if (valor <= disponivel) {
            setSaldo(getSaldo() - valor);
            registrarOperacao("Saque de R$" + valor + " realizado. Saldo atual: R$" + getSaldo());
        } else {
            System.out.println("Saldo insuficiente! Limite do cheque especial: R$" + limiteChequeEspecial);
        }
    }
}