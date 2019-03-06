#!/usr/bin/env bash
TESTCASE=$1

if [ -n "$TESTCASE" ]; then
    EXTRA_ARGS="-Dit.test=$TESTCASE"
fi

. ./multi-platform-support.sh

export ST_KAFKA_VERSION=$($GREP -E '^[0-9.]+ +default' ./kafka-versions | $SED -E 's/(^[0-9.]+).*/\1/')

mvn -e -q verify -pl systemtest -P systemtests -Djava.net.preferIPv4Stack=true -DtrimStackTrace=false -DjunitTags=acceptance $EXTRA_ARGS
