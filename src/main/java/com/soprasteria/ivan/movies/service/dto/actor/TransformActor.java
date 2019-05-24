package com.soprasteria.ivan.movies.service.dto.actor;

import java.util.List;
import java.util.stream.Collectors;

import com.soprasteria.ivan.movies.builder.dto.actor.ActorFullDTOBuilder;
import com.soprasteria.ivan.movies.builder.entities.ActorBuilder;
import com.soprasteria.ivan.movies.model.entities.Actor;

public class TransformActor {

	public static List<ActorFullDTO> fromActorListToActorFullDTOList(List<Actor> actors) {

		if (actors != null) {

			return actors.stream().map(TransformActor::mapActorToActorFullDTO).collect(Collectors.toList());

		}

		return null;

	}

	public static List<Actor> fromActorFullDTOListToActorList(List<ActorFullDTO> actors) {

		if (actors != null) {

			return actors.stream().map(TransformActor::mapActorFullDTOToActor).collect(Collectors.toList());
		}

		return null;

	}

	public static ActorFullDTO mapActorToActorFullDTO(Actor actor) {
		return new ActorFullDTOBuilder().name(actor.getName(), actor.getSurnames())
				   						.age(actor.getAge())
				   						.build();

	}

	public static Actor mapActorFullDTOToActor(ActorFullDTO actor) {

		return new ActorBuilder().name(actor.getName(), actor.getSurnames())
								 .age(actor.getAge())
								 .build();
	}

}