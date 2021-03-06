package mk.ukim.finki.wp.lab.web.servlet;

import mk.ukim.finki.wp.lab.model.Order;
import mk.ukim.finki.wp.lab.service.OrderService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@CrossOrigin(origins = "http://localhost:3000")
@WebServlet(name = "ConfirmationInfoServlet",urlPatterns = "/ConfirmationInfo.do")
public class ConfirmationInfo extends HttpServlet {
    private final SpringTemplateEngine springTemplateEngine;
    private final OrderService orderService;

    public ConfirmationInfo(SpringTemplateEngine springTemplateEngine, OrderService orderService) {
        this.springTemplateEngine = springTemplateEngine;
        this.orderService = orderService;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();

        WebContext webContext = new WebContext(request, response, request.getServletContext());
        webContext.setVariable("name",session.getAttribute("name"));
        webContext.setVariable("address",session.getAttribute("address"));
        webContext.setVariable("ip",request.getRemoteAddr());
        webContext.setVariable("browser",request.getHeader("User-Agent"));
        webContext.setVariable("pizzaType",session.getAttribute("pizzaType"));
        webContext.setVariable("pizzaSize",session.getAttribute("pizzaSize"));
        Order order=orderService.placeOrder((String)session.getAttribute("pizzaType"),
                                (String)session.getAttribute("name"),
                                (String)session.getAttribute("address"),
                (String)session.getAttribute("pizza_size"));

        Order order1 = (Order) session.getAttribute("orderObject");
        order1.setOrderId(order.getOrderId());
        order1.setTimeOrdered(order.getTimeOrdered());

        webContext.setVariable("ID",order.getOrderId());
        this.springTemplateEngine.process("confirmationInfo.html", webContext, response.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.invalidate();
        resp.sendRedirect("");
    }
}
