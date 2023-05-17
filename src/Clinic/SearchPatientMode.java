/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clinic;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxEditor;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class SearchPatientMode extends AbstractListModel implements ComboBoxModel,KeyListener, ItemListener {
    ArrayList<String> db = new ArrayList<>();
    ArrayList<String> data = new ArrayList<String>();
    String selection;
    JComboBox cb;
    ComboBoxEditor cbe;
    int currPos = 0;
    private final ArrayList<Patient> all_patients;
    int type;//if 0 it wlll search by ID, if 1 search by name
 
    public SearchPatientMode(JComboBox jcb) {
 
        cb = jcb;
        cbe = jcb.getEditor();
        // here we add the key listener to the text field that the combobox is
        // wrapped around
        cbe.getEditorComponent().addKeyListener(this);
 
        // set up our "database" of items - in practice you will usuallu have a
        // proper db.    
        all_patients = new Repo().getAllpatients();
        for (int i = 0; i < all_patients.size(); i++) {
          String pt;
          pt= all_patients.get(i).getStudent_id();
          db.add(pt);
          pt = all_patients.get(i).getFull_name();
          db.add(pt);
        }
   
        this.type = type;
        
       
    }
 
    public void updateModel(String in) {
        data.clear();
        // lets find any items which start with the string the user typed, and
        // add it to the popup list
        // here you would usually get your items from a database, or some other
        // storage...
      
                for (int i = 0; i < db.size(); i++) {
                    if (db.get(i).contains(in)) {
                        data.add(db.get(i));
                    }}

        super.fireContentsChanged(this, 0, data.size());
 
        // this is a hack to get around redraw problems when changing the list
        // length of the displayed popups
        cb.hidePopup();
        cb.showPopup();
        if (data.size() != 0)
            cb.setSelectedIndex(0);
    }
 
    public int getSize() {
        return data.size();
    }
 
    public Object getElementAt(int index) {
        return data.get(index);
    }
 
    public void setSelectedItem(Object anItem) {
        selection = (String) anItem;
    }
 
    public Object getSelectedItem() {
        return selection;
    }
 
    public void keyTyped(KeyEvent e) {
    }
 
    public void keyPressed(KeyEvent e) {
    }
 
    public void keyReleased(KeyEvent e) {
        String str = cbe.getItem().toString();
        JTextField jtf = (JTextField) cbe.getEditorComponent();
        currPos = jtf.getCaretPosition();
 
        if (e.getKeyChar() == KeyEvent.CHAR_UNDEFINED) {
            if (e.getKeyCode() != KeyEvent.VK_ENTER) {
                cbe.setItem(str);
                jtf.setCaretPosition(currPos);
            }
        } else if (e.getKeyCode() == KeyEvent.VK_ENTER){
            cb.setSelectedIndex(cb.getSelectedIndex());
        } else {
            updateModel(cb.getEditor().getItem().toString());
            cbe.setItem(str);
            jtf.setCaretPosition(currPos);
        }
    }
 
    public void itemStateChanged(ItemEvent e) {
        cbe.setItem(e.getItem().toString());
        cb.setSelectedItem(e.getItem());
    }
 
}