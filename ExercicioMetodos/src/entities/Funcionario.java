package entities;

public class Funcionario {
	private String nome;
	private double salario;
	
	public Funcionario(String nome, double salario) {
		this.nome = nome;
		this.salario = salario;
	}
	
	public String GetNome() {
		return nome;
	}
	
	public double GetSalario() {
		return salario;
	}
	
	public String Aumento(double salario) {
		this.salario += salario;
		return "O aumento de salário para "+ GetNome() +" foi registrado com sucesso! Seu novo salário é: R$"+GetSalario();
	}
	
	
}
