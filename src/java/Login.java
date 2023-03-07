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
            if(email == "admin1234@gmail.com"){
               res.sendRedirect("Admin.html");
            }
            else{
                res.sendRedirect("Home.html");
            }
        }
        else{
//            res.setContentType("text/html");
//            PrintWriter out = res.getWriter();
            pw1.println("<h1>Incorrect username or password</h1>");
        }
        
    }
}