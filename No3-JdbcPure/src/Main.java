import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Chen Manman
 * @since ${DATE} ${TIME}
 * <p>
 * 直接引Jar包的JDBC程序
 * 增删改的运行语句均用execute()，查询的运行语句用executeQuery()
 */
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 获取连接
        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "02080328");
        //sql语句操作
        insert(connection);
        select(connection);
        update(connection);
        delete(connection);
        connection.close();
    }

    public static void insert(Connection connection) throws SQLException {
        // 写sql语句
        List<String> names = new ArrayList<>();
        names.add("明朝那些事");
        names.add("简爱");
        names.add("居里夫人传");
//        PreparedStatement statement = connection.prepareStatement("insert into book (name, create_time) values ('格林童话', '2022-12-30')");
        PreparedStatement statement = connection.prepareStatement("insert into book(name, create_time) values (?, ?)");
        for (String name : names) {
            statement.setString(1, name);
            statement.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
            statement.execute();
        }
        // 事务提交,默认提交，无需再手动添加该语句
        // connection.commit();
    }

    public static void delete(Connection connection) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("delete from book where name='简爱'");
        statement.execute();
    }

    public static void update(Connection connection) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("update book set name='MySQL' where name='简爱'");
        statement.execute();
    }

    public static void select(Connection connection) throws SQLException {
        //写sql语句
        PreparedStatement statement = connection.prepareStatement("select * from book");
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            Timestamp createTime = resultSet.getTimestamp("create_time");
            System.out.println(name + " " + createTime);
        }
    }
}