/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Printer;

import Qrcode.GenerateQRCode;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author Jimma University
 */
public class prescription_printer {

    ArrayList<String> ps;
    private Document pdfR;
    private PdfPTable my_table;
    private FileOutputStream outputStream;
    private final String dir;
    private final File file;
    private PdfPCell table_cell;
    java.sql.Date date;
    private String dest;

    public prescription_printer(ArrayList<String> ps) throws IOException {
        this.ps = ps;
        java.util.Date utilDate = new java.util.Date();
        date = new java.sql.Date(utilDate.getTime());
        dir = "All_Prescriptions\\";
        file = new File(dir);
        if (!file.exists()) {
            File dr = new File(dir);
            dr.mkdirs();
        }

    }

    public void printPs(String pharmacist) {
        for (int i = 0; i < ps.size(); i++) {
            try {
                System.out.println("ps........" + ps.get(i));
                String[] data = ps.get(i).split("@");
                String date = data[0];
                String id = data[1];
                String name = data[2];
                System.out.println("data 4  " + data[4]);
//                String tx = data[4].substring(0, data[4].indexOf('&'));

                String[] gross = data[4].split("\n");
                String drug = "";
                for (int j = 0; j < gross.length; j++) {
                    String[] det = gross[j].substring(gross[j].indexOf('&')).split("&");

                    String quant;
                    if (det[1].equals("tube")) {
                        quant = "";
                    } else {
                        quant = " #" + det[4] + " " + det[1];
                    }
                    String med = gross[j].substring(0, gross[j].indexOf('&')) + quant;

                    if (drug.equals("")) {
                        drug = med + "\n";
                    } else {
                        drug = drug + "\n" + med + "\n";
                    }
                }

                String clinician = data[3];
                System.out.println("data 1 " + data[1]);
                System.out.println("data 2 " + data[2]);
                String other_detail[] = data[4].substring(data[4].indexOf('&')).split("&");
                String unit = other_detail[1];
                double unit_price = Double.parseDouble(other_detail[2]);
                String ex_date = other_detail[3];
                int quantity = Integer.parseInt(other_detail[4]);
                String tax = other_detail[5];
                String profit = other_detail[6];

                pdfR = new Document();
                my_table = new PdfPTable(4);
                dest = dir + "\\" + id.replace('/', '_') + "_" + date + ".pdf";

                outputStream = new FileOutputStream(dest);
                PdfWriter.getInstance(pdfR, outputStream);
                pdfR.setPageSize(PageSize.A6);
                float m = 170 + pdfR.getPageSize().getWidth() / 2;//determines page margin
                pdfR.setMargins(m, m, 10, 10);

                float[] columnWidths = new float[]{25f, 50f, 20f, 20f};
                my_table.setWidths(columnWidths);

                pdfR.open();
                table_cell = null;

                Image img = Image.getInstance("Icons/julogo.png");
                table_cell = new PdfPCell(img);
                table_cell.setHorizontalAlignment(0);
//            table_cell.setColspan(4);
                table_cell.setPaddingBottom(5);
                table_cell.setBorder(Rectangle.NO_BORDER);
                my_table.addCell(table_cell);
//            my_table.completeRow();

                table_cell = new PdfPCell(new Phrase(new Chunk("Jimma University Student Health Center", FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD))));
                table_cell.setHorizontalAlignment(1);
                table_cell.setColspan(1);
                table_cell.setPaddingBottom(5);
                table_cell.setBorder(Rectangle.NO_BORDER);
                my_table.addCell(table_cell);

//                Image img2 = Image.getInstance("Icons/druglogo.png");
//                table_cell = new PdfPCell(img2);
//                table_cell.setHorizontalAlignment(0);
////            table_cell.setColspan(4);
//                table_cell.setPaddingBottom(1);
//                table_cell.setPaddingLeft(25);
//                table_cell.setBorder(Rectangle.NO_BORDER);
//                my_table.addCell(table_cell);
//                my_table.completeRow();
                BufferedImage bufferedImage = new GenerateQRCode().Generate(ps.get(i));
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ImageIO.write(bufferedImage, "png", baos);
                baos.flush();
                byte[] imageInByte = baos.toByteArray();
                baos.close();
                Image image = Image.getInstance(imageInByte);

                table_cell = new PdfPCell(image);
                table_cell.setHorizontalAlignment(1);
                table_cell.setColspan(2);
                table_cell.setPaddingBottom(1);
                table_cell.setBorder(Rectangle.NO_BORDER);
                my_table.addCell(table_cell);
                my_table.completeRow();

                table_cell = new PdfPCell(new Phrase(new Chunk("Prescription Format", FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD))));
                table_cell.setHorizontalAlignment(1);
                table_cell.setColspan(4);
                table_cell.setPaddingBottom(1);
                table_cell.setBorder(Rectangle.NO_BORDER);
                my_table.addCell(table_cell);
                my_table.completeRow();

                table_cell = new PdfPCell(new Phrase(new Chunk("MRN: " + id.toUpperCase(), FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD))));
                table_cell.setHorizontalAlignment(0);
                table_cell.setColspan(4);
                table_cell.setPaddingBottom(10);
                table_cell.setBorder(Rectangle.NO_BORDER);
                my_table.addCell(table_cell);
                my_table.completeRow();

