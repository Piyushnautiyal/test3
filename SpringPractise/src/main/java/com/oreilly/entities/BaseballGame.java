package com.oreilly.entities;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

public class BaseballGame implements Game {
	@Resource
	private Team homeTeam;
	@Resource
	private Team awayTeam;

	public BaseballGame() {}

	/*public BaseballGame(Team homeTeam, Team awayTeam) {
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
	}*/

	@Override
	public void setHomeTeam(Team team) {
		this.homeTeam = team;
	}

	@Override
	public Team getHomeTeam() {
		return homeTeam;
	}

	@Override
	public void setAwayTeam(Team team) {
		this.awayTeam =team;
	}

	@Override
	public Team getAwayTeam() {
		return awayTeam;
	}

	@Override
	public String playGame() {
		System.out.println("Inside playgame");
		return Math.random() < 0.5 ? getHomeTeam().getName() :
			getAwayTeam().getName();
	}

	@Override
	public String toString() {
		return String.format("Game between %s at %s", awayTeam.getName(), homeTeam.getName());
	}

}
