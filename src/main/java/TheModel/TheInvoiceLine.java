/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TheModel;

/**
 *
 * @author hp
 */
public class TheInvoiceLine {
    private int invoiceNum;
    private String name;
    private int count;
    private double price;

    public TheInvoiceLine(int invoiceNum, String name, int count, double price) {
        this.invoiceNum = invoiceNum;
        this.name = name;
        this.count = count;
        this.price = price;
    }
    
    public double grtLineTotal(){
        return price*count;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getInvoice() {
        return invoiceNum;
    }

    public void setInvoice(int invoiceNum) {
        this.invoiceNum = invoiceNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "TheInvoiceLine{" + "name=" + name + ", count=" + count + ", price=" + price + '}';
    }
    
    public double getTotal(){
        return count * price;
       
    }
}
