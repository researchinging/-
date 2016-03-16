package com.jiabin.greed;

import java.util.Random;

/**
 * ѡ��
 * @author dayan
 *
 */
public class Players {
	public String name;
	/**
	 * ��ѡ�ֵ��ܳɼ�
	 */
	public int score;
	/**
	 * ��¼ѡ��һ�ֵĳɼ�
	 */
	public int round_score;
	/**
	 * ���� 
	 */
	private Dices dice=new Dices();
	public Players(String name)
	{
		this.name=name;
		score=0;
		round_score=0;
	}
	/**
	 * ѡ�������Ƿ����������
	 * @return 	1--����   0--��ֹ����
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
 * ѡ����һ�����ӣ����������round_score
 * @return ��ѡ����һ�ֵ÷�
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
 * ѡ�ֽ���һ�ֱ���������һ�ֵĵ÷ָ��µ��ܵ÷���
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
