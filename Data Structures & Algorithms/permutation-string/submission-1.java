class Solution {
    public boolean checkInclusion(String s1, String s2) 
    {
        int n1 = s1.length();
        int n2 = s2.length();

        if(n1>n2) return false;

        HashMap<Character,Integer> map1 = new HashMap<>();
        for(int i=0; i<n1; i++)
        {
            char ch = s1.charAt(i);
            map1.put(ch, map1.getOrDefault(ch,0)+1);
        }

        HashMap<Character,Integer> map2 = new HashMap<>();
        int l=0;
        int r=0;

        while(r<n2)
        {
            char front = s2.charAt(r);
            map2.put(front, map2.getOrDefault(front,0)+1);

            //make it possible
            // it's "possible" because both maps have size 2 — but the frequencies don't match.
            // real condition: window length == n1
            while(r-l+1>n1)
            {
                char back = s2.charAt(l);
                map2.put(back, map2.get(back)-1);
                if(map2.get(back)==0)
                {
                    map2.remove(back);
                }

                l++;
            }

            //if possible
            if(r-l+1==n1 && map2.equals(map1)) return true;

            r++;
        }

        return false;
    }
}
