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

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import org.eclipse.winery.model.tosca.yaml.support.TMapRequirementDefinition;
import org.eclipse.winery.model.tosca.yaml.visitor.AbstractParameter;
import org.eclipse.winery.model.tosca.yaml.visitor.AbstractResult;
import org.eclipse.winery.model.tosca.yaml.visitor.IException;
import org.eclipse.winery.model.tosca.yaml.visitor.IVisitor;

import org.eclipse.jdt.annotation.NonNull;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tNodeType", namespace = " http://docs.oasis-open.org/tosca/ns/simple/yaml/1.0", propOrder = {
		"attributes",
		"requirements",
		"capabilities",
		"interfaces",
		"artifacts"
})
public class TNodeType extends TNodeOrGroupType {
	private Map<String, TAttributeDefinition> attributes;
	private List<TMapRequirementDefinition> requirements;
	private Map<String, TCapabilityDefinition> capabilities;
	private Map<String, TInterfaceDefinition> interfaces;
	private Map<String, TArtifactDefinition> artifacts;

	public TNodeType() {
	}

	public TNodeType(Builder builder) {
		super(builder);
		this.setAttributes(builder.attributes);
		this.setRequirements(builder.requirements);
		this.setCapabilities(builder.capabilities);
		this.setInterfaces(builder.interfaces);
		this.setArtifacts(builder.artifacts);
	}

	@NonNull
	public Map<String, TAttributeDefinition> getAttributes() {
		if (attributes == null) {
			attributes = new LinkedHashMap<>();
		}
		return attributes;
	}

	public void setAttributes(Map<String, TAttributeDefinition> attributes) {
		this.attributes = attributes;
	}

	@NonNull
	public List<TMapRequirementDefinition> getRequirements() {
		if (requirements == null) {
			requirements = new ArrayList<>();
		}

		return requirements;
	}

	public void setRequirements(List<TMapRequirementDefinition> requirements) {
		this.requirements = requirements;
	}

	@NonNull
	public Map<String, TCapabilityDefinition> getCapabilities() {
		if (this.capabilities == null) {
			this.capabilities = new LinkedHashMap<>();
		}

		return capabilities;
	}

	public void setCapabilities(Map<String, TCapabilityDefinition> capabilities) {
		this.capabilities = capabilities;
	}

	@NonNull
	public Map<String, TInterfaceDefinition> getInterfaces() {
		if (this.interfaces == null) {
			this.interfaces = new LinkedHashMap<>();
		}

		return interfaces;
	}

	public void setInterfaces(Map<String, TInterfaceDefinition> interfaces) {
		this.interfaces = interfaces;
	}

	@NonNull
	public Map<String, TArtifactDefinition> getArtifacts() {
		if (this.artifacts == null) {
			this.artifacts = new LinkedHashMap<>();
		}

		return artifacts;
	}

	public void setArtifacts(Map<String, TArtifactDefinition> artifacts) {
		this.artifacts = artifacts;
	}

	public <R extends AbstractResult<R>, P extends AbstractParameter<P>> R accept(IVisitor<R, P> visitor, P parameter) throws IException {
		R ir1 = super.accept(visitor, parameter);
		R ir2 = visitor.visit(this, parameter);
		if (ir1 == null) {
			return ir2;
		} else {
			return ir1.add(ir2);
		}
	}

	public static class Builder extends TEntityType.Builder {
		private Map<String, TAttributeDefinition> attributes;
		private List<TMapRequirementDefinition> requirements;
		private Map<String, TCapabilityDefinition> capabilities;
		private Map<String, TInterfaceDefinition> interfaces;
		private Map<String, TArtifactDefinition> artifacts;

		public Builder() {

		}

		public Builder(TEntityType entityType) {
			super(entityType);
		}

		public Builder setAttributes(Map<String, TAttributeDefinition> attributes) {
			this.attributes = attributes;
			return this;
		}

		public Builder setRequirements(List<TMapRequirementDefinition> requirements) {
			this.requirements = requirements;
			return this;
		}

		public Builder setCapabilities(Map<String, TCapabilityDefinition> capabilities) {
			this.capabilities = capabilities;
			return this;
		}

		public Builder setInterfaces(Map<String, TInterfaceDefinition> interfaces) {
			this.interfaces = interfaces;
			return this;
		}

		public Builder setArtifacts(Map<String, TArtifactDefinition> artifacts) {
			this.artifacts = artifacts;
			return this;
		}

		public TNodeType build() {
			return new TNodeType(this);
		}
	}
}
