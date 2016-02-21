package org.ka.fixtures.v1.list;

import org.ka.fixtures.v1.database.DatabaseType;
import org.ka.fixtures.v1.fixture.FixtureConfiguration;

import java.util.List;

public class FixtureList {
    private final List<FixtureConfiguration> configurations;
    private final String inputDirectory;
    private final String outputDirectory;
    private final DatabaseType dbType;

    public FixtureList(DatabaseType dbType, List<FixtureConfiguration> configurations,
                       String inputDirectory, String outputDirectory) {
        this.dbType = dbType;
        this.configurations = configurations;
        this.inputDirectory = inputDirectory;
        this.outputDirectory = outputDirectory;
    }

    public List<FixtureConfiguration> getConfigurations() {
        return configurations;
    }

    public String getInputDirectory() {
        return inputDirectory;
    }

    public String getOutputDirectory() {
        return outputDirectory;
    }

    public DatabaseType getDbType() {
        return dbType;
    }
}
