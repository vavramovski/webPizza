package mk.ukim.finki.wp.lab.web.servlet;

import mk.ukim.finki.wp.lab.model.Order;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "SelectPizzaServlet",urlPatterns = "/selectPizzaSize.html")
public class PizzaSize extends HttpServlet {
    private final SpringTemplateEngine springTemplateEngine;


    public PizzaSize(SpringTemplateEngine springTemplateEngine) {
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        WebContext webContext = new WebContext(request, response, request.getServletContext());

        webContext.setVariable("pizzaName",session.getAttribute("pizzaType"));
        this.springTemplateEngine.process("selectPizzaSize.html", webContext, response.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        session.setAttribute("pizzaSize",req.getParameter("pizza_size"));
        Order order = (Order)session.getAttribute("orderObject");
        order.setPizzaSize(req.getParameter("pizza_size"));

        resp.sendRedirect("/PizzaOrder.do");
    }
}
