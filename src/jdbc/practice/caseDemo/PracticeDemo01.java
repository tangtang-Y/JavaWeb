package jdbc.practice.caseDemo;

/*
*
* 案例
* 查询MySQL的account表，并设置为Account对象，对象存储到ArrayList集合中，并遍历
*
*
* */

import jdbc.practice.caseDemo.Account;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class PracticeDemo01 {

    public static void main(String[] args) throws Exception{


        //注册驱动
//        Class.forName("com.mysql.jdbc.Driver");


        //获取数据库连接

        String url = "jdbc:mysql://localhost:3306/practice?useSSL=false";
        String userName = "root";
        String password = "linhaitang";

        Connection conn = DriverManager.getConnection(url, userName, password);

        //定义SQL
        String sqlUpdate = "update account set money = 2000 where id = 2";
        String sqlUpdate1 = "update account set money = 3200 where id = 4";

        String sqlQuery = "select * from account";

        //获取执行SQL的对象
        Statement stmt = conn.createStatement();

         stmt.executeUpdate(sqlUpdate);
         stmt.executeUpdate(sqlUpdate1);

        ResultSet rs = stmt.executeQuery(sqlQuery);

        ArrayList<Account> list = new ArrayList<>();

        while (rs.next()){
            int id = rs.getInt("id");
            String a_name = rs.getString("a_name");
            double money = rs.getDouble("money");

            Account account = new Account();

            account.setId(id);
            account.setA_name(a_name);
            account.setMoney(money);

            list.add(account);
        }

        list.forEach(System.out::println);


        rs.close();
        stmt.close();
        conn.close();

    }
}
