/*
 * Copyright 2018, Strimzi authors.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.strimzi.systemtest;

import io.fabric8.kubernetes.api.model.apps.Deployment;
import io.fabric8.kubernetes.api.model.apps.DeploymentBuilder;
import io.strimzi.systemtest.kafkaclients.AbstractClient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static io.strimzi.test.TestUtils.changeOrgAndTag;

public class ClientResources {
    private static final Logger LOGGER = LogManager.getLogger(AbstractClient.class);
    public static final String MESSAGING_CLIENTS = "messaging-clients";

    private static Deployment getMessagingAppDeploymentResource() {
        return new DeploymentBuilder()
                .withNewMetadata()
                .withName(MESSAGING_CLIENTS)
                .endMetadata()
                .withNewSpec()
                .withNewSelector()
                .addToMatchLabels("app", MESSAGING_CLIENTS)
                .endSelector()
                .withReplicas(1)
                .withNewTemplate()
                .withNewMetadata()
                .addToLabels("app", MESSAGING_CLIENTS)
                .endMetadata()
                .withNewSpec()
                .addNewContainer()
                .withName(MESSAGING_CLIENTS)
                .withImage(changeOrgAndTag("strimzi/test-client:latest-kafka-2.1.1"))
                .addNewPort()
                .withContainerPort(4242)
                .endPort()
                .withNewLivenessProbe()
                .withNewTcpSocket()
                .withNewPort(4242)
                .endTcpSocket()
                .withInitialDelaySeconds(10)
                .withPeriodSeconds(5)
                .endLivenessProbe()
                .endContainer()
                .endSpec()
                .endTemplate()
                .endSpec()
                .build();
    }

    // TODO add waitForCreation, waitForDeletion

}
