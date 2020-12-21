package com.accio.dictionary;

import java.util.Scanner;
import java.io.*;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Dictionary root = new Dictionary();
		int input;
//		String[] s = new String[];
		do{
			System.out.println("Enter 1 for adding a word into dictionary ");
			System.out.println("Enter 2 for searching a word into dictionary ");
			System.out.println("Enter 3 for printing all words in the dictionary ");
			System.out.println("Enter 4 for printing all words starting with given string in the dictionary ");
			System.out.println("Enter 5 for counting number of words in the dictionary ");
			System.out.println("Enter 6 for counting number of words starting with given string in the dictionary ");
			System.out.println("Enter 7 to exit the Dictionary");
			input = sc.nextInt();
			String word,value;
			int len;
			switch(input){
			case 1:
				word = sc.next();
				value = sc.next();
				len = word.length();
				root.insert(word, value, 0, len);
//				System.out.println(root.wordCount);
				break;
			case 2:
				word = sc.next();
				len = word.length();
				System.out.println(root.search(word, 0, len));
				break;
			case 3:
				root.printAll();
				break;
			case 4:
				word = sc.next();
				len = word.length();
				root.printAllStartingWith(word, 0, len);
				break;
			case 5:
				System.out.println(root.countAll());
				break;
			case 6:
				word = sc.next();
				len = word.length();
				System.out.println(root.countStartingWith(word, 0 ,len));
				break;
			default:
				break;
			}
		}while(input != 7);
		sc.close();
	}
}
