import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import bean.*;

public class Newpass extends HttpServlet{
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
        res.setContentType("text/html");
        PrintWriter pw1 = res.getWriter();
        String npass = req.getParameter("np");
        String ans = req.getParameter("ans");
        
        connection ob = new connection();
        ob.setPass(npass);
        ob.setAns(ans);
        
        try{
            HttpSession ses=req.getSession();
            String s1= (String)ses.getAttribute("n1");
            ob.setEmail(s1);
        }
        catch(Exception e){
            pw1.println(e);
        }
        boolean n = ob.Check();
        if(n == true){
            pw1.println("Password Updated");
        }
        else{
            pw1.println("Password not updated");
        }
        
    }
}