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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/runsearch.html")
public class SearchServlet extends HttpServlet
{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Model model = ModelFactory.getModel();
        List<Patient> searchResult;

        String keyword = request.getParameter("keyword");
        String type = request.getParameter("type");
        searchResult = model.searchForAny(keyword, type);

        String firsttype = request.getParameter("firsttype");
        String secondtype = request.getParameter("secondtype");
        String firstkey = request.getParameter("firstkey");
        String secondkey = request.getParameter("secondkey");
        //addAll can be used as other search categories will return empty lists.
        searchResult.addAll(model.searchMultiple(firsttype, secondtype, firstkey, secondkey));

        String alpha = request.getParameter("alpha");
        searchResult.addAll(model.searchForAlphabet(alpha));

        request.setAttribute("allResult", searchResult);

        ServletContext context = getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/searchResult.jsp");
        dispatch.forward(request, response);
    }
}