package pers.lu.common;


import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.core.JFinal;
import com.jfinal.ext.handler.ContextPathHandler;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.render.ViewType;
import com.jfinal.template.Engine;

import pers.lu.common.model.Good;
import pers.lu.common.model.User;
import pers.lu.controller.IndexController;
import pers.lu.route.ActionRoutes;
import pers.lu.route.IndexRoutes;

public class DemoConfig extends JFinalConfig {

    public static void main(String[] args) {
        JFinal.start("src/main/webapp", 8080, "/");
    }

    @Override
    public void configConstant(Constants arg0) {
        // 读取配置文件，也可以使用PropKit
        PropKit.use("a_little_config.txt");
        arg0.setDevMode(true);
        arg0.setEncoding("UTF-8");
        // arg0.setViewType(ViewType.JSP);
    }

    @Override
    public void configRoute(Routes arg0) {
        // 控制个人中心
        arg0.add(new IndexRoutes());
        arg0.add(new ActionRoutes());
    }

    @Override
    public void configEngine(Engine arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void configHandler(Handlers arg0) {
        // 用于保证上下文正确，防止文件更新以后，样式表丢失
        arg0.add(new ContextPathHandler("ctx"));

    }

    @Override
    public void configInterceptor(Interceptors arg0) {

    }

    // 使用getModel()方法前必须要启动ARP
    @Override
    public void configPlugin(Plugins arg0) {
        // 根据键值对找到对应的值
        DruidPlugin druidPlugin = new DruidPlugin(PropKit.get("jdbcUrl"), PropKit.get("user"), PropKit.get("password"));
        arg0.add(druidPlugin);

        ActiveRecordPlugin arp = new ActiveRecordPlugin(druidPlugin);
        //数据库链接池
        arg0.add(arp);
        arp.addMapping("t_user", User.class);
        arp.addMapping("t_goods", Good.class);

        // 设置SqlTemplate的基准路径，SqlTemplate是一个sql文件，即建立数据库
        /*arp.setBaseSqlTemplatePath(PathKit.getWebRootPath() + "/WEB-INF");
        arp.addSqlTemplate("/sql/Mall.sql");*/
        

    }

}
