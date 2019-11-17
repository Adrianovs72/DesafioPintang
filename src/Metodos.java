import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Metodos {

	private int id;
	private String nome;
	private String email;
	private String senha;
	private int ddd;
	private String numero;
	private String tipo;

	public Metodos(int id_p) {
		this.id = id_p;
	}

	public Metodos(String nome, String email, String senha, int ddd, String numero, String tipo) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.ddd = ddd;
		this.numero = numero;
		this.tipo = tipo;
	}

	public Metodos(String nome, String email, String senha, int ddd, String numero, String tipo, int id) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.ddd = ddd;
		this.numero = numero;
		this.tipo = tipo;
		this.id = id;
	}

	// Método para Cadastrar.

	void cadastrar() {

		try {

			Connection con = ConectBD.conect();

			String sql = "insert into dd_clinte(nome, email, senha, ddd, numero, tipo) value(?, ?, ?, ?, ?, ?)";

			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, nome);
			stmt.setString(2, email);
			stmt.setString(3, senha);
			stmt.setInt(4, ddd);
			stmt.setString(5, numero);
			stmt.setString(6, tipo);

			stmt.execute();
			stmt.close();
			con.close();

			JOptionPane.showMessageDialog(null, "Cliente Cadastrado");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

//Metodo para Atualizar Cadastro
	void atualizar() {
		try {

			Connection con = ConectBD.conect();

			String sql = "update dd_clinte set nome=? , email=? ,senha=?, ddd=?, numero=?, tipo =?  where id=? ";

			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, nome);
			stmt.setString(2, email);
			stmt.setString(3, senha);
			stmt.setInt(4, ddd);
			stmt.setString(5, numero);
			stmt.setString(6, tipo);
			stmt.setInt(7, id);

			stmt.execute();
			stmt.close();
			con.close();

			JOptionPane.showMessageDialog(null, "Dados Atualizados");

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
