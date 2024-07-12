package ru.accelerator.sdt.gateway.services.interf;


import org.springframework.data.domain.Page;
import ru.accelerator.sdt.gateway.dto.query.QueryCreateDto;
import ru.accelerator.sdt.gateway.dto.query.QueryResultDto;
import ru.accelerator.sdt.gateway.dto.query.QueryInfoDto;

public interface QueryService {
    QueryInfoDto createQuery(QueryCreateDto query);
    QueryInfoDto getQueryInfo(Integer id);
    Page<QueryInfoDto> getAllQueryInfoInfo(Integer page, Integer size);
    QueryResultDto getQueryResult(Integer id);
    Page<QueryResultDto> getAllQueryResults(Integer page, Integer size);

}
