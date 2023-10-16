package org.talend.designer.codegen.translators.logs_errors;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.ElementParameterParser;

public class TLogCatcherBeginJava
{
  protected static String nl;
  public static synchronized TLogCatcherBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TLogCatcherBeginJava result = new TLogCatcherBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t";
  protected final String TEXT_3 = NL + "\ttry {" + NL + "\t";
  protected final String TEXT_4 = NL + "\tfor (LogCatcherUtils.LogCatcherMessage lcm : ";
  protected final String TEXT_5 = ".getMessages()) {";
  protected final String TEXT_6 = NL + "\t\t";
  protected final String TEXT_7 = ".type = lcm.getType();" + NL + "\t\t";
  protected final String TEXT_8 = ".origin = (lcm.getOrigin()==null || lcm.getOrigin().length()<1 ? null : lcm.getOrigin());" + NL + "\t\t";
  protected final String TEXT_9 = ".priority = lcm.getPriority();" + NL + "\t\t";
  protected final String TEXT_10 = ".message = lcm.getMessage();" + NL + "\t\t";
  protected final String TEXT_11 = ".code = lcm.getCode();" + NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_12 = ".moment = java.util.Calendar.getInstance().getTime();" + NL + "\t" + NL + "    \t";
  protected final String TEXT_13 = ".pid = pid;" + NL + "\t\t";
  protected final String TEXT_14 = ".root_pid = rootPid;" + NL + "\t\t";
  protected final String TEXT_15 = ".father_pid = fatherPid;" + NL + "\t" + NL + "    \t";
  protected final String TEXT_16 = ".project = projectName;" + NL + "    \t";
  protected final String TEXT_17 = ".job = jobName;" + NL + "    \t";
  protected final String TEXT_18 = ".context = contextStr;" + NL + "    \t\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	boolean ignoreInternalErrors = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__IGNORE_LOG_CATCHER_INTERNAL_ERRORS__"));


    stringBuffer.append(TEXT_2);
    if(ignoreInternalErrors){
    stringBuffer.append(TEXT_3);
    }
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    
	for (IConnection conn : node.getOutgoingConnections()) {
		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_6);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_18);
    
		}
	}

    return stringBuffer.toString();
  }
}
