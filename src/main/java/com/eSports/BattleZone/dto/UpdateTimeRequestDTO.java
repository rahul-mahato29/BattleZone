package com.eSports.BattleZone.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateTimeRequestDTO {
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime matchTime;
}
