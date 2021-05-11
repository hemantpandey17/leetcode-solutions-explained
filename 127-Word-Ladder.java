/*

Basically I keep two sets of words, one set reached that represents the borders that have been reached with "distance" steps; another set wordDict that has not been reached. In the while loop, for each word in the reached set, I give all variations and check if it matches anything from wordDict, if it has a match, I add that word into toAdd set, which will be my "reached" set in the next loop, and remove the word from wordDict because I already reached it in this step. And at the end of while loop, I check the size of toAdd, which means that if I can't reach any new String from wordDict, I won't be able to reach the endWord, then just return 0. Finally if the endWord is in reached set, I return the current steps "distance".

The idea is that reached always contain only the ones we just reached in the last step, and wordDict always contain the ones that haven't been reached. This is pretty much what Dijkstra's algorithm does, or you can see this as some variation of BFS.

*/


class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> reached = new HashSet<String>();
        Set<String> wordDict = new HashSet<>(wordList);
        reached.add(beginWord);
        int distance = 1;
        while (!reached.contains(endWord)) {
            Set<String> toAdd = new HashSet<String>();
            for (String each : reached) {
                char[] chars = each.toCharArray();
                for (int i = 0; i < each.length(); i++) {
                    char temp = chars[i];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        chars[i] = ch;
                        String word = new String(chars);
                        if (wordDict.contains(word)) {
                            toAdd.add(word);
                            wordDict.remove(word);
                        }
                    }
                    chars[i] = temp;
                }
            }
            distance++;
            if (toAdd.size() == 0) return 0;
            reached = toAdd;
        }
        return distance;
    }
}

/*
Dry run


beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Reached = []
wordDict = ["hot","dot","dog","lot","log","cog"]

Adding beginWord to Reached, Reached = ["hit"]
Distance = 1

We will do till the reached set does not contain the endWord "cog"

Make a set toAdd (this will contain all words which can be made from words in reached and also present in wordDict)

from hit, hot can be made by changing one char, so we add hot to toAdd and remove hit from wordDict
Distance = 2
Now, since toAdd's size is > 0, reached = toAdd

Now since reached does not contain end word, we repeat now with reached = hot
From hot, dot can be made
Distance = 3
Now, since toAdd's size is > 0, reached = toAdd

Now since reached does not contain end word, we repeat now with reached = dot
From dot, dog can be made
Distance = 4

Now, since toAdd's size is > 0, reached = toAdd
Now since reached does not contain end word, we repeat now with reached = dog
From dot, cog can be made
Distance = 5
Now, since toAdd's size is > 0, reached = toAdd

Now the reached has endWord, so we return distance = 5




*/
