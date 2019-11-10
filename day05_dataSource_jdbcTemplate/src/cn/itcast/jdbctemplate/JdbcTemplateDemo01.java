package cn.itcast.jdbctemplate;

import cn.itcast.utils.JdbcUtils;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author victor
 * @site https://victorfengming.github.io/
 * @company XDL
 * @project itcast
 * @package cn.itcast.jdbctemplate
 * @created 2019-11-10 15:54
 * @function ""
 */
public class JdbcTemplateDemo01 {
    public static void main(String[] args) {
        //1.导入jar包
        // 2.创建JDBCTemplate对象
        JdbcTemplate template = new JdbcTemplate(JdbcUtils.getDataSource());
        //3.嗲用方法
        // 定义一个sql
        String sql = "update account set balance = 9999 where id = ?";

        int count = template.update(sql,3);
        System.out.println(count);
        // 这里不用释放资源了,得劲
    }
}
