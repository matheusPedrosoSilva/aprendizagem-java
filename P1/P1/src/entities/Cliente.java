package entities;

public class Cliente {
	
	private String nome;
	private double limiteCartao;
	private double saldo;
	private int score;
	
	public Cliente(String nome, double limiteCartao, double saldo, int score) {
		this.nome = nome;
		this.limiteCartao = limiteCartao;
		this.saldo = saldo;
		this.score = score;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public double getLimiteCartao() {
		return this.limiteCartao;
	}
	
	public double getSaldo() {
		return this.saldo;
	}
	
	public int getScore() {
		return this.score;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
		return;
	}
	
	public void setLimiteCartao(double limiteCartao) {
		this.limiteCartao = limiteCartao;
		return;
	}
	
	public void setSaldo(double saldo) {
		this.saldo = saldo;
		return;
	}
	
	public void setScore(int score) {
		this.score = score;
		return;
	}
	
	public void LimiteScore() {
		setLimiteCartao(getLimiteCartao() + (getScore()*1));
		return;
	}
	
	public void ImprimeDados() {
		System.out.println("=============================================");
		System.out.print(
				"Nome: " + getNome() + 
				"\nSaldo: " + getSaldo() + 
				"\nLimite Cartão de Crédito: " + getLimiteCartao() + 
				"\nScore: " + getScore());
		return;
	}
}
