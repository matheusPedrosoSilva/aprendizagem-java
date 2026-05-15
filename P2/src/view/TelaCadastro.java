package view;

import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel; 
import javax.swing.JPasswordField; 
import javax.swing.JTextField;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;

import model.Usuario;


public class TelaCadastro extends JFrame {

	private final JPanel tela;
	private final JTextField txtNome;
	private final JTextField txtCpf;
	private final JPasswordField pswSenha;
	private final JPasswordField pswConfSenha;
	private boolean usuarioValido;
	private boolean cadastroValido;
	private String mensageJOption;
	private int mensageType = 0;
	
	public TelaCadastro() {
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("CRUD - Cadastro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 426, 230);
		
		tela = new JPanel();
		tela.setBackground(SystemColor.black);
		setContentPane(tela);
		tela.setLayout(null);
		
		JLabel lblTitulo = new JLabel("CADASTRO");
		lblTitulo.setBounds(144, 0, 160, 39);
		lblTitulo.setFont(new Font("Arial", 3, 19));
		tela.add(lblTitulo);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(24, 50, 70, 15);
		tela.add(lblNome);
		txtNome = new JTextField();
		txtNome.setBounds(120, 50, 219, 19);
		tela.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(24, 75, 70, 15);
		tela.add(lblCpf);
		txtCpf = new JTextField();
		txtCpf.setBounds(120, 75, 219, 19);
		tela.add(txtCpf);
		txtCpf.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(24, 100, 70, 15);
		tela.add(lblSenha);
		pswSenha = new JPasswordField();
		pswSenha.setBounds(120, 100, 219, 19);
		tela.add(pswSenha);
		
		JLabel lblConfSenha = new JLabel("Confirme Senha");
		lblConfSenha.setBounds(24, 125, 70, 15);
		tela.add(lblConfSenha);
		pswConfSenha = new JPasswordField();
		pswConfSenha.setBounds(120, 125, 219, 19);
		tela.add(pswConfSenha);
		
		JButton btnCadastrar = new JButton ("Cadastrar");
		btnCadastrar.setBounds(200, 156, 117, 25);
		tela.add(btnCadastrar);
		
		JButton btnCancelar = new JButton ("Cancelar");
		btnCancelar.setBounds(50, 156, 117, 25);
		tela.add(btnCancelar);
		
		btnCancelar.addActionListener ((ActionEvent e) ->{
			TelaLogin tLogin = new TelaLogin();
			tLogin.abreTela();
			dispose();
		});
		
		btnCadastrar.addActionListener ((ActionEvent e) ->{
			try {
				Usuario usu = new Usuario();
				usu.setNome(txtNome.getText());
				usu.setCpf(txtCpf.getText());
				usu.setSenha(pswSenha.getText());
				if ("".equals(usu.getNome())) {
					mensageJOption = "Campo nome vazio";
					mensageType = 0;
				}
				else if ("".equals(usu.getCpf())) {
					mensageJOption = "Campo CPF vazio";
					mensageType = 0;
				}
				else if ("".equals(usu.getSenha())) {
					mensageJOption = "Campo senha vazio";
					mensageType = 0;
				}
				else if (!usu.getSenha().equals(pswConfSenha.getText())) {
					mensageJOption = "Campo senha de confirmacao errado";
					mensageType = 0;
				}
				else {
					usuarioValido = usu.verificaUsuario(usu.getCpf());
					if(usuarioValido ==true) {
						mensageJOption = "Usuario ja existe";
						mensageType = 0;
					} else {
						cadastroValido = usu.cadastraUsuario(usu.getNome(), usu.getCpf(), usu.getSenha());
						if (cadastroValido == true) {
							mensageJOption = "Usuario cadastrado";
							mensageType = 1;
						} else {
							mensageJOption = "Erro";
							mensageType = 0;
						}
					}
				}
				
				JOptionPane.showMessageDialog(null, mensageJOption, "Atencao", mensageType);
				if (mensageType == 1) {
					TelaLogin tLogin = new TelaLogin();
					tLogin.abreTela();
					dispose();
				}
			}
			catch(HeadlessException ec) {
				System.out.println("Erro "+ ec.getMessage());
			}
			
		});
		

	}
	
	public void abreTela() {
		TelaCadastro tela = new TelaCadastro();
		tela.setVisible(true);
	}
	
}
