import java.util.*;
class trial_tictactoe{
		public static void main(String[] args){
			Menu();
		}
//GAME
	public static void Game(){
		Scanner in = new Scanner(System.in);
		Scanner in1 = new Scanner(System.in);
		System.out.println("\n1st player want to select X or O");
		System.out.println("Enter 1 for X or any other digit for O");
		int a = in1.nextInt();
		String user = "";
		if(a == 1){
			user = "X";
		}else{
			user = "O";
		}
		System.out.println("Enter 1st player name");
		String name = in.nextLine();
		System.out.println("Enter 2nd player name");
		String name2 = in.nextLine();
		int tie = 0;
		String main = "";
		int check = 1;
		char main2 = ' ';
		String array[][] = {{"a","b","c"},{"d","e","f"},{"g","h","i"}};
		board(array);
		String MoveChance;
		do{
			System.out.println("Enter the alphabet where " + name + " want to move his/her chance");
			main = in.nextLine();
			main2 = main.charAt(0);
			while(main2 >= 'j'){
				System.out.println("Invalid Move");
				System.out.println("Enter the alphabet again");
				main = in.nextLine();
				main2 = main.charAt(0);
			}
			MoveChance = Character.toString(main2);
			tie = tie + 1;
			move(MoveChance,array,user);
			board(array);
			check = Check(array);
			if(check == 0){
				Win(name);
				break;
			}
			if(tie < 9){
				System.out.println("Enter the alphabet where " + name2 + " wants to move his/her chance");
				main = in.nextLine();
				main2 = main.charAt(0);
				while(main2 >= 'j'){
					System.out.println("Your digit is out of reach");
					System.out.println("Enter the alphabet again");
					main = in.nextLine();
					main2 = main.charAt(0);
				}
				MoveChance = Character.toString(main2);
				tie = tie + 1;
				move2(MoveChance,array,user);
				board(array);
				check = Check(array);
				if(check == 0){
					if(user == "X"){
						user = "O";
					}else{
						user = "X";
					}
					Win(name2);
					break;
				}
			}
		}while(tie < 9);
		if(tie == 9){
			System.out.println("Sorry! but unfortunately the game is tied");
			Menu();
		}
	}
//MENU
	public static void Menu(){
		Scanner in = new Scanner(System.in);
		System.out.println("		Enter	1	to	play");
		System.out.println("		Enter	2	for	instruction");
		System.out.println("		Enter	3	to	play with computer");
		System.out.println("		Enter	4	to	know about the game");
		System.out.println("		Enter	5	to	quit");
		int choice = in.nextInt();
		if(choice == 1){
			Game();
		}else if(choice == 2){
			instruction();
			Menu();
		}else if(choice == 3){
			Computer();
		}else if(choice == 4){
			About();
			Menu();			
		}else if(choice == 5){
			System.out.println("\t\tThanks for playing");
		}else{
			System.out.println("Wrong choice");
			Menu();
		}
	}
//1st PLAYER MOVE
	public static void move(String main,String array[][],String user){
		for(int i = 0 ; i < 3 ; ++i){
			for(int j = 0 ; j < 3 ; ++j){	
				if(array[i][j].equalsIgnoreCase(main)){
					array[i][j] = user;
				}
			}
		}
	}
//2nd PLAYER CHANCE
	public static void move2(String main,String array[][],String user){
		if(user.equalsIgnoreCase("X")){
			user = "O";
		}else{
			user = "X";
		}
                for(int i = 0 ; i < 3 ; ++i){
                        for(int j = 0 ; j < 3 ; ++j){
                                if(array[i][j].equalsIgnoreCase(main)){
                                        array[i][j] = user;
                                }
                        }
                }
	}
//INSTRUCTIONS
	public static void instruction(){
		System.out.println("This is a tic tac game");
		try{Thread.sleep(1000);}catch(Exception e){}
		System.out.println("The game will finish when similar charcter 'X' Or 'O'");
		System.out.println("forms 3 pair diagonally or on boundaries");
		System.out.println("You have to enter the alphabet to move your chance");
		try{Thread.sleep(3000);}catch(Exception e){}
		System.out.println("The board will look like this :-");
		System.out.println("  a |   b   |  c ");
		System.out.println("----|-------|-----");
		System.out.println(" d  |   e   |  f  ");
		System.out.println("----|-------|-----");
		System.out.println(" g  |   h   |  i");
		System.out.println("A player will win when he forms similar 'X' or 'O'");
		System.out.println("On a,b & c or on d,e,f or g,h,i or a,d,g or b,e,h or c,f,i");
		System.out.println("And also when the form diagonaly on a,e,i or c,e,g");
		try{Thread.sleep(500);}catch(Exception e){}
	}

//BOARD
	public static void board(String array[][]){
		System.out.println("\t\t\t\t"+array[0][0]+" | "+array[0][1]+" | "+array[0][2]);
		System.out.println("\t\t\t      ----|---|----");
		System.out.println("\t\t\t\t"+array[1][0]+" | "+array[1][1]+" | "+array[1][2]);
		System.out.println("\t\t\t      ----|---|----");
		System.out.println("\t\t\t\t"+array[2][0]+" | "+array[2][1]+" | "+array[2][2]);
		System.out.println();
	}
//CHECK
	public static int Check(String array[][]){
		int win = 1;
		for(int i = 0 ; i < 3; ++i){
			for(int j = 0 ; j < 1 ; ++j){
				if(array[i][j] == array[i][j +1] && array[i][j + 1] == array[i][j + 2]){
					win = 0;		
				}
			}
		}
		for(int i = 0 ; i < 3 ; ++i){
			for(int j = 0 ; j < 1 ; ++j){
				if(array[j][i] == array[j + 1][i] && array[j + 1][i] == array[j + 2][i]){
					win = 0;
				}
			}
		}
		if(array[0][0] == array[1][1] && array[1][1] == array[2][2]){
			win = 0;
		}
		if(array[0][2] == array[1][1] && array[1][1] == array[2][0]){
			win = 0;
		}
		return(win);
	}
//WIN
	public static void Win(String user){
		System.out.println("\t\t\tCONGRATULATIONS!!!!");
		System.out.println(user + " had won the game");
		System.out.println("Hope You liked the game");
		Menu();
	}

//COMPUTER GAME
	public static void Computer(){
		Scanner in = new Scanner(System.in);
		Scanner in1 = new Scanner(System.in);
		String[] alreadymoved = {"j","k","l","m","n","o","p","q","r","s"};
		System.out.println("What would you like to choose");
		System.out.println("Press 1 for 'X' or and digit for 'O'");
		int no = in.nextInt();
		String user;
		if(no == 1){
			user = "X";
		}else{
			user = "O";
		}
		String[][] array = {{"a","b","c"},{"d","e","f"},{"g","h","i"}};
		int tie = 0;
		System.out.println("Please Enter your name");
		String name = in1.nextLine();
		String main;
		int check;
		board(array);
		int upgrade = 0;
		do{
			System.out.println("Enter the alphabet where you want to move your chance");
			main = in1.nextLine();
			alreadymoved[upgrade] = main;
			upgrade = upgrade + 1;	
			tie = tie + 1;
			move(main,array,user);
			board(array);
			int temp = 0;
			check = Check(array);
			if(check == 0){
				Win(name);
				break;
			}
			if(tie < 9){
				int declration = 97;
				int random = (int)(Math.random()*9);
				declration = declration + random;
				char computermove = (char)declration;
				String mainmovecomputer = Character.toString(computermove); 
				for(int i= 0 ; i < 10 ; ++i){
					if(mainmovecomputer.equals(alreadymoved[i])){
						while(mainmovecomputer.equals(alreadymoved[i])){
							declration = 97;
							random = (int)(Math.random()*9);
							declration = declration + random;
							computermove = (char)declration;
							mainmovecomputer = Character.toString(computermove);
							i = 0;
						}
					}
					

				}
				move2(mainmovecomputer,array,user);
				alreadymoved[upgrade] = mainmovecomputer;
				upgrade = upgrade + 1;
				try{Thread.sleep(1000);}catch(Exception e){}
				System.out.println("The computer moved its chance as: ");
				board(array);
				check = Check(array);
				tie = tie + 1;
				if(check == 0){
					if(user.equalsIgnoreCase("X")){
						user = "O";
					}else{
						user = "X";
					}
					System.out.println("The computer has won");
					System.out.println("Computer was playing with " + user);
					System.out.println("Hope you enjoyed the game");
					Menu();
					break;
				}
			}
		}while(tie < 9);
		if(tie == 9){
			System.out.println("Sorry! but the game is tied");
			Menu();
		}
	}
//ABOUT
	public static void About(){
		System.out.println("\tThis Game is made by Ritwik");
		try{Thread.sleep(500);}catch(Exception e){}
		System.out.println("\ti am a boy of class 9");
		System.out.println("\tG-mail - ritwikmni@gmail.com");
		try{Thread.sleep(2000);;}catch(Exception e){}
		System.out.println("\tThis is my first vesion of game");
		System.out.println("\tI will try to make more better version in future");
		try{Thread.sleep(3000);}catch(Exception e){}
	}
		
}
