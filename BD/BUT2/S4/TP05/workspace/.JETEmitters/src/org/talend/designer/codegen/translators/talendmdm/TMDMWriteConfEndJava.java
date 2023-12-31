package org.talend.designer.codegen.translators.talendmdm;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.utils.NodeUtil;

public class TMDMWriteConfEndJava
{
  protected static String nl;
  public static synchronized TMDMWriteConfEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMDMWriteConfEndJava result = new TMDMWriteConfEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "                if(log.is";
  protected final String TEXT_3 = "Enabled())";
  protected final String TEXT_4 = NL + "            log.";
  protected final String TEXT_5 = "(\"";
  protected final String TEXT_6 = " - \" ";
  protected final String TEXT_7 = " + (";
  protected final String TEXT_8 = ") ";
  protected final String TEXT_9 = ");";
  protected final String TEXT_10 = NL + "    \tclass BytesLimit65535_";
  protected final String TEXT_11 = "{" + NL + "    \t\tpublic void limitLog4jByte() throws Exception{" + NL + "    \t\t\t";
  protected final String TEXT_12 = NL + "            StringBuilder ";
  protected final String TEXT_13 = " = new StringBuilder();";
  protected final String TEXT_14 = NL + "            ";
  protected final String TEXT_15 = ".append(\"Parameters:\");";
  protected final String TEXT_16 = NL + "                    ";
  protected final String TEXT_17 = ".append(\"";
  protected final String TEXT_18 = "\" + \" = \" + String.valueOf(";
  protected final String TEXT_19 = ").substring(0, 4) + \"...\");     ";
  protected final String TEXT_20 = NL + "                    ";
  protected final String TEXT_21 = ".append(\"";
  protected final String TEXT_22 = "\" + \" = \" + ";
  protected final String TEXT_23 = ");";
  protected final String TEXT_24 = NL + "                ";
  protected final String TEXT_25 = ".append(\" | \");";
  protected final String TEXT_26 = NL + "    \t\t}" + NL + "    \t}" + NL + "    \t" + NL + "        new BytesLimit65535_";
  protected final String TEXT_27 = "().limitLog4jByte();";
  protected final String TEXT_28 = NL + "            StringBuilder ";
  protected final String TEXT_29 = " = new StringBuilder();    ";
  protected final String TEXT_30 = NL + "                    ";
  protected final String TEXT_31 = ".append(";
  protected final String TEXT_32 = ".";
  protected final String TEXT_33 = ");";
  protected final String TEXT_34 = NL + "                    if(";
  protected final String TEXT_35 = ".";
  protected final String TEXT_36 = " == null){";
  protected final String TEXT_37 = NL + "                        ";
  protected final String TEXT_38 = ".append(\"<null>\");" + NL + "                    }else{";
  protected final String TEXT_39 = NL + "                        ";
  protected final String TEXT_40 = ".append(";
  protected final String TEXT_41 = ".";
  protected final String TEXT_42 = ");" + NL + "                    }   ";
  protected final String TEXT_43 = NL + "                ";
  protected final String TEXT_44 = ".append(\"|\");";
  protected final String TEXT_45 = NL + "    }" + NL + "}";
  protected final String TEXT_46 = NL + "    txf_";
  protected final String TEXT_47 = ".join();" + NL + "    if(txf_";
  protected final String TEXT_48 = ".getLastException()!=null) {" + NL + "        currentComponent = txf_";
  protected final String TEXT_49 = ".getCurrentComponent();" + NL + "        throw txf_";
  protected final String TEXT_50 = ".getLastException();" + NL + "    }" + NL + "    globalMap.remove(\"queue_";
  protected final String TEXT_51 = "\");";
  protected final String TEXT_52 = NL + "    String readFinishWithExceptionMarkWithPipeId_";
  protected final String TEXT_53 = " = \"";
  protected final String TEXT_54 = "_FINISH_WITH_EXCEPTION\"+(queue_";
  protected final String TEXT_55 = "==null?\"\":queue_";
  protected final String TEXT_56 = ".hashCode());" + NL + "    if(globalMap.containsKey(readFinishWithExceptionMarkWithPipeId_";
  protected final String TEXT_57 = ")){" + NL + "        globalMap.put(readFinishWithExceptionMarkWithPipeId_";
  protected final String TEXT_58 = ", null);// syn" + NL + "        globalMap.remove(readFinishWithExceptionMarkWithPipeId_";
  protected final String TEXT_59 = ");" + NL + "        return;" + NL + "    }" + NL + "    globalMap.remove(\"queue_";
  protected final String TEXT_60 = "\");";
  protected final String TEXT_61 = NL + "globalMap.put(readFinishMarkWithPipeId_";
  protected final String TEXT_62 = ",null);//syn" + NL + "globalMap.remove(readFinishMarkWithPipeId_";
  protected final String TEXT_63 = ");";
  protected final String TEXT_64 = NL + NL + "    if(miList_";
  protected final String TEXT_65 = ".size() > 0){" + NL + "" + NL + "        org.talend.mdm.webservice.WSPutItemWithReportArray putItemWithReportArray = new org.talend.mdm.webservice.WSPutItemWithReportArray(miList_";
  protected final String TEXT_66 = ");" + NL + "        wspks_";
  protected final String TEXT_67 = " = service_";
  protected final String TEXT_68 = ".putItemWithReportArray(putItemWithReportArray).getWsItemPK();" + NL + "        ";
  protected final String TEXT_69 = NL + "        " + NL + "        miList_";
  protected final String TEXT_70 = ".clear();" + NL + "        miList_";
  protected final String TEXT_71 = " = null;";
  protected final String TEXT_72 = NL + NL + "            int i2_";
  protected final String TEXT_73 = " = 0;" + NL + "            for(org.talend.mdm.webservice.WSItemPK wspk2_";
  protected final String TEXT_74 = " : wspks_";
  protected final String TEXT_75 = "){" + NL + "" + NL + "                String compositeId = \"\";" + NL + "                for(String id:wspk2_";
  protected final String TEXT_76 = ".getIds()) {" + NL + "                  compositeId += id;" + NL + "                }" + NL + "" + NL + "                wspk2_";
  protected final String TEXT_77 = ".setWsDataClusterPK(dataCluster_";
  protected final String TEXT_78 = ");" + NL + "                service_";
  protected final String TEXT_79 = ".updateItemMetadata(util_";
  protected final String TEXT_80 = ".makeUpdateMeteItm(taskIDs_";
  protected final String TEXT_81 = ".get(i2_";
  protected final String TEXT_82 = "), wspk2_";
  protected final String TEXT_83 = "));" + NL + "                i2_";
  protected final String TEXT_84 = "++;" + NL + "            }" + NL;
  protected final String TEXT_85 = NL + "            taskIDs_";
  protected final String TEXT_86 = ".clear();";
  protected final String TEXT_87 = NL + "    }";
  protected final String TEXT_88 = NL + NL + "    if(miList_";
  protected final String TEXT_89 = ".size() > 0){" + NL + "" + NL + "        org.talend.mdm.webservice.WSPutItemArray putItemArray = new org.talend.mdm.webservice.WSPutItemArray(miList_";
  protected final String TEXT_90 = ");" + NL + "        wspks_";
  protected final String TEXT_91 = " = service_";
  protected final String TEXT_92 = ".putItemArray(putItemArray).getWsItemPK();" + NL;
  protected final String TEXT_93 = NL + NL + "        miList_";
  protected final String TEXT_94 = ".clear();" + NL + "        miList_";
  protected final String TEXT_95 = " = null;";
  protected final String TEXT_96 = NL + NL + "            int i2_";
  protected final String TEXT_97 = " = 0;" + NL + "            for(org.talend.mdm.webservice.WSItemPK wspk2_";
  protected final String TEXT_98 = " : wspks_";
  protected final String TEXT_99 = "){" + NL + "" + NL + "                String compositeId = \"\";" + NL + "                for(String id:wspk2_";
  protected final String TEXT_100 = ".getIds()) {" + NL + "                  compositeId += id;" + NL + "                }" + NL + "" + NL + "                wspk2_";
  protected final String TEXT_101 = ".setWsDataClusterPK(dataCluster_";
  protected final String TEXT_102 = ");" + NL + "                service_";
  protected final String TEXT_103 = ".updateItemMetadata(util_";
  protected final String TEXT_104 = ".makeUpdateMeteItm(taskIDs_";
  protected final String TEXT_105 = ".get(i2_";
  protected final String TEXT_106 = "), wspk2_";
  protected final String TEXT_107 = "));" + NL + "                i2_";
  protected final String TEXT_108 = "++;" + NL + "            }" + NL;
  protected final String TEXT_109 = NL + "            taskIDs_";
  protected final String TEXT_110 = ".clear();";
  protected final String TEXT_111 = NL + "    }";
  protected final String TEXT_112 = NL + "    service_";
  protected final String TEXT_113 = ".logout(new org.talend.mdm.webservice.WSLogout());";
  protected final String TEXT_114 = NL + NL + "globalMap.put(\"";
  protected final String TEXT_115 = "_NB_LINE\",nb_line_";
  protected final String TEXT_116 = ");" + NL + "globalMap.put(\"";
  protected final String TEXT_117 = "_NB_LINE_REJECTED\",nb_line_rejected_";
  protected final String TEXT_118 = ");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
class BasicLogUtil{
    protected String cid  = "";
    protected org.talend.core.model.process.INode node = null;
    protected boolean log4jEnabled = false;
    private String logID = "";
    
