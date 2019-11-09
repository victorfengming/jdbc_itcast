package cn.itcast.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * @author victor
 * @site https://victorfengming.github.io/
 * @company XDL
 * @project itcast
 * @package cn.itcast.jdbc
 * @created 2019-11-07 23:43
 * @function ""
 */
public class JdbcDemo01 {

    public static void main(String[] args) throws Exception {
        // 1. 导入驱动jar包
        // 2.注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        // 3.获取数据库连接对象
//        Connection conn = DriverManager.getConnection("jdbc:mysql:///plan","root","");
        Connection conn = DriverManager.getConnection("jdbc:mysql:///plan","root","");

        //4. 定义sql
        String sql = "use plan";
        //5. 获取执行sql语句的对象 statement
        Statement stmt = conn.createStatement();
        //6. 执行sql,接收返回结果
        int count = stmt.executeUpdate(sql);
        //7. 处理结果
        System.out.println(count);
        //8. 释放资源
        stmt.clearBatch();
        conn.close();
    }
}
