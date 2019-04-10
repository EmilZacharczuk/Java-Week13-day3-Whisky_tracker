package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Whisky;
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
}
