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
public class rkingPin extends JButton{
     private int pos;
   public rkingPin(String title, int po)
   {
      super(title);
      pos = po;
       
      ImageIcon redI = new ImageIcon("rking.jpg");
      this.setIcon(redI);
   }
}
