package interpreterpattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * 场景类
 *
 * 运行方法举例：
 * 输入a+b-c,Enter；
 * 输入a的值，Enter；
 * 输入b的值，Enter；
 * 输入c的值，Enter；
 * 出结果。
 *
 */
public class Client {
    public static void main(String[] args) throws IOException{
        String expStr = getExpStr();
        //赋值
        HashMap<String,Integer> var = getValue(expStr);
        Calculator cal = new Calculator(expStr);
        System.out.println("运算结果为：" + expStr + "=" + cal.run(var));
    }
    //获得表达式
    public static String getExpStr() throws IOException{
        System.out.println("请输入表达式：");
        return (new BufferedReader(new InputStreamReader(System.in))).readLine();
    }
    //获得值映射
    public static HashMap<String,Integer> getValue(String expStr) throws IOException{
        HashMap<String,Integer> map = new HashMap<>();
        //解析有几个参数要传递
        for (char ch:expStr.toCharArray()){
            if (ch != '+' && ch != '-'){
                //解决重复参数的问题
                if (!map.containsKey(String.valueOf(ch))){
                    String in = (new BufferedReader(new InputStreamReader(System.in))).readLine();
                    map.put(String.valueOf(ch),Integer.valueOf(in));
                }
            }
        }
        return map;
    }
}
