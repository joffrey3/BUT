package org.talend.designer.codegen.translators.aws;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IElementParameter;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.designer.codegen.config.CamelEndpointBuilder;
import java.util.List;
import java.util.Map;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class CAWSSESMainJava
{
  protected static String nl;
  public static synchronized CAWSSESMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    CAWSSESMainJava result = new CAWSSESMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "    ";
  protected final String TEXT_2 = ".to(";
  protected final String TEXT_3 = ")" + NL;
  protected final String TEXT_4 = NL + "            .to(";
  protected final String TEXT_5 = ")";
  protected final String TEXT_6 = NL + "            from(";
  protected final String TEXT_7 = ")";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode) codeGenArgument.getArgument();
   	String cid = node.getUniqueName();

	CamelEndpointBuilder builder = CamelEndpointBuilder.getBuilder();

	String from = ElementParameterParser.getValue(node, "__FROM__");

	builder.setComponent("aws-ses");
	builder.useDoubleSlash(false);
	builder.setName(from);

    String amazonSESClient = ElementParameterParser.getValue(node, "__AWS_CONNECTION_CLIENT__");

    builder.addParam("amazonSESClient", "\"#cAWSSES_" +amazonSESClient+"\"");
    
    String subject = ElementParameterParser.getValue(node, "__SUBJECT__");
    builder.addParam("subject", subject);
    
    String to = ElementParameterParser.getValue(node, "__TO__");
    builder.addParam("to", to);
    
    String returnPath = ElementParameterParser.getValue(node, "__RETURN_PATH__");
    builder.addParam("returnPath", returnPath);
    
    String replyToAddresses = ElementParameterParser.getValue(node, "__REPLY_TO_ADDRESSES__");
    builder.addParam("replyToAddresses", replyToAddresses);

	List<Map<String, String>> tableValues = (List<Map<String, String>>) ElementParameterParser.getObjectValue(node, "__URI_OPTIONS__");
	for (Map<String, String> map : tableValues) {
		String argName = map.get("NAME").trim();
		String argValue = map.get("VALUE").trim();
		if(argName.startsWith("\"") && argName.endsWith("\"") && argName.length() >= 2) {
			argName = argName.substring(1, argName.length() - 1);
		}
		builder.addParam(argName, argValue);
	}

    List<Map<String, String>> messageHeaders = (List<Map<String, String>>) ElementParameterParser.getObjectValue(node, "__MESSAGE_HEADERS__");

	String uri = builder.build();
   
	List< ? extends IConnection> conns = node.getIncomingConnections();
	
	if(messageHeaders.size()>0){
	    StringBuilder sb1 = new StringBuilder();
        for (Map<String, String> map : messageHeaders) {
            String header = map.get("MESSAGE_HEADER");
            String value = map.get("MESSAGE_HEADER_VALUE");
            
            sb1.append(".setHeader(\"");
            sb1.append(header);
            sb1.append("\",");
            sb1.append("constant(");
            if(map.get("MESSAGE_HEADER").equals("CamelAwsSesTo")){
                sb1.append(cid+"tos");
            }else if(map.get("MESSAGE_HEADER").equals("CamelAwsSesReplyToAddresses")){
                sb1.append(cid+"replyToAddresses");
            }else if((map.get("MESSAGE_HEADER").equals("CamelAwsSesHtmlEmail"))){
                if("true".equals(map.get("MESSAGE_HEADER_VALUE"))){
                    sb1.append(value);
                }
            }else{
                sb1.append(value);
            }
            sb1.append("))");
        }

    stringBuffer.append(TEXT_1);
    stringBuffer.append(sb1.toString());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(uri);
    stringBuffer.append(TEXT_3);
     } else { 
    
        if(conns.size()>0) {
    
    stringBuffer.append(TEXT_4);
    stringBuffer.append(uri);
    stringBuffer.append(TEXT_5);
    
        } else {
    
    stringBuffer.append(TEXT_6);
    stringBuffer.append(uri);
    stringBuffer.append(TEXT_7);
    
        }
    
    }
    return stringBuffer.toString();
  }
}
