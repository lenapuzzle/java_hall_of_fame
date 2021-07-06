package com.launchacademy.services;

import com.launchacademy.models.*;
import org.apache.commons.beanutils.*;

import javax.persistence.*;
import java.lang.reflect.*;
import java.util.*;

public class GamesService {

  private EntityManager em;

  public GamesService(EntityManager em) {
    this.em = em;
  }

  public boolean save(Map<String, String[]> gamesData) {

    Game game = new Game();
    try{
      BeanUtils.populate(game, gamesData);
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    }
    try {
      em.getTransaction().begin();
      em.persist(game);
      em.getTransaction().commit();
      System.out.println("Persist successful");

      return true;
    } catch (Exception e) {
      em.getTransaction().rollback();
      System.out.println("Persist failed");
      return false;
    }
  }

  public List<Game> findAll(){
    TypedQuery<Game> query = em.createQuery("SELECT g from Game g", Game.class);
    return query.getResultList();
  }
}
