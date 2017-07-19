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
package org.eclipse.winery.model.tosca.yaml;

import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import org.eclipse.winery.model.tosca.yaml.visitor.IException;
import org.eclipse.winery.model.tosca.yaml.visitor.IParameter;
import org.eclipse.winery.model.tosca.yaml.visitor.IResult;
import org.eclipse.winery.model.tosca.yaml.visitor.IVisitor;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tRelationshipAssignment", namespace = " http://docs.oasis-open.org/tosca/ns/simple/yaml/1.0", propOrder = {
		"type",
		"properties",
		"interfaces"
})
public class TRelationshipAssignment {
	private String type;
	private Map<String, TPropertyAssignment> properties;
	private Map<String, TInterfaceAssignment> interfaces;

	public TRelationshipAssignment() {
	}

	public TRelationshipAssignment(String type) {
		this.type = type;
	}

	public TRelationshipAssignment(Builder builder) {
		this.setType(builder.type);
		this.setProperties(builder.properties);
		this.setInterfaces(builder.interfaces);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Map<String, TPropertyAssignment> getProperties() {
		return properties;
	}

	public void setProperties(Map<String, TPropertyAssignment> properties) {
		this.properties = properties;
	}

	public Map<String, TInterfaceAssignment> getInterfaces() {
		return interfaces;
	}

	public void setInterfaces(Map<String, TInterfaceAssignment> interfaces) {
		this.interfaces = interfaces;
	}

	public IResult accept(IVisitor visitor, IParameter parameter) throws IException {
		return visitor.visit(this, parameter);
	}

	public static class Builder {
		private final String type;
		private Map<String, TPropertyAssignment> properties;
		private Map<String, TInterfaceAssignment> interfaces;

		public Builder(String type) {
			this.type = type;
		}

		public Builder setProperties(Map<String, TPropertyAssignment> properties) {
			this.properties = properties;
			return this;
		}

		public Builder setInterfaces(Map<String, TInterfaceAssignment> interfaces) {
			this.interfaces = interfaces;
			return this;
		}

		public TRelationshipAssignment build() {
			return new TRelationshipAssignment(this);
		}
	}
}