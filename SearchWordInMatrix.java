public class SearchWordInMatrix {

    static final int ROW = 3;
    static final int COL = 5;

    static int rowNum[] = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int colNum[] = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) {
        
        char mat[][] = { {'B', 'N', 'E', 'Y', 'S'},
                        {'H', 'E', 'D', 'E', 'S'},
                        {'S', 'G', 'N', 'D', 'E'}
                    };   
                    
        String word = "DES";
        
        char wordArr[] = word.toCharArray();
        findWords(mat, wordArr, wordArr.length-1);
       
    }

    public static void findWords(char[][] mat, char[] wordArr, int n){
        for(int i =0; i<ROW; i++){
            for(int j =0; j<COL; j++){
            
                if(wordArr[0] == mat[i][j]){
                    search(mat, i , j , -1, -1, wordArr, "",  0, n);
                }
            }
        }
    }

    public static void search(char[][] mat, int row , int col , int pRow, int pCol, char[] wordArr, String path, int index, int n){

        if(index > n || mat[row][col] != wordArr[index]){
            return;
        }

        path += (wordArr[index]) + "(" + String.valueOf(row)+ ", " + String.valueOf(col) + ") ";
        if (index == n)
        {
            System.out.print(path +"\n");
            return;
        }

        for(int k=0; k<8; k++){

            if(isValid(row+rowNum[k], col+colNum[k], pRow, pCol)){
                search(mat, row+rowNum[k], col+colNum[k], row, col, wordArr, path, index+1, n);
            }
        }
    } 
    
    public static boolean isValid(int row, int col, int pRow, int pCol){
        return (row >= 0) && (row < ROW) &&
        (col >= 0) && (col < COL) &&
        !(row == pRow && col == pCol);
    }
}
