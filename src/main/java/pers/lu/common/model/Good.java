package pers.lu.common.model;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;

public class Good extends Model<Good> {
    private static final long serialVersionUID = 1L;

    public static final Good dao = new Good();

    private static String TableName() {
        return "t_goods";
    }

    // 这里体会到了jfinal的强大之处，mysql和oracle的分页都只需下面这一句
    public Page<Good> paginate(int pageNumber, int pageSize) {
        return paginate(pageNumber, pageSize, "select * ", "from t_goods order by id asc");
    }
}
