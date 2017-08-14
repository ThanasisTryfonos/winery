package org.eclipse.winery.repository.patterndetection.model.patterns;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.eclipse.winery.repository.patterndetection.model.RelationshipEdge;
import org.eclipse.winery.repository.patterndetection.model.PatternComponent;

import org.jgrapht.DirectedGraph;
import org.jgrapht.graph.DefaultDirectedGraph;

/**
 * Created by marvin on 15.05.2017.
 */
public class ExecutionEnvironmentPattern {

	private static final String propertiesFilename = "patterndetection.properties";

	private Properties properties;

	private String os;
	private String service;
	private String application;
	private String hostedOn;
	private String dependsOn;

	private DirectedGraph<PatternComponent, RelationshipEdge> pattern;

	public ExecutionEnvironmentPattern() {
		properties = new Properties();
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propertiesFilename);
		try {
			properties.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		service = properties.getProperty("labelService");
		os = properties.getProperty("labelOS");
		application = properties.getProperty("labelApp");

		dependsOn = properties.getProperty("relationDependsOn");
		hostedOn = properties.getProperty("relationHostedOn");

		pattern = new DefaultDirectedGraph<>(RelationshipEdge.class);

		PatternComponent operatingSystem = new PatternComponent(os, 1, 1);
		PatternComponent serviceComponent = new PatternComponent(service, 1, Integer.MAX_VALUE);
		PatternComponent appComponent1 = new PatternComponent(application, 1, 1);
		//PatternComponent appComponent2 = new PatternComponent(application, 1 ,1);

		pattern.addVertex(operatingSystem);
		pattern.addVertex(serviceComponent);
		pattern.addVertex(appComponent1);
		//pattern.addVertex(appComponent2);

		pattern.addEdge(serviceComponent, operatingSystem, new RelationshipEdge(serviceComponent, operatingSystem, hostedOn));
		pattern.addEdge(appComponent1, serviceComponent, new RelationshipEdge(appComponent1, serviceComponent, dependsOn));
		//pattern.addEdge(appComponent2, serviceComponent, new RelationshipEdge(appComponent2, serviceComponent, dependsOn));
	}

	public DirectedGraph<PatternComponent, RelationshipEdge> getPatternGraph() {
		return pattern;
	}
}
