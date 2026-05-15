package view;

import model.Usuario;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel; 
import javax.swing.JPasswordField; 
import javax.swing.JTextField;


public class TelaLogin extends JFrame {
	
	private final JPanel panelTela;
	private final JTextField txtUsuario;
	private final JPasswordField pswSenha;
	private boolean usuarioValido;
	
	public TelaLogin() {
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 426, 212);
		panelTela = new JPanel();
		panelTela.setBackground(SystemColor.black);
		setContentPane(panelTela);
		panelTela.setLayout(null);
		
		JLabel lblIdentificacao = new JLabel("IDENTIFICACAO");
		lblIdentificacao.setBounds(144, 0, 160, 39);
		lblIdentificacao.setFont(new Font("Arial", 3, 19));
		panelTela.add(lblIdentificacao);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(24, 65, 70, 15);
		panelTela.add(lblUsuario);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(24, 92, 70, 15);
		panelTela.add(lblSenha);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(112, 63, 219, 19);
		panelTela.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		pswSenha = new JPasswordField();
		pswSenha.setBounds(112, 90, 219, 19);
		panelTela.add(pswSenha);
		
		JButton btnEntrar = new JButton ("ENTRAR");
		btnEntrar.setBounds(200, 136, 117, 25);
		panelTela.add(btnEntrar);
		
		JButton btnCadastrar = new JButton ("CADASTRAR");
		btnCadastrar.setBounds(50, 136, 117, 25);
		panelTela.add(btnCadastrar);
		
		btnEntrar.addActionListener((ActionEvent e) ->{
			Usuario usu = new Usuario();
			usu.setCpf(txtUsuario.getText());
			usu.setSenha(pswSenha.getText());
			if("".equals(txtUsuario.getText())){
				JOptionPane.showMessageDialog(null, "Usuário Invalido", "Atencao", JOptionPane.ERROR_MESSAGE);
				txtUsuario.grabFocus();
			}
			else if("".equals(pswSenha.getText())){
				JOptionPane.showMessageDialog(null, "Senha Invalido", "Atencao", JOptionPane.ERROR_MESSAGE);
				pswSenha.grabFocus();
			}
			else {
				usuarioValido = usu.verificaUsuario(usu.getCpf(), usu.getSenha());
				if (usuarioValido == true) {
					JOptionPane.showMessageDialog(null, "Ok", "Atencao", JOptionPane.INFORMATION_MESSAGE);
					TelaInicio tInicio = new TelaInicio();
					tInicio.abreTela();
					dispose();
				}
				else {
					JOptionPane.showMessageDialog(null, "Invalido", "Atencao", JOptionPane.ERROR_MESSAGE);
					limpaText();
					txtUsuario.grabFocus();
					
				}
			}
		});
		
		btnCadastrar.addActionListener ((ActionEvent e) ->{
			TelaCadastro tCadastro = new TelaCadastro();
			tCadastro.abreTela();
			dispose();
		});
	}
	
	public void limpaText() {
		txtUsuario.setText("");
		pswSenha.setText("");
	}
	
	public void abreTela() {
		TelaLogin tela = new TelaLogin();
		tela.setVisible(true);
	}

}
