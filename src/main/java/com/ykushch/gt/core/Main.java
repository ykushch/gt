package com.ykushch.gt.core;

import com.ykushch.gt.parser.Parser;
import org.apache.commons.cli.CommandLine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        CommandLine line = Parser.parse(args);

        if (line.hasOption("init")) {
            log.info(line.getOptionValue("block-size"));
        } else {
            Parser.help();
        }
    }
}
