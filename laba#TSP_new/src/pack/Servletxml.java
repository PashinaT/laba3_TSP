package pack;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servletxml", urlPatterns = {"/result.xml"})
public class Servletxml extends HttpServlet{

    protected void performTask(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/xml; charset=UTF-8");
        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession();
        Task task = (Task) session.getAttribute("task");
        if (task != null) {
            try {
                JAXBContext jaxbContext = JAXBContext.newInstance(Task.class);
                Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
                jaxbMarshaller.marshal(task, out);
            } catch (JAXBException e) {
                e.getMessage();
            }
            finally {
                out.close();
            }
        } else {
            task = new Task();
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        performTask(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        performTask(req, resp);
    }


}