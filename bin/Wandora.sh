#!/bin/bash
echo "*****************************************************"
echo "***   WANDORA - THE KNOWLEDGE MANAGEMENT STUDIO   ***"
echo "***     Copyright (C) 2004-2014 Wandora Team      ***"
echo "***              http://wandora.org               ***" 
echo "*****************************************************"
echo "Xms750m Xmx1000m"

WANDORALIB=

source SetClasspath.sh
source SetR.sh
source SetProcessing.sh
source SetTesseract.sh

cd ../build
java -Xms750m -Xmx1000m -Djava.library.path=$WANDORALIB -Dorg.wandora.mediafw="GST" -classpath $WANDORACLASSES org.wandora.application.Wandora $1