/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Rok;

/**
 *
 * @author Andrej
 */
public class ModelTabeleRokovi extends AbstractTableModel{
    
    List<Rok> rokovi;
    String[] kolone = {"naziv","datum pocetka","datum zavrsetka"};
    
    public ModelTabeleRokovi(List<Rok> rokovi){
        this.rokovi = rokovi;
    }

    @Override
    public int getRowCount() {
        return rokovi.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Rok r = rokovi.get(rowIndex);
        return switch(columnIndex){
        case 0->r.getNaziv();
        case 1->r.getDatumPocetka();
        case 2->r.getDatumZavrsetka();
        default->"NA";
        };
    }
    
    public String getColumnName(int columnIndex){
        return kolone[columnIndex];
    }
    
}
