package io.sowmoussa.ipl.repository;

import org.springframework.data.repository.CrudRepository;
import io.sowmoussa.ipl.model.Team;

public interface TeamRepository extends CrudRepository<Team, Long> {
    
    Team findByTeamName(String teamName);
}
