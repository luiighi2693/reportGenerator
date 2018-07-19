package com.greensize.develop.reportgenerator.configuration;

import com.greensize.develop.reportgenerator.util.SchemaUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.LinkedHashMap;

@Configuration
public class SchemaConfig {

    @Value("#{${header.context}}")
    private LinkedHashMap<String,Object> headerContext;

    @Value("${report.export.path}")
    private String reportExportPath;

    @Value("${report.export.default.name}")
    private String reportExportDefaultName;

    @PostConstruct
    public void init() {
        SchemaUtil.setHeaderContext(headerContext);
        SchemaUtil.setReportExportPath(
                System.getProperty("os.name").contains("Windows") ? ("C:" + reportExportPath.replace("/", "\\")) : (reportExportPath));
        SchemaUtil.setDefaultReportName(reportExportDefaultName);
    }
}
