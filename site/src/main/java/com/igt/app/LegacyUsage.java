package com.igt.app;

import com.igt.log.LegacyLogger;
import com.igt.report.LegacyReport;

public class LegacyUsage {

    public static void main(String[] args) {
        LegacyLogger logger = LegacyLogger.getInstance();
        System.out.println(logger.getData());

        LegacyReport report = LegacyReport.getInstance();
        System.out.println(report.getReport());
    }
}
