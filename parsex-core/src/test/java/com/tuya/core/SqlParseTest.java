package com.tuya.core;

import com.tuya.common.exceptions.SqlParseException;
import com.tuya.common.model.Result;
import com.tuya.common.model.TableInfo;
import org.junit.Test;

import java.util.HashSet;

import static com.tuya.core.SqlParseUtil.print;

public class SqlParseTest {

    String sql1 = "alter table dwd_afterservice_feedback_item\n" +
            "add columns ( app_name        string comment 'app名称',\n" +
            "    app_owner       string  comment 'app拥有者')";

    String sql = "";
    private HashSet<TableInfo> inputTables = new HashSet<>();

    @Test
    public void sparkSqlParse() throws SqlParseException {
        System.out.println(sql);
        Result parse = new SparkSQLParse().parse(sql);
        print(parse);

    }

    @Test
    public void hiveSqlParse() throws SqlParseException {
        Result parse = new HiveSQLParse().parse(sql);
        print(parse);

    }

    @Test
    public void prestoSqlParse() throws SqlParseException {
        System.out.println(sql);
        Result parse = new PrestoSqlParse().parse(sql);
        print(parse);
    }


}
