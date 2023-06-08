package com.example.wpclc.lc;

/**
 * @author wangpengcheng
 * @version 1.0
 * @Description
 * @date 2023/6/8 10:06
 */
public class LC468 {
    public String validIPAddress(String queryIP) {
        if (queryIP.indexOf('.') >= 0) {
            // IPv4
            int last = -1;
            for (int i = 0; i < 4; ++i) {
                // 首先，它找到每一部分的开始和结束位置。开始位置是上一部分结束位置之后的第一个字符，结束位置是这一部分的'.'的位置（对于最后一部分，结束位置是字符串的结束位置）。
                int cur = (i == 3 ? queryIP.length() : queryIP.indexOf('.', last + 1));
                if (cur < 0) {
                    return "Neither";
                }
                // 检查每一部分的长度。如果长度小于1或大于3，就返回"Neither"   192.168.1.1    3   7
                if (cur - last - 1 < 1 || cur - last - 1 > 3) {
                    return "Neither";
                }
                int addr = 0;
                // 检查每一部分的每一个字符。如果有任何一个字符不是数字，就返回"Neither"
                for (int j = last + 1; j < cur; ++j) {
                    if (!Character.isDigit(queryIP.charAt(j))) {
                        return "Neither";
                    }
                    addr = addr * 10 + (queryIP.charAt(j) - '0');
                }
                // 检查每一部分的数值。如果数值大于255，就返回"Neither"
                if (addr > 255) {
                    return "Neither";
                }
                // 检查每一部分的首字符。如果数值大于0但首字符是'0'，就返回"Neither"
                if (addr > 0 && queryIP.charAt(last + 1) == '0') {
                    return "Neither";
                }
                // 如果数值是0但这一部分的长度大于1，也返回"Neither"
                if (addr == 0 && cur - last - 1 > 1) {
                    return "Neither";
                }
                last = cur;
            }
            return "IPv4";
        } else {
            // IPv6
            int last = -1;
            for (int i = 0; i < 8; ++i) {
                //同样地，它首先找到每一部分的开始和结束位置。
                int cur = (i == 7 ? queryIP.length() : queryIP.indexOf(':', last + 1));
                if (cur < 0) {
                    return "Neither";
                }
                // 检查每一部分的长度。如果长度小于1或大于4，就返回"Neither"
                if (cur - last - 1 < 1 || cur - last - 1 > 4) {
                    return "Neither";
                }
                // 检查每一部分的每一个字符。如果有任何一个字符既不是数字也不是a-f或A-F，就返回"Neither
                for (int j = last + 1; j < cur; ++j) {
                    if (!Character.isDigit(queryIP.charAt(j))
                            && !('a' <= Character.toLowerCase(queryIP.charAt(j))
                            && Character.toLowerCase(queryIP.charAt(j)) <= 'f')) {
                        return "Neither";
                    }
                }
                last = cur;
            }
            return "IPv6";
        }

    }
}
