package com.example.demo.Repository;

import com.example.demo.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Andriansyah YR on 7/29/2017.
 */
@Component
public interface UserJpaRespository extends JpaRepository<Users, Long>{

    Users findByName(String name);

    @Query(value = "select * from users c where c.team_name = :team_name", nativeQuery=true)
    List<Users> findByTeamName(@Param("team_name") String team_name);
}
