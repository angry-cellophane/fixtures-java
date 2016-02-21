package org.ka.fixtures.v1;

import org.ka.fixtures.v1.database.DatabaseType;
import org.ka.fixtures.v1.list.FixtureList;
import org.ka.fixtures.v1.list.FixtureListBuilder;
import org.ka.fixtures.v1.processor.FixturesProcessor;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

public class Fixtures {

    private final Map<DatabaseType, FixturesProcessor> processors;

    public Fixtures(Map<DatabaseType, FixturesProcessor> processors) {
        this.processors = processors;
    }

    public void applyFixtures(FixtureListBuilder builder) {
        applyFixtures(Collections.singletonList(builder));
    }

    public void applyFixtures(List<FixtureListBuilder> builders) {
        builders.stream()
                .map(FixtureListBuilder::build)
                .forEachOrdered(list -> {
                    FixturesProcessor processor = processors.get(list.getDbType());
                    processor.apply(list);
                });
    }

    public void createFixturesForInputTables(List<FixtureListBuilder> builders) {
        forEachList((l, p) -> {
            p.createFixturesForInputTables(l);
        }, builders);
    }

    public void createFixturesForOutputTables(List<FixtureListBuilder> builders) {
        forEachList((l, p) -> {
            p.createFixturesForOutputTables(l);
        }, builders);
    }

    public void assertOutputTablesEqualFixtures(List<FixtureListBuilder> builders) {
        forEachList((l, p) -> {
            p.assertOutputTablesEqualFixtures(l);
        }, builders);
    }

    private void forEachList(BiConsumer<FixtureList, FixturesProcessor> consumer, List<FixtureListBuilder> builders) {
        builders.stream()
                .map(FixtureListBuilder::build)
                .forEachOrdered(list -> {
                    FixturesProcessor processor = processors.get(list.getDbType());
                    consumer.accept(list, processor);
                });
    }
}
