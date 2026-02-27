package entities;

public class Conta {

	private int numConta;
	private int digito;
	private double saldo;
	private double limite;
	
	public Conta(int numConta, int digito, double limite) {
		this.numConta = numConta;
		this.digito = digito;
		this.saldo = 0;
		this.limite = limite;
	}
	
	public int GetNumConta() {
		return numConta;
	}
	
	public int GetDigito() {
		return digito;
	}
	
	public double GetSaldo() {
		return saldo;
	}
	
	public double GetLimite() {
		return limite;
	}
	
	public void Deposito(double deposito) {
		if (deposito >= 0) {
			saldo += deposito;
		}
		else {
			System.out.println("Valor digitado inferior ou igual a 0. Tente Novamente");
		}
		return;
	}
}
