package model.entities.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.DepartamentDao;
import model.entities.Departament;

public class DepartamentDaoJDBC implements DepartamentDao {

	private Connection conn;

	public DepartamentDaoJDBC(Connection conn) {
		// TODO Auto-generated constructor stub
		this.conn = conn;
	}

	@Override
	public void insert(Departament obj) {
		// TODO Auto-generated method stub

		PreparedStatement st = null;

		try {
			st = conn.prepareStatement("INSERT INTO departament\r\n" + "(nome)\r\n" + "VALUES\r\n" + "(?)",
					Statement.RETURN_GENERATED_KEYS);
			st.setString(1, obj.getName());

			int rowsAffected = st.executeUpdate();

			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();

				if (rs.next()) {
					int id = rs.getInt(1);
					rs.getInt(id);
				}
				DB.closeResultSet(rs);
			}

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}

	}

	@Override
	public void update(Departament obj) {
		// TODO Auto-generated method stub

		PreparedStatement st = null;

		try {
			st = conn.prepareStatement("UPDATE departament\r\n" + "SET name = ?" + "WHERE Id = ?");
			st.setString(1, obj.getName());
			st.executeUpdate();
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}

	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub

		PreparedStatement st = null;

		try {
			st = conn.prepareStatement("DELETE FROM departament WHERE Id = ?");
			st.setInt(1, id);
			st.executeUpdate();

		} catch (SQLException E) {
			throw new DbException(E.getMessage());
		}

	}

	@Override
	public Departament findById(Integer id) {

		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement("SELECT * from departament WHERE Id = ?");
			st.setInt(1, id);
			rs = st.executeQuery();

			if (rs.next()) {
				Departament departament = new Departament();
				departament.setId(rs.getInt("id"));
				departament.setName(rs.getString("nome"));
				return departament;
			}
			return null;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public List<Departament> findAll() {
		// TODO Auto-generated method stub

		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM departament ORDER BY nome");
			rs = st.executeQuery();

			List<Departament> list = new ArrayList<>();

			while (rs.next()) {
				Departament obj = new Departament();
				obj.setId(rs.getInt("id"));
				obj.setName(rs.getString("Nome"));
				list.add(obj);
			}
			return list;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}

	}

}
