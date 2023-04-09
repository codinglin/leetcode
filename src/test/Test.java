package test;

import java.io.*;
import java.util.*;

public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            int x = in.nextInt();
            int y = in.nextInt();
            int[] score = new int[n];
            for (int i = 0; i < n; i++) {
                score[i] = in.nextInt();
            }
            Arrays.sort(score);
            // 淘汰数量
            int t = n - y;
            if(t > y) {
                System.out.println(-1);
            } else if (t >= x) {
                System.out.println(score[n - y - 1]);
            } else {
                System.out.println(score[x - 1]);
            }
        }
    }
}

class Test1{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < a.length; i++) {
                a[i] = in.nextInt();
            }
            Arrays.sort(a);
            int sum = 0;
            for (int i = 0; i < a.length; i++) {
                sum += Math.abs(a[i] - (i+1));
            }
            System.out.println(sum);
        }
    }
}


class Test2{
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(reader.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(reader.readLine());
            String tables = reader.readLine();
            int M = Integer.parseInt(reader.readLine());
            String enters = reader.readLine();

            int[] res = solve(tables, enters);
            for (int r : res) {
                writer.write(Integer.toString(r));
                writer.newLine();
            }
        }
        writer.flush();
    }

    private static int[] solve(String tables, String enters) {
        List<PriorityQueue<Integer>> pqs = new ArrayList<>(3);
        pqs.add(new PriorityQueue<>());
        pqs.add(new PriorityQueue<>());
        pqs.add(new PriorityQueue<>());
        for (int i = 0; i < tables.length(); i++) {
            pqs.get(tables.charAt(i) - '0').add(i);
        }
        int[] res = new int[enters.length()];
        for (int i = 0; i < enters.length(); i++) {
            int table;
            if (enters.charAt(i) == 'M') {
                if (pqs.get(1).isEmpty()) {
                    table = pqs.get(0).poll();
                    pqs.get(1).add(table);
                } else {
                    table = pqs.get(1).poll();
                    pqs.get(2).add(table);
                }
            } else {
                if (!pqs.get(0).isEmpty()) {
                    table = pqs.get(0).poll();
                    pqs.get(1).add(table);
                } else {
                    table = pqs.get(1).poll();
                    pqs.get(2).add(table);
                }
            }
            res[i] = table + 1;
        }

        return res;
    }
}

class Test3{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int[][][] dp = new int[n][n][n];
        for (int i = 0; i < n - 1; i++) {
            dp[i][i + 1][i] = arr[i] * arr[i + 1];
            dp[i][i + 1][i + 1] = dp[i][i + 1][i];
        }
        for (int k = 2; k < n; k++) {
            for (int i = 0; i < n - k; i++) {
                for (int m = i; m <= i + k; m++) {
                    int left = i == m ? 0 : dp[i][m - 1][i] + arr[i] * arr[m];
                    for (int l = i + 1; l < m; l++) {
                        left = Math.min(left, dp[i][m - 1][l] + arr[l] * arr[m]);
                    }
                    int right = m == i + k ? 0 : dp[m + 1][i + k][i + k] + arr[i + k] * arr[m];
                    for (int r = m + 1; r < i + k; r++) {
                        right = Math.min(right, dp[m + 1][i + k][r] + arr[r] * arr[m]);
                    }
                    dp[i][i + k][m] = left + right;
                }
            }
        }
        int res = dp[0][n - 1][0];
        for (int i = 1; i < n; i++) {
            res = Math.min(res, dp[0][n - 1][i]);
        }
        System.out.println(res);
    }
}

class Test4{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return numSum(o1) - numSum(o2);
                }
            });
            for (int i = 1; i <= n; i++) {
                queue.add(i);
            }
            for (int i = 1; i <= m - 1; i++) {
                queue.poll();
            }
            System.out.println(queue.peek());
        }
    }

    private static int numSum(int x) {
        int sum = 0;
        while (x != 0) {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }
}
