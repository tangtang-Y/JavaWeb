package jdbc.practice.inject;

import java.sql.*;

/*
*
* sql注入演示
*
* */
public class InjectDemo01 {

    public static void main(String[] args) throws Exception{


        String url = "jdbc:mysql://localhost:3306/practice?useSSL=false";
        String userName = "root";
        String password = "linhaitang";
        Connection conn = DriverManager.getConnection(url,userName,password);

        //模拟用户输入用户名密码
        String name = "张三";
        String pwd = "' or '1' = '1";  //sql 注入

        //定义好的SQL

//        String sql = "select * from user_password where user_name = '"+name+"' and user_password = '"+pwd+"'";
        //用占位符 ? 替代字符串拼接
        String sql = "select * from user_password where user_name = ? and user_password = ?";

        PreparedStatement pre = conn.prepareStatement(sql);

        pre.setString(1,name);
        pre.setString(2,pwd);

//        System.out.println(sql);
        //select * from user_password where user_name = '张三' and user_password = '' or '1' = '1'

        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery(sql);

        if(rs.next()){
            System.out.println("登录成功");
        }else {
            System.out.println("登录失败");
        }


        rs.close();
        stmt.close();
        conn.close();

    }
}
