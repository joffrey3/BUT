package org.talend.designer.codegen.translators.aws;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IElementParameter;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class CAWSConnectionMainJava
{
  protected static String nl;
  public static synchronized CAWSConnectionMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    CAWSConnectionMainJava result = new CAWSConnectionMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();

    stringBuffer.append(TEXT_1);
    return stringBuffer.toString();
  }
}
