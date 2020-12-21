package com.accio.dictionary;

public class Dictionary {
	
	String value;
	int wordCount;
	Dictionary[] child = new Dictionary[26];
//	Array
	int ch;
	
	Dictionary(){
		this.value = new String();
		this.wordCount = 0;
		for(int i = 0; i < 26; i++)
			child[i] = null;
	}
	
	void insert(String word, String value, int index, int len){
		if(index == len)	{
			this.value = value;
			return ;
		}
		if(child[word.charAt(index) - 'a'] == null){
			child[word.charAt(index) - 'a'] = new Dictionary();
		}
		this.wordCount++;
		child[word.charAt(index) - 'a'].insert(word, value, index+1, len);
	}
	
	String search(String word, int index, int len){
		if(index == len){
			if(this.value.equals(""))
				return "No such word exits in the Dictionary";
			else
				return this.value;
		}
		else{
			if(this.child[word.charAt(index) - 'a'] == null)
				return "No such word exits in the Dictionary";
			else
				return child[word.charAt(index) - 'a'].search(word, index+1, len);
		}
	}
	
	void printAll(){
		String s = new String();
		printTree(s);
	}
	
	void printAllStartingWith(String word, int index, int len){
		if(index == len){
			this.printTree(word);
			return ;
		}
		else{
			if(child[word.charAt(index) - 'a'] == null){
				System.out.println("No words exists");
				return ;
			}
			else
				child[word.charAt(index) - 'a'].printAllStartingWith(word, index+1, len);
		}
	}
	
	int countAll(){
		return this.wordCount;
	}
	
	int countStartingWith(String word, int index, int len){
		if(index == len)
			return this.countAll();
		else{
			if(this.child[word.charAt(index) - 'a'] == null)
				return 0;
			else
				return this.child[word.charAt(index) - 'a'].countStartingWith(word, index+1, len);
		}
	}
	
	void printTree(String s){
		if(!this.value.equals("")){
			System.out.println(s+" "+this.value);
		}
		for(int i = 0; i < 26; i++){
			if(child[i] != null){
				int ch = 97+i;
				String dup = s+(char)ch;
				child[i].printTree(dup);
			}
		}
	}
}