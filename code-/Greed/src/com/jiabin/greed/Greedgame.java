package com.jiabin.greed;

import java.util.ArrayList;
/**
 * ʵ�ֱ�������
 * @author dayan
 *
 */
public class Greedgame {
	/**
	 * ����������
	 */
	private ArrayList<Players> competitor =new ArrayList<Players>();
	/**
	 * ÿһ����ֵĲ�����
	 */
	private ArrayList<Players> roundplayers =new ArrayList<Players>();
	/**
	 * ʤ�����޵ı�־
	 */
	private boolean No_winner=true;
	/**
	 * ���ѡ��
	 * @param e-������
	 * 
	 */
	public void addplayers(Players e) {
		competitor.add(e);
		System.out.println("add competitor:"+e.getName());
	}
	
	/**
	 * ��� �����ѡ����ͷһ�����ӵ÷�>=300�����
	 */
	private void inround(){
		int i;
		System.out.println("");
		for(i=0;i<competitor.size();i++){
			if(competitor.get(i).dropDice()>=300) {
				roundplayers.add(competitor.get(i));
				System.out.println("  "+competitor.get(i).getName()+"  in round");
			}
				
			else competitor.get(i).Round_score_clear();
		}
		
	}
	

	/**
	 * ����߿�ʼһ����Ϸ:ֱ������������������������ӵ÷�Ϊ0�����˳�����
	 * 
	 * 
	 */
	private void oneround(){
		int i;
		for(i=0;i<roundplayers.size();i++){
			while(roundplayers.get(i).IsDrop()) 
					if(0==roundplayers.get(i).dropDice()){
						roundplayers.get(i).Round_score_clear();
						break;
					}	
		}
	}
	/**
	 * ����һ�ֵ÷�
	 */
	private void calscore(){
		int i;
		for(i=0;i<roundplayers.size();i++){
			if(roundplayers.get(i).updatescore()>=3000){
				No_winner=false;
				System.out.println("winner is:"+roundplayers.get(i).getName());
				break;
			}
		}
		roundplayers.clear();
		System.out.println("**************end of one round***********");
	}
	
	public void startgame(){
		do{
			System.out.println("**************�ж��Ƿ����***********");
			inround();
			System.out.println("**************����߿�ʼһ����Ϸ***********");
			oneround();
			calscore();
			showscore();
			
		}while(No_winner);
	}

	private void showscore() {
		// TODO Auto-generated method stub
		int i;
		for(i=0;i<competitor.size();i++){
			System.out.println("competitor:"+competitor.get(i).getName()+"   score is:"+competitor.get(i).getScore());
		}
		System.out.println("***********result******************");
	}
}
