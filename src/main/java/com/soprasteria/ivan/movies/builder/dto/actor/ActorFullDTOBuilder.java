package com.soprasteria.ivan.movies.builder.dto.actor;

import com.soprasteria.ivan.movies.service.dto.actor.ActorFullDTO;

public class ActorFullDTOBuilder {

	private String name;
	private String surnames;
	private Integer age;

	public ActorFullDTOBuilder name(String name, String surnames) {
		this.name = name;
		this.surnames = surnames;
		return this;
	}

	public ActorFullDTOBuilder age(Integer age) {
		this.age = age;
		return this;
	}

	public ActorFullDTO build() {
		ActorFullDTO dto = new ActorFullDTO();
		dto.setAge(age);
		dto.setName(name);
		dto.setSurnames(surnames);
		return dto;
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