package pers.lu.controller;

import org.apache.commons.lang3.StringUtils;

import com.jfinal.core.Controller;

import pers.lu.common.model.User;

public class ActionController extends Controller {
    public void login() {
        renderTemplate("/login.jsp");
    }

    public void dologin() {
        String email = getPara("email").trim();
        String password = getPara("password").trim();
        User user = new User();
        user.set("email", email);
        user.set("password", password);

        if (StringUtils.isBlank(email))
            renderText("请输入邮箱地址！");
        if (StringUtils.isBlank(password))
            renderText("请输入密码！");

        if (!User.isExistEmail(email)) {
            renderText("邮箱不存在!");
            return;
        }
        if (!User.CheckLogin(user)) {
            renderText("密码错误!");
            return;
        }

        getSession(true).setAttribute("loginUser", user);
        forwardAction("/index");
    }

    // 输入http://localhost:8080/action/register时，跳转到register页面
    public void register() {
        renderTemplate("/register.jsp");
    }

    public void registerHandler() {
        /**
         * 可以在getModel中为User取一个别名，这个别名会被使用到前端的表单的name属性中。<br>
         * 如果希望传参时避免使用modelName 前缀，<br>
         * 可以使用空串作为modelName来实现：getModel(Blog.class, “”);<br>
         * 这对开发纯API 项目非常有用。
         */
        // System.out.println(getModel(User.class));

        // 使用getPara()最好写上默认值
        String email = getPara("email").trim();
        String password = getPara("password").trim();

        if (StringUtils.isBlank(email))
            renderText("请输入邮箱地址！");
        if (StringUtils.isBlank(password))
            renderText("请输入密码！");

        if (User.isExistEmail(email))
            renderText("邮箱已被注册！请输入其他邮箱！");
        // 使用空串作为modelName
        // new User().set("name", "James").set("age", 25)通过getModel已经做好了
        User user = getModel(User.class, "");
        user.save();
        // 由于post之后会有一个跳转，需要使用render()得到这个跳转。
        renderText("传值成功！");
    }
}
