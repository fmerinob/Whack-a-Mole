package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class cotizacion_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Sistema de Cotización de Seguros de Auto</h1>\n");
      out.write("        ");

            int modelo = 0, valor = 0;
            String nombre = request.getParameter("nombre"), apellidos = request.getParameter("apellidos"), genero = request.getParameter("genero"), estado = request.getParameter("estado"), edad = request.getParameter("edad");
            if(nombre!=null && apellidos!=null){
                out.println("<p>Estimado " + nombre + " " + apellidos + "</p>");
            }
            else{
                out.println("<p>Nombre Desconocido" + "</p>");
            }
            out.println("<p>En funcion a los datos proporcionados " + "</p>");
            if(genero!=null){
                out.println("<p>Género: " + genero + "</p>");
            }
            else{
                out.println("<p>Género Desconocido" + "</p>");
            }
            if(edad!=null){
                out.println("<p>Edad: " + edad + "</p>");
            }
            else{
                out.println("<p>Edad Desconocida" + "</p>");
            }
            if(estado!=null){
                out.println("<p>Estado: " + estado + "</p>");
            }
            else{
                out.println("<p>Estado Desconocido" + "</p>");
            }
            if(request.getParameter("marca")!=null){
                out.println("<p>Marca: " + request.getParameter("marca")+ "</p>");
            }
            else{
                out.println("<p>Marca Desconocida" +"</p>");
            }
            if(request.getParameter("modelo")!=null){
                out.println("<p>Modelo: " + request.getParameter("modelo")+"</p>");
                modelo = Integer.parseInt(request.getParameter("modelo"));
                if(modelo <=2000){
                    valor = 4200;
                }
                else{
                    valor = 7800;
                }
            }
            else{
                out.println("<p>Modelo Desconocido" +"</p>");
                valor = 0;
            }
            if(request.getParameter("placas")!=null){
                out.println("<p>Placas: " + request.getParameter("placas")+"</p>");
            }
            else{
                out.println("<p>Placas Desconocidas" +"</p>");
            }
            out.println("<p>La cotización de su seguro es: " +"</p>");
            out.println("<p>"+"</p>");
            out.println("<p>"+ valor +"</p>");
        
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
