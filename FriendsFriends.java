import java.util.Scanner;
public class FriendsFriends {
	public static int amountOfPers = 50;
	public static int [][] friends = new int [amountOfPers + 1][amountOfPers + 1];
	public static int [][] degrees = new int [amountOfPers + 1][amountOfPers + 1];
	public static boolean start = true;
	
	public static void main(String[] args) {
		
		init();
		recieveInput();
		
	} // main
	
	// Initializes friendships and reset 2D array "friends"
	public static void init () {
		for (int i = 1; i < friends.length; i++) {
			for (int j = 1; j < friends.length; j++) {
				friends [i][j] = 0;
			} // for
		} // for
		addFriend (1,6);
		addFriend (2,6);
		addFriend (3,6);
		addFriend (3,4);
		addFriend (3,5);
		addFriend (3,15);
		addFriend (4,5);
		addFriend (4,6);
		addFriend (5,6);
		addFriend (6,7);
		addFriend (7,8);
		addFriend (8,9);
		addFriend (9,10);
		addFriend (9,12);
		addFriend (10,11);
		addFriend (11,12);
		addFriend (12,13);
		addFriend (13,14);
		addFriend (13,15);
		addFriend (16,17);
		addFriend (16,18);
		addFriend (17,18);
	} // init
	
	// Adds a friendship
	public static void addFriend (int pers1, int pers2) {
		friends [pers1][pers2] = 1;
		friends [pers2][pers1] = 1;
	} // addFriend
	
	// Removes a friendship
	public static void removeFriend(int pers1, int pers2) {
		friends [pers1][pers2] = 0;
		friends [pers2][pers1] = 0;
	} // removeFriend
	
	// Counts the amount of friends a person has
	public static int countFriends(int pers) {
		int friendAmount = 0;
		
		for (int i = 1; i < friends.length; i++) {
			if (friends[pers][i] == 1 ) {
				friendAmount++;
			} // if
		} // for
		return friendAmount;
	} // countFriends
	
	// Calculates the degrees of seperation between any two people
	public static int degreesOfSeperation(int pers1, int pers2) {
		if (start) {
			start = false;
			for (int i = 1; i < degrees.length; i++) {
				for (int j = 1; j < degrees.length; j++) {
					if (i == j) {
						degrees[i][j] = 0;
					} else if (friends[i][j] == 1) {
						degrees[i][j] = 1;
					} else {
						degrees[i][j] = 99;
					} // if
				} // for
			} // for
		}  // if
		
		for (int k = 1; k < degrees.length; k++) {
			for (int j = 1; j < degrees.length; j++) {
				if (j == k) {
					continue;
				} // if
				
				for (int i = 1; i < degrees.length; i++) {
					degrees[i][j] = (degrees[i][j] > degrees[i][k] + degrees[k][j])? degrees[i][k] + degrees[k][j]: degrees[i][j];
				} // for
			} // for
		} // for
		
		return degrees[pers1][pers2];
	} // degreesOfSeperation
	
	// Calculates how many friends of friends a person has
	public static int friendsOfFriends (int pers) {
		int friendAmount2 = 0;
		
		degreesOfSeperation(0,0);
		
		for (int i = 1; i < degrees.length; i++) {
			if (degrees[pers][i] == 2 ) {
				friendAmount2++;
			} // if
		} // for
		
		return friendAmount2;
	} // friendsOfFriends
	
	// Prints the 2D array "friends"
	public static void printFriends () {
		for (int [] i: friends) {
			System.out.println("");
			for (int j: i) {
				System.out.print(j + " ");
			} // for
		} // for
	} // printFriends
	
	// Recieves input and activates commands accordingly
	public static void recieveInput () {
		Scanner in = new Scanner (System.in);
		String input = " ";
		String [] values = new String [3];
		char action = ' ';
		int pers1 = 0;
		int pers2 = 0;
		int degree = 0;
		
		do {
			input = in.nextLine();
			values = input.split(" ");
			if (input.length() >= 2) {
				pers1 = Integer.parseInt(values[1]);
				if (input.length() >= 5) {
					pers2 = Integer.parseInt(values[2]);
				}  // if
			}  // if

			switch(values[0]) {
				case "i":
					addFriend(pers1,pers2);
					break;
				case "d":
					removeFriend(pers1,pers2);
					break;
				case "n":
					System.out.println(countFriends(pers1));
					break;
				case "f":
					start = true;
					System.out.println(friendsOfFriends(pers1));
					break;
				case "s":
					start = true;
					degree = degreesOfSeperation(pers1,pers2);
					if (degree == 99) {
						System.out.println("Not connected");
					} else {
						System.out.println(degree);
					}
					break;
				case "q":
					System.exit(0);
				case "p":
					printFriends();
					break;
			}  // switch
		} while (true);
	} // recieveInput
} // main
