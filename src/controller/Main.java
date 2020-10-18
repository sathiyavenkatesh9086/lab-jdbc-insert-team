

package controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import dao.CityDAO;
import dao.TeamDAO;
import model.City;
import model.Team;
import utility.ConnectionManager;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		// creating object
		CityDAO citydao = new CityDAO();
		TeamDAO teamdao = new TeamDAO();
		City city = null;
		Team team = null;

		// getting inputs
		System.out.println("Enter City id");
		long cityId = Long.parseLong(reader.readLine());

		System.out.println("Enter city name");
		String cityName = reader.readLine();

		System.out.println("Enter the team ID");
		Long teamID = Long.parseLong(reader.readLine());

		System.out.println("Enter team name");
		String teamName = reader.readLine();

		System.out.println("Enter coach name");
		String coachName = reader.readLine();

		System.out.println("Enter captain");
		long captain = Long.parseLong(reader.readLine());

		city.setCityId(cityId);
		city.setCityName(cityName);
		citydao.createCity(city);

		team.setCity(city);
		team.setId(teamID);
		team.setName(teamName);
		team.setCoach(coachName);
		team.setCaptain(captain);
		teamdao.createTeam(team);

		System.out.println("Team Details are : ");
		System.out.println("Name \t Coach \t City");

		Connection connection = ConnectionManager.getConnection();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT * FROM KABBADI");
		while (resultSet.next()) {
			System.out.println("Team Name : " + resultSet.getString(1));
			System.out.println("Coach Name : " + resultSet.getString(2));
			// System.out.println("Captain Name : " + resultSet.getString(3));
			// System.out.println("City ID : " + resultSet.getString(4));
			System.out.println("City Name : " + resultSet.getString(5));
		}

	}
}