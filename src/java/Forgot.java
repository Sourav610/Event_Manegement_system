import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import bean.*;

public class Forgot extends HttpServlet{
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
        res.setContentType("text/Html");
        PrintWriter pw1 = res.getWriter();
        String email = req.getParameter("email");
        
        connection n = new connection();
        n.setEmail(email);
       
        boolean result = n.forgetFetch();
        if(result == true){
            pw1.println("success");
        }
        else{
            pw1.println("Unsuccess");
        }
        
    }
}