public class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return -1;
        }

        int N = coins.length;
        int[][] F = new int[N][amount + 1];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= amount; j++) {
                F[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int j = 1; coins[0] != 0 && j <= amount; j++) {
            if (j % coins[0] == 0) {
                F[0][j] = j / coins[0];
            } else {
                F[0][j] = -1;
            }
        }

        for (int i = 0; i < N; i++) {
            F[i][0] = 0;
        }

        for (int i = 1; i < N; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j >= coins[i]) {
                    if (F[i][j - coins[i]] == -1 && F[i - 1][j] == -1) {
                        F[i][j] = -1;
                    } else {
                        if (F[i][j - coins[i]] != -1) {
                            F[i][j] = F[i][j - coins[i]] + 1;
                        }
                        if (F[i - 1][j] != -1) {
                            F[i][j] = Math.min(F[i][j], F[i - 1][j]);
                        }
                    }
                } else {
                    F[i][j] = F[i - 1][j];
                }
            }
        }

        return F[N - 1][amount] == Integer.MAX_VALUE ? -1 : F[N - 1][amount];
    }
}
