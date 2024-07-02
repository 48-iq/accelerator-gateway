package ru.accelerator.sdt.gateway.services.impl;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.accelerator.sdt.gateway.dto.area.AreaCreateDto;
import ru.accelerator.sdt.gateway.dto.area.AreaDto;
import ru.accelerator.sdt.gateway.dto.area.AreaUpdateDto;
import ru.accelerator.sdt.gateway.entities.Area;
import ru.accelerator.sdt.gateway.repositories.AreaRepository;
import ru.accelerator.sdt.gateway.repositories.UserRepository;
import ru.accelerator.sdt.gateway.services.interf.AreaService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class AreaServiceImpl implements AreaService {
    private final AreaRepository areaRepository;
    private final UserRepository userRepository;
    private final DateTimeFormatter dateFormatter;


    private Area areaToEntity(AreaCreateDto areaDto) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate sowingDate = LocalDate.parse(areaDto.getSowingDate(), dtf);
        return Area.builder()
                .title(areaDto.getTitle())
                .latitude(areaDto.getLatitude())
                .longitude(areaDto.getLongitude())
                .soilType(areaDto.getSoilType())
                .user(userRepository.getReferenceById(areaDto.getUserId()))
                .sowingDate(sowingDate)
                .build();
    }

    private AreaDto areaToDto(Area area) {
        String sowingDate = dateFormatter.format(area.getSowingDate());
        return AreaDto.builder()
                .id(area.getId())
                .title(area.getTitle())
                .latitude(area.getLatitude())
                .longitude(area.getLongitude())
                .soilType(area.getSoilType())
                .sowingDate(sowingDate)
                .build();
    }

    @Override
    @Transactional
    public AreaDto createArea(AreaCreateDto areaDto) {
        Area area = areaToEntity(areaDto);
        area = areaRepository.save(area);
        return areaToDto(area);
    }

    @Override
    @Transactional
    public void updateArea(Integer id, AreaUpdateDto areaDto) {
        areaRepository.updateArea(id,
                areaDto.getTitle(),
                areaDto.getLongitude(),
                areaDto.getLatitude(),
                areaDto.getSoilType(),
                LocalDate.parse(areaDto.getSowingDate(), dateFormatter)
                );
    }

    @Override
    public AreaDto findAreaById(Integer id) {
        Area area = areaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("area with such id doesn't exist"));
        return areaToDto(area);
    }

    @Override
    public Page<AreaDto> findAreaByTitle(String title, Integer page, Integer size) {
        Page<Area> areaPage = areaRepository.findAreasByTitle(title, PageRequest.of(page, size));
        return new PageImpl<AreaDto>(
                areaPage.getContent().stream().map(this::areaToDto).toList(),
                areaPage.getPageable(),
                areaPage.getTotalElements()
        );
    }

    @Override
    public Page<AreaDto> findAllAreas(Integer page, Integer size) {
        Page<Area> areaPage = areaRepository.findAll(PageRequest.of(page, size));
        return new PageImpl<AreaDto>(
                areaPage.getContent().stream().map(this::areaToDto).toList(),
                areaPage.getPageable(),
                areaPage.getTotalElements()
        );
    }

    @Override
    public void deleteAreaById(Integer id) {
        areaRepository.deleteById(id);
    }
}
