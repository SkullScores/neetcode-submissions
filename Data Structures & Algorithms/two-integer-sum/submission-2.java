class Solution {
    public int[] twoSum(int[] nums, int target) 
    {
        HashMap<Integer,int[]> map = new HashMap<>();

        for(int i=0; i<nums.length; i++)
        {
            if(!map.containsKey(nums[i]))
            {
                map.put(nums[i], new int[]{i,1});
            }
            else
            {
                int[] curr = map.get(nums[i]);
                int cnt = curr[1];
                map.put(nums[i], new int[]{i, cnt+1});
            }
        }

        for(int i=0; i<nums.length; i++)
        {
            if(map.containsKey(target-nums[i]))
            {
                int[] curr = map.get(target-nums[i]);
                int idx=curr[0];

                if(i != idx)
                {
                    if(i<=idx)
                    {
                        return new int[]{i,idx};
                    }
                    else 
                    {
                        return new int[]{idx,i};
                    }
                }
            }
        }

        return new int[]{0,0};
    }
}