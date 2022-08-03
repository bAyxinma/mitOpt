package com.example.mit_lvyou.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mit_lvyou.entity.TravelInfoBean;
import com.example.mit_lvyou.entity.UserBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<UserBean> {
    @Select("select * from user_table as user join travel_table as travel on user.user_id = travel.userid where user.user_id = #{userId}")
    TravelInfoBean selectUserTravelById(Integer userId);

    @Select("select * from user_table")
    List<UserBean> selectAllUser();

    @Select("select * from user_table where nickname = #{nickName}")
    UserBean selectUserByNickName(String nickName);
}
