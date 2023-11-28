package com.jooq.gen.test;

import org.jooq.Converter;
import org.jooq.TableField;
import org.jooq.codegen.GenerationTool;
import org.jooq.codegen.JavaGenerator;
import org.jooq.impl.DSL;
import org.jooq.meta.extensions.ddl.DDLDatabase;
import org.jooq.meta.jaxb.*;
import org.jooq.util.jaxb.tools.MiniJAXB;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Date;
import java.util.Random;
import java.util.UUID;


/**
 * @author : liyifei
 * @created : 2023/11/15, 星期三
 * Copyright (c) 2004-2029 All Rights Reserved.
 **/
public class CodeGenTest {
    public static void main(String[] args) throws Exception {
        File file = new File("./jooqConfig.xml");
        Configuration configuration = MiniJAXB.unmarshal(file, Configuration.class);
        configuration.getGenerator().withTarget(
                new Target().withPackageName("com.katana.demo.entity")
                        .withDirectory("generated-sources")
        );
        GenerationTool.generate(configuration);
    }


}
