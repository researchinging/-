package com.jiabin.greed;



public class Greed {
	
	
	
	public static void main(String[] args) {
		Players p1=new Players("1��");
		Players p2=new Players("2��");
		Players p3=new Players("3��");
		
		Greedgame game=new Greedgame();
		game.addplayers(p1);
		game.addplayers(p2);
		game.addplayers(p3);
		
		System.out.println("example:0  0  1  4  1  0    competitor:1��   score is:450");
		
		System.out.println("meaning:���ӳ�������1-0�Σ�����2-0�Σ�����3-1�Σ�����4-4��");
		game.startgame();
	}

}
