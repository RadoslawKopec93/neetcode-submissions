class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> seen = new HashSet<>();
        HashSet<Character> seen2 = new HashSet<>();

        for(char[] row : board) {
            for(int i = 0; i < 9; i++) {
                char c = row[i];
                if(!seen.contains(c) && c != '.') {
                    seen.add(c);
                } else if(c != '.') {
                    return false;
                }
                for(int j = 0; j < 9; j++) {
                    char cc = board[j][i];
                    if(!seen2.contains(cc) && cc != '.') {
                        seen2.add(cc);
                    } else if(cc != '.') {
                        return false;
                    }
                }
                seen2.clear();
            }
            seen.clear();
        }
        int square = 0;

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 9; j++) {

                for(int k = square; k < square + 3; k++) {
                    if(!seen.contains(board[j][k]) && board[j][k]!='.') {
             
                        seen.add(board[j][k]);
                    } else if(board[j][k] != '.') {
                        return false;
                    }
                }
                if (j != 0 && (j + 1) % 3 == 0) {
                    seen.clear();
                }

            }
            square += 3;
        }
        return true;
    }
}
