package org.talend.designer.codegen.translators.generic.component;

import java.util.List;
import java.util.Set;
import java.util.HashSet;
import org.talend.components.api.component.ComponentDefinition;
import org.talend.designer.core.generic.model.Component;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.EConnectionType;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.utils.TalendTextUtils;
import org.talend.core.model.utils.NodeUtil;
import org.talend.designer.core.generic.model.Component;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.talend.components.api.properties.ComponentProperties;
import org.talend.daikon.NamedThing;
import org.talend.daikon.properties.property.Property;
import org.talend.designer.core.generic.constants.IGenericConstants;
import org.talend.core.model.utils.ContextParameterUtils;

public class ComponentMain
{
  protected static String nl;
  public static synchronized ComponentMain create(String lineSeparator)
  {
    nl = lineSeparator;
    ComponentMain result = new ComponentMain();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "            boolean ";
  protected final String TEXT_2 = " = false;" + NL + "            routines.system.Dynamic ";
  protected final String TEXT_3 = " = new routines.system.Dynamic();";
  protected final String TEXT_4 = NL + "        org.talend.codegen.enforcer.OutgoingSchemaEnforcer ";
  protected final String TEXT_5 = " = org.talend.codegen.enforcer.EnforcerCreator.createOutgoingEnforcer(";
  protected final String TEXT_6 = ", ";
  protected final String TEXT_7 = ");" + NL + "" + NL + "        // Create a reusable factory that converts the output of the reader to an IndexedRecord." + NL + "        org.talend.daikon.avro.converter.IndexedRecordConverter<Object, ? extends org.apache.avro.generic.IndexedRecord> ";
  protected final String TEXT_8 = " = null;";
  protected final String TEXT_9 = NL + "        // Construct the factory once when the first data arrives." + NL + "        if (";
  protected final String TEXT_10 = " == null) {";
  protected final String TEXT_11 = NL + "            ";
  protected final String TEXT_12 = " = (org.talend.daikon.avro.converter.IndexedRecordConverter<Object, ? extends org.apache.avro.generic.IndexedRecord>)" + NL + "                    new org.talend.daikon.avro.AvroRegistry()" + NL + "                            .createIndexedRecordConverter(";
  protected final String TEXT_13 = ".getClass());" + NL + "        }" + NL + "" + NL + "        // Enforce the outgoing schema on the input.";
  protected final String TEXT_14 = NL + "        ";
  protected final String TEXT_15 = ".setWrapped(";
  protected final String TEXT_16 = ".convertToAvro(";
  protected final String TEXT_17 = "));";
  protected final String TEXT_18 = NL + "            if (!";
  protected final String TEXT_19 = ") {" + NL + "                org.apache.avro.Schema dynSchema_";
  protected final String TEXT_20 = " = ((org.talend.codegen.enforcer.OutgoingDynamicSchemaEnforcer) ";
  protected final String TEXT_21 = ").getDynamicFieldsSchema();" + NL + "                for (org.apache.avro.Schema.Field dynamicField_";
  protected final String TEXT_22 = " : dynSchema_";
  protected final String TEXT_23 = ".getFields()){" + NL + "                    routines.system.DynamicMetadata dynamicMetadata_";
  protected final String TEXT_24 = " = new routines.system.DynamicMetadata();" + NL + "                    org.apache.avro.Schema dynamicFieldSchema_";
  protected final String TEXT_25 = " = dynamicField_";
  protected final String TEXT_26 = ".schema();" + NL + "                    // set name" + NL + "                    dynamicMetadata_";
  protected final String TEXT_27 = ".setName(dynamicField_";
  protected final String TEXT_28 = ".name());" + NL + "                    // set db name" + NL + "                    dynamicMetadata_";
  protected final String TEXT_29 = ".setDbName(dynamicField_";
  protected final String TEXT_30 = ".name());" + NL + "                    // set nullable" + NL + "                    if (org.talend.daikon.avro.AvroUtils.isNullable(dynamicFieldSchema_";
  protected final String TEXT_31 = ")) {" + NL + "                        dynamicMetadata_";
  protected final String TEXT_32 = ".setNullable(true);" + NL + "                    }" + NL + "                    // set type" + NL + "                    String talendType_";
  protected final String TEXT_33 = " = org.talend.codegen.converter.TypeConverter.avroToDi(dynamicFieldSchema_";
  protected final String TEXT_34 = ");" + NL + "                    dynamicMetadata_";
  protected final String TEXT_35 = ".setType(talendType_";
  protected final String TEXT_36 = ");" + NL + "                    // set pattern" + NL + "                    String pattern_";
  protected final String TEXT_37 = " = dynamicField_";
  protected final String TEXT_38 = ".getProp(org.talend.daikon.avro.SchemaConstants.TALEND_COLUMN_PATTERN);" + NL + "                    if (pattern_";
  protected final String TEXT_39 = " != null && !pattern_";
  protected final String TEXT_40 = ".trim().isEmpty()) {" + NL + "                        dynamicMetadata_";
  protected final String TEXT_41 = ".setFormat(pattern_";
  protected final String TEXT_42 = ");" + NL + "                    }" + NL + "                    // set logical type" + NL + "                    org.apache.avro.Schema unwrappedSchema_";
  protected final String TEXT_43 = " = org.talend.daikon.avro.AvroUtils.unwrapIfNullable(dynamicFieldSchema_";
  protected final String TEXT_44 = ");" + NL + "                    String logicalType_";
  protected final String TEXT_45 = " = org.talend.daikon.avro.LogicalTypeUtils.getLogicalTypeName(unwrappedSchema_";
  protected final String TEXT_46 = ");" + NL + "                    dynamicMetadata_";
  protected final String TEXT_47 = ".setLogicalType(logicalType_";
  protected final String TEXT_48 = ");" + NL + "                    // set length" + NL + "                    Object length_";
  protected final String TEXT_49 = " = dynamicField_";
  protected final String TEXT_50 = ".getProp(org.talend.daikon.avro.SchemaConstants.TALEND_COLUMN_DB_LENGTH);" + NL + "                    if (length_";
  protected final String TEXT_51 = " != null) {" + NL + "                        dynamicMetadata_";
  protected final String TEXT_52 = ".setLength(Integer.parseInt(String.valueOf(length_";
  protected final String TEXT_53 = ")));" + NL + "                    }" + NL + "                    // set precision" + NL + "                    Object precision_";
  protected final String TEXT_54 = " = dynamicField_";
  protected final String TEXT_55 = ".getProp(org.talend.daikon.avro.SchemaConstants.TALEND_COLUMN_PRECISION); " + NL + "                    if (precision_";
  protected final String TEXT_56 = " != null) {" + NL + "                        dynamicMetadata_";
  protected final String TEXT_57 = ".setPrecision(Integer.parseInt(String.valueOf(precision_";
  protected final String TEXT_58 = ")));" + NL + "                    } " + NL + "                    // add dynamic field metadata to dynamic variable";
  protected final String TEXT_59 = NL + "                    ";
  protected final String TEXT_60 = ".metadatas.add(dynamicMetadata_";
  protected final String TEXT_61 = ");" + NL + "                }" + NL + "                initDyn_";
  protected final String TEXT_62 = " = true;" + NL + "            }";
  protected final String TEXT_63 = NL + "            ";
  protected final String TEXT_64 = ".clearColumnValues();";
  protected final String TEXT_65 = NL + "                java.util.Map<String, Object> dynamicValue_";
  protected final String TEXT_66 = " = (java.util.Map<String, Object>) ";
  protected final String TEXT_67 = ".get(";
  protected final String TEXT_68 = ");" + NL + "                for (java.util.Map.Entry<String, Object> dynamicValueEntry_";
  protected final String TEXT_69 = " : dynamicValue_";
  protected final String TEXT_70 = ".entrySet()) {";
  protected final String TEXT_71 = NL + "                    ";
  protected final String TEXT_72 = ".setColumnValue(";
  protected final String TEXT_73 = ".getIndex(dynamicValueEntry_";
  protected final String TEXT_74 = ".getKey()), dynamicValueEntry_";
  protected final String TEXT_75 = ".getValue());" + NL + "                }";
  protected final String TEXT_76 = NL + "                ";
  protected final String TEXT_77 = ".";
  protected final String TEXT_78 = " = ";
  protected final String TEXT_79 = ";";
  protected final String TEXT_80 = NL + "                Object columnValue_";
  protected final String TEXT_81 = "_";
  protected final String TEXT_82 = " = ";
  protected final String TEXT_83 = ".get(";
  protected final String TEXT_84 = ");";
  protected final String TEXT_85 = NL + "                        ";
  protected final String TEXT_86 = ".";
  protected final String TEXT_87 = " = ParserUtils.parseTo_Document(String.valueOf(columnValue_";
  protected final String TEXT_88 = "_";
  protected final String TEXT_89 = "));";
  protected final String TEXT_90 = NL + "                        ";
  protected final String TEXT_91 = ".";
  protected final String TEXT_92 = " = (";
  protected final String TEXT_93 = ") (columnValue_";
  protected final String TEXT_94 = "_";
  protected final String TEXT_95 = ");";
  protected final String TEXT_96 = NL + "                    if (columnValue_";
  protected final String TEXT_97 = "_";
  protected final String TEXT_98 = " == null) {";
  protected final String TEXT_99 = NL + "                        ";
  protected final String TEXT_100 = ".";
  protected final String TEXT_101 = " = ";
  protected final String TEXT_102 = ";" + NL + "                    } else {";
  protected final String TEXT_103 = NL + "                            ";
  protected final String TEXT_104 = ".";
  protected final String TEXT_105 = " = ParserUtils.parseTo_Document(String.valueOf(columnValue_";
  protected final String TEXT_106 = "_";
  protected final String TEXT_107 = "));";
  protected final String TEXT_108 = NL + "                            ";
  protected final String TEXT_109 = ".";
  protected final String TEXT_110 = " = (";
  protected final String TEXT_111 = ") (columnValue_";
  protected final String TEXT_112 = "_";
  protected final String TEXT_113 = ");";
  protected final String TEXT_114 = NL + "                    }";
  protected final String TEXT_115 = NL + " \t\t                    java.util.List<Object> ";
  protected final String TEXT_116 = " = new java.util.ArrayList<Object>();" + NL + " \t\t                    ";
  protected final String TEXT_117 = NL + " \t\t                    ";
  protected final String TEXT_118 = " = new java.util.ArrayList<Object>();" + NL + " \t\t                    ";
  protected final String TEXT_119 = NL + " \t\t                            ";
  protected final String TEXT_120 = ".add(\"";
  protected final String TEXT_121 = "\");" + NL + " \t\t                            ";
  protected final String TEXT_122 = NL + " \t\t                                ";
  protected final String TEXT_123 = ".add(";
  protected final String TEXT_124 = ");" + NL + " \t\t                                ";
  protected final String TEXT_125 = NL + " \t\t                            ";
  protected final String TEXT_126 = ".add(\"\");" + NL + " \t\t                            ";
  protected final String TEXT_127 = NL + " \t\t                    ((org.talend.daikon.properties.Properties)props_";
  protected final String TEXT_128 = ").setValue(\"";
  protected final String TEXT_129 = "\",";
  protected final String TEXT_130 = ");" + NL + " \t\t                    ";
  protected final String TEXT_131 = NL + " \t\t                        props_";
  protected final String TEXT_132 = ".setValue(\"";
  protected final String TEXT_133 = "\"," + NL + " \t\t                        routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_134 = "));" + NL + " \t\t                        ";
  protected final String TEXT_135 = NL + " \t\t                    props_";
  protected final String TEXT_136 = ".setValue(\"";
  protected final String TEXT_137 = "\"," + NL + " \t\t                        TalendDate.parseDate(\"yyyy-MM-dd HH:mm:ss\",";
  protected final String TEXT_138 = "));" + NL + " \t\t                    ";
  protected final String TEXT_139 = NL + " \t\t                    props_";
  protected final String TEXT_140 = ".setValue(\"";
  protected final String TEXT_141 = "\"," + NL + " \t\t                        ";
  protected final String TEXT_142 = ".";
  protected final String TEXT_143 = ");" + NL + " \t\t                    ";
  protected final String TEXT_144 = NL + " \t\t                    props_";
  protected final String TEXT_145 = ".setValue(\"";
  protected final String TEXT_146 = "\"," + NL + " \t\t                        new org.apache.avro.Schema.Parser().parse(";
  protected final String TEXT_147 = "));" + NL + " \t\t                    ";
  protected final String TEXT_148 = NL + " \t\t                    props_";
  protected final String TEXT_149 = ".setValue(\"";
  protected final String TEXT_150 = "\"," + NL + " \t\t                    ";
  protected final String TEXT_151 = ");" + NL + " \t\t                    ";
  protected final String TEXT_152 = NL + " \t\t                props_";
  protected final String TEXT_153 = ".setValue(\"";
  protected final String TEXT_154 = "\", null);" + NL + " \t\t            ";
  protected final String TEXT_155 = NL + "                ";
  protected final String TEXT_156 = " = null;";
  protected final String TEXT_157 = NL + "                if (!incomingEnforcer_";
  protected final String TEXT_158 = ".areDynamicFieldsInitialized()) {" + NL + "                    // Initialize the dynamic columns when they are first encountered." + NL + "                    for (routines.system.DynamicMetadata dm_";
  protected final String TEXT_159 = " : ";
  protected final String TEXT_160 = ".";
  protected final String TEXT_161 = ".metadatas) {" + NL + "                        incomingEnforcer_";
  protected final String TEXT_162 = ".addDynamicField(" + NL + "                                dm_";
  protected final String TEXT_163 = ".getName()," + NL + "                                dm_";
  protected final String TEXT_164 = ".getType()," + NL + "                                dm_";
  protected final String TEXT_165 = ".getLogicalType()," + NL + "                                dm_";
  protected final String TEXT_166 = ".getFormat()," + NL + "                                dm_";
  protected final String TEXT_167 = ".getDescription()," + NL + "                                dm_";
  protected final String TEXT_168 = ".isNullable());" + NL + "                    }" + NL + "                    incomingEnforcer_";
  protected final String TEXT_169 = ".createRuntimeSchema();" + NL + "                }";
  protected final String TEXT_170 = NL + "            incomingEnforcer_";
  protected final String TEXT_171 = ".createNewRecord();";
  protected final String TEXT_172 = NL + "                    incomingEnforcer_";
  protected final String TEXT_173 = ".put(\"";
  protected final String TEXT_174 = "\", ";
  protected final String TEXT_175 = ".";
  protected final String TEXT_176 = ");";
  protected final String TEXT_177 = NL + "                    for (int i = 0; i < ";
  protected final String TEXT_178 = ".";
  protected final String TEXT_179 = ".getColumnCount(); i++) {" + NL + "                        incomingEnforcer_";
  protected final String TEXT_180 = ".put(";
  protected final String TEXT_181 = ".";
  protected final String TEXT_182 = ".getColumnMetadata(i).getName(),";
  protected final String TEXT_183 = NL + "                                ";
  protected final String TEXT_184 = ".";
  protected final String TEXT_185 = ".getColumnValue(i));" + NL + "                    }";
  protected final String TEXT_186 = NL + "            org.apache.avro.generic.IndexedRecord data_";
  protected final String TEXT_187 = " = incomingEnforcer_";
  protected final String TEXT_188 = ".getCurrentRecord();" + NL + "" + NL + "            writer_";
  protected final String TEXT_189 = ".write(data_";
  protected final String TEXT_190 = ");" + NL + "            " + NL + "            nb_line_";
  protected final String TEXT_191 = "++;";
  protected final String TEXT_192 = NL + "            \tif (writer_";
  protected final String TEXT_193 = " instanceof org.talend.components.api.component.runtime.WriterWithFeedback) {" + NL + "\t\t\t\t\torg.talend.components.api.component.runtime.WriterWithFeedback writerWithFeedbackMain_";
  protected final String TEXT_194 = " = (org.talend.components.api.component.runtime.WriterWithFeedback) writer_";
  protected final String TEXT_195 = ";" + NL + "\t\t\t\t\twriterWithFeedbackMain_";
  protected final String TEXT_196 = " = new org.talend.codegen.flowvariables.runtime.FlowVariablesWriter(writerWithFeedbackMain_";
  protected final String TEXT_197 = ", container_";
  protected final String TEXT_198 = ");" + NL + "                    java.util.Iterator outgoingMainRecords_";
  protected final String TEXT_199 = " = writerWithFeedbackMain_";
  protected final String TEXT_200 = ".getSuccessfulWrites().iterator();" + NL + "                    Object outgoingMain_";
  protected final String TEXT_201 = " = null;" + NL + "                    if (outgoingMainRecords_";
  protected final String TEXT_202 = ".hasNext()) {" + NL + "                        outgoingMain_";
  protected final String TEXT_203 = " = outgoingMainRecords_";
  protected final String TEXT_204 = ".next();" + NL + "                        if(outgoingMainRecords_";
  protected final String TEXT_205 = ".hasNext()){" + NL + "                        \toutgoingMain_";
  protected final String TEXT_206 = " = data_";
  protected final String TEXT_207 = ";" + NL + "                        }" + NL + "                    }";
  protected final String TEXT_208 = NL + "                    else {" + NL + "                    \tif (!writerWithFeedbackMain_";
  protected final String TEXT_209 = ".getRejectedWrites().iterator().hasNext()) {" + NL + "                    \t\toutgoingMain_";
  protected final String TEXT_210 = " = data_";
  protected final String TEXT_211 = ";" + NL + "                    \t}" + NL + "                    }";
  protected final String TEXT_212 = NL + "                    if (outgoingMain_";
  protected final String TEXT_213 = "!=null) {" + NL + "                    \t";
  protected final String TEXT_214 = " = new ";
  protected final String TEXT_215 = "Struct();" + NL + "                    \t";
  protected final String TEXT_216 = NL + "                    }" + NL + "              \t} else {" + NL + "              \t\t// For no feedback writer,just pass the input record to the output" + NL + "              \t\tif (data_";
  protected final String TEXT_217 = "!=null) {" + NL + "                  \t\t";
  protected final String TEXT_218 = " = new ";
  protected final String TEXT_219 = "Struct();" + NL + "                \t\t";
  protected final String TEXT_220 = NL + "                  \t}" + NL + "            \t}";
  protected final String TEXT_221 = NL + "\t\t\t\t\torg.talend.components.api.component.runtime.WriterWithFeedback writerWithFeedbackReject_";
  protected final String TEXT_222 = " = (org.talend.components.api.component.runtime.WriterWithFeedback) writer_";
  protected final String TEXT_223 = ";" + NL + "\t\t\t\t\twriterWithFeedbackReject_";
  protected final String TEXT_224 = " = new org.talend.codegen.flowvariables.runtime.FlowVariablesWriter(writerWithFeedbackReject_";
  protected final String TEXT_225 = ", container_";
  protected final String TEXT_226 = ");" + NL + "                    java.util.Iterator outgoingRejectRecords_";
  protected final String TEXT_227 = " = writerWithFeedbackReject_";
  protected final String TEXT_228 = ".getRejectedWrites().iterator();" + NL + "                    if (outgoingRejectRecords_";
  protected final String TEXT_229 = ".hasNext()) {";
  protected final String TEXT_230 = NL + "                        ";
  protected final String TEXT_231 = " = new ";
  protected final String TEXT_232 = "Struct();" + NL + "                        Object outgoingReject_";
  protected final String TEXT_233 = " = outgoingRejectRecords_";
  protected final String TEXT_234 = ".next();";
  protected final String TEXT_235 = NL + "                    }";
  protected final String TEXT_236 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    

