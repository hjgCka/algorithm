package com.hjg.plain.algorithm.fundamental;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * 二分查找法。
 * 通过idea的edit configurations，设置工作目录，启动参数，重定向参数。
 * @description:
 * @author: hjg
 * @createdOn: 2021/3/15
 */
public class BinarySearch {

    public static int indexOf(int key, int[] a) {
        int lo = 0;
        int hi = a.length - 1;

        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(key < a[mid]) {
                hi = mid - 1;
            } else if (key > a[mid]) {
                lo = mid + 1;
            } else {
                //返回索引
                return mid;
            }
        }

        //找不到返回-1
        return -1;
    }

    public static void main(String[] args) {

        //ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        //使用ClassLoader的话，不能加上'/'表示根classpath
        //CladdLoadern能识别的类路径不以'/'开头，但是可以使用'/'分隔
        //URL url = classLoader.getResource(args[0]);

        //使用Class获取资源时，需要加上'/'表示根classpath
        //实际会将'/'移除，并使用ClassLoader加载
        //如果不加上'/'，则会解析为com/hjg/plain/algorithm/fundamental/tinyW.txt路径，但是文件实际是与com目录同一层级
        //URL url = BinarySearch.class.getResource(args[0]);

        In in = new In(args[0]);
        int[] whiteList = in.readAllInts();

        Arrays.sort(whiteList);

        //手动输入数字，使用ctrl+d结束
        while(!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            if(indexOf(key, whiteList) < 0) {
                //打印找不到索引的数字(即tinyT.txt文件中的，不在tinyW.txt内的数字)
                StdOut.println(key);
            }
        }
    }
}
