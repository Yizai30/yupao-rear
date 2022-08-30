package com.mena.yupao.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mena.yupao.mapper.UserTeamMapper;
import com.mena.yupao.model.domain.UserTeam;
import com.mena.yupao.service.UserTeamService;
import org.springframework.stereotype.Service;

/**
* @author Mena
* @description 针对表【user_team(用户队伍关系)】的数据库操作Service实现
* @createDate 2022-08-30 12:01:36
*/
@Service
public class UserTeamServiceImpl extends ServiceImpl<UserTeamMapper, UserTeam>
    implements UserTeamService {

}




