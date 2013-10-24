package org.personal.mason.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import org.personal.mason.domain.SystemUser;

public class DataHolder {

	private static DataHolder instance = null;

	public synchronized static DataHolder getInstance() {
		if (instance == null) {
			instance = new DataHolder();
		}
		return instance;
	}

	private ArrayList<SystemUser> users = new ArrayList<SystemUser>();

	private DataHolder() {
		init();
	}

	private void init() {
		Random rand = new Random();
		int random = rand.nextInt(5) + 5;
		for (int i = 0; i < random; i++) {
			SystemUser user = new SystemUser();
			user.setAge(rand.nextInt(100) + 3);
			user.setGender("M");
			user.setName(String.format("name%d", rand.nextInt(40) + 2));
			user.setPassword(String.format("password%d", rand.nextInt(50) + 50));
			users.add(user);
		}
	}

	public ArrayList<SystemUser> getUsers() {
		return users;
	}

	public void addUser(SystemUser... susers) {
		if (susers != null && susers.length > 0) {
			users.addAll(Arrays.asList(susers));
		}
	}

	public SystemUser addUser(SystemUser user) {
		users.add(user);
		return user;
	}

	public void deleteUser(int id) {
		if (id < users.size()) {
			users.remove(id);
		}
	}

	public SystemUser findUser(int id) {
		if (id < users.size()) {
			return users.get(id);
		}

		return null;
	}
}
