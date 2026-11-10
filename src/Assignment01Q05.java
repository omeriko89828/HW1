public class Assignment01Q05 {
    public static int findShortestPath(int[][] m, int i, int j) {
        if (i == j) return 0;
        int n = m.length;
        int [] dist = new int[n];
        for (int v = 0; v < n; v++) dist [v] = -1;
        int[] queue = new int[n];
        int head = 0, tail = 0;
        dist[i] = 0;
        queue[tail++] = i;
        while (head < tail) {
            int cur = queue[head++];
            for (int next = 0; next < n; next++) {
                if (m[cur][next] == 1 && dist[next] == -1) {
                    dist[next] = dist[cur] + 1;
                    queue[tail++] = next;
                    if (next == j) return dist[next];
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(
            findShortestPath(new int[][]{{0,0,0}, {0,0,0}, {0,0,0}}, 0, 1)); // -1
        System.out.println(
            findShortestPath(new int[][]{{0,0,0}, {0,0,0}, {0,0,0}}, 1, 1)); // 0
        System.out.println(
            findShortestPath(new int[][]{{0,1,0,0}, {0,0,1,0}, {0,0,0,1}, {1,0,0,0}}, 0, 2)); // 2
        System.out.println(
            findShortestPath(new int[][]{{0,1,0,1}, {0,0,0,1}, {0,0,0,0}, {0,0,1,0}}, 0, 2)); // 2
    }
}