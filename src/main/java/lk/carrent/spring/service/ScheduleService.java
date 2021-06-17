package lk.carrent.spring.service;

import lk.carrent.spring.dto.ScheduleDTO;

import java.util.ArrayList;

public interface ScheduleService {
    void addSchedule(ScheduleDTO dto);

    void deleteSchedule(String id);

    ScheduleDTO searchSchedule(String id);

    ArrayList<ScheduleDTO> getAllSchedule();

    void updateSchedule(ScheduleDTO dto);
}
