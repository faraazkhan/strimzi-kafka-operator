/*
 * Copyright 2018, Strimzi authors.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.strimzi.systemtest.kafkaclients.console;

import io.strimzi.systemtest.kafkaclients.AbstractClient;
import io.strimzi.systemtest.kafkaclients.ClientType;

public class ConsoleConsumer extends AbstractClient {
    public ConsoleConsumer() {
        super(ClientType.CLI_KAFKA_CONSOLE_CONSUMER);
    }

    @Override
    protected void fillAllowedArgs() {

    }
}
