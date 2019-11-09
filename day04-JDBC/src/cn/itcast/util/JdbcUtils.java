package cn.itcast.util;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

/**
 * @author victor
 * @site https://victorfengming.github.io/
 * @company XDL
 * @project itcast
 * @package cn.itcast.util
 * @created 2019-11-09 10:40
 * @function "JDBC工具类"
 */
public class JdbcUtils {

    //声明三个成员变量
    // 因为只有静态变量才能被静态代码块所访问,被静态方法所访问
    private static String url;
    private static String user;
    private static String password;
    private static String driver;

    /**
     * 文件的读取,只需要读取一次即可拿到这些值
     * 我们可以使用静态代码块
     * 因为静态代码块是随着类加载进行加载的
     * 只读取一次
     */

    static {
        // 读取资源文件,获取值
        try {
            // 1. 创建 Properties集合类
            Properties pro = new Properties();
            // 2.加载文件
//            pro.load(new FileReader("D:\\IdeaProjects\\itcast\\day04-JDBC\\src\\jdbc.properties"));
            // 这么写指定不行
            // 获取src路径下的文件的方式-->ClassLoader 类加载器
            ClassLoader classLoader = JdbcUtils.class.getClassLoader();
            // 这里的相对路径就是src
            URL res = classLoader.getResource("jdbc.properties");
            // 这里URL表示统一资源对应符
            String path = res.getPath();
//            System.out.println(path);
            pro.load(new FileReader(path));
            // 3.获取属性,赋值
            url = pro.getProperty("url");
            user = pro.getProperty("user");
            password = pro.getProperty("password");
            driver = pro.getProperty("driver");
            // 4. 注册驱动
            Class.forName(driver);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    /**
     * 获取连接
     * @return 连接对象
     */
//    public static Connection getConnection(String url,String user,String password,String driver) throws SQLException {
//        return DriverManager.getConnection(url, user, password);
//    }
//    这个地方,我既不想用传递参数的方式,还想要简化书写,这可咋整,我们这里使用配置文件的方式,所以要这样写
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    /**
     * 释放资源方法
     */
    public static void close(Statement stmt, Connection conn) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 释放资源方法重载
     */
    public static void close(ResultSet rs, Statement stmt, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
