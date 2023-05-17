/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Qrcode;

/**
 *
 * @author Jimma University
 */
import com.spire.barcode.BarCodeGenerator;
import com.spire.barcode.BarCodeType;
import com.spire.barcode.BarcodeSettings;
import com.spire.barcode.QRCodeECL;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GenerateQRCode {
    public  BufferedImage Generate(String text) throws IOException {
        //Instantiate a BarcodeSettings object
        BarcodeSettings settings = new BarcodeSettings();
        //Set barcode type
        settings.setType(BarCodeType.QR_Code);
        
        //Set barcode data
        String data = text;
        settings.setData(data);
        //Set barcode module width
        settings.setX((float) 0.5);
        //Set error correction level
        settings.setQRCodeECL(QRCodeECL.M);

        //Set text visibility
        settings.setShowText(false);
        settings.setShowTopText(true);
        settings.setShowBottomText(true);

        //Set border visibility
        settings.hasBorder(false);

        //Instantiate a BarCodeGenerator object based on the specific settings
        BarCodeGenerator barCodeGenerator = new BarCodeGenerator(settings);
        //Generate QR code image
        BufferedImage bufferedImage = barCodeGenerator.generateImage();
        
        //save the image to a .png file
        ImageIO.write(bufferedImage,"png",new File("QR_Code.png"));
        return bufferedImage;
    }
}
