import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class check extends HttpServlet{
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
        res.setContentType("text/html");
        PrintWriter pw1 = res.getWriter();
        String num = req.getParameter("mob_no");
        
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
           Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","coding1234");
            Statement stmt = con.createStatement();
            String s1 = "select * from Booking where mob_no ='"+num+"' and stat = 'yes'";
//            pw1.println(s1);
            ResultSet rs = stmt.executeQuery(s1);
            if(rs.next()){
                pw1.println("<table>\n" +
"			<tr>\n" +
"				<td><b>Your event is approved</b></td>\n" +
"			</tr>\n" +
"			<tr>\n" +
"				<td><b>Event Name</b></td>\n" +
"				<td>"+rs.getString(1)+"</td>\n" +
"			</tr>\n" +
"			<tr>\n" +
"				<td><b>Price</b></td>\n" +
"				<td>Rs 2000</td>\n" +
"			</tr>\n" +
"			<tr>\n" +
"				<td><button><a href=\"Payment.html\"><b>Pay Now</b></button></td>\n" +
"			</tr>\n" +
"</table>");
            }
        }
        catch(Exception e){
            pw1.println(e);
        }
    }
}