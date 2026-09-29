class Solution {
    public boolean isPalindrome(String s) 
    {
        int n = s.length();
        if(n<=1)
        {
            return true;
        }

        int l=0;
        int r=n-1;

        while(l<r)
        {

            while(l<r && !alphaNum(s.charAt(l)))
            {
                l++;
            }
            while(r>l && !alphaNum(s.charAt(r)))
            {
                r--;
            }

            char front = Character.toLowerCase(s.charAt(l));
            char back = Character.toLowerCase(s.charAt(r));

            if(front!=back) return false;
            
            l++;
            r--;
        }

        return true;
    }

    public boolean alphaNum(char ch)
    {
        return ((ch>='A' && ch<='Z') || (ch>='a' && ch<='z') || (ch>='0' && ch<='9'));
    }
}
