package br.com.ulbra.AP2.repositories;

import br.com.ulbra.AP2.models.Player;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class PlayerRepository {
    private List<Player> listaPlayer = new ArrayList<>();

    public PlayerRepository(){
        listaPlayer.add(new Player(1L, "Gustavo Tondin"));
        listaPlayer.add(new Player(2L, "Titan"));
        listaPlayer.add(new Player(3L, "Fallen"));
        listaPlayer.add(new Player(4L, "Rafolas"));
        listaPlayer.add(new Player(5L, "Laozin"));
    }

    public List<Player> getPlayers(){
        return listaPlayer;
    }

    public Player getPlayer(Long id){
        return listaPlayer
                .stream()
                .filter(item -> Objects.equals(item.getId(), id))
                .findFirst()
                .orElseThrow();
    }

    public void deletePlayer(Long id){
        Player player = listaPlayer
                .stream()
                .filter(item -> Objects.equals(item.getId(), id))
                .findFirst()
                .orElseThrow();
        listaPlayer.remove(player);
    }

    public Player createPlayer(Player player){
        listaPlayer.add(player);
        return player;
    }

    public Player editPlayer(Long id, Player playerUpdated){
        Player player = listaPlayer
                .stream()
                .filter(item -> Objects.equals(item.getId(), id))
                .findFirst()
                .orElseThrow();
        player.setName(playerUpdated.getName());
        player.setId(playerUpdated.getId());
        return player;
    }

}
