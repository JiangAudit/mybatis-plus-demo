package com.tdk.mybatisplus.demo;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.querys.DbQueryRegistry;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import org.apache.commons.lang3.StringUtils;

/**
 * 代码生成器
 *
 * @author: taodingkai
 * @modified:
 * @version: 2021/5/17 11:13
 */

public class CodeGenerator {
    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner       scanner = new Scanner(System.in);
        StringBuilder help    = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotBlank(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static void main(String[] args) {
        AutoGenerator mpg = new AutoGenerator();
        // 配置策略
        // 1、全局配置
        GlobalConfig gc = new GlobalConfig();
        // 当前项目的路径
        String projectPath = System.getProperty("user.dir");
        // 生成文件输出根目录
        gc.setOutputDir(projectPath + "/src/main/java");
        // 作者
        gc.setAuthor("jiangcheng");
        // 生成完成后不弹出文件框
        gc.setOpen(true);
        // 文件是否覆盖
        gc.setFileOverride(true);
        //主键策略 实体类主键ID类型
        gc.setIdType(IdType.AUTO);
        gc.setDateType(DateType.ONLY_DATE);
        // 是否开启swagger
        gc.setSwagger2(true);
        // 是否支持AR模式，AR模式，就是bean有增删改查方法，继承自Model类
        gc.setActiveRecord(true);
        // XML 二级缓存
        gc.setEnableCache(false);
        // XML ResultMap xml映射文件的配置
        gc.setBaseResultMap(true);
        // XML columList xml映射文件的配置
        gc.setBaseColumnList(true);

        // 自定义文件命名，注意 %s 会自动填充表对应的实体类名
        gc.setControllerName("%sController");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setMapperName("%sDao");
        gc.setXmlName("%sMapper");
        mpg.setGlobalConfig(gc);

        //2、设置数据源
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
//        dsc.setDbType(DbType.ORACLE);
//        dsc.setUrl("jdbc:oracle:thin:@10.15.4.98:1521/HCMBAK");
        dsc.setUrl("jdbc:mysql://172.24.28.50:3306/hr-door-ps?characterEncoding=UTF-8&useUnicode=true&useSSL=false&tinyInt1isBit=false&allowPublicKeyRetrieval=true&serverTimezone=Asia/Shanghai");
        // dsc.setSchemaName("public");
//        dsc.setDriverName("oracle.jdbc.OracleDriver");
        dsc.setDriverName("com.mysql.jdbc.Driver");
//        dsc.setUsername("SYSADM");
//        dsc.setPassword("xdfps3");
        dsc.setUsername("root");
        dsc.setPassword("xdf@123");
        mpg.setDataSource(dsc);

        //3、包的配置
        PackageConfig pc = new PackageConfig();
        pc.setParent(scanner("父包名"));
        // 可以不用设置，默认是controller
        //pc.setController("controller"); 
        // 可以不用设置，默认是service
        //pc.setService("service");
        // 可以不用设置，默认是service.impl
        //pc.setServiceImpl("service.impl");
        // 可以不用设置，默认是mapper
        pc.setMapper("dao");
        // 可以不用设置，默认是entity
        //pc.setEntity("entity"); 
        // 可以不用设置，默认是默认是mapper.xml
        //pc.setXml("mapper"); 
        // 控制层请求地址的包名显示,可不设置，这样包名就是父包名的值，但是RequestMapping会有两个斜杠像这样 //user不太好
        pc.setModuleName(scanner("模块名")); 
        mpg.setPackageInfo(pc);
        
        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        List<FileOutConfig> focList = new ArrayList<>();
        focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return projectPath + "/src/main/resources/mapper/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);
        mpg.setTemplate(new TemplateConfig().setXml(null));
        
        //4、策略配置
        StrategyConfig strategy = new StrategyConfig();
        // 需要生成的表 设置要映射的表名。可以不设置，默认所有表都生成
        //strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
        // 表名生成策略
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        // 启用lombok；
        strategy.setEntityLombokModel(true);
        strategy.setInclude(scanner("数据表").split(","));
        //开启全局大写命名
        //strategy.setCapitalMode(false); 
        // 设置mapper父类
        //strategy.setSuperMapperClass(null);
        // 是否需要开启特定规范字段

        // 控制：true——生成@RsetController false——生成@Controller
        strategy.setRestControllerStyle(true); 
        // 表字段注释启动 启动模板中的这个 <#if table.convert>
        strategy.setEntityTableFieldAnnotationEnable(true); 
        // 是否删除实体类字段的前缀
        strategy.setEntityBooleanColumnRemoveIsPrefix(true); 
        // 去掉前缀比如sys_user去掉前缀后就是对应的实体就是User
        strategy.setTablePrefix(""); 
        // 控制层mapping的映射地址 false：infRecData true：inf_rec_data
        strategy.setControllerMappingHyphenStyle(true);
        mpg.setStrategy(strategy);

        //模板生成器
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        TemplateConfig tc = new TemplateConfig();
        // 指定模板位置
        tc.setController("myController.java");
        //tc.setService();
        //tc.setServiceImpl();
        //tc.setEntity();
        //tc.setMapper();
        //tc.setXml();
        mpg.setTemplate(tc);
        mpg.execute(); //执行
        //经测试mapper文件会生成两次删除位置不对的文件
        File file = new File(projectPath + "/src/main/java/"+pc.getParent().replaceAll("\\.","/")+"/mapper");
        System.out.println("删除多余的文件"+file.getAbsolutePath());
        deleteDir(file);
    }
    public static void deleteDir(File file){
        if(file.exists()) {
            //判断是否为文件夹
            if (file.isDirectory()) {
                //获取该文件夹下的子文件夹
                File[] files = file.listFiles();
                //循环子文件夹重复调用delete方法
                for (int i = 0; i < files.length; i++) {
                    deleteDir(files[i]);
                }
            }
            //若为空文件夹或者文件删除，File类的删除方法
            file.delete();
        }
    }
}