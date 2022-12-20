package druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

/*
*
* 一、数据库连接池概述
* 1.数据库连接池是个容器，负责分配、管理数据库连接（Connection）
* 2.它允许应用程序重复使用一个现有的数据库连接，而不是再重新建立一个
* 3.释放超过最大空闲时间的数据库连接来避免因为没有释放数据库连接而引起的数据库连接遗漏
*
* 好处：
* 1.资源复用
* 2.提升系统响应速度
* 3.避免数据库连接遗漏
*
* 二、数据库连接池的实现
* 1.标准接口：DataSource
*   官方提供的数据库连接池标准接口，由第三方组织实现此接口
*   功能：获取连接
*   Connection getConnection();
*
* 2.常见的数据库连接池
* 1.DBCP
* 2.C3P0
* 3.Druid
*
* Druid(德鲁伊)
* 1.Druid连接池是阿里巴巴开源的数据库连接池项目
* 2.功能强大，性能优秀，是Java语言最好的数据库连接池之一
*
* Druid使用步骤：
* 1.导入jar包
* 2.定义配置文件
* 3.加载配置文件
* 4.获取数据库连接池对象
* 5.获取连接
*
*
* */
public class Note {

    public static void main(String[] args) throws Exception{


        //加载配置文件

        Properties prop = new Properties();

        prop.load(new FileInputStream("D:\\workspace\\JavaWeb\\src\\druid.properties"));

        //获取连接池对象,固定用法DruidDataSourceFactory.createDataSource(prop);
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        //获取数据库连接
        Connection connection = dataSource.getConnection();

        System.out.println(connection);
    }
}
