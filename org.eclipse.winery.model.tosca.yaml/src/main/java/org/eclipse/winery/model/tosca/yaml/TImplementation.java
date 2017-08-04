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
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;

import org.eclipse.winery.model.tosca.yaml.visitor.AbstractParameter;
import org.eclipse.winery.model.tosca.yaml.visitor.AbstractResult;
import org.eclipse.winery.model.tosca.yaml.visitor.IException;
import org.eclipse.winery.model.tosca.yaml.visitor.IVisitor;

import org.eclipse.jdt.annotation.NonNull;

/**
 * Part of Operation Definition
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tImplementation", namespace = " http://docs.oasis-open.org/tosca/ns/simple/yaml/1.0", propOrder = {
		"primary",
		"dependencies"
})
public class TImplementation {
	@XmlAttribute(name = "primary", required = true)
	private QName primary;
	private List<QName> dependencies;

	public TImplementation() {

	}

	public TImplementation(QName primary) {
		this.primary = primary;
	}

	public TImplementation(Builder builder) {
		this.setPrimary(builder.primary);
		this.setDependencies(builder.dependencies);
	}

	@NonNull
	public QName getPrimary() {
		return primary;
	}

	public void setPrimary(QName primary) {
		this.primary = primary;
	}

	@NonNull
	public List<QName> getDependencies() {
		if (this.dependencies == null) {
			this.dependencies = new ArrayList<>();
		}

		return dependencies;
	}

	public void setDependencies(List<QName> dependencies) {
		this.dependencies = dependencies;
	}

	public <R extends AbstractResult<R>, P extends AbstractParameter<P>> R accept(IVisitor<R, P> visitor, P parameter) throws IException {
		return visitor.visit(this, parameter);
	}

	public static class Builder {
		private final QName primary;
		private List<QName> dependencies;

		public Builder(QName primary) {
			this.primary = primary;
		}

		public Builder setDependencies(List<QName> dependencies) {
			this.dependencies = dependencies;
			return this;
		}

		public TImplementation build() {
			return new TImplementation(this);
		}
	}
}
