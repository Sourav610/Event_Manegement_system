import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import bean.*;

public class Login extends HttpServlet{
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
        res.setContentType("text/Html");
        PrintWriter pw1 = res.getWriter();
        String email = req.getParameter("email");
        String pass = req.getParameter("pass");
        
        connection n = new connection();
        n.setEmail(email);
        n.setPass(pass);
       
        boolean result = n.fetch();
        if(result == true){
            pw1.println("success");
        }
        else{
            pw1.println("Unsuccess");
        }
        
    }
}