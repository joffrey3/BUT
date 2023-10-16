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

public class CAWSSNSMainJava
{
  protected static String nl;
  public static synchronized CAWSSNSMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    CAWSSNSMainJava result = new CAWSSNSMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "        .to(";
  protected final String TEXT_2 = ")";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    List< ? extends IConnection> in = node.getIncomingConnections();

    CamelEndpointBuilder eb = CamelEndpointBuilder.getBuilder();
    eb.setComponent("aws-sns");
    eb.useDoubleSlash(false);

    String sns = ElementParameterParser.getValue(node, "__AWS_CONNECTION_CLIENT__");
    String topicName = ElementParameterParser.getValue(node, "__TOPIC_NAME__");
    String subjectName = ElementParameterParser.getValue(node, "__SUBJECT_NAME__");

    //Producer
    eb.setName(topicName);
    eb.addParam("amazonSNSClient", "\"#cAWSSNS_" +sns+"\"");
    eb.addParam("subject", subjectName);

    String uri = eb.build();
    if(in.size()>0) {

    stringBuffer.append(TEXT_1);
    stringBuffer.append(uri);
    stringBuffer.append(TEXT_2);
    
    }

    return stringBuffer.toString();
  }
}
