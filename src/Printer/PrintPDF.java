/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Printer;

/**
 *
 * @author Jimma University
 */
import java.awt.print.PrinterException;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.commons.io.FileUtils;
import org.apache.pdfbox.pdmodel.PDDocument;

public class PrintPDF {

    public void print(String path, File dir) {
        try {
            PDDocument pdf = PDDocument.load(path);
            pdf.print();

            FileUtils.cleanDirectory(dir);
        } catch (IOException ex) {
            Logger.getLogger(PrintPDF.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error...." + ex);
        } catch (PrinterException ex) {
            Logger.getLogger(PrintPDF.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error...." + ex);
        }
    }

//    public void remove(String filename) throws IOException {
//        File file = new File(filename);
//
//        FileUtils.cleanDirectory(file);
//        if (file.delete()) {
//            System.out.println("File deleted successfully");
//        } else {
//            System.out.println("Failed to delete the file");
//        }
//    }
}
