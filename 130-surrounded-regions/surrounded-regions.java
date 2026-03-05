class Solution {
    public void solve(char[][] board) {

        int rows = board.length;
        int cols = board[0].length;
        for(int j = 0; j < cols; j++){
            if(board[0][j] == 'O'){
                dfs(board,0,j,'T');
            }
            if(board[rows-1][j] == 'O'){
                dfs(board,rows-1,j,'T');
            }
        }
        for(int i = 0; i < rows; i++){
            if(board[i][0] == 'O'){
                dfs(board,i,0,'T');
            }
            if(board[i][cols-1] == 'O'){
                dfs(board,i,cols-1,'T');
            }
        }
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(board[i][j]=='T'){
                    board[i][j]='O';
                }
            }
        }
    }
    private void dfs(char[][] board,int i,int j,char c){
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || board[i][j]!='O'){
            return;
        }

        board[i][j] = c;

        dfs(board,i+1,j,c);
        dfs(board,i-1,j,c);
        dfs(board,i,j+1,c);
        dfs(board,i,j-1,c);
    }
}