public class Solution {
    public boolean canPartition(int[] A) {
        if (A == null || A.length == 0) {
            return false;
        }

        int N = A.length;
        long S = 0;
        for (int i = 0; i < N; i++) {
            S += A[i];
        }

        if ((S & 1) == 1) {
            return false;
        }

        long T = S >> 1;
        boolean[][] F = new boolean[N][(int) (T + 1)];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= T; j++) {
                if (i == 0) {
                    F[i][j] = (j == 0);
                } else {
                    if (j >= A[i]) {
                        F[i][j] = F[i - 1][(int) (j - A[i])] || F[i - 1][j];
                    } else {
                        F[i][j] = F[i - 1][j];
                    }
                }
            }
        }

        return F[N - 1][(int) T];
    }
}
