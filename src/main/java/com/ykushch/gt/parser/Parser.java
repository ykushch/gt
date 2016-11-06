package com.ykushch.gt.parser;

import org.apache.commons.cli.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Parser {

    private static final Logger log = LoggerFactory.getLogger(Parser.class);

    public static CommandLine parse(String[] args) {
        Options options = configureOptions();
        return parseOptions(options, args);
    }

    private static Options configureOptions() {
        Option initOpt = Option.builder("init")
                .desc("Initialize repository")
                .hasArg(false).build();

        return new Options()
                .addOption(initOpt);
    }

    private static CommandLine parseOptions(Options opts, String[] args) {
        try {
            return new DefaultParser().parse(opts, args);
        } catch (ParseException e) {
            log.error("{}", e.getMessage());
            help();
            throw new RuntimeException(e);
        }
    }

    public static void help() {
        Options options = configureOptions();
        printHelp(options);
    }

    private static void printHelp(Options opts) {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("gt", opts);
    }
}