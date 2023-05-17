/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Printer;


import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Jimma University
 */
public class PDFMerge {
 
    static void mergePdfFiles(ArrayList<InputStream> inputPdfList, FileOutputStream outputStream){
 
        try {
            //Create document and pdfReader objects.
            Document document = new Document();
            ArrayList<PdfReader> readers = new ArrayList<PdfReader>();
            int totalPages = 0;
            
            //Create pdf Iterator object using inputPdfList.
            Iterator<InputStream> pdfIterator = inputPdfList.iterator();
            
            // Create reader list for the input pdf files.
            while (pdfIterator.hasNext()) {
                try {
                    InputStream pdf = pdfIterator.next();
                    PdfReader pdfReader = new PdfReader(pdf);
                    readers.add(pdfReader);
                    totalPages = totalPages + pdfReader.getNumberOfPages();
                } catch (IOException ex) {
                    Logger.getLogger(PDFMerge.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "merge 1 Error...."+ex);
                }
            }
            
            // Create writer for the outputStream
            PdfWriter writer = PdfWriter.getInstance(document, outputStream);
            
            //Open document.
            document.open();
            document.setPageSize(PageSize.A6);
            //Contain the pdf data.
            PdfContentByte pageContentByte = writer.getDirectContent();
            
            PdfImportedPage pdfImportedPage;
            int currentPdfReaderPage = 1;
            Iterator<PdfReader> iteratorPDFReader = readers.iterator();
            
            // Iterate and process the reader list.
            while (iteratorPDFReader.hasNext()) {
                PdfReader pdfReader = iteratorPDFReader.next();
                //Create page and add content.
                while (currentPdfReaderPage <= pdfReader.getNumberOfPages()) {
                    document.newPage();
                    pdfImportedPage = writer.getImportedPage(
                            pdfReader,currentPdfReaderPage);
                    pageContentByte.addTemplate(pdfImportedPage, 0, 0);
                    currentPdfReaderPage++;
                }
                currentPdfReaderPage = 1;
            }
            
            //Close document and outputStream.
            outputStream.flush();
            document.close();
            outputStream.close();
            
            System.out.println("Pdf files merged successfully.");
        } catch (DocumentException ex) {
            Logger.getLogger(PDFMerge.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "merge 2 Error...."+ex);
        } catch (IOException ex) {
            Logger.getLogger(PDFMerge.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "merge 3 Error...."+ex);
        }
       }
 
	public void meargePDF(String path, String outputName){
	  try {
              File dir = new File(path);
	    //Prepare input pdf file list as list of input stream.
	    ArrayList<InputStream> inputPdfList = getPdfFiles(dir);
	    //Prepare output stream for merged pdf file.
            FileOutputStream outputStream = new FileOutputStream(outputName+".pdf");
 
            //call method to merge pdf files.
            mergePdfFiles(inputPdfList, outputStream);
	   } catch (Exception e) {
		e.printStackTrace();
                JOptionPane.showMessageDialog(null, "merge 4 Error...."+e);
	  }
	}
        
    public ArrayList<InputStream> getPdfFiles(File dir){
    ArrayList<InputStream> rtnFiles = new ArrayList<>();
        System.out.println("our dir  "+dir.getAbsolutePath());
    File[] files = dir.listFiles();
    for (File file : files) {
        
        if (file.isDirectory()) {
            rtnFiles.addAll(getPdfFiles(file));
            
        } else {
            if (file.getName().endsWith((".pdf"))) {
                FileInputStream stream = null;
                try {
                    stream = new FileInputStream(file);
                    rtnFiles.add(stream);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(PDFMerge.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, " merge getpdf ... Error...."+ex);
                } finally {
//                    try {
//                        stream.close();
//                    } catch (IOException ex) {
//                        Logger.getLogger(PDFMerge.class.getName()).log(Level.SEVERE, null, ex);
//                        JOptionPane.showMessageDialog(null, "merge getpdf close Error...."+ex);
//                    }
                }
            }
        }
    }

    return rtnFiles;
}
   
 

}