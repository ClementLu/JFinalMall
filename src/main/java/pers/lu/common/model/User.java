package pers.lu.common.model;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.jfinal.plugin.activerecord.Model;

import pers.lu.tool.GlobalTool;


/**
 * @author 卢一丹
 * @see User通过继承Model，便立即拥有的众多方便的操作数据库的方法。<br>
 *      在User中声明的dao静态对象是为了方便查询操作而定义的，该对象并不是必须的。<br>
 *      基于ActiveRecord的Model无需定义属性，无需定义getter、setter方法，无需XML配置，无需Annotation配置，极大降低了代码量。
 */
public class User extends Model<User>{

    /**
     * serialVersionUID适用于Java的序列化机制。<br>
     * 简单来说，Java的序列化机制是通过判断类的serialVersionUID来验证版本一致性的。<br>
     * 在进行反序列化时，JVM会把传来的字节流中的serialVersionUID与本地相应实体类的serialVersionUID进行比较，<br>
     * 如果相同就认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的异常，即是InvalidCastException。<br>
     */
    private static final long serialVersionUID = 1L;
    public static final User dao = new User();

    public static String TableName() {
        return "t_user";
    }

    // 检查邮箱是否存在
    public static boolean isExistEmail(String email) {
        if (StringUtils.isBlank(email)) {
            return false;
        }
        List<User> userList = User.dao.find("SELECT * FROM t_user WHERE email = ?", email);
        if (userList.size() == 1)
            return true;
        else
            return false;
    }

/*    public static boolean isExistEmail(String email) {
        if (StringUtils.isBlank(email)) {
            return false;
        }
        List<User> userList = User.dao.find("SELECT * FROM t_user WHERE email = ?", email);
        if (userList.size() == 1) {
            return true;
        } else {
            return false;
        }
    }*/

    // 检查邮箱和密码是否存在
    public static boolean CheckLogin(User user) {
        String email = user.getStr("email").trim();
        String password = user.getStr("password").trim();
        String password_md5 = GlobalTool.md5_encode(password);

        if (StringUtils.isBlank(email) || StringUtils.isBlank(password))
            return false;

        List<User> userList = User.dao.find("SELECT * FROM t_user WHERE email = ? AND password = ?", email, password);
        // 由于注册的时候的密码没有写成使用MD5算法加密，因此下面的检测无法进行
        //List<User> userList = User.dao.find("SELECT * FROM t_user WHERE email = ? AND password = ?", email, password_md5);
        if (userList.size() == 1)
            return true;
        else
            return false;
    }

    /*public static boolean CheckLogin(User user) {
        String email = user.getStr("email").trim();
        String password = user.getStr("password").trim();
        String password_md5 = GlobalTool.md5_encode(password);
        if (StringUtils.isBlank(email) || StringUtils.isBlank(password)) {
            return false;
        }
        List<User> userList = User.dao.find("SELECT * FROM adou_user WHERE email = ? AND password = ?", email,
                password_md5);
        if (userList.size() == 1) {
            return true;
        } else {
            return false;
        }
    }*/

}
