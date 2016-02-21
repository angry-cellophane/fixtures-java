package org.ka.fixtures.v1.fixture;


import org.ka.fixtures.v1.database.DatabaseType;

public class FixtureConfiguration {

    private final String tableName;
    private final String createQuery;
    private final Object[] createQueryArgs;
    private final boolean isInput;
    private final boolean isOutput;

    public FixtureConfiguration(String tableName, String createQuery, Object[] createQueryArgs, boolean isInput, boolean isOutput) {
        this.tableName = tableName;
        this.createQuery = createQuery;
        this.createQueryArgs = createQueryArgs;
        this.isInput = isInput;
        this.isOutput = isOutput;
    }

    public String getTableName() {
        return tableName;
    }

    public String getCreateQuery() {
        return createQuery;
    }

    public Object[] getCreateQueryArgs() {
        return createQueryArgs;
    }

    public boolean isInput() {
        return isInput;
    }

    public boolean isOutput() {
        return isOutput;
    }
}
