package com.handgame.engine;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AdvanceEngine {
	public void genAdvanced(CommonService cs){
		//Basic logic: 
		//Step 1: Read historical records from file which stores client gestures
		//Step 2: Find out the most common patterns (2 consecutive chances)
		//Step 3: See if the client's last gesture in above pattern, then make decision
		//Step 4: If not in above pattern, find out most frequent gestures, then decide
		
		//Step 1
		int[] clienthis = {};
		int [] mostcommon = {};
		AdvanceEngine ae = new AdvanceEngine();
		clienthis = ae.readFile();
		int n = clienthis.length;
		int clientpotential = -1,compchoice = 0;
		if (n == 0) {
			clientpotential = (int)(Math.random()*5);
		}else{
			if ( n == 1){
				clientpotential = clienthis[n-1]; 
			}else{
				//Step 2 & Step 3
				mostcommon = ae.findPattern(clienthis);
				if(clienthis[n-1] == mostcommon[0]){
					clientpotential = mostcommon[1];
				}else{
					//Step 4
					clientpotential = ae.mostCommonInt(clienthis);
				}
				
			}
		}
			
		compchoice = ae.findSolution(clientpotential);	
		
		cs.setCompchoice(compchoice);
	}

	
	//Function findResult: purpose is to collect result client and computer choice
	public String[] findResult(CommonService cs){
    	String[] res = new String[3];
    	
    	//set the compchoice first, here we use random value
    	AdvanceEngine ae = new AdvanceEngine();
    	ae.genAdvanced(cs);
    	
    	//Make Comparison here
    	CompareLogic cl = new CompareLogic();
    	cl.compare(cs);
    	
    	//Collect the result of game
    	res[0] = cs.getResultList()[cs.getFinalresult()];
    	res[1] = cs.getGestureList()[cs.getClientchoice()];
    	res[2] = cs.getGestureList()[cs.getCompchoice()];
    	return res;
    }
	
	public int[] readFile(){
		int[] clienthistory = {};
		int i=0;
		String filePath = "records/clientrecords.txt";
		File file = new File(filePath);
		try{
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			while(br.readLine() != null){
				clienthistory[i] = Integer.parseInt(br.readLine());
				i++;
			}
			
			br.close();
			fr.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		return clienthistory;
	}
	
	public void writeFile(int clientchoice){
		String filePath = "records/clientrecords.txt";
		File file = new File(filePath);
		try{
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.append((char)clientchoice);
			bw.newLine();	
			bw.close();
			fw.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}
	
	public int[] findPattern(int[] clienthis){
		int[] rlt = new int[2];
//		Set<Integer> set = new Set<Integer,Integer>(); 
//		Map<Set,Integer> map = new HashMap<Set,Integer>();
//		
//		
		return rlt;
	}
	
	public int mostCommonInt(int[] clienthis){
		int i = 0, max = 0, mostcommon = -1;
		int[] frequency = new int[5];
		for (i = 0;i<frequency.length;i++){
			frequency[i] = 0;
		}

		for(i = 0; i<clienthis.length;i++){
			frequency[clienthis[i]] += 1;
		}
		
		//Find out largest value in frequency
		for (i=0;i<frequency.length;i++){
			if(frequency[i] > max){ 
				max = frequency[i];
				mostcommon = i; }
		}
		
		return mostcommon;
	}
	
	public int findSolution(int clientpotential){
		if(clientpotential == 0){ 
			return 1;
		}else if(clientpotential == 1){
			return 2;
		}else if(clientpotential == 2){
			return 3;
		}else if(clientpotential == 3){
			return 4;
		}else if(clientpotential == 4){
			return 0;
		}else return -1;
		
	}

}
