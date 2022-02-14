import java.util.Scanner;
public class FriendsFriends {
	public static int [][] friends = new int [51][51];
	
	public static void main(String[] args) {
		
		init();
		printFriends();
	}
	public static void init () {
		for (int i = 1; i < friends.length; i++) {
			for (int j = 1; j < friends.length; j++) {
				friends [i][j] = 0;
			}
		}
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
	}
	public static void addFriend (int pers1, int pers2) {
		friends [pers1][pers2] = 1;
		friends [pers2][pers1] = 1;
	}
	public static void removeFriend(int pers1, int pers2) {
		friends [pers1][pers2] = 0;
		friends [pers2][pers1] = 0;
	}
	public static int countFriends(int pers) {
		int friendAmount = 0;
		
		for (int i = 1; i < friends.length; i++) {
			if (friends[pers][i] == 1 ) {
				friendAmount++;
			}
		}
		return friendAmount;
	}
	public static int degreesOfSeperation(int pers1, int pers2) {
		int degrees = 0;
		
		
		return degrees;
	}
	public static void printFriends () {
		for (int [] i: friends) {
			System.out.println("");
			for (int j: i) {
				System.out.print(j + " ");
			}
		}
	}
	public static void recieveInput () {
		Scanner in = new Scanner (System.in);
		String input = " ";
		char action = ' ';
		
		input = in.nextLine();
		action = input.charAt(0);
	}
}
