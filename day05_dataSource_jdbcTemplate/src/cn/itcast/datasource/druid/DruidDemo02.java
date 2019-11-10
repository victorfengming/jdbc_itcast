package cn.itcast.datasource.druid;

import cn.itcast.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author victor
 * @site https://victorfengming.github.io/
 * @company XDL
 * @project itcast
 * @package cn.itcast.datasource.druid
 * @created 2019-11-10 15:13
 * @function ""
 */
public class DruidDemo02 {
    public static void main(String[] args) {
        /*
         * 完成添加操作:给account表添加一条记录
         * */
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            //1 .获取连接
            conn = JdbcUtils.getConnection();
            // 2. 定义sql
            // String sql = "insert into account valuse(null,?,?)";
            String sql = "insert into account values(null,?,?)";
            // 3. 获取pstmt对象
            pstmt = conn.prepareStatement(sql);
            // 给问号赋值
            pstmt.setString(1, "王五");
            pstmt.setInt(2, 3000);
            // 5. 执行sql
            System.out.println(pstmt.executeUpdate());
            // System.out.println(count);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 释放资源
            JdbcUtils.close(pstmt, conn);
        }
    }
}
