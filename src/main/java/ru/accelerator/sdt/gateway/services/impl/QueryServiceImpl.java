package ru.accelerator.sdt.gateway.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.accelerator.sdt.gateway.dto.query.QueryCreateDto;
import ru.accelerator.sdt.gateway.dto.query.QueryResultDto;
import ru.accelerator.sdt.gateway.dto.query.QueryInfoDto;
import ru.accelerator.sdt.gateway.services.interf.QueryService;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class QueryServiceImpl implements QueryService {
    private final RestTemplate restTemplate;
    @Value("${hosts.services.query}")
    private String queryHost;
    @Value("${mappings.services.query.create}")
    private String createMapping;
    @Value("${mappings.services.query.info}")
    private String infoMapping;
    @Value("${mappings.services.query.allinfo}")
    private String allInfoMapping;
    @Value("${mappings.services.query.result}")
    private String resultMapping;
    @Value("${mappings.services.query.allresults}")
    private String allresultsMapping;

    @Override
    public QueryInfoDto createQuery(QueryCreateDto query) {
        try {
            ResponseEntity<QueryInfoDto> response = restTemplate.postForEntity(queryHost + createMapping,
                    query, QueryInfoDto.class);
            return response.getBody();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public QueryInfoDto getQueryInfo(Integer id) {
        try {
            ResponseEntity<QueryInfoDto> response = restTemplate.getForEntity(queryHost + infoMapping + "/" + id,
                    QueryInfoDto.class);
            return response.getBody();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Page<QueryInfoDto> getAllQueryInfoInfo(Integer page, Integer size) {
        try {
            Map<String, Integer> params = new HashMap<>();
            params.put("page", page);
            params.put("size", size);
            ResponseEntity<Page> response = restTemplate.getForEntity(queryHost + allInfoMapping,
                    Page.class, params);
            return response.getBody();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public QueryResultDto getQueryResult(Integer id) {
        try {
            ResponseEntity<QueryResultDto> response = restTemplate.getForEntity(queryHost + resultMapping + "/" + id,
                QueryResultDto.class);
            return response.getBody();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Page<QueryResultDto> getAllQueryResults(Integer page, Integer size) {
        try {
            Map<String, Integer> params = new HashMap<>();
            params.put("page", page);
            params.put("size", size);
            ResponseEntity<Page> response = restTemplate.getForEntity(queryHost + allresultsMapping,
                    Page.class, params);
            return response.getBody();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
