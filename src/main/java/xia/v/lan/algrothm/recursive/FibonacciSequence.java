package xia.v.lan.algrothm.recursive;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenhao
 * @description <p>
 * created by chenhao 2020/6/16 17:09
 * 斐波那契数列
 */
public class FibonacciSequence {

    static int fib1(int n){
        if(n == 1 || n == 2){
            return 1;
        }
        return fib1(n-1) + fib1(n-2);
    }

    private static final Map<Integer,Integer> map = new HashMap<Integer,Integer>();

    static int fib2(int n){
        if(n == 1 || n == 2){
            return 1;
        }
        int result;
        if(map.get(n) == null){
            result = fib2(n - 1) + fib2(n - 2);
            map.put(n,result);
            return result;
        }else{
            return map.get(n);
        }
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(fib1(n));
        System.out.println(fib2(n));
    }
}
