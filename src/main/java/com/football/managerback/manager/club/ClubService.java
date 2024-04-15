package com.football.managerback.manager.club;

import com.football.managerback.domain.club.club.Club;
import com.football.managerback.domain.club.club.ClubMapper;
import com.football.managerback.domain.club.club.ClubRepository;
import com.football.managerback.manager.club.dto.ClubInfo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClubService {

    private final ClubRepository clubRepository;
    private final ClubMapper clubMapper;

    public List<ClubInfo> getClubs() {
        List<Club> clubs = clubRepository.findAll();
        List<ClubInfo> clubsInfos = clubMapper.toClubsInfos(clubs);
        return clubsInfos;
    }

}
