package cls;

import java.nio.charset.StandardCharsets;

public class UtfDemo {
    public static void main(String[] args) {
        /*
        测试UTF-8编解码API
         */
        String str = "Javaλ表达式";
        //将字符串中的文字进行UTF-8编码
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        //将字节数组中的UTF-8编码的字符进行解码
        //new String(bytes,"UTF-8");
       String s = new String(bytes, StandardCharsets.UTF_8);
       System.out.println(s);
    }
}