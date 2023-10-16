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

public class TRouteLoopBeginJava
{
  protected static String nl;
  public static synchronized TRouteLoopBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TRouteLoopBeginJava result = new TRouteLoopBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "\tif ( initialize ) { // To divert the initializer thread" + NL + "\t\tholdReadyState();" + NL + "\t\treturn;" + NL + "\t}" + NL + "\t" + NL + "\torg.apache.camel.Exchange routerExchange = null != singleUseRouterExchange ? singleUseRouterExchange : (org.apache.camel.Exchange) globalMap.get(ROUTER_EXCHANGE);";
  protected final String TEXT_2 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode) codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	cid = cid.replaceAll("_Loop", "");
	
String nodeLabel = node.getLabel();
if(nodeLabel == null){
	nodeLabel = cid;
	
}
	
INode routeInputNode = node.getProcess().getNodesOfType("tRouteIn").get(0);
	
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
System.setProperty("org.talend.studio.route.job.inloop", "true");

    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    return stringBuffer.toString();
  }
}
