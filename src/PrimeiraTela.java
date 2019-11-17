import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class PrimeiraTela extends JFrame {

	private JPanel contentPane;
	private JTextField tf_usuario;
	private JPasswordField pf_senha;
	private JButton btnCriarConta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrimeiraTela frame = new PrimeiraTela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PrimeiraTela() {
		setResizable(false);
		setTitle("Tela de Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 332, 277);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Usu\u00E1rio :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(21, 68, 89, 22);
		contentPane.add(lblNewLabel);

		JLabel lblSenha = new JLabel("Senha :");
		lblSenha.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblSenha.setBounds(21, 124, 81, 22);
		contentPane.add(lblSenha);

		tf_usuario = new JTextField();
		tf_usuario.setBounds(124, 72, 129, 20);
		contentPane.add(tf_usuario);
		tf_usuario.setColumns(10);

		pf_senha = new JPasswordField();
		pf_senha.setBounds(124, 128, 129, 20);
		contentPane.add(pf_senha);

		JButton bt_entrar = new JButton("Entrar");
		bt_entrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					Connection con = ConectBD.conect();

					String sql = "select *from d_senhas where usuario=? and senha=?";

					PreparedStatement stmt = con.prepareStatement(sql);
					stmt.setString(1, tf_usuario.getText());
					stmt.setString(2, new String(pf_senha.getPassword()));

					ResultSet rs = stmt.executeQuery();

					if (rs.next()) {

						TelaCadastro exibir = new TelaCadastro();
						exibir.setVisible(true);

						setVisible(false);

					} else {

						JOptionPane.showMessageDialog(null, "Esse usuário não existe.");
					}

					stmt.close();
					con.close();

				} catch (SQLException e) {

					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		bt_entrar.setBounds(114, 170, 89, 23);
		contentPane.add(bt_entrar);

	

			}
	
		
	}
