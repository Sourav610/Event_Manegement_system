import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import bean.*;
import java.sql.*;

public class Forgot extends HttpServlet{
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
        res.setContentType("text/Html");
        PrintWriter pw1 = res.getWriter();
        String email = req.getParameter("e1");
        try{
            HttpSession ses=req.getSession();
            //Establishing a session
            ses.setAttribute("n1",email);
        }
        catch(Exception e){
            pw1.println(e);
        }
        
        connection n = new connection();
        n.setEmail(email);
       
        boolean result = n.forgetFetch();
        if(result == true){
            pw1.println("<!DOCTYPE html>\n" +
"\n" +
"<html>\n" +
"    <head>\n" +
"        <meta charset=\"UTF-8\">\n" +
"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"    </head>\n" +
"    <body>\n" +
"        <form method=\"get\" action=\"Newpass\">\n" +
"            NewPassword: <input type=\"password\" value=\"\" name=\"np\">\n" +
"            <br>\n" +
"             Security_Question: \n" + n.getSq()+
"            <br>\n" +
"            Ans:<input type=\"text\" value=\"\" name=\"ans\">\n" +
"            <input type=\"submit\" value=\"submit\">\n" +
"        </form>\n" +
"            \n" +
"    </body>\n" +
"</html>\n" +
"");
        }
        else{
            pw1.println("Unsuccess");
        }
        
    }
}