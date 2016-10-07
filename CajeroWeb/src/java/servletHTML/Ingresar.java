/*
 * New Ligths
 * Services info Web
 * Rubio Haro 
 */
package servletHTML;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rod
 */
public class Ingresar extends HttpServlet {

    Usuario user;
    String UserTag, Password;

    @Override
    public void doPost(HttpServletRequest peticion, HttpServletResponse respuesta) throws ServletException, IOException {
        user = new Usuario();
        UserTag = new String();
        Password = new String();
        UserTag = peticion.getParameter("Usuario");
        Password = peticion.getParameter("Pass");
        user.setNombre(UserTag);
        user.setPass(Password);
        if (validar()) {
            try (PrintWriter out = new PrintWriter(respuesta.getOutputStream())) {
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Resultado</title>");
                out.println("<link href=\"css/bootstrap.min.css\" rel=\"stylesheet\" type=\"text/css\">");
                out.println("<link href=\"css/Estilos.css\" rel=\"stylesheet\" type=\"text/css\"/>");
                out.println("</head>");
                out.println("<body>");
                out.println(""
                        + "<div class=\"container\">\n"
                        + "            <div class=\"row\">\n"
                        + "                <div class=\"col-md-6\">\n"
                        + "                    <div class=\"panel panel-default\">\n"
                        + "                        <div class=\"panel-heading\">\n"
                        + "                            Cuenta Bancaria de: " + user.getNombre() + "\n"
                        + "                        </div>\n"
                        + "                        <div class=\"panel-body\">\n"
                        + "                            <div class=\"form-group\">\n"
                        + "                                <form method=\"POST\" class=\"form-group\" action='Accionar'>\n"
                        + "                                    Ingresa una Cantidad"
                        + "                                    <input class=\"form-control\" type=\"number\" autocomplete=\"off\" name=\"Pass\" id=\"Pass\" placeholder=\"Cantidad ejemplo: 1000\" required/>$Pesos\n"
                        + "                                    <input class=\"form-control\" type=\"number\" style=\"display: none\" autocomplete=\"off\" name=\"Usuario\" id=\"Usuario\"/>\n"
                        + "                                    <br/>\n"
                        + "                                    <div class=\"text-center \"><input class=\"btn-success\" type=submit   value=\"Depositar\"/></div>\n "
                        + "                                    <br>"
                        + "                                    <div class=\"text-center \"><input class=\"btn-danger\" type=submit name=\"Submit\"   value=\"Retirar\"/></div>\n"
                        + "                                </form>\n"
                        + "                            </div>\n"
                        + "                        </div>\n"
                        + "                    </div>\n"
                        + "                </div>\n"
                        + "                <div class=\"col-md-6\">\n"
                        + "                    <div class=\"panel panel-default\">\n"
                        + "                        <div class=\"panel-heading\">\n"
                        + "                            INFORMACION DE TU CUENTA \n"
                        + "                        </div>\n"
                        + "                        <div class=\"panel-body\">\n"
                        + "                            <div class=\"form-group\">\n"                        
                        + "                                    <input class=\"form-control\" type=\"text\" disabled=\"on\" name=\"Usuario\" value=\"Tu saldo es: "+user.getSaldo()+"\" id=\"Usuario\" />\n"                        
                        + "                                    <br/>\n"
                        + "                            </div>\n"
                        + "                        </div>\n"
                        + "                    </div>\n"
                        + "                </div>\n"
                        + "            </div>\n"
                        + "\n"
                        + "        </div>"
                        + ""
                        + ""
                        + ">");
                out.println("</body>");
                out.println("</html>");
            }
        }
    }
    public boolean validar() {
        if (UserTag == null || UserTag.equals("") || Password == null || Password.equals("")) {
            return false;
        } else {
            return true;
        }
    }
}
