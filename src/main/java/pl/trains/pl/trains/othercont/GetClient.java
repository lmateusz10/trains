package pl.trains.pl.trains.othercont;

import pl.trains.model.Client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Mateusz on 14.03.2017.
 */
@WebServlet("/getclient")
public class GetClient extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @PersistenceUnit(name = "myPersistenceUnit")
    private EntityManagerFactory emf;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        long clientId = Long.parseLong(request.getParameter("clientId"));

        EntityManager em = emf.createEntityManager();
        Client client = em.find(Client.class, clientId);
        client.getOrders().size();
        String clientDesc = client.toString();
        em.close();

        response.getWriter().println(clientDesc);
    }
}
