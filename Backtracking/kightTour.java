public class kightTour {
    static int n = 5;
    static int res[][] = new int[n][n];
    static int  xMoves[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
    static int  yMoves[] = { 1, 2, 2, 1, -1, -2, -2, -1 };
    public static void main(String[] args) {
        for(int i=0 ;i<n; i++){
            for(int j=0 ;j<n; j++){
                res[i][j] = -1;
            }
        }

        res[2][2] = 0;
        if( solve(2, 2, 1)){
            printSol();
        }else {
            System.out.println("not possible");
        }
    }

    static boolean solve(int x, int y, int count){
        if (count == n*n){
            return true;
        }
        for(int k=0; k<8; k++){
            int nextX = x+xMoves[k];
            int nextY = y+yMoves[k];

            if(isSafe(nextX, nextY)){
                res[nextX][nextY] = count;
                if(solve(nextX, nextY, count+1))
                    return true;
                else
                    res[nextX][nextY] = -1;
            }
        }
        return false;
    }

    static boolean isSafe(int x, int y){

        if(x<n && x>-1 && y<n && y>-1 && res[x][y] == -1){
            return true;
        } 
        return false;
    }

    static void printSol(){
        for(int i=0 ;i<n; i++){
            for(int j=0 ;j<n; j++){
                System.out.print(res[i][j] + "  ");
                 res[i][j] = -1;
            }
            System.out.println("  ");
        }
    }

}
