/*
 * 49. Group Anagrams
 
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 */

import java.util.*;

class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        // define variables.
        HashMap<String, List<String>> h = new HashMap<>();
        // go through our array.
        for(String s : strs) {
            // define char array + sort it.
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String sortedString = new String(c);

            // define if it doesn't exist.
            if(!h.containsKey(sortedString)) {
                h.put(sortedString, new ArrayList<>());
            }

            // put it in.
            h.get(sortedString).add(s);
        }
        return new ArrayList<>(h.values());
    }
    
    public static void main(String[] args) {
        GroupAnagrams g = new GroupAnagrams();
        String[] wordsList = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(g.groupAnagrams(wordsList));
    }
}