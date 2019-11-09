package cn.itcast.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;

/**
 * @author victor
 * @site https://victorfengming.github.io/
 * @company XDL
 * @project itcast
 * @package cn.itcast.jdbc
 * @created 2019-11-08 14:41
 * @function "用于插入数据"
 */
public class JdbcDemo02 {
    public static void main(String[] args) {
                System.out.println(LocalDateTime.now());

        Statement stmt = null;

        try {
            // 1.注册驱动
            // 这行不写也行
            //  Class.forName("com.mysql.jdbc.Driver");
            // 2. 定义sql
            //  String sql = "insert into account values(null,'ttk',6299)";
            String sql = "insert into account values(null,'ttk',1907)";
            // 获取Connection对象

            Connection conn = DriverManager.getConnection("jdbc:mysql:///plan", "root", "");
            // 4获取执行sql对象 Statement
            stmt = conn.createStatement();
            int count = 0;
            /*for (int i = 0; i < 1000; i++) {
                stmt.executeUpdate(sql);
                count++;
            }*/
            count = stmt.executeUpdate(sql);

            // 5 执行sql
            // count影响的行数
            // 6.处理结果
            System.out.println(count);
            if (count > 0) {
                System.out.println("提交成功");

            } else {
                System.out.println("添加失败");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 释放资源
            // 为了避免空指针异常需要判断
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
                System.out.println(LocalDateTime.now());

    }
}
