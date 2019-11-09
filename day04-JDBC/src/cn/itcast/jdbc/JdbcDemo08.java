package cn.itcast.jdbc;

import cn.itcast.domain.Emp;
import cn.itcast.util.JdbcUtils;


import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author victor
 * @site https://victorfengming.github.io/
 * @company XDL
 * @project itcast
 * @package cn.itcast.jdbc
 * @created 2019-11-08 23:38
 * @function "定义一个方法,查询emp表的数据将其封装为对象,然后装载集合,返回"
 */
public class JdbcDemo08 {

    public static void main(String[] args) {
        List<Emp> list = new JdbcDemo08().findAll2();
        for (Emp emp : list) {
            System.out.println(emp);
        }
    }

    /**
     * 查询所有emp对象
     *
     * @return
     */
    public List<Emp> findAll() {
        //提前声明一些变量,以便于能够在try和catch中来回穿梭
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<Emp> list = null;

        try {
            // 1.注册,为了能够兼容mysql5以下的版本,所以写上
            Class.forName("com.mysql.jdbc.Driver");
            // 2.获取连接
            conn = DriverManager.getConnection("jdbc:mysql:///plan", "root", "");
            // 3.定义sql
            String sql = "select * from emp";
            // 4. 获取执行sql的对象
            stmt = conn.createStatement();
            // 5.执行sql
            rs = stmt.executeQuery(sql);
            // 先创建一个引用就ok
            Emp emp = null;
            list = new ArrayList<Emp>();
            // 6.遍历结果集
            while (rs.next()) {
                // 7.获取数据
                int id = rs.getInt("id");
                String ename = rs.getString("ename");
                int job_id = rs.getInt("job_id");
                int mgr = rs.getInt("mgr");
                // 这个sqlDate是Date 的子类,所以是可以直接进行赋值的
                Date joindate = rs.getDate("joindate");
                double bonus = rs.getDouble("bonus");
                double salary = rs.getDouble("salary");
                int dept_id = rs.getInt("dept_id");
                // 创建emp对象
                emp = new Emp();
                emp.setId(id);
                emp.setEname(ename);
                emp.setJob_id(job_id);
                emp.setMgr(mgr);
                emp.setJoindate(joindate);
                emp.setBonus(bonus);
                emp.setSalary(salary);
                emp.setDept_id(dept_id);

                // 装载集合
                list.add(emp);
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

            if (rs != null) {
                try {
                    rs.close();
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
        return list;
    }  /**
     * 演示JDBC工具类
     *
     * @return
     */
    public List<Emp> findAll2() {
        //提前声明一些变量,以便于能够在try和catch中来回穿梭
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<Emp> list = null;

        try {
            // 1.注册,为了能够兼容mysql5以下的版本,所以写上
            // 2.获取连接
            conn = JdbcUtils.getConnection();
            // 3.定义sql
            String sql = "select * from emp";
            // 4. 获取执行sql的对象
            stmt = conn.createStatement();
            // 5.执行sql
            rs = stmt.executeQuery(sql);
            // 先创建一个引用就ok
            Emp emp = null;
            list = new ArrayList<Emp>();
            // 6.遍历结果集
            while (rs.next()) {
                // 7.获取数据
                int id = rs.getInt("id");
                String ename = rs.getString("ename");
                int job_id = rs.getInt("job_id");
                int mgr = rs.getInt("mgr");
                // 这个sqlDate是Date 的子类,所以是可以直接进行赋值的
                Date joindate = rs.getDate("joindate");
                double bonus = rs.getDouble("bonus");
                double salary = rs.getDouble("salary");
                int dept_id = rs.getInt("dept_id");
                // 创建emp对象
                emp = new Emp();
                emp.setId(id);
                emp.setEname(ename);
                emp.setJob_id(job_id);
                emp.setMgr(mgr);
                emp.setJoindate(joindate);
                emp.setBonus(bonus);
                emp.setSalary(salary);
                emp.setDept_id(dept_id);

                // 装载集合
                list.add(emp);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            // 7. 释放资源
            JdbcUtils.close(rs,stmt,conn);
        }
        return list;
    }
}
