package pl.trains.controller;

import pl.trains.dao.TrainDao;
import pl.trains.dao.TrainDaoImpl;
import pl.trains.model.Wagon;

import javax.inject.Inject;
import javax.persistence.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Mateusz on 28.02.2017.
 */
@WebServlet("/addwagon")
public class AddWagon extends HttpServlet {
    @Inject
    TrainDao trainDao;

    @PersistenceUnit(name = "myPersistenceUnit")
    private EntityManagerFactory entityManagerFactory;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        Wagon wagon = new Wagon();
        wagon.setMark(request.getParameter("mark"));
        wagon.setType(request.getParameter("type"));
        wagon.setOwner(request.getParameter("owner"));
        wagon.setProducer(request.getParameter("producer"));
        wagon.setSeatingAreas(request.getParameter("seatingareas"));
        wagon.setQuantity(request.getParameter("quantity"));

        trainDao.addWagon(wagon);
        response.sendRedirect(request.getContextPath());

    }

}