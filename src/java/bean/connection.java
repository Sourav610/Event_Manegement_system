package bean;

import java.sql.*;

public class connection {
    private String Name;
    private String Add;
    private String cont;
    private String email;
    private String pass;
    private String sq;
    private String ans;

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getAdd() {
        return Add;
    }

    public void setAdd(String Add) {
        this.Add = Add;
    }

    public String getCont() {
        return cont;
    }

    public void setCont(String cont) {
        this.cont = cont;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getSq() {
        return sq;
    }

    public void setSq(String sq) {
        this.sq = sq;
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }
    
    public boolean insert(){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localHost:1521:XE","system","coding1234");
            Statement stmt = con.createStatement();
            String q1 = "insert into People values('"+Name+"','"+Add+"','"+cont+"','"+email+"','"+pass+"','"+sq+"','"+ans+"')";
            int x = stmt.executeUpdate(q1);
            if(x>0){
                return true;
            }
            else{
                return false;
            }
            
        }
        catch(Exception e){
            System.out.println(e);
        }
        return false;
    }
    public boolean fetch(){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","coding1234");
            Statement stmt = con.createStatement();
            String s1 = "select * from People where email='"+email+"'and pass='"+pass+"'";
            ResultSet rs = stmt.executeQuery(s1);
            if(rs.next()){
                return true;
            }
            else{
                return false;
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        return false;
    }
    public boolean forgetFetch(){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","coding1234");
            Statement stmt = con.createStatement();
            String s1 = "select * from People where email='"+email+"'";
            ResultSet rs = stmt.executeQuery(s1);
            if(rs.next()){
                return true;
            }
            else{
                return false;
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        return false;
    }
}
