class Solution:
    def peopleAwareOfSecret(self, n: int, delay: int, forget: int) -> int:
        MOD = 10**9 + 7
        
        discover = [0] * (n + 1)
        share = [0] * (n + 1)
        forget_count = [0] * (n + 1)
        
        discover[1] = 1
        share[1] = 1
        
        for i in range(2, n + 1):
            if i - delay >= 1:
                discover[i] = share[i - delay] % MOD
            
            share[i] = (discover[i] + share[i - 1]) % MOD
            if i - forget >= 1:
                share[i] = (share[i] - discover[i - forget + 1]) % MOD
            
            if i - forget + 1 >= 1:
                forget_count[i] = discover[i - forget + 1] % MOD
        
        return (share[n] - forget_count[n]) % MOD

