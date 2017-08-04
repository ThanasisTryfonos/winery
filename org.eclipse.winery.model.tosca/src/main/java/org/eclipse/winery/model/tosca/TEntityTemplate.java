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
 *    Christoph Kleine - additional code contribution
 *******************************************************************************/

package org.eclipse.winery.model.tosca;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.w3c.dom.Element;


/**
 * Java class for tEntityTemplate complex type.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tEntityTemplate", propOrder = {
		"properties",
		"propertyConstraints"
})
@XmlSeeAlso({
		TArtifactTemplate.class,
		TPolicyTemplate.class,
		TCapability.class,
		TRequirement.class,
		TRelationshipTemplate.class,
		TNodeTemplate.class
})
public abstract class TEntityTemplate extends HasId {

	@XmlElement(name = "Properties")
	protected TEntityTemplate.Properties properties;

	@XmlElement(name = "PropertyConstraints")
	protected TEntityTemplate.PropertyConstraints propertyConstraints;

	@XmlAttribute(name = "type", required = true)
	protected QName type;

	public TEntityTemplate() {
		super();
	}

	public TEntityTemplate(String id) {
		super(id);
	}

	public TEntityTemplate(Builder builder) {
		super(builder);
		this.properties = builder.properties;
		this.propertyConstraints = builder.propertyConstraints;
		this.type = builder.type;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof TEntityTemplate)) return false;
		if (!super.equals(o)) return false;
		TEntityTemplate that = (TEntityTemplate) o;
		return Objects.equals(properties, that.properties) &&
				Objects.equals(propertyConstraints, that.propertyConstraints) &&
				Objects.equals(type, that.type);
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), properties, propertyConstraints, type);
	}

	/**
	 * Gets the value of the properties property.
	 *
	 * @return possible object is {@link TEntityTemplate.Properties }
	 */
	/*@Nullable*/
	public TEntityTemplate.Properties getProperties() {
		return properties;
	}

	/**
	 * Sets the value of the properties property.
	 *
	 * @param value allowed object is {@link TEntityTemplate.Properties }
	 */
	public void setProperties(TEntityTemplate.Properties value) {
		this.properties = value;
	}

	/**
	 * Gets the value of the propertyConstraints property.
	 *
	 * @return possible object is {@link TEntityTemplate.PropertyConstraints }
	 */
	/*@Nullable*/
	public TEntityTemplate.PropertyConstraints getPropertyConstraints() {
		return propertyConstraints;
	}

	/**
	 * Sets the value of the propertyConstraints property.
	 *
	 * @param value allowed object is {@link TEntityTemplate.PropertyConstraints }
	 */
	public void setPropertyConstraints(TEntityTemplate.PropertyConstraints value) {
		this.propertyConstraints = value;
	}

	/**
	 * Gets the value of the type property.
	 *
	 * @return possible object is {@link QName }
	 */
	@NonNull
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

	/**
	 * <p>Java class for anonymous complex type.
	 *
	 * <p>The following schema fragment specifies the expected content contained within this class.
	 *
	 * <pre>
	 * &lt;complexType>
	 *   &lt;complexContent>
	 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
	 *       &lt;sequence>
	 *         &lt;any processContents='lax' namespace='##other'/>
	 *       &lt;/sequence>
	 *     &lt;/restriction>
	 *   &lt;/complexContent>
	 * &lt;/complexType>
	 * </pre>
	 */
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = {
			"any"
	})
	public static class Properties {

		@XmlAnyElement(lax = true)
		protected Object any;

		/**
		 * Gets the value of the any property.
		 *
		 * @return possible object is {@link Element } {@link Object }
		 */
		@Nullable
		public Object getAny() {
			return any;
		}

		/**
		 * Sets the value of the any property.
		 *
		 * @param value allowed object is {@link Element } {@link Object }
		 */
		public void setAny(Object value) {
			this.any = value;
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
	 *       &lt;sequence>
	 *         &lt;element name="PropertyConstraint" type="{http://docs.oasis-open.org/tosca/ns/2011/12}tPropertyConstraint"
	 * maxOccurs="unbounded"/>
	 *       &lt;/sequence>
	 *     &lt;/restriction>
	 *   &lt;/complexContent>
	 * &lt;/complexType>
	 * </pre>
	 */
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = {
			"propertyConstraint"
	})
	public static class PropertyConstraints {

		@XmlElement(name = "PropertyConstraint", required = true)
		protected List<TPropertyConstraint> propertyConstraint;

		/**
		 * Gets the value of the propertyConstraint property.
		 *
		 * <p>
		 * This accessor method returns a reference to the live list,
		 * not a snapshot. Therefore any modification you make to the
		 * returned list will be present inside the JAXB object.
		 * This is why there is not a <CODE>set</CODE> method for the propertyConstraint property.
		 *
		 * <p>
		 * For example, to add a new item, do as follows:
		 * <pre>
		 *    getPropertyConstraint().add(newItem);
		 * </pre>
		 *
		 *
		 * <p>
		 * Objects of the following type(s) are allowed in the list
		 * {@link TPropertyConstraint }
		 */
		@NonNull
		public List<TPropertyConstraint> getPropertyConstraint() {
			if (propertyConstraint == null) {
				propertyConstraint = new ArrayList<TPropertyConstraint>();
			}
			return this.propertyConstraint;
		}
	}

	public static class Builder extends HasId.Builder {
		private final QName type;
		private TEntityTemplate.Properties properties;
		private TEntityTemplate.PropertyConstraints propertyConstraints;

		public Builder(String id, QName type) {
			super(id);
			this.type = type;
		}

		public Builder(TEntityTemplate entityTemplate) {
			super(entityTemplate);
			this.type = entityTemplate.getType();
			this.properties = entityTemplate.getProperties();
			this.addPropertyConstraints(entityTemplate.getPropertyConstraints());
		}

		public Builder setProperties(TEntityTemplate.Properties properties) {
			this.properties = properties;
			return this;
		}

		public Builder setPropertyConstraints(TEntityTemplate.PropertyConstraints propertyConstraints) {
			this.propertyConstraints = propertyConstraints;
			return this;
		}

		public Builder addPropertyConstraints(TEntityTemplate.PropertyConstraints propertyConstraints) {
			if (propertyConstraints == null || propertyConstraints.getPropertyConstraint().isEmpty()) {
				return this;
			}

			if (this.propertyConstraints == null) {
				this.propertyConstraints = propertyConstraints;
			} else {
				this.propertyConstraints.getPropertyConstraint().addAll(propertyConstraints.getPropertyConstraint());
			}
			return this;
		}

		public Builder addPropertyConstraints(List<TPropertyConstraint> propertyConstraints) {
			if (propertyConstraints == null) {
				return this;
			}

			TEntityTemplate.PropertyConstraints tmp = new TEntityTemplate.PropertyConstraints();
			tmp.getPropertyConstraint().addAll(propertyConstraints);
			return addPropertyConstraints(tmp);
		}

		public Builder addPropertyConstraints(TPropertyConstraint propertyConstraints) {
			if (propertyConstraints == null) {
				return this;
			}

			TEntityTemplate.PropertyConstraints tmp = new TEntityTemplate.PropertyConstraints();
			tmp.getPropertyConstraint().add(propertyConstraints);
			return addPropertyConstraints(tmp);
		}
	}
}
