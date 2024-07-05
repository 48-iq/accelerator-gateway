package ru.accelerator.sdt.gateway.services.interf;


import ru.accelerator.sdt.gateway.dto.query.QueryCreateDto;
import ru.accelerator.sdt.gateway.dto.query.QueryDto;
import ru.accelerator.sdt.gateway.dto.query.QueryInfoDto;

public interface QueryService {
    QueryInfoDto createQuery(QueryCreateDto queryCreateDto);
    void deleteQuery(Integer id);
    QueryInfoDto getInfo(Integer id);
    QueryDto getResult(Integer id);

}
