package br.com.ulbra.AP2.repositories;

import br.com.ulbra.AP2.models.Player;
import br.com.ulbra.AP2.models.Team;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class TeamRepository {
    private List<Team> lista = new ArrayList<>();

    public TeamRepository(){
        lista.add(new Team(1L,"Team Liquid"));
        lista.add(new Team(2L,"Loud"));
        lista.add(new Team(3L,"Pain gaming"));
    }

    public List<Team> getTeams(){
        return lista;
    }

    public Team getTeam(Long id){
        return lista
                .stream()
                .filter( item -> Objects.equals(item.getId(), id))
                .findFirst()
                .orElseThrow();
    }

    public void deleteTeam(Long id){
        Team team = lista
                .stream()
                .filter( item -> Objects.equals(item.getId(), id))
                .findFirst()
                .orElseThrow();
        lista.remove(team);
    }

    public Team createTeam(Team team){
        lista.add(team);
        return team;
    }

    public Team editTeam(Long id, Team teamUpdated){
        Team team = lista
                .stream()
                .filter( item -> Objects.equals(item.getId(), id))
                .findFirst()
                .orElseThrow();
        team.setName(teamUpdated.getName());
        return team;
    }

    public void addPlayerToTeam(Long id,Player player){
        Team team = getTeam(id);
        if (player.getTeam() != null) {
            System.out.println("Jogador " + player.getName() + " já está em um time!");
            return;
        }
        team.addPlayer(player);
    }
}
