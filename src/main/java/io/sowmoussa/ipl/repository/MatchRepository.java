package io.sowmoussa.ipl.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import io.sowmoussa.ipl.model.Match;

public interface MatchRepository extends CrudRepository<Match, Long> {
    
    List<Match> getByTeam1OrTeam2OrderByDateDesc(String teamName1, String teamName2, Pageable pageable);
}
