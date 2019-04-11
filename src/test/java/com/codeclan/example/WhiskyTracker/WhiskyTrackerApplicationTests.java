package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhiskyTrackerApplicationTests {

	@Autowired
	WhiskyRepository whiskyRepository;

	@Autowired
	DistilleryRepository distilleryRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void canFindWhiskyByYear() {
		List<Whisky> found = whiskyRepository.findWhiskyByYear(1991);
		assertEquals("The Rosebank 12 - Flora and Fona", found.get(0).getName());
		List<Whisky> found2 = whiskyRepository.findWhiskyByYear(2018);
		assertEquals("The Glendronach Revival", found2.get(0).getName());
		assertEquals("The Glendronach Original", found2.get(1).getName());
	}

	@Test
	public void canFindDestilleryByRegion() {
		List<Distillery> found = distilleryRepository.findDistilleryByRegion("Lowland");
		assertEquals("Rosebank", found.get(0).getName());
		List<Distillery> found2 = distilleryRepository.findDistilleryByRegion("Speyside");
		assertEquals("Macallan", found2.get(0).getName());
		assertEquals("Balvenie", found2.get(1).getName());
	}
	@Test
	public void canFindAllWhiskiesFromSpecificDistilleryByYear() {
		List<Whisky> found = whiskyRepository.findWhiskyInSpecificDistilleryByYear("Glendronach", 15);
		assertEquals("The Glendronach Revival", found.get(0).getName());
	}
}
