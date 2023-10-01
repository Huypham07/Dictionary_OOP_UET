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
            return this.idArray;
        }

        public void setIdArray(int i) {
            this.idArray = i;
        }

    }

    private TrieNode root;
    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String key, int indexArray) {
        String l_key = key.toLowerCase();
        TrieNode tmpNode = this.root;
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
        TrieNode tmpNode = this.root;
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

    public List<String> dictionarySearcher(String prefix) {
        List<String> results = new ArrayList<>();
        TrieNode current = root;

        for (char c : prefix.toLowerCase().toCharArray()) {
            TrieNode nextNode = current.children[c - 'a'];
            if (nextNode == null) {
                return results; // Không tìm thấy tiền tố
            }
            current = nextNode; // Đi đến node tiếp theo
        }

        findWordsWithPrefix(current, prefix, results);
        return results;
    }

    private void findWordsWithPrefix(TrieNode node, string currentWord, List<String> results) {
        if (node.getIdArray() >= 0) {
            results.add(currentWord.toString());
        }

        for (char c = 'a'; c <= 'z'; c++) {
            TrieNode child = node.children[c - 'a'];
            if (child != null) {
                currentWord.append(c);
                findWordsWithPrefix(child, currentWord, results);
                currentWord.deleteCharAt(currentWord.length() - 1);
            }
        }
    }
    // write method
    // remove word
}
