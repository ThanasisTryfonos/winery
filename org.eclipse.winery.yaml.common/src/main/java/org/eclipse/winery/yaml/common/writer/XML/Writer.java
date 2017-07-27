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
package org.eclipse.winery.yaml.common.writer.XML;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.eclipse.winery.model.tosca.TDefinitions;

import com.sun.xml.internal.bind.marshaller.NamespacePrefixMapper;

public class Writer {
	public void writeXML(TDefinitions definitions, String fileName) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(TDefinitions.class);

		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.setProperty("com.sun.xml.internal.bind.namespacePrefixMapper", new NamespacePrefixMapper() {
			@Override
			public String getPreferredPrefix(String s, String s1, boolean b) {
				return "tosca";
			}
		});

		File file = new File(fileName);
		file.getParentFile().mkdirs();
		marshaller.marshal(definitions, file);
	}
}