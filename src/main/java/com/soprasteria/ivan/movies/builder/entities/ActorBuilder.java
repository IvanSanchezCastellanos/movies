package com.soprasteria.ivan.movies.builder.entities;

import com.soprasteria.ivan.movies.model.entities.Actor;

public class ActorBuilder {

	private String name;
	private String surnames;
	private Integer age;

	public ActorBuilder name(String name, String surnames) {
		this.name = name;
		this.surnames = surnames;
		return this;
	}

	public ActorBuilder age(Integer age) {
		this.age = age;
		return this;
	}

	public Actor build() {
		Actor actor = new Actor();
		actor.setName(name);
		actor.setSurnames(surnames);
		actor.setAge(age);
		return actor;
	}

	public String getName() {
		return name;
	}

	public String getSurnames() {
		return surnames;
	}

	public Integer getAge() {
		return age;
	}

}