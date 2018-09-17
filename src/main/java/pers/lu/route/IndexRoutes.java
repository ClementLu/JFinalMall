package pers.lu.route;

import com.jfinal.config.Routes;

import pers.lu.controller.IndexController;

public class IndexRoutes extends Routes {

    @Override
    public void config() {
        setBaseViewPath("index");
        add("/index",IndexController.class);
    }

}
