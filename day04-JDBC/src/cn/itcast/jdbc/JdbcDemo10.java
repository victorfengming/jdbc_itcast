package cn.itcast.jdbc;

import cn.itcast.util.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author victor
 * @site https://victorfengming.github.io/
 * @company XDL
 * @project itcast
 * @package cn.itcast.jdbc
 * @created 2019-11-09 14:07
 * @function "事务操作"
 */
public class JdbcDemo10 {
    public static void main(String[] args) {
        transfer();
    }


    /**
     * 转账函数
     */
    public static void transfer() {
        Connection conn = null;
        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;
        try {
            // 1.获取来接
            conn = JdbcUtils.getConnection();
            // 2. 定义sql
            //2.1 victor+500
            String sql1 = "update account set balance = balance + ? where id = ?";
            // 2.2 ttkr -50
            String sql2 = "update account set balance = balance - ? where id = ?";
            // 3.获取执行sql对象
            pstmt1 = conn.prepareStatement(sql1);
            pstmt2 = conn.prepareStatement(sql2);
            // 设置参数
            pstmt1.setDouble(1,500);
            pstmt1.setDouble(2,1);

            pstmt2.setDouble(1,500);
            pstmt2.setDouble(2,2);

            // 5.执行sql
            pstmt1.executeUpdate();
            // 手动制造异常
            int i = 3/0;
            pstmt2.executeUpdate();

        } catch (Exception e) {
            // 事务回滚
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            JdbcUtils.close(pstmt1,conn);
            JdbcUtils.close(pstmt2,null);

        }
    }
}
