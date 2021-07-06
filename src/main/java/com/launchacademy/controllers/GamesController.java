package com.launchacademy.controllers;

import com.launchacademy.models.Game;
import com.launchacademy.services.*;

import java.io.IOException;
import java.util.*;
import javax.persistence.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/games/new", "/games"})
public class GamesController extends HttpServlet {

  @Override
  protected void doGet(
      HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    if (req.getServletPath().equals("/games/new")) {
      //add logic to direct to new form to prompt for information
      RequestDispatcher dispatcher = req.getRequestDispatcher("/views/games/new.jsp");
      dispatcher.forward(req, resp);
    }
    else if(req.getServletPath().equals("/games")) {
      //add show logic to see list of completed games
      //retrieve games from db then forward to the view
      System.out.println("Got to the get for /games");
      EntityManager em = getEmf().createEntityManager();

      GamesService gamesService = new GamesService(em);
      List<Game> listOfGames = gamesService.findAll();

      req.setAttribute("games", listOfGames);

      em.close();

      RequestDispatcher dispatcher = req.getRequestDispatcher("/views/games/games.jsp");
      dispatcher.forward(req, resp);
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    if(req.getServletPath().equals("/games")){
      EntityManagerFactory emf = getEmf();

      EntityManager em = emf.createEntityManager();
      GamesService gamesService = new GamesService(em);
      boolean isSaved = gamesService.save(req.getParameterMap());

      em.close();

      if(isSaved){
        resp.sendRedirect("/games");
      }
      else{
        resp.sendRedirect("/games/new");
      }
    }
  }

  private EntityManagerFactory getEmf() {
    return (EntityManagerFactory)this.getServletContext().getAttribute("emf");
  }
}