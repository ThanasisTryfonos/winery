/*******************************************************************************
 * Copyright (c) 2012-2017 University of Stuttgart.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and the Apache License 2.0 which both accompany this distribution,
 * and are available at http://www.eclipse.org/legal/epl-v10.html
 * and http://www.apache.org/licenses/LICENSE-2.0
 *
 * Contributors:
 *     Oliver Kopp - initial API and implementation
 *     Nicole Keppler, Lukas Balzer - changes for angular frontend
 *******************************************************************************/
package org.eclipse.winery.repository.rest.resources;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.eclipse.winery.common.ids.definitions.TOSCAComponentId;
import org.eclipse.winery.model.tosca.Definitions;
import org.eclipse.winery.model.tosca.HasType;
import org.eclipse.winery.repository.backend.BackendUtils;
import org.eclipse.winery.repository.backend.RepositoryFactory;
import org.eclipse.winery.repository.rest.resources._support.ResourceCreationResult;
import org.eclipse.winery.repository.rest.resources.apiData.QNameWithTypeApiData;

import org.apache.commons.lang3.StringUtils;

/**
 * This class does NOT inherit from TEntityTemplatesResource<ArtifactTemplate> as these templates are directly nested in
 * a TDefinitionsElement
 */
public abstract class AbstractComponentsWithTypeReferenceResource<T extends AbstractComponentInstanceResource> extends AbstractComponentsResource<T> {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response onJsonPost(QNameWithTypeApiData jsonData) {
		// only check for type parameter as namespace and name are checked in super.onPost
		if (StringUtils.isEmpty(jsonData.type)) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		ResourceCreationResult creationResult = super.onPost(jsonData.namespace, jsonData.localname);
		if (!creationResult.isSuccess()) {
			return creationResult.getResponse();
		}
		if (creationResult.getStatus().equals(Status.CREATED)) {
			final TOSCAComponentId id = (TOSCAComponentId) creationResult.getId();
			final Definitions definitions = RepositoryFactory.getRepository().getDefinitions(id);
			final HasType element = (HasType) definitions.getElement();
			element.setType(jsonData.type);
			try {
				BackendUtils.persist(id, definitions);
			} catch (IOException e) {
				throw new WebApplicationException(e);
			}
		}
		return creationResult.getResponse();
	}
}
