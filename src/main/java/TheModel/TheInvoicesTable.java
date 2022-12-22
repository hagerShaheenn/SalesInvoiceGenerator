/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TheModel;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author hp
 */
public class TheInvoicesTable extends AbstractTableModel{
    private ArrayList<TheInvoiceHeader> invoices;  
    private String [] columns= {"No", "Date", "Customer","Total"};
    

    public TheInvoicesTable(ArrayList<TheInvoiceHeader> invoices) {
        this.invoices = invoices;
    }
    

    @Override
    public int getRowCount() {
        return invoices.size();
    }

    @Override
    public int getColumnCount() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        TheInvoiceHeader invoice= invoices.get(rowIndex);
       
        switch(columnIndex){
            case 0: return invoice.getNumber();
            case 1: return invoice.getDate();
            case 2: return invoice.getName();
            case 3: return invoice.getInvoiceTotal();
            default: return "";
            
                
        }
        
        
        }
}
