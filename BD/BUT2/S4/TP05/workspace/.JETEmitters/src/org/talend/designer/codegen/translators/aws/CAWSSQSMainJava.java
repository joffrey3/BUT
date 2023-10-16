package org.talend.designer.codegen.translators.aws;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IElementParameter;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.designer.codegen.config.CamelEndpointBuilder;
import org.talend.core.utils.TalendQuoteUtils;
import java.util.List;
import java.util.Map;

public class CAWSSQSMainJava
{
  protected static String nl;
  public static synchronized CAWSSQSMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    CAWSSQSMainJava result = new CAWSSQSMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "        .to(";
  protected final String TEXT_2 = ")";
  protected final String TEXT_3 = NL + "        from(";
  protected final String TEXT_4 = ")";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    List< ? extends IConnection> in = node.getIncomingConnections();

    CamelEndpointBuilder eb = CamelEndpointBuilder.getBuilder();
    eb.setComponent("aws-sqs");
    eb.useDoubleSlash(false);

    String sqs = ElementParameterParser.getValue(node, "__AWS_CONNECTION_CLIENT__");
    String queueName = ElementParameterParser.getValue(node, "__QUEUE_NAME__");
    boolean delAfterRead = "true".equals(ElementParameterParser.getValue(node, "__DELETE_AFTER_READ__"));
    boolean delIfFilter = "true".equals(ElementParameterParser.getValue(node, "__DELETE_IF_FILTERED__"));
    boolean enableConcurrent = "true".equals(ElementParameterParser.getValue(node, "__ENABLE_CONCURRENT__"));

    String poolNumber = ElementParameterParser.getValue(node, "__POOL_NUMBER__");
    String maxMessage = ElementParameterParser.getValue(node, "__MAX_MESSAGE__");
    boolean changeVisibility = "true".equals(ElementParameterParser.getValue(node, "__EXTEND_MESSAGE_VISIBILITY__"));
    String visibilitySeconds = ElementParameterParser.getValue(node, "__VISIBILITY_TIMEOUT__");
    String delaySeconds = ElementParameterParser.getValue(node, "__DELAY_SECOND__");
    String waitSeconds = ElementParameterParser.getValue(node, "__WAIT_TIME_SECOND__");
    String awsID = ElementParameterParser.getValue(node, "__QUEUE_OWNER_ACCOUNT__");

    List<Map<String,String>> queueConf = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__QUEUE_CONFIGURATION__");

    boolean attrAll = "true".equals(ElementParameterParser.getValue(node, "__ATTRIBUTE_ALL__"));
    boolean attrRecTime = "true".equals(ElementParameterParser.getValue(node, "__ATTRIBUTE_RECEIVE_TIME__"));
    boolean attrRecCount = "true".equals(ElementParameterParser.getValue(node, "__ATTRIBUTE_RECEIVE_COUNT__"));
    boolean attrSender = "true".equals(ElementParameterParser.getValue(node, "__ATTRIBUTE_SENDER_ID__"));
    boolean attrSentTime = "true".equals(ElementParameterParser.getValue(node, "__ATTRIBUTE_SENT_TIME__"));

    List<Map<String,String>> msgAttr = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__MESSAGE_ATTRIBUTE_NAME__");

    //Shared header
    eb.addParam("amazonSQSClient", "\"#cAWSSQS_" +sqs+"\"");
    eb.setName(queueName);

    if (in.size()>0) {
    //Producer
        if(!"0".equals(delaySeconds)){
            eb.addParam("delaySeconds", delaySeconds);
        }
        if(!"0".equals(waitSeconds)){
            eb.addParam("waitTimeSeconds", waitSeconds);
        }
    } else {
    //Consumer
        if (!delAfterRead) { eb.addParam("deleteAfterRead", "false"); };
        if (!delIfFilter) { eb.addParam("deleteIfFiltered", "false"); };
        if (enableConcurrent) {
            eb.addParam("concurrentConsumers", poolNumber);
            eb.addParam("maxMessagesPerPoll", maxMessage);
        }
        if (changeVisibility) {
            eb.addParam("extendMessageVisibility", "true");
            eb.addParam("visibilityTimeout", visibilitySeconds);
        }

        if (attrAll) {
            eb.addParam("attributeNames", "\"All\"");
        } else {
            String attr = "";
            if (attrRecTime) { attr+="ApproximateFirstReceiveTimestamp,"; }
            if (attrRecCount) { attr+="ApproximateReceiveCount,"; }
            if (attrSender) { attr+="SenderId,"; }
            if (attrSentTime) { attr+="SentTimestamp,"; }

            if (attr.length() > 0) {
                eb.addParam("attributeNames", TalendQuoteUtils.addQuotesIfNotExist(attr.substring(0, attr.length()-1)));
            }
        }

        String msgs = "";
        for (Map<String,String> map :msgAttr) {
            msgs+=TalendQuoteUtils.removeQuotesIfExist(map.get("ATTRIBUTE_NAME"))+",";
        }
        if (msgs.length() > 0) {
            eb.addParam("messageAttributeNames",TalendQuoteUtils.addQuotesIfNotExist(msgs.substring(0, msgs.length()-1)));
        }
    }
    //Shared end
    if (TalendQuoteUtils.removeQuotesIfExist(awsID).length() > 0) {
        eb.addParam("queueOwnerAWSAccountId",awsID);
    }
    if (queueConf.size() > 0) {
        for (Map<String,String> map : queueConf) {
            String param = map.get("QUEUE_PARAMETER");
            String value = map.get("VALUE");
            eb.addParam(param,value);
        }
    }

    String uri = eb.build();
    if (in.size() > 0) {

    stringBuffer.append(TEXT_1);
    stringBuffer.append(uri);
    stringBuffer.append(TEXT_2);
    
    } else {

    stringBuffer.append(TEXT_3);
    stringBuffer.append(uri);
    stringBuffer.append(TEXT_4);
    
    }

    return stringBuffer.toString();
  }
}
