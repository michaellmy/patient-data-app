package uk.ac.ucl.servlets;

import org.apache.jasper.tagplugins.jstl.core.Out;
import uk.ac.ucl.model.Model;
import uk.ac.ucl.model.ModelFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.nio.file.Paths;

@WebServlet("/upload")
@MultipartConfig
public class UploadServlet extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Model model = ModelFactory.getModel();
        Part filePart = request.getPart("file");

        InputStream fileContent = filePart.getInputStream();
        String thebytes = convertStreamtoString(fileContent);
        OutputStream mywriter = new FileOutputStream("thisfile.csv");
        mywriter.write(thebytes.getBytes());
        model.readFile(new File("thisfile.csv"));
        mywriter.close();
        response.sendRedirect("/patientList.html");
    }

    public String convertStreamtoString(InputStream is) throws IOException
    {
        String csvData = new String();
        int data = is.read();
        while(data!=-1){
            char achar = (char)data;
            csvData += achar;
            data = is.read();
        }
        is.close();
        return csvData;
    }
}
