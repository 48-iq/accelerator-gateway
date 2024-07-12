package ru.accelerator.sdt.gateway.dto.user;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class LimitUpdateDto {
    private Integer dayLimit;
    private Integer todayCount;

}
