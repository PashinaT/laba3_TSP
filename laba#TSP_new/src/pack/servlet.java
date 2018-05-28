package pack;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/result.html")
public class servlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        toFind(req,resp);

    }
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        toFind(req,resp);

    }

    public void toFind(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException
    {
        resp.setContentType("text/html; charset=UTF-8");// Устанавливает тип содержимого ответа,
        // отправляемого клиенту, если ответ еще не зафиксирован
        HttpSession session = req.getSession();//возвращают текущий сеанс, связанный с этим запросом
        Task task = (Task) session.getAttribute("task");//используется только для использования на
        // стороне сервера - вы заполняете запрос атрибутами, которые вы можете использовать в рамках
        // одного запроса.
        String str1=task.getA();
        String str2=task.getB();


        int k=0;
        int w=0;
        int i=0;
        while(i < str1.length())
        {
            w=str1.indexOf(str2, w);
            if(w != -1)
            {
                k++;
                i++;
                w=w+1;
            }
            else
                break;

        }
        if (task != null) {
            task.setResult(k);
        }
        session.setAttribute("task", task);
        req.getRequestDispatcher("/result.jsp").forward(req, resp);//передача запроса
        // /управления другому ресурсу на сервере
    }


}
