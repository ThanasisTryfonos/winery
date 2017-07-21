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
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.namespace.QName;


/**
 * <p>Java class for tEntityType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="tEntityType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://docs.oasis-open.org/tosca/ns/2011/12}tExtensibleElements">
 *       &lt;sequence>
 *         &lt;element name="Tags" type="{http://docs.oasis-open.org/tosca/ns/2011/12}tTags" minOccurs="0"/>
 *         &lt;element name="DerivedFrom" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="typeRef" use="required" type="{http://www.w3.org/2001/XMLSchema}QName" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="PropertiesDefinition" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="element" type="{http://www.w3.org/2001/XMLSchema}QName" />
 *                 &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}QName" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" />
 *       &lt;attribute name="abstract" type="{http://docs.oasis-open.org/tosca/ns/2011/12}tBoolean" default="no" />
 *       &lt;attribute name="final" type="{http://docs.oasis-open.org/tosca/ns/2011/12}tBoolean" default="no" />
 *       &lt;attribute name="targetNamespace" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *       &lt;anyAttribute processContents='lax' namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tEntityType", propOrder = {
		"tags",
		"derivedFrom",
		"propertiesDefinition"
})
@XmlSeeAlso({
		TNodeType.class,
		TRelationshipType.class,
		TRequirementType.class,
		TCapabilityType.class,
		TArtifactType.class,
		TPolicyType.class
})
public abstract class TEntityType extends TExtensibleElements {
	@XmlElement(name = "Tags")
	protected TTags tags;
	@XmlElement(name = "DerivedFrom")
	protected TEntityType.DerivedFrom derivedFrom;
	@XmlElement(name = "PropertiesDefinition")
	protected TEntityType.PropertiesDefinition propertiesDefinition;
	@XmlAttribute(name = "name", required = true)
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	@XmlSchemaType(name = "NCName")
	protected String name;
	@XmlAttribute(name = "abstract")
	protected TBoolean _abstract;
	@XmlAttribute(name = "final")
	protected TBoolean _final;
	@XmlAttribute(name = "targetNamespace")
	@XmlSchemaType(name = "anyURI")
	protected String targetNamespace;

	public TEntityType() {
	}

	public TEntityType(Builder builder) {
		super(builder);
		this.tags = builder.tags;
		this.derivedFrom = builder.derivedFrom;
		this.propertiesDefinition = builder.propertiesDefinition;
		this.name = builder.name;
		this._abstract = builder._abstract;
		this._final = builder._final;
		this.targetNamespace = builder.targetNamespace;
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
	 * @return possible object is {@link TEntityType.DerivedFrom }
	 */
	public TEntityType.DerivedFrom getDerivedFrom() {
		return derivedFrom;
	}

	/**
	 * Sets the value of the derivedFrom property.
	 *
	 * @param value allowed object is {@link TEntityType.DerivedFrom }
	 */
	public void setDerivedFrom(TEntityType.DerivedFrom value) {
		this.derivedFrom = value;
	}

	/**
	 * Gets the value of the propertiesDefinition property.
	 *
	 * @return possible object is {@link TEntityType.PropertiesDefinition }
	 */
	public TEntityType.PropertiesDefinition getPropertiesDefinition() {
		return propertiesDefinition;
	}

	/**
	 * Sets the value of the propertiesDefinition property.
	 *
	 * @param value allowed object is {@link TEntityType.PropertiesDefinition }
	 */
	public void setPropertiesDefinition(TEntityType.PropertiesDefinition value) {
		this.propertiesDefinition = value;
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
	 * <p>Java class for anonymous complex type.
	 *
	 * <p>The following schema fragment specifies the expected content contained within this class.
	 *
	 * <pre>
	 * &lt;complexType>
	 *   &lt;complexContent>
	 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
	 *       &lt;attribute name="typeRef" use="required" type="{http://www.w3.org/2001/XMLSchema}QName" />
	 *     &lt;/restriction>
	 *   &lt;/complexContent>
	 * &lt;/complexType>
	 * </pre>
	 */
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "")
	public static class DerivedFrom {

		@XmlAttribute(name = "typeRef", required = true)
		protected QName typeRef;

		/**
		 * Gets the value of the typeRef property.
		 *
		 * @return possible object is {@link QName }
		 */
		public QName getTypeRef() {
			return typeRef;
		}

		/**
		 * Sets the value of the typeRef property.
		 *
		 * @param value allowed object is {@link QName }
		 */
		public void setTypeRef(QName value) {
			this.typeRef = value;
		}
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
	 *       &lt;attribute name="element" type="{http://www.w3.org/2001/XMLSchema}QName" />
	 *       &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}QName" />
	 *     &lt;/restriction>
	 *   &lt;/complexContent>
	 * &lt;/complexType>
	 * </pre>
	 */
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "")
	public static class PropertiesDefinition {

		@XmlAttribute(name = "element")
		protected QName element;
		@XmlAttribute(name = "type")
		protected QName type;

		/**
		 * Gets the value of the element property.
		 *
		 * @return possible object is {@link QName }
		 */
		public QName getElement() {
			return element;
		}

		/**
		 * Sets the value of the element property.
		 *
		 * @param value allowed object is {@link QName }
		 */
		public void setElement(QName value) {
			this.element = value;
		}

		/**
		 * Gets the value of the type property.
		 *
		 * @return possible object is {@link QName }
		 */
		public QName getType() {
			return type;
		}

		/**
		 * Sets the value of the type property.
		 *
		 * @param value allowed object is {@link QName }
		 */
		public void setType(QName value) {
			this.type = value;
		}
	}

	public static class Builder extends TExtensibleElements.Builder {
		private final String name;

		private TTags tags;
		private TEntityType.DerivedFrom derivedFrom;
		private TEntityType.PropertiesDefinition propertiesDefinition;
		private TBoolean _abstract;
		private TBoolean _final;
		private String targetNamespace = null;

		public Builder(String name) {
			this.name = name;
		}

		public Builder(TEntityType entityType) {
			super(entityType);
			this.name = entityType.getName();
			this.derivedFrom = entityType.getDerivedFrom();
			this.tags = entityType.getTags();
			this._abstract = entityType.getAbstract();
			this._final = entityType.getFinal();
			this.targetNamespace = entityType.getTargetNamespace();
			this.propertiesDefinition = entityType.getPropertiesDefinition();
		}

		public Builder RMsetTags(TTags tags) {
			this.tags = tags;
			return this;
		}

		public Builder RMsetDerivedFrom(TEntityType.DerivedFrom derivedFrom) {
			this.derivedFrom = derivedFrom;
			return this;
		}

		public Builder RMsetDerivedFrom(QName derivedFrom) {
			if (derivedFrom == null) {
				return this;
			}

			if (this.derivedFrom == null) {
				this.derivedFrom = new TEntityType.DerivedFrom();
			}
			this.derivedFrom.setTypeRef(derivedFrom);
			return this;
		}

		public Builder RMsetDerivedFrom(String derivedFrom) {
			if (derivedFrom == null || derivedFrom.length() == 0) {
				return this;
			}

			return RMsetDerivedFrom(new QName(derivedFrom));
		}

		public Builder RMsetPropertiesDefinition(PropertiesDefinition propertiesDefinition) {
			this.propertiesDefinition = propertiesDefinition;
			return this;
		}

		public Builder RMsetAbstract(TBoolean _abstract) {
			this._abstract = _abstract;
			return this;
		}

		public Builder RMsetAbstract(Boolean _abstract) {
			if (this._abstract == null) {
				return this;
			}

			return RMsetAbstract(_abstract ? TBoolean.YES : TBoolean.NO);
		}

		public Builder RMsetFinal(TBoolean _final) {
			this._final = _final;
			return this;
		}

		public Builder RMsetFinal(Boolean _final) {
			if (this._final == null) {
				return this;
			}

			return RMsetFinal(_final ? TBoolean.YES : TBoolean.NO);
		}

		public Builder RMsetTargetNamespace(String targetNamespace) {
			this.targetNamespace = targetNamespace;
			return this;
		}

		public Builder addTags(TTags tags) {
			if (tags == null) {
				return this;
			}

			if (this.tags == null) {
				this.tags = tags;
			} else {
				this.tags.getTag().addAll(tags.getTag());
			}
			return this;
		}

		public Builder addTag(TTag tag) {
			if (tag == null) {
				return this;
			}

			TTags tmp = new TTags();
			tmp.getTag().add(tag);
			return addTags(tmp);
		}

		public Builder addTag(String key, String value) {
			if (value == null) {
				return this;
			}

			TTag tag = new TTag();
			tag.setName(key);
			tag.setValue(value);
			return this.addTag(tag);
		}
	}
}
