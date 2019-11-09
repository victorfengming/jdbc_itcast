package cn.itcast.util;

import java.util.Scanner;

/**
 * @author victor
 * @site https://victorfengming.github.io/
 * @company XDL
 * @project xdl_exam_system
 * @package cn.itxdl.util
 * @created 2019-11-07 9:26
 * @function ""
 */
public class python {
    // 提供Scanner类行的引用并进行初始化
    private static Scanner sc = new Scanner(System.in);
    // 提供Scanner类行的引用并进行初始化

    /**
     * 用于模拟python中的input函数,OK
     *
     * @param tip
     * @return
     */
    public static String input(String tip) {
        System.out.print(tip);
        return sc.nextLine();
    }

    /**
     * 用于模拟python中的str.isDigit函数,判断字符串是不是数字
     *
     * @param string
     * @return 布尔类型
     */
    public static Boolean isDigit(String string) {
        char[] charArray = string.toCharArray();
        for (char c : charArray) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 用于打印对象
     *
     * @param ob
     */
    public static void print(Object ob) {
        System.out.println(ob);
    }

    /**
     * 用于输入整数的校验
     *
     * @param tip
     * @return
     */
    public static Integer input_int(String tip) {
        while (true) {
            System.out.print(tip);
            String res = sc.next();
            if (isDigit(res)) {
                int i = Integer.parseInt(res);
                return i;
            }
            System.out.println("[系统提示]:您输入的有瑕疵,请重新输入!");
        }
    }

    public static Integer input_int_range(String tip, Integer min, Integer max) {

        while (true) {
            Integer index = input_int(tip);
            // 这里要加范围验证
            if (min <= index && index < max) {
                return index;
            }
            python.print("您输入的序号不在范围,请重新输入!");
        }
    }


}
