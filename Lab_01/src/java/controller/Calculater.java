package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author chinhoag
 */
public class Calculater extends HttpServlet {

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
        PrintWriter out = response.getWriter();

        String first = request.getParameter("num1");
        String second = request.getParameter("num2");
        String op = request.getParameter("option");
        String result = "";
        
        if(first == null || second == null){
            request.getRequestDispatcher("calculator.html").forward(request, response);
        }
        try {
            double f = Double.parseDouble(first);
            double s = Double.parseDouble(second);

            switch (op) {
                case "+":
                    result = f + s + "";
                    break;
                case "-":
                    result = f - s + "";
                    break;
                case "*":
                    result = f * s + "";
                    break;
                case ":":
                    result = f / s + "";
                    break;
            }
        } catch (NumberFormatException e) {
            result = "ERROR";
        }

        out.println("<form action = \"Calculater\" method=\"POST\">\n");
        out.println("<table>\n"
                + "                <tr>\n"
                + "                    <td>First:</td><td><input type=\"text\" name=\"num1\" value=" + first + "></td>\n"
                + "                </tr>\n"
                + "                <tr>\n"
                + "                    <td>Second:</td><td><input type=\"text\" name=\"num2\" value=" + second + "></td>\n"
                + "                </tr>\n"
                + "\n"
                + "                <tr>\n"
                + "                    <td>Operator:</td>   \n"
                + "                    <td>\n"
                + "                        <select name=\"option\">");
        out.println("<option value=\"+\">+</option>\n"
                + "                            <option value=\"-\">-</option>\n"
                + "                            <option value=\"*\">*</option>\n"
                + "                            <option value=\":\">:</option>");
        out.println("</select>\n"
                + "                        <br/>\n"
                + "                    </td>\n"
                + "                </tr>\n"
                + "                <tr>\n"
                + "                    <td></td><td><input type=\"submit\" value=\"Compute\"/></td>\n"
                + "                </tr>\n"
                + "                <tr>\n"
                + "                    <td>Result:</td><td><input type=\"text\" value=" + result + "></td>\n"
                + "                </tr>\n"
                + "            </table>");
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
        processRequest(request, response);
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
