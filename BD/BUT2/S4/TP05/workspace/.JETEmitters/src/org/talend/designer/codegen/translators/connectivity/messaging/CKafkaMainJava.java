package org.talend.designer.codegen.translators.connectivity.messaging;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IElementParameter;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.designer.codegen.config.CamelEndpointBuilder;
import java.util.List;
import java.util.Map;

public class CKafkaMainJava
{
  protected static String nl;
  public static synchronized CKafkaMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    CKafkaMainJava result = new CKafkaMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = " " + NL + "            final String decryptedSSLKeyPassword = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_2 = ");";
  protected final String TEXT_3 = NL + "            final String decryptedSSLKeyPassword = ";
  protected final String TEXT_4 = "; ";
  protected final String TEXT_5 = " " + NL + "            final String decryptedSSLKeyStorePassword = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_6 = ");";
  protected final String TEXT_7 = NL + "            final String decryptedSSLKeyStorePassword = ";
  protected final String TEXT_8 = "; ";
  protected final String TEXT_9 = " " + NL + "            final String decryptedSSLTrustStorePassword = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_10 = ");";
  protected final String TEXT_11 = NL + "            final String decryptedSSLTrustStorePassword = ";
  protected final String TEXT_12 = "; ";
  protected final String TEXT_13 = NL + "            .to(";
  protected final String TEXT_14 = ")";
  protected final String TEXT_15 = NL + "        from(";
  protected final String TEXT_16 = ")";
  protected final String TEXT_17 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode) codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    List<? extends IConnection> incomingConnections = node.getIncomingConnections();

    CamelEndpointBuilder builder = CamelEndpointBuilder.getBuilder();
    builder.setComponent("kafka");
    builder.useDoubleSlash(false);

    String topic = ElementParameterParser.getValue(node, "__TOPIC__").trim();
    builder.setName(topic);

    String brokerList = ElementParameterParser.getValue(node, "__BROKER_LIST__").trim();
    builder.addParam("brokers", brokerList);

    String clientId = ElementParameterParser.getValue(node, "__CLIENT_ID__").trim();
    if (!"\"\"".equals(clientId)) {
        builder.addParam("clientId", clientId);
    }

    String groupId = ElementParameterParser.getValue(node, "__GROUP_ID__").trim();
    if (!"\"\"".equals(groupId)) {
        builder.addParam("groupId", groupId);
    }

    String connectionMaxIdleMs = ElementParameterParser.getValue(node, "__CONNECTION_MAX_IDLE_MS__").trim();
    if (!"\"\"".equals(connectionMaxIdleMs)) {
        builder.addParam("connectionMaxIdleMs", connectionMaxIdleMs);
    }

    String receiveBufferBytes = ElementParameterParser.getValue(node, "__MAX_REQUEST_SIZE__").trim();
    if (!"\"\"".equals(receiveBufferBytes)) {
        builder.addParam("receiveBufferBytes", receiveBufferBytes);
    }

    String metadataMaxAgeMs = ElementParameterParser.getValue(node, "__METADATA_MAX_AGE_MS__").trim();
    if (!"\"\"".equals(metadataMaxAgeMs)) {
        builder.addParam("metadataMaxAgeMs", metadataMaxAgeMs);
    }

    String reconnectBackoffMs = ElementParameterParser.getValue(node, "__RECONNECT_BACKOFF_MS__").trim();
    if (!"\"\"".equals(reconnectBackoffMs)) {
        builder.addParam("reconnectBackoffMs", reconnectBackoffMs);
    }

    String sslKeyPasswordField = "__SSL_KEY_PASSWORD__";
    if (!"\"\"".equals(ElementParameterParser.getValue(node, sslKeyPasswordField).trim())) {
        
    if (ElementParameterParser.canEncrypt(node, sslKeyPasswordField)) {
    stringBuffer.append(TEXT_1);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, sslKeyPasswordField));
    stringBuffer.append(TEXT_2);
    } else {
    stringBuffer.append(TEXT_3);
    stringBuffer.append(ElementParameterParser.getValue(node, sslKeyPasswordField));
    stringBuffer.append(TEXT_4);
    }
    
        builder.addParam("sslKeyPassword", "decryptedSSLKeyPassword");
    }

    String sslKeystoreLocation = ElementParameterParser.getValue(node, "__SSL_KEYSTORE_LOCATION__").trim();
    if (!"\"\"".equals(sslKeystoreLocation)) {
        builder.addParam("sslKeystoreLocation", sslKeystoreLocation);
    }

    String sslKeyStorePasswordField = "__SSL_KEYSTORE_PASSWORD__";
    if (!"\"\"".equals(ElementParameterParser.getValue(node, sslKeyStorePasswordField).trim())) {
        
    if (ElementParameterParser.canEncrypt(node, sslKeyStorePasswordField)) {
    stringBuffer.append(TEXT_5);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, sslKeyStorePasswordField));
    stringBuffer.append(TEXT_6);
    } else {
    stringBuffer.append(TEXT_7);
    stringBuffer.append(ElementParameterParser.getValue(node, sslKeyStorePasswordField));
    stringBuffer.append(TEXT_8);
    }
    
        builder.addParam("sslKeystorePassword", "decryptedSSLKeyStorePassword");
    }

    String sslTrustStorePasswordField = "__SSL_TRUSTSTORE_PASSWORD__";
    if (!"\"\"".equals(ElementParameterParser.getValue(node, sslTrustStorePasswordField).trim())) {
        
    if (ElementParameterParser.canEncrypt(node, sslTrustStorePasswordField)) {
    stringBuffer.append(TEXT_9);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, sslTrustStorePasswordField));
    stringBuffer.append(TEXT_10);
    } else {
    stringBuffer.append(TEXT_11);
    stringBuffer.append(ElementParameterParser.getValue(node, sslTrustStorePasswordField));
    stringBuffer.append(TEXT_12);
    }
    
        builder.addParam("sslTruststorePassword", "decryptedSSLTrustStorePassword");
    }

    String sslTruststoreLocation = ElementParameterParser.getValue(node, "__SSL_TRUSTSTORE_LOCATION__").trim();
    if (!"\"\"".equals(sslTruststoreLocation)) {
        builder.addParam("sslTruststoreLocation", sslTruststoreLocation);
    }

    String sslCipherSuites = ElementParameterParser.getValue(node, "__SSL_CIPHER_SUITS__").trim();
    if (!"\"\"".equals(sslCipherSuites)) {
        builder.addParam("sslCipherSuites", sslCipherSuites);
    }

    String sslEndpointAlgorithm = ElementParameterParser.getValue(node, "__SSL_ENDPOINT_ALGORITHM__").trim();
    if (!"\"\"".equals(sslEndpointAlgorithm)) {
        builder.addParam("sslEndpointAlgorithm", sslEndpointAlgorithm);
    }

    String saslKerberosServiceName = ElementParameterParser.getValue(node, "__SASL_KERBEROS_SERVICE_NAME__").trim();
    if (!"\"\"".equals(saslKerberosServiceName)) {
        builder.addParam("saslKerberosServiceName", saslKerberosServiceName);
    }

    String securityProtocol = ElementParameterParser.getValue(node, "__SECURITY_PROTOCOL__").trim();
    if (!"\"\"".equals(securityProtocol)) {
        builder.addParam("securityProtocol", "\"" + securityProtocol + "\"");
    }

    if (incomingConnections.size() > 0) {
        String partitioner = ElementParameterParser.getValue(node, "__PARTITIONER__").trim();
        if (!"\"\"".equals(partitioner)) {
            builder.addParam("partitioner", partitioner);
        }

        String compressionCodec = ElementParameterParser.getValue(node, "__COMPRESSION_CODEC__");
        if (!"\"\"".equals(compressionCodec)) {
            builder.addParam("compressionCodec", "\"" + compressionCodec + "\"");
        }

        String serializerClass = ElementParameterParser.getValue(node, "__SERIALIZER_CLASS__").trim();
        if (!"\"\"".equals(serializerClass)) {
            builder.addParam("serializerClass", serializerClass);
        }

        String keySerializerClass = ElementParameterParser.getValue(node, "__KEY_SERIALIZER_CLASS__").trim();
        if (!"\"\"".equals(keySerializerClass)) {
            builder.addParam("keySerializerClass", keySerializerClass);
        }

        String requestRequiredAcks = ElementParameterParser.getValue(node, "__REQUEST_REQUIRED_ACKS__").trim();
        if (!"\"\"".equals(requestRequiredAcks)) {
            builder.addParam("requestRequiredAcks", "\"" + requestRequiredAcks + "\"");
        }

        String requestTimeoutMs = ElementParameterParser.getValue(node, "__REQUEST_TIMEOUT_MS__").trim();
        if (!"\"\"".equals(requestTimeoutMs)) {
            builder.addParam("requestTimeoutMs", requestTimeoutMs);
        }

        String retryBackoffMs = ElementParameterParser.getValue(node, "__RETRY_BACKOFF_MS__").trim();
        if (!"\"\"".equals(retryBackoffMs)) {
            builder.addParam("retryBackoffMs", retryBackoffMs);
        }

        String sendBufferBytes = ElementParameterParser.getValue(node, "__SEND_BUFFER_BYTES__").trim();
        if (!"\"\"".equals(sendBufferBytes)) {
            builder.addParam("sendBufferBytes", sendBufferBytes);
        }

        String bufferMemorySize = ElementParameterParser.getValue(node, "__BUFFER_MEMORY_SIZE__").trim();
        if (!"\"\"".equals(bufferMemorySize)) {
            builder.addParam("bufferMemorySize", bufferMemorySize);
        }

        String retries = ElementParameterParser.getValue(node, "__RETRIES__").trim();
        if (!"\"\"".equals(retries)) {
            builder.addParam("retries", retries);
        }

        String producerBatchSize = ElementParameterParser.getValue(node, "__PRODUCER_BATCH_SIZE__").trim();
        if (!"\"\"".equals(producerBatchSize)) {
            builder.addParam("producerBatchSize", producerBatchSize);
        }

        String lingerMs = ElementParameterParser.getValue(node, "__LINGER_MS__").trim();
        if (!"\"\"".equals(lingerMs)) {
            builder.addParam("lingerMs", lingerMs);
        }

        String maxBlockMs = ElementParameterParser.getValue(node, "__MAX_BLOCK_MS__").trim();
        if (!"\"\"".equals(maxBlockMs)) {
            builder.addParam("maxBlockMs", maxBlockMs);
        }

        String maxRequestSize = ElementParameterParser.getValue(node, "__MAX_REQUEST_SIZE__").trim();
        if (!"\"\"".equals(maxRequestSize)) {
            builder.addParam("maxRequestSize", maxRequestSize);
        }

        String maxInFlightRequest = ElementParameterParser.getValue(node, "__MAX_IN_FLIGHT_REQUEST__").trim();
        if (!"\"\"".equals(maxInFlightRequest)) {
            builder.addParam("maxInFlightRequest", maxInFlightRequest);
        }
    } else {
        String retryBackoffMs = ElementParameterParser.getValue(node, "__RETRY_BACKOFF_MS__").trim();
        if (!"\"\"".equals(retryBackoffMs)) {
            builder.addParam("retryBackoffMs", retryBackoffMs);
        }

        String autoCommitEnable = ElementParameterParser.getValue(node, "__AUTO_COMMIT_ENABLE__").trim();
        if (!"\"\"".equals(autoCommitEnable)) {
            builder.addParam("autoCommitEnable", autoCommitEnable);
        }

        String autoCommitIntervalMs = ElementParameterParser.getValue(node, "__AUTO_COMMIT_INTERVAL_MS__").trim();
        if (!"\"\"".equals(autoCommitIntervalMs)) {
            builder.addParam("autoCommitIntervalMs", autoCommitIntervalMs);
        }

        String fetchMinBytes = ElementParameterParser.getValue(node, "__FETCH_MIN_BYTES__").trim();
        if (!"\"\"".equals(fetchMinBytes)) {
            builder.addParam("fetchMinBytes", fetchMinBytes);
        }

        String fetchWaitMaxMs = ElementParameterParser.getValue(node, "__FETCH_WAIT_MAX_MS__").trim();
        if (!"\"\"".equals(fetchWaitMaxMs)) {
            builder.addParam("fetchWaitMaxMs", fetchWaitMaxMs);
        }

        String autoOffsetReset = ElementParameterParser.getValue(node, "__AUTO_OFFSET_RESET__").trim();
        if (!"\"\"".equals(autoOffsetReset)) {
            builder.addParam("autoOffsetReset", "\"" + autoOffsetReset + "\"");
        }

        String heartbeatIntervalMs = ElementParameterParser.getValue(node, "__HEARTBEAT_INTERVAL_MS__").trim();
        if (!"\"\"".equals(heartbeatIntervalMs)) {
            builder.addParam("heartbeatIntervalMs", heartbeatIntervalMs);
        }

        String maxPartitionFetchBytes = ElementParameterParser.getValue(node, "__MAX_PARTITION_FETCH_BYTES__").trim();
        if (!"\"\"".equals(maxPartitionFetchBytes)) {
            builder.addParam("maxPartitionFetchBytes", maxPartitionFetchBytes);
        }

        String sessionTimeoutMs = ElementParameterParser.getValue(node, "__SESSION_TIMEOUT_MS__").trim();
        if (!"\"\"".equals(sessionTimeoutMs)) {
            builder.addParam("sessionTimeoutMs", sessionTimeoutMs);
        }

        String partitionAssignor = ElementParameterParser.getValue(node, "__PARTITION_ASSIGNOR__").trim();
        if (!"\"\"".equals(partitionAssignor)) {
            builder.addParam("partitionAssignor", partitionAssignor);
        }

        String consumerRequestTimeoutMs = ElementParameterParser.getValue(node, "__CONSUMER_REQUEST_TIMEOUT_MS__").trim();
        if (!"\"\"".equals(consumerRequestTimeoutMs)) {
            builder.addParam("consumerRequestTimeoutMs", consumerRequestTimeoutMs);
        }
    }

    List<Map<String, String>> tableValues = (List<Map<String, String>>) ElementParameterParser.getObjectValue(node, "__URI_OPTIONS__");
    for (Map<String, String> map : tableValues) {
        String argName = map.get("NAME").trim();
        String argValue = map.get("VALUE").trim();
        if(argName.startsWith("\"") && argName.endsWith("\"") && argName.length() >= 2) {
            argName = argName.substring(1, argName.length() - 1);
        }
        builder.addParam(argName, argValue);
    }

    String uri = builder.build();

    if (incomingConnections.size() > 0) {

    stringBuffer.append(TEXT_13);
    stringBuffer.append(uri);
    stringBuffer.append(TEXT_14);
    
    } else {

    stringBuffer.append(TEXT_15);
    stringBuffer.append(uri);
    stringBuffer.append(TEXT_16);
    
    }

    stringBuffer.append(TEXT_17);
    return stringBuffer.toString();
  }
}
