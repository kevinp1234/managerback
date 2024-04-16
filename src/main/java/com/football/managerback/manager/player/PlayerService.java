package com.football.managerback.manager.player;

import com.football.managerback.domain.player.Player;
import com.football.managerback.domain.player.PlayerMapper;
import com.football.managerback.domain.player.PlayerRepository;
import com.football.managerback.domain.player.playerdetail.PlayerDetail;
import com.football.managerback.domain.player.playerdetail.PlayerDetailRepository;
import com.football.managerback.domain.player.playerobservation.PlayerObservationRepository;
import com.football.managerback.manager.player.dto.PlayerInfo;
import com.football.managerback.manager.player.dto.PlayersRequest;
import com.football.managerback.util.DateConverter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PlayerService {
    private final PlayerRepository playerRepository;
    private final PlayerDetailRepository playerDetailRepository;
    private final PlayerObservationRepository playerObservationRepository;

    private final PlayerMapper playerMapper;


    public List<PlayerInfo> getPlayers (PlayersRequest request){
        List<Player> players = playerRepository.findPlayersBy(
                request.getConfederationId(),
                request.getCountryId(),
                request.getLeagueId(),
                request.getClubId());

        List<PlayerInfo> playerInfos = playerMapper.toPlayerInfos(players);
        for (PlayerInfo playerInfo : playerInfos) {
            addDetailedInfo(playerInfo);
        }

        return playerInfos;
    
    }

    private void addDetailedInfo(PlayerInfo playerInfo) {
        PlayerDetail playerDetail = playerDetailRepository.findPlayerDetailBy(playerInfo.getPlayerId());
        playerInfo.setNationality(playerDetail.getNationality());
        playerInfo.setBirthDate(DateConverter.localDateToString(playerDetail.getBirthDate()));
        playerInfo.setHeight(playerDetail.getHeight());
        playerInfo.setWeight(playerDetail.getWeight());
        boolean observationExists = playerObservationRepository.playerObservationExists(playerInfo.getPlayerId());
        playerInfo.setObservationExists(observationExists);
    }

}