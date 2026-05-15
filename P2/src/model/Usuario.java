package model;

import java.sql.SQLException;
import application.Conexao;

public class Usuario {
	private String nome;
	private String senha;
	private float saldo;
	private String cpf;
	private boolean resultUsuario;
	private boolean resultPadraoSenha;
	private boolean resultCadastro;
	private boolean resultAlteracao;
	private boolean resultExclusao;

	public static String nomeUsuario;
	public static String usuarioSistema;
	public static String saldoUsuario;

	public float getSaldo() {
		return saldo;
	}
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean cadastraUsuario(String nome, String cpf, String senha) {
		Conexao banco = new Conexao();
		try {
			banco.openConnection();
			banco.stmt = banco.con.createStatement();
			banco.stmt.execute("INSERT INTO usuarios (nomeUsuario, saldo, cpf, senha) VALUES ('" + nome + "', 0, '" + cpf + "', md5('" + senha + "'))");
			resultCadastro = true;
		} catch (SQLException ec) {
			System.out.println("Erro: " + ec);
			resultCadastro = false;
		} finally {
			banco.closeConnection();
		}
		return resultCadastro;
	}

	public boolean verificaSenha(String senha) {
		resultPadraoSenha = senha.length() >= 10;
		return resultPadraoSenha;
	}

	public boolean verificaUsuario(String cpf, String senha) {
		Conexao banco = new Conexao();
		try {
			banco.openConnection();
			banco.stmt = banco.con.createStatement();
			banco.resultSet = banco.stmt.executeQuery("SELECT * FROM usuarios WHERE cpf = '" + cpf + "' AND senha = md5('" + senha + "')");
			if (banco.resultSet.next()) {
				resultUsuario = true;
				setCpf(banco.resultSet.getString(4));
				setNome(banco.resultSet.getString(2));
				setSaldo(banco.resultSet.getFloat(3));
				nomeUsuario = getNome();
				usuarioSistema = getCpf();
				saldoUsuario = String.format("%.2f", getSaldo());
			} else {
				resultUsuario = false;
			}
		} catch (SQLException ec) {
			System.out.println("Erro: " + ec);
		} finally {
			banco.closeConnection();
		}
		return resultUsuario;
	}

	public boolean verificaUsuario(String cpf) {
		Conexao banco = new Conexao();
		try {
			banco.openConnection();
			banco.stmt = banco.con.createStatement();
			banco.resultSet = banco.stmt.executeQuery("SELECT * FROM usuarios WHERE cpf = '" + cpf + "'");
			resultUsuario = banco.resultSet.next();
		} catch (SQLException ec) {
			System.out.println("Erro: " + ec);
		} finally {
			banco.closeConnection();
		}
		return resultUsuario;
	}

	public float saldoBanco() {
		cpf = usuarioSistema;
	    Conexao banco = new Conexao();
	    float saldo = 0;
	    try {
	        banco.openConnection();
	        banco.stmt = banco.con.createStatement();
	        banco.resultSet = banco.stmt.executeQuery("SELECT saldo FROM usuarios WHERE cpf = '" + cpf + "'");
	        if (banco.resultSet.next()) {
	            saldo = banco.resultSet.getFloat(1);
	        }
	    } catch (SQLException ec) {
	        System.out.println("Erro: " + ec.getMessage());
	    } finally {
	        banco.closeConnection();
	    }
	    return saldo;
	}
	
	public boolean deposito(float saldo, String cpf) {
		Conexao banco = new Conexao();
		try {
			banco.openConnection();
			banco.stmt = banco.con.createStatement();
			banco.stmt.execute("UPDATE usuarios SET saldo = saldo + " + saldo + " WHERE cpf = '" + cpf + "'");
			resultAlteracao = true;
		} catch (SQLException ec) {
			System.out.println("Erro " + ec.getMessage());
			resultAlteracao = false;
		} finally {
			banco.closeConnection();
		}
		saldoUsuario = String.format("%.2f", saldoBanco());
		return resultAlteracao;
	}
	
	public boolean saque(float saque, String cpf) {
		Conexao banco = new Conexao();
		if(saldoBanco()>saque) {
			try {
				banco.openConnection();
				banco.stmt = banco.con.createStatement();
				banco.stmt.execute("UPDATE usuarios SET saldo = saldo - " + saque + " WHERE cpf = '" + cpf + "'");
				resultAlteracao = true;
			} catch (SQLException ec) {
				System.out.println("Erro " + ec.getMessage());
				resultAlteracao = false;
			} finally {
				banco.closeConnection();
			}
			saldoUsuario = String.format("%.2f", saldoBanco());
			
		}
		else {
			resultAlteracao = false;
		}
		return resultAlteracao;
	}
	
	public boolean excluiUsuario(String cpf) {
		Conexao banco = new Conexao();
		try {
			banco.openConnection();
			banco.stmt = banco.con.createStatement();
			banco.stmt.execute("DELETE FROM usuarios WHERE cpf = '" + cpf + "'");
			resultExclusao = true;
		} catch (SQLException ec) {
			System.out.println("Erro " + ec.getMessage());
			resultExclusao = false;
		} finally {
			banco.closeConnection();
		}
		return resultExclusao;
	}
}
