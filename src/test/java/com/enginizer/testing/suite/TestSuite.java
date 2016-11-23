package com.enginizer.testing.suite;

import com.enginizer.testing.flow.LoginTest;
import com.enginizer.testing.model.User;
import com.enginizer.testing.model.enums.UserRole;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

@RunWith(Suite.class)
@Suite.SuiteClasses({ LoginTest.class})
public class TestSuite {

	public static final String SEPARATOR = ":";

	public static Map<String, User> userList = new HashMap<>();

	@BeforeClass
	public static void setup() {
		ResourceLoader loader = new DefaultResourceLoader();
		org.springframework.core.io.Resource resource = loader.getResource("classpath:conf/users.txt");
		try {
			try (Stream<String> lines = Files.lines(Paths.get(resource.getURI()))) {
				lines.forEach(line -> parseUserFromLine(line));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void parseUserFromLine(String line) {
		String[] split = line.split(SEPARATOR);

		User user = new User();
		user.setUsername(split[0]);
		user.setPassword(split[1]);
		user.setRole(UserRole.valueOf(split[2]));

		userList.put(split[0], user);
	}

}
