import java.io.*;
import java.sql.*;
import java.awt.*;
class FetchAll{
    public static void main(String args[])throws IOException{
        DataInputStream ds = new DataInputStream(System.in);
//        System.out.println("Enter id whose record is to be fetched");
//        String eno = ds.readLine();
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","coding1234");
            Statement stmt= con.createStatement();
            String q1 = "select * from Booking";
            ResultSet rs = stmt.executeQuery(q1);
//            List<Event> events = eventDAO.getAllEvents();
//            while(rs.next()){
//                System.out.println("The no is "+rs.getString(1));
//                System.out.println("The name is "+rs.getString(2));
//                System.out.println("The contact no is "+rs.getString(3));
//            }
            con.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