/**
 * Utility for generating code that can turn an IndexedRecording coming from a
 * generic component into a rowStruct expected by the Studio.
 */
class IndexedRecordToRowStructGenerator {

    /** A unique tag for generating code variables, usually based on the cid
     *  of the node. */
    private final String cid;

    /** The columns in the rowStruct to generate. */
    private final List<IMetadataColumn> columns;

    /** The connection that we're generating code for. */
    private final IConnection connection;

    /** If there is a dynamic column, its name.  Null if none. */
    private final String dynamicColName;

    /** Variable names generated in code used by this utility. */
    private final String codeVarSchemaEnforcer;
    private final String codeVarIsDynamicInitialized;
    private final String codeVarDynamic;
    private final String codeVarIndexedRecordAdapter;

    public IndexedRecordToRowStructGenerator(String cid, IConnection connection) {
        this(cid, connection, connection.getMetadataTable().getListColumns());
    }

    public IndexedRecordToRowStructGenerator(String cid, IConnection connection, List<IMetadataColumn> columns) {
        this.cid = cid;
        this.connection = connection;
        this.columns = columns;

        String tmpDynamicColName = null;
        for (IMetadataColumn column : columns) {
            if (column.getTalendType().equals("id_Dynamic")) {
                tmpDynamicColName = column.getLabel();
                break;
            }
        }
        dynamicColName = tmpDynamicColName;

        this.codeVarSchemaEnforcer = "outgoingEnforcer_" + cid;
        this.codeVarIsDynamicInitialized = "initDyn_" + cid;
        this.codeVarDynamic = "dynamic_" + cid;
        this.codeVarIndexedRecordAdapter = "factory_" + cid;
    }

