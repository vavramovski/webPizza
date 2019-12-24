package mk.ukim.finki.wp.lab.web.servlet;


import mk.ukim.finki.wp.lab.model.Order;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;


@CrossOrigin(origins = "http://localhost:3000")
@WebServlet(name = "PizzaOrderServlet",urlPatterns = "/PizzaOrder.do")
public class PizzaOrder extends HttpServlet {
    private final SpringTemplateEngine springTemplateEngine;


    public PizzaOrder(SpringTemplateEngine springTemplateEngine) {
        this.springTemplateEngine = springTemplateEngine;
    }



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        WebContext webContext = new WebContext(request, response, request.getServletContext());
        webContext.setVariable("pizzaType",session.getAttribute("pizzaType"));
        webContext.setVariable("pizzaSize",session.getAttribute("pizzaSize"));
        this.springTemplateEngine.process("deliveryInfo.html", webContext, response.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.setAttribute("name",req.getParameter("clientName"));
        session.setAttribute("address",req.getParameter("clientAddress"));
        Order order = (Order)session.getAttribute("orderObject");
        order.setClientName(req.getParameter("clientName"));
        order.setClientAddress(req.getParameter("clientAddress"));
        resp.sendRedirect("ConfirmationInfo.do");
    }
}