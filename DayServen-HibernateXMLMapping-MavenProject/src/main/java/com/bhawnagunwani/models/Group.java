package com.bhawnagunwani.models;

import java.util.HashSet;
import java.util.Set;

public class Group {
	
	private int id;
	private String name;

	private Set<User> users = new HashSet<User>();

	public Group(String name) {
		this.name = name;
	}

	public void addUser(User user) {
		this.users.add(user);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Group [id=" + id + ", name=" + name + ", users=" + users + "]";
	}
	
}
