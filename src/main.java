/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 * John Odetokun
 * 
 * 
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class main extends JFrame {
    private String pturn = "red";
    private int RED = 12;
    private int turn = 0;
    private int BLACK = 12;
    private JFrame mainP;
   private JPanel jp;
   private JButton [] all;
   private int acount = 0;
   private ArrayList <Integer> adds = new <Integer> ArrayList(); 
   private int poss = 0;
   private int jpos =0;
   private int jpos1 = 0;
   private int jpos2 =0;
   private int jpos3 = 0;
   JTextField t;
   JButton z;
   private int prevPos;
   private sound s;
   public main()
   {
        
        super(":) Checkers Game :)");
        prevPos = 0;
        this.jp = new JPanel();
        this.all = new JButton[64];
        this.mainP = new JFrame();
        mainP.getContentPane().setBackground(java.awt.Color.black);
        z = new JButton();
        t = new JTextField();
        try
        {
        s = new sound();
        }
        catch(Exception e)
        {
        }         
        t.setBackground(new java.awt.Color(0, 0, 0));
        t.setForeground(new java.awt.Color(255, 0, 0));
        t.setText("RED Starts");
        t.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 255, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(255, 255, 0), new java.awt.Color(0, 0, 0))));
        z.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
            });
   }
   
   public  void runn ()
   {
      main t = new main();
      t.initGrid();
   }
   
   
   public void update(JButton [] j , int len)
   {
       if(pturn.equals("red"))
       {
           t.setForeground(Color.red);
           t.setText("RED piece Move");
       }
       else
       {
           t.setForeground(Color.blue);
           t.setText("BLACK piece Move");
       }
       if(RED < 1)
       {
           JOptionPane.showMessageDialog(null, "BLACK TEAM WINS");
           Winner w = new Winner();
           w.who("black");
           this.setVisible(false);
           
       }
       else if (BLACK < 1)
       {
           JOptionPane.showMessageDialog(null, "RED TEAM WINS");
           Winner w = new Winner();
           w.who("red");
           this.setVisible(false);
           
       }
       else
       {
        
        jp.removeAll();
        for(int i = 0 ; i < len; i++)
        {
            jp.add(all[i]);
            
        }
        
        mainP.repaint();
        mainP.validate();
        
//        mainP.add(jp);
//        add(mainP);
        
       }
       
   }
   private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
       if(turn == 0)
       {
           turn = 1;
           pturn = "black";
       }
       else
       {
           turn =0;
           pturn = "red";
       }
       update(all,all.length);
    } 
   public void updateGrid(JButton [] j, int len)
   {
        mainP.getContentPane().setBackground(Color.RED);
        mainP.setVisible(true);
        mainP.setSize(800, 700);
       
        //setVisible(true);
        mainP.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jp.setLayout(new GridLayout(8,8));
        
        //this.setSize(600, 600);
        jp.setSize(550, 550);
        
        //mainP.setSize(600,600);
        
        for(int i = 0 ; i < len; i++)
        {
            jp.add(all[i]);
            
        }
        z.setBounds(100, 625, 220, 30);
        t.setBounds(320, 625, 220, 30);
        z.setText("END TURN");
        jp.setBounds(50,500,500,50);
        jp.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder( Color.BLACK, 40, true), new javax.swing.border.MatteBorder(null)));
        
        mainP.add(z);
        mainP.add(t);
        mainP.add(jp);
        
   }
   
   private void initGrid()
   {
      //rows
            for(int j = 0; j < 4 ; j++)
            {
               //red piece
               all[acount] = new redButton ("",acount);
               all[acount].addActionListener(new action(acount));
               acount++;
            
               //empty space
               all[acount] = new NormalButton();
               all[acount].addActionListener(new naction(acount));
               acount++;
               
            }   
            for(int y = 0; y <4; y++)
            {
               //empty space
               all[acount] = new NormalButton();
               all[acount].addActionListener(new naction(acount));
               acount++;
               //red piece
               all[acount] = new redButton ("", acount);
               all[acount].addActionListener(new action(acount));
               acount++;    
            }
            for(int q = 0; q < 4 ; q++)
            {
               //red piece
               all[acount] = new redButton ("", acount);
               all[acount].addActionListener(new action(acount));
               acount++;
            
               //empty space
               all[acount] = new NormalButton();
               all[acount].addActionListener(new naction(acount));
               acount++;
            }
            for (int a = 0 ; a <8; a++)
            {
            //8 spaces
            //empty space
               if(a % 2==0)
               {
                    all[acount] = new NormalButton ();
                    all[acount].addActionListener(new naction(acount));
                    acount++;
               }
               else
               {
                    all[acount] = new jsButton ();
                    all[acount].addActionListener(new jaction(acount));
                    acount++;
               }
            }
            for (int b = 0 ; b <8; b++)
            {
            //8 spaces
               //empty space
               if(b % 2 ==0)
               {
                    all[acount] = new jsButton ();
                    all[acount].setBackground(Color.black);
                    all[acount].addActionListener(new jaction(acount));
                    acount++;
               }
               else
               {
                    
                    all[acount] = new NormalButton ();
                    all[acount].addActionListener(new naction(acount));
                    acount++;
               }
            }
            
            for(int t = 0; t<4;t++)
            {  
               //empty space
                all[acount] = new NormalButton();
                all[acount].addActionListener(new naction(acount));
                acount++;
               //black piece
               all[acount] = new blackButton ("", acount);
               all[acount].addActionListener(new baction(acount));
               acount++;
            }
            for(int p = 0; p <4 ;p++)
            {
               //black piece
               all[acount] = new blackButton ("", acount);
               all[acount].addActionListener(new baction(acount));
               acount++;
               //empty space
                all[acount] = new NormalButton();
                all[acount].addActionListener(new naction(acount));
                 acount++;
            }
            for(int z = 0; z<4 ; z++)
            {  
               //empty space
                all[acount] = new NormalButton ();
                all[acount].addActionListener(new naction(acount));
                acount++;
               //black piece
               all[acount] = new blackButton ("", acount);
               all[acount].addActionListener(new baction(acount));
               acount++;
            }          
         
         updateGrid(all, acount);
         
   }//end initgrid

   private class jaction implements ActionListener 
   {
        private int position;
        public jaction(int pos) {
            position = pos;
        }
        @Override
        public void actionPerformed(ActionEvent x)
        {
            
        }
    }
  //NORMAL ACTION
   private class naction implements ActionListener 
   {
        private int position;
        public naction(int pos) {
            position = pos;
        }
        @Override
        public void actionPerformed(ActionEvent x)
        {
            JOptionPane.showMessageDialog(null, "No piece or move there, press OK and try again", "Sorry", JOptionPane.ERROR_MESSAGE);
        }
    }
    //RED BUTTON ACTION
    
    private class action implements ActionListener {
    private final int position;    
        
        public action(int pos) {
            position = pos;
        }
        @Override
        public void actionPerformed(ActionEvent d)
        {
            if(position != prevPos)
            {
                
                prevPos = position;
            if(all[position].getClass().getName().contains("redButton") && turn == 0)
            {
                String mo = "";
                if(adds.size() > 0 )
                {
                    
                    adds.remove(0);
                }
                
                cleareMoves();
                boolean space = false;
                if(position %8 == 0 && position < 55)
                {
                    if(!mo.contains("0") && all[position+9].getClass().getName().contains("jsButton"))
                    {
                        
                        all[position+9] = new redAvailableMoves("", position+9);
                        all[position+9].addActionListener(new action(position+9));
                        adds.add(position+9);
                        mo += "0";
                        space =true;
                    }   
                }
                else if ((position+1) %8 == 0 && position < 55)
                {
                    if(!mo.contains("1") && all[position+7].getClass().getName().contains("jsButton"))
                    {
                        all[position+7] = new redAvailableMoves("", position+7);
                        all[position+7].addActionListener(new action(position+7));
                        adds.add(position+7);
                        mo += "1";
                        space = true;
                    }
                }
                else
                {
                    if(!mo.contains("0") && all[position+9].getClass().getName().contains("jsButton"))
                    {
                        
                        all[position+9] = new redAvailableMoves("", position+9);
                        all[position+9].addActionListener(new action(position+9));
                        adds.add(position+9);
                        mo += "0";
                        space =true;
                    }
                    if(!mo.contains("1") && all[position+7].getClass().getName().contains("jsButton"))
                    {
                        
                        all[position+7] = new redAvailableMoves("", position+7);
                        all[position+7].addActionListener(new action(position+7));
                        adds.add(position+7);
                        mo += "1";
                        space = true;
                    }
                }
                //JUMPS
                if ((position) %8 == 0 || (position-1) %8 == 0)
                {
                    // Jump move
                    if (position < 48)
                    {
                        if(!mo.contains("0") && (all[position+9].getClass().getName().contains("blackButton") ||all[position+9].getClass().getName().contains("bkingPin")) && all[position+18].getClass().getName().contains("jsButton"))
                        {
                            
                            all[position+18] = new redAvailableMoves("", position+18);
                            all[position+18].addActionListener(new action(position+18));
                            jpos = position+9;
                            mo += "0";
                            adds.add(position+18);
                            space = true;
                        }
                        
                    }
                }
                else if (((position+1) %8 == 0 || (position+2) %8 == 0) && position < 46)
                {
                    if(!mo.contains("1") && position < 48 && (all[position+7].getClass().getName().contains("blackButton")||all[position+7].getClass().getName().contains("bkingPin"))&& (all[position+14].getClass().getName().contains("jsButton")))
                    {
                        
                        all[position+14] = new redAvailableMoves("", position+14);
                        all[position+14].addActionListener(new action(position+14));
                        jpos1 = position+7;
                        mo += "1";
                        adds.add(position+14);
                        space = true;
                    }
                }
                else
                {
                    if(!mo.contains("0") && position < 48 && (all[position+9].getClass().getName().contains("blackButton")||all[position+9].getClass().getName().contains("bkingPin")) && (all[position+18].getClass().getName().contains("jsButton")))
                    {
                        all[position+18] = new redAvailableMoves("", position+18);
                        all[position+18].addActionListener(new action(position+18));
                        jpos = position+9;
                        mo += "0";
                        adds.add(position+18);
                        space = true;
                    }
                    
                    if(!mo.contains("1") && position < 48 && (all[position+7].getClass().getName().contains("blackButton")||all[position+7].getClass().getName().contains("bkingPin"))&& (all[position+14].getClass().getName().contains("jsButton")))
                    {
                        all[position+14] = new redAvailableMoves("", position+14);
                        all[position+14].addActionListener(new action(position+14));
                        jpos1 = position+7;
                        mo += "1";
                        adds.add(position+14);
                        space = true;
                    }
                }
                if (space == true)
                    {
                        poss = position;
                    }
            }//end IF REDBUTTON

            else if(all[position].getClass().getName().contains("redAvailableMoves") && turn == 0)
            {
                s.play("SoundsCrate-MediumWhooshNoBuild");
                if(adds.size() > 0)
                {
                    adds.remove(new Integer(position));
                }
                if(jpos !=0 && Math.abs(position - poss) > 9 && (position - jpos) == (jpos - poss) )
                {
                    BLACK --;
                    all[position] = all[poss];
                    all[position].addActionListener(new action(position));
                    all[jpos] = new jsButton();
                    all[jpos].addActionListener(new jaction(jpos));
                    jpos1 = 0;
                    jpos = 0;
                    all[poss] = new jsButton();
                    all[poss].addActionListener(new jaction(poss));
                }
                else if(jpos1 !=0 && Math.abs(position - poss) > 9 && (position - jpos1) == (jpos1 - poss))
                {
                    BLACK --;
                    all[position] = all[poss];
                    all[position].addActionListener(new action(position));
                    all[jpos1] = new jsButton();
                    all[jpos].addActionListener(new jaction(jpos));
                    jpos1 = 0;
                    jpos = 0;
                    all[poss] = new jsButton();
                    all[poss].addActionListener(new jaction(poss));
                    
                }
                else
                {
                    all[position] = all[poss];
                    all[position].addActionListener(new action(position));
                    all[poss] = new jsButton();
                    all[poss].addActionListener(new jaction(poss));
                    turn = 1;
                    pturn = "black";
                    
                }
                
                if(position > 55)
                {
                    all[position] = new rkingPin("", position);
                    all[position].addActionListener(new rkAction(position));
                    turn = 1;
                    pturn = "black";
                    
                }
              
                cleareMoves();
                 
            }//end redAvailableMoves
            
            }
            update(all, 64);
            
        }
    }
    
    //BLACK BUTTON ACTION
    private class baction implements ActionListener {
        private final int position;
        public baction(int pos) {
            position = pos;
        }
        @Override
        public void actionPerformed(ActionEvent u)
        {
            if(position != prevPos)
            {
                
                prevPos = position;
            String mo = "";
            if(!adds.isEmpty() )
                {
                    adds.remove(0);
                }
           if(all[position].getClass().getName().contains("blackButton") && turn == 1)
            {
                jpos = 0;
                cleareMoves();
                boolean space = false;
                //NORMAL MOVES
                if(position > 8 && (position %8 == 0))
                {
                    if(!mo.contains("1") && (all[position-7].getClass().getName().contains("jsButton")))
                    {
                        
                        mo += "1";
                        all[position-7] = new blackAvailableMoves("", position-7);
                        all[position-7].addActionListener(new baction(position-7));
                        adds.add(position -7);
                        space =true;
                    }
                }
                else if (position >8 && ((position+1) % 8 == 0))
                {
                    if(!mo.contains("0")&& (all[position-9].getClass().getName().contains("jsButton")))
                    {
                        
                        all[position-9] = new blackAvailableMoves("", position-9);
                        all[position-9].addActionListener(new baction(position-9));
                        adds.add(position -9) ;
                        mo+="0";
                        space =true;
                    }
                }
                else
                {
                    if(!mo.contains("1") && (all[position-7].getClass().getName().contains("jsButton")))
                    {
                        mo += "1";
                        all[position-7] = new blackAvailableMoves("", position-7);
                        all[position-7].addActionListener(new baction(position-7));
                        adds.add(position -7);
                        space =true;
                    }
                    if(!mo.contains("0")&& (all[position-9].getClass().getName().contains("jsButton")))
                    {
                        all[position-9] = new blackAvailableMoves("", position-9);
                        all[position-9].addActionListener(new baction(position-9));
                        adds.add(position -9) ;
                        mo+="0";
                        space =true;
                    }
                }
                //JUMPS
                if (position %8 == 0 && (position-1) %8 == 0  )
                {
                    // Jump move
                    if(!mo.contains("1") && position > 15 && (all[position-14].getClass().getName().contains("jsButton")) && (all[position-7].getClass().getName().contains("redButton") || all[position-7].getClass().getName().contains("rkingPin")))
                    {
                        
                        mo += "1";
                        all[position-14] = new blackAvailableMoves("", position-14);
                        all[position-14].addActionListener(new baction(position-14));
                        jpos1 = position-7;
                        adds.add(position-14);
                        space = true;
                    }
                }
                else if ((position+2) %8 == 0 && (position+1) %8 == 0)
                {
                    if(!mo.contains("0") &&position > 17 && (all[position-18].getClass().getName().contains("jsButton")) && (all[position-9].getClass().getName().contains("redButton") || all[position-9].getClass().getName().contains("rkingPin")))
                    {
                        all[position-18] = new blackAvailableMoves("", position-18);
                        all[position-18].addActionListener(new baction(position-18));
                        jpos = position-9;
                        adds.add(position-18);
                        space = true;
                        mo += "0";
                    }
                }
                else
                {
                    if(!mo.contains("0") &&position > 17 && (all[position-18].getClass().getName().contains("jsButton")) && (all[position-9].getClass().getName().contains("redButton") || all[position-9].getClass().getName().contains("rkingPin")))
                    {
                        all[position-18] = new blackAvailableMoves("", position-18);
                        all[position-18].addActionListener(new baction(position-18));
                        jpos = position-9;
                        adds.add(position-18);
                        space = true;
                        mo += "0";
                    }
                    if(!mo.contains("1") && position > 15 && (all[position-14].getClass().getName().contains("jsButton")) && (all[position-7].getClass().getName().contains("redButton") || all[position-7].getClass().getName().contains("rkingPin")))
                    {
                        all[position-14] = new blackAvailableMoves("", position-14);
                        all[position-14].addActionListener(new baction(position-14));
                        jpos1 = position-7;
                        mo += "1";
                        adds.add(position-7);
                        space = true;
                    }
                }
                if (space == true)
                    {
                        poss = position;
                    }
                
            }//end IF BLACK BUTTON
                
            else if(all[position].getClass().getName().contains("blackAvailableMoves")&& turn == 1)
            {
                s.play("SoundsCrate-MediumWhooshNoBuild");
                adds.remove(new Integer(position));
                
                if(jpos != 0 && Math.abs(position - poss) > 9 && (position - jpos) == (jpos - poss))
                {
                    
                    RED --;
                    all[position] = all[poss];
                    all[position].addActionListener(new baction(position));
                    all[jpos] = new jsButton();
                    all[jpos].addActionListener(new jaction(jpos));
                    jpos = 0;
                    jpos1 = 0;
                    all[poss] = new jsButton();
                    all[poss].addActionListener(new jaction(poss));
                    
                }
                else if(jpos1 != 0 && Math.abs(position - poss) > 9 && (position - jpos1) == (jpos1 - poss))
                {
                    
                    RED --;
                    all[position] = all[poss];
                    all[position].addActionListener(new baction(position));
                    all[jpos1] = new jsButton();
                    all[jpos1].addActionListener(new jaction(jpos1));
                    jpos1 = 0;
                    jpos = 0;
                    all[poss] = new jsButton();
                    all[poss].addActionListener(new jaction(poss));
                    
                }
                else
                {
                    all[position] = all[poss];
                    all[position].addActionListener(new baction(position));
                    all[poss] = new jsButton();
                    all[poss].addActionListener(new jaction(poss));
                    turn = 0;
                    pturn = "red";
                    
                }
                
                if(position  < 8)
                {
                    all[position] = new bkingPin("", position);
                    all[position].addActionListener(new bkAction(position));
                    turn = 0;
                    pturn = "red";
                }
                  cleareMoves(); 
            }//end blackAvailableMoves
            }
            update(all, 64);
            
        }
    }
    
    
    //RED KING ACTION
    private class rkAction implements ActionListener {
        private final int position;
        public rkAction(int pos) {
            position = pos;
        }
        @Override
        public void actionPerformed(ActionEvent k)
        {
            if(position != prevPos)
            {
                prevPos = position;
            if (all[position].getClass().getName().contains("rkingPin") && turn == 0)
            {
                String mo = "";
                cleareMoves();
                
                boolean space = false;
                
                if(position %8 == 0)
                {                    
                    if(!mo.contains("1") && position < 55 && all[position+9].getClass().getName().contains("jsButton"))
                    {
                        all[position+9] = new rkMoves("", position+9);
                        all[position+9].addActionListener(new rkAction(position+9));
                        mo += "1";
                        space =true;
                    }
                    if(position >8 && !mo.contains("4") && all[position-9].getClass().getName().contains("jsButton"))
                    {
                        all[position-9] = new rkMoves("", position-9);
                        all[position-9].addActionListener(new rkAction(position-9));
                        mo += "4";
                        space =true;
                    }
                }
                else if((position+1) %8 == 0)
                {
                    if(!mo.contains("2") && position < 55 && all[position+7].getClass().getName().contains("jsButton"))
                    {
                        all[position+7] = new rkMoves("", position+7);
                        all[position+7].addActionListener(new rkAction(position+7));
                        mo+= "2";
                        space = true;
                    }
                    if(position > 8 && !mo.contains("5") && (all[position-7].getClass().getName().contains("jsButton")))
                    {
                        all[position-7] = new rkMoves("", position-7);
                        all[position-7].addActionListener(new rkAction(position-7));
                        mo += "5";
                        space =true;
                    }
                }
                else
                {
                    if(!mo.contains("1") && position < 55 && all[position+9].getClass().getName().contains("jsButton"))
                    {
                        all[position+9] = new rkMoves("", position+9);
                        all[position+9].addActionListener(new rkAction(position+9));
                        mo += "1";
                        space =true;
                    }
                    if(position >8 && !mo.contains("4") && (all[position-9].getClass().getName().contains("jsButton")))
                    {
                        all[position-9] = new rkMoves("", position-9);
                        all[position-9].addActionListener(new rkAction(position-9));
                        mo += "4";
                        space =true;
                    }
                    if(!mo.contains("2") && position < 55 && all[position+7].getClass().getName().contains("jsButton"))
                    {
                        all[position+7] = new rkMoves("", position+7);
                        all[position+7].addActionListener(new rkAction(position+7));
                        mo+= "2";
                        space = true;
                    }
                    if(position > 8 && !mo.contains("5") && (all[position-7].getClass().getName().contains("jsButton")))
                    {
                        all[position-7] = new rkMoves("", position-7);
                        all[position-7].addActionListener(new rkAction(position-7));
                        mo += "5";
                        space =true;
                    }
                }
                //JUMP
                if (position %8 == 0 || (position-1) %8 == 0)
                {
                    // Jump move
                    if (position < 48)
                    {
                        if(!mo.contains("3") && (all[position+9].getClass().getName().contains("blackButton") || all[position+9].getClass().getName().contains("bkingPin"))&& all[position+18].getClass().getName().contains("jsButton"))
                        {
                            all[position+18] = new rkMoves("", position+18);
                            all[position+18].addActionListener(new rkAction(position+18));
                            jpos = position+9;
                            mo += "3";
                            space = true;
                        }                       
                    }
                    if( !mo.contains("6") && position > 15 && (all[position-9].getClass().getName().contains("blackButton")|| all[position-9].getClass().getName().contains("bkingPin"))&& (all[position-18].getClass().getName().contains("jsButton")))
                    {
                        all[position-18] = new rkMoves("", position-18);
                        all[position-18].addActionListener(new rkAction(position-18));
                        jpos2 = position-9;
                        mo += "6";
                        space = true;
                    }
                }
                else if ((position+1) %8 == 0 || (position+2) %8 == 0)
                {
                    if(!mo.contains("3") && position < 48 && (all[position+7].getClass().getName().contains("blackButton")|| all[position+7].getClass().getName().contains("bkingPin"))&& (all[position+14].getClass().getName().contains("jsButton")))
                    {
                        all[position+14] = new rkMoves("", position+14);
                        all[position+14].addActionListener(new rkAction(position+14));
                        jpos1 = position+7;
                        mo += "3";
                        space = true;
                    }
                    if(!mo.contains("7") && position > 15 && (all[position-7].getClass().getName().contains("blackButton")|| all[position-7].getClass().getName().contains("bkingPin"))&& (all[position-14].getClass().getName().contains("jsButton")))
                    {
                        all[position-14] = new rkMoves("", position-14);
                        all[position-14].addActionListener(new rkAction(position-14));
                        jpos3 = position-7;
                        mo += "7";
                        space = true;
                    }   
                }
                else
                {
                    if(!mo.contains("3") && position < 48 && (all[position+7].getClass().getName().contains("blackButton")|| all[position+7].getClass().getName().contains("bkingPin"))&& (all[position+14].getClass().getName().contains("jsButton")))
                    {
                        all[position+14] = new rkMoves("", position+14);
                        all[position+14].addActionListener(new rkAction(position+14));
                        jpos1 = position+7;
                        mo += "3";
                        space = true;
                    }
                    if(!mo.contains("7") && position > 15 && (all[position-7].getClass().getName().contains("blackButton")|| all[position-7].getClass().getName().contains("bkingPin"))&& (all[position-14].getClass().getName().contains("jsButton")))
                    {
                        all[position-14] = new rkMoves("", position-14);
                        all[position-14].addActionListener(new rkAction(position-14));
                        jpos3 = position-7;
                        mo += "7";
                        space = true;
                    }
                    if (position < 48)
                    {
                        if(!mo.contains("3") && (all[position+9].getClass().getName().contains("blackButton") || all[position+9].getClass().getName().contains("bkingPin"))&& all[position+18].getClass().getName().contains("jsButton"))
                        {
                            all[position+18] = new rkMoves("", position+18);
                            all[position+18].addActionListener(new rkAction(position+18));
                            jpos = position+9;
                            mo += "3";
                            space = true;
                        }
                    }
                    if( !mo.contains("6") && position > 15 && (all[position-9].getClass().getName().contains("blackButton")|| all[position-9].getClass().getName().contains("bkingPin"))&& (all[position-18].getClass().getName().contains("jsButton")))
                    {
                        all[position-18] = new rkMoves("", position-18);
                        all[position-18].addActionListener(new rkAction(position-18));
                        jpos2 = position-9;
                        mo += "6";
                        space = true;
                    }   
                }
                if (space == true)
                    {
                        poss = position;
                    }
                
            }//end IF BLACKKINg BUTTON
            else if(all[position].getClass().getName().contains("rkMoves"))
            {
                s.play("SoundsCrate-MediumWhooshNoBuild");
                
                if(jpos !=0 && Math.abs(position - poss) > 9 && (position - jpos) == (jpos - poss) )
                {
                    BLACK --;
                    all[position] = all[poss];
                    all[position].addActionListener(new rkAction(position));
                    all[jpos] = new jsButton();
                    all[jpos].addActionListener(new jaction(jpos));
                    jpos1 = 0;
                    jpos = 0;
                    jpos2 = 0;
                    jpos3 =0;
                    all[poss] = new jsButton();
                    all[poss].addActionListener(new jaction(poss));
                }
                else if(jpos1 !=0 && Math.abs(position - poss) > 9 && (position - jpos1) == (jpos1 - poss))
                {
                    BLACK --;
                    all[position] = all[poss];
                    all[position].addActionListener(new jaction(position));
                    all[jpos1] = new jsButton();
                    all[jpos1].addActionListener(new jaction(jpos1));
                    jpos1 = 0;
                    jpos = 0;
                    jpos2 = 0;
                    jpos3 =0;
                    all[poss] = new jsButton();
                    all[poss].addActionListener(new jaction(poss));
                }
                else if(jpos2 !=0 && Math.abs(position - poss) > 9 && (position - jpos2) == (jpos2 - poss))
                {
                    BLACK --;
                    all[position] = all[poss];
                    all[position].addActionListener(new rkAction(position));
                    all[jpos2] = new jsButton();
                    all[jpos2].addActionListener(new jaction(jpos2));
                    jpos1 = 0;
                    jpos = 0;
                    jpos2 = 0;
                    jpos3 =0;
                    all[poss] = new jsButton();
                    all[poss].addActionListener(new jaction(poss));
                }
                else if(jpos3 !=0 && Math.abs(position - poss) > 9 && (position - jpos3) == (jpos3 - poss))
                {
                    BLACK --;
                    all[position] = all[poss];
                    all[position].addActionListener(new rkAction(position));
                    all[jpos3] = new jsButton();
                    all[jpos3].addActionListener(new jaction(jpos3));
                    jpos1 = 0;
                    jpos = 0;
                    jpos2 = 0;
                    jpos3 =0;
                    all[poss] = new jsButton();
                    all[poss].addActionListener(new jaction(poss));
                }
                else
                {
                    all[position] = all[poss];
                    all[position].addActionListener(new rkAction(position));
                    all[poss] = new jsButton();
                    all[poss].addActionListener(new jaction(poss));
                    turn = 1;
                    pturn = "red";
                    
                }
                cleareMoves();
                
            }//end rkMoves
            }
            update(all, 64);
        }
        
        
    }
    
    //BLACK KING ACTION
    private class bkAction implements ActionListener {
        private int position;
        
        public bkAction(int pos) {
            position = pos;
        }
        @Override
        public void actionPerformed(ActionEvent a)
        {
            if(position != prevPos)
            {
                
                prevPos = position;
            if(all[position].getClass().getName().contains("bkingPin") && turn ==1)
            {
                String mo ="";
                cleareMoves();
                
                boolean space = false;
                
                if(position %8 == 0 )
                {                    
                    if(!mo.contains("0") && position < 55 && (all[position+9].getClass().getName().contains("jsButton")))
                    {
                        all[position+9] = new bkMoves("", position+9);
                        all[position+9].addActionListener(new bkAction(position+9));
                        mo += "0";
                        space =true;
                    }
                    if(!mo.contains("1") && position > 8 && (all[position-7].getClass().getName().contains("jsButton")))
                    {
                        all[position-7] = new bkMoves("", position-7);
                        all[position-7].addActionListener(new bkAction(position-7));
                        mo += "1";
                        space =true;
                    }
                }
                else if((position+1) % 8 == 0)
                {
                    if(!mo.contains("2") && position > 8 && (all[position-9].getClass().getName().contains("jsButton")))
                    {
                        all[position-9] = new bkMoves("", position-9);
                        all[position-9].addActionListener(new bkAction(position-9));
                        mo += "2";
                        space =true;
                    }
                    if(!mo.contains("3") && position < 55 && (all[position+7].getClass().getName().contains("jsButton")))
                    {
                        all[position+7] = new bkMoves("", position+7);
                        all[position+7].addActionListener(new bkAction(position+7));
                        mo += "3";
                        space = true;                        
                    } 
                }
                else
                {
                    if(!mo.contains("2") && position > 8 && (all[position-9].getClass().getName().contains("jsButton")))
                    {
                        all[position-9] = new bkMoves("", position-9);
                        all[position-9].addActionListener(new bkAction(position-9));
                        mo += "2";
                        space =true;
                    }
                    if(!mo.contains("3") && position < 55 && (all[position+7].getClass().getName().contains("jsButton")))
                    {
                        all[position+7] = new bkMoves("", position+7);
                        all[position+7].addActionListener(new bkAction(position+7));
                        mo += "3";
                        space = true;                        
                    }
                    if(!mo.contains("0") && position < 55 && (all[position+9].getClass().getName().contains("jsButton")))
                    {
                        all[position+9] = new bkMoves("", position+9);
                        all[position+9].addActionListener(new bkAction(position+9));
                        mo+= "0";
                        space =true;
                    }
                    if(!mo.contains("1") && position > 8 && (all[position-7].getClass().getName().contains("jsButton")))
                    {
                        all[position-7] = new bkMoves("", position-7);
                        all[position-7].addActionListener(new bkAction(position-7));
                        mo += "1";
                        space =true;
                    }
                }
                if ((position) %8 == 0 || (position-1) %8 == 0)
                {
                    // Jump move
                    if (position < 48)
                    {
                        if(!mo.contains("4") && (all[position+9].getClass().getName().contains("redButton") || all[position+9].getClass().getName().contains("rkingPin") )&& (all[position+18].getClass().getName().contains("jsButton")))
                        {
                            all[position+18] = new bkMoves("", position+18);
                            all[position+18].addActionListener(new bkAction(position+18));
                            jpos = position+9;
                            mo += "4";
                            space = true;
                        }
                        
                    }
                    if(!mo.contains("5") && position > 15 && (all[position-7].getClass().getName().contains("redButton") || all[position-7].getClass().getName().contains("rkingPin")  )&& (all[position-14].getClass().getName().contains("jsButton")))
                    {
                        all[position-14] = new bkMoves("", position-14);
                        all[position-14].addActionListener(new bkAction(position-14));
                        jpos1 = position-7;
                        mo += "5";
                        space = true;
                    }
                }
                else if ((position+1) %8 == 0 || (position+2) %8 == 0)
                {
                    if(!mo.contains("6") && position < 48 && (all[position+7].getClass().getName().contains("redButton") || all[position+7].getClass().getName().contains("rkingPin") )&& (all[position+14].getClass().getName().contains("jsButton")))
                    {
                        all[position+14] = new bkMoves("", position+14);
                        all[position+14].addActionListener(new bkAction(position+14));
                        jpos2 = position+7;
                        mo += "6";
                        space = true;
                    }
                    if(!mo.contains("7") && position > 15 && (all[position-9].getClass().getName().contains("redButton") || all[position-9].getClass().getName().contains("rkingPin")  )&& (all[position-18].getClass().getName().contains("jsButton")))
                    {
                        all[position-18] = new bkMoves("", position-18);
                        all[position-18].addActionListener(new bkAction(position-18));
                        jpos3 = position-9;
                        mo += "7";
                        space = true;
                    } 
                }
                else
                {
                     if(!mo.contains("6") && position < 48 && (all[position+7].getClass().getName().contains("redButton") || all[position+7].getClass().getName().contains("rkingPin") )&& (all[position+14].getClass().getName().contains("jsButton")))
                    {
                        all[position+14] = new bkMoves("", position+14);
                        all[position+14].addActionListener(new bkAction(position+14));
                        jpos2 = position+7;
                        mo += "6";
                        space = true;
                    }
                    if(!mo.contains("7") && position > 15 && (all[position-9].getClass().getName().contains("redButton") || all[position-9].getClass().getName().contains("rkingPin")  )&& (all[position-18].getClass().getName().contains("jsButton")))
                    {
                        all[position-18] = new bkMoves("", position-18);
                        all[position-18].addActionListener(new bkAction(position-18));
                        mo += "7";
                        jpos3 = position-9;
                        space = true;
                    } 
                    if (position < 48)
                    {
                        if(!mo.contains("4") && (all[position+9].getClass().getName().contains("redButton") || all[position+9].getClass().getName().contains("rkingPin") )&& (all[position+18].getClass().getName().contains("jsButton")))
                        {
                            all[position+18] = new bkMoves("", position+18);
                            all[position+18].addActionListener(new bkAction(position+18));
                            jpos = position+9;
                            mo += "4";
                            space = true;
                        }
                        
                    }
                    if( !mo.contains("5") && position > 15 && (all[position-7].getClass().getName().contains("redButton") || all[position-7].getClass().getName().contains("rkingPin")  )&& (all[position-14].getClass().getName().contains("jsButton")))
                    {
                        all[position-14] = new bkMoves("", position-14);
                        all[position-14].addActionListener(new bkAction(position-14));
                        jpos1 = position-7;
                        mo += "5";
                        space = true;
                    }
                }

              
                if (space == true)
                    {
                        poss = position;
                    }  
                
                
            }//end IF REDKINGBUTTON

            else if(all[position].getClass().getName().contains("bkMoves"))
            {
                s.play("SoundsCrate-MediumWhooshNoBuild");
                adds.remove(new Integer(position));
                if(jpos !=0 && Math.abs(position - poss) > 9 && (position - jpos) == (jpos - poss) )
                {
                    RED --;
                    all[position] = all[poss];
                    all[position].addActionListener(new bkAction(position));
                    all[jpos] = new jsButton();
                    all[jpos].addActionListener(new jaction(jpos));
                    jpos1 = 0;
                    jpos = 0;
                    jpos2 = 0;
                    jpos3 = 0 ;
                    all[poss] = new jsButton();
                    all[poss].addActionListener(new jaction(poss));
                }
                else if(jpos1 !=0 && Math.abs(position - poss) > 9 && (position - jpos1) == (jpos1 - poss))
                {
                    RED --;
                    all[position] = all[poss];
                    all[position].addActionListener(new bkAction(position));
                    all[jpos1] = new jsButton();
                    all[jpos1].addActionListener(new jaction(jpos1));
                    jpos1 = 0;
                    jpos = 0;
                    jpos2 = 0;
                    jpos3 = 0 ;
                    all[poss] = new jsButton();
                    all[poss].addActionListener(new jaction(poss));
                }
                else if(jpos2 !=0 && Math.abs(position - poss) > 9 && (position - jpos2) == (jpos2 - poss))
                {
                    RED --;
                    all[position] = all[poss];
                    all[position].addActionListener(new bkAction(position));
                    all[jpos2] = new jsButton();
                    all[jpos2].addActionListener(new jaction(jpos2));
                    jpos1 = 0;
                    jpos = 0;
                    jpos2 = 0;
                    jpos3 = 0 ;
                    all[poss] = new jsButton();
                    all[poss].addActionListener(new jaction(poss));
                }
                else if(jpos3 !=0 && Math.abs(position - poss) > 9 && (position - jpos3) == (jpos3 - poss))
                {
                    RED --;
                    all[position] = all[poss];
                    all[position].addActionListener(new bkAction(position));
                    all[jpos3] = new jsButton();
                    all[jpos3].addActionListener(new jaction(jpos3));
                    jpos1 = 0;
                    jpos = 0;
                    jpos2 = 0;
                    jpos3 = 0 ;
                    all[poss] = new jsButton();
                    all[poss].addActionListener(new jaction(poss));
                }
                else
                {
                    all[position] = all[poss];
                    all[position].addActionListener(new bkAction(position));
                    all[poss] = new jsButton();
                    all[poss].addActionListener(new jaction(poss));
                    turn = 0;
                    pturn = "red";
                }
                cleareMoves();
                
            }//end rkMoves
            }
            update(all, 64);
        }
        
        
    }
    
    
    public void cleareMoves()
    {
        for(int i = 0; i < all.length; i++)
        {
            if(all[i].getClass().getName().contains("redAvailableMoves") || all[i].getClass().getName().contains("blackAvailableMoves") || all[i].getClass().getName().contains("rkMoves") || all[i].getClass().getName().contains("bkMoves") )
            {
               
                all[i] = new jsButton();
                all[i].addActionListener(new jaction(i));
                
            }
        }
        
        
    }
    
}
    
    


