import java.io.*;
import java.util.*;

public class Main {

    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
    static boolean[][] visited;
    static char[][] board;
    static Trie trie;
    static Set<String> foundWords;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int w = Integer.parseInt(br.readLine());
        trie = new Trie();
        for (int i = 0; i < w; i++) {
            String str = br.readLine();
            trie.insert(str);
        }
        br.readLine();

        int b = Integer.parseInt(br.readLine());
        for (int Time = 0; Time < b; Time++) {
            board = new char[4][4];
            for (int i = 0; i < 4; i++) {
                String tmp = br.readLine();
                for (int j = 0; j < 4; j++) {
                    board[i][j] = tmp.charAt(j);
                }
            }

            foundWords = new HashSet<>();
            visited = new boolean[4][4];

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    dfs(i, j, "", trie.root);
                }
            }

            List<String> list = new ArrayList<>(foundWords);
            int cnt = list.size();
            int score = 0;
            String best = "";
            for (String word : list) {
                if (best.length() < word.length() || (best.length() == word.length() && word.compareTo(best) < 0)) {
                    best = word;
                }
                int len = word.length();
                if (len == 8) {
                    score += 11;
                } else if (len > 2 && len <= 4) {
                    score += 1;
                } else if (len == 5) {
                    score += 2;
                } else if (len == 6) {
                    score += 3;
                } else if (len == 7) {
                    score += 5;
                }
            }
            bw.write(score + " " + best + " " + cnt);
            bw.newLine();
            if (Time < b - 1) {
                br.readLine();
            }
        }

        br.close();
        bw.close();
    }

    static void dfs(int x, int y, String word, TrieNode node) {
        if (x < 0 || x >= 4 || y < 0 || y >= 4 || visited[x][y]) {
            return;
        }

        int idx = board[x][y] - 'A';
        if (node.children[idx] == null) return;

        visited[x][y] = true;
        word += board[x][y];
        node = node.children[idx];

        if (node.isEnd) {
            foundWords.add(word);
        }

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            dfs(nx, ny, word, node);
        }

        visited[x][y] = false;
    }
}

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEnd = false;
}

class Trie {
    TrieNode root = new TrieNode();

    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'A';
            if (node.children[idx] == null) {
                node.children[idx] = new TrieNode();
            }
            node = node.children[idx];
        }
        node.isEnd = true;
    }
}