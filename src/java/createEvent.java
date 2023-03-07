import bean.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;


public class createEvent extends HttpServlet{
    public void doGet (HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
        res.setContentType("text/html");
        PrintWriter pw1 = res.getWriter();
        
        String name = req.getParameter("name");
        String date = req.getParameter("date");
        String time = req.getParameter("time");
        String loc = req.getParameter("loc");
        String desc = req.getParameter("desc");
        String num = req.getParameter("num");
        String stat = "no";
        
        Booking ob = new Booking();
        ob.setName(name);
        ob.setDate(date);
        ob.setTime(time);
        ob.setLoc(loc);
        ob.setDesc(desc);
        ob.setStat(stat);
        ob.setNum(num);
        
        
        boolean re = ob.insert();
        if(re == true){
            pw1.println("Success");
        }
        else{
            pw1.println("unsuccess");
        }

//        try{
//            Class.forName("oracle.jdbc.driver.OracleDriver");
//            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localHost:1521:XE","system","coding1234");
//            Statement stmt = con.createStatement();
//            String q1 = "insert into Booking values('"+name+"','"+date+"','"+time+"','"+loc+"','"+desc+"','"+stat+"',"+num+")";
//            pw1.println(q1);
//            int x = stmt.executeUpdate(q1);
////            System.out.println(q1);
//            if(x>0){
//                pw1.println("success");
//            }
//            else{
//                pw1.println("unsuccess");
//            }
//        }
//        catch(Exception e){
//            pw1.println(e);
//        }
    }
}