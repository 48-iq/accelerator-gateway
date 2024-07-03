package ru.accelerator.sdt.gateway.dto.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class LimitUpdateDto {
    private Integer dayQueryCount;
    private Integer todayQueryCount;
    @JsonIgnore
    private Integer version;
}
