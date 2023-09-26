import java.util.*;
public class Trie {
    static class TrieNode {
        static final int ALPHABET_SIZE = 26;
        private TrieNode[] children;
        private int idArray;

        public TrieNode() {
            children = new TrieNode[ALPHABET_SIZE];
            idArray = -1;
            for (int i = 0; i < ALPHABET_SIZE; i++) {
                children[i] = null;
            }
        }

        //getter, setter of idArray
        public int getIdArray() {
            return idArray;
        }

        public void setIdArray(int i) {
            idArray = i;
        }

    }

    private TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    public void insert(String key, int indexArray) {
        String l_key = key.toLowerCase();
        TrieNode tmpNode = root;
        for (int i = 0; i < l_key.length(); i++) {
            int index = l_key.charAt(i) - 'a';
            if (tmpNode.children[index] == null) {
                tmpNode.children[index] = new TrieNode();
            }
            tmpNode = tmpNode.children[index];
        }
        tmpNode.setIdArray(indexArray);
    }

    public int search(String key) {
        String l_key = key.toLowerCase();
        TrieNode tmpNode = root;
        for (int i = 0; i < l_key.length(); i++) {
            int index = l_key.charAt(i) - 'a';
            if (tmpNode.children[index] != null) {
                tmpNode = tmpNode.children[index];
            } else {
                return -1;
            }
        }
        if (tmpNode != null && tmpNode.getIdArray() >= 0) {
            return tmpNode.getIdArray();
        } else {
            return -1; // Can't find
        }
    }

    // remove word

    // find words suggestion with prefix s
    // write method
}