    private BasicLogUtil(){}
    
    public BasicLogUtil(org.talend.core.model.process.INode node){
        this.node = node;
        String cidx = this.node.getUniqueName();
        if(cidx.matches("^.*?tAmazonAuroraOutput_\\d+_out$")){
             cidx = cidx.substring(0,cidx.length()-4);// 4 ==> "_out".length();
        }
        this.cid = cidx;
        this.log4jEnabled = ("true").equals(org.talend.core.model.process.ElementParameterParser.getValue(this.node.getProcess(), "__LOG4J_ACTIVATE__"));
        this.log4jEnabled = this.log4jEnabled &&
                            this.node.getComponent().isLog4JEnabled() && !"JOBLET".equals(node.getComponent().getComponentType().toString());
        this.logID = this.cid;
    }
    
    public String var(String varName){
        return varName + "_" + this.cid;
    }
    public String str(String content){
        return "\"" + content + "\"";
    }
    
    public void info(String... message){
        log4j("info", message);
    }
    
    public void debug(String... message){
        log4j("debug", message);
    }
    
    public void warn(String... message){
        log4j("warn", message);
    }
    
    public void error(String... message){
        log4j("error", message);
    }
    
    public void fatal(String... message){
        log4j("fatal", message);
    }
    
    public void trace(String... message){
        log4j("trace", message);
    }
    java.util.List<String> checkableList = java.util.Arrays.asList(new String[]{"info", "debug", "trace"});     
    public void log4j(String level, String... messages){
        if(this.log4jEnabled){
            if(checkableList.contains(level)){
            
    stringBuffer.append(TEXT_2);
    stringBuffer.append(level.substring(0, 1).toUpperCase() + level.substring(1));
    stringBuffer.append(TEXT_3);
    
            }
            
    stringBuffer.append(TEXT_4);
    stringBuffer.append(level);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(logID);
    stringBuffer.append(TEXT_6);
    for(String message : messages){
    stringBuffer.append(TEXT_7);
    stringBuffer.append(message);
    stringBuffer.append(TEXT_8);
    }
    stringBuffer.append(TEXT_9);
    
        }
    }
    
