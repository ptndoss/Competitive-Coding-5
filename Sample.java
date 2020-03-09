// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    List<Integer> result;
    // int Max;
    public List<Integer> largestValues(TreeNode root) {
        result = new ArrayList<>();
        dfs(root, 0);

        // BSF Solution
        // result.add(0);
        // List<Integer> result = new ArrayList<>();
//         if(root == null)
//             return result;
        
//         max = Integer.MIN_VALUE;
        
//         Queue<TreeNode> q = new LinkedList<>();
//         q.add(root);
        
//         while(!q.isEmpty()){
//             int max = Integer.MIN_VALUE;
//             int size = q.size();
//             for(int i=0;i<size;i++){
//                 TreeNode currNode = q.poll();
//                 if(currNode.val > max){
//                     max = currNode.val;
//                 }
                
//                 if(currNode.left != null) q.add(currNode.left);
//                 if(currNode.right != null) q.add(currNode.right);
                
//             }
//             result.add(max);
        
        return result;
    }
    
    private void dfs(TreeNode root, int index){
        // base
        if(root == null)
            return;
        // logic
        if(result.size() == index){
            result.add(index, root.val);    
        } else if(result.get(index) < root.val){
            result.set(index, root.val) ;
        }
        dfs(root.left, index+1);
        dfs(root.right, index+1);
        
    }
}


//         }


// =======================Valid Sudoku==============
// Time Complexity : O(n*m)
// Space Complexity : O(n*m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach



class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        if(board == null || board.length ==0)
            return true;
        int row = board.length;
        int col = board[0].length;
        for(int i=0;i<row; i++){
        HashSet<Character> rowSet = new HashSet<>();
        HashSet<Character> colSet = new HashSet<>();
        HashSet<Character> boxSet = new HashSet<>();
        
            for(int j=0;j<col;j++){
                if(board[i][j] != '.' && !rowSet.add(board[i][j]))
                        return false;
                if(board[j][i] != '.' && !colSet.add(board[j][i]))
                        return false;
                int rowIndex= 3*(i/3);
                int colIndex= 3*(i%3);
            
                if(board[rowIndex + j/3][colIndex + j%3 ]!='.' && !boxSet.add(board[rowIndex + j/3][colIndex + j%3 ]))
                    return false;
                }
       
    }
        return true;
        
    }
    
}


