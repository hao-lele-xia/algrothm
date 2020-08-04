package xia.v.lan.algrothm.recursive;

import java.util.HashMap;
import java.util.Vector;

/**
 * @author chenhao
 * @description <p>
 * created by chenhao 2020/6/17 13:56
 */
public class CoinChange {

    /**
     * 给你 k 种面值的硬币，面值分别为 c1, c2 ... ck，每种硬币的数量无限，再给一个总金额 amount，
     * 问你最少需要几枚硬币凑出这个金额，如果不可能凑出，算法返回 -1
     * @param coins
     * @param amount
     * @return
     */
    int coinChange(int[] coins,int amount){
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int coin : coins) {
                if(i-coin < 0){
                    continue;
                }
                dp[i] = Math.min(dp[i],1 + dp[i-coin]);
            }
        }
        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        Integer i = 1;
        Integer a = i;
        System.out.println(a.hashCode() == i.hashCode());
        a--;
        System.out.println(a.hashCode() == i.hashCode());
        System.out.println(i);
        System.out.println(a);
    }

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
}