    public boolean isActive(){
        return this.log4jEnabled;
    }
}

class LogUtil extends BasicLogUtil{
    
    private LogUtil(){
    }
    
    public LogUtil(org.talend.core.model.process.INode node){
        super(node);
    }
    
    public void startWork(){
        debug(str("Start to work."));
    }
    
    public void endWork(){
        debug(str("Done."));
    }
    
    public void logIgnoredException(String exception){
        warn(exception);
    }
    
    public void logPrintedException(String exception){
        error(exception);
    }
    
    public void logException(String exception){
        fatal(exception);
    }
    
    public void logCompSetting(){
    
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    
       			 if(log4jEnabled){
       			 
    stringBuffer.append(TEXT_12);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_13);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_15);
    
            java.util.Set<org.talend.core.model.process.EParameterFieldType> ignoredParamsTypes = new java.util.HashSet<org.talend.core.model.process.EParameterFieldType>(); 
            ignoredParamsTypes.addAll(
                java.util.Arrays.asList(
                    org.talend.core.model.process.EParameterFieldType.SCHEMA_TYPE,
                    org.talend.core.model.process.EParameterFieldType.LABEL,
                    org.talend.core.model.process.EParameterFieldType.EXTERNAL,
                    org.talend.core.model.process.EParameterFieldType.MAPPING_TYPE,
                    org.talend.core.model.process.EParameterFieldType.IMAGE,
                    org.talend.core.model.process.EParameterFieldType.TNS_EDITOR,
                    org.talend.core.model.process.EParameterFieldType.WSDL2JAVA,
                    org.talend.core.model.process.EParameterFieldType.GENERATEGRAMMARCONTROLLER,
                    org.talend.core.model.process.EParameterFieldType.GENERATE_SURVIVORSHIP_RULES_CONTROLLER,
                    org.talend.core.model.process.EParameterFieldType.REFRESH_REPORTS,
                    org.talend.core.model.process.EParameterFieldType.BROWSE_REPORTS,
                    org.talend.core.model.process.EParameterFieldType.PALO_DIM_SELECTION,
                    org.talend.core.model.process.EParameterFieldType.GUESS_SCHEMA,
                    org.talend.core.model.process.EParameterFieldType.MATCH_RULE_IMEX_CONTROLLER,
                    org.talend.core.model.process.EParameterFieldType.MEMO_PERL,
                    org.talend.core.model.process.EParameterFieldType.DBTYPE_LIST,
                    org.talend.core.model.process.EParameterFieldType.VERSION,
                    org.talend.core.model.process.EParameterFieldType.TECHNICAL,
                    org.talend.core.model.process.EParameterFieldType.ICON_SELECTION,
                    org.talend.core.model.process.EParameterFieldType.JAVA_COMMAND,
                    org.talend.core.model.process.EParameterFieldType.TREE_TABLE,
                    org.talend.core.model.process.EParameterFieldType.VALIDATION_RULE_TYPE,
                    org.talend.core.model.process.EParameterFieldType.DCSCHEMA,
                    org.talend.core.model.process.EParameterFieldType.SURVIVOR_RELATION,
                    org.talend.core.model.process.EParameterFieldType.REST_RESPONSE_SCHEMA_TYPE
                    )
            );
            for(org.talend.core.model.process.IElementParameter ep : org.talend.core.model.utils.NodeUtil.getDisplayedParameters(node)){
                if(!ep.isLog4JEnabled() || ignoredParamsTypes.contains(ep.getFieldType())){
                    continue;
                }
                String name = ep.getName();
                if(org.talend.core.model.process.EParameterFieldType.PASSWORD.equals(ep.getFieldType())){
                    String epName = "__" + name + "__";
                    String password = "";
                    if(org.talend.core.model.process.ElementParameterParser.canEncrypt(node, epName)){
                        password = org.talend.core.model.process.ElementParameterParser.getEncryptedValue(node, epName);
                    }else{
                        String passwordValue = org.talend.core.model.process.ElementParameterParser.getValue(node, epName);
                        if (passwordValue == null || "".equals(passwordValue.trim())) {// for the value which empty
                            passwordValue = "\"\"";
                        } 
                        password = "routines.system.PasswordEncryptUtil.encryptPassword(" + passwordValue + ")";
                    } 
                    
    stringBuffer.append(TEXT_16);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_17);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(password);
    stringBuffer.append(TEXT_19);
    
                }else{
                    String value = org.talend.core.model.utils.NodeUtil.getNormalizeParameterValue(node, ep);
                    
    stringBuffer.append(TEXT_20);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_21);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_23);
    
                }   
                
    stringBuffer.append(TEXT_24);
    stringBuffer.append(var("log4jParamters"));
    stringBuffer.append(TEXT_25);
    
            }
        }
		debug(var("log4jParamters"));
		
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    
    }
    
    //no use for now, because we log the data by rowStruct
    public void traceData(String rowStruct, java.util.List<org.talend.core.model.metadata.IMetadataColumn> columnList, String nbline){
        if(log4jEnabled){
        
    stringBuffer.append(TEXT_28);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_29);
    
            for(org.talend.core.model.metadata.IMetadataColumn column : columnList){
                org.talend.core.model.metadata.types.JavaType javaType = org.talend.core.model.metadata.types.JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                String columnName = column.getLabel();
                boolean isPrimit = org.talend.core.model.metadata.types.JavaTypesManager.isJavaPrimitiveType(column.getTalendType(), column.isNullable());
                if(isPrimit){
                
    stringBuffer.append(TEXT_30);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_31);
    stringBuffer.append(rowStruct);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_33);
    
                }else{
                
    stringBuffer.append(TEXT_34);
    stringBuffer.append(rowStruct);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_38);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_40);
    stringBuffer.append(rowStruct);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_42);
    
                }
                
    stringBuffer.append(TEXT_43);
    stringBuffer.append(var("log4jSb"));
    stringBuffer.append(TEXT_44);
    
            }
        }
        trace(str("Content of the record "), nbline, str(": "), var("log4jSb"));
        
    
    }
}

