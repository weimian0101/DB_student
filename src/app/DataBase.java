package app;

import java.sql.*;

public class DataBase {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/stu?" + "useSSL=false&serverTimezone=GMT&characterEncoding=UTF-8";
    static final String username = "root";
    static final String password = "123456";

    //连接数据库
    public void connect() throws SQLException {
        Connection conn = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, username, password);
            if (conn != null) {
                System.out.println("Database connection successful");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
        //查询数据
    public void query() throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = DriverManager.getConnection(DB_URL,username,password);
            stmt = conn.createStatement();
            String sql = "SELECT * FROM stu_mess " +
                    "WHERE stuSex = '男'";
            stu_info(stmt, sql);

        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            if(stmt!= null) {
                stmt.close();
            }
            if(conn != null) {
                conn.close();
            }
        }
    }
    //插入数据
    public void insert() throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = DriverManager.getConnection(DB_URL,username,password);
            stmt = conn.createStatement();
            String sql = "INSERT INTO stu_mess (stuNumber, stuName, stuSex, stuPhone_num) VALUES ('2024006','王晓雨','女','13812345678')";
            int rows = stmt.executeUpdate(sql);
            if(rows > 0) {
                System.out.println("Data inserted successfully");
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            if(stmt != null) {
                stmt.close();
            }
            if(conn != null) {
                conn.close();
            }
        }
    }

    //更新数据
    public void update() throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = DriverManager.getConnection(DB_URL,username,password);
            stmt = conn.createStatement();
            String sql = "UPDATE stu_mess SET stuPhone_num = '13612845678' WHERE stuName = '张三'";
            int rows = stmt.executeUpdate(sql);
            if(rows > 0) {
                System.out.println("Data updated successfully");
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            if(stmt != null) {
                stmt.close();
            }
            if(conn != null) {
                conn.close();
            }
        }
    }

    //删除数据
    public void delete() throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = DriverManager.getConnection(DB_URL, username, password);
            stmt = conn.createStatement();
            String sql = "DELETE FROM stu_mess WHERE stuName = '艾合买提·买买提'";
            int rows = stmt.executeUpdate(sql);
            if (rows > 0) {
                System.out.println("Data deleted successfully");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //关闭数据库连接
    public void close() throws SQLException {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL,username,password);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        if(conn!= null) {
            conn.close();
            System.out.println("Database connection closed");
        }
    }

    public void traverse() throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = DriverManager.getConnection(DB_URL,username,password);
            stmt = conn.createStatement();
            String sql = "SELECT * FROM stu_mess";
            stu_info(stmt, sql);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            if(stmt != null) {
                stmt.close();
            }
            if(conn != null) {
                conn.close();
            }
        }

    }

    private void stu_info(Statement stmt, String sql) throws SQLException {
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()) {
            String id = rs.getString("stuNumber");
            String name = rs.getString("stuName");
            String sex = rs.getString("stuSex");
            String phone = rs.getString("stuPhone_num");
            System.out.println( "学号: " + id + "\t 姓名: " + name + "\t 性别: " + sex + "\t 电话号码: " + phone);
        }
    }
}

