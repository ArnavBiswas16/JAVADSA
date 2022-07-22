public class ratInMaze {

    static int[][] maze ={{1, 0, 0, 0},
                          {1, 1, 0, 0},
                          {0, 1, 0, 0},
                          {0, 1, 1, 1}
                        };
    static int n = maze.length;  
    static int[][] sol= new int[n][n];                  
    public static void main(String[] args) {
        System.out.println( getOut(0, 0));
    }

    static boolean getOut(int x, int y){

        if(x==n-1 && y==n-1 && maze[x][y] == 1){
            sol[x][y] =1;
            return true;
        }
        if(isSafe(x, y)){

            if (sol[x][y] == 1)
                  return false;

                  sol[x][y] = 1;
            //move forward
            if(getOut(x, y+1)){
                return true;
            }

            //move backward
            if(y-1 >=0 && getOut(x, y-1)){
                return true;
            }
            

            //move down
            if(getOut(x+1, y)){
                return true;
            }

            // move up
            if(getOut(x-1, y)){
                return true;
            }
            
            sol[x][y] = 0;
            return false;
        }   
        return false;
    }

    static boolean isSafe(int x, int y)
    {
        // if (x, y outside maze) return false
        return (x >= 0 && x < n && y >= 0
                && y < n && maze[x][y] == 1);
    }
}
