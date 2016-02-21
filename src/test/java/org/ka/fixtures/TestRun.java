package org.ka.fixtures;

import org.junit.Test;
import org.ka.fixtures.v1.Fixtures;
import org.ka.fixtures.v1.database.DatabaseType;
import org.ka.fixtures.v1.list.FixtureListBuilder;
import org.ka.fixtures.v1.processor.FixturesProcessor;
import org.ka.fixtures.v1.processor.OracleFixturesProcessor;
import org.ka.fixtures.v1.processor.SybaseFixturesProcessor;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.ka.fixtures.v1.FixtureUtils.*;

public class TestRun {

    @Test
    public void testRun() {
        Map<DatabaseType, FixturesProcessor> processorMap = new HashMap<>();
        processorMap.put(DatabaseType.SYBASE, new SybaseFixturesProcessor());
        processorMap.put(DatabaseType.ORACLE, new OracleFixturesProcessor());
        Fixtures fixtures = new Fixtures(processorMap);

        List<FixtureListBuilder> lists = prepareFixtures();

        fixtures.createFixturesForInputTables(lists);
        fixtures.createFixturesForOutputTables(lists);
        fixtures.applyFixtures(lists);
        fixtures.assertOutputTablesEqualFixtures(lists);
    }

    List<FixtureListBuilder> prepareFixtures() {
        String ids = "1,2,3,4,5,6,7,8, 9";
        Date date = new Date();

        return fixtures(
                sybaseFixtures(
                        fixture("MYDB..MY_TABLE").inputFile(),
                        fixture("MYDB..MY_TABLE1")
                                .inputFile()
                                .fixtureFilePath("input/database/MY_TABLE.csv")
                                .createQuery("select * from MYDB..MYTABLE1 where date = ?", date),
                        fixture("MYDB..MY_TABLE2").outputFile(),
                        fixture("MYDB..MY_TABLE3")
                                .outputFile()
                                .createQuery("select * from MYDB_MY_TABLE3 WHERE id in (" + ids + ") and date = ?", date)
                ),
                sybaseFixtures(
                        fixture("MYDB2..MY_TABLE").inputFile(),
                        fixture("MYDB2..MY_TABLE1").inputFile(),
                        fixture("MYDB2..MY_TABLE2").outputFile(),
                        fixture("MYDB2..MY_TABLE3").outputFile()
                )
                        .inputDirectory("input/database2")
                        .outputDirectory("output/database2"),
                oracleFixtures(
                        fixture("MY_SCHEMA.MY_TABLE1").inputFile(),
                        fixture("MY_SCHEMA.MY_TABLE2").outputFile()
                )
                        .inputDirectory("input/database/oracle")
                        .outputDirectory("output/database/oracle")
        );
    }
}
