package cn.itcast.datasource.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author victor
 * @site https://victorfengming.github.io/
 * @company XDL
 * @project itcast
 * @package cn.itcast.datasource.c3p0
 * @created 2019-11-10 9:56
 * @function ""
 */
public class C3p0Demo02 {
    public static void main(String[] args) throws SQLException {
        //1.获取DataSource 使用默认配置
        DataSource ds = new ComboPooledDataSource();
       // 1.1 获取DataSource ,使用指定名称配置
        // 2.获取连接
        for (int i = 0; i < 10; i++) {
            Connection conn = ds.getConnection();
            System.out.println(i + ":" + conn);
            if (i == 5) {
                conn.close();   // 归还连接到连接池中
            }
        }
    }
}
