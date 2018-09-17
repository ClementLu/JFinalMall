package pers.lu.tool;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.codec.digest.DigestUtils;

public class GlobalTool {
    public static String md5_encode(String password) {
        if (StringUtils.isBlank(password))
            return null;
        else return DigestUtils.md5Hex(password);
    }

}
