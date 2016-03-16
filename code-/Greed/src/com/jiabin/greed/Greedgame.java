package com.jiabin.greed;

import java.util.ArrayList;
/**
 * 实现比赛规则
 * @author dayan
 *
 */
public class Greedgame {
	/**
	 * 参赛者链表
	 */
	private ArrayList<Players> competitor =new ArrayList<Players>();
	/**
	 * 每一轮入局的参赛者
	 */
	private ArrayList<Players> roundplayers =new ArrayList<Players>();
	/**
	 * 胜者有无的标志
	 */
	private boolean No_winner=true;
	/**
	 * 添加选手
	 * @param e-参赛者
	 * 
	 */
	public void addplayers(Players e) {
		competitor.add(e);
		System.out.println("add competitor:"+e.getName());
	}
	
	/**
	 * 入局 ：如果选手掷头一次骰子得分>=300则入局
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
	 * 入局者开始一轮游戏:直到入局者主动放弃或者掷骰子得分为0，则退出本轮
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
	 * 计算一轮得分
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
			System.out.println("**************判断是否入局***********");
			inround();
			System.out.println("**************入局者开始一轮游戏***********");
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