class LogHelper{
    
    java.util.Map<String, String> pastDict = null;
    
    public LogHelper(){
        pastDict = new java.util.HashMap<String, String>();
        pastDict.put("insert", "inserted");
        pastDict.put("update", "updated");
        pastDict.put("delete", "deleted");
        pastDict.put("upsert", "upserted");
    }   
    
    public String upperFirstChar(String data){ 
        return data.substring(0, 1).toUpperCase() + data.substring(1);
    }
    
    public String toPastTense(String data){
        return pastDict.get(data);
    }
}
LogHelper logHelper = new LogHelper();

LogUtil log = null;

    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
LogUtil logUtil = new LogUtil(node);
String cid = node.getUniqueName();
String virtualcid = cid;
String destination = ElementParameterParser.getValue(node, "__DESTINATION__");
if(destination!=null && !"".equals(destination)){
    cid = destination;
}
boolean isStaging = "STAGING".equalsIgnoreCase(ElementParameterParser.getValue(node, "__CONTAINER_TYPE__"));
boolean useExistingConn = ("true").equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));
boolean isMassInsert =("true").equals(ElementParameterParser.getValue(node,"__EXTENDINSERT__"));
boolean withReport = ("true").equals(ElementParameterParser.getValue(node,"__WITHREPORT__"));
boolean addTaskID = ("true").equals(ElementParameterParser.getValue(node,"__ADD_TASKID__"));
String taskID = ElementParameterParser.getValue(node,"__TASKID__");
boolean usePartialUpdate = ("true").equals(ElementParameterParser.getValue(node,"__USE_PARTIAL_UPDATE__"));

    stringBuffer.append(TEXT_45);
    
