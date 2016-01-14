package com.handgame.engine;

import com.handgame.engine.CommonService;

public class BasicEngine {
	
	public void genRandom(CommonService cs){
		cs.setCompchoice((int)(Math.random()*5));
	}

	
	//Function findResult: purpose is to collect result client and computer choice
	public String[] findResult(CommonService cs){
    	String[] res = new String[3];
    	
    	//set the compchoice first, here we use random value
    	BasicEngine be = new BasicEngine();
    	be.genRandom(cs);
    	
    	//Make Comparison here
    	CompareLogic cl = new CompareLogic();
    	cl.compare(cs);
    	
    	//Collect the result of game
    	res[0] = cs.getResultList()[cs.getFinalresult()];
    	res[1] = cs.getGestureList()[cs.getClientchoice()];
    	res[2] = cs.getGestureList()[cs.getCompchoice()];
    	return res;
    }
	

}
