/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.awt.Color;
import javax.swing.*;
public class redButton extends JButton
{
    private int pos;
   public redButton(String title, int po)
   {
      super(title);
      pos = po;
      setBackground(Color.BLACK); 
      ImageIcon redI = new ImageIcon("red.jpg");
      this.setIcon(redI);
   }
   
    
   
   

}
