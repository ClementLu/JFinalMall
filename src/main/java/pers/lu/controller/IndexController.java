package pers.lu.controller;

import com.jfinal.config.Plugins;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Page;

import pers.lu.common.model.Good;
import pers.lu.common.model.User;

public class IndexController extends Controller {
    public void index() {
        // 参数二为默认值，即当msg为空时，取defaultValue为msg的值
        // URL范例：http://localhost:8080/index?msg=123
        // String msg = getPara("msg", "defaultValue");

        // msg要在前端显示的话需要写成#(msg)
        // setAttr("msg", "Hello World!" + msg);

        // getParaToInt(0, 1)的意思是取得第一个参数值，没有的话默认为1
        // 记得绑定Model，即在public void configPlugin(Plugins arg0)中添加
        Page<Good> goodList = Good.dao.paginate(getParaToInt(0, 1), 10);
        setAttr("goodList", goodList);

        // 渲染名为 test.html 的视图，且视图类型为 JFinal Template
        // renderTemplate("/WEB-INF/index.html");

        // 商品主页面
        // renderJson(goodList);
         render("/index.jsp");
    }

}
