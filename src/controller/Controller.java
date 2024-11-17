/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import database.DBBroker;
import java.sql.*;
import java.util.List;
import model.Predmet;
import model.Rok;
import model.RokPredmet;
/**
 *
 * @author Andrej
 */
public class Controller {
    
    private static Controller instance;
    private DBBroker dbb;
    
    public static Controller getInstance(){
        if(instance == null)
            instance = new Controller();
        return instance;
    }
    
    private Controller(){
        dbb = new DBBroker();
    }

    public List<Rok> ucitajRokove() {
        return dbb.ucitajRokove();
    }


    public List<RokPredmet> ucitajPredmete(Rok rok) {
        return dbb.ucitajPredmete(rok);
    }

    public List<Predmet> ucitajPredmet() {
        return dbb.ucitajPredmet();
    }

    public boolean unesiOdrzavanje(RokPredmet rp) {
        return dbb.unesiOdrzavanje(rp);
    }

    public void obrisiOdrzavanje(RokPredmet rp) {
        dbb.obrisiOdrzavanje(rp);
    }
}
