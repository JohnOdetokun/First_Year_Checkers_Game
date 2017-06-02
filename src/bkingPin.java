/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * John Odetokun
 * 
 * 
 */
public class bkingPin extends JButton{
     private int pos;
   public bkingPin(String title, int po)
   {
      super(title);
      pos = po;
       
      ImageIcon blackI = new ImageIcon("bking.jpg");
      this.setIcon(blackI);
      
   }
}
