/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.time.LocalDate;
import java.util.List;
import javax.swing.SpringLayout;
import javax.swing.table.AbstractTableModel;
import model.Predmet;
import model.RokPredmet;

/**
 *
 * @author Andrej
 */
public class ModelTabeleOdrzavanja extends AbstractTableModel{

    List<RokPredmet> odrzavanja;
    String[] kolone = {"naziv","espb","datum odrzavanja"};
    
    public ModelTabeleOdrzavanja(List<RokPredmet> odrzavanja){
        this.odrzavanja = odrzavanja;
    }

    @Override
    public int getRowCount() {
        return odrzavanja.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        RokPredmet rp = odrzavanja.get(rowIndex);
        return switch(columnIndex){
        case 0->rp.getPredmet()!= null ? rp.getPredmet().getNaziv(): "";
        case 1->rp.getPredmet()!= null ? rp.getPredmet().getEspb(): "";
        case 2->rp.getDatum()!= null ? rp.getDatum(): "";
        default->"NA";
        };
    }
    
    public String getColumnName(int columnIndex){
        return kolone[columnIndex];
    }
    
    

    public List<RokPredmet> getOdrzavanja() {
        return odrzavanja;
    }

    public void setOdrzavanja(List<RokPredmet> odrzavanja) {
        this.odrzavanja = odrzavanja;
        fireTableDataChanged();
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex){
        
        RokPredmet odrzavanje = odrzavanja.get(rowIndex);
        if(odrzavanje.getPredmet() == null || odrzavanje.getDatum() == null){
            return true;
        }
        
        return false;
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex){
        
        RokPredmet rp = odrzavanja.get(rowIndex);
        
        
        switch(columnIndex){
        case 0: 
            rp.setPredmet((Predmet)aValue);
            break;
        case 2: 
            rp.setDatum(LocalDate.parse(String.valueOf(aValue)));
            break;
        }
        fireTableDataChanged();
    }
    
}
