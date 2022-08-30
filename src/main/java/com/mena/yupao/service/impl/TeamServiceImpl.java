package com.mena.yupao.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mena.yupao.mapper.TeamMapper;
import com.mena.yupao.model.domain.Team;
import com.mena.yupao.service.TeamService;
import org.springframework.stereotype.Service;

/**
* @author Mena
* @description 针对表【team(队伍)】的数据库操作Service实现
* @createDate 2022-08-30 12:01:00
*/
@Service
public class TeamServiceImpl extends ServiceImpl<TeamMapper, Team>
    implements TeamService {

}




