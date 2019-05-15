package uk.ac.ucl.servlets;

import uk.ac.ucl.model.Model;
import uk.ac.ucl.model.ModelFactory;
import uk.ac.ucl.model.Patient;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * This servlet was split from the original search servlet in order
 * to display different statistics and content for this search.
 */

@WebServlet("/runSearchAge.html")
public class SearchAgeServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Model model = ModelFactory.getModel();

        List<Patient> searchResult = model.searchForAge(request.getParameter("searchAgeMin"),request.getParameter("searchAgeMax"));
        request.setAttribute("ageResult", searchResult);

        String oldest = model.getOldest(searchResult);
        request.setAttribute("oldest", oldest);

        String youngest = model.getYoungest(searchResult);
        request.setAttribute("youngest", youngest);

        String averageAge = model.getAverageAge(searchResult);
        request.setAttribute("averageAge", averageAge);

        String males = model.getMales(searchResult);
        request.setAttribute("males", males);

        String females = model.getFemales(searchResult);
        request.setAttribute("females", females);

        ServletContext context = getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/searchAgeResult.jsp");
        dispatch.forward(request, response);
    }
}