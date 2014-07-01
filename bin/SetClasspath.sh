#!/bin/bash
# This bat script is executed automatically by Wandora.sh.
# You don't need to execute it manually.
WANDORACLASSES=classes
WANDORACLASSES=$WANDORACLASSES:resources
WANDORACLASSES=$WANDORACLASSES:lib/arq/*
WANDORACLASSES=$WANDORACLASSES:lib/mstor/*
WANDORACLASSES=$WANDORACLASSES:lib/jmbox/*
WANDORACLASSES=$WANDORACLASSES:lib/jtidy/*
WANDORACLASSES=$WANDORACLASSES:lib/gdata/*
WANDORACLASSES=$WANDORACLASSES:lib/jetty/*
WANDORACLASSES=$WANDORACLASSES:lib/jdic/*
WANDORACLASSES=$WANDORACLASSES:lib/jdicplus/*
WANDORACLASSES=$WANDORACLASSES:lib/poi/*
WANDORACLASSES=$WANDORACLASSES:lib/musicbrainz/*
#WANDORACLASSES=$WANDORACLASSES:lib/fmj/*
WANDORACLASSES=$WANDORACLASSES:lib/axis2/*
WANDORACLASSES=$WANDORACLASSES:lib/pdfbox/*
WANDORACLASSES=$WANDORACLASSES:lib/sesame/*
WANDORACLASSES=$WANDORACLASSES:lib/any23/*
WANDORACLASSES=$WANDORACLASSES:lib/stanford-ner/*
WANDORACLASSES=$WANDORACLASSES:lib/gate/*
WANDORACLASSES=$WANDORACLASSES:lib/gate/lib/*
WANDORACLASSES=$WANDORACLASSES:lib/derby/*
WANDORACLASSES=$WANDORACLASSES:lib/twitter/*
WANDORACLASSES=$WANDORACLASSES:lib/ical4j/*
WANDORACLASSES=$WANDORACLASSES:lib/df/*
WANDORACLASSES=$WANDORACLASSES:lib/unirest/*
WANDORACLASSES=$WANDORACLASSES:lib/tmql4j/*
WANDORACLASSES=$WANDORACLASSES:lib/*
#  To use Webview Panel with Java 7 fix next line to address the location of JavaFX jar jfxrt.jar .
WANDORACLASSES=$WANDORACLASSES:/usr/jdk/jre/lib/jfxrt.jar