                table_cell = new PdfPCell(new Phrase(new Chunk("Pt.Name: " + name, FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD))));
                table_cell.setHorizontalAlignment(0);
                table_cell.setColspan(4);
                table_cell.setPaddingBottom(10);
                table_cell.setBorder(Rectangle.NO_BORDER);
                my_table.addCell(table_cell);
                my_table.completeRow();

                table_cell = new PdfPCell(new Phrase(new Chunk("Sex:____  Age:____", FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD))));
                table_cell.setHorizontalAlignment(0);
                table_cell.setColspan(4);
                table_cell.setPaddingBottom(5);
                table_cell.setBorder(Rectangle.NO_BORDER);
                my_table.addCell(table_cell);
                my_table.completeRow();

                table_cell = new PdfPCell(new Phrase(new Chunk("Date: " + date, FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD))));
                table_cell.setHorizontalAlignment(0);
                table_cell.setColspan(4);
                table_cell.setPaddingBottom(10);
                table_cell.setBorder(Rectangle.NO_BORDER);
                my_table.addCell(table_cell);
                my_table.completeRow();

                table_cell = new PdfPCell(new Phrase(new Chunk("Rx: ", FontFactory.getFont(FontFactory.HELVETICA, 16, Font.BOLD))));
                table_cell.setHorizontalAlignment(0);
                table_cell.setColspan(4);
                table_cell.setPaddingBottom(5);
                table_cell.setBorder(Rectangle.NO_BORDER);
                my_table.addCell(table_cell);
                my_table.completeRow();

                table_cell = new PdfPCell(new Phrase(new Chunk(drug, FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL))));
                table_cell.setHorizontalAlignment(0);
                table_cell.setColspan(4);
                table_cell.setPaddingBottom(40);
                table_cell.setBorder(Rectangle.NO_BORDER);
                my_table.addCell(table_cell);
                my_table.completeRow();

                table_cell = new PdfPCell(new Phrase(new Chunk("Prescriber: " + clinician, FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD))));
                table_cell.setHorizontalAlignment(0);
                table_cell.setColspan(4);
//            table_cell.setPaddingBottom(25);
                table_cell.setBorder(Rectangle.NO_BORDER);
                my_table.addCell(table_cell);
                my_table.completeRow();

                table_cell = new PdfPCell(new Phrase(new Chunk("Pharmacist: " + pharmacist + ": Sign__________", FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD))));
                table_cell.setHorizontalAlignment(0);
                table_cell.setColspan(4);
//            table_cell.setPaddingBottom(25);
                table_cell.setBorder(Rectangle.NO_BORDER);
                my_table.addCell(table_cell);
                my_table.completeRow();

                pdfR.add(my_table);
                pdfR.close();
            } catch (BadElementException ex) {
                Logger.getLogger(prescription_printer.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "p_printer error 1: " + ex);
            } catch (IOException | DocumentException ex) {
                Logger.getLogger(prescription_printer.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "p_printer error 2 for file: " + dest + "\n" + ex);
            }
        }

        PDFMerge merger = new PDFMerge();
        merger.meargePDF(file.getAbsolutePath() + "/", "prescriptions");

        PrintPDF print = new PrintPDF();
        print.print("prescriptions.pdf", file);
    }

}
