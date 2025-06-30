package br.com.ulbra.AP2.services;

import br.com.ulbra.AP2.models.Player;
import br.com.ulbra.AP2.repositories.PlayerRepository;
import br.com.ulbra.AP2.repositories.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    private PlayerRepository playerRepository;
    private TeamRepository teamRepository;

    public PlayerService(PlayerRepository playerRepository, TeamRepository teamRepository){
        this.playerRepository = playerRepository;
        this.teamRepository = teamRepository;
    }

    public List<Player> getPlayers(){
        return this.playerRepository.getPlayers();
    }

    public Player getPlayer(Long id){
        return this.playerRepository.getPlayer(id);
    }

    public void deletePlayer(long id){
        this.playerRepository.deletePlayer(id);
    }

    public Player createPlayer(Player player){
        return this.playerRepository.createPlayer(player);
    }

    public Player editPlayer(Long id, Player player){
        return this.playerRepository.editPlayer(id, player);
    }

    public Player assignTeamToPlayer(Long playerId, Long teamId) {
        Player player = playerRepository.getPlayer(playerId);
        teamRepository.addPlayerToTeam(teamId, player);
        return player;
    }
}
