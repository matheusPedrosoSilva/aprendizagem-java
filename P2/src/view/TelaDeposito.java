package view;

import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;

import model.Usuario;


public class TelaDeposito extends JFrame {

    private final JPanel tela;
    private final JTextField txtValor;
    private boolean atualizacaoValida;


    public TelaDeposito() {
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("CRUD - Depósito");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500, 200, 426, 150);

        tela = new JPanel();
        tela.setBackground(SystemColor.black);
        setContentPane(tela);
        tela.setLayout(null);

        JLabel lblTitulo = new JLabel("Depósito");
        lblTitulo.setBounds(144, 0, 160, 39);
        lblTitulo.setFont(new Font("Arial", 3, 19));
        tela.add(lblTitulo);

        JLabel lblValor = new JLabel("Valor");
        lblValor.setBounds(24, 35, 70, 15);
        tela.add(lblValor);
        txtValor = new JTextField();
        txtValor.setBounds(120, 35, 219, 19);
        tela.add(txtValor);
        txtValor.setColumns(10);

        JButton btnConfirmar = new JButton("Confirmar"); 
        btnConfirmar.setBounds(200, 76, 117, 25);
        tela.add(btnConfirmar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(50, 76, 117, 25);
        tela.add(btnCancelar);

        btnCancelar.addActionListener((ActionEvent e) -> {
            TelaInicio tInicio = new TelaInicio();
            tInicio.abreTela();
            dispose();
        });

        btnConfirmar.addActionListener((ActionEvent e) -> {
            try {
                Usuario usu = new Usuario();
                usu.setCpf(Usuario.usuarioSistema);
                if ("".equals(txtValor.getText())) {
                    JOptionPane.showMessageDialog(null, "Campo valor vazio", "Atencao", JOptionPane.ERROR_MESSAGE);
                    txtValor.grabFocus();
                } else {
                    String valorTexto = txtValor.getText().replace(",", ".");
                    atualizacaoValida = usu.deposito(Float.parseFloat(valorTexto), Usuario.usuarioSistema);

                    if (atualizacaoValida == true) {
                        JOptionPane.showMessageDialog(null, "Deposito realizado", "Atencao", JOptionPane.INFORMATION_MESSAGE);
                        TelaInicio tInicio = new TelaInicio();
                        tInicio.abreTela();
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Erro", "Atencao", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } catch (HeadlessException ec) {
                System.out.println("Erro " + ec.getMessage());
            } catch (NumberFormatException ec) {
                JOptionPane.showMessageDialog(null, "Digite um valor numérico válido", "Atencao", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    public void abreTela() {
        TelaDeposito tela = new TelaDeposito();
        tela.setVisible(true);
    }
}