package com.greensize.develop.reportgenerator.util;

import java.util.Calendar;
import java.util.LinkedHashMap;

public class SchemaUtil {
    private static LinkedHashMap<String,Object> headerContext;
    private static String reportExportPath;
    private static String defaultReportName;

    public static LinkedHashMap<String, Object> getHeaderContext() {
        return headerContext;
    }

    public static void setHeaderContext(LinkedHashMap<String, Object> headerContext) {
        SchemaUtil.headerContext = headerContext;
    }

    public static String getReportExportPath() {
        return reportExportPath;
    }

    public static void setReportExportPath(String reportExportPath) {
        SchemaUtil.reportExportPath = reportExportPath;
    }

    public static String getDefaultReportName() {
        return defaultReportName;
    }

    public static void setDefaultReportName(String defaultReportName) {
        SchemaUtil.defaultReportName = defaultReportName;
    }

    public static String getRandomReportName() {
        return "report" + String.valueOf(Calendar.getInstance().getTimeInMillis()) + ".xlsx";
    }
}
