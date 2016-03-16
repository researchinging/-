package com.jiabin.greed;

import java.util.Random;

public class Dices {
	private int number;
	private int numArr[]=new int[7];
	
	private void init_numArr() {
		int i;
		for(i=1;i<=6;i++) numArr[i]=0;

	}
	public Dices(){
		number=6;
		init_numArr();
	}
	/**
	 * 投掷一次骰子，并将score返回
	 * @return 得分
	 */
	public int drop(){
		Random rand = new Random();
		int i,tem_score=0;
		init_numArr();
		for(i=0;i<number;i++)
		numArr[rand.nextInt(5)+1]++;
		for(i=1;i<=6;i++)
			System.out.print("  "+numArr[i]);
		//case1:
		if(numArr[1]==6) {number=0;return 3000;}
		//case2:
		else if(numArr[1]>3) {
			tem_score=1000+(numArr[1]-3)*100;
			if(numArr[5]!=0) tem_score+=50*numArr[5];
			number=number-numArr[1]-numArr[5];
			return tem_score;
		}
		//case3:
		else if(numArr[1]==3){
			tem_score=1000;
			number=number-3;
			for(i=2;i<=6;i++)
				if(numArr[i]==3) {
					tem_score+=i*100;
					number=0;
					return tem_score;
				}
		    if(numArr[5]!=0) tem_score+=50*numArr[5];
		    number=number-numArr[5];
		    return tem_score;
		}
		//case4:
		else if(numArr[1]>=1){
			tem_score=numArr[1]*100;
			number=number-numArr[1];
			for(i=2;i<=6;i++)
				if(numArr[i]>=3) {
					tem_score+=i*100;
					number=number-numArr[i];
				}
			if(numArr[5]>3) {tem_score=numArr[1]*100+5*100+50*(numArr[5]-3);number=number+3-numArr[5];}
			
			else if(numArr[5]<3) {tem_score+=50*numArr[5];number=number-numArr[5];}
			return tem_score;
		}
		//case5:
		else{
			for(i=2;i<=6;i++){
				if(numArr[i]==6) {
					tem_score=i*100*2;
					number=0;
					return tem_score;
				}else if(numArr[i]>=3) {
					tem_score=i*100;
					number=number-numArr[i];
				}
			}
			if(numArr[5]==4||numArr[5]==5) tem_score=5*100+50*(numArr[5]-3);
			else if(numArr[5]<3) {tem_score+=50*numArr[5];number=number-numArr[5];}
			return tem_score;
				
		}
}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}

	
}
