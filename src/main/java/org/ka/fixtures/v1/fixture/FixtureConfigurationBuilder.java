package org.ka.fixtures.v1.fixture;


import org.ka.fixtures.v1.database.DatabaseType;

public class FixtureConfigurationBuilder {

    private static final String QUERY_PREFIX = "select * from ";
    private static final Object[] NO_ARGS = new Object[0];

    private final String tableName;
    private String createQuery;
    private String fixturePath;
    private Object[] createQueryArgs;
    private boolean isOutput;
    private boolean isInput;

    public FixtureConfigurationBuilder(String tableName) {
        this.tableName = tableName;
        this.createQuery = QUERY_PREFIX + tableName;
        this.createQueryArgs = NO_ARGS;
        this.isInput = false;
        this.isOutput = false;
    }

    public FixtureConfigurationBuilder createQuery(String query, Object ... args) {
        createQuery = query;
        createQueryArgs = args == null ? NO_ARGS : args;
        return this;
    }

    public FixtureConfigurationBuilder outputFile() {
        isOutput = true;
        return this;
    }

    public FixtureConfigurationBuilder inputFile() {
        isInput = true;
        return this;
    }

    public FixtureConfigurationBuilder fixtureFilePath(String filePath) {
        this.fixturePath = filePath;
        return this;
    }

    public FixtureConfiguration build() {
        return new FixtureConfiguration(
                tableName,
                createQuery,
                createQueryArgs,
                isInput,
                isOutput
        );
    }
}
