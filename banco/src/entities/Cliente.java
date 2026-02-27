package entities;

public class Cliente {
	private int idCliente;
	private String nome;
	
	public Cliente(int idCliente, String nome) {
		this.idCliente = idCliente;
		this.nome = nome;
	}
	
	public String GetNome() {
		return nome;
	}
	
	public int GetIdCliente() {
		return idCliente;
	}
	
}


