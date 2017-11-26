package main.huixian.dao;

import main.huixian.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

/**
 * Created by ASUS on 2017/11/3.
 */
public interface UserMapper {

    @Insert({"insert into user (id,name,pic) values (#{id},#{name},#{pic})"})

    public void add(User user);



}
