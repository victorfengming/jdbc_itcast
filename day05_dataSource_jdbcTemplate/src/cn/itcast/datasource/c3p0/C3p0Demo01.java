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
 * @created 2019-11-09 16:05
 * @function "c3p0演示"
 */
public class C3p0Demo01 {
    public static void main(String[] args) throws SQLException {
        // 1.创建数据库连接池对象
        DataSource ds = new ComboPooledDataSource();
        // 2. 获取连接对象
        Connection conn = ds.getConnection();

        // 3.打印
        System.out.println(conn);
    }
}
