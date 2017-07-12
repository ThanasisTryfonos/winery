/*******************************************************************************
 * Copyright (c) 2017 University of Stuttgart.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and the Apache License 2.0 which both accompany this distribution,
 * and are available at http://www.eclipse.org/legal/epl-v10.html
 * and http://www.apache.org/licenses/LICENSE-2.0
 *
 * Contributors:
 *     Christoph Kleine - initial API and implementation
 *******************************************************************************/
package org.eclipse.winery.yaml.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import org.eclipse.winery.yaml.model.support.TMapObjectValue;
import org.eclipse.winery.yaml.model.support.TMapPropertyFilterDefinition;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tNodeFilter", namespace = " http://docs.oasis-open.org/tosca/ns/simple/yaml/1.0", propOrder = {
		"properties",
		"capabilities"
})
public class TNodeFilterDefinition {
	private List<TMapPropertyFilterDefinition> properties;
	private List<TMapObjectValue> capabilities;

	public List<TMapPropertyFilterDefinition> getProperties() {
		return properties;
	}

	public void setProperties(List<TMapPropertyFilterDefinition> properties) {
		this.properties = properties;
	}

	public List<TMapObjectValue> getCapabilities() {
		return capabilities;
	}

	public void setCapabilities(List<TMapObjectValue> capabilities) {
		this.capabilities = capabilities;
	}
}
