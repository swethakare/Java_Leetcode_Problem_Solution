import java.util.*;

class item {
    String x;
    int cnt;

    item(String x, int cnt) {
        this.x = x;
        this.cnt = cnt;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> s = new HashSet<>();
        for (String word : wordList) {
            s.add(word);
        }
        Queue<item> q = new LinkedList<>();
        q.add(new item(beginWord, 1));
        int cnt = 0;
        while (!q.isEmpty()) {
            item it = q.poll();
            String cur = it.x;
            cnt = it.cnt;
            if (cur.equals(endWord)) {
                return cnt;
            }
            if (cur.length() > 0) {
                char[] newcur = cur.toCharArray();
                for (int i = 0; i < newcur.length; i++) {
                    char oldChar = newcur[i];
                    for (char j = 'a'; j <= 'z'; j++) {
                        newcur[i] = j;
                        String ite = String.valueOf(newcur);
                        if (s.contains(ite)) {
                            q.add(new item(ite, cnt + 1));
                            s.remove(ite);
                        }
                    }
                    newcur[i] = oldChar;
                }
            }
        }
        return 0;
    }
}
