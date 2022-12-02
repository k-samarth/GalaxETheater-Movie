package com.galaxe.movietheatre.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.galaxe.movietheatre.dto.ScheduleDto;
import com.galaxe.movietheatre.entities.Schedule;

@Mapper
public interface ScheduleMapper {
	@Mapping(target="scheduleId",source="scheduleId")

	@Mapping(target="scheduleDate",source="scheduleDate")
	@Mapping(target="scheduleTime",source="scheduleTime")
	@Mapping(target="theatreName",source="theatreName")
	public Schedule convertToEntity(ScheduleDto scheduleDto);
	
	@Mapping(target="scheduleId",source="scheduleId")
	@Mapping(target="scheduleDate",source="scheduleDate")
	@Mapping(target="scheduleTime",source="scheduleTime")
	@Mapping(target="theatreName",source="theatreName")
	public ScheduleDto convertToDto(Schedule schedule);
}
