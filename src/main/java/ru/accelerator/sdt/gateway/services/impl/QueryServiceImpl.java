package ru.accelerator.sdt.gateway.services.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.accelerator.sdt.gateway.dto.query.QueryCreateDto;
import ru.accelerator.sdt.gateway.dto.query.QueryDto;
import ru.accelerator.sdt.gateway.dto.query.QueryInfoDto;
import ru.accelerator.sdt.gateway.entities.Query;
import ru.accelerator.sdt.gateway.entities.Status;
import ru.accelerator.sdt.gateway.repositories.AreaRepository;
import ru.accelerator.sdt.gateway.repositories.QueryRepository;
import ru.accelerator.sdt.gateway.repositories.UserRepository;
import ru.accelerator.sdt.gateway.services.interf.QueryService;

@Service
@RequiredArgsConstructor
public class QueryServiceImpl implements QueryService {
    private final QueryRepository queryRepository;
    private final UserRepository userRepository;
    private final AreaRepository areaRepository;

    @Override
    @Transactional
    public QueryInfoDto createQuery(QueryCreateDto queryDto) {
        Query query = Query.builder()
                .user(userRepository.getReferenceById(queryDto.getUserId()))
                .area(areaRepository.getReferenceById(queryDto.getAreaId()))
                .images(queryDto.getImages())
                .status(Status.PROCESSING)
                .build();
        query = queryRepository.save(query);
        return

    }

    @Override
    public void deleteQuery(Integer id) {

    }

    @Override
    public QueryInfoDto getInfo(Integer id) {
        return null;
    }

    @Override
    public QueryDto getResult(Integer id) {
        return null;
    }
}
