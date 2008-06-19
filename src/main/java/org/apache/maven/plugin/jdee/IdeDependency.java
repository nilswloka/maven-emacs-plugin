/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.maven.plugin.jdee;

import java.io.File;

import org.apache.maven.project.MavenProject;

/**
 * Copyed from maven-eclipse-plugin and littlebit changed by Lukas Benda
 * @author Fabrizio Giustina
 * @author Lukas Benda - only small changes
 * @version $Id: IdeDependency.java 595476 2007-11-15 22:21:55Z aheritier $
 */
public class IdeDependency implements Comparable {

  /** Is it dependency of this project or some dependecie? */
  private boolean firstLevel;
  /** Is this a test dependency? */
  private boolean testDependency;
  /** Is this a system scope dependency? */
  private boolean systemScoped;
  /** Is this a provided dependency? */
  private boolean provided;
  /** Is this dependency added to classpath? */
  private boolean addedToClasspath;
  /** Resolved artifact file. */
  private File file;
  /** Resolved javadoc file. */
  private File javadocAttachment;
  /** Resolved source file. */
  private File sourceAttachment;
  /** Group id. */
  private String groupId;
  /** Artifact id. */
  private String artifactId;
  /** Artifact version. */
  private String version;
  /** Artifact classifier */
  private String classifier;
  /** Artifact type. */
  private String type;

  /** Creates an uninitialized instance */
  public IdeDependency() {
    super();
  }

  /** Create inialized instance
   * @param groupId Group id
   * @param artifactId Artifact id
   * @param version Artifact version
   * @param classifier Artifact classifier
   * @param firstLevel is this dependenci primary dependenci of this project
   *        or come with another dependencie?
   * @param testDependency Is this a test dependency?
   * @param systemScoped Is this a system scope dependency?
   * @param provided Is this a provided dependency?
   * @param addedToClasspath Is this dependency added to classpath?
   * @param file Resolved artifact file
   * @param type Artifact type
   * @param dependencyDepth Depth of this dependency in the transitive
   *        dependency trail.
   */
  public IdeDependency(String groupId, String artifactId, String version,
                       String classifier, boolean firstLevel,
                       boolean testDependency, boolean systemScoped,
                       boolean provided, boolean addedToClasspath,
                       File file, String type, int dependencyDepth) {
    // group:artifact:version
    this.groupId = groupId;
    this.artifactId = artifactId;
    this.version = version;
    this.classifier = classifier;
    this.firstLevel = firstLevel;

    // flags
    this.testDependency = testDependency;
    this.systemScoped = systemScoped;
    this.provided = provided;
    this.addedToClasspath = addedToClasspath;

    // file and type
    this.file = file;
    this.type = type;
  }

  /** Get the <code>FirstLevel</code> value.
   * @return a value
   */
  public final boolean isFirstLevel() {
    return firstLevel;
  }

  /** Set the <code>FirstLevel</code> value.
   * @param newFirstLevel The new FirstLevel value.
   */
  public final void setFirstLevel(final boolean newFirstLevel) {
    this.firstLevel = newFirstLevel;
  }

    /**
     * Getter for <code>javadocAttachment</code>.
     *
     * @return Returns the javadocAttachment.
     */
    public File getJavadocAttachment()
    {
        return this.javadocAttachment;
    }

    /**
     * Setter for <code>javadocAttachment</code>.
     *
     * @param javadocAttachment The javadocAttachment to set.
     */
    public void setJavadocAttachment( File javadocAttachment )
    {
        this.javadocAttachment = javadocAttachment;
    }

    /**
     * Getter for <code>artifactId</code>.
     *
     * @return Returns the artifactId.
     */
    public String getArtifactId()
    {
        return this.artifactId;
    }

    /**
     * Setter for <code>artifactId</code>.
     *
     * @param artifactId The artifactId to set.
     */
    public void setArtifactId( String artifactId )
    {
        this.artifactId = artifactId;
    }

    /**
     * Getter for <code>groupId</code>.
     *
     * @return Returns the groupId.
     */
    public String getGroupId()
    {
        return this.groupId;
    }

    /**
     * Setter for <code>groupId</code>.
     *
     * @param groupId The groupId to set.
     */
    public void setGroupId( String groupId )
    {
        this.groupId = groupId;
    }

    /**
     * Getter for <code>version</code>.
     *
     * @return Returns the version.
     */
    public String getVersion()
    {
        return this.version;
    }

    /**
     * Setter for <code>version</code>.
     *
     * @param version The version to set.
     */
    public void setVersion( String version )
    {
        this.version = version;
    }

    /**
     * Getter for <code>classifier</code>.
     *
     * @return Returns the classifier.
     */
    public String getClassifier()
    {
        return this.classifier;
    }

    /**
     * Setter for <code>groupId</code>.
     *
     * @param groupId The groupId to set.
     */
    public void setClassifier( String classifier )
    {
        this.classifier = classifier;
    }

