/*
 * Copyright 2018, Strimzi authors.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.strimzi.systemtest.kafkaclients;

public enum ClientType {
    CLI_KAFKA_CONSOLE_PRODUCER,
    CLI_KAFKA_CONSOLE_CONSUMER,
    CLI_KAFKA_VERIFIABLE_PRODUCER,
    CLI_KAFKA_VERIFIABLE_CONSUMER;

    /**
     * Get bind client type to client executable
     *
     * @param client client type
     * @return client executable
     */
    public static String getCommand(ClientType client) {
        switch (client) {
            case CLI_KAFKA_CONSOLE_PRODUCER:
                return "bin/kafka-console-producer.sh";
            case CLI_KAFKA_CONSOLE_CONSUMER:
                return "bin/kafka-console-consumer.sh";
            default:
                return "";
        }
    }
}
