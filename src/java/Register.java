import bean.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class Register extends HttpServlet{
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
        res.setContentType("text/html");
        PrintWriter pw1 = res.getWriter();
        String nm1 = req.getParameter("n1");
        String add = req.getParameter("n6");
        String cont = req.getParameter("n7");
        String email = req.getParameter("n2");
        String pass = req.getParameter("n3");
        String sq = req.getParameter("n4");
        String ans = req.getParameter("n5");
        
        connection ob=new connection();
        ob.setName(nm1);
        ob.setAdd(add);
        ob.setCont(cont);
        ob.setEmail(email);
        ob.setPass(pass);
        ob.setSq(sq);
        ob.setAns(ans);

        boolean result = ob.insert();
        if(result == true){
            res.sendRedirect("Login.html");
        }
        else{
            pw1.println("unsuccess");
        }
    }
}
