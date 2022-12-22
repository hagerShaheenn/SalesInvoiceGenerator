package TheController;

import TheModel.TheInvoiceHeader;
import TheModel.TheInvoiceLine;
import TheModel.TheInvoicesTable;
import TheView.TheFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;

public class TheControllerr implements ActionListener {
    
    private TheFrame frame;

    public TheControllerr(TheFrame frame) {
        this.frame = frame;
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        System.out.println("welcome");

        switch (e.getActionCommand()) {

            case "Create New Voice":
                NewInvoice();
                break;

            case "Delete Invoice":
                deleteInvoice();
                break;

            case "save":
                saveItem();
                break;

            case "cancel":
                cancelItem();
                break;

            case "Load File":
                loadFile();
                break;

            case "Save File":
                saveFie();
                break;

        }

    }

    private void NewInvoice() {

    }

    private void deleteInvoice() {
    }

    private void saveItem() {
    }

    private void cancelItem() {
    }

    private void loadFile() {
        JFileChooser fc = new JFileChooser();
        try{
        int result = fc.showOpenDialog(frame);
        if(result == JFileChooser.APPROVE_OPTION){
            File headerFile = fc.getSelectedFile();
           Path headerPath = Paths.get(headerFile.getAbsolutePath());
           List<String> headerLines =Files.readAllLines(headerPath);
           System.out.println("invoices readed");
           ArrayList<TheInvoiceHeader> invoicesArray = new ArrayList<>();
           for(String headreLine : headerLines ){
               String [] headerParts = headreLine.split(",");
               int invoiceNum=Integer.parseInt( headerParts[0]);
               String invoiceDate = headerParts[1];
               String CustomerName = headerParts[2];
               TheInvoiceHeader invoice = new TheInvoiceHeader(invoiceNum, CustomerName,invoiceDate);
               invoicesArray.add(invoice);
           
               
           }
         result = fc.showOpenDialog(null);
         if(result==JFileChooser.APPROVE_OPTION){
            File lineFile = fc.getSelectedFile();
            Path linePath = Paths.get(lineFile.getAbsolutePath());
            List<String> lineLines = Files.readAllLines(linePath);
            for(String lineLine :lineLines){
                String lineParts[] = lineLine.split(",");
                int invoiceNum=Integer.parseInt( lineParts[0]); 
                String itemName = lineParts[1];
                double itemPrice = Double.parseDouble(lineParts[2]);
                int count =  Integer.parseInt(lineParts[3]);
                TheInvoiceHeader inv = null;
                for (TheInvoiceHeader invoice : invoicesArray){
                    if (invoice.getNumber()== invoiceNum){
                        inv=invoice;
                        break;
                    }
                }
                TheInvoiceLine line= new TheInvoiceLine(invoiceNum, itemName, count, itemPrice);
                inv.getItems().add(line);
                
            }
            
         
            
            
         } 
               frame.setInvoices(invoicesArray);
               TheInvoicesTable invoicesTableModel = new TheInvoicesTable(invoicesArray);
               frame.setInvoicesTableModel (invoicesTableModel);
               frame.getInvoiceTable().setModel(invoicesTableModel);
               frame.getInvoicesTableModel().fireTableDataChanged();
                         

        }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    private void saveFie() {
    }

}
