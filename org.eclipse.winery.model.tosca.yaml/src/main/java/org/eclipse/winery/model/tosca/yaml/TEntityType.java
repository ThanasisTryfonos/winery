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

import org.eclipse.winery.model.tosca.yaml.support.Metadata;
import org.eclipse.winery.model.tosca.yaml.visitor.IException;
import org.eclipse.winery.model.tosca.yaml.visitor.IParameter;
import org.eclipse.winery.model.tosca.yaml.visitor.IResult;
import org.eclipse.winery.model.tosca.yaml.visitor.IVisitor;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tEntityType", namespace = " http://docs.oasis-open.org/tosca/ns/simple/yaml/1.0", propOrder = {
		"description",
		"version",
		"derived_from",
		"properties",
		"attributes",
		"metadata"
})
public class TEntityType {
	private String description;
	private TVersion version;
	private String derived_from;
	private Map<String, TPropertyDefinition> properties;
	private Map<String, TAttributeDefinition> attributes;
	private Metadata metadata;

	public TEntityType() {
	}

	public TEntityType(Builder builder) {
		this.setDescription(builder.description);
		this.setVersion(builder.version);
		this.setDerived_from(builder.derived_from);
		this.setProperties(builder.properties);
		this.setAttributes(builder.attributes);
		this.setMetadata(builder.metadata);
	}

	public static void init(TEntityType base, Builder builder) {
		base.setDescription(builder.description);
		base.setVersion(builder.version);
		base.setDerived_from(builder.derived_from);
		base.setProperties(builder.properties);
		base.setAttributes(builder.attributes);
		base.setMetadata(builder.metadata);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public TVersion getVersion() {
		return version;
	}

	public void setVersion(TVersion version) {
		this.version = version;
	}

	public void setVersion(String version) {
		TVersion tmp = new TVersion(version);
		setVersion(tmp);
	}

	public String getDerived_from() {
		return derived_from;
	}

	public void setDerived_from(String derived_from) {
		this.derived_from = derived_from;
	}

	public Map<String, TPropertyDefinition> getProperties() {
		return properties;
	}

	public void setProperties(Map<String, TPropertyDefinition> properties) {
		this.properties = properties;
	}

	public Map<String, TAttributeDefinition> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, TAttributeDefinition> attributes) {
		this.attributes = attributes;
	}

	public Metadata getMetadata() {
		return metadata;
	}

	public void setMetadata(Metadata metadata) {
		this.metadata = metadata;
	}

	public IResult accept(IVisitor visitor, IParameter parameter) throws IException {
		return visitor.visit(this, parameter);
	}

	public static class Builder {
		private String description;
		private TVersion version;
		private String derived_from;
		private Map<String, TPropertyDefinition> properties;
		private Map<String, TAttributeDefinition> attributes;
		private Metadata metadata;

		public Builder() {

		}

		public Builder(TEntityType entityType) {
			this.description = entityType.getDescription();
			this.version = entityType.getVersion();
			this.derived_from = entityType.getDerived_from();
			this.properties = entityType.getProperties();
			this.attributes = entityType.getAttributes();
			this.metadata = entityType.getMetadata();
		}

		public Builder setDescription(String description) {
			this.description = description;
			return this;
		}

		public Builder setVersion(TVersion version) {
			this.version = version;
			return this;
		}

		public Builder setDerived_from(String derived_from) {
			this.derived_from = derived_from;
			return this;
		}

		public Builder setProperties(Map<String, TPropertyDefinition> properties) {
			this.properties = properties;
			return this;
		}

		public Builder setAttributes(Map<String, TAttributeDefinition> attributes) {
			this.attributes = attributes;
			return this;
		}

		public Builder setMetadata(Metadata metadata) {
			if (this.metadata == null) {
				this.metadata = metadata;
			} else {
				this.metadata.putAll(metadata);
			}
			return this;
		}

		public Builder setMetadata(String key, String value) {
			Metadata metadata = new Metadata();
			metadata.put(key, value);
			return this.setMetadata(metadata);
		}

		public TEntityType build() {
			return new TEntityType(this);
		}
	}
}