    public IConnection getConnection() {
        return connection;
    }

    /**
     * Generate code that declares and initializes the variables that are used
     * in the code generated by this utility.
     */
    public void generateInitialVariables(String codeVarSchemaToEnforce, boolean dynamicByPosition) {
        if (dynamicColName != null) {
            
    stringBuffer.append(TEXT_1);
    stringBuffer.append(codeVarIsDynamicInitialized);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(codeVarDynamic);
    stringBuffer.append(TEXT_3);
    
        }

        
    stringBuffer.append(TEXT_4);
    stringBuffer.append(codeVarSchemaEnforcer);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(codeVarSchemaToEnforce);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(dynamicByPosition);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(codeVarIndexedRecordAdapter);
    stringBuffer.append(TEXT_8);
    
    }

    /**
     * Generate code that copies data from the IndexedRecord to the rowStruct.
     *
     * @param codeVarIndexedRecord the name of the variable that contains the
     *    IndexedRecord.
     * @param codeVarRowStruct the name of the variable that contains the
     *    rowStruct.
     */
    public void generateConvertRecord(String codeVarIndexedRecord, String codeVarRowStruct) {
        generateConvertRecord(codeVarIndexedRecord, codeVarRowStruct, columns);
    }

    /**
     * Generate code that copies data from the IndexedRecord to the rowStruct.
     *
     * @param codeVarIndexedRecord the name of the variable that contains the
     *    IndexedRecord.
     * @param codeVarRowStruct the name of the variable that contains the
     *    rowStruct.
     * @param columnsToGenerate the list of columns in the rowStruct to generate
     *    code for.
     */
    public void generateConvertRecord(String codeVarIndexedRecord, String codeVarRowStruct, List<IMetadataColumn> columnsToGenerate) {
        
    stringBuffer.append(TEXT_9);
    stringBuffer.append(codeVarIndexedRecordAdapter);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(codeVarIndexedRecordAdapter);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(codeVarIndexedRecord);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(codeVarSchemaEnforcer);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(codeVarIndexedRecordAdapter);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(codeVarIndexedRecord);
    stringBuffer.append(TEXT_17);
    

        if (dynamicColName != null) {
            
    stringBuffer.append(TEXT_18);
    stringBuffer.append(codeVarIsDynamicInitialized);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(codeVarSchemaEnforcer);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
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
    stringBuffer.append(TEXT_59);
    stringBuffer.append(codeVarDynamic);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(codeVarDynamic);
    stringBuffer.append(TEXT_64);
    
        }

        for (int i = 0; i < columnsToGenerate.size(); i++) {
            IMetadataColumn column = columnsToGenerate.get(i);
            String columnName = column.getLabel();
            String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
            if (columnName.equals(dynamicColName)) {
            
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(codeVarSchemaEnforcer);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(codeVarDynamic);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(codeVarDynamic);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(codeVarRowStruct);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(dynamicColName);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(codeVarDynamic);
    stringBuffer.append(TEXT_79);
    
            } else {
            
    stringBuffer.append(TEXT_80);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(codeVarSchemaEnforcer);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_84);
    
                if (JavaTypesManager.NULL.equals(JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate))) {
                    // there is no default value, so just assign data value to RowStruct
                
    
                    if ("id_Document".equals(column.getTalendType())) {
                    
    stringBuffer.append(TEXT_85);
    stringBuffer.append(codeVarRowStruct);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    
                    } else {
                    
    stringBuffer.append(TEXT_90);
    stringBuffer.append(codeVarRowStruct);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    
                    }
                } else {
                    // there is default value, so check on null and set default value instead of null
                
    stringBuffer.append(TEXT_96);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(codeVarRowStruct);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate));
    stringBuffer.append(TEXT_102);
    
