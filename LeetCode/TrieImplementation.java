// The following Code contains implementation of Trie Data Structure, which can mainly be used for Dictionary purposes.

import java.util.*;

class Trie {
    String value;
    HashMap<String, Trie> children;
    Boolean isEnd;

    /** Initialize your data structure here. */
    public Trie() {
        this.value = "";
        this.children = new HashMap<String, Trie>();
        this.isEnd = false;
        
    }
    
    Boolean isEqual(String word, String value){
        return value.equals(word.charAt(0)+"");
    }
    
    private void insertRecur(String word, Trie node){
            if(!isEqual(word, node.value)){
                node.value = word.charAt(0)+"";
            }
     
            if(word.length() == 1){
                node.isEnd = true;
                return;
            }
            
            if(node.children.containsKey(word.charAt(1)+"")){
                insertRecur(word.substring(1),node.children.get(word.charAt(1)+"")); 
            } else {
                Trie childrenNode = new Trie();
                node.children.put(word.charAt(1)+"", childrenNode);
                insertRecur(word.substring(1),childrenNode);
            }
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        if(!this.children.containsKey(word.charAt(0)+"")){
             Trie children = new Trie();
             this.children.put(word.charAt(0)+"",children);
        }
           
        
        insertRecur(word, this.children.get(word.charAt(0)+""));
        
    }
    
    Boolean searchRecurse(String word, Trie node, Boolean startWith){
        if(node != null && isEqual(word, node.value)){
            if(word.length() == 1){
                if(node.isEnd == true || startWith)
                    return true;
                else
                    return false;
            } else{
                return searchRecurse(word.substring(1), node.children.get(word.charAt(1)+""), startWith);
            }   
        }
        
        return false;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        
        return searchRecurse(word, this.children.get(word.charAt(0)+""), false);
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
         return searchRecurse(prefix, this.children.get(prefix.charAt(0)+""), true);
    }
}

 
 public class TrieImplementation{
	 public static void main(String args[]){
		 Trie obj = new Trie();
		 obj.insert("apple");
		 //obj.insert("app");
		 obj.insert("applet");
		 obj.insert("banana");
		 System.out.println("Is there any mango in dictionary ? " + obj.search("mango"));
		 System.out.println("Is there any man in dictionary ? " + obj.startsWith("man"));
		 System.out.println("Is there any app in dictionary ? " + obj.startsWith("app"));
	 }
 }