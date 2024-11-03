package com.devlab.taskmanager;

import com.devlab.taskmanager.model.User;
import com.devlab.taskmanager.repository.RoleRepository;
import com.devlab.taskmanager.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class TaskmanagerApplicationTests {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Test
	void adminUserExists() {
		Optional<User> adminUser = userRepository.findByUsername("admin");
		assertTrue(adminUser.isPresent(), "Admin user should exist in the database");
	}

	@Test
	void adminUserHasRoleAdmin() {
		Optional<User> adminUser = userRepository.findByUsername("admin");
		assertTrue(adminUser.isPresent(), "Admin user should exist in the database");

		User user = adminUser.get();
		boolean hasAdminRole = user.getRoles().stream()
				.anyMatch(role -> "ADMIN".equals(role.getName()));
		assertTrue(hasAdminRole, "Admin user should have the ADMIN role");
	}
}
