
import java.util.LinkedList;
import java.util.*;

public class RottenOranges {
    public static void main(String[] args) {
        
        int[][] arr = {{2,0,0,2}, {1,0,0,1}, {1,1,0,1},{0,0,0,1}};

        System.out.println(findTime(arr));
    }

    public static int findTime(int [][] grid){

        if(grid == null){
            return 0;
        }

        class address{
            int i;
            int j;
            address(int i, int j){
                this.i = i;
                this.j = j;
            }
        }

        int rows = grid.length;
        int cols = grid[0].length;
        Queue<address> q = new LinkedList<>();
        int count_fresh = 0;
        for(int i = 0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j] == 2){
                    q.add(new address(i, j));
                }
                if(grid[i][j] == 1){
                    count_fresh++;
                }
            }
        }

        if(count_fresh == 0){
            return 0;
        }
        int[] dx = {0,0, 1, -1};
        int[] dy = {1,-1, 0, 0};

        int countMin = 0;
        int cnt = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i =0; i<size; i++){
                address point = q.poll();
                for(int j= 0; j<4; j++){
                    int x= point.i +dx[j];
                    int y = point.j + dy[j];

                    if(x<0 || x>=rows || y<0 || y>=cols || grid[x][y]  == 0|| grid[x][y]  == 2){
                        continue;
                    }

                    grid[x][y] = 2;
                    cnt++;
                    q.add(new address(x, y));
                }
            }
            if(q.size()!=0){
                countMin++;
            }
        }
        System.err.println(cnt);
        if(cnt == count_fresh){
            return countMin;
        } return -1;
    }
}
