package cls;

//public class UTF8Coding {
    /*
     *手工编写 UTF-8编码
     * Char. number range  |        UTF-8 octet sequence
      (hexadecimal)    |              (binary)
   --------------------+---------------------------------------------
   0000 0000-0000 007F | 0xxxxxxx
   0000 0080-0000 07FF | 110xxxxx 10xxxxxx
   0000 0800-0000 FFFF | 1110xxxx 10xxxxxx 10xxxxxx
   0001 0000-0010 FFFF | 11110xxx 10xxxxxx 10xxxxxx 10xxxxxx
     */

    /**
     * 将一个字符串编码为 UTF-8字节数组
     *
     * @param str 被编码的字符串
     * @return 经过UTF-8以后字节数组
     */
//    public static byte[] getBytes(String str) {
//        //预估一下返回值的最大情况
//        byte[] bytes = new byte[str.length() * 4];
//        //index代表 bytes 数组中数据的存储位置
//        int index = 0;
//        //遍历字符串中每个字符，根据字符的Unicode编码范围，进行编码
//        //将编码存储的bytes,bytes中就是返回值UTF-8数据
//        for (int i = 0; i < str.length(); i++) {
//            char c = str.charAt(i);
//            //判断c范围，根据范围进行编码
//            //c在 0 到 0x7F范围内，是1字节编码，1字节编码添加到bytes
//            if (c <= 0x7F) {
//                bytes[index++] = (byte) c;
//            }
//            return bytes;
//
//

