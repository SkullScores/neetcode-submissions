class Solution {

    public String encode(List<String> strs) 
    {
        if(strs.isEmpty()) return "";

        StringBuilder sb = new StringBuilder();
        for(String s : strs)
        {
            sb.append(s.length());
            sb.append("#");
            sb.append(s);
        }

        return sb.toString();
    }

    public List<String> decode(String str) 
    {
        List<String> list = new ArrayList<>();
        
        if(str.length()==0) return list;

        int i=0;

        while(i<str.length())
        {
            int j=i;

            //find the '#'
            while(str.charAt(j)!='#')
            {
                j++;
            }

            int len = Integer.parseInt(str.substring(i,j));

            j++;

            String word = str.substring(j,j+len);

            list.add(word);

            i=j+len;
        }

        return list;
    }
}
