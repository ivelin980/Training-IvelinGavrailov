package chat.server;

import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

public class Database {
	private Connection con;
	private static Database dbObject;

	private Database() throws DecoderException {
		try {
			String hexPass = "506124243049473938303530";
			this.con = DriverManager.getConnection("jdbc:mysql:///chatserver", "root",
					new String(Hex.decodeHex(hexPass), StandardCharsets.UTF_8));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static Database getInstance() throws DecoderException {
		if (dbObject == null) {
			dbObject = new Database();
		}
		return dbObject;
	}

	public List<String> getUserNames() throws SQLException {
		List<String> userNames = new ArrayList<>();
		try (PreparedStatement stmt = con.prepareStatement("select * from users"); ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				userNames.add(rs.getString("username"));
			}
		}
		return userNames;
	}

	public boolean isAlreadyInUse(String username) throws SQLException {
		boolean isNotValid;
		try (PreparedStatement stmt = con.prepareStatement("Select * from users where username=?")) {
			stmt.setString(1, username);
			try (ResultSet rs = stmt.executeQuery()) {
				isNotValid = rs.next();
			}
			return isNotValid;
		}
	}

	public boolean isLoginSuccessful(String username, String pass) throws SQLException {
		boolean isSuccessful;
		try (PreparedStatement stmt = con.prepareStatement("Select * from users where username=? and pass=?")) {
			stmt.setString(1, username);
			stmt.setString(2, pass);
			try (ResultSet rs = stmt.executeQuery()) {
				isSuccessful = rs.next();
			}
			return isSuccessful;
		}
	}

	public boolean createUser(String userName, String pass) throws SQLException {
		boolean isSuccessful;
		try (PreparedStatement stmt = con
				.prepareStatement("insert into users values(" + System.currentTimeMillis() + ",?,?)")) {
			stmt.setString(1, userName);
			stmt.setString(2, pass);
			try (ResultSet rs = stmt.executeQuery()) {
				isSuccessful = rs.next();
			}
		}
		return isSuccessful;
	}

	public int updateUserName(int code, String username, String pass) throws SQLException {
		int rowsAffected;
		try (PreparedStatement stmt = con.prepareStatement("update users set username=? ,pass=? where code=?")) {
			stmt.setString(1, username);
			stmt.setString(2, pass);
			stmt.setLong(3, code);
			try (ResultSet rs = stmt.executeQuery()) {
				rowsAffected = stmt.executeUpdate();
			}
		}
		return rowsAffected;
	}

	public ServerData getServerData(String serverName) throws SQLException {
		ServerData serverData = null;
		try (PreparedStatement stmt = con.prepareStatement("select ip,port from servers where name=?")) {
			stmt.setString(1, serverName);
			try (ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					serverData = new ServerData(serverName, rs.getString("ip"), rs.getInt("port"));
				}
			}
		}
		return serverData;
	}

	public int getServerCode(String serverName) throws SQLException {
		int serverCode = -1;
		try (PreparedStatement stmt = con.prepareStatement("select code from servers where name=?")) {
			stmt.setString(1, serverName);
			try (ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					serverCode = rs.getInt("code");
				}
			}
		}
		return serverCode;
	}
}
