package mk.ukim.finki.wp.lab.web.servlet;

import mk.ukim.finki.wp.lab.model.Order;
import mk.ukim.finki.wp.lab.model.Pizza;
import mk.ukim.finki.wp.lab.service.impl.OrderServiceImpl;
import mk.ukim.finki.wp.lab.service.impl.PizzaServiceImpl;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "ShowPizzaServlet", urlPatterns = "")
public class ShowPizza extends HttpServlet {
    private final SpringTemplateEngine springTemplateEngine;

    private final PizzaServiceImpl pizzaService;
    private final OrderServiceImpl orderService;

    public ShowPizza(SpringTemplateEngine springTemplateEngine, PizzaServiceImpl pizzaService, OrderServiceImpl orderService) {
        this.springTemplateEngine = springTemplateEngine;
        this.pizzaService = pizzaService;
        this.orderService = orderService;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        WebContext webContext = new WebContext(request, response, request.getServletContext());

        if (session.getAttribute("searchID") != null) {
            long ID;
            try {
                ID = Long.parseLong((String) session.getAttribute("searchID"));
                Optional<Order> order = orderService.searchOrder(ID);
                if (order.isPresent()) {
                    webContext.setVariable("pizzaName", order.get().getPizzaType());
                    String timeRemaining = order.get().timeRemaining();
                    webContext.setVariable("timeRemaining", timeRemaining);
                }
            } catch (Exception e) {
                webContext.setVariable("search", "NOT AN ID");
            }
        }

        List<String> variables = new ArrayList<>();
        variables.add("pizza1");
        variables.add("pizza2");
        variables.add("pizza3");
        variables.add("pizza4");
        variables.add("pizza5");
        variables.add("pizza6");
        variables.add("pizza7");
        variables.add("pizza8");
        variables.add("pizza9");
        variables.add("pizza10");

        List<Pizza> pizzas = pizzaService.getPizzas();
        for (
                int i = 0; i < variables.size(); i++) {
            webContext.setVariable(variables.get(i), pizzas.get(i));
        }

        this.springTemplateEngine.process("listPizzas.html", webContext, response.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (req.getParameter("searchID") != null) {
            session.setAttribute("searchID", req.getParameter("searchID"));
            doGet(req, resp);
        } else {
            String pizza = req.getParameter("pizza");
            session.setAttribute("pizzaType", pizza);
            Order newOrder = new Order();
            newOrder.setPizzaType(pizza);
            session.setAttribute("orderObject", newOrder);
            resp.sendRedirect("/selectPizzaSize.html");
        }
    }

}