                        if ("id_Document".equals(column.getTalendType())) {
                        
    stringBuffer.append(TEXT_103);
    stringBuffer.append(codeVarRowStruct);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    
                        } else {
                        
    stringBuffer.append(TEXT_108);
    stringBuffer.append(codeVarRowStruct);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    
                        }
                        
    stringBuffer.append(TEXT_114);
    
                }
            }
        }
    }
}

    
 
 /**
  * Utility for generating code that set values for the properties of the component.
  */
 class ProcessPropertiesGenerator {
 
     /** A unique tag for generating code variables, usually based on the cid
      *  of the node. */
     private final String cid;
 
     private final Component component;
     
     public ProcessPropertiesGenerator(String cid, Component component) {
         this.cid = cid;
         this.component = component;    
     }
 
     /**
      * Generate code that set value for component properties
      */
     public void setPropertyValues(Property property, Component.CodegenPropInfo propInfo, String connName, boolean setDynamicTags, boolean firstCall) {
     
 		            Object value = property.getStoredValue();
 		            if (value != null) {
 		            	if (setDynamicTags && (value instanceof String) && isDynamicValue(String.valueOf(value), connName)) {
 		            		property.setTaggedValue(IGenericConstants.DYNAMIC_PROPERTY_VALUE, "true");
 		            	}
 		                if (value instanceof List) { // if
 		                    // added for the support of tables
 		                    String tmpVarName = cid+propInfo.fieldName.replace('.','_')+"_"+property.getName();
 		                    if(firstCall) {
 		                    
    stringBuffer.append(TEXT_115);
    stringBuffer.append(tmpVarName );
    stringBuffer.append(TEXT_116);
    
 		                    } else {
 		                    
    stringBuffer.append(TEXT_117);
    stringBuffer.append(tmpVarName );
    stringBuffer.append(TEXT_118);
    
 		                    }
 		                    for (Object subPropertyValue : (java.util.List<Object>)property.getValue()) {
 		                        if ((property.getPossibleValues() != null && property.getPossibleValues().size() > 0)||
 		                        	Boolean.valueOf(String.valueOf(property.getTaggedValue(IGenericConstants.ADD_QUOTES)))) {
 		                            
    stringBuffer.append(TEXT_119);
    stringBuffer.append(tmpVarName );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(subPropertyValue );
    stringBuffer.append(TEXT_121);
    
 		                        } else if(!"".equals(subPropertyValue)) {
 		                        	if(setDynamicTags && isDynamicValue(String.valueOf(subPropertyValue), connName)) {
 		                        		property.setTaggedValue(IGenericConstants.DYNAMIC_PROPERTY_VALUE, "true");
 		                        	}
 		                                
    stringBuffer.append(TEXT_122);
    stringBuffer.append(tmpVarName );
    stringBuffer.append(TEXT_123);
    stringBuffer.append(subPropertyValue );
    stringBuffer.append(TEXT_124);
    
 		                        } else {
 		                            
    stringBuffer.append(TEXT_125);
    stringBuffer.append(tmpVarName );
    stringBuffer.append(TEXT_126);
    
 		                        }
 		                    }
 		                    
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid );
    stringBuffer.append(propInfo.fieldName);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(property.getName());
    stringBuffer.append(TEXT_129);
    stringBuffer.append(tmpVarName );
    stringBuffer.append(TEXT_130);
    
 		                } else if (value instanceof String && property.isFlag(Property.Flags.ENCRYPT) && ElementParameterParser.canEncryptValue((String) value)) {
 		                    if (!"".equals(property.getStringValue())) {
 		                        
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid );
    stringBuffer.append(propInfo.fieldName);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(property.getName());
    stringBuffer.append(TEXT_133);
    stringBuffer.append(component.getCodegenValue(property, (String) value));
    stringBuffer.append(TEXT_134);
    
 		                    }
 		                } else if (value != null && "java.util.Date".equals(property.getType())){
 		                    
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid );
    stringBuffer.append(propInfo.fieldName);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(property.getName());
    stringBuffer.append(TEXT_137);
    stringBuffer.append(component.getCodegenValue(property, value.toString()));
    stringBuffer.append(TEXT_138);
    
 		                } else if (property instanceof org.talend.daikon.properties.property.EnumProperty) {
 		                    
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid );
    stringBuffer.append(propInfo.fieldName);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(property.getName());
    stringBuffer.append(TEXT_141);
    stringBuffer.append(property.getType().replaceAll("<.*>", ""));
    stringBuffer.append(TEXT_142);
    stringBuffer.append(property.getValue());
    stringBuffer.append(TEXT_143);
    
 		                } else if (property instanceof org.talend.daikon.properties.property.SchemaProperty) {
 		                    
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid );
    stringBuffer.append(propInfo.fieldName);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(property.getName());
    stringBuffer.append(TEXT_146);
    stringBuffer.append(component.getCodegenValue(property, property.getStringValue()));
    stringBuffer.append(TEXT_147);
    
 		                } else if (!(value instanceof String) || !((String)value).equals("")) {
 		                    
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid );
    stringBuffer.append(propInfo.fieldName);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(property.getName());
    stringBuffer.append(TEXT_150);
    stringBuffer.append(component.getCodegenValue(property, value.toString()));
    stringBuffer.append(TEXT_151);
    
 		                }
 		            }
 		            if("java.lang.Integer".equals(property.getType()) && (value == null || ((value instanceof String) && ((String)value).isEmpty()))) {//need to overwrite the default value when the passed value is null or empty string from the model
 		        	
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid );
    stringBuffer.append(propInfo.fieldName);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(property.getName());
    stringBuffer.append(TEXT_154);
    
 		            }
     }
     
     private boolean isDynamicValue(String value, String connName) {
		if(value == null) {
			return false;
		}
		boolean dynamicByGlobals = ContextParameterUtils.isContainContextParam(value) || ContextParameterUtils.containCodeVariable(value, "globalMap.");
		if(connName == null || dynamicByGlobals) {
			return dynamicByGlobals;
		}
		return ContextParameterUtils.containCodeVariable(value, connName + ".");
	}
 
 }
 
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
Component component = (Component)node.getComponent();
ComponentDefinition def = component.getComponentDefinition();

