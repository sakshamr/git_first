/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 *
 * @author Saksham Rastogi
 */
public class TicTacToe extends JFrame 
{
    JPanel p=new JPanel(new GridLayout(3,3));
    int player;
    int count;
    boolean player1=false;
    boolean player2=false;
    
    
     int turn1[][]=new int[3][3];
     JLabel jl;
     public TicTacToe()
    {
       for(int i=0;i<3;i++)
       {
           for(int j=0;j<3;j++)
           {
               cp[i][j]=new CustomPanel();
               
             p.add(cp[i][j]);
             cp[i][j].setBorder(b);
           }
       }
       player=1;
        jl=new JLabel("Start Player1");
        this.add(jl, BorderLayout.SOUTH);
       this.add(p,BorderLayout.CENTER);
        this.setTitle("Event");
        this.setSize(400,400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        
       
   }
    
    class CustomPanel extends JPanel implements MouseListener
    {
        int turn;
        
        public CustomPanel()
        {
            turn=0;
           // turn=player;
            this.addMouseListener(this);
        }

        //@Override
        public void mouseClicked(MouseEvent e) {
            //System.out.println("Hi");
            
            Object o=e.getSource();
            count++;
                
            for(int i=0;i<3;i++)
            {
                for(int j=0;j<3;j++)
                {
                    
                    if(o==cp[i][j]&&turn==0)
                    {
                        //System.out.println("");
                        
                         cp[i][j].turn=player;
                        player=player%2;
                         player++;
                         jl.setText("Player"+(player)+" turn");
                        turn1[i][j]= cp[i][j].turn;
                       
                         repaint();
                        
                       
                    }
                    //System.out.print(cp[i][j].turn);
                }
                //System.out.println();
                
                
            }
          if(isWinner()||count==9)
           {    //whoIsWinner();
                JOptionPane.showMessageDialog(null,whoIsWinner());
                
               System.exit(0);
           }
              
           
                   
           
        }
        
      
        @Override
        public void mousePressed(MouseEvent e) {
            
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            
        }

        @Override
        public void mouseExited(MouseEvent e) {
            
        }
        
        @Override
        protected void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            if(turn==1)
            {
                g.drawLine(0, 0, getWidth(),getHeight());
                g.drawLine(0,getWidth(),getHeight(),0);
            }
            else if(turn==2)
            {
                g.drawOval(0, 0, getWidth(), getHeight());
            }
        }
       
         }
    
   Border b=new LineBorder(Color.BLACK,2);
    CustomPanel cp[][]=new CustomPanel[3][3];
  
   
   public static void main(String args[])
   {
       TicTacToe f=new TicTacToe();
       
   }
   public  boolean isWinner()
   {
       if((turn1[0][0]==1&&turn1[0][1]==1&&turn1[0][2]==1)||turn1[0][0]==2&&turn1[0][1]==2&&turn1[0][2]==2)
       {  
           if(turn1[0][0]==1)
               player1=true;
           else
               player2=true;
           return true;
       }
       
       
       else if((turn1[1][0]==1&&turn1[1][1]==1&&turn1[1][2]==1)||(turn1[1][0]==2&&turn1[1][1]==2&&turn1[1][2]==2))
       {
          if(turn1[1][0]==1)
               player1=true;
           else
               player2=true;
           return true;
       }
      
       else if((turn1[2][0]==1&&turn1[2][1]==1&&turn1[2][2]==1)||(turn1[2][0]==2&&turn1[2][1]==2&&turn1[2][2]==2))
       {
          if(turn1[2][0]==1)
               player1=true;
           else
               player2=true;
           return true;
       }
       
        else if((turn1[0][0]==1&&turn1[1][0]==1&&turn1[2][0]==1)||(turn1[0][0]==2&&turn1[1][0]==2&&turn1[2][0]==2))
       {
           if(turn1[0][0]==1)
               player1=true;
           else
               player2=true;
           return true;
       }
      
        else if((turn1[0][1]==1&&turn1[1][1]==1&&turn1[2][1]==1)||(turn1[0][1]==2&&turn1[1][1]==2&&turn1[2][1]==2))
       {
          if(turn1[0][1]==1)
               player1=true;
           else
               player2=true;
           return true;
       }
      
        else if((turn1[0][2]==1&&turn1[1][2]==1&&turn1[2][2]==1)||(turn1[0][2]==2&&turn1[1][2]==2&&turn1[2][2]==2))
       {
           if(turn1[0][2]==1)
               player1=true;
           else
               player2=true;
           return true;
       }
      
        else if((turn1[0][0]==1&&turn1[1][1]==1&&turn1[2][2]==1)||(turn1[0][0]==2&&turn1[1][1]==2&&turn1[2][2]==2))
       {
          if(turn1[0][0]==1)
               player1=true;
           else
               player2=true;
           return true;
       }
       
        else if((turn1[0][2]==1&&turn1[1][1]==1&&turn1[2][0]==1)||(turn1[0][2]==2&&turn1[1][1]==2&&turn1[2][0]==2))
       {
           if(turn1[0][2]==1)
               player1=true;
           else
               player2=true;
           return true;
       }
        
       else
        {
            
           return false;
        }
       
       
       
       
          
   }
   public String whoIsWinner()
   {
       if(player1)
       {    jl.setText("Player1 has won");
            return "Player1 has won";
       }
            
       else if(player2)
       {   jl.setText("Player2 has won");
           return "Player2 has won";
       }
       else if(!isWinner())
       {    jl.setText("It's a tie");
           return "It's a tie";
       }
       return "";
   }
           
   
    
}
