/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit.bestteam.pubster.presentationlayer;

import fit.bestteam.pubster.presentationlayer.rpcserver.JsonRpcContext;
import com.googlecode.jsonrpc4j.JsonRpcServer;
import fit.bestteam.pubster.interfaces.businesslayer.CustomerService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Base64;
import java.util.StringTokenizer;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Handles Customer API
 * @author illia
 */


//@DatabaseIdentityStoreDefinition(
//        dataSourceLookup = "java:app/pubsterNB",
//        callerQuery = "select password from public.customers where login = ? or email = ? or telephone = ?",
//        groupsQuery = "select 'customer'",
//        hashAlgorithm = Hasher.class)

//@BasicAuthenticationMechanismDefinition(realmName="Secured API")
//@DeclareRoles({"customer", "staff", "manager"})
@WebServlet(name = "CustomerServlet", urlPatterns = {"/customerapi"})
//@ServletSecurity(@HttpConstraint(rolesAllowed = "customer"))
public class CustomerServlet extends HttpServlet {

    @EJB
    private CustomerService m_customerService;
    
    private JsonRpcServer m_jsonRpcServer;
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Customer API</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Hi dude ^_^</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    public void init() throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.
        m_jsonRpcServer = new JsonRpcServer(this.m_customerService);
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");
        StringTokenizer st = new StringTokenizer(authHeader);
        String _username = null;
        if (st.hasMoreTokens()) {
            String basic = st.nextToken();

            if (basic.equalsIgnoreCase("Basic")) {
                String credentials = new String(Base64.getDecoder().decode(st.nextToken()), "UTF-8");
                int p = credentials.indexOf(":");
                if (p != -1) {
                    _username = credentials.substring(0, p).trim();
                } 
            }
        }
        if (_username == null) {
            processRequest(request, response);
            return;
        }
        JsonRpcContext.set(_username);
        m_jsonRpcServer.handle(request, response);
        JsonRpcContext.unset();
//        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
