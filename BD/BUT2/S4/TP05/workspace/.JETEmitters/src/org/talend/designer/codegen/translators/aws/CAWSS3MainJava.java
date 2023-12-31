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

public class CAWSS3MainJava
{
  protected static String nl;
  public static synchronized CAWSS3MainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    CAWSS3MainJava result = new CAWSS3MainJava();
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

    String bucketName = ElementParameterParser.getValue(node, "__BUCKET_NAME__");

    builder.setComponent("aws-s3");
    builder.useDoubleSlash(false);
    builder.setName(bucketName);

    //String accessKey = ElementParameterParser.getValue(node, "__ACCESS_KEY__");
    //builder.addParam("accessKey", accessKey);

    //String secretKey = ElementParameterParser.getValue(node, "__SECRET_KEY__");

    //builder.addParam("secretKey", "\"RAW("+org.talend.core.utils.TalendQuoteUtils.removeQuotesIfExist(secretKey)+")\"");

    String amazonS3Client = ElementParameterParser.getValue(node, "__AWS_CONNECTION_CLIENT__");

    builder.addParam("amazonS3Client", "\"#cAWSS3_" + amazonS3Client + "\"");

    String prefix = ElementParameterParser.getValue(node, "__PREFIX__");
    builder.addParam("prefix", prefix);

    String fileName = ElementParameterParser.getValue(node, "__FILE_NAME__");
    builder.addParam("fileName", fileName);

    String region = ElementParameterParser.getValue(node,"__REGION__");

    boolean set_region = (region!=null && !region.isEmpty() && !"DEFAULT".equalsIgnoreCase(region));

    if (set_region) {
        builder.addParam("region", region);
    }

    String includeBody = ElementParameterParser.getValue(node, "__INCLUDE_BODY__");
    if ("false".equals(includeBody)) {
        builder.addParam("includeBody", "\"" + includeBody + "\"");
    }

    String multiPartUpload = ElementParameterParser.getValue(node, "__MULTI_PART_UPLOAD__");
    if ("true".equals(multiPartUpload)) {
        builder.addParam("multiPartUpload", "\"" + multiPartUpload + "\"");
        String partSize = ElementParameterParser.getValue(node, "__PART_SIZE__");

        builder.addParam("partSize", partSize);
    }

    if ("true".equals(multiPartUpload)) {
        builder.addParam("multiPartUpload", "\"" + multiPartUpload + "\"");
    }

    String deleteAfterRead = ElementParameterParser.getValue(node, "__DELETE_AFTER_READ__");
    if ("false".equals(deleteAfterRead)) {
        builder.addParam("deleteAfterRead", "\"" + deleteAfterRead + "\"");
    }

    String deleteAfterWrite = ElementParameterParser.getValue(node, "__DELETE_AFTER_WRITE__");
    if ("true".equals(deleteAfterWrite)) {
        builder.addParam("deleteAfterWrite", "\"" + deleteAfterWrite + "\"");
    }

    String serverSideEncryption = ElementParameterParser.getValue(node, "__SERVER_SIDE_ENCRYPTION__");
    if ("true".equals(serverSideEncryption)) {
        builder.addParam("serverSideEncryption", "\"AES256\"");
    }

    String storageClass = ElementParameterParser.getValue(node,"__STORAGE_CLASS__");

    boolean set_storageClass = (storageClass!=null && !storageClass.isEmpty() && !"Standard".equalsIgnoreCase(storageClass));

    if (set_storageClass) {
        builder.addParam("storageClass", "\"" + storageClass + "\"");
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

    String useMessageHeadersUserDefined = ElementParameterParser.getValue(node, "__USE_MESSAGE_HEADERS_USER_DEFINED__");

    List<Map<String, String>> userDefinedHeaders = (List<Map<String, String>>) ElementParameterParser.getObjectValue(node, "__MESSAGE_HEADERS_USER_DEFINED__");

    List<Map<String, String>> messageHeaders = (List<Map<String, String>>) ElementParameterParser.getObjectValue(node, "__MESSAGE_HEADERS__");

    String uri = builder.build();
   
    List< ? extends IConnection> conns = node.getIncomingConnections();

    if (conns.size() > 0 && messageHeaders.size() > 0) {
        StringBuilder sb1 = new StringBuilder();
        for (Map<String, String> map : messageHeaders) {
            String header = map.get("MESSAGE_HEADER");
            String value = map.get("MESSAGE_HEADER_VALUE");

            sb1.append(".setHeader(\"");
            sb1.append(header);
            sb1.append("\",");
            sb1.append("constant(");
            sb1.append(value);
            sb1.append("))");
        }

        if (("true".equals(useMessageHeadersUserDefined)) && (userDefinedHeaders.size()>0)) {
            sb1.append(".setHeader(\"");
            sb1.append("CamelAwsS3Headers");
            sb1.append("\",");
            sb1.append("constant(");
            sb1.append(cid+"userDefinedHeaders");
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
