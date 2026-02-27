package application;
import entities.Funcionario;

public class TestaFuncionario {

	public static void main(String[] args) {
		Funcionario func1 = new Funcionario("Arthur", 1000);
		Funcionario func2 = new Funcionario("Marcos", 2000);
		
		System.out.println("Funcionário: "+ func1.GetNome());
		System.out.println("Salário: "+ func1.GetSalario());		
		System.out.println("==============================");
		System.out.println("Funcionário: "+ func2.GetNome());
		System.out.println("Salário: "+ func2.GetSalario());			
		System.out.println("==============================");
		System.out.println(func1.Aumento(100));
		System.out.println(func2.Aumento(500));
	}
}
