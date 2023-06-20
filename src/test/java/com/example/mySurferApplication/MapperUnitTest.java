package com.example.mySurferApplication;

import com.example.mySurferApplication.DemoApplication.Mappers.ContestMapper;
import com.example.mySurferApplication.DemoApplication.Mappers.SurferMapper;
import com.example.mySurferApplication.DemoApplication.Services.Entities.Contest;
import com.example.mySurferApplication.DemoApplication.Services.Entities.ContestDto;
import com.example.mySurferApplication.DemoApplication.Services.Entities.Surfer;
import com.example.mySurferApplication.DemoApplication.Services.Entities.SurferDto;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;


class MapperUnitTest {
	private SurferMapper surferMapper = Mappers.getMapper(SurferMapper.class);
	private ContestMapper contestMapper = Mappers.getMapper(ContestMapper.class);

	@Test()
	void givenSurferDto_whenMaps_thenCorrect() {
		SurferDto surferDto = createSurferDto();

		Surfer surfer = surferMapper.dtoToSurfer(surferDto);
		assertEquals(surfer.getCountry(), surferDto.getCountry());
		assertEquals(surfer.getGender(), surferDto.getGender());
		assertEquals(surfer.getName(), surferDto.getName());
		assertEquals(surfer.getId(), surferDto.getId());
	}
	@Test
	void givenSurfer_whenMaps_thenCorrect() {
		Surfer surfer = createSurfer();

		SurferDto surferDto = surferMapper.surferToDto(surfer);
		assertEquals(surfer.getCountry(), surferDto.getCountry());
		assertEquals(surfer.getName(), surferDto.getName());
		assertEquals(surfer.getId(), surferDto.getId());
	}
	@Test
	void givenContest_whenMaps_thenCorrect() {
		Contest contest = createContest();
		Surfer surfer = createSurfer();
		contest.registerSurfer(surfer);

		ContestDto contestDto = contestMapper.contestToDto(contest);

		assertEquals(contest.getPlace(), contestDto.getPlace());
		assertEquals(contest.getMaxNrOfSurfer(), contestDto.getMaxParticipants());
		assertInstanceOf(SurferDto.class,contestDto.getRegisteredSurfers().stream().findFirst().get());
		assertEquals(contestDto.getRegisteredSurfers().stream().findFirst().get().getName(), "Leon");
	}

	private Contest createContest () {
		Contest contest = new Contest("Luzern", 5);

		return contest;
	}

	private Surfer createSurfer () {
		Surfer surfer = new Surfer();
		surfer.setName("Leon");
		surfer.setCountry("Switzerland");
		surfer.setId(1L);
		surfer.setGender("m");
		return surfer;
	}

	private SurferDto createSurferDto (){
		SurferDto surferDto = new SurferDto();
		surferDto.setId(1L);
		surferDto.setCountry("Switzerland");
		surferDto.setName("Leon");
		surferDto.setGender("m");
		return surferDto;
	}
}
