class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) 
    {
        if(!wordList.contains(endWord) || beginWord.equals(endWord))
        {
            return 0;
        }

        Queue<String> q = new LinkedList<>();
        HashSet<String> wordSet = new HashSet<>(wordList);
        
        q.add(beginWord);

        int cnt=0;

        while(!q.isEmpty())
        {
            int size = q.size();
            cnt++;

            while(size-- >0)
            {
                String curr = q.poll();

                if(curr.equals(endWord))
                {
                    return cnt;
                }

                char[] currWord = curr.toCharArray();
                for(int i=0; i<currWord.length; i++)
                {
                    char temp = currWord[i];

                    for(char c='a'; c<='z'; c++)
                    {
                        if(c!=temp)
                        {
                            currWord[i]=c;

                            String nextWord = new String(currWord);

                            if(wordSet.contains(nextWord))
                            {
                                q.add(nextWord);
                                wordSet.remove(nextWord);
                            }
                        }
                    }

                    currWord[i]=temp;
                }
            }
        }

        return 0;
    }
}
