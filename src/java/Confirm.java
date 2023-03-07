import java.io.*;
import java.sql.*;
import javax.servlet.*; //for getting the geneticServlet class
import javax.servlet.http.*; //for getting the HttpServlet class

public class Confirm extends HttpServlet{
    public void doGet(HttpServletRequest req, HttpServletResponse res)throws IOException,ServletException
    {
        res.setContentType("text/html");
        PrintWriter pw1=res.getWriter();
        String aprv = req.getParameter("approval");
        String num = req.getParameter("number");
        
         try{
            Class.forName("oracle.jdbc.driver.OracleDriver"); //technical term for typhod driver
            //registering type4 driver of oracle
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","coding1234");
            Statement stmt = con.createStatement();
            String q1 = "update Booking set stat ='"+aprv+"' where mob_no = '"+num+"'";
            pw1.println(q1);
            ResultSet rs = stmt.executeQuery(q1);
            if(rs.next()){
                pw1.println("Approved");
            }
            else{
                pw1.println("Not Approved");
            }
            con.close();
        }
        catch(Exception e){
            pw1.println(e);
        }
    }
}
        