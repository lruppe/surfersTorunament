package com.example.mySurferApplication;

import com.example.mySurferApplication.DemoApplication.Contest;
import com.example.mySurferApplication.DemoApplication.Surfer;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.failBecauseExceptionWasNotThrown;

@SpringBootTest
class MySurferApplicationTests {

	@Test()
	void checkForMaxSurfersInContest()  {
		//given
		Surfer surfer1 = createSurfer("max", "italian");
		Surfer surfer2 = createSurfer("hans", "swiss");
		Surfer surfer3 = createSurfer("blubb", "blaaa");
		Contest contest = new Contest("lucerne", 2);

		contest.registerSurfer(surfer1);
		contest.registerSurfer(surfer2);

		try {
			//when
			contest.registerSurfer(surfer3);
			failBecauseExceptionWasNotThrown(RuntimeException.class);
		} catch (Exception e){
			//then
			assertThat(e.getMessage()).isEqualTo("Max nr of surfer exceeded");
		}

	}

	private Surfer createSurfer (String name, String nationality) {
		Surfer surfer = new Surfer();
		surfer.setName(name);
		surfer.setCountry(nationality);
		return surfer;
	}
}
