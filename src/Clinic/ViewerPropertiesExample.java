/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clinic;

/**
 *
 * @author yibe1
 */

 
 import java.util.ResourceBundle;
import javax.swing.JFrame;
import javax.swing.JPanel;
 
 /**
  * The <code>ViewerPropertiesExample</code> class is an example of how to use
  * <code>SwingController</code> and <code>SwingViewBuilder</code>
  * to build a PDF viewer component with support for configuration via the Properties
  * file.  A file specified at the command line is opened in a JFrame which contains
  * the viewer component.
  *
  * @since 4.0
  */
 public class ViewerPropertiesExample {
     public static void main(String[] args) {
         // Get a file from the command line to open
//         String filePath = args[0];
 
 // build a component controller
//         SwingController controller = new SwingController();
// 
// // Construct a PropertiesManager from the default properties file and default message bundle
//         PropertiesManager properties = new PropertiesManager(System.getProperties(),
//                         ResourceBundle.getBundle(PropertiesManager.DEFAULT_MESSAGE_BUNDLE));
// 
// // Change the value of a couple default viewer Properties.
// // Note: this should be done before the factory is initialized.
//         properties.setBoolean("application.showLocalStorageDialogs",
//                 Boolean.FALSE);
// 
//         SwingViewBuilder factory = new SwingViewBuilder(controller, properties);
// 
// // add interactive mouse link annotation support via callback
//         controller.getDocumentViewController().setAnnotationCallback(
//                 new org.icepdf.ri.common.MyAnnotationCallback(
//                         controller.getDocumentViewController()));
// 
//         JPanel viewerComponentPanel = factory.buildViewerPanel();
// 
//         JFrame applicationFrame = new JFrame();
//         applicationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         applicationFrame.getContentPane().add(viewerComponentPanel);
// 
// // Now that the GUI is all in place, we can try openning a PDF
//         controller.openDocument(filePath);
// 
// // show the component
//         applicationFrame.pack();
//         applicationFrame.setVisible(true);
     }
 }