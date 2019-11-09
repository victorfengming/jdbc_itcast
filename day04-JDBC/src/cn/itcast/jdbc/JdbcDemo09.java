package cn.itcast.jdbc;

import cn.itcast.util.JdbcUtils;
import cn.itcast.util.python;

import java.sql.*;

/**
 * @author victor
 * @site https://victorfengming.github.io/
 * @company XDL
 * @project itcast
 * @package cn.itcast.jdbc
 * @created 2019-11-09 11:52
 * @function "- 需求 :
 * - 通过键盘录入用户名和密码
 * - 判断用户是否登录成功"
 */
public class JdbcDemo09 {

    public static void main(String[] args) {
        // 1.键盘录入,接收用户名和密码
        String username = python.input("请输入用户名:");
        String password = python.input("请输入密码:");
        // 2.调用用方法
        //创建对象
        boolean flag = new JdbcDemo09().login(username, password);
        // 3.判断结果,输出不同语句
        if (flag) {
            System.out.println("登录成功");
        } else {
            System.out.println("用户名或者密码错误");
        }
    }


    /**
     * 登录方法
     */
    public boolean login(String username, String password) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            if (username != null || password != null) {
                ;
            }
            // 连接数据库判断是否登录成功
            // 1.获取连接
            conn = JdbcUtils.getConnection();
            // 2.定义sql
            String sql = "select * from user where username = ? and password = ?";
            System.out.println(sql);
            // 3获取执行sql的对象
            // stmt = conn.createStatement();
            // 升级版本的
            pstmt = conn.prepareStatement(sql);
            // 4执行查询
            //  rs = pstmt.executeQuery(sql);
            // 这里不需要传递参数了
            rs = pstmt.executeQuery();
            // 5判断
            // 要是查到了, 唉, 就直接就返回true
            //            if (rs.next()) {
            //                // 如果有下一行则返回true
            //                return true;
            //            } else {
            //                return false;
            //            }
            // 上面的代码就是垃圾代码
            // 如果有下一行则返回true
            return rs.next();

        } catch (SQLException e) {
            e.printStackTrace();
            //        去改配置文件, 数据库要db4
            // 这里就体现了JdbcUtils类的可扩展性很强了,不用改代码都
        }finally {
            // 释放资源
            JdbcUtils.close(rs,pstmt,conn);
        }

        return false;
    }
}
