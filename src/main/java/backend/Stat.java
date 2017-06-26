package backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Stat {
	Connection connect;
	Statement statement;
	ResultSet resultSet;
	configPw config = new configPw();
	String pw = config.getPw();
	String username = config.getUsername();

	public void setBadQuest(String questB, String answer, String wiki) {
		PreparedStatement ps;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/backend?autoReconnect=true&useSSL=false",
					username, pw);
			statement = connect.createStatement();
			ps = connect.prepareStatement("INSERT INTO quest (quest, asnwer, wiki) VALUES (?,?,?)");
			ps.setString(1, questB);
			ps.setString(2, answer);
			ps.setString(3, wiki);
			ps.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			close();
		}

	}

	public String status(String command) {
		String asql = "select answerdQuest, answerdCorrect from users";
		String giveBack = "";
		double correct = 0;
		double all = 0;
		double temp = 0;
		int count = 0;
		String cmd = "";
		switch (command) {
		case "age":
			cmd = "age";
			count = 5;
			break;
		case "gender":
			cmd = "stat";
			count = 5;
			break;
		default:

			break;
		}

		try {

			// statement = connect.createStatement();
			// resultSet = statement.executeQuery(asql);
			for (int i = 1; i < count; i++) {
				correct = 0;
				all = 0;
				temp = 0;
				String query = asql + " where " + cmd + "=" + i;
				if (i == 4 && cmd == "stat") {
					query = asql;
				}
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				connect = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/backend?autoReconnect=true&useSSL=false", username, pw);
				statement = connect.createStatement();
				resultSet = statement.executeQuery(query);
				while (resultSet.next()) {
					all += resultSet.getDouble(1);
					correct += resultSet.getDouble(2);

				}
				temp = correct / all;
				giveBack = giveBack + temp;
				if (i != 4) {
					giveBack += ",";
				}
			}

		} catch (Exception e) {
			giveBack = e.getMessage();
		} finally {
			close();
		}
		return giveBack;
	}

	public void set(int quest, int correct, int possible, int age, int status, String wiki, String feedback) {
		PreparedStatement ps;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/backend?autoReconnect=true&useSSL=false",
					username, pw);
			statement = connect.createStatement();
			ps = connect.prepareStatement(
					"INSERT INTO users (answerdQuest, answerdCorrect, answersPossible, age, stat, wiki, feedback) VALUES (?,?,?,?,?,?,?)");
			ps.setInt(1, quest);
			ps.setInt(2, correct);
			ps.setInt(3, possible);
			ps.setInt(4, age);
			ps.setInt(5, status);
			ps.setString(6, wiki);
			ps.setString(7, feedback);
			ps.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			close();
		}

	}

	private void close() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}

			if (statement != null) {
				statement.close();
			}

			if (connect != null) {
				connect.close();
			}
		} catch (Exception e) {

		}
	}

}
