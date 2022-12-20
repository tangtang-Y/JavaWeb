package jdbc.practice.inject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*
* 解决SQL注入问题
*
* */
public class InjectDemo02 {

    public static void main(String[] args) throws Exception{

        String url = "jdbc:mysql://localhost:3306/practice?useSSL=false&useServerPrepStmts=true";
        String userName = "root";
        String password = "linhaitang";

        Connection conn = DriverManager.getConnection(url,userName,password);


        String name = "张三";
        String pwd = "' or '1' = '1";
        //定义SQL
        String sql = "select * from user_password where user_name = ? and user_password = ?";

        PreparedStatement pre = conn.prepareStatement(sql);

        pre.setString(1,name);
        pre.setString(2,pwd);

        ResultSet rs = pre.executeQuery();

        if (rs.next()){
            System.out.println("登录成功");
        }else {
            System.out.println("登录失败");
        }



        rs.close();
        pre.close();
        conn.close();



    }




}
