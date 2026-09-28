class Solution {
    public int[] topKFrequent(int[] nums, int k) 
    {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : nums)
        {
            map.put(num, map.getOrDefault(num,0)+1);
        }

        //min-heap
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[1],b[1]));

        for(int x : map.keySet())
        {
            pq.add(new int[]{x, map.get(x)});

            if(pq.size()>k)
            {
                pq.poll();
            }
        }

        int[] ans = new int[k];
        int idx=0;

        while(k!=0)
        {
            int[] curr = pq.poll();
            int num = curr[0];
            ans[idx++]=num;
            k--;
        }

        return ans;
    }
}
