import java.util.Scanner;

public class nQueen {
    
    static int n;
    static int res[][];
    static boolean status;
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in); 
        System.out.println("eneter size");
        n = sc.nextInt();
        res = new int[n][n];
        if(solve(0)){
            // for(int i=0; i<n; i++){
            //     for(int j=0;j<n;j++){
            //         System.out.print(res[i][j] +"  ");
            //     }
            //     System.out.println("  ");
            // }
        } else {
            System.out.println("no sollution");
        }
    }

    static boolean solve(int row){

        if(row>=n){
            for(int i=0; i<n; i++){
                for(int j=0;j<n;j++){
                    System.out.print(res[i][j] +"  ");
                }
                System.out.println("  ");
            }
            status =true;
        }

        for(int j = 0; j<n; j++){
            if(isSafe(row, j)){
                res[row][j] = 1;
                if(solve(row+1))
                return true;
                res[row][j] = 0;
            } 
        }
        return status;

    }

    static boolean isSafe(int x, int y){

        int rx = x, lx =x;
        int ry = y, ly =y;
        //left upper diagnol
        while(lx>0 && ly>0){
            lx--; ly--;
            if(res[lx][ly] == 1){
                return false;
            }
        }

        // right upper diagnol
        while(rx>0 && ry<n-1){
            rx--; ry++;
            if(res[rx][ry] == 1){
                return false;
            }
        }

        // up same col
        while(x>0){
            x--;
            if(res[x][y] == 1){
                return false;
            }
        }
        return true;
    }
}
