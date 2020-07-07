package SaxParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import ua.itea.Dependencies;

public class PomSaxParser extends DefaultHandler{
	private List<Dependencies> dependencies = new ArrayList<Dependencies>();
	private static final String DEPENDENCY = "dependency";
	private static final String GROUPID = "groupId";
	private static final String ARTIFACTID = "artifactId";
	private static final String VERSION = "version";
	private static final String SCOPE = "scope";
	private Dependencies tmpDependencies = new Dependencies();
	private boolean isArtifactId;
	private boolean isGroupId;
	private boolean isVersion;
	private boolean isScope;
	
	public List<Dependencies> getDependencies(){
		return dependencies;
	}
	@Override
	public void startDocument() throws SAXException {
		//System.out.println("Start document");
	}
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if(Objects.equals(qName, DEPENDENCY)) {
			tmpDependencies= new Dependencies();
		}
		if(Objects.equals(qName, GROUPID)) {
			isGroupId = true;
		}
		if(Objects.equals(qName, ARTIFACTID)) {
			isArtifactId = true;
		}
		if(Objects.equals(qName, VERSION )) {
			isVersion = true;
		}
		if(Objects.equals(qName, SCOPE)) {
			isScope = true;
		}
	}
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String value = "";
		for(int i = start; i< start+length; i++) {
			value+=ch[i];
		}
		if(value.length()>0) {
			if(isGroupId) {
				tmpDependencies.setGroupId(value);
				isGroupId=false;
			}
			if(isArtifactId) {
				tmpDependencies.setArtifactId(value);
				isArtifactId=false;
			}
			if(isVersion) {
				tmpDependencies.setVersion(value);
				isVersion=false;
			}
			if(isScope) {
				tmpDependencies.setScope(value);
				isScope=false;
			}
		}
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if(Objects.equals(qName, DEPENDENCY)) {
			dependencies.add(tmpDependencies);
		}
	}
	@Override
	public void endDocument() throws SAXException {
		//System.out.println("End document");
	}
	

}
