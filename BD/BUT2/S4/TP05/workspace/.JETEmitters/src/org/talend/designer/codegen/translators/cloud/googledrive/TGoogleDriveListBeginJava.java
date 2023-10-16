package org.talend.designer.codegen.translators.cloud.googledrive;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.designer.codegen.config.NodeParamsHelper;
import java.util.List;
import java.util.ArrayList;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;

public class TGoogleDriveListBeginJava
{
  protected static String nl;
  public static synchronized TGoogleDriveListBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TGoogleDriveListBeginJava result = new TGoogleDriveListBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "com.google.api.services.drive.Drive ";
  protected final String TEXT_3 = "_client;";
  protected final String TEXT_4 = NL + "{";
  protected final String TEXT_5 = NL + " \tjavax.net.ssl.TrustManagerFactory tmf = javax.net.ssl.TrustManagerFactory" + NL + "\t.getInstance(javax.net.ssl.TrustManagerFactory" + NL + "\t\t\t.getDefaultAlgorithm());" + NL + "" + NL + "\tjava.io.FileInputStream fis = new java.io.FileInputStream(" + NL + "\t\t\t";
  protected final String TEXT_6 = ");" + NL + "\tjava.security.KeyStore ks = java.security.KeyStore" + NL + "\t\t\t.getInstance(java.security.KeyStore.getDefaultType());" + NL + "\t";
  protected final String TEXT_7 = NL + "\t";
  protected final String TEXT_8 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_9 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_10 = ");";
  protected final String TEXT_11 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_12 = " = ";
  protected final String TEXT_13 = "; ";
  protected final String TEXT_14 = NL + "                       " + NL + "\tks.load(fis, decryptedPassword_";
  protected final String TEXT_15 = ".toCharArray());" + NL + "\tfis.close();" + NL + "\ttmf.init(ks);" + NL + "\tjavax.net.ssl.SSLContext sslContext = javax.net.ssl.SSLContext.getInstance(";
  protected final String TEXT_16 = ");" + NL + "\tsslContext.init(null, tmf.getTrustManagers(), new java.security.SecureRandom());";
  protected final String TEXT_17 = NL + "com.google.api.client.http.HttpTransport httpTransport = new com.google.api.client.http.javanet.NetHttpTransport.Builder()";
  protected final String TEXT_18 = NL + "\t\t.setProxy(new java.net.Proxy(java.net.Proxy.Type.HTTP, java.net.InetSocketAddress.createUnresolved(";
  protected final String TEXT_19 = ", ";
  protected final String TEXT_20 = ")))";
  protected final String TEXT_21 = NL + "\t.setSslSocketFactory(sslContext.getSocketFactory())";
  protected final String TEXT_22 = NL + "\t.build();" + NL + "" + NL + "\tcom.google.api.client.googleapis.auth.oauth2.GoogleCredential credential = new com.google.api.client.googleapis.auth.oauth2.GoogleCredential().setAccessToken(";
  protected final String TEXT_23 = ");" + NL + "\t";
  protected final String TEXT_24 = "_client = new  com.google.api.services.drive.Drive.Builder(httpTransport, new com.google.api.client.json.jackson2.JacksonFactory(), credential)" + NL + "\t.setApplicationName(";
  protected final String TEXT_25 = "+\" (GPN:Talend)\").build();" + NL + "}\t";
  protected final String TEXT_26 = NL + "\t";
  protected final String TEXT_27 = "_client = (com.google.api.services.drive.Drive)globalMap.get(";
  protected final String TEXT_28 = ");";
  protected final String TEXT_29 = NL + "    java.util.List<com.google.api.services.drive.model.File> ";
  protected final String TEXT_30 = "_result = new java.util.ArrayList<com.google.api.services.drive.model.File>();" + NL + "    com.google.api.services.drive.Drive.Files.List ";
  protected final String TEXT_31 = "_request = ";
  protected final String TEXT_32 = "_client.files().list();" + NL + "    String ";
  protected final String TEXT_33 = "_folderName = ";
  protected final String TEXT_34 = ";" + NL + "    String ";
  protected final String TEXT_35 = "_qTrash = ";
  protected final String TEXT_36 = "\" and trashed=false\"";
  protected final String TEXT_37 = " \"\" ";
  protected final String TEXT_38 = "; " + NL + "" + NL + "    if (";
  protected final String TEXT_39 = "_folderName == null || ";
  protected final String TEXT_40 = "_folderName.isEmpty())" + NL + "    {" + NL + "    \tthrow new Exception(\"Folder name can not be empty\");" + NL + "    }" + NL + "\t" + NL + "    if(";
  protected final String TEXT_41 = "_folderName.startsWith(\"\\\"\")){" + NL + "\t\t";
  protected final String TEXT_42 = "_folderName = ";
  protected final String TEXT_43 = "_folderName.substring(1);" + NL + "\t}" + NL + "\tif(";
  protected final String TEXT_44 = "_folderName.endsWith(\"\\\"\")){" + NL + "\t\t";
  protected final String TEXT_45 = "_folderName = ";
  protected final String TEXT_46 = "_folderName.substring(0, ";
  protected final String TEXT_47 = "_folderName.length() - 1);" + NL + "    }" + NL + "\t";
  protected final String TEXT_48 = " //without subfolders" + NL + "    do {" + NL + "      " + NL + "      if(!";
  protected final String TEXT_49 = "_folderName.equals(\"root\")) {" + NL + "      \t\t";
  protected final String TEXT_50 = "_request.setQ(\"title = '\" + ";
  protected final String TEXT_51 = "_folderName + \"'\"+";
  protected final String TEXT_52 = "_qTrash+\" and mimeType = 'application/vnd.google-apps.folder'\");" + NL + "      } else {" + NL + "      " + NL + "\t  \t";
  protected final String TEXT_53 = NL + "\t  \t\t";
  protected final String TEXT_54 = "_request.setQ(\"'\" + ";
  protected final String TEXT_55 = "_folderName + \"' in parents\"+";
  protected final String TEXT_56 = "_qTrash);" + NL + "      \t";
  protected final String TEXT_57 = NL + "      \t\t";
  protected final String TEXT_58 = "_request.setQ(\"'\" + ";
  protected final String TEXT_59 = "_folderName + \"' in parents\"+";
  protected final String TEXT_60 = "_qTrash+\" and mimeType != 'application/vnd.google-apps.folder'\");" + NL + "      \t";
  protected final String TEXT_61 = NL + "      \t\t";
  protected final String TEXT_62 = "_request.setQ(\"'\" + ";
  protected final String TEXT_63 = "_folderName + \"' in parents\"+";
  protected final String TEXT_64 = "_qTrash+\" and mimeType = 'application/vnd.google-apps.folder'\");" + NL + "      \t";
  protected final String TEXT_65 = NL + "      }" + NL + "        com.google.api.services.drive.model.FileList files = ";
  protected final String TEXT_66 = "_request.execute();" + NL + "        if(!";
  protected final String TEXT_67 = "_folderName.equals(\"root\")) {" + NL + "\t        if (files.getItems().size() > 1) {" + NL + "\t        \tthrow new Exception(\"More than one folder with name \" + \"\\\"\" + ";
  protected final String TEXT_68 = "_folderName + \"\\\" found!\");" + NL + "\t        } else if (files.getItems().isEmpty()) {" + NL + "\t        \tthrow new Exception(\"No folder with name \" + \"\\\"\" + ";
  protected final String TEXT_69 = "_folderName + \"\\\" found!\");" + NL + "\t        } else {" + NL + "\t        \t";
  protected final String TEXT_70 = "_request = ";
  protected final String TEXT_71 = "_client.files().list();" + NL + "\t        \t";
  protected final String TEXT_72 = NL + "\t        \t\t";
  protected final String TEXT_73 = "_request.setQ(\"'\" + files.getItems().get(0).getId() + \"' in parents\"+";
  protected final String TEXT_74 = "_qTrash);" + NL + "\t        \t";
  protected final String TEXT_75 = NL + "\t        \t\t";
  protected final String TEXT_76 = "_request.setQ(\"'\" + files.getItems().get(0).getId() + \"' in parents\"+";
  protected final String TEXT_77 = "_qTrash+\" and mimeType != 'application/vnd.google-apps.folder'\");" + NL + "\t        \t";
  protected final String TEXT_78 = NL + "\t        \t\t";
  protected final String TEXT_79 = "_request.setQ(\"'\" + files.getItems().get(0).getId() + \"' in parents\"+";
  protected final String TEXT_80 = "_qTrash+\" and mimeType = 'application/vnd.google-apps.folder'\");" + NL + "\t        \t";
  protected final String TEXT_81 = NL + "\t        \tfiles = ";
  protected final String TEXT_82 = "_request.execute();" + NL + "\t        }" + NL + "        }";
  protected final String TEXT_83 = NL + "        ";
  protected final String TEXT_84 = "_result.addAll(files.getItems());";
  protected final String TEXT_85 = NL + "        ";
  protected final String TEXT_86 = "_request.setPageToken(files.getNextPageToken());" + NL + "    } while (";
  protected final String TEXT_87 = "_request.getPageToken() != null &&";
  protected final String TEXT_88 = NL + "             ";
  protected final String TEXT_89 = "_request.getPageToken().length() > 0);";
  protected final String TEXT_90 = NL + "    java.util.List<String> subfolders_";
  protected final String TEXT_91 = " = new java.util.ArrayList<String>(); " + NL + "    if(!";
  protected final String TEXT_92 = "_folderName.equals(\"root\")) {" + NL + "   \t\t";
  protected final String TEXT_93 = "_request.setQ(\"title = '\" + ";
  protected final String TEXT_94 = "_folderName + \"'\"+";
  protected final String TEXT_95 = "_qTrash+\" and mimeType = 'application/vnd.google-apps.folder'\");" + NL + "   \t\tcom.google.api.services.drive.model.FileList ";
  protected final String TEXT_96 = "_files = ";
  protected final String TEXT_97 = "_request.execute();" + NL + "   \t\tif (";
  protected final String TEXT_98 = "_files.getItems().size() > 1) {" + NL + "        \tthrow new Exception(\"More than one folder with name \" + \"\\\"\" + ";
  protected final String TEXT_99 = "_folderName + \"\\\" found!\");" + NL + "        } else if (";
  protected final String TEXT_100 = "_files.getItems().isEmpty()) {" + NL + "        \tthrow new Exception(\"No folder with name \" + \"\\\"\" + ";
  protected final String TEXT_101 = "_folderName + \"\\\" found!\");" + NL + "        } else {" + NL + "        \tsubfolders_";
  protected final String TEXT_102 = ".add(";
  protected final String TEXT_103 = "_files.getItems().get(0).getId());" + NL + "   \t\t}" + NL + "   \t\t";
  protected final String TEXT_104 = "_request = ";
  protected final String TEXT_105 = "_client.files().list();" + NL + "    } else {" + NL + "\tsubfolders_";
  protected final String TEXT_106 = ".add(";
  protected final String TEXT_107 = "_folderName);" + NL + "\t}" + NL + "\twhile (subfolders_";
  protected final String TEXT_108 = ".size()>0) {" + NL + "    do {" + NL + "\t  \t";
  protected final String TEXT_109 = NL + "\t  \t\t";
  protected final String TEXT_110 = "_request.setQ(\"'\"+subfolders_";
  protected final String TEXT_111 = ".get(0)+\"' in parents\"+";
  protected final String TEXT_112 = "_qTrash+\" and mimeType = 'application/vnd.google-apps.folder'\");" + NL + "     \t";
  protected final String TEXT_113 = NL + "      \t\t";
  protected final String TEXT_114 = "_request.setQ(\"'\"+subfolders_";
  protected final String TEXT_115 = ".get(0)+\"' in parents\"+";
  protected final String TEXT_116 = "_qTrash); // check all files and folders" + NL + "      \t";
  protected final String TEXT_117 = NL + "        com.google.api.services.drive.model.FileList files = ";
  protected final String TEXT_118 = "_request.execute();" + NL + "       " + NL + "\t\tfor (com.google.api.services.drive.model.File file : files.getItems()) {" + NL + "\t\t  if (file.getMimeType().equals(\"application/vnd.google-apps.folder\")) {" + NL + "\t\t\tsubfolders_";
  protected final String TEXT_119 = ".add(file.getId());" + NL + "          } " + NL + "          if (" + NL + "\t\t\t      \"BOTH\".equals(\"";
  protected final String TEXT_120 = "\")" + NL + "\t\t\t\t || (" + NL + "\t\t\t\t       \"FILES\".equals(\"";
  protected final String TEXT_121 = "\")" + NL + "\t\t\t\t\t    &&" + NL + "\t\t\t\t\t\t!file.getMimeType().equals(\"application/vnd.google-apps.folder\")" + NL + "\t\t\t\t\t) " + NL + "\t\t\t\t || (" + NL + "\t\t\t\t        \"DIRECTORIES\".equals(\"";
  protected final String TEXT_122 = "\")" + NL + "\t\t\t\t\t\t && " + NL + "\t\t\t\t\t\t file.getMimeType().equals(\"application/vnd.google-apps.folder\")" + NL + "\t\t\t\t\t) " + NL + "\t\t    )" + NL + "\t\t  {" + NL + "\t\t\t";
  protected final String TEXT_123 = "_result.add(file);" + NL + "\t\t  }" + NL + " \t\t}";
  protected final String TEXT_124 = NL + "        ";
  protected final String TEXT_125 = "_request.setPageToken(files.getNextPageToken());" + NL + "    } while (";
  protected final String TEXT_126 = "_request.getPageToken() != null &&";
  protected final String TEXT_127 = NL + "             ";
  protected final String TEXT_128 = "_request.getPageToken().length() > 0);" + NL + "    subfolders_";
  protected final String TEXT_129 = ".remove(0);" + NL + "\t}" + NL + "     ";
  protected final String TEXT_130 = NL + "\tfor (com.google.api.services.drive.model.File ";
  protected final String TEXT_131 = "_temp : ";
  protected final String TEXT_132 = "_result) {" + NL + "" + NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_133 = "_ID\",";
  protected final String TEXT_134 = "_temp.getId());" + NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_135 = "_TITLE\",";
  protected final String TEXT_136 = "_temp.getTitle());" + NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_137 = "_MIME_TYPE\",";
  protected final String TEXT_138 = "_temp.getMimeType());" + NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_139 = "_LAST_MODIFIED\",";
  protected final String TEXT_140 = "_temp.getModifiedDate().toStringRfc3339());" + NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_141 = "_SIZE\",";
  protected final String TEXT_142 = "_temp.getFileSize());" + NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_143 = "_SELF_LINK\",";
  protected final String TEXT_144 = "_temp.getSelfLink());" + NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_145 = "_PARENTS\",";
  protected final String TEXT_146 = "_temp.getParents());" + NL + "\t\t\ttry{" + NL + NL;
  protected final String TEXT_147 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
NodeParamsHelper helper = new NodeParamsHelper(node);

String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
String accessToken = helper.getStringParam("__ACCESS_TOKEN__");
String folderName = helper.getStringParam("__FOLDER_NAME__");
boolean useProxy = helper.getBoolParam("__USE_PROXY__");
boolean useSSL = helper.getBoolParam("__USE_SSL__");
boolean withTrashFiles = helper.getBoolParam("__INCLUDTRASHFILES__");


String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
String connectionKey = "\"conn_" + connection+"\"";

List< ? extends IConnection> outputConnections = node.getOutgoingSortedConnections();
		
String dataOutputConnection = null;	
    for(IConnection conn : outputConnections) {
        if(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
        	dataOutputConnection = conn.getName();
        	break;
        } // if(conn) end
    } // for(conns) end

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    
if(!"true".equals(useExistingConn)){

    stringBuffer.append(TEXT_4);
    
if(useSSL) {

    stringBuffer.append(TEXT_5);
    stringBuffer.append(helper.getStringParam("__SSL_TRUST_STORE__"));
    stringBuffer.append(TEXT_6);
    String passwordFieldName = "__SSL_TRUST_STORE_PASSWORD__";
    stringBuffer.append(TEXT_7);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_10);
    } else {
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_13);
    }
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(helper.getStringParam("__SSL_ALGORITHM__"));
    stringBuffer.append(TEXT_16);
    	
}

    stringBuffer.append(TEXT_17);
    if(useProxy){
String proxyHost = helper.getStringParam("__PROXY_HOST__");
String proxyPort = helper.getStringParam("__PROXY_PORT__");

    stringBuffer.append(TEXT_18);
    stringBuffer.append(proxyHost);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(proxyPort);
    stringBuffer.append(TEXT_20);
    }
  if(useSSL) {

    stringBuffer.append(TEXT_21);
    
  }

    stringBuffer.append(TEXT_22);
    stringBuffer.append(accessToken);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(helper.getStringParam("__APPLICATION_NAME__"));
    stringBuffer.append(TEXT_25);
    
} else {

    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(connectionKey);
    stringBuffer.append(TEXT_28);
    }
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(folderName);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
     if (!withTrashFiles) {
    stringBuffer.append(TEXT_36);
     } else {
    stringBuffer.append(TEXT_37);
     } 
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    if ("false".equals(helper.getStringParam("__INCLUDSUBDIR__"))) { 
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    if ("BOTH".equals(helper.getStringParam("__LIST_MODE__"))) {
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    } else if ("FILES".equals(helper.getStringParam("__LIST_MODE__"))) {
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    } else {
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    }
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    if ("BOTH".equals(helper.getStringParam("__LIST_MODE__"))) {
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    } else if ("FILES".equals(helper.getStringParam("__LIST_MODE__"))) {
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    } else {
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    }
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    } else {
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_108);
    if ("DIRECTORIES".equals(helper.getStringParam("__LIST_MODE__"))) {
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    } else {
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    }
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_119);
    stringBuffer.append(helper.getStringParam("__LIST_MODE__"));
    stringBuffer.append(TEXT_120);
    stringBuffer.append(helper.getStringParam("__LIST_MODE__"));
    stringBuffer.append(TEXT_121);
    stringBuffer.append(helper.getStringParam("__LIST_MODE__"));
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_129);
    }
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(TEXT_147);
    return stringBuffer.toString();
  }
}
