import java.sql.*;

public class Main {

    public static void main(String[] args) {
        Connection con;
        Statement st;
        ResultSet rs;
        String dbURL = "jdbc:sqlserver://localhost:1433;DatabaseName=school;encrypt=true;trustServerCertificate=true";
        String userName = "sa";
        String userPwd = "123456";
        String sql = "select * from 学生表";
        try {
            con = DriverManager.getConnection(dbURL, userName, userPwd);
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                String sno = rs.getString(1);
                String sname = rs.getString(2);
                String ssex = rs.getString(3);
                String sbir = rs.getString(4);
                System.out.println("学号：" + sno + " 姓名：" + sname + " 性别：" + ssex
                        + " 出生日期：" + sbir );
            }
            rs.close();
            st.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据库连接失败！！！");
        }

    }

}

