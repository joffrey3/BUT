package org.talend.designer.codegen.translators.technical;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;
import java.util.Map;

public class TRouteInMainJava
{
  protected static String nl;
  public static synchronized TRouteInMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TRouteInMainJava result = new TRouteInMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t" + NL + "\t";
  protected final String TEXT_2 = NL + "\t\t\t";
  protected final String TEXT_3 = NL + "\t\t\t//";
  protected final String TEXT_4 = NL;
  protected final String TEXT_5 = "        \t            \t" + NL + "\t\t            \t\t";
  protected final String TEXT_6 = ".";
  protected final String TEXT_7 = " = ";
  protected final String TEXT_8 = ";        \t            \t" + NL + "\t\t            \t";
  protected final String TEXT_9 = NL + "        \t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode) codeGenArgument.getArgument();
	INode routeInputNode = node.getProcess().getNodesOfType("tRouteInput").get(0);
	String cid = routeInputNode.getUniqueName();
	cid = cid.replaceAll("_In", "");
	
String nodeLabel = node.getLabel();
if(nodeLabel == null){
	nodeLabel = cid;
	
}
	
List<Map<String, String>> tableValues =
    (List<Map<String,String>>)ElementParameterParser.getObjectValue(
        routeInputNode,
        "__VALUES__"
    );
	
	
List< ? extends IConnection> conns = routeInputNode.getOutgoingSortedConnections();
String firstConnName = "";	

for(IConnection conn : conns) {
    if(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
 		firstConnName = conn.getName();
 		break;
    }
}

List<IMetadataTable> metadatas = routeInputNode.getMetadataList();
IMetadataTable metadata = null;
if ((metadatas!=null)&&(metadatas.size()>0)) {
	metadata = metadatas.get(0);    
}

    stringBuffer.append(TEXT_1);
    
	for (IConnection conn : conns) {
		if (!conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
    stringBuffer.append(TEXT_2);
    stringBuffer.append("// NO DATA CONNECTION CATEGORY " + conn.getLineStyle().getName());
    stringBuffer.append(TEXT_3);
    stringBuffer.append("// " + firstConnName);
    		}
	}
	
    stringBuffer.append(TEXT_4);
    
    for(IConnection conn : conns) {
        if(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
        	boolean hasJudgedHeaders = false;
        	StringBuilder headersNotNullSb = new StringBuilder();
        	StringBuilder headersIsNullSb = new StringBuilder();
        	headersIsNullSb.append("if(routerExchange == null){");
        	headersNotNullSb.append("}else{");
			List<IMetadataColumn> columns = metadata.getListColumns();
			if(columns!=null&&columns.size()>0){
				for(Map<String, String> tableValue : tableValues) {
				   	String label = tableValue.get("SCHEMA_COLUMN");
		            String value = tableValue.get("VALUE");
		            IMetadataColumn column = metadata.getColumn(label);
		            String talendType = column.getTalendType();
		            JavaType javaType = JavaTypesManager.getJavaTypeFromId(talendType);
		            String typeToGenerate = JavaTypesManager.getTypeToGenerate(javaType, true);
		            if(value == null || value.length() == 0){ //use the default value
	            		String defaultValue = JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate, column.getDefault());
	            		
    stringBuffer.append(TEXT_5);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(label );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(defaultValue );
    stringBuffer.append(TEXT_8);
    
		            }else {
		            	if("id_Document".equals(talendType)){
		            		headersNotNullSb.append(conn.getName());
		            		headersNotNullSb.append(".");
		            		headersNotNullSb.append(label);
		            		headersNotNullSb.append(" = ParserUtils.parseTo_Document(org.apache.camel.builder.SimpleBuilder.simple(");
		            		headersNotNullSb.append(value);
		            		headersNotNullSb.append(").evaluate(routerExchange, String.class));\n");
		            	}else{
		            		headersNotNullSb.append(conn.getName());
		            		headersNotNullSb.append(".");
		            		headersNotNullSb.append(label);
		            		headersNotNullSb.append(" = org.apache.camel.builder.SimpleBuilder.simple(");
		            		headersNotNullSb.append(value);
		            		headersNotNullSb.append(").evaluate(routerExchange, ");
		            		headersNotNullSb.append(typeToGenerate);
		            		headersNotNullSb.append(".class);\n");
		            	}
		            	headersIsNullSb.append("System.err.println(\"ERROR: No input for ");
		            	headersIsNullSb.append(nodeLabel);
		            	headersIsNullSb.append(", You may need to start it Via a Route instead of running it directly!\");");
		            	headersIsNullSb.append(conn.getName());
		            	headersIsNullSb.append(" = null");
		            	//headersIsNullSb.append(".");
		            	//headersIsNullSb.append(label);
		            	//headersIsNullSb.append(JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate, column.getDefault()));
		            	headersIsNullSb.append(";\n");
		            }
	            }
	            headersNotNullSb.append("}");

    stringBuffer.append(TEXT_9);
    stringBuffer.append(headersIsNullSb.toString());
    stringBuffer.append(headersNotNullSb.toString());
    
            }
    }
}

    return stringBuffer.toString();
  }
}
