/*
542. 01 Matrix
Ran on leetcode: Yes
TC: O(M * N)
SC: O(M * N)
Set all the 1s as -1 because we need to set the distance and track the nodes which are not visited, and enqueue all the 0s and in bfs manner find all the -1s which can be reached layer by layer and set the distance acoordingly
*/
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        // get the dimensions 
        int rL = mat.length;
        int cL = mat[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int[][] dirs = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

        for(int i = 0; i < rL; i++){
            for(int j = 0; j < cL; j++){
                if(mat[i][j] == 1){ // Change all 1 to -1 cauz we need to store distance
                    mat[i][j] = -1;
                } 
                if(mat[i][j] == 0){ // enqueue all 0's
                    queue.offer(new int[]{i, j});
                }
            }
        }

        int dist = 1;

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){ // Move layer by layer, at each layer if the value is -1 set the distance
                int[] cell = queue.poll();
                int r = cell[0];
                int c = cell[1];
                for(int[] dir: dirs){
                    int newR = r + dir[0];
                    int newC = c + dir[1];
                    if(newR >= 0 && newC >= 0 && newR < rL && newC < cL && mat[newR][newC] == -1){ // inbound and if the cell is not visited yet
                        queue.offer(new int[]{newR, newC}); // add to the queue
                        mat[newR][newC] = dist; // set the dist
                    }
                }
            }
            dist++; // return the dist
        }

        return mat;
    }
}