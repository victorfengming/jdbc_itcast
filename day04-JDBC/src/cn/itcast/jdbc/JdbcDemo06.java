package cn.itcast.jdbc;

import java.sql.*;

/**
 * @author victor
 * @site https://victorfengming.github.io/
 * @company XDL
 * @project itcast
 * @package cn.itcast.jdbc
 * @created 2019-11-08 16:01
 * @function "查询是重中之重"
 */
public class JdbcDemo06 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            // 1.注册表
            // 2.获取连接对象
            conn = DriverManager.getConnection("jdbc:mysql:///plan", "root", "");
            // 3. 定义sql
            String sql = "select * from account";
            // 4.获取执行sql对象
            stmt = conn.createStatement();
            // 5.执行sql
            rs = stmt.executeQuery(sql);
            // 6.处理结果
            // 6.1 让游标向下移动一行
            // 循环判断游标是否最后一行末尾
            while (rs.next()) {
                //            获取数据
                int id = rs.getInt(1);
                String name = rs.getString("name");
                double balance = rs.getDouble(3);
                System.out.println(id + "---" + name + "---" + balance);

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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
