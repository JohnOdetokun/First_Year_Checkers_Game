/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.awt.Color;
import javax.swing.JButton;

/**
 * John Odetokun
 * 
 * 
 */
public class redAvailableMoves extends JButton
{
    private int pos;
   public redAvailableMoves(String title, int po)
   {
      super(title);
      pos = po;
      setBackground(Color.RED);
       
   }
   
    
   
   
        
    

}
