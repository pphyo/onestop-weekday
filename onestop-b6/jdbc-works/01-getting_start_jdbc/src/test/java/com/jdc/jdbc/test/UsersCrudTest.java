package com.jdc.jdbc.test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.function.Executable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.jdc.jdbc.model.dao.UserDao;
import com.jdc.jdbc.model.domain.User;

@TestMethodOrder(OrderAnnotation.class)
public class UsersCrudTest {
	
	static UserDao dao;
	
	@BeforeAll
	static void setUpBeforeClass() {
		dao = new UserDao();
		dao.truncate("users");
	}
	
	@Order(1)
	@ParameterizedTest
	@CsvSource(value = {
			"pphyo: pyaephyo.jdc@gmail.com: pyaephyo: 1",
			"cherry: cherry@gmail.com: cherry: 1",
			"kyawgyi: kyawgyi@gmail.com: kyawgyi: 1",
			"kozin: zinlinhtet@gmail.com: zinlin: 1",
			"ttt: ttt@gmail.com: theint: 1"
	}, delimiter = ':')
	void test_for_save_user(String username, String email, 
			String password, int result) {
		var user = new User(username, email, password, null);
		assertEquals(result, dao.save(user));		
	}
	
	@Order(2)
	@ParameterizedTest
	@ValueSource(ints = 5)
	void test_for_count_all_users(long result) {
		assertEquals(result, dao.countAllUser());
	}
	
	@Order(3)
	@ParameterizedTest
	@CsvSource({
		"pphyo, pyaephyo.jdc@gmail.com, pyaephyo, 2023-07-26, 1",
		"cherry, cherry@gmail.com, cherry, 2023-07-26, 2",
		"kyawgyi, kyawgyi@gmail.com, kyawgyi, 2023-07-26, 3"
	})
	void test_for_find_by_id(String username, String email, 
			String password, LocalDate creation, int id) {
		
		var user = dao.findById(id);
		
		assertNotNull(user);
		
		assertAll(() -> {
			assertEquals(username, user.getUsername());
			assertEquals(email, user.getEmail());
			assertEquals(password, user.getPassword());
			assertEquals(creation, user.getCreation().toLocalDate());
			assertEquals(id, user.getId());
		});
		
	}
	
	@Order(4)
	@ParameterizedTest
	@CsvSource({
				"4, 4",
				"5, 3"
			})
	void test_for_delete(int deletedId, long remainCount) {
		
		dao.delete(deletedId);
		
		assertEquals(dao.countAllUser(), remainCount);
		
	}
	
	@Order(5)
	@ParameterizedTest
	@CsvSource("3, zawgyi, zawgyi@gmail.com, zawgyi")
	void test_for_update(int id, String username, String email, String password) {
		
		var user = new User(id, username, email, password, LocalDateTime.now());
		dao.update(user);
		
		var updatedUser = dao.findById(id);
		
		assertNotNull(updatedUser);
		
		Executable exe = new Executable() {
			
			@Override
			public void execute() throws Throwable {
				assertEquals(username, updatedUser.getUsername());
				assertEquals(email, updatedUser.getEmail());
				assertEquals(password, updatedUser.getPassword());
			}
		};
		
		assertAll(exe);
		
	}
	
	@Order(6)
	@ParameterizedTest
	@CsvSource("0, sirzaw, zaw.minlwin@gmail.com, minlwin")
	void test_for_not_update_with_id_zero(int id, String username, String email, String password) {
		
		Executable exe = new Executable() {
			@Override
			public void execute() throws Throwable {
				dao.update(new User(username, email, password, LocalDateTime.now()));
			}
		};
		
		assertThrows(AssertionError.class, exe);		
		
	}
	
	@Order(7)
	@ParameterizedTest
	@ValueSource(ints = 3)
	void test_for_find_all(int resultCount) {
		var userList = dao.findAll();
		
		assertNotEquals(0, userList.size());
		assertEquals(3, userList.size());
	}
	
}