boolean hasInput = !NodeUtil.getIncomingConnections(node, IConnectionCategory.DATA).isEmpty();

if(hasInput){
    // These will be initialized if there are outgoing connections and will be
    // null if there isn't a corresponding outgoing connection.
    IndexedRecordToRowStructGenerator mainIrToRow = null;
    IndexedRecordToRowStructGenerator rejectIrToRow = null;

    List<? extends IConnection> outgoingConns = node.getOutgoingSortedConnections();
    if (outgoingConns!=null){
        for (int i = 0; i < outgoingConns.size(); i++) {
            IConnection outgoingConn = outgoingConns.get(i);
            if (outgoingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
                
    stringBuffer.append(TEXT_155);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_156);
    
            }
            if ("MAIN".equals(outgoingConn.getConnectorName())) {
                mainIrToRow = new IndexedRecordToRowStructGenerator(cid + "OutMain",
                        outgoingConn);
            }
            if ("REJECT".equals(outgoingConn.getConnectorName())) {
                rejectIrToRow = new IndexedRecordToRowStructGenerator(cid + "OutReject",
                        outgoingConn);
            }
        }
    }

    // Generate the code to handle the incoming records.
    IConnection inputConn = null;
    List< ? extends IConnection> inputConns = node.getIncomingConnections();
    if(inputConns!=null) {
	   	for (IConnection conn : inputConns) {
	   		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
	   			inputConn = conn;
	    	}
	   	}
   	}

   	boolean hasValidInput = inputConn!=null;

   	IMetadataTable metadata;
    List<IMetadataTable> metadatas = node.getMetadataList();
    boolean haveValidNodeMetadata = ((metadatas != null) && (metadatas.size() > 0) && (metadata = metadatas.get(0)) != null);

    if (hasValidInput && haveValidNodeMetadata) {
        List<IMetadataColumn> input_columnList = inputConn.getMetadataTable().getListColumns();

        if (input_columnList!=null && !input_columnList.isEmpty()) {
            // If there are dynamic columns in the schema, they need to be
            // initialized into the runtime schema of the actual IndexedRecord
            // provided to the component.

            int dynamicPos = -1;
	        for (int i = 0; i < input_columnList.size(); i++) {
	            if (input_columnList.get(i).getTalendType().equals("id_Dynamic")) {
	                dynamicPos = i;
	                break;
	            }
	        }

            if (dynamicPos != -1)  {
                
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(inputConn.getName());
    stringBuffer.append(TEXT_160);
    stringBuffer.append(input_columnList.get(dynamicPos).getLabel());
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    
            }

            
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    
            for (int i = 0; i < input_columnList.size(); i++) { // column
                IMetadataColumn column = input_columnList.get(i);
                if (dynamicPos != i) {
                    
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_174);
    stringBuffer.append(inputConn.getName());
    stringBuffer.append(TEXT_175);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_176);
    
                } else {
                    
    stringBuffer.append(TEXT_177);
    stringBuffer.append(inputConn.getName());
    stringBuffer.append(TEXT_178);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(inputConn.getName());
    stringBuffer.append(TEXT_181);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_182);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(inputConn.getName());
    stringBuffer.append(TEXT_184);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_185);
    
                }
            } // column

            // If necesary, generate the code to handle outgoing connections.
            // TODO: For now, this can only handle one outgoing record for
            // each incoming record.  To handle multiple outgoing records, code
            // generation needs to occur in component_begin in order to open
            // a for() loop.

            // There will be a ClassCastException if the output component does
            // not implement WriterWithFeedback, but permits outgoing
            // connections.
            
            ComponentProperties componentProps = node.getComponentProperties();
			ProcessPropertiesGenerator generator = new ProcessPropertiesGenerator(cid, component);
            List<Component.CodegenPropInfo> propsToProcess = component.getCodegenPropInfos(componentProps);
            for (Component.CodegenPropInfo propInfo : propsToProcess) { // propInfo
    			List<NamedThing> properties = propInfo.props.getProperties();
    			for (NamedThing prop : properties) { // property
        			if (prop instanceof Property) { // if, only deal with valued Properties
            			Property property = (Property)prop;
            			if (property.getFlags() != null && (property.getFlags().contains(Property.Flags.DESIGN_TIME_ONLY) || property.getFlags().contains(Property.Flags.HIDDEN)))
 		                	continue;
            			if(property.getTaggedValue(IGenericConstants.DYNAMIC_PROPERTY_VALUE)!=null && Boolean.valueOf(String.valueOf(property.getTaggedValue(IGenericConstants.DYNAMIC_PROPERTY_VALUE)))) {
            				generator.setPropertyValues(property, propInfo, null, false, false);
            			}
        			}
    			} // property
			} // propInfo
            
            
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_191);
    
            if (mainIrToRow != null) {
                
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_207);
    
                    if (rejectIrToRow == null) {
                    
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    
                    }
                    
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(mainIrToRow.getConnection().getName());
    stringBuffer.append(TEXT_214);
    stringBuffer.append(mainIrToRow.getConnection().getName() );
    stringBuffer.append(TEXT_215);
    
                        mainIrToRow.generateConvertRecord("outgoingMain_" + cid, mainIrToRow.getConnection().getName());
                        
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(mainIrToRow.getConnection().getName());
    stringBuffer.append(TEXT_218);
    stringBuffer.append(mainIrToRow.getConnection().getName() );
    stringBuffer.append(TEXT_219);
    
                        mainIrToRow.generateConvertRecord("data_" + cid, mainIrToRow.getConnection().getName());
                        
    stringBuffer.append(TEXT_220);
    
            }
            if (rejectIrToRow != null) {
            
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_229);
    stringBuffer.append(TEXT_230);
    stringBuffer.append(rejectIrToRow.getConnection().getName());
    stringBuffer.append(TEXT_231);
    stringBuffer.append(rejectIrToRow.getConnection().getName() );
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_234);
    
                        rejectIrToRow.generateConvertRecord("outgoingReject_" + cid, rejectIrToRow.getConnection().getName());
                        
    stringBuffer.append(TEXT_235);
    
            }
        }
    }
} // canStart

    stringBuffer.append(TEXT_236);
    return stringBuffer.toString();
  }
}
