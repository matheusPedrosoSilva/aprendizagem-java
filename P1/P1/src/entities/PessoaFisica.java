package entities;

public class PessoaFisica extends Cliente{

	private String cpf;
	private int idade;
	
	public PessoaFisica(String nome, double limiteCartao, double saldo, int score, String cpf, int idade) {
		super(nome, limiteCartao, saldo, score);
		this.cpf = cpf;
		this.idade = idade;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
		return;
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
		return;
	}
	
	public String getCpf() {
		return this.cpf;
	}
	
	public int getIdade() {
		return this.idade;
	}
	
	@Override
	public void LimiteScore() {
		if (getIdade() < 18) {
			setLimiteCartao(0);
			return;
		}
		else if (getIdade() >= 60){
			setLimiteCartao(getLimiteCartao() + (getScore()*0.5));
			return;			
		}
		else {
			setLimiteCartao(getLimiteCartao() + (getScore()*2));
			return;	
		}
	}
	
	@Override
	public void ImprimeDados() {
		System.out.println("=============================================");
		System.out.println(
				"Nome: " + getNome() + 
				"\nIdade: " + getIdade() +
				"\nCPF: " + getCpf() + 
				"\nScore: " + getScore() +
				"\nSaldo: " + getSaldo() + 
				"\nLimite Cartão de Crédito: " + getLimiteCartao());
		return;
	}
}
