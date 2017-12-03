package com.igt.app;

import com.igt.log.LegacyLogger;

public class LegacyUsage {

    public static void main(String[] args) {
        LegacyLogger logger = LegacyLogger.getInstance();
        System.out.println(logger.getData());
    }
}
