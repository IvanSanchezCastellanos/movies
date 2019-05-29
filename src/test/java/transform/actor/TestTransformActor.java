package transform.actor;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.soprasteria.ivan.movies.model.entities.Actor;
import com.soprasteria.ivan.movies.service.dto.actor.ActorFullDTO;
import com.soprasteria.ivan.movies.service.dto.actor.TransformActor;

public class TestTransformActor {

	@Test
	public void testFromActorListToActorFullDTOList() {

		List<ActorFullDTO> list = TransformActor.fromActorListToActorFullDTOList(DataForTransformActorTests.getActorList());

		assertTrue("Transform from actor list to actorDTO list not correct",
					DataForTransformActorTests.getActorFullDTOList().get(0).equals(list.get(0))
				 && DataForTransformActorTests.getActorFullDTOList().get(1).equals(list.get(1)));

	}

	@Test
	public void testFromNullActorListToActorFullDTOList() {

		assertTrue("Transform from null actor list to actorDTO list not correct",
					TransformActor.fromActorListToActorFullDTOList(null) == null);

	}

	@Test
	public void testFromActorFullDTOListToActorList() {

		List<Actor> listResult = TransformActor.fromActorFullDTOListToActorList(DataForTransformActorTests.getActorFullDTOList());

		assertTrue("Transform from actor full dto list to actor list not correct",
					listResult.get(0).equals(DataForTransformActorTests.getActorList().get(0))
				 && listResult.get(1).equals(DataForTransformActorTests.getActorList().get(1)));

	}

	@Test
	public void testFromNullActorFullDTOListToActorList() {

		assertTrue("Transform from actor full dto list to actor list not correct",
					TransformActor.fromActorFullDTOListToActorList(null) == null);

	}

	@Test
	public void fromNullActorListToActorFullDTOList() {
		assertTrue("Transfrom from null actor list to actor full DTO list not correct", TransformActor.fromActorListToActorFullDTOList(null) == null);
	}
	
	@Test
	public void fromNullActorFullDTOListToActorList() {
		assertTrue("Transform from null actor full DTO list to actor list not correct", TransformActor.fromActorFullDTOListToActorList(null) == null);
	}
}