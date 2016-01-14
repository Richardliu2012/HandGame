package com.handgame.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import com.handgame.engine.GameStarter;


public class HandGame extends JFrame {
	int mode = -1;
    int clientchoice = -1;
    String result = "";
    JLabel bottomlabel = new JLabel();
	public void createJFrame(String title){

	    final JFrame jf = new JFrame(title);
		
		//Below is the setting of the JFrame
		jf.setVisible(true);
		jf.setSize(800, 800);
		jf.setLayout(new BorderLayout());
		jf.setBackground(Color.WHITE);
		jf.setDefaultCloseOperation(EXIT_ON_CLOSE);

		Container container = jf.getContentPane();
	    container.setBounds(200, 200, 800, 800);
	    
	    //define element of top of UI 
	    JLabel toplabel = new JLabel();
        toplabel.setIcon(new ImageIcon("pic/title.png"));
        toplabel.setHorizontalAlignment(JLabel.CENTER);
        
        //define the element of bottom of UI
        //define the elements : choose basic or advanced level
        JPanel bottompanel = new JPanel();
        bottompanel.setVisible(true);
        JRadioButton basic = new JRadioButton("Basic");
        basic.setBounds(45, 29, 60, 20);
        JRadioButton advance = new JRadioButton("Advance");
        advance.setBounds(134, 29, 60, 20);
        ButtonGroup group = new ButtonGroup();
        group.add(basic);
        group.add(advance);
        bottompanel.add(basic);
        bottompanel.add(advance);
        
        basic.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
            mode = 0;
            //below code is for testing only
//            System.out.println("value is "+mode);
		}
		});
        
        advance.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
            mode = 1;
            //below code is for testing only
//            System.out.println("value is "+mode);
		}
		});
        

        bottomlabel.setIcon(new ImageIcon("pic/bottom.png"));
        bottomlabel.setHorizontalAlignment(JLabel.CENTER);
        bottomlabel.setText("Hello World");
        bottompanel.add(bottomlabel);
        
        
        //define the elements of middle of UI
        JPanel middlepanel = new JPanel();
        JLabel jl0 = new JLabel();
        jl0.setIcon(new ImageIcon("pic/rock.png"));
        JLabel jl1 = new JLabel();
        jl1.setIcon(new ImageIcon("pic/paper.png"));
        JLabel jl2 = new JLabel();
        jl2.setIcon(new ImageIcon("pic/scissor.png"));
        JLabel jl3 = new JLabel();
        jl3.setIcon(new ImageIcon("pic/spock.png"));
        JLabel jl4 = new JLabel();
        jl4.setIcon(new ImageIcon("pic/lizard.png"));
        
        middlepanel.add(jl0);
        middlepanel.add(jl1);
        middlepanel.add(jl2);
        middlepanel.add(jl3);
        middlepanel.add(jl4);
        
        //Here define the action for client choice
        jl0.addMouseListener(new MouseAdapter(){
    	  public void mouseClicked(MouseEvent mevent){
    		  clientchoice = 0;
    		  HandGame hg = new HandGame();
    		  result = hg.startGame(mode, clientchoice);
    		  bottomlabel.setText(" You "+result+"   ");
      	  }  
        });
        
        jl1.addMouseListener(new MouseAdapter(){
    	  public void mouseClicked(MouseEvent mevent){
    		  clientchoice = 1;
    		  HandGame hg = new HandGame();
    		  result = hg.startGame(mode, clientchoice);
    		  bottomlabel.setText(" You "+result+"   ");
      	  }  
        });
        
        jl2.addMouseListener(new MouseAdapter(){
    	  public void mouseClicked(MouseEvent mevent){
    		  clientchoice = 2;
    		  HandGame hg = new HandGame();
    		  result = hg.startGame(mode, clientchoice);
    		  bottomlabel.setText(" You "+result+"   ");
      	  }  
        });
        
        jl3.addMouseListener(new MouseAdapter(){
    	  public void mouseClicked(MouseEvent mevent){
    		  clientchoice = 3;
    		  HandGame hg = new HandGame();
    		  result = hg.startGame(mode, clientchoice);
    		  bottomlabel.setText(" You "+result+"   ");
      	  }  
        });
        
        jl4.addMouseListener(new MouseAdapter(){
    	  public void mouseClicked(MouseEvent mevent){
    		  clientchoice = 4;
    		  HandGame hg = new HandGame();
    		  result = hg.startGame(mode, clientchoice);
    		  bottomlabel.setText(" You "+result+"   ");
      	  }  
        });
        
        
	    //define the layout of the game GUI as below 
	    String[] border = {BorderLayout.CENTER, BorderLayout.NORTH,BorderLayout.SOUTH};
	    container.setLayout(new BorderLayout());
	    container.add(border[0],middlepanel);
	    container.add(border[1],toplabel);
	    container.add(border[2],bottompanel);

		jf.pack();		
		
	}
	
	public String startGame(int mode, int clientchoice){
		String[] res = new String[3];
		if ((mode != 0)&&(mode != 1)){
			return "Error";
		}else if (clientchoice < 0 || clientchoice >4){
			return "Error";
		}else{
			GameStarter game = new GameStarter();
			res = game.startGame(mode, clientchoice);
			return res[0];
		}
		
		
	}

	public static void main(String[] args){
		new HandGame().createJFrame("Enjoy Hand Game!");
        //define the action for JRadioButton
		
	}
	
    
}
