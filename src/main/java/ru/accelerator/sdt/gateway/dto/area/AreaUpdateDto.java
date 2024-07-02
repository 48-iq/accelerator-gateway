package ru.accelerator.sdt.gateway.dto.area;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class AreaUpdateDto {
    private String title;
    private Double longitude;
    private Double latitude;
    private String soilType;
    private String sowingDate;
}
