package com.handgame.engine;

public class CommonService {
	int finalresult = 0;
	int clientchoice = 0;
	int compchoice = 0;
	String[] gesturelist;
	String[] resultlist;
	
	public int getClientchoice() {
		return clientchoice;
	}
	public void setClientchoice(int clientchoice) {
		this.clientchoice = clientchoice;
	}

	public int getFinalresult() {
		return finalresult;
	}
	public void setFinalresult(int finalresult) {
		this.finalresult = finalresult;
	}

	public int getCompchoice() {
		return compchoice;
	}
	public void setCompchoice(int compchoice) {
		this.compchoice = compchoice;
	}
	public String[] getGestureList() {
		return gesturelist;
	}
	public void setGestureList(String[] gesturelist) {
		this.gesturelist = gesturelist;
	}
	public String[] getResultList() {
		return resultlist;
	}
	public void setResultList(String[] resultlist) {
		this.resultlist = resultlist;
	}


}
