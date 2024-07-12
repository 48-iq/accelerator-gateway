package ru.accelerator.sdt.gateway.services.impl;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.accelerator.sdt.gateway.dto.area.AreaCreateDto;
import ru.accelerator.sdt.gateway.dto.area.AreaDto;
import ru.accelerator.sdt.gateway.dto.area.AreaUpdateDto;
import ru.accelerator.sdt.gateway.repositories.UserRepository;
import ru.accelerator.sdt.gateway.services.interf.AreaService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AreaServiceImpl implements AreaService {

    private final RestTemplate restTemplate;

    @Value("${hosts.services.area}")
    private String areaHost;
    @Value("${mappings.services.area.create}")
    private String createMapping;
    @Value("${mappings.services.area.update}")
    private String updateMapping;
    @Value("${mappings.services.area.find}")
    private String findMapping;
    @Value("${mappings.services.area.findall}")
    private String findAllMapping;
    @Value("${mappings.services.area.delete}")
    private String deleteMapping;

    @Override
    public AreaDto createArea(AreaCreateDto area) {
        try {
            ResponseEntity<AreaDto> response = restTemplate.postForEntity(areaHost + createMapping, area, AreaDto.class);
            return response.getBody();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void updateArea(Integer id, AreaUpdateDto areaDto) {
        try {
            ResponseEntity<Void> response = restTemplate.postForEntity(areaHost + updateMapping + "/" + id, areaDto, Void.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public AreaDto findAreaById(Integer id) {
        try {
            ResponseEntity<AreaDto> response = restTemplate.getForEntity(areaHost + findMapping, AreaDto.class);
            return response.getBody();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Page<AreaDto> findAllAreas(Integer page, Integer size) {
        try {
            Map<String, Integer> params = new HashMap<>();
            params.put("page", page);
            params.put("size", size);
            ResponseEntity<PageImpl> response = restTemplate.getForEntity(areaHost + findAllMapping, PageImpl.class, params);
            return response.getBody();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteArea(Integer id) {
        try {
            restTemplate.delete(areaHost + deleteMapping + "/" + id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
