package com.handgame.engine;

import com.handgame.engine.CommonService;
import com.handgame.engine.BasicEngine;;

public class GameStarter {

	public void startGame(int mode, int clientchoice){
		//Please do not change below block of codes, Initialize the Game
 		//-------------------------------------------------------------------
		CommonService cs = new CommonService();
		String[] gesturelist = {"Rock","Paper","Scissors","Spock","Lizard"};
		String[] resultset = {"Draw","Win","Lose"};
		cs.setGestureList(gesturelist);
		cs.setResultList(resultset);
 		//-------------------------------------------------------------------
		
		//Below codes start the game
		//Mode 0 is Random Mode where computer will pick a number randomly
                //Mode 1 is Advance Mode where computer will try to learn from client's previous gesture
		
		String[] result;
		cs.setClientchoice(clientchoice);
		
		
	        result = (mode == 0) ? new BasicEngine().findResult(cs):new AdvanceEngine().findResult(cs);
                System.out.println("You choose "+result[1]+" .");
                System.out.println("Computer choose "+result[2]+" .");
                System.out.println("You "+result[0]+" .");
	}
	
	public static void main(String[] args){
		GameStarter gs = new GameStarter();
		gs.startGame(0,3);
	}
}
