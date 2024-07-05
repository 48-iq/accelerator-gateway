package ru.accelerator.sdt.gateway.dto.query;

import lombok.*;
import ru.accelerator.sdt.gateway.entities.Status;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class QueryDto {
    private Integer id;
    private String status;
    private List<String> images;
    private Integer areaId;
    private Integer userId;
    private String result;
}
