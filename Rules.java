/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
/**
   * reglas del juego 
 * @author DELL
 */
public class Rules {

	/**
	  * Comenzar el juego
	 */
	public void GameStart(){
		// Estas son todas las cartas
		ArrayList<Integer> allBrand = new ArrayList<Integer>();
		for(int i=1;i<53;i++){
			allBrand.add(i);
		}
		
		Player player1=new Player();
		Player player2=new Player();
		System.out.println("**************************");
		System.out.println("$                        $");
		System.out.println("$ Bienvenido al juego de blackjack $");
		System.out.println("$                        $");
		System.out.println("**************************");
		Scanner sc=new Scanner(System.in);
		System.out.println("\t Pulsa cualquier tecla para iniciar el juego ...");
          
		
                sc.nextLine();
                
		player1.setName("Jugador 1");
		player2.setName("Jugador 2");
                
              
		//Licencia
		Licensing(allBrand,player1,player2);
		// Mostrar las cartas en la mano del jugador
		showBrand(player1,player2);
		// Calcula la puntuaci�n
		Calculation( player1, player2);
		// Quiere el jugador una carta?
		// El jugador dos quiere una carta
		needBrand(allBrand,player1,player2);
		// Comience a comparar despu�s de donar todas las tarjetas
		compare(player1, player2);
	}
	
	/**
	 * 
	 * @param player1
	 * @param player2
	  * Comparar
	 */
       
        
	public void compare(Player player1,Player player2){
		if(player1.getScore()>player2.getScore()&&player1.getScore()<=21 ){
			System.out.println("Felicitaciones al jugador 1 por ganar");
                        
		}else if(player1.getScore()<player2.getScore()&&player2.getScore()<=21){
			System.out.println("Felicitaciones al jugador 2 por ganar");
				}
            
               
	}
	
	/**
	 * 
	 * @param allBrand
	 * @param player1
	 * @param player2
	  * Necesita tarjetas
	 */
	public void needBrand(ArrayList<Integer> allBrand,Player player1,Player player2){
		Random rd=new Random();
		int choice;
		int choice1;
		do{
		//player1
		System.out.println("El jugador 1 quiere una tarjeta?");
		System.out.println("1. S1 \t 2. No");
		Scanner sc=new Scanner(System.in);
		choice=sc.nextInt();
		switch (choice) {
		case 1:
			int a=rd.nextInt(allBrand.size());
			player1.getArr().add(allBrand.get(a));
			allBrand.remove(a);
			showBrand(player1,player2);
			Calculation( player1, player2);
			break;
		case 2:
			break;
		default:
			System.out.println("El parametro que ingreso es incorrecto, vuelva a ingresar ...");
			break;
		}
		
		//player2
		System.out.println("El jugador 2 quiere una tarjeta?");
		System.out.println("1. Si \t2. No");
		choice1=sc.nextInt();
		switch (choice1) {
		case 1:
			int b=rd.nextInt(allBrand.size());
			player2.getArr().add(allBrand.get(b));
			allBrand.remove(b);
			// Mostrar las cartas en la mano del jugador
			showBrand(player1,player2);
			// Calcula la puntuaci�n
			Calculation( player1, player2);
			break;
		case 2:
			break;
		default:
			System.out.println("El parametro que ingreso es incorrecto, vuelva a ingresar ...");
			break;
		}
		}while(choice==1||choice1==1);
	}
	
	/**
	 * 
	 * @param player1
	 * @param player2
	  * Calcular puntuaci�n
	 */
	public void Calculation(Player player1,Player player2){
		System.out.println();
		int temp=0;
		for(int i=0;i<player1.getArr().size();i++){
			temp+=brandNumber(player1.getArr().get(i));
			player1.setScore(temp);
		}
		temp=0;
		System.out.println("La puntuacion del jugador 1 es:"+player1.getScore());
		for(int i=0;i<player2.getArr().size();i++){
			temp+=brandNumber(player2.getArr().get(i));
			player2.setScore(temp);
		}
		System.out.println("La puntuacion del jugador 2 es:"+player2.getScore());
	}
	
	/**
	 * 
	 * @param i
	  * El n�mero representado por la tarjeta @return
	 */
	public int brandNumber(int i){
		if(i<=4 &&i>0){
			return 1;
		}else if(i<=8){
			return 2;
		}else if(i<=12){
			return 3;
		}else if(i<=16){
			return 4;
		}else if(i<=20){
			return 5;
		}else if(i<=24){
			return 6;
		}else if(i<=28){
			return 7;
		}else if(i<=32){
			return 8;
		}else if(i<=36){
			return 9;
		}else if(i<=40){
			return 10;
		}else if(i<=44){
			return 10;
		}else if(i<=48){
			return 10;
		}else if(i<=52){
			return 10;
		}
		return 0;
	}
	
	/**
	 * 
	 * @param player1
	 * @param player2
	  * @see muestra las cartas en la mano del jugador
	 */
	public void showBrand(Player player1,Player player2){
		System.out.print("La mano del jugador 1 es:");
		for(int i=0;i<player1.getArr().size();i++){
			BrandFace(player1.getArr().get(i), player1, player2);
			System.out.print("\t");
		}
		System.out.println();
		System.out.print("La mano del jugador 2 es:");
		for(int i=0;i<player2.getArr().size();i++){
			BrandFace(player2.getArr().get(i), player1, player2);
			System.out.print("\t");
		}
	}
	
	/**
	 * 
	 * @param i
	 * @param player1
	 * @param player2
     * @return 
	  * @see muestra la tarjeta
	 */
	public String BrandFace(int i,Player player1,Player player2){
		if(i<=4 &&i>0){
			System.out.print("A");
                        return "A";
		}else if(i<=8){
			System.out.print("2");
                        return "2";
		}else if(i<=12){
			System.out.print("3");
                        return "3";
		}else if(i<=16){
			System.out.print("4");
                        return "4";
		}else if(i<=20){
			System.out.print("5");
                        return "5";
		}else if(i<=24){
			System.out.print("6");
                        return "6";
		}else if(i<=28){
			System.out.print("7");
                        return "7";
		}else if(i<=32){
			System.out.print("8");
                        return "8";
		}else if(i<=36){
			System.out.print("9");
                        return "9";
		}else if(i<=40){
			System.out.print("10");
                        return "10";
		}else if(i<=44){
			System.out.print("J");
                        return "J";
		}else if(i<=48){
			System.out.print("Q");
                        return "Q";
		}else if(i<=52){
			System.out.print("K");
                        return "K";
		}
            return null;
	}
	
	/**
	 * 
	 * @param allBrand
	 * @param player1
	 * @param player2
	  	 * Licencia 
	 */
	public void Licensing(ArrayList<Integer> allBrand,Player player1,Player player2){
		Random rd=new Random();
		int first=rd.nextInt(allBrand.size());
		player1.getArr().add(allBrand.get(first));
		allBrand.remove(first);
		int second=rd.nextInt(allBrand.size());
		player1.getArr().add(allBrand.get(second));
		allBrand.remove(second);
		int third=rd.nextInt(allBrand.size());
		player2.getArr().add(allBrand.get(third));
		allBrand.remove(third);
		int fourth=rd.nextInt(allBrand.size());
		player2.getArr().add(allBrand.get(fourth));
		allBrand.remove(fourth);
	}
	
	
}
