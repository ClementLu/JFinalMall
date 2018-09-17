package pers.lu.route;

import com.jfinal.config.Routes;

import pers.lu.controller.ActionController;

public class ActionRoutes extends Routes {
    @Override
    public void config() {
        this.add("/action", ActionController.class);
    }
}
