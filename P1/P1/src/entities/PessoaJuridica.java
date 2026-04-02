package entities;

public class PessoaJuridica extends Cliente{
	
	private String cnpj;
	private String razaoSocial;
	
	public PessoaJuridica(String nome, double saldo, double limiteCartao, int score, String cnpj, String razaoSocial) {
		super(nome, saldo, limiteCartao, score);
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
	}
	
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
		return;
	}
	
	public String getCnpj() {
		return this.cnpj;
	}
	
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
		return;
	}
	
	public String getRazaoSocial() {
		return this.razaoSocial;
	}
	
	@Override
	public void LimiteScore() {
		setLimiteCartao((getScore()*5) + getSaldo());
	}
	
	@Override
	public void ImprimeDados() {
		super.ImprimeDados();
		System.out.println("\nRazão Social: " + getRazaoSocial() +  "\nCNPJ: " + getCnpj());
		return;
	}
}
