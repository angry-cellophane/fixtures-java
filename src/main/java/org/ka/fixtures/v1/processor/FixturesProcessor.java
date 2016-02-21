package org.ka.fixtures.v1.processor;

import org.ka.fixtures.v1.list.FixtureList;

public interface FixturesProcessor {
    void apply(FixtureList list);
    void createFixturesForInputTables(FixtureList list);
    void createFixturesForOutputTables(FixtureList list);
    void assertOutputTablesEqualFixtures(FixtureList list);
}
