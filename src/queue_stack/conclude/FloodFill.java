package queue_stack.conclude;

import java.util.*;

public class FloodFill {
    private class Part{
        private int sr;
        private int sc;
        private int color;

        public Part(int sr, int sc, int color) {
            this.sr = sr;
            this.sc = sc;
            this.color = color;
        }
    }

    /**
     * BFS算法
     * @param image
     * @param sr
     * @param sc
     * @param newColor
     * @return
     */
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        if (newColor == image[sr][sc]){
            return image;
        }

        int high = image.length;
        int width = image[0].length;

        Queue<Part> queue = new LinkedList<>();

        Part root = new Part(sr, sc, image[sr][sc]);
        queue.add(root);

        while (!queue.isEmpty()) {
            Part part = queue.peek();

            List<Part> parts = new ArrayList<>();
            //获取四周的位置
            if (part.sr > 0 && image[part.sr - 1][part.sc] == part.color) {
                Part up = new Part(part.sr - 1, part.sc, part.color);
                parts.add(up);
            }
            if (part.sr < high - 1 && image[part.sr + 1][part.sc] == part.color) {
                Part down = new Part(part.sr + 1, part.sc, part.color);
                parts.add(down);
            }
            if (part.sc > 0 && image[part.sr][part.sc - 1] == part.color) {
                Part left = new Part(part.sr, part.sc - 1, part.color);
                parts.add(left);
            }
            if (part.sc < width - 1 && image[part.sr][part.sc + 1] == part.color) {
                Part right = new Part(part.sr, part.sc + 1, part.color);
                parts.add(right);
            }

            if (!parts.isEmpty()) {
                parts.stream().forEach(obj -> {
                    queue.add(obj);
                });
            }

            Part newPart = queue.remove();
            image[newPart.sr][newPart.sc] = newColor;

        }

        return image;
    }

    /**
     * dfs算法遍历
     * @param image
     * @param sr
     * @param sc
     * @param newColor
     * @return
     */
    public int[][] floodFill2(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];

        dfs(image, sr, sc, newColor, oldColor);
        return image;
    }

    public void dfs(int[][] image, int sr, int sc, int newColor, int oldColor){
        if (newColor == image[sr][sc]){
            return;
        }

        image[sr][sc] = newColor;

        if (sr > 0 && oldColor == image[sr-1][sc]){
            dfs(image, sr-1, sc, newColor, oldColor);
        }
        if (sr < image.length-1 && oldColor == image[sr+1][sc]){
            dfs(image, sr+1, sc, newColor, oldColor);
        }
        if (sc > 0 && oldColor == image[sr][sc-1]){
            dfs(image, sr, sc-1, newColor, oldColor);
        }
        if (sc < image[sr].length-1 && oldColor == image[sr][sc+1]){
            dfs(image, sr, sc+1, newColor, oldColor);
        }
    }
}
