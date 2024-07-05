package ru.accelerator.sdt.gateway.dto.query;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class QueryInfoDto {
    private Integer id;
    private String status;
    private Integer userId;
    private Integer areaId;
    private List<String> images;
}
