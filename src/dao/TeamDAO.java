
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import model.Team;
import utility.ConnectionManager;

public class TeamDAO {
	public void createTeam(Team team) throws Exception {

		// connection to the database
		Connection connection = ConnectionManager.getConnection();

		// insert into the team table
		String sql = "insert into kabbadi(id,name,coach,home_city,capatin) values(?,?,?,?,?)";
		PreparedStatement statement = connection.prepareStatement(sql);

		// set team parameters
		statement.setLong(1, team.getId());
		statement.setString(1, team.getName());
		statement.setString(2, team.getCoach());
		statement.setLong(3, team.getCaptain());
		statement.setLong(4, team.getCity().getCityId());
		statement.setString(5, team.getCity().getCityName());
		statement.executeUpdate();
		connection.close();
		System.out.println("Team has been created");
	}
}