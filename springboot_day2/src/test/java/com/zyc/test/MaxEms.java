package com.zyc.test;

import org.junit.Test;

import java.text.DateFormatSymbols;

public class MaxEms {

    private static int knd = 5;//邮票种类
    private static int lim = 4;//限制张数
    private static int cnt = 0;//当前邮票种类
    private static int max = 0;//存储邮资最大区间
    private static int[] x = new int[100];//当前邮票面值
    private static int[] r = new int[100];//最终的最优结果
    private static int[][] C = new int [100][10000];//记录搜索结点状态

    public static void dfs(){
        if (cnt == knd) {//判断 当前 的邮票种类 是否等于 最大种类数 也就是已经获取全部的票
            if (x[cnt] * lim < max) //做一个限制 如果当前 所有面值 中的最大值 * 限制张数 都小于 max 那几个数 可定不是 最优解
                return;
            int tmp = findMax(); //算出 当前 所有面值 所获得的最大面区间的 给 max
            if (tmp > max) {
                max = tmp;
                for (int i = 1; i <= knd; i++)  //把面值 赋值给  村结果的数组
                    r[i] = x[i];
            }
        }else {
            int tmp = findMax(); //获取 当前 票面的 最大值
            // 下面用公式  ：x[i]的可取值范围是[x[i-1]+1:r+1]
            for (int i = x[cnt] + 1; i <= tmp + 1; i++) {//下一层结点的面值的可能取值
                x[++cnt] = i;//将可能面值加入当前面值组合中
                dfs();
                cnt--; // 走完 这一趟 dfs  恢复下标
            }
        }
    }

    public static int findMax(){ //计算  现有 x[] 中的最大邮资区间
        int j = 1;
        //向下DP
        while (C[cnt - 1][j] != 0) { //遍历表中上一行  为 下一行 赋值

            //判断 当前票面是否大于值 || 比较 当前点 的上方 和 当前点的 总面值 -减去当前面值 的差  的最优解 +1
            //C[cnt][j - x[cnt]] 代表 当前点的 总面值 - 减去当前面值 的差  的票数
            //C[cnt - 1][j]代表 无当前面值时 获得此时 总面值的 最票数
            if (j < x[cnt] || C[cnt - 1][j] <= C[cnt][j - x[cnt]] + 1)
                C[cnt][j] = C[cnt - 1][j];
            else
                C[cnt][j] = C[cnt][j - x[cnt]] + 1;
            j++;
        }

        //向右DP
        while (true) {
            int tmp = Integer.MAX_VALUE;//赋值为 最大值  存放  邮票张数
            for (int i = 1; i <= cnt; i++) {
                if (tmp > C[cnt][j - x[i]] + 1)
                    tmp = C[cnt][j - x[i]] + 1;////C[cnt][j - x[cnt]] 代表 当前点的 总面值 - 减去当前面值 的差  的票数
            }
            if (tmp == Integer.MAX_VALUE || tmp > lim) //最限制  当temp等于最大值  或者 大于最大张数 结束
                break;
            else
                C[cnt][j] = tmp;
            j++;
        }
        C[cnt][j] = 0;
        return j - 1;
    }

    public static void main(String[] args) {

        x[1] = 1; //已知 第一个 面值  为  1
        cnt = 1;  //因为  已知  第一个面值为  1 所以 现在 种类数  为 1；
        dfs(); //调用深搜   跑 算法   走你..
        System.out.println(max);
        for (int i = 1; i <= knd; i++)
            System.out.print(r[i] + " ");
        System.out.println();
    }


}
