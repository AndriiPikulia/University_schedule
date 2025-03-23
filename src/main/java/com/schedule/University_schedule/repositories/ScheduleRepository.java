package com.schedule.University_schedule.repositories;

import com.schedule.University_schedule.domains.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
