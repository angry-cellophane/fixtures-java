package org.ka.fixtures.v1.list;

import org.ka.fixtures.v1.database.DatabaseType;
import org.ka.fixtures.v1.fixture.FixtureConfiguration;

import java.util.List;

public class FixtureListBuilder {

    private final List<FixtureConfiguration> configurations;
    private final DatabaseType dbType;
    private String inputDir;
    private String outputDir;

    public FixtureListBuilder(DatabaseType dbType, List<FixtureConfiguration> configurations) {
        this.dbType = dbType;
        this.configurations = configurations;
        this.inputDir = "input/fixtures";
        this.outputDir = "output/fixtures";
    }

    public FixtureListBuilder inputDirectory(String inputDir) {
        this.inputDir = inputDir;
        return this;
    }

    public FixtureListBuilder outputDirectory(String outputDir) {
        this.outputDir = outputDir;
        return this;
    }

    public FixtureList build() {
        return new FixtureList(dbType, configurations, inputDir, outputDir);
    }
}
