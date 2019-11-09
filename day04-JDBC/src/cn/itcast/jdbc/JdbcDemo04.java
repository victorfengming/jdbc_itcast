package cn.itcast.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author victor
 * @site https://victorfengming.github.io/
 * @company XDL
 * @project itcast
 * @package cn.itcast.jdbc
 * @created 2019-11-08 15:35
 * @function "从表中删除记录"
 */
public class JdbcDemo04 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            // 1.注册表
            // 2.获取连接对象
            conn = DriverManager.getConnection("jdbc:mysql:///plan","root","");
            // 3. 定义sql
            String sql = "delete from account where id = 4";
            // 4.获取执行sql对象
            stmt = conn.createStatement();
            // 5.执行sql
            int count = stmt.executeUpdate(sql);
            // 6.处理结果
            if (count > 0) {
                System.out.println("运行成功");
            } else {
                System.out.println("失败了!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            // 7. 释放资源
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
