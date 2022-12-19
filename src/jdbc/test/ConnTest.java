package jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
*
* Connection
*
* 事务管理
*
* java用处理异常的方式来处理事务回滚
*
* */
public class ConnTest {

    public static void main(String[] args) throws Exception{

//        Class.forName("com.mysql.jdbc.Driver");

        //连接数据库
        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1 : 3306/selfdefinedb?useSSL = false", "root", "linhaitang");

        //定义SQL语句
        String sql1 = "update account set money = 3000 where id = 1";
        String sql2 = "update account set money = 3000 where id = 2";

        //获取对象

        Statement stmt = conn.createStatement();

        try {

            //开启事务
            conn.setAutoCommit(false);

            int ret1 = stmt.executeUpdate(sql1);

//            int i = 3/0;

            int ret2 = stmt.executeUpdate(sql2);


            System.out.println(ret1);
            System.out.println(ret2);

            //提交事务
            conn.commit();


        } catch (Exception e) {
            conn.rollback();
           e.printStackTrace();
        }

        stmt.close();
        conn.close();
    }
}
