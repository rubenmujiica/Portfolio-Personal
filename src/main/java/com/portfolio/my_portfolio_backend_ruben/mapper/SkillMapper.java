package com.portfolio.my_portfolio_backend_ruben.mapper;

import com.portfolio.my_portfolio_backend_ruben.dto.SkillDto;
import com.portfolio.my_portfolio_backend_ruben.model.Skill;

public class SkillMapper {

    public static SkillDto toDto(Skill skill){
        if(skill==null){
            return null;
        }
        SkillDto skillDto = new SkillDto();

        skillDto.setId(skill.getId());
        skillDto.setName(skill.getName());
        skillDto.setLevelPercentage(skill.getLevelPercentage());
        skillDto.setIconClass(skill.getIconClass());
        skillDto.setPersonalInfoId(skill.getPersonalInfoId());

        return skillDto;
    }

    public static Skill toEntity(SkillDto dto){
        if(dto==null){
            return null;
        }
        Skill skill = new Skill();

        skill.setId(dto.getId());
        skill.setName(dto.getName());
        skill.setLevelPercentage(dto.getLevelPercentage());
        skill.setIconClass(dto.getIconClass());
        skill.setPersonalInfoId(dto.getPersonalInfoId());

        return skill;
    }
}
