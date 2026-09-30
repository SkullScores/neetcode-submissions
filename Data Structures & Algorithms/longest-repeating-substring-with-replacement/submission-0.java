class Solution {
    public int characterReplacement(String s, int k) 
    {
        int n = s.length();

        HashMap<Character,Integer> map = new HashMap<>();
        int maxFreq = 0;
        int ans=0;

        int l=0;
        int r=0;

        //no characters I need to change in a vlid window = length - maxFreq

        while(r<n)
        {
            char frontChar = s.charAt(r);

            map.put(frontChar, map.getOrDefault(frontChar,0)+1);
            maxFreq = Math.max(maxFreq, map.get(frontChar));

            //make it possible
            while((r-l+1)-maxFreq > k)
            {
                char backChar = s.charAt(l);
                map.put(backChar, map.get(backChar)-1);
                if(map.get(backChar)==0)
                {
                    map.remove(backChar);
                }

                l++;
            }

            //if possible
            ans = Math.max(ans, r-l+1);

            r++;
        }

        return ans;
        
    }
}
