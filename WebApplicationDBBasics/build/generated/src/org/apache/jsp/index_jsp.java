package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.Connection;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>STAFF</h1>\n");
      out.write("        ");

            Class.forName("org.apache.derby.jdbc.ClientDriver");
                Connection con =
            DriverManager.getConnection("jdbc:derby://localhost:1527/MyDatabase","root","root"); 
            /* TODO output your page here. You may use following sample code. */
            Statement query = con.createStatement();
            
            if(request.getParameter("add")!=null){
                if(request.getParameter("id")!=null && request.getParameter("name")!=null && request.getParameter("balance")!=null ){
                    query.executeUpdate("INSERT INTO CUSTOMERS VALUES ("+request.getParameter("id")+", '"+request.getParameter("name")+"' ,"+request.getParameter("balance")+")");
                }
            }
            if(request.getParameter("update")!=null){
                if(request.getParameter("id")!=null && request.getParameter("name")!=null && request.getParameter("balance")!=null ){
                    query.executeUpdate("UPDATE CUSTOMERS SET NAME='"+request.getParameter("name")+"'WHERE ID="+request.getParameter("id"));
                }
            }
            if(request.getParameter("delete")!=null){
                if(request.getParameter("id")!=null){
                    query.executeUpdate("DELETE FROM CUSTOMERS where ID="+request.getParameter("id"));
                }
            }
            
            ResultSet rs = query.executeQuery("SELECT * FROM CUSTOMERS");
            
            
            while(rs.next()) {
                out.println(" Id: "+ rs.getInt("ID"));
                out.println(" Name: "+ rs.getString("NAME"));
                out.println(" Balance: "+ rs.getDouble("BALANCE")+"<br>");
            }
            //con.commit();
            con.close();
            
        
      out.write("\n");
      out.write("        <form action=\"index.jsp\">\n");
      out.write("            <h1>Add a record</h1>\n");
      out.write("            <table border=\"1\">\n");
      out.write("                <tbody>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>ID:</td>\n");
      out.write("                        <td><input type=\"text\" name=\"id\" value=\"\" /></td>\n");
      out.write("                        <td>NAME:</td>\n");
      out.write("                        <td><input type=\"text\" name=\"name\" value=\"\" /></td>\n");
      out.write("                        <td>BALANCE</td>\n");
      out.write("                        <td><input type=\"text\" name=\"balance\" value=\"\" /></td>\n");
      out.write("                    </tr>\n");
      out.write("                </tbody>\n");
      out.write("            </table>\n");
      out.write("            <input type=\"submit\" value=\"ok\" name=\"add\" />\n");
      out.write("        </form>\n");
      out.write("        \n");
      out.write("        <form action=\"index.jsp\">\n");
      out.write("            <h1>Delete a record</h1>\n");
      out.write("            <table border=\"1\">\n");
      out.write("                <tbody>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>ID:</td>\n");
      out.write("                        <td><input type=\"text\" name=\"id\" value=\"\" /></td>\n");
      out.write("                    </tr>\n");
      out.write("                </tbody>\n");
      out.write("            </table>\n");
      out.write("            <input type=\"submit\" value=\"ok\"name=\"delete\" />\n");
      out.write("        </form>\n");
      out.write("        \n");
      out.write("        <form action=\"index.jsp\">\n");
      out.write("            <h1>Update a record</h1>\n");
      out.write("            <table border=\"1\">\n");
      out.write("                <tbody>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>ID:</td>\n");
      out.write("                        <td><input type=\"text\" name=\"id\" value=\"\" /></td>\n");
      out.write("                        <td>NAME:</td>\n");
      out.write("                        <td><input type=\"text\" name=\"name\" value=\"\" /></td>\n");
      out.write("                        <td>BALANCE</td>\n");
      out.write("                        <td><input type=\"text\" name=\"balance\" value=\"\" /></td>\n");
      out.write("                    </tr>\n");
      out.write("                </tbody>\n");
      out.write("            </table>\n");
      out.write("            <input type=\"submit\" value=\"ok\" name=\"update\"/>\n");
      out.write("        </form>\n");
      out.write("    </body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
