package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import model.City;
import utility.ConnectionManager;

public class CityDAO {
	public City getCityByName(String name) throws Exception {

		// connection to the database
		Connection connection = ConnectionManager.getConnection();

		// City object
		City city = null;

		// statement object
		Statement statement = connection.createStatement();
		String sql = "SELECT * from city where name = " + "'" + name + "'";
		ResultSet resultSet = statement.executeQuery(sql);
		while (resultSet.next()) {
			city = new City(resultSet.getLong("cityid"), resultSet.getString("cityname"));
		}
		return city;

	}

	public void createCity(City city) throws Exception {

		String sqlString = "insert into city values(?,?)";

		// get connection
		Connection connection = ConnectionManager.getConnection();
		// Statement object
		PreparedStatement statement = connection.prepareStatement(sqlString);
		statement.setLong(1, city.getCityId());
		statement.setString(2, city.getCityName());
		statement.executeUpdate();
		connection.close();
	}

}