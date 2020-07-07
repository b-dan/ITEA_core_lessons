package DomParser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import ua.itea.Dependencies;

public class MainDom {
	public static void main(String[] args) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setValidating(false);
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(new File("pom.xml"));
			NodeList ns = doc.getElementsByTagName("dependencies");
			Node node = ns.item(0);

			NodeList nChildNodes = node.getChildNodes();

			List<Dependencies> dependencies = new ArrayList<Dependencies>();

			for(int i = 0; i < nChildNodes.getLength(); i++) {
				Node nodeChild = nChildNodes.item(i);
				Dependencies dep = new Dependencies();
				if(nodeChild.getNodeType() == 1) {

					NodeList nGroupId = ((Element) nodeChild).getElementsByTagName("groupId");
					NodeList nArtifactId = ((Element) nodeChild).getElementsByTagName("artifactId");
					NodeList nVersion = ((Element) nodeChild).getElementsByTagName("version");
					NodeList nScope = ((Element) nodeChild).getElementsByTagName("scope");

					dep.setGroupId(nGroupId.item(0).getTextContent());
					dep.setArtifactId(nArtifactId.item(0).getTextContent());
					dep.setVersion(nVersion.item(0).getTextContent());
					
					if(nScope.getLength() != 0) {
						dep.setScope(nScope.item(0).getTextContent());
					}
					dependencies.add(dep);
				}
			}
			System.out.println(dependencies);

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