INode sourceNode = node.getIncomingConnections(EConnectionType.ON_COMPONENT_OK).get(0).getSource();
String virtualSourceCid = sourceNode.getUniqueName();
INode startNode = NodeUtil.getSpecificStartNode(sourceNode);
String startNodeCid = null; 
if(startNode != null){
    startNodeCid = startNode.getUniqueName();
} 
IConnection nextMergeConn = NodeUtil.getNextMergeConnection(node);
if(nextMergeConn != null && nextMergeConn.getInputId()>1 && startNodeCid != null){

    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(virtualSourceCid);
    stringBuffer.append(TEXT_51);
    
}else{

    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(node.getUniqueName());
    stringBuffer.append(TEXT_60);
    
}

    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    
if(!usePartialUpdate){
    
    if(isMassInsert){
        if(!isStaging && withReport){

     logUtil.debug("\"Put item with report to MDM server.\"");
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
     logUtil.debug("\"Put item size:\"+wspks_"+cid+".size()");
     logUtil.debug("\"Put item with report array successfully.\"");
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_71);
    if(addTaskID){
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
     logUtil.debug("\"Add task id successfully.\"");
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    }
    stringBuffer.append(TEXT_87);
    
        }else{
     logUtil.debug("\"Put item with report to MDM server.\"");
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_92);
     logUtil.debug("\"Put item size:\"+wspks_"+cid+".size()");
     logUtil.debug("\"Put item with report array successfully.\"");
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_95);
    if(addTaskID){
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_108);
     logUtil.debug("\"Add task id successfully.\"");
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    }
    stringBuffer.append(TEXT_111);
    
        }
    }
}
    if(!useExistingConn){
     logUtil.debug("\"Closing connection to MDM server.\"");
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_113);
    }
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    return stringBuffer.toString();
  }
}
