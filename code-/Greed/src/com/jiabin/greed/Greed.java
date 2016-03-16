package com.jiabin.greed;



public class Greed {
	
	
	
	public static void main(String[] args) {
		Players p1=new Players("1号");
		Players p2=new Players("2号");
		Players p3=new Players("3号");
		
		Greedgame game=new Greedgame();
		game.addplayers(p1);
		game.addplayers(p2);
		game.addplayers(p3);
		
		System.out.println("example:0  0  1  4  1  0    competitor:1号   score is:450");
		
		System.out.println("meaning:骰子出现数字1-0次，数字2-0次，数字3-1次，数字4-4次");
		game.startgame();
	}

}
