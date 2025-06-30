package br.com.ulbra.AP2.services;

import br.com.ulbra.AP2.models.Team;
import br.com.ulbra.AP2.repositories.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {
    private TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public List<Team> getTeams(){
        return this.teamRepository.getTeams();
    }

    public Team getTeam(Long id){
        return this.teamRepository.getTeam(id);
    }

    public void deleteTeam(Long id){
        this.teamRepository.deleteTeam(id);
    }

    public Team createTeam(Team team){
        return this.teamRepository.createTeam(team);
    }

    public Team editTeam(Long id, Team team){
        return this.teamRepository.editTeam(id, team);
    }
}
