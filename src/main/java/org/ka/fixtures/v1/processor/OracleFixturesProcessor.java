package org.ka.fixtures.v1.processor;


import org.ka.fixtures.v1.fixture.FixtureConfiguration;
import org.ka.fixtures.v1.list.FixtureList;

import java.io.File;

public class OracleFixturesProcessor implements FixturesProcessor {

    @Override
    public void apply(FixtureList list) {
        list.getConfigurations().stream()
                .filter(FixtureConfiguration::isOutput)
                .forEachOrdered(config -> {
                    System.out.println("clean table: "+config.getTableName());
                });

        list.getConfigurations().stream()
                .filter(FixtureConfiguration::isInput)
                .forEachOrdered(config -> {
                    System.out.println("apply fixture: "+config.getTableName());
                });
    }

    @Override
    public void createFixturesForInputTables(FixtureList list) {
        list.getConfigurations().stream()
                .filter(FixtureConfiguration::isInput)
                .forEachOrdered(config -> {
                    System.out.println("save table: "
                            + config.getTableName()
                            + " to "+ list.getInputDirectory()
                            + "/"
                            + config.getTableName());
                });
    }

    @Override
    public void createFixturesForOutputTables(FixtureList list) {
        list.getConfigurations().stream()
                .filter(FixtureConfiguration::isOutput)
                .forEachOrdered(config -> {
                    System.out.println("save table: "
                            + config.getTableName()
                            + " to "+ list.getOutputDirectory()
                            + "/"
                            + config.getTableName());
                });
    }

    @Override
    public void assertOutputTablesEqualFixtures(FixtureList list) {
        list.getConfigurations().stream()
                .filter(FixtureConfiguration::isOutput)
                .forEachOrdered(config -> {
                    System.out.println("assert table: "
                            + config.getTableName()
                            + " equals "+ list.getInputDirectory()
                            + "/"
                            + config.getTableName());
                });
    }
}
