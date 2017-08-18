package org.eclipse.winery.TestConsistency.entitytypes;

import org.eclipse.winery.common.ids.definitions.ArtifactTypeId;
import org.eclipse.winery.common.ids.definitions.RelationshipTypeId;
import org.eclipse.winery.common.ids.definitions.TOSCAComponentId;
import org.eclipse.winery.repository.backend.Repository;
import org.eclipse.winery.repository.export.TOSCAExportUtil;
import org.eclipse.winery.repository.resources.AbstractResourceTest;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.fail;

/**
 * Created by Lati on 11.08.17.
 */
public class TestConsistencyRelationshipTypeId extends AbstractResourceTest {

	/**
	 * testConsistency - checks consistency between Repository and its linked elements for Duplicates.
	 * @throws Exception
	 */
	@Test
	public void testConsistency() throws Exception{
		this.setRevisionTo("c25aa724201824fce6eddcc7c35a666c6e015880"); // prepare local Repository.
		List<String> errors = new ArrayList<>(); // collect Errors in list.
		Set<RelationshipTypeId> list = Repository.INSTANCE.getAllTOSCAComponentIds(RelationshipTypeId.class);
		
		
		
		// Hint 2: now We should iterate over all Elements of our Result List and get all Linked objects and check if they are part oft the Repository, too.
	}
}