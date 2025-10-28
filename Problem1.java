/*
733. Flood Fill
Ran on leetcode: Yes
TC: O(M * N)
SC: O(M * N)
Start from the source and move in all four direction in BFS manner if they are of same color of source and pain all of them.
*/
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // dimensions of image
        int rL = image.length;
        int cL = image[0].length;

        // add the src pixel
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr, sc});
        int currColor = image[sr][sc];

        // all dir
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while(!queue.isEmpty()){
            // poll the element and change color
            int[] pixel = queue.poll();
            int r = pixel[0];
            int c = pixel[1];
            image[r][c] = color;
            for(int[] dir: dirs){
                int newR = r + dir[0];
                int newC = c + dir[1];
                // if not out of bound and color which is being painted, or already visited add it to the queue
                if(newR >= 0 && newC >= 0 && newR < rL && newC < cL && image[newR][newC] != color && image[newR][newC] == currColor){
                    queue.offer(new int[]{newR, newC});
                }
            }
        }

        return image;
    }
}