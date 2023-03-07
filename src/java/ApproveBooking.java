import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class ApproveBooking extends HttpServlet{
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
        res.setContentType("text/html");
        PrintWriter pw1 = res.getWriter();
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","coding1234");
            Statement stmt = con.createStatement();
            String s1 = "select * from Booking";
//            pw1.println(s1);
            ResultSet rs = stmt.executeQuery(s1);
            if(rs.next()){
                pw1.println("Success");
                pw1.println("<div class=\"container\">\n" +
"		<h1>Event Approval</h1>\n" +
"		<p>Please review the following event details and approve or reject the event:</p>\n" +
"\n" +
"		<table>\n" +
"			<tr>\n" +
"				<td><b>Event Name:</b></td>\n" +
"				<td>"+rs.getString(1)+"</td>\n" +
"			</tr>\n" +
"			<tr>\n" +
"				<td><b>Date:</b></td>\n" +
"				<td>"+rs.getString(2)+"</td>\n" +
"			</tr>\n" +
"			<tr>\n" +
"				<td><b>Time:</b></td>\n" +
"				<td>"+rs.getString(3)+"</td>\n" +
"			</tr>\n" +
"			<tr>\n" +
"				<td><b>Location:</b></td>\n" +
"				<td>"+rs.getString(4)+"</td>\n" +
"			</tr>\n" +
"			<tr>\n" +
"				<td><b>Description:</b></td>\n" +
"				<td>"+rs.getString(5)+"</td>\n" +
"			</tr>\n" +
"                       <tr>\n" +
"				<td><b>Mobile No:</b></td>\n" +
"				<td>"+rs.getString(7)+"</td>\n" +
"			</tr>\n" +
"		</table>"
                        + "<form method=\"get\" action=\"Confirm\">\n" +
"                             <input type=\"hidden\" value=\""+rs.getString(7)+"\" name =\"number\">"+
"			<label for=\"approval\">Approve or Reject:</label>\n" +
"			<select name=\"approval\" id=\"approval\">\n" +
"				<option value=\"yes\">Approve</option>\n" +
"				<option value=\"no\">Reject</option>\n" +
"			</select>\n" +
"			<br><br>\n" +
"			<input type=\"submit\" value=\"Submit\">\n" +
"		</form>\n" +
"	</div>");
            }
            else{
                pw1.println("No Data");
            }
        }
        catch(Exception e){
            pw1.println(e);
        }
    }
}
