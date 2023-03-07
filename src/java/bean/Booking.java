package bean;
import java.sql.*;

public class Booking{
    private String name;
    private String date;
    private String time;
    private String loc;
    private String desc;
    private String stat;
    private String num;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }
   
    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
    
    public boolean insert(){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localHost:1521:XE","system","coding1234");
            Statement stmt = con.createStatement();
            String q1 = "insert into Booking values('"+name+"','"+date+"','"+time+"','"+loc+"','"+desc+"','"+num+"','"+stat+"')";
            int x = stmt.executeUpdate(q1);
            System.out.println(q1);
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
            String s1 = "select * from Booking";
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