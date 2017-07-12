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

import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tTopologyTemplate", namespace = " http://docs.oasis-open.org/tosca/ns/simple/yaml/1.0", propOrder = {
		"description",
		"inputs",
		"node_templates",
		"relationship_templates",
		"groups",
		"policies",
		"outputs",
		"substitution_mappings"
})
public class TTopologyTemplateDefinition {
	private String description;
	private Map<String, TParameterDefinition> inputs;
	private Map<String, TNodeTemplate> node_templates;
	private Map<String, TRelationshipTemplate> relationship_templates;
	private Map<String, TGroupDefinition> groups;
	private Map<String, TPolicyDefinition> policies;
	private Map<String, TParameterDefinition> outputs;
	private TSubstitutionMappings substitution_mappings;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Map<String, TParameterDefinition> getInputs() {
		return inputs;
	}

	public void setInputs(Map<String, TParameterDefinition> inputs) {
		this.inputs = inputs;
	}

	public Map<String, TNodeTemplate> getNode_templates() {
		return node_templates;
	}

	public void setNode_templates(Map<String, TNodeTemplate> node_templates) {
		this.node_templates = node_templates;
	}

	public Map<String, TRelationshipTemplate> getRelationship_templates() {
		return relationship_templates;
	}

	public void setRelationship_templates(Map<String, TRelationshipTemplate> relationship_templates) {
		this.relationship_templates = relationship_templates;
	}

	public Map<String, TGroupDefinition> getGroups() {
		return groups;
	}

	public void setGroups(Map<String, TGroupDefinition> groups) {
		this.groups = groups;
	}

	public Map<String, TPolicyDefinition> getPolicies() {
		return policies;
	}

	public void setPolicies(Map<String, TPolicyDefinition> policies) {
		this.policies = policies;
	}

	public Map<String, TParameterDefinition> getOutputs() {
		return outputs;
	}

	public void setOutputs(Map<String, TParameterDefinition> outputs) {
		this.outputs = outputs;
	}

	public TSubstitutionMappings getSubstitution_mappings() {
		return substitution_mappings;
	}

	public void setSubstitution_mappings(TSubstitutionMappings substitution_mappings) {
		this.substitution_mappings = substitution_mappings;
	}
}
