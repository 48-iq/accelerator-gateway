package ru.accelerator.sdt.gateway.dto.area;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class AreaCreateDto {
    private String title;
    private Double longitude;
    private Double latitude;
    private String soilType;
    private String sowingDate;
    private Integer userId;
}
