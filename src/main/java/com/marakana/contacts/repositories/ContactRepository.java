package com.marakana.contacts.repositories;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.marakana.contacts.entities.Address;
import com.marakana.contacts.entities.Contact;

public class ContactRepository {

	private final DataSource ds;

	public ContactRepository() {

		try {
			Context context = new InitialContext();
			try {

				ds = (DataSource) context.lookup("java:comp/env/jdbc/trainingdb");
				System.out.println("Contact Repository Constructor :  " + ds.toString());
				try {
					System.out.println(
							"Contact Repository Constructor getConnection() :  " + ds.getConnection().toString());
				}catch(Exception ex) {
					
				} 
				
			} finally {
				context.close();
			}

		} catch (NamingException e) {
			throw new RuntimeException(e);
		} finally {

		}
	}

	public void init() throws SQLException {

		Connection coonnection = null;// ds.getConnection();
		try {
			//////
			coonnection = ds.getConnection();

		} catch (Exception e) {

			// e.printStackTrace();
			System.out.println(" Contact Repositoty Init : " + ds.toString());
			System.out.println("Exception : " + e.getMessage());
			// System.out.println(" ddd " + ds.toString());
		}
		try {
			Statement statement = coonnection.createStatement();
			try {
				// statement.execute("delete from contact");

				statement.execute(
						"create table IF NOT EXISTS contact (id integer generated by default as identity, name varchar(255),"
								+ "address_id integer)");

			} finally {
				statement.close();
			}

		} finally {
			coonnection.close();

		}

	}

	public void create(Contact contact) throws SQLException {

		Connection coonnection = ds.getConnection();
		try {
			Statement statement = coonnection.createStatement();
			try {
				String sql = "insert into contact (name, address_id) values ('" + contact.getName() + "','"
						+ contact.getAddressId() + "')";
				statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
				ResultSet generatedKeys = statement.getGeneratedKeys();
				try {
					if (generatedKeys.next()) {
						contact.setId(generatedKeys.getLong("id"));
					}
				} finally {
					generatedKeys.close();
				}
			} finally {
				statement.close();
			}

		} finally {
			coonnection.close();
		}

	}

	public List<Contact> findAll() throws SQLException {
		Connection connection = ds.getConnection();
		try {
			Statement statement = connection.createStatement();
			try {

				ResultSet rs = statement.executeQuery("select * from contact");
				try {
					List<Contact> contacts = new ArrayList<Contact>();
					while (rs.next()) {
						Contact contact = unmarshal(rs);
						contacts.add(contact);
					}
					return contacts;
				} finally {
					rs.close();
				}

			} finally {
				statement.close();
			}

		} finally {
			connection.close();
		}
	}

	public Contact find(long id) throws SQLException {
		Connection connection = ds.getConnection();
		try {
			Statement statement = connection.createStatement();
			try {

				ResultSet results = statement.executeQuery("select * from contact where id = " + id);
				try {
					if (!results.next()) {
						return null;
					} else {
						return unmarshal(results);
					}
				} finally {
					results.close();
				}
			} finally {
				statement.close();
			}

		} finally {
			connection.close();

		}
	}

	public static Contact unmarshal(ResultSet results) throws SQLException {

		Contact contact = new Contact();
		contact.setId(results.getLong("Id"));
		contact.setName(results.getString("name"));
		contact.setAddressId(results.getLong("address_id"));
		return contact;

	}

	public void delete(Contact contact) throws SQLException {
		Connection connection = ds.getConnection();
		try {
			Statement statement = connection.createStatement();
			try {
				String sql = "delete from contact where id = " + contact.getId();
				statement.executeUpdate(sql);
			} finally {
				statement.close();
			}
		} finally {
			connection.close();
		}
	}

	public void update(Contact contact) throws SQLException {
		Connection connection = ds.getConnection();
		try {
			Statement statement = connection.createStatement();
			try {
				String sql = "update contact set name = '" + contact.getName() + "',address_id='"
						+ contact.getAddressId() + "' where id =" + contact.getId();
				statement.executeUpdate(sql);
			} finally {
				statement.close();
			}

		} finally {
			connection.close();

		}
	}
}