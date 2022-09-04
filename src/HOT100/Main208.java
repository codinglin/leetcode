package HOT100;

public class Main208 {

}

class Trie {
    private boolean isEnd;
    private Trie[] children;

    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }

    public void insert(String word) {
        Trie node = this;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            int index = ch - 'a';
            if(node.children[index] == null){
                node.children[index] = new Trie();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return node!=null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    private Trie searchPrefix(String prefix){
        Trie node = this;
        for(int i=0; i<prefix.length(); i++){
            char ch = prefix.charAt(i);
            int index = ch - 'a';
            if(node.children[index] == null){
                return null;
            }
            node = node.children[index];
        }
        return node;
    }
}
