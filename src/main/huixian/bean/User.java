package main.huixian.bean;

/**
 * Created by ASUS on 2017/11/3.
 */
public class User {
    private Integer id;
    private String name;
    private String file;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPic() {
        return file;
    }

    public void setPic(String pic) {
        this.file = pic;
    }

    @Override
    public String toString() {
        return "用户名："+getName()+ " --  图片："+getPic();
    }
}
