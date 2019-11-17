import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class ListaCliente extends JFrame {

	private JPanel contentPane;
	private JTable tb_clientes;
	private JButton btnVoltar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaCliente frame = new ListaCliente();
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
	public ListaCliente() {
		setTitle("Clientes Cadastrados");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 496, 381);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 62, 460, 203);
		contentPane.add(scrollPane);

		tb_clientes = new JTable();
		tb_clientes.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null, null, null }, },
				new String[] { "ID", "Nome", "E-mail", "Senha", "DDD", "N\u00FAmero", "Tipo Telefone" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tb_clientes.getColumnModel().getColumn(0).setPreferredWidth(26);
		tb_clientes.getColumnModel().getColumn(1).setPreferredWidth(257);
		tb_clientes.getColumnModel().getColumn(2).setPreferredWidth(205);
		tb_clientes.getColumnModel().getColumn(3).setPreferredWidth(136);
		tb_clientes.getColumnModel().getColumn(4).setPreferredWidth(39);
		tb_clientes.getColumnModel().getColumn(5).setPreferredWidth(90);
		scrollPane.setViewportView(tb_clientes);

		JButton btnMostrarClientes = new JButton("Mostrar Clientes");
		btnMostrarClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					Connection con = ConectBD.conect();

					String sql = "Select *from dd_clinte";
					PreparedStatement stmt = con.prepareStatement(sql);

					ResultSet rs = stmt.executeQuery();

					DefaultTableModel table = (DefaultTableModel) tb_clientes.getModel();
					table.setNumRows(0);

					while (rs.next()) {
						table.addRow(new Object[] { rs.getString("id"), rs.getString("nome"), rs.getString("email"),
								rs.getString("senha"), rs.getString("ddd"), rs.getString("numero"),
								rs.getString("tipo") });

					}
					rs.close();
					con.close();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		btnMostrarClientes.setBounds(10, 28, 135, 23);
		contentPane.add(btnMostrarClientes);

		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				TelaCadastro exibir = new TelaCadastro();
				exibir.setVisible(true);

				setVisible(false);

			}
		});
		btnVoltar.setBounds(10, 308, 89, 23);
		contentPane.add(btnVoltar);
	}
}
