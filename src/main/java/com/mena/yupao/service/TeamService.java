package com.mena.yupao.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mena.yupao.model.domain.Team;
import com.mena.yupao.model.domain.User;
import com.mena.yupao.model.dto.TeamQuery;
import com.mena.yupao.model.request.TeamJoinRequest;
import com.mena.yupao.model.request.TeamUpdateRequest;
import com.mena.yupao.model.vo.TeamUserVO;

import java.util.List;

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

    /**
     * 搜索队伍
     *
     * @param teamQuery
     * @param isAdmin
     * @return
     */
    List<TeamUserVO> listTeams(TeamQuery teamQuery, boolean isAdmin);

    /**
     * 更新队伍
     *
     * @param teamUpdateRequest
     * @param loginUser
     * @return
     */
    boolean updateTeam(TeamUpdateRequest teamUpdateRequest, User loginUser);

    /**
     * 加入队伍
     * @param teamJoinRequest
     * @return
     */
    boolean joinTeam(TeamJoinRequest teamJoinRequest, User loginUser);
}
