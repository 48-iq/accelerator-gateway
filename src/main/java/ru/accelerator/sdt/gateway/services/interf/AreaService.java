package ru.accelerator.sdt.gateway.services.interf;

import org.springframework.data.domain.Page;
import ru.accelerator.sdt.gateway.dto.area.AreaCreateDto;
import ru.accelerator.sdt.gateway.dto.area.AreaDto;
import ru.accelerator.sdt.gateway.dto.area.AreaUpdateDto;

public interface AreaService {
    AreaDto createArea(AreaCreateDto area);
    void updateArea(Integer id, AreaUpdateDto areaDto);
    AreaDto findAreaById(Integer id);
    Page<AreaDto> findAllAreas(Integer page, Integer size);
    void deleteArea(Integer id);
}
