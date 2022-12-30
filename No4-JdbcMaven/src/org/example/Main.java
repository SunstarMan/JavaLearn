package org.example;

import java.sql.*;

/**
 * @author Chen Manman
 * @since 2022/12/30 14:20
 */
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 获取连接
        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "02080328");
        PreparedStatement statement = connection.prepareStatement("select * from book;");
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            Timestamp createTime = resultSet.getTimestamp("create_time");
            System.out.println(name + "  " + createTime);
        }
        connection.close();
    }
}
