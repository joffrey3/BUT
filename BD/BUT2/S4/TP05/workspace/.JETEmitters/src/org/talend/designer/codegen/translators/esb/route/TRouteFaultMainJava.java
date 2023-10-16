package org.talend.designer.codegen.translators.esb.route;

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

public class TRouteFaultMainJava
{
  protected static String nl;
  public static synchronized TRouteFaultMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TRouteFaultMainJava result = new TRouteFaultMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + NL + "// tRouterFault code" + NL;
  protected final String TEXT_2 = NL + "\t\torg.apache.camel.Exchange routerExchange_";
  protected final String TEXT_3 = " = routerExchange;";
  protected final String TEXT_4 = NL + "\t\torg.apache.camel.Exchange routerExchange_";
  protected final String TEXT_5 = " = singleUseRouterExchange != null" + NL + "\t\t\t? singleUseRouterExchange : (org.apache.camel.Exchange) globalMap.get(ROUTER_EXCHANGE);";
  protected final String TEXT_6 = NL;
  protected final String TEXT_7 = "        \t" + NL + "\t        // copy Body from IN to OUT to propagate them" + NL + "   \t\t\trouterExchange_";
  protected final String TEXT_8 = ".getOut().setBody(routerExchange_";
  protected final String TEXT_9 = ".getIn().getBody());" + NL + "\t        // copy headers from IN to OUT to propagate them" + NL + "\t\t\trouterExchange_";
  protected final String TEXT_10 = ".getOut().setHeaders(routerExchange_";
  protected final String TEXT_11 = ".getIn().getHeaders());" + NL + "\t\t\t// copy attachements from IN to OUT to propagate them" + NL + "\t\t\trouterExchange_";
  protected final String TEXT_12 = ".getOut().setAttachments(routerExchange_";
  protected final String TEXT_13 = ".getIn().getAttachments());" + NL + "\t        " + NL;
  protected final String TEXT_14 = NL + "\t            " + NL + "\t            ";
  protected final String TEXT_15 = NL + "\t\t                routerExchange_";
  protected final String TEXT_16 = ".getOut().setBody(";
  protected final String TEXT_17 = ".";
  protected final String TEXT_18 = ".getDocument().asXML(), org.w3c.dom.Document.class);" + NL + "\t\t            \t";
  protected final String TEXT_19 = NL + "\t\t                routerExchange_";
  protected final String TEXT_20 = ".getOut().setBody(";
  protected final String TEXT_21 = ".";
  protected final String TEXT_22 = ", ";
  protected final String TEXT_23 = ".class);" + NL + "\t\t            \t";
  protected final String TEXT_24 = NL + "\t            \trouterExchange_";
  protected final String TEXT_25 = ".getOut().setHeader(";
  protected final String TEXT_26 = ", ";
  protected final String TEXT_27 = ".";
  protected final String TEXT_28 = ");" + NL + "\t            \t";
  protected final String TEXT_29 = NL + "\t            \trouterExchange_";
  protected final String TEXT_30 = ".setProperty(";
  protected final String TEXT_31 = ", ";
  protected final String TEXT_32 = ".";
  protected final String TEXT_33 = ");" + NL + "\t            \t";
  protected final String TEXT_34 = NL + "\t            \tSystem.setProperty(";
  protected final String TEXT_35 = ", ";
  protected final String TEXT_36 = ".";
  protected final String TEXT_37 = " == null? null:";
  protected final String TEXT_38 = ".";
  protected final String TEXT_39 = ".toString());" + NL + "\t            \t";
  protected final String TEXT_40 = NL + "\t\t\t//set output as fault    " + NL + "\t        routerExchange_";
  protected final String TEXT_41 = ".getOut().setFault(true);";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode) codeGenArgument.getArgument();
String cid = node.getUniqueName();

List<Map<String, String>> tableValues =
    (List<Map<String,String>>)ElementParameterParser.getObjectValue(
        node,
        "__VALUES__"
    );

List< ? extends IConnection> conns = node.getIncomingConnections();
String firstConnName = "";

for(IConnection conn : conns) {
    if(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
 		firstConnName = conn.getName();
 		break;
    }
}

List<IMetadataTable> metadatas = node.getMetadataList();
IMetadataTable metadata = null;
if ((metadatas!=null)&&(metadatas.size()>0)) {
	metadata = metadatas.get(0);    
}

    stringBuffer.append(TEXT_1);
    
if ( "true".equals(System.getProperty("org.talend.studio.route.job.inloop")) ) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    
} else {

    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
}

    stringBuffer.append(TEXT_6);
    
    for(IConnection conn : conns) { // 1
        if(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {  // 2
        	boolean hasJudgedHeaders = false;
        	StringBuilder bodySb = new StringBuilder();

    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
                       	
            for(Map<String, String> tableValue : tableValues) { // 3
            	String label = tableValue.get("SCHEMA_COLUMN");
	            String value = tableValue.get("VALUE");
	            String type = tableValue.get("TYPE");

	            IMetadataColumn column = metadata.getColumn(label);
	            String talendType = column.getTalendType();
	            JavaType javaType = JavaTypesManager.getJavaTypeFromId(talendType);
	            String typeToGenerate = JavaTypesManager.getTypeToGenerate(javaType, true);
    stringBuffer.append(TEXT_14);
    if("Body".equals(type)){ 
                    // http://camel.apache.org/using-getin-or-getout-methods-on-exchange.html
	            	if("id_Document".equals(talendType)){
	            		
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_17);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_18);
    
	            	}else{
	            		
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_21);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_23);
    
	            	}
	            }else if("Header".equals(type)){
	            	
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_27);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_28);
    
	            }else if("Property".equals(type)){
	            	
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_32);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_33);
    
	            }else if("System".equals(type)){
	            	
    stringBuffer.append(TEXT_34);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_36);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_38);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_39);
    
	            }
        } // 3

    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    
    } // 2
} // 1


    return stringBuffer.toString();
  }
}
