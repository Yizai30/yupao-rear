package com.mena.yupao.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mena.yupao.model.domain.Team;
import com.mena.yupao.model.domain.User;

/**
* @author Mena
* @description 针对表【team(队伍)】的数据库操作Service
* @createDate 2022-08-30 12:01:00
*/
public interface TeamService extends IService<Team> {

    /**
     * 创建队伍
     *
     * @param team
     * @param loginUser
     * @return
     */
    long addTeam(Team team, User loginUser);
}
