package com.jiabin.greed;

import java.util.Random;

/**
 * 选手
 * @author dayan
 *
 */
public class Players {
	public String name;
	/**
	 * 该选手的总成绩
	 */
	public int score;
	/**
	 * 记录选手一轮的成绩
	 */
	public int round_score;
	/**
	 * 骰子 
	 */
	private Dices dice=new Dices();
	public Players(String name)
	{
		this.name=name;
		score=0;
		round_score=0;
	}
	/**
	 * 选手这轮是否继续掷骰子
	 * @return 	1--继续   0--终止本轮
	 */
	public boolean IsDrop(){
		if(dice.getNumber()==0) return false;
		else {
			Random rand = new Random();
			if(0!=rand.nextInt(10)%2) return true;
			else return false;
		}
	}
/**
 * 选手掷一次骰子，将结果计入round_score
 * @return 该选手这一轮得分
 */
public int dropDice(){
	int tem_score=0;
	tem_score=dice.drop();
	round_score+=tem_score;
	System.out.println("    competitor:"+name+"   score is:"+tem_score);
	return tem_score;
}


public String getName() {
	return name;
}



public void Round_score_clear() {
	round_score = 0;
	dice.setNumber(6);
}

/**
 * 选手结束一轮比赛，将这一轮的得分更新到总得分中
 */
public int updatescore() {
	score+=round_score;
	round_score=0;
	dice.setNumber(6);
	return score;

}
public int getScore() {
	return score;
}


}
