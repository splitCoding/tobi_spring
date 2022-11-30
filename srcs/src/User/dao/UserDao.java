package User.dao;

import User.domain.User;

import java.sql.*;

public class UserDao {
    static Connection connection;

    public void dbConnect(String jdbcDriver, String dbUrl, String userName, String password) throws SQLException, ClassNotFoundException {
        Class.forName(jdbcDriver);
        System.out.println("::Connecting to db....");
        connection = DriverManager.getConnection(dbUrl, userName, password);
        System.out.println("::Connect Success!!");
    }

    public void dbDisconnect() throws SQLException {
        connection.close();
        System.out.println("::Connection closed");
    }

    public void initDb() throws SQLException {
        String initDbSql = "drop all objects";
        Statement st = connection.createStatement();
        st.executeUpdate(initDbSql);
        System.out.println("::Init All");
        st.close();
    }

    public void createUserTable() throws SQLException {
        String createUserTableSql = "CREATE TABLE  USER_TABLE " +
                "(" +
                "id VARCHAR(10) PRIMARY KEY, " +
                "Name VARCHAR(20) not NULL, " +
                "Password VARCHAR(20) not NULL" +
                ")";
        Statement st = connection.createStatement();
        st.executeUpdate(createUserTableSql);
        System.out.println("::USER_TABLE successfully created");
        st.close();
    }

    public void add(User user) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("insert into user_table (id, name, password) values (?,?,?)");
        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());
        ps.executeUpdate();
        System.out.println("::User add successfully");
        ps.close();
    }

    public User get(String id) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("select * from user_table where id = ?");
        ps.setString(1, id);
        ResultSet rs = ps.executeQuery();
        System.out.println("::Found User By Id = " + id);
        rs.next();
        User find = new User();
        find.setId(rs.getString("id"));
        find.setName(rs.getString("name"));
        find.setPassword(rs.getString("password"));
        ps.close();
        rs.close();
        return find;
    }
}
