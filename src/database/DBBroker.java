/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.Predmet;
import model.Rok;
import model.RokPredmet;

/**
 *
 * @author Andrej
 */
public class DBBroker {

    public List<Rok> ucitajRokove() {
        String upit ="select * from rok";
        List<Rok> rokovi = new ArrayList<>();
        
        try{
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while(rs.next()){
                int id = rs.getInt("id");
                String naziv = rs.getString("naziv");
                LocalDate datumPocetka = rs.getDate("datum_pocetka").toLocalDate();
                LocalDate datumZavrsetka = rs.getDate("datum_zavrsetka").toLocalDate();
                
                Rok r = new Rok(id,naziv,datumPocetka,datumZavrsetka);
                rokovi.add(r);
            }
                 
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return rokovi;
    }

    public List<RokPredmet> ucitajPredmete(Rok rok) {
        String upit ="select * from predmet p join rok_predmet rp on p.id = rp.id_predmet where rp.id_rok = ? order by rp.datum asc";
        List<RokPredmet> odrzavanja = new ArrayList<>();
        
        try{
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);
            ps.setInt(1, rok.getId());
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int id = rs.getInt("p.id");
                String naziv = rs.getString("p.naziv");
                int espb = rs.getInt("p.espb");
                Predmet p = new Predmet(id,naziv,espb);
                
                                
                LocalDate datum = rs.getDate("rp.datum").toLocalDate();
                RokPredmet rp = new RokPredmet(rok, p, datum);
                odrzavanja.add(rp);
                
            }
                 
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return odrzavanja;
    }

    public List<Predmet> ucitajPredmet() {
        String upit ="select * from predmet";
        List<Predmet> predmeti = new ArrayList<>();
        
        try{
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while(rs.next()){
                int id = rs.getInt("id");
                String naziv = rs.getString("naziv");
                int espb = rs.getInt("espb");
                
                Predmet p = new Predmet(id,naziv,espb);
                predmeti.add(p);
            }
                 
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return predmeti;
    }

    public boolean unesiOdrzavanje(RokPredmet rp) {
        
        String upit = "insert into rok_predmet (id_rok,id_predmet,datum) values(?,?,?)";
        try{
            System.out.println(rp);
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);
            ps.setInt(1, rp.getRok().getId());
            ps.setInt(2, rp.getPredmet().getId());
            ps.setDate(3, Date.valueOf(rp.getDatum()));
            
            int ar = ps.executeUpdate();
            Konekcija.getInstance().getConnection().commit();
            return ar > 0;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public void obrisiOdrzavanje(RokPredmet rp) {
        String upit = "delete from rok_predmet where id_predmet = "+rp.getPredmet().getId();
        
        try{
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            st.executeUpdate(upit);
            Konekcija.getInstance().getConnection().commit();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
