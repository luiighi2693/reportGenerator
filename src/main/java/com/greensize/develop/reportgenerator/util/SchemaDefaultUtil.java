package com.greensize.develop.reportgenerator.util;

import java.util.Calendar;
import java.util.LinkedHashMap;

public class SchemaDefaultUtil {
    private static LinkedHashMap<String,Object> headerContext;
    private static String reportExportPath;
    private static String reportName;

    public static LinkedHashMap<String, Object> getHeaderContext() {
        return headerContext;
    }

    public static void setHeaderContext(LinkedHashMap<String, Object> headerContext) {
        SchemaDefaultUtil.headerContext = headerContext;
    }

    public static String getReportExportPath() {
        return reportExportPath;
    }

    public static void setReportExportPath(String reportExportPath) {
        SchemaDefaultUtil.reportExportPath = reportExportPath;
    }

    public static String getReportName() {
        return reportName;
    }

    public static void setReportName(String reportName) {
        SchemaDefaultUtil.reportName = reportName;
    }

    public static String getRandomReportName() {
        return "report" + String.valueOf(Calendar.getInstance().getTimeInMillis()) + ".xlsx";
    }
}
