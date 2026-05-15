package view;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

import model.Usuario;



public class TelaInicio extends JFrame {

	private final JPanel tela;
	private boolean exclusaoValida;
	
	public TelaInicio() {
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("CRUD - Inicio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 426, 230);
		
		tela = new JPanel();
		tela.setBackground(SystemColor.black);
		setContentPane(tela);
		tela.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Seja bem vindo, "+ Usuario.nomeUsuario );
		lblTitulo.setBounds(144, 0, 160, 39);
		tela.add(lblTitulo);

		JLabel lblSaldo = new JLabel("Saldo, "+ Usuario.saldoUsuario);
		lblSaldo.setBounds(144, 20, 160, 39);
		tela.add(lblSaldo);
		
		JButton btnExcluir = new JButton ("Excluir Conta");
		btnExcluir.setBounds(275, 156, 117, 25);
		tela.add(btnExcluir);
		
		JButton btnDeposito = new JButton ("Depósito");
		btnDeposito.setBounds(150, 76, 117, 25);
		tela.add(btnDeposito);
		
		JButton btnSaque = new JButton ("Saque");
		btnSaque.setBounds(150, 116, 117, 25);
		tela.add(btnSaque);
		
		JButton btnSair = new JButton ("Sair");
		btnSair.setBounds(25, 156, 117, 25);
		tela.add(btnSair);
		
		btnDeposito.addActionListener ((ActionEvent e) ->{
			TelaDeposito tDeposito = new TelaDeposito();
			tDeposito.abreTela();
			dispose();
		});
		
		btnSaque.addActionListener ((ActionEvent e) ->{
			TelaSaque tSaque = new TelaSaque();
			tSaque.abreTela();
			dispose();
		});
		
		btnExcluir.addActionListener ((ActionEvent e) ->{
			try {
				Object [] options = {"Sim", "Não"};
				int opcao = JOptionPane.showOptionDialog(null, Usuario.usuarioSistema +", tem certeza que deseja excluir sua conta?", "Atencao", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
				if (opcao == 0) {
					Usuario usu = new Usuario();
					exclusaoValida = usu.excluiUsuario(Usuario.usuarioSistema);
					if(exclusaoValida == true) {
						JOptionPane.showMessageDialog(null, "Usuário excluido com sucesso. Retornando a tela de login", "Atencao", JOptionPane.INFORMATION_MESSAGE);
						TelaLogin tLogin = new TelaLogin();
						tLogin.abreTela();
						dispose();
					} else {
						JOptionPane.showMessageDialog(null,  "Erro", "Atencao", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
			catch (HeadlessException ec){
				System.out.println("Erro" + ec);
			}
		});
		
		btnSair.addActionListener ((ActionEvent e) ->{
			TelaLogin tLogin = new TelaLogin();
			tLogin.abreTela();
			dispose();
		});
	}
	
	public void abreTela() {
		TelaInicio tela = new TelaInicio();
		tela.setVisible(true);
	}
}
