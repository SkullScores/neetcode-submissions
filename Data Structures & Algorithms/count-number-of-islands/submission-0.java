class Solution {
    public int numIslands(char[][] grid) 
    {
        int m = grid.length;
        int n = grid[0].length;

        int cnt=0;

        for(int r=0; r<m; r++)
        {
            for(int c=0; c<n; c++)
            {
                if(grid[r][c]=='1')
                {
                    dfs(r,c,grid);
                    cnt++;
                }
            }
        }

        return cnt;
    }

    public void dfs(int r, int c, char[][] grid)
    {
        int m = grid.length;
        int n = grid[0].length;

        if(r<0 || r>=m || c<0 || c>=n || grid[r][c]=='0')
        {
            return;
        }

        grid[r][c]='0';

        dfs(r+1,c,grid);
        dfs(r-1,c,grid);
        dfs(r,c+1,grid);
        dfs(r,c-1,grid);
    }
}
