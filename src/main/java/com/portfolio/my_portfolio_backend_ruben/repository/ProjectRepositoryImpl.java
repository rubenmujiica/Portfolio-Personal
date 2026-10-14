package com.portfolio.my_portfolio_backend_ruben.repository;

import com.portfolio.my_portfolio_backend_ruben.model.Project;
import com.portfolio.my_portfolio_backend_ruben.model.Skill;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ProjectRepositoryImpl implements IProjectRepository {

    private final JdbcTemplate jdbcTemplate;

    private final RowMapper<Project> projectRowMapper = (rs, numRow) ->{
        Project project = new Project();
        project.setId(rs.getLong("id"));
        project.setTitle(rs.getString("title"));
        project.setDescription(rs.getString("description"));
        project.setImageUrl(rs.getString("image_url"));
        project.setProjectUrl(rs.getString("project_url"));
        project.setPersonalInfoId(rs.getLong("personal_info_id"));
        return project;
    };

    @Override
    public List<Project> findAll() {
        String sql = "Select * From projects";
        return jdbcTemplate.query(sql, projectRowMapper);
    }

    @Override
    public Optional<Project> findById(Long id) {
        String sql = "Select * From projects Where id = ?";
        try{
            return Optional.ofNullable(jdbcTemplate.queryForObject(sql, projectRowMapper, id));
        }catch (EmptyResultDataAccessException e){
            return Optional.empty();
        }
    }

    @Override
    public Project save(Project project) {
        //Crear si no hay ID
        if(project.getId()==null){
            String sql = "INSERT INTO projects (title, description, image_url, project_url, personal_info_id) " +
                    "VALUES (?, ?, ?, ?, ?)";
            KeyHolder keyHolder = new GeneratedKeyHolder();

            jdbcTemplate.update( connection -> {
                PreparedStatement ps = connection.prepareStatement(sql, new String []{"id"});
                ps.setString(1, project.getTitle());
                ps.setString(2, project.getDescription());
                ps.setString(3, project.getImageUrl());
                ps.setString(4, project.getProjectUrl());
                ps.setLong(5, project.getPersonalInfoId());
                return ps;
            }, keyHolder);

            project.setId(Objects.requireNonNull(keyHolder.getKey()).longValue());
        }else{
            String sql = "UPDATE projects SET title=?, description=?, image_url=?, project_url=?, personal_info_id=? WHERE id=?";

            jdbcTemplate.update(sql,
                    project.getTitle(),
                    project.getDescription(),
                    project.getImageUrl(),
                    project.getProjectUrl(),
                    project.getPersonalInfoId(),
                    project.getId()
            );
        }
        return project;
    }

    @Override
    public void deleteById(Long id) {
        String sql = "Delete From projects Where id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public List<Project> findByPersonalInfoId(Long personalInfoId) {
        String sql = "Select * From projects Where personal_info_id=?";
        return jdbcTemplate.query(sql, projectRowMapper, personalInfoId);
    }
}
