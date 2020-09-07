package edu.samir.pizza2nice.api.dao.orm;

import java.sql.*;

public class MySqlDatabaseConnexionImpl {
    private final String url;
    private final String user;
    private final String pwd;

    private Connection connection;

    public MySqlDatabaseConnexionImpl(String url, String user, String pwd) {
        this.url = url;
        this.user = user;
        this.pwd = pwd;
    }

    public MySqlDatabaseConnexionImpl() {
        url = "jdbc:mysql://localhost:3306/pizza2nice";
        user = "samir";
        pwd = "08634454";
    }

    public void connectToDatabase() throws SQLException {
        Connection connection = DriverManager.getConnection(url, user, pwd);
    }

    public ResultSet getResultSetForSqlQuery(String sqlQuery) throws SQLException {
            Statement statement = connection.createStatement();
            return statement.executeQuery(sqlQuery);
    }

    public void closeDatabaseConnection() throws SQLException {
        connection.close();
    }

}
