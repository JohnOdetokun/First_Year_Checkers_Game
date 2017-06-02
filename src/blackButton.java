/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.awt.Color;
import javax.swing.*;
public class blackButton extends JButton
{
    private int pos;
   public blackButton(String title, int po)
   {
      super(title);
      pos = po;
      setBackground(Color.BLACK);
      ImageIcon blackI = new ImageIcon("blue.jpg");
      
      this.setIcon(blackI);
   }
   
    
   
   

}
