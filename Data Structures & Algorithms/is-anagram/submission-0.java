class Solution {
    public boolean isAnagram(String s, String t) 
    {
        if(s.length()!=t.length()) return false;

        HashMap<Character,Integer> map1 = new HashMap<>();
        HashMap<Character,Integer> map2 = new HashMap<>();

        for(int i=0; i<s.length(); i++)
        {
            Character ch1 = s.charAt(i);
            Character ch2 = t.charAt(i);

            if(!map1.containsKey(ch1))
            {
                map1.put(ch1,1);
            }
            else if(map1.containsKey(ch1))
            {
                map1.put(ch1, map1.get(ch1)+1);
            }

            if(!map2.containsKey(ch2))
            {
                map2.put(ch2,1);
            }
            else if(map2.containsKey(ch2))
            {
                map2.put(ch2, map2.get(ch2)+1);
            }
        }

        return map1.equals(map2);
    }
}