    /**
     * Getter for <code>sourceAttachment</code>.
     *
     * @return Returns the sourceAttachment.
     */
    public File getSourceAttachment()
    {
        return this.sourceAttachment;
    }

    /**
     * Setter for <code>sourceAttachment</code>.
     *
     * @param sourceAttachment The sourceAttachment to set.
     */
    public void setSourceAttachment( File sourceAttachment )
    {
        this.sourceAttachment = sourceAttachment;
    }

    /**
     * Getter for <code>systemScoped</code>.
     *
     * @return Returns the systemScoped.
     */
    public boolean isSystemScoped()
    {
        return this.systemScoped;
    }

    /**
     * Setter for <code>systemScoped</code>.
     *
     * @param systemScoped The systemScoped to set.
     */
    public void setSystemScoped( boolean systemScoped )
    {
        this.systemScoped = systemScoped;
    }

    /**
     * Getter for <code>testDependency</code>.
     *
     * @return Returns the testDependency.
     */
    public boolean isTestDependency()
    {
        return this.testDependency;
    }

    /**
     * Setter for <code>testDependency</code>.
     *
     * @param testDependency The testDependency to set.
     */
    public void setTestDependency( boolean testDependency )
    {
        this.testDependency = testDependency;
    }

    /**
     * Getter for <code>file</code>.
     *
     * @return Returns the file.
     */
    public File getFile()
    {
        return this.file;
    }

    /**
     * Setter for <code>file</code>.
     *
     * @param file The file to set.
     */
    public void setFile( File file )
    {
        this.file = file;
    }

    /**
     * Getter for <code>artifactId</code>.
     *
     * @return Returns the artifactId.
     */
    public String getId()
    {
        return this.groupId + ':' + this.artifactId + ':' + this.version;
    }

    /**
     * Getter for <code>type</code>.
     *
     * @return Returns the type.
     */
    public String getType()
    {
        return this.type;
    }

    /**
     * Setter for <code>type</code>.
     *
     * @param type The type to set.
     */
    public void setType( String type )
    {
        this.type = type;
    }

    /**
     * Getter for <code>addedToClasspath</code>.
     *
     * @return Returns the addedToClasspath.
     */
    public boolean isAddedToClasspath()
    {
        return this.addedToClasspath;
    }

    /**
     * Setter for <code>addedToClasspath</code>.
     *
     * @param addedToClasspath The addedToClasspath to set.
     */
    public void setAddedToClasspath( boolean addedToClasspath )
    {
        this.addedToClasspath = addedToClasspath;
    }

    /**
     * Getter for <code>provided</code>.
     *
     * @return Returns the provided.
     */
    public boolean isProvided()
    {
        return this.provided;
    }

    /**
     * Setter for <code>provided</code>.
     *
     * @param provided The provided to set.
     */
    public void setProvided( boolean provided )
    {
        this.provided = provided;
    }

    /**
     * @see java.lang.Object#toString()
     */
    public String toString()
    {
        return getId();
    }

    /**
     * @see java.lang.Comparable#compareTo(java.lang.Object) Compare using groupId+artifactId+type Strings
     */
    public int compareTo( Object o )
    {
        IdeDependency dep = (IdeDependency) o;
        // in case of system scoped dependencies the files must be compared.
        if ( isSystemScoped() && dep.isSystemScoped() && getFile().equals( dep.getFile() ) )
        {
            return 0;
        }
        int equals = this.getGroupId().compareTo( dep.getGroupId() );
        if ( equals != 0 )
        {
            return equals;
        }
        equals = this.getArtifactId().compareTo( dep.getArtifactId() );
        if ( equals != 0 )
        {
            return equals;
        }
        equals = this.getType().compareTo( dep.getType() );
        if ( equals != 0 )
        {
            return equals;
        }
        return 0;
    }

    /**
     * Is this dependency System scoped outside the eclipse project. This is NOT complete because in reality the check
     * should mean that any module in the reactor contains the system scope locally!
     *
     * @return Returns this dependency is systemScoped outside the project.
     */
    public boolean isSystemScopedOutsideProject( MavenProject project )
    {
        File modulesTop = project.getBasedir();
        while ( new File( modulesTop.getParentFile(), "pom.xml" ).exists() )
        {
            modulesTop = modulesTop.getParentFile();
        }
        return isSystemScoped() && !getFile().getAbsolutePath().startsWith( modulesTop.getAbsolutePath() );
    }

    /**
     * {@inheritDoc}
     */
    public boolean equals( Object obj )
    {
        return compareTo( obj ) == 0;
    }

    /**
     * {@inheritDoc}
     */
    public int hashCode()
    {
        if ( isSystemScoped() )
        {
            return getFile().hashCode();
        }
        else
        {
            return this.getGroupId().hashCode() ^ this.getArtifactId().hashCode() ^ this.getType().hashCode();
        }
    }
}
