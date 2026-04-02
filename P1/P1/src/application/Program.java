package application;
import entities.PessoaFisica;
import entities.PessoaJuridica;


public class Program {

	public static void main(String[] args) {
		PessoaFisica f = new PessoaFisica("Enzo", 1, 100, 100, "123456789001", 16);
		f.ImprimeDados();
		f.LimiteScore();
		f.ImprimeDados();
		PessoaJuridica j = new PessoaJuridica("Empresa", 10000, 10000, 650, "12345678901234", "Empresa LTDA");
		j.ImprimeDados();
		j.LimiteScore();
		j.ImprimeDados();
	}
	
}