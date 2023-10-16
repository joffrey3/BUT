package org.talend.designer.codegen.translators.technical;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TRouteLoopEndJava
{
  protected static String nl;
  public static synchronized TRouteLoopEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TRouteLoopEndJava result = new TRouteLoopEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode) codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	cid = cid.replaceAll("_Loop", "");
	System.clearProperty("org.talend.studio.route.job.inloop");

    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    return stringBuffer.toString();
  }
}
