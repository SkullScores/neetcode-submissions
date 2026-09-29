class Solution {
    public int lengthOfLongestSubstring(String s) 
    {
        int n=s.length();

        int l=0;
        int r=0;

        HashMap<Character,Integer> map = new HashMap<>();
        int max=0;

        while(r<n)
        {
            char frontChar = s.charAt(r);
            map.put(frontChar, map.getOrDefault(frontChar,0)+1);

            //make it valid
            while(map.get(frontChar)>1)
            {
                char backChar = s.charAt(l);
                map.put(backChar, map.get(backChar)-1);

                if(map.get(backChar)==0)
                {
                    map.remove(backChar);
                }
                l++;
            }

            //if valid
            if(map.get(frontChar)==1)
            {
                max=Math.max(max,r-l+1);
            }

            r++;
        }

        return max;
    }
}
