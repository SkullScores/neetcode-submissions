class Solution {
    public List<List<String>> groupAnagrams(String[] strs) 
    {
        HashMap<HashMap<Character,Integer>, List<String>> map = new HashMap<>();

        for(String s : strs)
        {
            HashMap<Character,Integer> freq = new HashMap<>();

            for(int i=0; i<s.length(); i++)
            {
                char ch = s.charAt(i);

                if(!freq.containsKey(ch))
                {
                    freq.put(ch,1);
                }
                else
                {
                    freq.put(ch, freq.get(ch)+1);
                }
            }

            if(!map.containsKey(freq))
            {
                map.put(freq, new ArrayList<String>());
            }

            map.get(freq).add(s);
        }

        return new ArrayList<>(map.values());
    }
}
