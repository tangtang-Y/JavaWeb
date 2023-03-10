package jdbc;

/*
*
* JDBC:就是使用Java语言操作关系型数据库的一套API（标准接口）
* 全称：(java DataBase Connectivity)Java数据库连接
*
* 相应的实现类(MySQL接口)，称为驱动(.jar)
*
* JDBC本质：
* 1.官方(SUN公司)定义的一套操作所有关系型数据库的规则，即接口
* 2.各个数据库厂商去实现这套接口，提供数据库驱动jar包
* 3.我们可以使用这套接口(JDBC)编程，真正执行的代码是驱动jar包中的实现类
*
* JDBC的好处：
* 1.各个数据库厂商使用相同的接口，Java代码不需要针对不同的数据库分别开发
* 2.可以随时替换底层数据库，访问数据库的Java代码基本不变
*
* JDBC API:
* 1.DriverManager(驱动管理类)(工具类)
* 作用：注册驱动，获取数据库连接
*方法 static Connection getConnection(url, username, password)
*
* 2.Connection
* 作用：获取执行SQL的对象、管理事务
* (1)普通执行SQL对象
*    Statement createStatement();
* (2)预编译SQL的执行SQL对象：防止SQL注入
* PreparedStatement prepareStatement();
*
* (3)执行存储过程的对象
* CallableStatement prepareCall(sql);
*------------------------------------
* 事务管理功能：
* (1)Mysql事务管理
* 1.开启事务：BEGIN;START TRANSACTION;
* 2.提交事务：COMMIT;
* 3.回滚事务：ROLLBACK;
*
* MySQL默认自动提交事务
*
* (2)JDBC事务管理：Connection接口中定义了3个方法
* 1.开启事务：setAutoCommit(boolean autoCommit);true为自动提交事务。false为手动提交事务，即为开启事务
* 2.提交事务：commit();
* 3.回滚事务：rollback();
*
*
* 3.Statement
* 作用：执行SQL语句
* int executeUpdate(sql);执行DML、DDL语句
* 返回值：(1)DML语句影响的行数 (2)DDL语句执行后，执行成功也可能返回0；
*
* ResultSet executeQuery(sql);执行DQL语句
* 返回值：ResultSet 结果集对象
*
*
* 4.ResultSet
* 结果集对象
*
* next();
* getXxx(参数)
*
* 使用格式：
* while(rs.next()){
*
*  rs.getXxx();
*
*
* }
*
*
* 5.PreparedStatement
* 作用：预编译SQL语句并执行，预防SQL注入问题
*
* SQL注入(Inject)：
* SQL注入是通过操作输入来修改事先定义好的SQL语句，用以达到执行代码对服务器进行攻击的方法。
*
* PreparedStatement的好处：
* 1.预编译SQL：性能更高
* 2.防止SQL注入：将敏感字符进行转义
*
* PreparedStatement预编译功能开启：useServerPrepStmts=true;
*
* 配置MySQL执行日志（在my.ini定义）:
* log-output=FILE
* general-log=1
* general_log_file="D:\mysql.log"
* slow-query-log=1
* slow_query_log_file="D:\mysql_slow.log"
* long_query_time=2
*
* PreparedStatement原理：
* 1.在获取PreparedStatement对象时，将SQL语句发送给MySQL服务器进行检查，编译（这些步骤很耗时）
* 2.执行时就不需要再进行这些步骤
* 3.如果SQL模板一样，则只需要进行一次检查、编译
*
*
*
*
*
*
*
*
* ---------------------------------------------------------------------------------------0
*
* 知识点补充:
* jar包的启动方式
*
* 在命令行输入 java -jar
*
*
*
*
*
*
* */

import java.sql.*;

@SuppressWarnings("all")
public class Note {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //注册驱动
//        Class.forName("com.mysql.jdbc.Driver");

        //获取连接对象
        String url = "jdbc:mysql://127.0.0.1:3306/selfdefinedb?useSSL=false";

        String username = "root";
        String password = "linhaitang";

        Connection connection = DriverManager.getConnection(url, username, password);


        //定义SQL
        String sql = "update account set money = 2000 where id = 1";

        //获取执行SQL的对象
        Statement statement = connection.createStatement();

        //执行sql
        int i = statement.executeUpdate(sql);  //受影响的行数

        //处理结果

        System.out.println(i);

        //释放资源
        statement.close();
        connection.close();


    }
}
