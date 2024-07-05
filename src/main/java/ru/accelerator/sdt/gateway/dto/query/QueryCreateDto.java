package ru.accelerator.sdt.gateway.dto.query;

import lombok.*;
import ru.accelerator.sdt.gateway.entities.Status;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QueryCreateDto {
    private Integer id;
    private Integer userId;
    private Integer areaId;
    private List<String> images;
}
