package pl.trains.controller;

import pl.trains.dao.TrainDao;
import pl.trains.model.Wagon;
import pl.trains.services.WagonsService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Mateusz on 16.03.2017.
 */
@WebServlet("/getwagons")
public class GetWagons extends HttpServlet{
    @Inject
    WagonsService wagonsService;
    @Override
    protected void doGet(HttpServletRequest request,  HttpServletResponse response) throws ServletException, IOException{
    List<Wagon> wagons=wagonsService.getAllWagons();
        for (Wagon wagon:wagons) {
            System.out.println(wagon);
        }
    }
    
    
}
