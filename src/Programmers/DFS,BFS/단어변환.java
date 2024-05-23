import java.util.*;
public class 단어변환 {
    class Solution {
        public int solution(String begin, String target, String[] words) {
            int answer = 0;
            List<String> wordList = Arrays.asList(words);

            if (!wordList.contains(target))
                return 0;

            List<List<Integer>> doubleList = new ArrayList<>();
            for (int i = 0; i < words.length; i++){
                doubleList.add(new ArrayList<Integer>());
            }

            for (int i = 0; i < words.length; i++) {
                for (int j = 0; j < words.length; j++){
                    if (!words[i].equals(words[j])){
                        if (hasDistance1(words[i], words[j])){
                            doubleList.get(i).add(j);
                        }
                    }
                }
            }

            Queue<Pair> queue = new LinkedList<>();
            boolean[] checked = new boolean[words.length];
            for (int i = 0; i < words.length; i++) {
                if (hasDistance1(words[i], begin)){
                    queue.add(new Pair(i, 1));
                }
            }

            while(!queue.isEmpty()){
                Pair pair = queue.poll();
                // System.out.println("pair: " + pair.index+ ", " + pair.depth);
                checked[pair.index] = true;
                if (target.equals(words[pair.index])){
                    answer = pair.depth;
                    break;
                }

                List<Integer> subList = doubleList.get(pair.index);
                for (int currIdx :subList){
                    if (!checked[currIdx]) {
                        queue.add(new Pair(currIdx, pair.depth + 1));
                    }
                }
            }

            return answer;

        }
        private boolean hasDistance1 (String str1, String str2){
            int count = 0;

            for (int i = 0; i < str1.length(); i ++){
                if (str1.charAt(i) != str2.charAt(i)){
                    count++;
                }
            }

            if (count == 1)
                return true;
            else
                return false;
        }

        class Pair {
            int index;
            int depth;

            public Pair(int index, int depth){
                this.depth = depth;
                this.index = index;
            }
        }
    }
}
