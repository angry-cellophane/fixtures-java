package org.ka.fixtures.v1;

import org.ka.fixtures.v1.database.DatabaseType;
import org.ka.fixtures.v1.fixture.FixtureConfiguration;
import org.ka.fixtures.v1.fixture.FixtureConfigurationBuilder;
import org.ka.fixtures.v1.list.FixtureListBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FixtureUtils {

    public static FixtureConfigurationBuilder fixture(String tableName) {
        return new FixtureConfigurationBuilder(tableName);
    }

    public static FixtureListBuilder sybaseFixtures(FixtureConfigurationBuilder ... builders) {
        List<FixtureConfiguration> configs = new ArrayList<>(builders.length);
        for (FixtureConfigurationBuilder builder : builders) {
            configs.add(builder.build());
        }
        return new FixtureListBuilder(DatabaseType.SYBASE, configs);
    }

    public static List<FixtureListBuilder> sybaseFixtures(FixtureListBuilder ... fixtureSets) {
        return Arrays.asList(fixtureSets);
    }

    public static List<FixtureListBuilder> fixtures(FixtureListBuilder ... fixtureLists) {
        return Arrays.asList(fixtureLists);
    }


    public static FixtureListBuilder oracleFixtures(FixtureConfigurationBuilder ... builders) {
        List<FixtureConfiguration> configs = new ArrayList<>(builders.length);
        for (FixtureConfigurationBuilder builder : builders) {
            configs.add(builder.build());
        }
        return new FixtureListBuilder(DatabaseType.ORACLE, configs);
    }

    public static List<FixtureListBuilder> oracleFixtures(FixtureListBuilder ... fixtureSets) {
        return Arrays.asList(fixtureSets);
    }

    private FixtureUtils() {}
}
