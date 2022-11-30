package User.dao;

import User.domain.User;

public class UserDaoCheck {
    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:~/Desktop/tobi_spring/test_db";
    static final String USER = "split";
    static final String PASSWORD = "sa";

    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        try {
            userDao.dbConnect(JDBC_DRIVER, DB_URL, USER, PASSWORD);
            userDao.initDb();
            userDao.createUserTable();
            User user = new User();
            user.setId("1");
            user.setName("split");
            user.setPassword("sa");
            userDao.add(user);
            User findUser = userDao.get("1");
            System.out.println(findUser);
            userDao.dbDisconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
