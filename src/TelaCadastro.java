import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;

public class TelaCadastro extends JFrame {

	private JPanel contentPane;
	private JTextField tf_id;
	private JTextField tf_nome;
	private JTextField tf_email;
	private JTextField tf_senha;
	private JTextField tf_ddd;
	private JTextField tf_telefone;
	private JTextField tf_tipotelefone;
	private JTextField tf_busca;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastro frame = new TelaCadastro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Criação da tela
	public TelaCadastro() {
		setTitle("Tela de Cadastro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 510, 417);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Menu");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("Cadastrar");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (tf_nome.getText().equals("")) {

					JOptionPane.showMessageDialog(null, "Campos em Branco");
				} else {

					Metodos mt = new Metodos(tf_nome.getText(), tf_email.getText(), tf_senha.getText(),
							Integer.parseInt(tf_ddd.getText()), tf_telefone.getText(), tf_tipotelefone.getText());
					mt.cadastrar();

					tf_nome.setText("");
					tf_email.setText("");
					tf_senha.setText("");
					tf_ddd.setText("");
					tf_telefone.setText("");
					tf_tipotelefone.setText("");
				}
			}
		});
		mntmNewMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mnNewMenu.add(mntmNewMenuItem);

		JMenuItem mntmAtualizar = new JMenuItem("Atualizar");
		mntmAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (tf_busca.getText().equals("")) {

					JOptionPane.showMessageDialog(null, "Informe o número da busca");
				} else {

					Metodos mt = new Metodos(tf_nome.getText(), tf_email.getText(), tf_senha.getText(),
							Integer.parseInt(tf_ddd.getText()), tf_telefone.getText(), tf_tipotelefone.getText(),
							Integer.parseInt(tf_id.getText()));
					mt.atualizar();

				}
				JOptionPane.showMessageDialog(null, "Dados Atualizados");
			}
		});
		mntmAtualizar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		mnNewMenu.add(mntmAtualizar);

		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				System.exit(0);
			}
		});
		mntmSair.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_END, InputEvent.CTRL_MASK));
		mnNewMenu.add(mntmSair);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblId = new JLabel("ID");
		lblId.setBounds(13, 40, 46, 14);
		contentPane.add(lblId);

		JLabel lblSenha = new JLabel("Nome");
		lblSenha.setBounds(13, 65, 46, 14);
		contentPane.add(lblSenha);

		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(14, 90, 46, 14);
		contentPane.add(lblEmail);

		JLabel lblSenha_1 = new JLabel("Senha");
		lblSenha_1.setBounds(14, 114, 46, 14);
		contentPane.add(lblSenha_1);

		JLabel lblDdd = new JLabel("DDD");
		lblDdd.setBounds(14, 140, 46, 14);
		contentPane.add(lblDdd);

		JLabel lblNmero = new JLabel("N\u00FAmero");
		lblNmero.setBounds(13, 165, 46, 14);
		contentPane.add(lblNmero);

		JLabel lblTipoDoTelefone = new JLabel("Tipo do Telefone");
		lblTipoDoTelefone.setBounds(14, 193, 87, 14);
		contentPane.add(lblTipoDoTelefone);

		tf_id = new JTextField();
		tf_id.setEditable(false);
		tf_id.setBounds(51, 38, 30, 20);
		contentPane.add(tf_id);
		tf_id.setColumns(10);

		tf_nome = new JTextField();
		tf_nome.setBounds(51, 62, 230, 20);
		contentPane.add(tf_nome);
		tf_nome.setColumns(10);

		tf_email = new JTextField();
		tf_email.setBounds(51, 87, 230, 20);
		contentPane.add(tf_email);
		tf_email.setColumns(10);

		tf_senha = new JTextField();
		tf_senha.setBounds(51, 111, 230, 20);
		contentPane.add(tf_senha);
		tf_senha.setColumns(10);

		tf_ddd = new JTextField();
		tf_ddd.setBounds(51, 137, 30, 20);
		contentPane.add(tf_ddd);
		tf_ddd.setColumns(10);

		tf_telefone = new JTextField();
		tf_telefone.setBounds(61, 162, 86, 20);
		contentPane.add(tf_telefone);
		tf_telefone.setColumns(10);

		tf_tipotelefone = new JTextField();
		tf_tipotelefone.setBounds(106, 190, 86, 20);
		contentPane.add(tf_tipotelefone);
		tf_tipotelefone.setColumns(10);

		JPanel panel = new JPanel();
		panel.setBorder(
				new TitledBorder(null, "Fun\u00E7\u00F5es", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(Color.GRAY);
		panel.setBounds(13, 245, 446, 84);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (tf_nome.getText().equals("")) {

					JOptionPane.showMessageDialog(null, "Campos em Branco");
				} else {

					Metodos mt = new Metodos(tf_nome.getText(), tf_email.getText(), tf_senha.getText(),
							Integer.parseInt(tf_ddd.getText()), tf_telefone.getText(), tf_tipotelefone.getText());
					mt.cadastrar();

					tf_nome.setText("");
					tf_email.setText("");
					tf_senha.setText("");
					tf_ddd.setText("");
					tf_telefone.setText("");
					tf_tipotelefone.setText("");

				}
			}
		});
		btnNewButton.setBounds(10, 16, 138, 23);
		panel.add(btnNewButton);

		JButton btnProcurarClientes = new JButton("Listar  Clientes");
		btnProcurarClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				ListaCliente exibir = new ListaCliente();
				exibir.setVisible(true);

			}
		});
		btnProcurarClientes.setBounds(10, 50, 138, 23);
		panel.add(btnProcurarClientes);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (tf_busca.getText().equals("")) {

					JOptionPane.showMessageDialog(null, "Informe o número da busca");
				} else {

					try {
						Connection con = ConectBD.conect();

						String sql = "Select *from dd_clinte where id like ?";

						PreparedStatement stmt = con.prepareStatement(sql);
						stmt.setString(1, "%" + tf_busca.getText());

						ResultSet rs = stmt.executeQuery();

						while (rs.next()) {

							tf_id.setText(rs.getString("id"));
							tf_nome.setText(rs.getString("nome"));
							tf_email.setText(rs.getString("email"));
							tf_senha.setText(rs.getString("senha"));
							tf_ddd.setText(rs.getString("ddd"));
							tf_telefone.setText(rs.getString("numero"));
							tf_tipotelefone.setText(rs.getString("tipo"));

						}

						rs.close();
						con.close();

					} catch (SQLException e1) {

						e1.printStackTrace();
					}

				}

			}
		});
		btnBuscar.setBounds(158, 16, 130, 23);
		panel.add(btnBuscar);

		tf_busca = new JTextField();
		tf_busca.setText("Informe o ID");
		tf_busca.setBounds(298, 16, 119, 23);
		panel.add(tf_busca);
		tf_busca.setColumns(10);

		JButton btnAtualizarDados = new JButton("Atualizar Dados");
		btnAtualizarDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (tf_busca.getText().equals("")) {

					if (tf_busca.getText().equals("")) {

						JOptionPane.showMessageDialog(null, "Informe o número da busca");
					} else {

						Metodos mt = new Metodos(tf_nome.getText(), tf_email.getText(), tf_senha.getText(),
								Integer.parseInt(tf_ddd.getText()), tf_telefone.getText(), tf_tipotelefone.getText(),
								Integer.parseInt(tf_id.getText()));
						mt.atualizar();

					}

					JOptionPane.showMessageDialog(null, "Dados Atualizados");

					tf_nome.setText("");
					tf_email.setText("");
					tf_senha.setText("");
					tf_ddd.setText("");
					tf_telefone.setText("");
					tf_tipotelefone.setText("");
				}
			}
		});
		btnAtualizarDados.setBounds(158, 50, 130, 23);
		panel.add(btnAtualizarDados);

		JButton btnExcluirCliente = new JButton("Excluir Cliente");
		btnExcluirCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (tf_busca.getText().equals("")) {

					JOptionPane.showMessageDialog(null, "Informe o número da busca");
				} else {

					try {

						Connection con = ConectBD.conect();
						String sql = "delete from dd_clinte where id = ?";

						PreparedStatement stmt = con.prepareStatement(sql);

						stmt.setString(1, tf_id.getText());

						stmt.execute();
						stmt.close();
						con.close();

						JOptionPane.showMessageDialog(null, "Cliente Excluido");

						tf_id.setText("");
						tf_nome.setText("");
						tf_email.setText("");
						tf_senha.setText("");
						tf_ddd.setText("");
						tf_telefone.setText("");
						tf_tipotelefone.setText("");

					} catch (SQLException e1) {

						e1.printStackTrace();
					}

				}
			}
		});
		btnExcluirCliente.setBounds(298, 50, 119, 23);
		panel.add(btnExcluirCliente);
	}
}
