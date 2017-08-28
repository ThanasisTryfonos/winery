/*******************************************************************************
 * Copyright (c) 2012-2017 University of Stuttgart.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and the Apache License 2.0 which both accompany this distribution,
 * and are available at http://www.eclipse.org/legal/epl-v10.html
 * and http://www.apache.org/licenses/LICENSE-2.0
 *
 * Contributors:
 *     Oliver Kopp - initial API and implementation, introduction of NamespaceManager
 *     Lukas Harzenetter - return namespaces sorted
 *     Nicole Keppler - return filtered namespace with number of containing components
 *     Niko Stadelmaier - return namespaces with prefix
 *******************************************************************************/
package org.eclipse.winery.repository.rest.resources.admin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.eclipse.winery.common.Util;
import org.eclipse.winery.common.ids.Namespace;
import org.eclipse.winery.common.ids.admin.NamespacesId;
import org.eclipse.winery.repository.backend.NamespaceManager;
import org.eclipse.winery.repository.backend.RepositoryFactory;
import org.eclipse.winery.repository.backend.filebased.ConfigurationBasedNamespaceManager;
import org.eclipse.winery.repository.rest.resources.apiData.NamespaceWithPrefix;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Manages prefixes for the namespaces
 */
public class NamespacesResource extends AbstractAdminResource {

	private static final Logger LOGGER = LoggerFactory.getLogger(NamespacesResource.class);

	private final NamespaceManager namespaceManager;

	public NamespacesResource() {
		super(new NamespacesId());
		namespaceManager = new ConfigurationBasedNamespaceManager(this.configuration);
	}

	/**
	 * Returns the list of all namespaces registered with his manager and used at component instances.
	 */
	public Collection<Namespace> getNamespaces() {
		Set<Namespace> res = this.namespaceManager.getAllNamespaces().stream().map(ns -> new Namespace(ns, false)).collect(Collectors.toSet());
		res.addAll(RepositoryFactory.getRepository().getUsedNamespaces());
		ArrayList<Namespace> list = new ArrayList<>(res);
		Collections.sort(list);
		return list;
	}

	/**
	 * Sets / overwrites prefix/namespace mapping <p> In case the prefix is already bound to another namespace,
	 * BAD_REQUEST is returned.
	 */
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response addNamespace(@FormParam("namespace") String namespace, @FormParam("nsPrefix") String prefix) {
		if (StringUtils.isEmpty(namespace)) {
			return Response.status(Status.BAD_REQUEST).entity("namespace must be given.").build();
		}
		if (StringUtils.isEmpty(prefix)) {
			return Response.status(Status.BAD_REQUEST).entity("prefix must be given.").build();
		}
		namespace = Util.URLdecode(namespace);
		prefix = Util.URLdecode(prefix);
		Collection<String> allPrefixes = this.namespaceManager.getAllPrefixes();
		if (allPrefixes.contains(prefix)) {
			if (this.namespaceManager.getPrefix(namespace).equals(prefix)) {
				return Response.notModified().build();
			} else {
				// the requested prefix is already bound to a different namespace
				return Response.status(Status.BAD_REQUEST).entity("prefix already bound to a different namespace.").build();
			}
		}
		this.namespaceManager.setPrefix(namespace, prefix);
		return Response.noContent().build();
	}

	/**
	 * Sets / overwrites prefix/namespace mapping
	 *
	 * In case the prefix is already bound to another namespace, BAD_REQUEST is returned.
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response replaceNamespaces(List<NamespaceWithPrefix> namespacesList) {
		if (namespacesList == null) {
			return Response.status(Status.BAD_REQUEST).entity("namespace list must be given.").build();
		}
		this.namespaceManager.clear();
		for (NamespaceWithPrefix nsp : namespacesList) {
			this.namespaceManager.setPrefix(nsp.namespace, nsp.prefix);
		}
		return Response.noContent().build();
	}

	/**
	 * Deletes given namespace from the repository
	 *
	 * @param uri to delete. The namespace is URLencoded.
	 */
	@DELETE
	@Path("{namespace}")
	public Response onDelete(@PathParam("namespace") String uri) {
		Response res;
		uri = Util.URLdecode(uri);
		if (this.namespaceManager.hasPrefix(uri)) {
			this.namespaceManager.remove(uri);
			res = Response.noContent().build();
		} else {
			res = Response.status(Status.NOT_FOUND).build();
		}
		return res;
	}

	@Path("{namespace}")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getPrefixForEncodedNamespace(@PathParam("namespace") String uri) {
		uri = Util.URLdecode(uri);
		return this.namespaceManager.getPrefix(uri);
	}

	/**
	 * Returns the list of all namespaces registered with his manager and used at component instances.
	 *
	 * @return a JSON list containing the non-encoded URIs of each known namespace
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<NamespaceWithPrefix> getNamespacesAsJSONlist() {
		Collection<Namespace> namespaces = this.getNamespaces();

		// We now have all namespaces
		// We need to convert from Namespace to String

		List<NamespaceWithPrefix> namespacesList = new ArrayList<>();
		for (Namespace ns : namespaces) {
			namespacesList.add(new NamespaceWithPrefix(ns, this.namespaceManager.getPrefix(ns.getDecoded())));
		}
		Collections.sort(namespacesList);
		return namespacesList;
	}
}
