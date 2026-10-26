class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) 
    {
        int n=nums.length;

        int[] ans = new int[n-k+1];
        int idx=0;

        Deque<Integer> dq = new ArrayDeque<>();

        int r=0;

        while(r<n)
        {
            //remove elements not in window currently
            while(!dq.isEmpty() && dq.peekFirst()<=r-k)
            {
                dq.pollFirst();
            }

            //remove smaller or equal elements from the back
            while(!dq.isEmpty() && nums[dq.peekLast()]<=nums[r])
            {
                dq.pollLast();
            }

            dq.offerLast(r); //the deque now holds usefule candidates in decreasing order of their values

            if(r>=k-1)
            {
                ans[idx++]=nums[dq.peekFirst()];
            }

            r++;
        }

        return ans;
    }
}
