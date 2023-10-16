package org.talend.designer.codegen.translators.logs_errors;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;

public class TLogCatcherEndJava
{
  protected static String nl;
  public static synchronized TLogCatcherEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TLogCatcherEndJava result = new TLogCatcherEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t}" + NL + "\t";
  protected final String TEXT_2 = NL + "\t} catch (Exception e_";
  protected final String TEXT_3 = ") {" + NL + "\t\tString error_";
  protected final String TEXT_4 = " = String.format(\"";
  protected final String TEXT_5 = " - LogCatcher failed to process log message(s) due to internal error: %s\", e_";
  protected final String TEXT_6 = ");" + NL + "\t\t";
  protected final String TEXT_7 = NL + "\t\t\tlog.error(error_";
  protected final String TEXT_8 = ", e_";
  protected final String TEXT_9 = ");" + NL + "\t\t";
  protected final String TEXT_10 = NL + "\t\t\tSystem.err.println(error_";
  protected final String TEXT_11 = ");" + NL + "\t\t";
  protected final String TEXT_12 = NL + "\t}" + NL + "\t";
  protected final String TEXT_13 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	boolean ignoreInternalErrors = "true".equalsIgnoreCase(ElementParameterParser.getValue(node, "__IGNORE_LOG_CATCHER_INTERNAL_ERRORS__"));
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));


    stringBuffer.append(TEXT_1);
    if(ignoreInternalErrors){
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    } else {
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    }
    stringBuffer.append(TEXT_12);
    }
    stringBuffer.append(TEXT_13);
    return stringBuffer.toString();
  }
}
