package entities;

public class Cartao {
	private int numCartao;
	private int mesVencimento;
	private int anoVencimento;
	
	public Cartao(int numCartao, int mesVencimento, int anoVencimento) {
		this.numCartao = numCartao;
		this.mesVencimento = mesVencimento;
		this.anoVencimento = anoVencimento;
	}
	
	public int GetNumCartao() {
		return numCartao;
	}
	
	public int GetMesVencimento() {
		return mesVencimento;
	}
	
	public int GetAnoVencimento() {
		return anoVencimento;
	}
}
