package com.handgame.engine;

public class CompareLogic {
	public void compare(CommonService cs){
		int clientchoice = cs.getClientchoice();
		int compchoice = cs.getCompchoice();
		int result = 0;
		//Here is the very basic comparing logic
		//Will add more efficient and concise one later
		if (clientchoice != compchoice){
		   if (clientchoice == 0){
			   if (compchoice == 1 || compchoice == 3){
			     	//client loses
				   result = 2;
			   }else{
				   //client wins
				   result = 1;}
	    	}
		   else if(clientchoice == 1){
			   if (compchoice == 2 || compchoice == 4){
			     	//client loses
				   result = 2;
			   }else{
				   //client wins
				   result = 1;}
	       }
		   else if(clientchoice == 2){
			   if (compchoice == 3 || compchoice == 0){
			     	//client loses
				   result = 2;
			   }else{
				   //client wins
				   result = 1;}
           }		
		   else if(clientchoice == 3){
			   if (compchoice == 4 || compchoice == 1){
			     	//client loses
				   result = 2;
			   }else{
				   //client wins
				   result = 1;}
		   }
    	   else if(clientchoice == 4){
			   if (compchoice == 0 || compchoice == 2){
			     	//client loses
				   result = 2;
			   }else{
				   //client wins
				   result = 1;}
		   }
		}
		cs.setFinalresult(result);
	}
}


