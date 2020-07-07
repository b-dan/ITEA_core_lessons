package ua.itea;

public class Dependencies {
	private String groupId;
	private String artifactId;
	private String version;
	private String scope;

	public Dependencies() {
		super();
		
	}

	

	public Dependencies(String groupId, String artifactId, String version, String scope) {
		super();
		this.groupId = groupId;
		this.artifactId = artifactId;
		this.version = version;
		this.scope = scope;
	}



	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getArtifactId() {
		return artifactId;
	}

	public void setArtifactId(String artifactId) {
		this.artifactId = artifactId;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}



	@Override
	public String toString() {
		return "Dependencies [groupId=" + groupId + ", artifactId=" + artifactId + ", version=" + version + ", scope="
				+ scope + "]";
	}

	

}
