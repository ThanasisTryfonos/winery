/*******************************************************************************
 * Copyright (c) 2013-2017 University of Stuttgart
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and the Apache License 2.0 which both accompany this distribution,
 * and are available at http://www.eclipse.org/legal/epl-v10.html
 * and http://www.apache.org/licenses/LICENSE-2.0
 *
 * Contributors:
 *    Oliver Kopp - initial code generation using vhudson-jaxb-ri-2.1-2
 *    Christoph Kleine - Builder implementation
 *******************************************************************************/

package org.eclipse.winery.model.tosca;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.namespace.QName;


/**
 * <p>Java class for tNodeTypeImplementation complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="tNodeTypeImplementation">
 *   &lt;complexContent>
 *     &lt;extension base="{http://docs.oasis-open.org/tosca/ns/2011/12}tExtensibleElements">
 *       &lt;sequence>
 *         &lt;element name="Tags" type="{http://docs.oasis-open.org/tosca/ns/2011/12}tTags" minOccurs="0"/>
 *         &lt;element name="DerivedFrom" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="nodeTypeImplementationRef" use="required" type="{http://www.w3.org/2001/XMLSchema}QName"
 * />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="RequiredContainerFeatures" type="{http://docs.oasis-open.org/tosca/ns/2011/12}tRequiredContainerFeatures"
 * minOccurs="0"/>
 *         &lt;element name="ImplementationArtifacts" type="{http://docs.oasis-open.org/tosca/ns/2011/12}tImplementationArtifacts"
 * minOccurs="0"/>
 *         &lt;element name="DeploymentArtifacts" type="{http://docs.oasis-open.org/tosca/ns/2011/12}tDeploymentArtifacts"
 * minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" />
 *       &lt;attribute name="targetNamespace" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *       &lt;attribute name="nodeType" use="required" type="{http://www.w3.org/2001/XMLSchema}QName" />
 *       &lt;attribute name="abstract" type="{http://docs.oasis-open.org/tosca/ns/2011/12}tBoolean" default="no" />
 *       &lt;attribute name="final" type="{http://docs.oasis-open.org/tosca/ns/2011/12}tBoolean" default="no" />
 *       &lt;anyAttribute processContents='lax' namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tNodeTypeImplementation", propOrder = {
		"tags",
		"derivedFrom",
		"requiredContainerFeatures",
		"implementationArtifacts",
		"deploymentArtifacts"
})
public class TNodeTypeImplementation extends TExtensibleElements {
	@XmlElement(name = "Tags")
	protected TTags tags;
	@XmlElement(name = "DerivedFrom")
	protected TNodeTypeImplementation.DerivedFrom derivedFrom;
	@XmlElement(name = "RequiredContainerFeatures")
	protected TRequiredContainerFeatures requiredContainerFeatures;
	@XmlElement(name = "ImplementationArtifacts")
	protected TImplementationArtifacts implementationArtifacts;
	@XmlElement(name = "DeploymentArtifacts")
	protected TDeploymentArtifacts deploymentArtifacts;
	@XmlAttribute(name = "name", required = true)
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	@XmlSchemaType(name = "NCName")
	protected String name;
	@XmlAttribute(name = "targetNamespace")
	@XmlSchemaType(name = "anyURI")
	protected String targetNamespace;
	@XmlAttribute(name = "nodeType", required = true)
	protected QName nodeType;
	@XmlAttribute(name = "abstract")
	protected TBoolean _abstract;
	@XmlAttribute(name = "final")
	protected TBoolean _final;

	public TNodeTypeImplementation() {
	}

	public TNodeTypeImplementation(Builder builder) {
		super(builder);
		this.tags = builder.tags;
		this.derivedFrom = builder.derivedFrom;
		this.requiredContainerFeatures = builder.requiredContainerFeatures;
		this.implementationArtifacts = builder.implementationArtifacts;
		this.deploymentArtifacts = builder.deploymentArtifacts;
		this.name = builder.name;
		this.targetNamespace = builder.targetNamespace;
		this.nodeType = builder.nodeType;
		this._abstract = builder._abstract;
		this._final = builder._final;
	}

	/**
	 * Gets the value of the tags property.
	 *
	 * @return possible object is {@link TTags }
	 */
	public TTags getTags() {
		return tags;
	}

	/**
	 * Sets the value of the tags property.
	 *
	 * @param value allowed object is {@link TTags }
	 */
	public void setTags(TTags value) {
		this.tags = value;
	}

	/**
	 * Gets the value of the derivedFrom property.
	 *
	 * @return possible object is {@link TNodeTypeImplementation.DerivedFrom }
	 */
	public TNodeTypeImplementation.DerivedFrom getDerivedFrom() {
		return derivedFrom;
	}

	/**
	 * Sets the value of the derivedFrom property.
	 *
	 * @param value allowed object is {@link TNodeTypeImplementation.DerivedFrom }
	 */
	public void setDerivedFrom(TNodeTypeImplementation.DerivedFrom value) {
		this.derivedFrom = value;
	}

	/**
	 * Gets the value of the requiredContainerFeatures property.
	 *
	 * @return possible object is {@link TRequiredContainerFeatures }
	 */
	public TRequiredContainerFeatures getRequiredContainerFeatures() {
		return requiredContainerFeatures;
	}

	/**
	 * Sets the value of the requiredContainerFeatures property.
	 *
	 * @param value allowed object is {@link TRequiredContainerFeatures }
	 */
	public void setRequiredContainerFeatures(TRequiredContainerFeatures value) {
		this.requiredContainerFeatures = value;
	}

	/**
	 * Gets the value of the implementationArtifacts property.
	 *
	 * @return possible object is {@link TImplementationArtifacts }
	 */
	public TImplementationArtifacts getImplementationArtifacts() {
		return implementationArtifacts;
	}

	/**
	 * Sets the value of the implementationArtifacts property.
	 *
	 * @param value allowed object is {@link TImplementationArtifacts }
	 */
	public void setImplementationArtifacts(TImplementationArtifacts value) {
		this.implementationArtifacts = value;
	}

	/**
	 * Gets the value of the deploymentArtifacts property.
	 *
	 * @return possible object is {@link TDeploymentArtifacts }
	 */
	public TDeploymentArtifacts getDeploymentArtifacts() {
		return deploymentArtifacts;
	}

	/**
	 * Sets the value of the deploymentArtifacts property.
	 *
	 * @param value allowed object is {@link TDeploymentArtifacts }
	 */
	public void setDeploymentArtifacts(TDeploymentArtifacts value) {
		this.deploymentArtifacts = value;
	}

	/**
	 * Gets the value of the name property.
	 *
	 * @return possible object is {@link String }
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the value of the name property.
	 *
	 * @param value allowed object is {@link String }
	 */
	public void setName(String value) {
		this.name = value;
	}

	/**
	 * Gets the value of the targetNamespace property.
	 *
	 * @return possible object is {@link String }
	 */
	public String getTargetNamespace() {
		return targetNamespace;
	}

	/**
	 * Sets the value of the targetNamespace property.
	 *
	 * @param value allowed object is {@link String }
	 */
	public void setTargetNamespace(String value) {
		this.targetNamespace = value;
	}

	/**
	 * Gets the value of the nodeType property.
	 *
	 * @return possible object is {@link QName }
	 */
	public QName getNodeType() {
		return nodeType;
	}

	/**
	 * Sets the value of the nodeType property.
	 *
	 * @param value allowed object is {@link QName }
	 */
	public void setNodeType(QName value) {
		this.nodeType = value;
	}

	/**
	 * Gets the value of the abstract property.
	 *
	 * @return possible object is {@link TBoolean }
	 */
	public TBoolean getAbstract() {
		if (_abstract == null) {
			return TBoolean.NO;
		} else {
			return _abstract;
		}
	}

	/**
	 * Sets the value of the abstract property.
	 *
	 * @param value allowed object is {@link TBoolean }
	 */
	public void setAbstract(TBoolean value) {
		this._abstract = value;
	}

	/**
	 * Gets the value of the final property.
	 *
	 * @return possible object is {@link TBoolean }
	 */
	public TBoolean getFinal() {
		if (_final == null) {
			return TBoolean.NO;
		} else {
			return _final;
		}
	}

	/**
	 * Sets the value of the final property.
	 *
	 * @param value allowed object is {@link TBoolean }
	 */
	public void setFinal(TBoolean value) {
		this._final = value;
	}


	/**
	 * <p>Java class for anonymous complex type.
	 *
	 * <p>The following schema fragment specifies the expected content contained within this class.
	 *
	 * <pre>
	 * &lt;complexType>
	 *   &lt;complexContent>
	 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
	 *       &lt;attribute name="nodeTypeImplementationRef" use="required" type="{http://www.w3.org/2001/XMLSchema}QName"
	 * />
	 *     &lt;/restriction>
	 *   &lt;/complexContent>
	 * &lt;/complexType>
	 * </pre>
	 */
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "")
	public static class DerivedFrom {

		@XmlAttribute(name = "nodeTypeImplementationRef", required = true)
		protected QName nodeTypeImplementationRef;

		/**
		 * Gets the value of the nodeTypeImplementationRef property.
		 *
		 * @return possible object is {@link QName }
		 */
		public QName getNodeTypeImplementationRef() {
			return nodeTypeImplementationRef;
		}

		/**
		 * Sets the value of the nodeTypeImplementationRef property.
		 *
		 * @param value allowed object is {@link QName }
		 */
		public void setNodeTypeImplementationRef(QName value) {
			this.nodeTypeImplementationRef = value;
		}
	}

	public static class Builder extends TExtensibleElements.Builder {
		private final String name;
		private final QName nodeType;
		private TTags tags;
		private TNodeTypeImplementation.DerivedFrom derivedFrom;
		private TRequiredContainerFeatures requiredContainerFeatures;
		private TImplementationArtifacts implementationArtifacts;
		private TDeploymentArtifacts deploymentArtifacts;
		private String targetNamespace;
		private TBoolean _abstract;
		private TBoolean _final;

		public Builder(TExtensibleElements extensibleElements, String name, QName nodeType) {
			super(extensibleElements);
			this.name = name;
			this.nodeType = nodeType;
		}

		public Builder(String name, QName nodeType) {
			this(new TExtensibleElements(), name, nodeType);
		}

		public Builder setTags(TTags tags) {
			this.tags = tags;
			return this;
		}

		public Builder RMsetDerivedFrom(TNodeTypeImplementation.DerivedFrom derivedFrom) {
			this.derivedFrom = derivedFrom;
			return this;
		}

		public Builder RMsetRequiredContainerFeatures(TRequiredContainerFeatures requiredContainerFeatures) {
			this.requiredContainerFeatures = requiredContainerFeatures;
			return this;
		}

		public Builder RMsetImplementationArtifacts(TImplementationArtifacts implementationArtifacts) {
			this.implementationArtifacts = implementationArtifacts;
			return this;
		}

		public Builder RMsetDeploymentArtifacts(TDeploymentArtifacts deploymentArtifacts) {
			this.deploymentArtifacts = deploymentArtifacts;
			return this;
		}

		public Builder RMsetTargetNamespace(String targetNamespace) {
			this.targetNamespace = targetNamespace;
			return this;
		}

		public Builder RMset_abstract(TBoolean _abstract) {
			this._abstract = _abstract;
			return this;
		}

		public Builder RMset_final(TBoolean _final) {
			this._final = _final;
			return this;
		}

		public TNodeTypeImplementation build() {
			return new TNodeTypeImplementation(this);
		}
	}
}
