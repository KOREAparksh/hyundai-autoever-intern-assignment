package com.example.hyundaiboot.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PushMessageHistoryRepositoryTest {

	@Autowired
	private PushMessageHistoryRepository pushMessageHistoryRepository;

	@Test
	void getAllHistory(){
		pushMessageHistoryRepository.findAll().forEach(System.out::println);
	}
}
