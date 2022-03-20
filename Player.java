/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;

import java.util.ArrayList;

/**
   * Categor�a de jugador
 * @author DELL
 *
 */
public class Player {

	private String name;//Nombre del jugador
	private ArrayList<Integer> al = new ArrayList<Integer>();//marca
	private int score;// Puntuaci�n del jugador
	
	//M�todo de construcci�n
	public Player() {
		super();
	}
	public Player(String name, int score) {
		super();
		this.name = name;
		
		this.score = score;
	}

	// m�todo getter setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Integer> getArr() {
		return al;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
}

