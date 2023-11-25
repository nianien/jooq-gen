## JOOQ代码生成

***<font color=red>该项目旨在对JOOQ代码生成进行增强，涉及非公开API，因此版本号与JOOQ保持一致</font>***

<font color=red>***利用H2的SQL脚本生成JAVA代码，不依赖数据库链接，默认兼容MySQL语法***</font>

### 配置 [jooqConfig.xml](../jooqConfig.xml)

```xml

<generator>
    <database>
        <properties>
            ...
            <property>
                <key>scripts</key>
                <!--指定SQL脚本目录，支持路径通配符-->
                <value>**/h2/*.sql</value>
            </property>
            ...
        </properties>
    </database>
    <target>
        <!--指定生成代码包名和目录-->
        <packageName>com.katana.demo.entity</packageName>
        <directory>src/main/java</directory>
    </target>
</generator>
```

### 配置maven插件

```xml

<plugin>
    <groupId>org.jooq</groupId>
    <artifactId>jooq-codegen-maven</artifactId>
    <version>${jooq.version}</version>
    <executions>
        <execution>
            <goals>
                <goal>generate</goal>
            </goals>
            <phase>package</phase>
        </execution>
    </executions>
    <dependencies>
        <!--增加依赖,需要放在最前位置-->
        <dependency>
            <groupId>io.github.nianien</groupId>
            <artifactId>jooq-gen</artifactId>
            <!--保持版本和JOOQ一致-->
            <version>${jooq.version}</version>
        </dependency>
        <dependency>
            <groupId>org.jooq</groupId>
            <artifactId>jooq-meta-extensions</artifactId>
            <version>${jooq.version}</version>
        </dependency>
    </dependencies>
    <configuration>
        <!--jooqConfig.xml，当前模块的相对路径-->
        <configurationFile>jooqConfig.xml</configurationFile>
    </configuration>
</plugin>
```