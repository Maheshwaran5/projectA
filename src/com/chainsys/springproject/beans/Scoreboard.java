package com.chainsys.springproject.beans;

public class Scoreboard {
	public int targetScore;
	
	private Scoreboard(){
		System.out.println("ScoreBoard object created");
	}
	private Scoreboard(int runs){
		targetScore=runs;
		System.out.println("ScoreBoard object created " + runs);
	}
	// factory method - the Methods are static here
	public static Scoreboard createObject() {
		return new Scoreboard();
	}
	public static Scoreboard createObject(int runs) {
		return new Scoreboard(runs);
	}
}
