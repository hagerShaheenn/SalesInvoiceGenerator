
package TheModel;

import java.util.ArrayList;
import java.util.Date;

public class TheInvoiceHeader {
    private int number;
    private String name;
    private String date;
    private ArrayList<TheInvoiceLine> items;


    public TheInvoiceHeader(int number, String name, String date) {
        this.number = number;
        this.name = name;
        this.date = date;
    }
    public double getInvoiceTotal(){
        double total = 0.0;
        for(TheInvoiceLine line : getItems()){
            total+= line.grtLineTotal();
        }
        return total;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<TheInvoiceLine> getItems() {
        if(items == null){
            items = new ArrayList<>();
        }
        return items;
    }

    public void setItems(ArrayList<TheInvoiceLine> items) {
        this.items = items;
    }
    
    



    @Override
    public String toString() {
        return "TheInvoiceHeader{" + "number=" + number + ", name=" + name + ", date=" + date + ", items=" + items + '}';
    }

    public double getTotal(){
        double total = 0.0;
        
        for(TheInvoiceLine item: getItems()){
            total+= item.getTotal();
        }
        return total;
    }
    
    
}
