package com.budwk.nb.commons.utils;

import org.nutz.lang.Lang;
import org.nutz.lang.Strings;
import org.nutz.mvc.Mvcs;

import javax.servlet.http.HttpServletRequest;
import java.util.Random;

/**
 * @author wizzer(wizzer@qq.com) on 2018/3/17.
 */
public class StringUtil {
    private static final String PATH_SEPARATOR = "?";
    private static final int PATH_LENGTH = 4;

    /**
     * 获取平台当前登录用户的所在单位
     *
     * @return
     */
    public static String getPlatformUserUnitid() {
        try {
            HttpServletRequest request = Mvcs.getReq();
            if (request != null) {
                return Strings.sNull(request.getSession(true).getAttribute("platform_unitid"));
            }
        } catch (Exception e) {

        }
        return "";
    }

    /**
     * 获取平台后台登陆UID
     *
     * @return
     */
    public static String getPlatformUid() {
        try {
            HttpServletRequest request = Mvcs.getReq();
            if (request != null) {
                return Strings.sNull(request.getSession(true).getAttribute("platform_uid"));
            }
        } catch (Exception e) {

        }
        return "";
    }

    /**
     * 获取平台后台登陆用户名称
     *
     * @return
     */
    public static String getPlatformLoginname() {
        try {
            HttpServletRequest request = Mvcs.getReq();
            if (request != null) {
                return Strings.sNull(request.getSession(true).getAttribute("platform_loginname"));
            }
        } catch (Exception e) {

        }
        return "";
    }

    /**
     * 获取平台后台登陆用户名称
     *
     * @return
     */
    public static String getPlatformUsername() {
        try {
            HttpServletRequest request = Mvcs.getReq();
            if (request != null) {
                return Strings.sNull(request.getSession(true).getAttribute("platform_username"));
            }
        } catch (Exception e) {

        }
        return "";
    }

    /**
     * 去掉URL中?后的路径
     *
     * @param p
     * @return
     */
    public static String getPath(String p) {
        if (Strings.sNull(p).contains(PATH_SEPARATOR)) {
            return p.substring(0, p.indexOf(PATH_SEPARATOR));
        }
        return Strings.sNull(p);
    }

    /**
     * 获得父节点ID
     *
     * @param s
     * @return
     */
    public static String getParentId(String s) {
        if (!Strings.isEmpty(s) && s.length() > PATH_LENGTH) {
            return s.substring(0, s.length() - PATH_LENGTH);
        }
        return "";
    }

    /**
     * 得到n位随机数
     *
     * @param s
     * @return
     */
    public static String getRndNumber(int s) {
        Random ra = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s; i++) {
            sb.append(String.valueOf(ra.nextInt(8)));
        }
        return sb.toString();
    }

    /**
     * 判断是否以字符串开头
     *
     * @param str
     * @param s
     * @return
     */
    public static boolean startWith(String str, String s) {
        return Strings.sNull(str).startsWith(Strings.sNull(s));
    }

    /**
     * 判断是否包含字符串
     *
     * @param str
     * @param s
     * @return
     */
    public static boolean contains(String str, String s) {
        return Strings.sNull(str).contains(Strings.sNull(s));
    }

    /**
     * 生成userToken字符串
     *
     * @param user_id
     * @param create_at
     * @param key
     * @return
     */
    public static String generateUserToken(String user_id, long create_at, String key) {
        return Lang.md5(user_id + create_at + key);
    }
}
