package com.soprasteria.ivan.movies.service.dto.actor;

import java.util.List;
import java.util.stream.Collectors;

import com.soprasteria.ivan.movies.builder.dto.actor.ActorFullDTOBuilder;
import com.soprasteria.ivan.movies.builder.entities.ActorBuilder;
import com.soprasteria.ivan.movies.model.entities.Actor;

public class TransformActor {

	public static List<ActorFullDTO> fromActorListToActorFullDTOList(List<Actor> actors) {

		if (actors != null) {

			return actors.stream().map(TransformActor::transformActorToActorFullDTO).collect(Collectors.toList());

		}

		return null;

	}

	public static List<Actor> fromActorFullDTOListToActorList(List<ActorFullDTO> actors) {

		if (actors != null) {

			return actors.stream().map(TransformActor::transformActorFullDTOToActor).collect(Collectors.toList());
		}

		return null;

	}

	public static ActorFullDTO transformActorToActorFullDTO(Actor actor) {
		return new ActorFullDTOBuilder().name(actor.getName(), actor.getSurnames())
				   						.age(actor.getAge())
				   						.build();

	}

	public static Actor transformActorFullDTOToActor(ActorFullDTO actor) {

		return new ActorBuilder().name(actor.getName(), actor.getSurnames())
								 .age(actor.getAge())
								 .build();
	}

}