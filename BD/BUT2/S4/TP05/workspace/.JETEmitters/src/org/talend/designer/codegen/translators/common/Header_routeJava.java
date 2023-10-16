package org.talend.designer.codegen.translators.common;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.talend.core.GlobalServiceRegister;
import org.talend.core.model.process.IProcess;
import org.talend.core.model.process.IProcess2;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.IContextParameter;
import org.talend.core.model.process.IElementParameter;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.utils.NodeUtil;
import org.talend.core.model.utils.JavaResourcesHelper;
import org.talend.core.ui.branding.IBrandingService;
import org.talend.core.ui.branding.AbstractBrandingService;
import org.talend.designer.codegen.i18n.Messages;
import org.talend.designer.codegen.ITalendSynchronizer;
import org.talend.designer.codegen.config.CamelEndpointBuilder;
import org.talend.designer.codegen.config.CamelEndpointBuilder.BuildingValueParamAppender;
import org.talend.designer.codegen.config.CamelEndpointBuilder.ConditionParamAppender;
import org.talend.designer.codegen.config.CamelEndpointBuilder.NodeParamNotDefaultAppender;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.designer.codegen.config.NodeParamsHelper;
import org.talend.designer.runprocess.CodeGeneratorRoutine;
import org.talend.core.model.process.EParameterFieldType;
import org.talend.core.model.process.ProcessUtils;

public class Header_routeJava {

  protected static String nl;
  public static synchronized Header_routeJava create(String lineSeparator)
  {
    nl = lineSeparator;
    Header_routeJava result = new Header_routeJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "package ";
  protected final String TEXT_3 = ";" + NL;
  protected final String TEXT_4 = NL + "        ";
  protected final String TEXT_5 = " ;";
  protected final String TEXT_6 = NL + NL + "/**" + NL + " * Job: ";
  protected final String TEXT_7 = " Purpose: ";
  protected final String TEXT_8 = "<br>" + NL + " * Description: ";
  protected final String TEXT_9 = " <br>" + NL + " * @author ";
  protected final String TEXT_10 = NL + " * @version ";
  protected final String TEXT_11 = NL + " * @status ";
  protected final String TEXT_12 = NL + " */" + NL + " ";
  protected final String TEXT_13 = NL + " " + NL + NL;
  protected final String TEXT_14 = NL + NL + "/**" + NL + " * Applies configuration properties to a HTTPConduit" + NL + " */" + NL + "class HttpConduitConfigApplier {" + NL + "    private static final String SECURE_HTTP_PREFIX = \"https\";" + NL + "" + NL + "    HttpConduitConfigApplier() {" + NL + "    }" + NL + "" + NL + "    void apply(java.util.Dictionary<String, String> d, org.apache.cxf.transport.http.HTTPConduit c, String address) {" + NL + "        applyClientPolicies(d, c);" + NL + "        applyAuthorization(d, c);" + NL + "        applyProxyAuthorization(d, c);" + NL + "        if (address != null && address.startsWith(SECURE_HTTP_PREFIX)) {" + NL + "            applyTlsClientParameters(d, c);" + NL + "        }" + NL + "    }" + NL + "" + NL + "    private void applyTlsClientParameters(java.util.Dictionary<String, String> d," + NL + "            org.apache.cxf.transport.http.HTTPConduit c) {" + NL + "        java.util.Enumeration<String> keys = d.keys();" + NL + "        org.apache.cxf.configuration.jsse.TLSClientParameters p = c.getTlsClientParameters();" + NL + "        org.apache.cxf.configuration.security.SecureRandomParameters srp = null;" + NL + "        org.apache.cxf.configuration.security.KeyManagersType kmt = null;" + NL + "        org.apache.cxf.configuration.security.TrustManagersType tmt = null;" + NL + "        while (keys.hasMoreElements()) {" + NL + "            String k = keys.nextElement();" + NL + "            if (k.startsWith(\"tlsClientParameters.\")) {" + NL + "                if (p == null) {" + NL + "                    p = new org.apache.cxf.configuration.jsse.TLSClientParameters();" + NL + "                    c.setTlsClientParameters(p);" + NL + "                }" + NL + "                String v = d.get(k);" + NL + "                k = k.substring(\"tlsClientParameters.\".length());" + NL + "" + NL + "                if (\"secureSocketProtocol\".equals(k)) {" + NL + "                    p.setSecureSocketProtocol(v);" + NL + "                } else if (\"sslCacheTimeout\".equals(k)) {" + NL + "                    p.setSslCacheTimeout(Integer.parseInt(v));" + NL + "                } else if (\"jsseProvider\".equals(k)) {" + NL + "                    p.setJsseProvider(v);" + NL + "                } else if (\"disableCNCheck\".equals(k)) {" + NL + "                    p.setDisableCNCheck(Boolean.parseBoolean(v));" + NL + "                } else if (\"useHttpsURLConnectionDefaultHostnameVerifier\".equals(k)) {" + NL + "                    p.setUseHttpsURLConnectionDefaultHostnameVerifier(Boolean.parseBoolean(v));" + NL + "                } else if (\"useHttpsURLConnectionDefaultSslSocketFactory\".equals(k)) {" + NL + "                    p.setUseHttpsURLConnectionDefaultSslSocketFactory(Boolean.parseBoolean(v));" + NL + "                } else if (k.startsWith(\"certConstraints.\")) {" + NL + "                    k = k.substring(\"certConstraints.\".length());" + NL + "                    org.apache.cxf.configuration.security.CertificateConstraintsType cct = p.getCertConstraints();" + NL + "                    if (cct == null) {" + NL + "                        cct = new org.apache.cxf.configuration.security.CertificateConstraintsType();" + NL + "                        p.setCertConstraints(cct);" + NL + "                    }" + NL + "                    org.apache.cxf.configuration.security.DNConstraintsType dnct = null;" + NL + "                    if (k.startsWith(\"SubjectDNConstraints.\")) {" + NL + "                        dnct = cct.getSubjectDNConstraints();" + NL + "                        if (dnct == null) {" + NL + "                            dnct = new org.apache.cxf.configuration.security.DNConstraintsType();" + NL + "                            cct.setSubjectDNConstraints(dnct);" + NL + "                        }" + NL + "                        k = k.substring(\"SubjectDNConstraints.\".length());" + NL + "                    } else if (k.startsWith(\"IssuerDNConstraints.\")) {" + NL + "                        dnct = cct.getIssuerDNConstraints();" + NL + "                        if (dnct == null) {" + NL + "                            dnct = new org.apache.cxf.configuration.security.DNConstraintsType();" + NL + "                            cct.setIssuerDNConstraints(dnct);" + NL + "                        }" + NL + "                        k = k.substring(\"IssuerDNConstraints.\".length());" + NL + "                    }" + NL + "                    if (dnct != null) {" + NL + "                        if (\"combinator\".equals(k)) {" + NL + "                            dnct.setCombinator(org.apache.cxf.configuration.security.CombinatorType.fromValue(v));" + NL + "                        } else if (\"RegularExpression\".equals(k)) {" + NL + "                            dnct.getRegularExpression().add(k);" + NL + "                        }" + NL + "                    }" + NL + "                } else if (k.startsWith(\"secureRandomParameters.\")) {" + NL + "                    k = k.substring(\"secureRandomParameters.\".length());" + NL + "                    if (srp == null) {" + NL + "                        srp = new org.apache.cxf.configuration.security.SecureRandomParameters();" + NL + "                    }" + NL + "                    if (\"algorithm\".equals(k)) {" + NL + "                        srp.setAlgorithm(v);" + NL + "                    } else if (\"provider\".equals(k)) {" + NL + "                        srp.setProvider(v);" + NL + "                    }" + NL + "                } else if (k.startsWith(\"cipherSuitesFilter.\")) {" + NL + "                    k = k.substring(\"cipherSuitesFilter.\".length());" + NL + "                    java.util.StringTokenizer st = new java.util.StringTokenizer(v, \",\");" + NL + "                    org.apache.cxf.configuration.security.FiltersType ft = p.getCipherSuitesFilter();" + NL + "                    if (ft == null) {" + NL + "                        ft = new org.apache.cxf.configuration.security.FiltersType();" + NL + "                        p.setCipherSuitesFilter(ft);" + NL + "                    }" + NL + "                    java.util.List<String> lst = \"include\".equals(k) ? ft.getInclude() : ft.getExclude();" + NL + "                    while (st.hasMoreTokens()) {" + NL + "                        lst.add(st.nextToken());" + NL + "                    }" + NL + "                } else if (k.startsWith(\"cipherSuites\")) {" + NL + "                    java.util.StringTokenizer st = new java.util.StringTokenizer(v, \",\");" + NL + "                    while (st.hasMoreTokens()) {" + NL + "                        p.getCipherSuites().add(st.nextToken());" + NL + "                    }" + NL + "                } else if (k.startsWith(\"trustManagers.\")) {" + NL + "                    tmt = getTrustManagers(tmt, k.substring(\"trustManagers.\".length()), v);" + NL + "                } else if (k.startsWith(\"keyManagers.\")) {" + NL + "                    kmt = getKeyManagers(kmt, k.substring(\"keyManagers.\".length()), v);" + NL + "                }" + NL + "            }" + NL + "        }" + NL + "" + NL + "        try {" + NL + "            if (srp != null) {" + NL + "                p.setSecureRandom(org.apache.cxf.configuration.jsse.TLSParameterJaxBUtils.getSecureRandom(srp));" + NL + "            }" + NL + "            if (kmt != null) {" + NL + "                p.setKeyManagers(org.apache.cxf.configuration.jsse.TLSParameterJaxBUtils.getKeyManagers(kmt));" + NL + "            }" + NL + "            if (tmt != null) {" + NL + "                p.setTrustManagers(org.apache.cxf.configuration.jsse.TLSParameterJaxBUtils.getTrustManagers(tmt));" + NL + "            }" + NL + "        } catch (RuntimeException e) {" + NL + "            throw e;" + NL + "        } catch (Exception e) {" + NL + "            throw new RuntimeException(e);" + NL + "        }" + NL + "    }" + NL + "" + NL + "    private org.apache.cxf.configuration.security.KeyManagersType getKeyManagers(" + NL + "            org.apache.cxf.configuration.security.KeyManagersType keyManagers, String k, String v) {" + NL + "        if (keyManagers == null) {" + NL + "            keyManagers = new org.apache.cxf.configuration.security.KeyManagersType();" + NL + "        }" + NL + "        if (\"factoryAlgorithm\".equals(k)) {" + NL + "            keyManagers.setFactoryAlgorithm(v);" + NL + "        } else if (\"provider\".equals(k)) {" + NL + "            keyManagers.setProvider(v);" + NL + "        } else if (\"keyPassword\".equals(k)) {" + NL + "            keyManagers.setKeyPassword(v);" + NL + "        } else if (k.startsWith(\"keyStore.\")) {" + NL + "            keyManagers.setKeyStore(getKeyStore(keyManagers.getKeyStore(), k.substring(\"keyStore.\".length()), v));" + NL + "        }" + NL + "        return keyManagers;" + NL + "    }" + NL + "" + NL + "    private org.apache.cxf.configuration.security.KeyStoreType getKeyStore(org.apache.cxf.configuration.security.KeyStoreType ks, String k, String v) {" + NL + "        if (ks == null) {" + NL + "            ks = new org.apache.cxf.configuration.security.KeyStoreType();" + NL + "        }" + NL + "        if (\"type\".equals(k)) {" + NL + "            ks.setType(v);" + NL + "        } else if (\"password\".equals(k)) {" + NL + "            ks.setPassword(v);" + NL + "        } else if (\"provider\".equals(k)) {" + NL + "            ks.setProvider(v);" + NL + "        } else if (\"url\".equals(k)) {" + NL + "            ks.setUrl(v);" + NL + "        } else if (\"file\".equals(k)) {" + NL + "            ks.setFile(v);" + NL + "        } else if (\"resource\".equals(k)) {" + NL + "            ks.setResource(v);" + NL + "        }" + NL + "        return ks;" + NL + "    }" + NL + "" + NL + "    private org.apache.cxf.configuration.security.TrustManagersType getTrustManagers(" + NL + "            org.apache.cxf.configuration.security.TrustManagersType tmt, String k, String v) {" + NL + "        if (tmt == null) {" + NL + "            tmt = new org.apache.cxf.configuration.security.TrustManagersType();" + NL + "        }" + NL + "        if (\"provider\".equals(k)) {" + NL + "            tmt.setProvider(v);" + NL + "        } else if (\"factoryAlgorithm\".equals(k)) {" + NL + "            tmt.setFactoryAlgorithm(v);" + NL + "        } else if (k.startsWith(\"keyStore.\")) {" + NL + "            tmt.setKeyStore(getKeyStore(tmt.getKeyStore(), k.substring(\"keyStore.\".length()), v));" + NL + "        } else if (k.startsWith(\"certStore\")) {" + NL + "            tmt.setCertStore(getCertStore(tmt.getCertStore(), k.substring(\"certStore.\".length()), v));" + NL + "        }" + NL + "        return tmt;" + NL + "    }" + NL + "" + NL + "    private org.apache.cxf.configuration.security.CertStoreType getCertStore(" + NL + "            org.apache.cxf.configuration.security.CertStoreType cs, String k, String v) {" + NL + "        if (cs == null) {" + NL + "            cs = new org.apache.cxf.configuration.security.CertStoreType();" + NL + "        }" + NL + "        if (\"file\".equals(k)) {" + NL + "            cs.setFile(v);" + NL + "        } else if (\"url\".equals(k)) {" + NL + "            cs.setUrl(v);" + NL + "        } else if (\"resource\".equals(k)) {" + NL + "            cs.setResource(v);" + NL + "        }" + NL + "        return cs;" + NL + "    }" + NL + "" + NL + "    private void applyProxyAuthorization(java.util.Dictionary<String, String> d," + NL + "            org.apache.cxf.transport.http.HTTPConduit c) {" + NL + "        java.util.Enumeration<String> keys = d.keys();" + NL + "        org.apache.cxf.configuration.security.ProxyAuthorizationPolicy p = c.getProxyAuthorization();" + NL + "        while (keys.hasMoreElements()) {" + NL + "            String k = keys.nextElement();" + NL + "            if (k.startsWith(\"proxyAuthorization.\")) {" + NL + "                if (p == null) {" + NL + "                    p = new org.apache.cxf.configuration.security.ProxyAuthorizationPolicy();" + NL + "                    c.setProxyAuthorization(p);" + NL + "                }" + NL + "                String v = d.get(k);" + NL + "                k = k.substring(\"proxyAuthorization.\".length());" + NL + "" + NL + "                if (\"UserName\".equals(k)) {" + NL + "                    p.setUserName(v);" + NL + "                } else if (\"Password\".equals(k)) {" + NL + "                    p.setPassword(v);" + NL + "                } else if (\"Authorization\".equals(k)) {" + NL + "                    p.setAuthorization(v);" + NL + "                } else if (\"AuthorizationType\".equals(k)) {" + NL + "                    p.setAuthorizationType(v);" + NL + "                }" + NL + "            }" + NL + "        }" + NL + "    }" + NL + "" + NL + "    private void applyAuthorization(java.util.Dictionary<String, String> d," + NL + "            org.apache.cxf.transport.http.HTTPConduit c) {" + NL + "        java.util.Enumeration<String> keys = d.keys();" + NL + "        org.apache.cxf.configuration.security.AuthorizationPolicy p = c.getAuthorization();" + NL + "        while (keys.hasMoreElements()) {" + NL + "            String k = keys.nextElement();" + NL + "            if (k.startsWith(\"authorization.\")) {" + NL + "                if (p == null) {" + NL + "                    p = new org.apache.cxf.configuration.security.AuthorizationPolicy();" + NL + "                    c.setAuthorization(p);" + NL + "                }" + NL + "                String v = d.get(k);" + NL + "                k = k.substring(\"authorization.\".length());" + NL + "" + NL + "                if (\"UserName\".equals(k)) {" + NL + "                    p.setUserName(v);" + NL + "                } else if (\"Password\".equals(k)) {" + NL + "                    p.setPassword(v);" + NL + "                } else if (\"Authorization\".equals(k)) {" + NL + "                    p.setAuthorization(v);" + NL + "                } else if (\"AuthorizationType\".equals(k)) {" + NL + "                    p.setAuthorizationType(v);" + NL + "                }" + NL + "            }" + NL + "        }" + NL + "    }" + NL + "" + NL + "    private void applyClientPolicies(java.util.Dictionary<String, String> d," + NL + "            org.apache.cxf.transport.http.HTTPConduit c) {" + NL + "        java.util.Enumeration<String> keys = d.keys();" + NL + "        org.apache.cxf.transports.http.configuration.HTTPClientPolicy p = c.getClient();" + NL + "        while (keys.hasMoreElements()) {" + NL + "            String k = keys.nextElement();" + NL + "            if (k.startsWith(\"client.\")) {" + NL + "                if (p == null) {" + NL + "                    p = new org.apache.cxf.transports.http.configuration.HTTPClientPolicy();" + NL + "                    c.setClient(p);" + NL + "                }" + NL + "                String v = d.get(k);" + NL + "                k = k.substring(\"client.\".length());" + NL + "                if (\"ConnectionTimeout\".equals(k)) {" + NL + "                    p.setConnectionTimeout(Long.parseLong(v.trim()));" + NL + "                } else if (\"ReceiveTimeout\".equals(k)) {" + NL + "                    p.setReceiveTimeout(Long.parseLong(v.trim()));" + NL + "                } else if (\"AsyncExecuteTimeout\".equals(k)) {" + NL + "                    p.setAsyncExecuteTimeout(Long.parseLong(v.trim()));" + NL + "                } else if (\"AsyncExecuteTimeoutRejection\".equals(k)) {" + NL + "                    p.setAsyncExecuteTimeoutRejection(Boolean.parseBoolean(v.trim()));" + NL + "                } else if (\"AutoRedirect\".equals(k)) {" + NL + "                    p.setAutoRedirect(Boolean.parseBoolean(v.trim()));" + NL + "                } else if (\"MaxRetransmits\".equals(k)) {" + NL + "                    p.setMaxRetransmits(Integer.parseInt(v.trim()));" + NL + "                } else if (\"AllowChunking\".equals(k)) {" + NL + "                    p.setAllowChunking(Boolean.parseBoolean(v.trim()));" + NL + "                } else if (\"ChunkingThreshold\".equals(k)) {" + NL + "                    p.setChunkingThreshold(Integer.parseInt(v.trim()));" + NL + "                } else if (\"ChunkLength\".equals(k)) {" + NL + "                    p.setChunkLength(Integer.parseInt(v.trim()));" + NL + "                } else if (\"Connection\".equals(k)) {" + NL + "                    p.setConnection(org.apache.cxf.transports.http.configuration.ConnectionType.valueOf(v));" + NL + "                } else if (\"DecoupledEndpoint\".equals(k)) {" + NL + "                    p.setDecoupledEndpoint(v);" + NL + "                } else if (\"ProxyServer\".equals(k)) {" + NL + "                    p.setProxyServer(v);" + NL + "                } else if (\"ProxyServerPort\".equals(k)) {" + NL + "                    p.setProxyServerPort(Integer.parseInt(v.trim()));" + NL + "                } else if (\"ProxyServerType\".equals(k)) {" + NL + "                    p.setProxyServerType(org.apache.cxf.transports.http.configuration.ProxyServerType.fromValue(v));" + NL + "                } else if (\"NonProxyHosts\".equals(k)) {" + NL + "                    p.setNonProxyHosts(v);" + NL + "                }" + NL + "            }" + NL + "        }" + NL + "    }" + NL + "}" + NL;
  protected final String TEXT_15 = NL + " " + NL + "@org.springframework.boot.autoconfigure.SpringBootApplication" + NL + "@org.springframework.boot.context.properties.EnableConfigurationProperties(";
  protected final String TEXT_16 = ".ContextProperties.class)" + NL + "@org.springframework.context.annotation.ImportResource(\"classpath:META-INF/spring/";
  protected final String TEXT_17 = ".xml\")" + NL + "public class ";
  protected final String TEXT_18 = " extends org.apache.camel.builder.RouteBuilder implements TalendESBRoute {" + NL + "" + NL + "    @org.springframework.beans.factory.annotation.Autowired" + NL + "    org.springframework.core.env.Environment env;";
  protected final String TEXT_19 = NL + "    public class ";
  protected final String TEXT_20 = " extends ";
  protected final String TEXT_21 = " implements TalendESBRoute {";
  protected final String TEXT_22 = NL + NL + "    private boolean inOSGi = routines.system.BundleUtils.inOSGi();" + NL + "" + NL + "\tprivate static Object arguments;" + NL + "\t" + NL + "\tpublic void setArguments(Object arguments) {" + NL + "\t\tthis.inOSGi = true;" + NL + "\t\t";
  protected final String TEXT_23 = ".arguments = arguments;" + NL + "\t}" + NL + "\t" + NL + "\tpublic <T> Map<String, T> getArguments(Object props,Class c){" + NL + "\t\tif (props != null) {" + NL + "\t\t\ttry {" + NL + "\t\t\t\tjava.lang.reflect.Field propertiesField = props.getClass().getDeclaredField(\"properties\");" + NL + "\t\t\t\tpropertiesField.setAccessible(true);" + NL + "\t\t\t\tjava.util.Dictionary p = (java.util.Dictionary) propertiesField.get(props);" + NL + "\t\t\t\tjava.util.Map<String,T> result = new java.util.HashMap<>();" + NL + "\t\t\t\t" + NL + "\t\t\t\tif(p !=null ){" + NL + "\t\t\t\t\tfor (java.util.Enumeration<String> keys = p.keys(); keys.hasMoreElements();) {" + NL + "\t\t\t\t\t\tString key = keys.nextElement();" + NL + "\t\t\t\t\t\tif(c.equals(String.class)){" + NL + "\t\t\t\t\t\t\tresult.put(key, (T) String.valueOf(p.get(key)));" + NL + "\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\tresult.put(key, (T) p.get(key));" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t" + NL + "\t\t\t\t    }" + NL + "\t\t\t\t}" + NL + "\t\t\t    " + NL + "\t\t\t    return result;" + NL + "" + NL + "\t\t\t} catch (Exception e) {" + NL + "\t\t\t\te.printStackTrace();" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn null;" + NL + "\t}";
  protected final String TEXT_24 = NL + "    private final CorrelationIDCallbackHandler correlationIDCallbackHandler_";
  protected final String TEXT_25 = " = new CorrelationIDCallbackHandler();";
  protected final String TEXT_26 = NL + "    @javax.ws.rs.Path(\"/\")" + NL + "    @io.swagger.annotations.Api(value = \"/\", description = \"";
  protected final String TEXT_27 = " ";
  protected final String TEXT_28 = " JAX-RS service\")";
  protected final String TEXT_29 = NL + "    public interface Service_";
  protected final String TEXT_30 = " {";
  protected final String TEXT_31 = NL + "        @javax.ws.rs.Path(";
  protected final String TEXT_32 = ")" + NL + "        @javax.ws.rs.";
  protected final String TEXT_33 = "()";
  protected final String TEXT_34 = NL + "        @javax.ws.rs.Consumes(";
  protected final String TEXT_35 = ")";
  protected final String TEXT_36 = NL + "        @javax.ws.rs.Produces(";
  protected final String TEXT_37 = ")";
  protected final String TEXT_38 = NL + "        @io.swagger.annotations.ApiOperation(value = \"";
  protected final String TEXT_39 = "\", notes = \"";
  protected final String TEXT_40 = "\")";
  protected final String TEXT_41 = NL + "        Object ";
  protected final String TEXT_42 = "(";
  protected final String TEXT_43 = ", ";
  protected final String TEXT_44 = NL + "                @javax.ws.rs.PathParam(\"";
  protected final String TEXT_45 = "\") String ";
  protected final String TEXT_46 = ", ";
  protected final String TEXT_47 = NL + "                ";
  protected final String TEXT_48 = " payload";
  protected final String TEXT_49 = NL + "        );";
  protected final String TEXT_50 = NL + "    }" + NL;
  protected final String TEXT_51 = "  " + NL + "    private final CorrelationIDCallbackHandler correlationIDCallbackHandler_";
  protected final String TEXT_52 = " = new CorrelationIDCallbackHandler();";
  protected final String TEXT_53 = NL + "  " + NL + "    //ESB Service Activity Monitor Feature" + NL + "    " + NL + "    private org.talend.esb.sam.agent.feature.EventFeature eventFeature;" + NL + "    " + NL + "    public void setEventFeature(org.talend.esb.sam.agent.feature.EventFeature eventFeature){" + NL + "    \tthis.eventFeature = eventFeature;" + NL + "    }" + NL + "    " + NL + "    public org.talend.esb.sam.agent.feature.EventFeature getEventFeature(org.apache.cxf.Bus bus) {" + NL + "    \torg.talend.esb.sam.agent.feature.EventFeature eventFeature_;" + NL + "    \tif(inOSGi){" + NL + "\t\t\teventFeature_ = eventFeature;" + NL + "\t\t}else{" + NL + "\t\t\teventFeature_ = new org.springframework.context.support.ClassPathXmlApplicationContext(\"META-INF/tesb/agent-context.xml\").getBean(org.talend.esb.sam.agent.feature.EventFeature.class);" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\treturn eventFeature_;" + NL + "    }" + NL;
  protected final String TEXT_54 = NL + "    //ESB Service Locator Feature" + NL + "" + NL + "\tprivate org.talend.esb.servicelocator.cxf.LocatorFeature locatorFeature;" + NL + "" + NL + "    public org.talend.esb.servicelocator.cxf.LocatorFeature getLocatorFeature(org.apache.cxf.Bus bus) {" + NL + "    \torg.talend.esb.servicelocator.cxf.LocatorFeature locatorFeature_ = null;" + NL + "        if(inOSGi){" + NL + "\t\t\tlocatorFeature_ = locatorFeature;" + NL + "        }else{  " + NL + "\t    \torg.springframework.context.support.ClassPathXmlApplicationContext context_ = new org.springframework.context.support.ClassPathXmlApplicationContext(new String[] { \"META-INF/tesb/locator/beans.xml\" });" + NL + "\t    \tlocatorFeature_ = (org.talend.esb.servicelocator.cxf.LocatorFeature) context_.getBean(org.talend.esb.servicelocator.cxf.LocatorFeature.class);" + NL + "        }" + NL + "        return locatorFeature_;" + NL + "    }" + NL + "    " + NL + "    public void setLocatorFeature(org.talend.esb.servicelocator.cxf.LocatorFeature locatorFeature){" + NL + "    \tthis.locatorFeature = locatorFeature;" + NL + "    }" + NL + "    " + NL + "    public void initLocator(CamelContext camelContext){" + NL + "    \tif(camelContext.getComponent(\"locator\") == null){" + NL + "\t\t\tcamelContext.addComponent(\"locator\", new org.apache.camel.impl.DefaultComponent(){" + NL + "\t\t\t\t@Override" + NL + "\t\t\t\tprotected org.apache.camel.Endpoint createEndpoint(String uri, String remaining, Map<String, Object> parameters) throws Exception {" + NL + "\t\t\t\t\treturn null;" + NL + "\t\t\t\t}" + NL + "\t\t\t});" + NL + "\t\t}" + NL + "    }" + NL;
  protected final String TEXT_55 = NL + "    static class CorrelationIDCallbackHandler implements org.talend.esb.policy.correlation.CorrelationIDCallbackHandler {" + NL + "        private String correlationId;" + NL + "        public void setCorrelationId(String correlationId) {" + NL + "            this.correlationId = correlationId;" + NL + "        }" + NL + "        public String getCorrelationId() {" + NL + "            return correlationId;" + NL + "        }" + NL + "    }";
  protected final String TEXT_56 = NL + "    public String getCXFRSEndpointAddress(String endpointUrl) {" + NL + "        if (inOSGi) {" + NL + "            if (endpointUrl != null && !endpointUrl.trim().isEmpty() && !endpointUrl.contains(\"://\")) {" + NL + "                if (endpointUrl.startsWith(\"/services\")) {" + NL + "                    endpointUrl = endpointUrl.substring(\"/services\".length());" + NL + "                }" + NL + "                if (!endpointUrl.startsWith(\"/\")) {" + NL + "                    endpointUrl = '/' + endpointUrl;" + NL + "                }" + NL + "            }" + NL + "            return endpointUrl;" + NL + "        }" + NL + "        String defaultEndpointUrl = \"";
  protected final String TEXT_57 = "\";" + NL + "        if (null == endpointUrl || endpointUrl.trim().isEmpty()) {" + NL + "            endpointUrl = defaultEndpointUrl;" + NL + "        } else if (!endpointUrl.contains(\"://\")) { // relative" + NL + "            if (endpointUrl.startsWith(\"/\")) {" + NL + "                endpointUrl = endpointUrl.substring(1);" + NL + "            }" + NL + "            endpointUrl = defaultEndpointUrl + endpointUrl;" + NL + "        }" + NL + "        return endpointUrl;" + NL + "    }" + NL + "" + NL + "static class CxfPayloadProvider implements javax.ws.rs.ext.MessageBodyWriter<org.apache.camel.component.cxf.CxfPayload<javax.xml.transform.Source>> {" + NL + "    public boolean isWriteable(Class<?> cls, java.lang.reflect.Type type, java.lang.annotation.Annotation[] anns, javax.ws.rs.core.MediaType mt) {" + NL + "        return cls == org.apache.camel.component.cxf.CxfPayload.class;" + NL + "    }" + NL + "    public long getSize(org.apache.camel.component.cxf.CxfPayload<javax.xml.transform.Source> obj, Class<?> cls, java.lang.reflect.Type type," + NL + "            java.lang.annotation.Annotation[] anns, javax.ws.rs.core.MediaType mt) {" + NL + "        return -1;" + NL + "    }" + NL + "    public void writeTo(org.apache.camel.component.cxf.CxfPayload<javax.xml.transform.Source> obj, Class<?> cls, java.lang.reflect.Type type," + NL + "            java.lang.annotation.Annotation[] anns, javax.ws.rs.core.MediaType mt," + NL + "            javax.ws.rs.core.MultivaluedMap<String, Object> headers, java.io.OutputStream os)" + NL + "            throws java.io.IOException, javax.ws.rs.WebApplicationException {" + NL + "        java.util.List<javax.xml.transform.Source> bodySource = obj.getBodySources();" + NL + "        if (bodySource == null || bodySource.size() != 1) {" + NL + "            throw new javax.ws.rs.InternalServerErrorException();" + NL + "        }" + NL + "        try {" + NL + "            org.apache.cxf.staxutils.StaxUtils.copy(bodySource.get(0), os);" + NL + "        } catch (javax.xml.stream.XMLStreamException ex) {" + NL + "            throw new javax.ws.rs.InternalServerErrorException(ex);" + NL + "        }" + NL + "" + NL + "    }" + NL + "}";
  protected final String TEXT_58 = NL + NL + "    private String propertyToString(Object obj){" + NL + "        if(obj!=null && obj instanceof java.util.Date){" + NL + "            return String.format(\"yyyy-MM-dd HH:mm:ss;%tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS\",obj);" + NL + "        }else{" + NL + "            return String.valueOf(obj);" + NL + "        }" + NL + "    }" + NL;
  protected final String TEXT_59 = NL + "            private final static class CXFConsumerBinding extends org.apache.camel.component.cxf.DefaultCxfBinding {" + NL + "                private org.apache.camel.component.cxf.CxfEndpoint endpoint;" + NL + "" + NL + "                public CXFConsumerBinding(org.apache.camel.component.cxf.CxfEndpoint endpoint){" + NL + "                    this.endpoint = endpoint;" + NL + "                    setHeaderFilterStrategy(consumerSoapHeaderFilter);" + NL + "                }" + NL + "                @Override" + NL + "                protected void propagateHeadersFromCamelToCxf(org.apache.camel.Exchange camelExchange," + NL + "                        Map<String, Object> camelHeaders, org.apache.cxf.message.Exchange cxfExchange," + NL + "                        Map<String, Object> cxfContext) {" + NL + "                    super.propagateHeadersFromCamelToCxf(camelExchange, camelHeaders, cxfExchange, cxfContext);" + NL + "                    final Object samlToken = camelHeaders.get(\"samlToken\");" + NL + "                    if (samlToken != null) {" + NL + "                        final Map<String, Object> properties = endpoint.getProperties();" + NL + "                        if (properties != null){" + NL + "                            Object object = properties.get(org.apache.cxf.ws.security.SecurityConstants.STS_CLIENT);" + NL + "                            if (object != null && object instanceof org.apache.cxf.ws.security.trust.STSClient) {" + NL + "                                ((org.apache.cxf.ws.security.trust.STSClient) object).setOnBehalfOf(samlToken);" + NL + "                                cxfContext.put(org.apache.cxf.ws.security.SecurityConstants.CACHE_ISSUED_TOKEN_IN_ENDPOINT, false);" + NL + "                            }" + NL + "                        }" + NL + "                    }" + NL + "                }" + NL + "            }";
  protected final String TEXT_60 = NL + "                private final static class CXFProviderBinding extends org.apache.camel.component.cxf.DefaultCxfBinding{" + NL + "" + NL + "                    @Override" + NL + "                    protected void propagateHeadersFromCxfToCamel( org.apache.cxf.message.Message cxfMessage," + NL + "                            org.apache.camel.Message camelMessage, org.apache.camel.Exchange camelExchange) {" + NL + "                        super.propagateHeadersFromCxfToCamel(cxfMessage, camelMessage, camelExchange);" + NL + "                        camelExchange.getIn().removeHeader(\"samlToken\");" + NL + "                        org.apache.cxf.security.SecurityContext securityContext = cxfMessage.get(org.apache.cxf.security.SecurityContext.class);" + NL + "                        if(securityContext != null && securityContext instanceof org.apache.cxf.rt.security.saml.claims.SAMLSecurityContext){" + NL + "                            org.w3c.dom.Element assertionElement = ((org.apache.cxf.rt.security.saml.claims.SAMLSecurityContext) securityContext).getAssertionElement();" + NL + "                            if(assertionElement != null){" + NL + "                                camelExchange.getIn().setHeader(\"samlToken\", assertionElement);" + NL + "                            }" + NL + "                        }" + NL + "                    }" + NL + "                }";
  protected final String TEXT_61 = NL + "            @org.springframework.context.annotation.Bean" + NL + "            public org.springframework.boot.web.servlet.ServletRegistrationBean servletRegistrationBean(org.springframework.context.ApplicationContext context) {" + NL + "                return new org.springframework.boot.web.servlet.ServletRegistrationBean(new org.apache.cxf.transport.servlet.CXFServlet(), \"/services/*\");" + NL + "            }" + NL + "            @org.springframework.context.annotation.Bean(name = \"cxf\")" + NL + "            public org.apache.cxf.bus.spring.SpringBus springBus() {" + NL;
  protected final String TEXT_62 = NL + "                    return (org.apache.cxf.bus.spring.SpringBus) new org.apache.cxf.bus.spring.SpringBusFactory().createBus(\"META-INF/tesb/locator/beans.xml\");";
  protected final String TEXT_63 = NL + "                    return new org.apache.cxf.bus.spring.SpringBus();";
  protected final String TEXT_64 = NL + NL + "            }";
  protected final String TEXT_65 = NL + NL + "            private org.apache.camel.component.cxf.CxfEndpoint getCxfEndpoint(String uri, boolean isProvider, boolean useAuthorization, boolean usePropagateSamlAP, String... token){" + NL + "                final org.apache.camel.component.cxf.CxfEndpoint cxfEndpoint = (org.apache.camel.component.cxf.CxfEndpoint) endpoint(uri);" + NL;
  protected final String TEXT_66 = NL + "                    cxfEndpoint.setCxfEndpointConfigurer(new org.apache.camel.component.cxf.CxfEndpointConfigurer() {" + NL + "                        public void configure(org.apache.cxf.frontend.AbstractWSDLBasedEndpointFactory factory) {" + NL + "                        }" + NL + "                        public void configureClient(org.apache.cxf.endpoint.Client client) {" + NL + "                            String configName = \"org.apache.cxf.http.conduits-\" + cxfEndpoint.getPortName().getLocalPart() + \".cfg\";" + NL + "                            java.util.Dictionary<String, String> dic = loadHttpConduitProperties(configName);" + NL + "" + NL + "                            org.apache.cxf.transport.http.HTTPConduit conduit = (org.apache.cxf.transport.http.HTTPConduit) client.getConduit();" + NL + "                            HttpConduitConfigApplier configApplier = new HttpConduitConfigApplier();" + NL + "                            configApplier.apply(dic, conduit, cxfEndpoint.getAddress());" + NL + "                        }" + NL + "                        public void configureServer(org.apache.cxf.endpoint.Server server) {" + NL + "                        }" + NL + "                    });";
  protected final String TEXT_67 = NL + "                    if (!isProvider&&token!=null &&" + NL + "                            (org.apache.cxf.transport.http.auth.HttpAuthHeader.AUTH_TYPE_BASIC.equals(token[0])" + NL + "                                    || org.apache.cxf.transport.http.auth.HttpAuthHeader.AUTH_TYPE_DIGEST.equals(token[0]))) {" + NL + "                        addHttpAuthConsumer(cxfEndpoint, token[0], token[1], token[2]);" + NL + "                    }";
  protected final String TEXT_68 = NL + "                    if(!isProvider&&token!=null&&token.length>=3&&\"UsernameToken\".equals(token[0])){" + NL + "                        addUsernameTokenConsumer(cxfEndpoint, token[1], token[2]);" + NL + "                    }";
  protected final String TEXT_69 = NL + "                if (inOSGi) {";
  protected final String TEXT_70 = NL + "                        if (isProvider && token!=null && org.apache.cxf.transport.http.auth.HttpAuthHeader.AUTH_TYPE_BASIC.equals(token[0])) {" + NL;
  protected final String TEXT_71 = NL + "                            addHttpAuthProvider(cxfEndpoint);";
  protected final String TEXT_72 = NL + NL + "                        }";
  protected final String TEXT_73 = NL + "                        if(isProvider && token!=null && \"UsernameToken\".equals(token[0])) {" + NL + "                            addUsernameTokenProvider(cxfEndpoint);" + NL + "                        }" + NL;
  protected final String TEXT_74 = NL + "                    if(token!=null&&\"SAMLToken\".equals(token[0])){" + NL + "                        addSAMLToken(cxfEndpoint,isProvider, useAuthorization, usePropagateSamlAP, token);" + NL + "                    }";
  protected final String TEXT_75 = NL + "                    if(token!=null&&\"Registry\".equals(token[0])){" + NL + "                        addRegistry(cxfEndpoint, isProvider, usePropagateSamlAP, token);" + NL + "                    }";
  protected final String TEXT_76 = NL + "                }";
  protected final String TEXT_77 = NL + "                return cxfEndpoint;" + NL + "            }";
  protected final String TEXT_78 = NL + "            private void addHttpAuthConsumer(org.apache.camel.component.cxf.CxfEndpoint cxfEndpoint, String type, String username, String password) {" + NL + "                org.apache.cxf.configuration.security.AuthorizationPolicy authorizationPolicy = new org.apache.cxf.configuration.security.AuthorizationPolicy();" + NL + "                authorizationPolicy.setAuthorizationType(type);" + NL + "                authorizationPolicy.setUserName(username);" + NL + "                authorizationPolicy.setPassword(password);" + NL + "                cxfEndpoint.setProperties(java.util.Collections.<String, Object>singletonMap(org.apache.cxf.configuration.security.AuthorizationPolicy.class.getName(), authorizationPolicy));" + NL + "            }";
  protected final String TEXT_79 = NL + "            private void addHttpAuthProvider(org.apache.camel.component.cxf.CxfEndpoint cxfEndpoint) {" + NL + "                org.apache.cxf.interceptor.security.JAASLoginInterceptor jaasLoginInterceptor = new org.apache.cxf.interceptor.security.JAASLoginInterceptor();" + NL + "                jaasLoginInterceptor.setContextName(\"karaf\");" + NL + "                cxfEndpoint.getInInterceptors().add(jaasLoginInterceptor);" + NL + "            }";
  protected final String TEXT_80 = NL + NL + "            class PropertyFileValidator implements org.apache.wss4j.dom.validate.Validator {" + NL + "" + NL + "                private final static String USERSFILENAME = \"users.properties\";" + NL + "" + NL + "                @Override" + NL + "                public org.apache.wss4j.dom.validate.Credential validate(org.apache.wss4j.dom.validate.Credential credential, org.apache.wss4j.dom.handler.RequestData data) throws org.apache.wss4j.common.ext.WSSecurityException {" + NL + "                    if (credential == null || credential.getUsernametoken() == null) {" + NL + "                        throw new org.apache.wss4j.common.ext.WSSecurityException(org.apache.wss4j.common.ext.WSSecurityException.ErrorCode.FAILURE, \"noCredential\");" + NL + "                    }" + NL + "" + NL + "                    String user = null;" + NL + "                    String password = null;" + NL + "" + NL + "                    org.apache.wss4j.dom.message.token.UsernameToken usernameToken = credential.getUsernametoken();" + NL + "" + NL + "                    user = usernameToken.getName();" + NL + "                    String pwType = usernameToken.getPasswordType();" + NL + "                    if (log.isDebugEnabled()) {" + NL + "                        log.debug(\"UsernameToken user \" + usernameToken.getName());" + NL + "                        log.debug(\"UsernameToken password type \" + pwType);" + NL + "                    }" + NL + "" + NL + "                    if (usernameToken.isHashed()) {" + NL + "                        log.warn(\"Authentication failed as hashed username token not supported\");" + NL + "                        throw new org.apache.wss4j.common.ext.WSSecurityException(org.apache.wss4j.common.ext.WSSecurityException.ErrorCode.FAILED_AUTHENTICATION);" + NL + "                    }" + NL + "" + NL + "                    password = usernameToken.getPassword();" + NL + "" + NL + "                    if (!org.apache.wss4j.dom.WSConstants.PASSWORD_TEXT.equals(pwType)) {" + NL + "                        log.warn(\"Password type \" + pwType + \" not supported\");" + NL + "                        throw new org.apache.wss4j.common.ext.WSSecurityException(org.apache.wss4j.common.ext.WSSecurityException.ErrorCode.FAILED_AUTHENTICATION);" + NL + "                    }" + NL + "" + NL + "                    if (!(user != null && user.length() > 0 && password != null && password.length() > 0)) {" + NL + "                        log.warn(\"User or password empty\");" + NL + "                        throw new org.apache.wss4j.common.ext.WSSecurityException(org.apache.wss4j.common.ext.WSSecurityException.ErrorCode.FAILED_AUTHENTICATION);" + NL + "                    }" + NL + "" + NL + "                    java.io.InputStream stream = getConfigLocation(USERSFILENAME);" + NL + "                    try {" + NL + "                        Properties properties = new Properties();" + NL + "                        properties.load(stream);" + NL + "                        String propertyPwd = (String) properties.get(user);" + NL + "                        if (propertyPwd == null || !propertyPwd.equalsIgnoreCase(password)) {" + NL + "                            log.info(\"Authentication failed\");" + NL + "                            throw new org.apache.wss4j.common.ext.WSSecurityException(org.apache.wss4j.common.ext.WSSecurityException.ErrorCode.FAILED_AUTHENTICATION);" + NL + "                        }" + NL + "                    } catch (Exception ex) {" + NL + "                        log.info(\"Authentication failed\", ex);" + NL + "                        throw new org.apache.wss4j.common.ext.WSSecurityException(org.apache.wss4j.common.ext.WSSecurityException.ErrorCode.FAILED_AUTHENTICATION);" + NL + "                    } finally {" + NL + "                        try {" + NL + "                            stream.close();" + NL + "                        } catch (java.io.IOException e) {" + NL + "" + NL + "                        }" + NL + "                    }" + NL + "" + NL + "                    return credential;" + NL + "                }" + NL + "" + NL + "            }" + NL + "" + NL + "            private void addUsernameTokenProvider(org.apache.camel.component.cxf.CxfEndpoint cxfEndpoint) {" + NL + "            PropertyFileValidator validator = new PropertyFileValidator();" + NL + "" + NL + "            cxfEndpoint" + NL + "                    .setProperties(java.util.Collections" + NL + "                            .<String, Object> singletonMap(" + NL + "                                    org.apache.cxf.ws.security.SecurityConstants.USERNAME_TOKEN_VALIDATOR," + NL + "                                    validator));" + NL + "            java.io.InputStream policyInput = getConfigLocation(\"org.talend.esb.job.token.policy\");" + NL + "            org.apache.neethi.Policy policy;" + NL + "            try {" + NL + "                policy = cxfEndpoint.getBus().getExtension(org.apache.cxf.ws.policy.PolicyBuilder.class).getPolicy(policyInput);" + NL + "            } catch (Exception e) {" + NL + "                throw new RuntimeException(\"Cannot load policy\", e);" + NL + "            }" + NL + "" + NL + "            cxfEndpoint.getFeatures().add(" + NL + "                    new org.apache.cxf.ws.policy.WSPolicyFeature(policy));" + NL + "            }";
  protected final String TEXT_81 = NL + "            private void addUsernameTokenProvider(org.apache.camel.component.cxf.CxfEndpoint cxfEndpoint) {" + NL + "                org.apache.wss4j.dom.validate.JAASUsernameTokenValidator validator = new org.apache.wss4j.dom.validate.JAASUsernameTokenValidator();" + NL + "                validator.setContextName(\"karaf\");" + NL + "                cxfEndpoint.setProperties(java.util.Collections.<String, Object>singletonMap(org.apache.cxf.ws.security.SecurityConstants.USERNAME_TOKEN_VALIDATOR, validator));" + NL + "                cxfEndpoint.getFeatures().add(new org.apache.cxf.ws.policy.WSPolicyFeature(policyProvider.getUsernamePolicy(cxfEndpoint.getBus())));" + NL + "            }";
  protected final String TEXT_82 = NL;
  protected final String TEXT_83 = NL + "            private void addUsernameTokenConsumer(org.apache.camel.component.cxf.CxfEndpoint cxfEndpoint," + NL + "                    String username, String password) {" + NL + "                if (null != policyProvider) {" + NL + "                    Map<String, Object> props = new HashMap<String, Object>();" + NL + "                    props.put(org.apache.cxf.rt.security.SecurityConstants.USERNAME, username);" + NL + "                    props.put(org.apache.cxf.rt.security.SecurityConstants.PASSWORD, password);" + NL + "                    cxfEndpoint.setProperties(props);" + NL + "                    cxfEndpoint.getFeatures().add(new org.apache.cxf.ws.policy.WSPolicyFeature(policyProvider.getUsernamePolicy(cxfEndpoint.getBus())));" + NL + "                } else {" + NL + "                    Map<String, Object> props = new HashMap<String, Object>();" + NL + "                    props.put(org.apache.wss4j.dom.handler.WSHandlerConstants.ACTION, org.apache.wss4j.dom.handler.WSHandlerConstants.USERNAME_TOKEN);" + NL + "                    props.put(org.apache.wss4j.dom.handler.WSHandlerConstants.PASSWORD_TYPE, org.apache.wss4j.common.WSS4JConstants.PW_TEXT);" + NL + "                    props.put(org.apache.wss4j.dom.handler.WSHandlerConstants.USER, username);" + NL + "                    props.put(org.apache.wss4j.dom.handler.WSHandlerConstants.PW_CALLBACK_REF," + NL + "                        new org.talend.esb.security.saml.WSPasswordCallbackHandler(username, password));" + NL + "                    cxfEndpoint.getOutInterceptors().add(new org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor(props));" + NL + "                }" + NL + "            }";
  protected final String TEXT_84 = NL + NL + "private Map<String, String> clientProperties;" + NL + "" + NL + "public void setClientProperties(Object clientProperties) {" + NL + "        this.clientProperties = getArguments(clientProperties,String.class);" + NL + "}" + NL;
  protected final String TEXT_85 = NL + "private final static org.apache.camel.component.cxf.common.header.CxfHeaderFilterStrategy consumerSoapHeaderFilter = new org.apache.camel.component.cxf.common.header.CxfHeaderFilterStrategy();";
  protected final String TEXT_86 = NL + "private void addRegistry(org.apache.camel.component.cxf.CxfEndpoint cxfEndpoint," + NL + "        boolean isProvider, boolean usePropagateSamlAP, final String... token) {";
  protected final String TEXT_87 = NL + NL + "    if(!isProvider){" + NL + "        final org.apache.cxf.Bus bus = cxfEndpoint.getBus();" + NL + "        if(usePropagateSamlAP && (token[4] == null)){" + NL + "            usePropagateSamlAP = false ;" + NL + "        }" + NL;
  protected final String TEXT_88 = NL + "            Properties stsProperties = new Properties();" + NL + "            java.io.InputStream stsCfg= getConfigLocation(\"org.talend.esb.job.client.sts.cfg\");" + NL + "" + NL + "            try {" + NL + "                    stsProperties.load(stsCfg);" + NL + "            } catch (Exception e) {" + NL + "                throw new RuntimeException(\"Cannot load client properties\", e);" + NL + "            }" + NL + "" + NL + "            Map<String, String> stsProps = new HashMap<String, String>();" + NL + "            for (Map.Entry<Object, Object> entry : stsProperties.entrySet()) {" + NL + "                    stsProps.put((String)entry.getKey(), (String)entry.getValue());" + NL + "            }" + NL + "            new org.talend.esb.security.saml.STSClientUtils(stsProps);";
  protected final String TEXT_89 = NL + "        final org.apache.cxf.ws.security.trust.STSClient stsClient;" + NL + "        if(usePropagateSamlAP) {" + NL + "            stsClient= org.talend.esb.security.saml.STSClientUtils.createSTSX509Client(bus, token[4]);" + NL + "        }else {" + NL + "            stsClient= org.talend.esb.security.saml.STSClientUtils.createSTSClient(bus, token[1], token[2]);" + NL + "        }" + NL + "        if (token[3]/*Role*/ != null && !(\"\".equals(token[3]))) {" + NL + "            org.talend.esb.security.saml.STSClientUtils.applyAuthorization(stsClient, token[3]);" + NL + "        }" + NL + "" + NL + "        Map<String, Object> clientProps = new HashMap<String, Object>();" + NL + "        clientProps.put(org.apache.cxf.ws.security.SecurityConstants.USERNAME," + NL + "                token[1]);" + NL + "        clientProps.put(org.apache.cxf.ws.security.SecurityConstants.PASSWORD," + NL + "                token[2]);" + NL + "" + NL + "        clientProps.put(" + NL + "                org.apache.cxf.ws.security.SecurityConstants.STS_CLIENT," + NL + "                stsClient);" + NL;
  protected final String TEXT_90 = NL + "            Properties clientPropertiesTmp = new Properties();" + NL + "            java.io.InputStream clientCfg= getConfigLocation(\"org.talend.esb.job.client.cfg\");" + NL + "" + NL + "            try {" + NL + "                    clientPropertiesTmp.load(clientCfg);" + NL + "" + NL + "                    clientProperties = new HashMap<String, String>();" + NL + "                    for (String key : clientPropertiesTmp.stringPropertyNames()) {" + NL + "                        clientProperties.put(key, clientPropertiesTmp.getProperty(key));" + NL + "                    }" + NL + "            } catch (Exception e) {" + NL + "                throw new RuntimeException(\"Cannot load client properties\", e);" + NL + "            }";
  protected final String TEXT_91 = NL + NL + "        for (Map.Entry<String, String> entry : clientProperties.entrySet()) {" + NL + "            if (org.apache.cxf.ws.security.SecurityConstants.ALL_PROPERTIES" + NL + "                    .contains(entry.getKey())) {" + NL + "                clientProps.put(entry.getKey(), entry.getValue());" + NL + "            }" + NL + "        }" + NL + "" + NL + "        if(usePropagateSamlAP) {" + NL + "            clientProps.put(org.apache.cxf.ws.security.SecurityConstants.SIGNATURE_USERNAME, token[4]);" + NL + "            clientProps" + NL + "            .put(org.apache.cxf.ws.security.SecurityConstants.CALLBACK_HANDLER," + NL + "                    new org.talend.esb.security.saml.WSPasswordCallbackHandler(token[4], token[2]));" + NL + "        }else {" + NL + "            clientProps" + NL + "            .put(org.apache.cxf.ws.security.SecurityConstants.CALLBACK_HANDLER," + NL + "                    new org.talend.esb.security.saml.WSPasswordCallbackHandler(" + NL + "                            clientProperties" + NL + "                            .get(org.apache.cxf.ws.security.SecurityConstants.SIGNATURE_USERNAME)," + NL + "                            clientProperties" + NL + "                            .get(\"security.signature.password\")));" + NL + "        }" + NL + "        clientProps.put(\"soap.no.validate.parts\", Boolean.TRUE);" + NL + "        clientProps.put(\"use.service.registry\", \"true\");" + NL + "        // set the cxfEndpoint Properties" + NL + "        cxfEndpoint.setProperties(clientProps);";
  protected final String TEXT_92 = NL + "        final org.apache.camel.component.cxf.CxfEndpointConfigurer cxfEndpointConfigurer = cxfEndpoint.getCxfEndpointConfigurer();" + NL + "        final org.apache.camel.component.cxf.CxfEndpoint cxfEndpointTrans= cxfEndpoint;" + NL + "        cxfEndpoint.setCxfEndpointConfigurer(new org.apache.camel.component.cxf.CxfEndpointConfigurer() {" + NL + "            public void configure(org.apache.cxf.frontend.AbstractWSDLBasedEndpointFactory factory) {" + NL + "                if (cxfEndpointConfigurer != null) {" + NL + "                    cxfEndpointConfigurer.configure(factory);" + NL + "                }" + NL + "                factory.setAddress(null);" + NL + "            }" + NL + "            public void configureClient(org.apache.cxf.endpoint.Client client) {" + NL;
  protected final String TEXT_93 = NL + "                    String configName = \"org.apache.cxf.http.conduits-\" + cxfEndpointTrans.getPortName().getLocalPart() + \".cfg\";" + NL + "                    java.util.Dictionary<String, String> dic = loadHttpConduitProperties(configName);" + NL + "" + NL + "                    org.apache.cxf.transport.http.HTTPConduit conduit = (org.apache.cxf.transport.http.HTTPConduit) client.getConduit();" + NL + "                    HttpConduitConfigApplier configApplier = new HttpConduitConfigApplier();" + NL + "                    configApplier.apply(dic, conduit, cxfEndpointTrans.getAddress());";
  protected final String TEXT_94 = NL + "                    if (cxfEndpointConfigurer != null) {" + NL + "                        cxfEndpointConfigurer.configureClient(client);" + NL + "                    }";
  protected final String TEXT_95 = NL + NL + "            }" + NL + "            public void configureServer(org.apache.cxf.endpoint.Server server) {" + NL + "                if (cxfEndpointConfigurer != null) {" + NL + "                    cxfEndpointConfigurer.configureServer(server);" + NL + "                }" + NL + "            }" + NL + "        });";
  protected final String TEXT_96 = NL + "        org.apache.cxf.endpoint.ClientLifeCycleManager cLifeCycleManager = bus.getExtension(org.apache.cxf.endpoint.ClientLifeCycleManager.class);" + NL + "        if (cLifeCycleManager != null) {" + NL + "            cLifeCycleManager.registerListener(new org.apache.cxf.endpoint.ClientLifeCycleListener() {" + NL + "                public void clientCreated(org.apache.cxf.endpoint.Client client) {" + NL + "                    String address = client.getEndpoint().getEndpointInfo().getAddress();" + NL + "                    if ((address != null) && address.startsWith(\"locator://\")) {" + NL + "\t\t\t\t    \torg.talend.esb.servicelocator.cxf.LocatorFeature locatorFeature_ = null;" + NL + "\t\t\t\t        if(inOSGi){" + NL + "\t\t\t\t\t\t\tlocatorFeature_ = routines.system.BundleUtils.getService(org.talend.esb.servicelocator.cxf.LocatorFeature.class);" + NL + "\t\t\t\t        }else{  " + NL + "\t\t\t\t\t    \torg.springframework.context.support.ClassPathXmlApplicationContext context_ = new org.springframework.context.support.ClassPathXmlApplicationContext(new String[] { \"META-INF/tesb/locator/beans.xml\" });" + NL + "\t\t\t\t\t    \tlocatorFeature_ = (org.talend.esb.servicelocator.cxf.LocatorFeature) context_.getBean(org.talend.esb.servicelocator.cxf.LocatorFeature.class);" + NL + "\t\t\t\t        }" + NL + "                        locatorFeature_.initialize(client, client.getBus());" + NL + "                    }" + NL + "                }" + NL + "                public void clientDestroyed(org.apache.cxf.endpoint.Client client) {" + NL + "                }" + NL + "            });" + NL + "        }" + NL + "    }";
  protected final String TEXT_97 = NL + "    if (isProvider) {" + NL + "" + NL + "        // set endpoint properties";
  protected final String TEXT_98 = NL + NL + "            class PropertyFileValidator implements org.apache.wss4j.dom.validate.Validator {" + NL + "" + NL + "                private final static String USERSFILENAME = \"users.properties\";" + NL + "" + NL + "                @Override" + NL + "                public org.apache.wss4j.dom.validate.Credential validate(org.apache.wss4j.dom.validate.Credential credential, org.apache.wss4j.dom.handler.RequestData data) throws org.apache.wss4j.common.ext.WSSecurityException {" + NL + "                    if (credential == null || credential.getUsernametoken() == null) {" + NL + "                        throw new org.apache.wss4j.common.ext.WSSecurityException(org.apache.wss4j.common.ext.WSSecurityException.ErrorCode.FAILURE, \"noCredential\");" + NL + "                    }" + NL + "" + NL + "                    String user = null;" + NL + "                    String password = null;" + NL + "" + NL + "                    org.apache.wss4j.dom.message.token.UsernameToken usernameToken = credential.getUsernametoken();" + NL + "" + NL + "                    user = usernameToken.getName();" + NL + "                    String pwType = usernameToken.getPasswordType();" + NL + "                    if (log.isDebugEnabled()) {" + NL + "                        log.debug(\"UsernameToken user \" + usernameToken.getName());" + NL + "                        log.debug(\"UsernameToken password type \" + pwType);" + NL + "                    }" + NL + "" + NL + "                    if (usernameToken.isHashed()) {" + NL + "                        log.warn(\"Authentication failed as hashed username token not supported\");" + NL + "                        throw new org.apache.wss4j.common.ext.WSSecurityException(org.apache.wss4j.common.ext.WSSecurityException.ErrorCode.FAILED_AUTHENTICATION);" + NL + "                    }" + NL + "" + NL + "                    password = usernameToken.getPassword();" + NL + "" + NL + "                    if (!org.apache.wss4j.dom.WSConstants.PASSWORD_TEXT.equals(pwType)) {" + NL + "                        log.warn(\"Password type \" + pwType + \" not supported\");" + NL + "                        throw new org.apache.wss4j.common.ext.WSSecurityException(org.apache.wss4j.common.ext.WSSecurityException.ErrorCode.FAILED_AUTHENTICATION);" + NL + "                    }" + NL + "" + NL + "                    if (!(user != null && user.length() > 0 && password != null && password.length() > 0)) {" + NL + "                        log.warn(\"User or password empty\");" + NL + "                        throw new org.apache.wss4j.common.ext.WSSecurityException(org.apache.wss4j.common.ext.WSSecurityException.ErrorCode.FAILED_AUTHENTICATION);" + NL + "                    }" + NL + "" + NL + "                    java.io.InputStream stream = getConfigLocation(USERSFILENAME);" + NL + "                    try {" + NL + "                        Properties properties = new Properties();" + NL + "                        properties.load(stream);" + NL + "                        String propertyPwd = (String) properties.get(user);" + NL + "                        if (propertyPwd == null || !propertyPwd.equalsIgnoreCase(password)) {" + NL + "                            log.info(\"Authentication failed\");" + NL + "                            throw new org.apache.wss4j.common.ext.WSSecurityException(org.apache.wss4j.common.ext.WSSecurityException.ErrorCode.FAILED_AUTHENTICATION);" + NL + "                        }" + NL + "                    } catch (Exception ex) {" + NL + "                        log.info(\"Authentication failed\", ex);" + NL + "                        throw new org.apache.wss4j.common.ext.WSSecurityException(org.apache.wss4j.common.ext.WSSecurityException.ErrorCode.FAILED_AUTHENTICATION);" + NL + "                    } finally {" + NL + "                        try {" + NL + "                            stream.close();" + NL + "                        } catch (java.io.IOException e) {" + NL + "" + NL + "                        }" + NL + "                    }" + NL + "" + NL + "                    return credential;" + NL + "                }" + NL + "" + NL + "            }" + NL + "" + NL + "            PropertyFileValidator jaasUTValidator = new PropertyFileValidator();" + NL + "" + NL + "        Properties serviceProps = new Properties();" + NL + "        java.io.InputStream serviceCfg= getConfigLocation(\"org.talend.esb.job.service.cfg\");" + NL + "" + NL + "        try {" + NL + "                serviceProps.load(serviceCfg);" + NL + "            securityProps = new HashMap<String, Object>();" + NL + "            for (String key : serviceProps.stringPropertyNames()) {" + NL + "                securityProps.put(key, serviceProps.getProperty(key));" + NL + "            }" + NL + "        } catch (Exception e) {" + NL + "            throw new RuntimeException(\"Cannot load service properties\", e);" + NL + "        }" + NL;
  protected final String TEXT_99 = NL + "            org.apache.wss4j.dom.validate.JAASUsernameTokenValidator jaasUTValidator = new org.apache.wss4j.dom.validate.JAASUsernameTokenValidator();" + NL + "            jaasUTValidator.setContextName(\"karaf\");";
  protected final String TEXT_100 = NL + NL + "        final String userName = (String) securityProps.get(org.apache.cxf.ws.security.SecurityConstants.SIGNATURE_USERNAME);" + NL + "        final Map<String, Object> endpointProps = new HashMap<String, Object>();" + NL + "        endpointProps.put(org.apache.cxf.ws.security.SecurityConstants.SIGNATURE_USERNAME, userName);" + NL + "        endpointProps.put(org.apache.cxf.ws.security.SecurityConstants.SIGNATURE_PROPERTIES, securityProps.get(org.apache.cxf.ws.security.SecurityConstants.SIGNATURE_PROPERTIES));" + NL + "        endpointProps.put(org.apache.cxf.rt.security.SecurityConstants.CALLBACK_HANDLER, new org.talend.esb.security.saml.WSPasswordCallbackHandler(userName, (String) securityProps.get(\"security.signature.password\")));" + NL + "        endpointProps.put(org.apache.cxf.ws.security.SecurityConstants.USERNAME_TOKEN_VALIDATOR, jaasUTValidator);" + NL + "        endpointProps.put(\"use.service.registry\", \"true\");";
  protected final String TEXT_101 = NL + "            Properties pepProps = new Properties();" + NL + "            java.io.InputStream pepCfg= getConfigLocation(\"org.talend.esb.authorization.pep.cfg\");" + NL + "" + NL + "            try {" + NL + "                pepProps.load(pepCfg);" + NL + "            } catch (Exception e) {" + NL + "                throw new RuntimeException(\"Cannot load pep properties\", e);" + NL + "            }" + NL + "            endpointProps.put(org.talend.esb.authorization.xacml.rt.pep.AuthorizationConstants.PDP_ADDRESS_PROPERTY, pepProps.get(\"tesb.pdp.address\"));";
  protected final String TEXT_102 = NL + NL + "        cxfEndpoint.setProperties(endpointProps);" + NL + "    }";
  protected final String TEXT_103 = NL + "}";
  protected final String TEXT_104 = NL + "private Map<String, Object> securityProps;" + NL + "" + NL + "public void setSecurityProps(Object securityProps) {" + NL + "    this.securityProps = getArguments(securityProps,Object.class);" + NL + "}";
  protected final String TEXT_105 = NL + "private org.apache.cxf.interceptor.Interceptor<? extends org.apache.cxf.message.Message> authorizationInterceptor;" + NL + "" + NL + "public void setAuthorizationInterceptor(org.apache.cxf.interceptor.Interceptor<? extends org.apache.cxf.message.Message> authorizationInterceptor) {" + NL + "    this.authorizationInterceptor = authorizationInterceptor;" + NL + "}";
  protected final String TEXT_106 = NL + NL + "private org.talend.esb.security.policy.PolicyProvider policyProvider;" + NL + "" + NL + "public void setPolicyProvider(org.talend.esb.security.policy.PolicyProvider policyProvider) {" + NL + "    this.policyProvider = policyProvider;" + NL + "}" + NL;
  protected final String TEXT_107 = NL + NL + "private void addSAMLToken(org.apache.camel.component.cxf.CxfEndpoint cxfEndpoint," + NL + "        boolean isProvider, boolean useAuthorization, boolean usePropagateSamlAP, String... token) {" + NL + "        final org.apache.cxf.Bus bus = cxfEndpoint.getBus();";
  protected final String TEXT_108 = NL + "    if (!isProvider) {" + NL;
  protected final String TEXT_109 = NL + "            Properties stsProperties = new Properties();" + NL + "            java.io.InputStream stsCfg = getConfigLocation(\"org.talend.esb.job.client.sts.cfg\");" + NL + "" + NL + "            try {" + NL + "                    stsProperties.load(stsCfg);" + NL + "            } catch (Exception e) {" + NL + "                throw new RuntimeException(\"Cannot load client properties\", e);" + NL + "            }" + NL + "" + NL + "            Map<String, String> stsProps = new HashMap<String, String>();" + NL + "            for (Map.Entry<Object, Object> entry : stsProperties.entrySet()) {" + NL + "                    stsProps.put((String)entry.getKey(), (String)entry.getValue());" + NL + "            }" + NL + "            new org.talend.esb.security.saml.STSClientUtils(stsProps);";
  protected final String TEXT_110 = NL + NL + "        final org.apache.cxf.ws.security.trust.STSClient stsClient;" + NL + "        if (usePropagateSamlAP) {" + NL + "            stsClient = org.talend.esb.security.saml.STSClientUtils.createSTSX509Client(bus, token[4]);" + NL + "        } else {" + NL + "            stsClient = org.talend.esb.security.saml.STSClientUtils.createSTSClient(bus, token[1], token[2]);" + NL + "        }";
  protected final String TEXT_111 = NL + "        if (token[3] != null && !(\"\".equals(token[3]))) {" + NL + "            org.talend.esb.security.saml.STSClientUtils.applyAuthorization(stsClient, token[3]);" + NL + "        }";
  protected final String TEXT_112 = NL + "        Map<String, Object> clientProps = new HashMap<String, Object>();" + NL + "        clientProps.put(" + NL + "                org.apache.cxf.ws.security.SecurityConstants.STS_CLIENT," + NL + "                stsClient);" + NL;
  protected final String TEXT_113 = NL + "            Properties clientPropertiesTmp = new Properties();" + NL + "            java.io.InputStream clientCfg = getConfigLocation(\"org.talend.esb.job.client.cfg\");" + NL + "" + NL + "            try {" + NL + "                    clientPropertiesTmp.load(clientCfg);" + NL + "" + NL + "                    clientProperties = new HashMap<String, String>();" + NL + "                    for (String key : clientPropertiesTmp.stringPropertyNames()) {" + NL + "                        clientProperties.put(key, clientPropertiesTmp.getProperty(key));" + NL + "                    }" + NL + "            } catch (Exception e) {" + NL + "                throw new RuntimeException(\"Cannot load client properties\", e);" + NL + "            }";
  protected final String TEXT_114 = NL + NL + "        for (Map.Entry<String, String> entry : clientProperties.entrySet()) {" + NL + "            if (org.apache.cxf.ws.security.SecurityConstants.ALL_PROPERTIES" + NL + "                    .contains(entry.getKey())) {" + NL + "                clientProps.put(entry.getKey(), entry.getValue());" + NL + "            }" + NL + "        }" + NL + "        if(usePropagateSamlAP) {" + NL + "            clientProps.put(org.apache.cxf.ws.security.SecurityConstants.SIGNATURE_USERNAME, token[4]);" + NL + "            clientProps" + NL + "            .put(org.apache.cxf.ws.security.SecurityConstants.CALLBACK_HANDLER," + NL + "                    new org.talend.esb.security.saml.WSPasswordCallbackHandler(token[4], token[2]));" + NL + "        }else {" + NL + "            clientProps" + NL + "            .put(org.apache.cxf.ws.security.SecurityConstants.CALLBACK_HANDLER," + NL + "                    new org.talend.esb.security.saml.WSPasswordCallbackHandler(" + NL + "                            clientProperties" + NL + "                            .get(org.apache.cxf.ws.security.SecurityConstants.SIGNATURE_USERNAME)," + NL + "                            clientProperties" + NL + "                            .get(\"security.signature.password\")));" + NL + "        }" + NL + "        // set the cxfEndpoint Properties" + NL + "        cxfEndpoint.setProperties(clientProps);" + NL + "    }";
  protected final String TEXT_115 = NL + NL + "if (isProvider) {" + NL + "        // set endpoint properties";
  protected final String TEXT_116 = NL + NL + "        Properties serviceProps = new Properties();" + NL + "        java.io.InputStream serviceCfg = getConfigLocation(\"org.talend.esb.job.service.cfg\");" + NL + "" + NL + "        try {" + NL + "            serviceProps.load(serviceCfg);" + NL + "" + NL + "            securityProps = new HashMap<String, Object>();" + NL + "            for (String key : serviceProps.stringPropertyNames()) {" + NL + "                securityProps.put(key, serviceProps.getProperty(key));" + NL + "            }" + NL + "" + NL + "        } catch (Exception e) {" + NL + "            throw new RuntimeException(\"Cannot load service properties\", e);" + NL + "        }";
  protected final String TEXT_117 = NL + "        final String userName = (String) securityProps.get(org.apache.cxf.ws.security.SecurityConstants.SIGNATURE_USERNAME);" + NL + "        final Map<String, Object> endpointProps = new HashMap<String, Object>();" + NL + "        endpointProps.put(org.apache.cxf.ws.security.SecurityConstants.SIGNATURE_USERNAME, userName);" + NL + "        endpointProps.put(org.apache.cxf.ws.security.SecurityConstants.SIGNATURE_PROPERTIES, securityProps.get(org.apache.cxf.ws.security.SecurityConstants.SIGNATURE_PROPERTIES));" + NL + "        endpointProps.put(org.apache.cxf.rt.security.SecurityConstants.CALLBACK_HANDLER, new org.talend.esb.security.saml.WSPasswordCallbackHandler(userName, (String) securityProps.get(\"security.signature.password\")));" + NL;
  protected final String TEXT_118 = NL + "        if(useAuthorization){" + NL + "            Properties pepProps = new Properties();" + NL + "            java.io.InputStream pepCfg = getConfigLocation(\"org.talend.esb.authorization.pep.cfg\");" + NL + "" + NL + "            try {" + NL + "                pepProps.load(pepCfg);" + NL + "            } catch (Exception e) {" + NL + "                throw new RuntimeException(\"Cannot load pep properties\", e);" + NL + "            }" + NL + "            endpointProps.put(org.talend.esb.authorization.xacml.rt.pep.AuthorizationConstants.PDP_ADDRESS_PROPERTY, pepProps.get(\"tesb.pdp.address\"));" + NL + "            org.talend.esb.authorization.xacml.rt.pep.CXFXACMLAuthorizingInterceptor authzInterceptor = new org.talend.esb.authorization.xacml.rt.pep.CXFXACMLAuthorizingInterceptor();" + NL + "            authzInterceptor.setPdpAddress(pepProps.getProperty(\"tesb.pdp.address\"));" + NL + "            cxfEndpoint.getInInterceptors().add(authzInterceptor);" + NL + "        }";
  protected final String TEXT_119 = NL + "        cxfEndpoint.setProperties(endpointProps);" + NL + "}" + NL;
  protected final String TEXT_120 = NL + "        // add policy" + NL + "        org.apache.neethi.Policy policy;" + NL;
  protected final String TEXT_121 = NL + "            java.io.InputStream policyInput = null;" + NL + "            if (useAuthorization) {" + NL + "                policyInput = getConfigLocation(\"org.talend.esb.job.saml.authz.policy\");" + NL + "            } else {" + NL + "                policyInput = getConfigLocation(\"org.talend.esb.job.saml.policy\");" + NL + "            }" + NL + "" + NL + "" + NL + "            try {" + NL + "                policy = cxfEndpoint.getBus().getExtension(org.apache.cxf.ws.policy.PolicyBuilder.class).getPolicy(policyInput);" + NL + "            } catch (Exception e) {" + NL + "                throw new RuntimeException(\"Cannot load policy\", e);" + NL + "            }";
  protected final String TEXT_122 = NL + "            if (useAuthorization) {" + NL + "                policy = policyProvider.getSAMLAuthzPolicy(bus);" + NL + "            } else {" + NL + "                policy = policyProvider.getSAMLPolicy(bus);" + NL + "            }";
  protected final String TEXT_123 = NL + NL + "        cxfEndpoint.getFeatures().add(new org.apache.cxf.ws.policy.WSPolicyFeature(policy));" + NL + "}";
  protected final String TEXT_124 = NL;
  protected final String TEXT_125 = NL + "            private org.apache.camel.Endpoint endpoint(String uri) {" + NL + "                return context().getEndpoint(uri);" + NL + "            }";
  protected final String TEXT_126 = NL + "    @Override" + NL + "    protected RouteBuilder createRouteBuilder() throws Exception {" + NL + "        return new RouteBuilder() {";
  protected final String TEXT_127 = NL + "    java.util.Map<String, String> getOidcSettings() {" + NL + "        java.util.Map<String, String> settings = new java.util.HashMap<String, String>();";
  protected final String TEXT_128 = NL + "\t\tif(!inOSGi){" + NL + "\t\t\torg.springframework.context.support.ClassPathXmlApplicationContext context =" + NL + "\t\t\t\tnew org.springframework.context.support.ClassPathXmlApplicationContext(\"META-INF/tesb/oidc-context.xml\");" + NL + "\t\t\torg.talend.esb.security.oidc.OidcConfiguration oidcConfiguration = context.getBean(org.talend.esb.security.oidc.OidcConfiguration.class);" + NL + "\t\t\treturn oidcConfiguration.getOidcProperties();" + NL + "\t\t}";
  protected final String TEXT_129 = "\t\t" + NL + "        String tokenEndpoint = org.talend.esb.security.oidc.OidcClientUtils.getTokenEndpoint();" + NL + "        String validationEndpoint = org.talend.esb.security.oidc.OidcClientUtils.getValidationEndpoint();" + NL + "        String clientId = org.talend.esb.security.oidc.OidcClientUtils.getPublicClientID();" + NL + "        String scope = org.talend.esb.security.oidc.OidcClientUtils.getScope();" + NL + "" + NL + "        if (tokenEndpoint == null && validationEndpoint == null) {" + NL + "" + NL + "            String fileName = \"org.talend.esb.job.oidc.cfg\";" + NL + "            java.io.InputStream stream = null;" + NL + "" + NL + "            String configFile = \"config/\" + fileName;" + NL + "" + NL + "            String file = \"\";" + NL + "            // by default from current \"config\" directory" + NL + "            file = System.getProperty(\"user.dir\") + java.io.File.separator + configFile;" + NL + "" + NL + "            java.io.File usersfile = new java.io.File(file);" + NL + "            if (usersfile.exists()) {" + NL + "                try{" + NL + "                    stream = new java.io.FileInputStream(file);" + NL + "                }catch(Exception e){" + NL + "                    stream = this.getClass().getClassLoader().getResourceAsStream(configFile);" + NL + "                }" + NL + "            } else {" + NL + "                stream = this.getClass().getClassLoader().getResourceAsStream(configFile);" + NL + "            }" + NL + "" + NL + "            if (stream != null) {" + NL + "                Properties oidcProperties = new Properties();" + NL + "                try {" + NL + "                    oidcProperties.load(stream);" + NL + "                } catch (Exception e) {" + NL + "                    throw new RuntimeException(\"Cannot load OpenID Connect properties\", e);" + NL + "                } finally {" + NL + "                    try {" + NL + "                        stream.close();" + NL + "                    } catch (Exception e) {}" + NL + "                }" + NL + "" + NL + "                tokenEndpoint = oidcProperties.getProperty(org.talend.esb.security.oidc.OidcConfiguration.OIDC_TOKEN_ENDPOINT_LOCATION);" + NL + "                validationEndpoint = oidcProperties.getProperty(org.talend.esb.security.oidc.OidcConfiguration.OIDC_VALIDATION_ENDPOINT_LOCATION);" + NL + "                clientId = oidcProperties.getProperty(org.talend.esb.security.oidc.OidcConfiguration.OIDC_PUBLIC_CLIENT_ID);" + NL + "                scope = oidcProperties.getProperty(org.talend.esb.security.oidc.OidcConfiguration.OIDC_SCOPE);" + NL + "            }" + NL + "        }" + NL + "" + NL + "        settings.put(org.talend.esb.security.oidc.OidcConfiguration.OIDC_TOKEN_ENDPOINT_LOCATION, tokenEndpoint);" + NL + "        settings.put(org.talend.esb.security.oidc.OidcConfiguration.OIDC_VALIDATION_ENDPOINT_LOCATION, validationEndpoint);" + NL + "        settings.put(org.talend.esb.security.oidc.OidcConfiguration.OIDC_PUBLIC_CLIENT_ID, clientId);" + NL + "        settings.put(org.talend.esb.security.oidc.OidcConfiguration.OIDC_SCOPE, scope);" + NL + "" + NL + "        return settings;" + NL + "    }";
  protected final String TEXT_130 = NL + NL + "    private String oidcClientBearer(String oidcUsername, String oidcPassword) throws java.lang.Exception {" + NL + "        return org.talend.esb.security.oidc.OidcClientUtils.oidcClientBearer(oidcUsername, oidcPassword, getOidcSettings());" + NL + "    }";
  protected final String TEXT_131 = NL + "            @Override" + NL + "            public void configure() throws java.lang.Exception {" + NL + "                doConfig();" + NL + "            }" + NL + "" + NL + "            public void doConfig() throws java.lang.Exception {" + NL + "                final /*org.apache.camel.model.Model*/CamelContext camelContext = getContext();" + NL + "                " + NL + "                final org.apache.camel.impl.SimpleRegistry registry = new org.apache.camel.impl.SimpleRegistry();" + NL + "                final org.apache.camel.impl.CompositeRegistry compositeRegistry =" + NL + "                    new org.apache.camel.impl.CompositeRegistry();" + NL + "                compositeRegistry.addRegistry(camelContext.getRegistry());" + NL + "                compositeRegistry.addRegistry(registry);" + NL + "                ((org.apache.camel.impl.DefaultCamelContext) camelContext).setRegistry(compositeRegistry);" + NL + NL;
  protected final String TEXT_132 = NL + "\t\t\t\t\t";
  protected final String TEXT_133 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_134 = NL + "\t\t\t\t\t";
  protected final String TEXT_135 = NL + "                    //read context values" + NL + "                    readContextValues(contextStr);";
  protected final String TEXT_136 = NL;
  protected final String TEXT_137 = NL + "                    camelContext.setUseMDCLogging(true);";
  protected final String TEXT_138 = NL + "                ";
  protected final String TEXT_139 = NL;
  protected final String TEXT_140 = NL + "                    consumerSoapHeaderFilter.setRelayHeaders(false);" + NL + "                    registry.put(\"CXF_PAYLOAD_HEADER_FILTER\", consumerSoapHeaderFilter);";
  protected final String TEXT_141 = NL + "                    registry.put(\"DEFAULT_CXF_BINDING\", new CXFProviderBinding());";
  protected final String TEXT_142 = NL + "                org.apache.cxf.jaxrs.AbstractJAXRSFactoryBean factory_";
  protected final String TEXT_143 = ";";
  protected final String TEXT_144 = NL + "                    org.apache.cxf.jaxrs.JAXRSServerFactoryBean sf_";
  protected final String TEXT_145 = " = new org.apache.cxf.jaxrs.JAXRSServerFactoryBean();" + NL + "                    factory_";
  protected final String TEXT_146 = " = sf_";
  protected final String TEXT_147 = ";" + NL + "                    sf_";
  protected final String TEXT_148 = ".setServiceClass(";
  protected final String TEXT_149 = ".class);" + NL + "                    sf_";
  protected final String TEXT_150 = ".setResourceProvider(";
  protected final String TEXT_151 = ".class, new org.apache.camel.component.cxf.jaxrs.CamelResourceProvider(";
  protected final String TEXT_152 = ".class));" + NL + "                    sf_";
  protected final String TEXT_153 = ".setProvider(new CxfPayloadProvider());" + NL + "                    // avoid JAXBException in runtime" + NL + "                    sf_";
  protected final String TEXT_154 = ".setProvider(new org.apache.cxf.jaxrs.provider.SourceProvider());";
  protected final String TEXT_155 = NL + "                            org.apache.cxf.jaxrs.security.JAASAuthenticationFilter jaas_";
  protected final String TEXT_156 = " = new org.apache.cxf.jaxrs.security.JAASAuthenticationFilter();" + NL + "                            jaas_";
  protected final String TEXT_157 = ".setContextName(\"karaf\");" + NL + "                            sf_";
  protected final String TEXT_158 = ".setProvider(jaas_";
  protected final String TEXT_159 = ");";
  protected final String TEXT_160 = NL;
  protected final String TEXT_161 = NL + NL + "                            Properties pepProps = new Properties();" + NL + "                            java.io.InputStream pepCfg = getConfigLocation(\"org.talend.esb.authorization.pep.cfg\");" + NL + "" + NL + "                            try {" + NL + "                                pepProps.load(pepCfg);";
  protected final String TEXT_162 = NL + "                                org.talend.esb.authorization.xacml.rt.pep.CXFXACMLAuthorizingInterceptor _authorizationInterceptor =" + NL + "                                        new org.talend.esb.authorization.xacml.rt.pep.CXFXACMLAuthorizingInterceptor();" + NL + "                                _authorizationInterceptor.setPdpAddress(pepProps.getProperty(\"tesb.pdp.address\"));" + NL + "                                authorizationInterceptor = (org.apache.cxf.interceptor.Interceptor) _authorizationInterceptor;" + NL;
  protected final String TEXT_163 = NL + "                            } catch (Exception e) {" + NL + "                                throw new RuntimeException(\"Cannot load pep properties\", e);" + NL + "                            }" + NL + "" + NL + "                            Properties serviceProps = new Properties();" + NL + "                            java.io.InputStream serviceCfg = getConfigLocation(\"org.talend.esb.job.service.cfg\");" + NL + "" + NL + "                            try {" + NL + "                                    serviceProps.load(serviceCfg);" + NL + "                                securityProps = new HashMap<String, Object>();" + NL + "                                for (String key : serviceProps.stringPropertyNames()) {" + NL + "                                    securityProps.put(key, serviceProps.getProperty(key));" + NL + "                                }" + NL + "                            } catch (Exception e) {" + NL + "                                throw new RuntimeException(\"Cannot load service properties\", e);" + NL + "                            }";
  protected final String TEXT_164 = NL + NL + "                            if (null != securityProps) {" + NL + "                                org.talend.esb.security.saml.SAMLRESTUtils.configureServer(sf_";
  protected final String TEXT_165 = ", securityProps);";
  protected final String TEXT_166 = NL + "                                sf_";
  protected final String TEXT_167 = ".getInInterceptors().add(authorizationInterceptor);";
  protected final String TEXT_168 = NL + "                            }";
  protected final String TEXT_169 = NL + "                                // OpenID authentication" + NL + "                                new org.talend.esb.security.oidc.OidcClientUtils(getOidcSettings()); // get settings to use them by access token validator" + NL + "                                sf_";
  protected final String TEXT_170 = ".setProvider(new org.talend.esb.security.oidc.OidcAccessTokenValidator());";
  protected final String TEXT_171 = NL + "                    org.apache.cxf.jaxrs.swagger.Swagger2Feature swagger2Feature_";
  protected final String TEXT_172 = " = new org.apache.cxf.jaxrs.swagger.Swagger2Feature();" + NL + "                    swagger2Feature_";
  protected final String TEXT_173 = ".setScan(false);";
  protected final String TEXT_174 = NL + "                    swagger2Feature_";
  protected final String TEXT_175 = ".setBasePath(\"";
  protected final String TEXT_176 = "\");" + NL + "                    swagger2Feature_";
  protected final String TEXT_177 = ".setUsePathBasedConfig(true);" + NL + "                    swagger2Feature_";
  protected final String TEXT_178 = ".setRunAsFilter(true);" + NL + "                    swagger2Feature_";
  protected final String TEXT_179 = ".setSwaggerUiMavenGroupAndArtifact(\"org.talend.esb/swagger-ui\");" + NL + "                    swagger2Feature_";
  protected final String TEXT_180 = ".setTitle(\"";
  protected final String TEXT_181 = "\");" + NL + "                    swagger2Feature_";
  protected final String TEXT_182 = ".setDescription(\"";
  protected final String TEXT_183 = "\");" + NL + "                    swagger2Feature_";
  protected final String TEXT_184 = ".setContact(null);" + NL + "                    swagger2Feature_";
  protected final String TEXT_185 = ".setLicense(null);" + NL + "                    swagger2Feature_";
  protected final String TEXT_186 = ".setLicenseUrl(null);" + NL + "                    sf_";
  protected final String TEXT_187 = ".getFeatures().add(swagger2Feature_";
  protected final String TEXT_188 = ");";
  protected final String TEXT_189 = NL + "                    org.apache.cxf.jaxrs.client.JAXRSClientFactoryBean cf_";
  protected final String TEXT_190 = " = new org.apache.cxf.jaxrs.client.JAXRSClientFactoryBean() {" + NL + "                        // https://issues.apache.org/jira/browse/CAMEL-7229" + NL + "                        public void setBus(org.apache.cxf.Bus bus) {" + NL + "                            if (null == this.bus) {" + NL + "                                super.setBus(bus);" + NL + "                            }" + NL + "                        };" + NL;
  protected final String TEXT_191 = NL + "                            public org.apache.cxf.jaxrs.client.WebClient createWebClient(){" + NL + "                                org.apache.cxf.jaxrs.client.WebClient ws = super.createWebClient();" + NL + "                                org.apache.cxf.jaxrs.client.ClientConfiguration config = org.apache.cxf.jaxrs.client.WebClient" + NL + "                                        .getConfig(ws);" + NL + "                                org.apache.cxf.transport.http.HTTPConduit conduit = (org.apache.cxf.transport.http.HTTPConduit) config" + NL + "                                        .getConduit();" + NL + "" + NL + "                                String urlString = \"";
  protected final String TEXT_192 = "\";" + NL + "" + NL + "                                String configName = \"org.apache.cxf.http.conduits-\" + urlString + \".cfg\";" + NL + "                                java.util.Dictionary<String, String> dic = loadHttpConduitProperties(configName);" + NL + "                                HttpConduitConfigApplier configApplier = new HttpConduitConfigApplier();" + NL + "                                configApplier.apply(dic, conduit, ";
  protected final String TEXT_193 = ");" + NL + "                                return ws;" + NL + "                            }";
  protected final String TEXT_194 = NL + "                    };" + NL + "                    factory_";
  protected final String TEXT_195 = " = cf_";
  protected final String TEXT_196 = ";";
  protected final String TEXT_197 = NL + "                    cf_";
  protected final String TEXT_198 = ".setServiceClass(";
  protected final String TEXT_199 = ".class);";
  protected final String TEXT_200 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_201 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_202 = ");";
  protected final String TEXT_203 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_204 = " = ";
  protected final String TEXT_205 = "; ";
  protected final String TEXT_206 = NL + "                            cf_";
  protected final String TEXT_207 = ".setUsername(";
  protected final String TEXT_208 = ");" + NL + "                            cf_";
  protected final String TEXT_209 = ".setPassword(decryptedPassword_";
  protected final String TEXT_210 = ");";
  protected final String TEXT_211 = NL;
  protected final String TEXT_212 = NL + "                                Properties stsProperties = new Properties();" + NL + "                                java.io.InputStream stsCfg = getConfigLocation(\"org.talend.esb.job.client.sts.cfg\");" + NL + "" + NL + "                                try {" + NL + "                                    stsProperties.load(stsCfg);" + NL + "                                } catch (Exception e) {" + NL + "                                    throw new RuntimeException(\"Cannot load client properties\", e);" + NL + "                                }" + NL + "" + NL + "                                Map<String, String> stsProps = new HashMap<String, String>();" + NL + "                                for (Map.Entry<Object, Object> entry : stsProperties.entrySet()) {" + NL + "                                    stsProps.put((String)entry.getKey(), (String)entry.getValue());" + NL + "                                }" + NL + "" + NL + "                                new org.talend.esb.security.saml.STSClientUtils(stsProps);";
  protected final String TEXT_213 = NL + "                                if (!inOSGi) {" + NL + "                                    throw new IllegalArgumentException(\"SAML based security scenarios are not supported in Studio (standalone)\");" + NL + "                                }";
  protected final String TEXT_214 = NL + "                            org.apache.cxf.ws.security.trust.STSClient stsClient_";
  protected final String TEXT_215 = " =" + NL + "                                org.talend.esb.security.saml.STSClientUtils.createSTSClient(cf_";
  protected final String TEXT_216 = ".getBus(),";
  protected final String TEXT_217 = NL + "                                    ";
  protected final String TEXT_218 = ", decryptedPassword_";
  protected final String TEXT_219 = ");";
  protected final String TEXT_220 = NL + "                                org.talend.esb.security.saml.STSClientUtils.applyAuthorization(stsClient_";
  protected final String TEXT_221 = ", ";
  protected final String TEXT_222 = ");";
  protected final String TEXT_223 = NL + "                            org.talend.esb.security.saml.SAMLRESTUtils.configureClient(cf_";
  protected final String TEXT_224 = ", stsClient_";
  protected final String TEXT_225 = ");";
  protected final String TEXT_226 = NL;
  protected final String TEXT_227 = NL + "                    factory_";
  protected final String TEXT_228 = ".setAddress(";
  protected final String TEXT_229 = ");";
  protected final String TEXT_230 = NL + "                    factory_";
  protected final String TEXT_231 = ".setAddress(getCXFRSEndpointAddress(";
  protected final String TEXT_232 = "));";
  protected final String TEXT_233 = NL + "                factory_";
  protected final String TEXT_234 = ".setAddress(";
  protected final String TEXT_235 = ");";
  protected final String TEXT_236 = NL + "                    factory_";
  protected final String TEXT_237 = ".setServiceName(new javax.xml.namespace.QName(";
  protected final String TEXT_238 = NL + "                        ";
  protected final String TEXT_239 = ",";
  protected final String TEXT_240 = NL + "                        ";
  protected final String TEXT_241 = "));" + NL + "\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_242 = "\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\tinitLocator(camelContext);" + NL + "\t\t\t\t\t\t\t" + NL + "                            factory_";
  protected final String TEXT_243 = ".setAddress(\"locator://rest\");" + NL + "" + NL + "                            org.talend.esb.servicelocator.cxf.LocatorFeature locatorFeature_";
  protected final String TEXT_244 = " = getLocatorFeature(cf_";
  protected final String TEXT_245 = ".getBus());";
  protected final String TEXT_246 = NL + "\t\t\t\t\t\t\torg.talend.esb.servicelocator.cxf.LocatorFeature locatorFeature_";
  protected final String TEXT_247 = " = getLocatorFeature(sf_";
  protected final String TEXT_248 = ".getBus());";
  protected final String TEXT_249 = NL + NL + "                       ";
  protected final String TEXT_250 = NL + "\t\t\t\t\tjava.util.Map<String, String> slCustomProps_";
  protected final String TEXT_251 = " = new java.util.HashMap<String, String>();" + NL + "\t\t\t\t\t";
  protected final String TEXT_252 = NL + "                    \tslCustomProps_";
  protected final String TEXT_253 = ".put(";
  protected final String TEXT_254 = ", ";
  protected final String TEXT_255 = ");";
  protected final String TEXT_256 = NL + "\t\t\t\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_257 = NL + "                    \tif(cf_";
  protected final String TEXT_258 = ".getProperties() == null){" + NL + "                    \t\tcf_";
  protected final String TEXT_259 = ".setProperties(new java.util.HashMap<String, Object>());" + NL + "                    \t}" + NL + "" + NL + "\t\t\t\t\t\tcf_";
  protected final String TEXT_260 = ".getProperties().put(org.talend.esb.servicelocator.cxf.LocatorFeature.LOCATOR_PROPERTIES, slCustomProps_";
  protected final String TEXT_261 = ");";
  protected final String TEXT_262 = NL + "                    \tif(sf_";
  protected final String TEXT_263 = ".getProperties() == null){" + NL + "                    \t\tsf_";
  protected final String TEXT_264 = ".setProperties(new java.util.HashMap<String, Object>());" + NL + "                    \t}" + NL + "                    \t" + NL + "                    \tsf_";
  protected final String TEXT_265 = ".getProperties().put(org.talend.esb.servicelocator.cxf.LocatorFeature.LOCATOR_PROPERTIES, slCustomProps_";
  protected final String TEXT_266 = ");";
  protected final String TEXT_267 = NL + "                        factory_";
  protected final String TEXT_268 = ".getFeatures().add(locatorFeature_";
  protected final String TEXT_269 = ");";
  protected final String TEXT_270 = NL + "                    // {baseUri}cREST" + NL + "                    factory_";
  protected final String TEXT_271 = ".setServiceName(new javax.xml.namespace.QName(";
  protected final String TEXT_272 = ", \"cREST\"));";
  protected final String TEXT_273 = NL + "\t\t\t\t\t\t\torg.talend.esb.sam.agent.feature.EventFeature eventFeature_";
  protected final String TEXT_274 = " = getEventFeature(cf_";
  protected final String TEXT_275 = ".getBus());";
  protected final String TEXT_276 = NL + "\t\t\t\t\t\t\torg.talend.esb.sam.agent.feature.EventFeature eventFeature_";
  protected final String TEXT_277 = " = getEventFeature(sf_";
  protected final String TEXT_278 = ".getBus());";
  protected final String TEXT_279 = NL + NL + "\t\t\t\t\t" + NL + "                    if (eventFeature_";
  protected final String TEXT_280 = " != null) {" + NL + "                        factory_";
  protected final String TEXT_281 = ".getFeatures().add(eventFeature_";
  protected final String TEXT_282 = ");" + NL + "                    }";
  protected final String TEXT_283 = NL + "                    final String correlationId_";
  protected final String TEXT_284 = " = ";
  protected final String TEXT_285 = ";" + NL + "                    if (null != correlationId_";
  protected final String TEXT_286 = " && correlationId_";
  protected final String TEXT_287 = ".length() > 0) {" + NL + "                        correlationIDCallbackHandler_";
  protected final String TEXT_288 = ".setCorrelationId(correlationId_";
  protected final String TEXT_289 = ");" + NL + "                        factory_";
  protected final String TEXT_290 = ".getProperties(true).put(org.talend.esb.policy.correlation.feature.CorrelationIDFeature.CORRELATION_ID_CALLBACK_HANDLER, " + NL + "                            correlationIDCallbackHandler_";
  protected final String TEXT_291 = ");" + NL + "                    }" + NL + "                    factory_";
  protected final String TEXT_292 = ".getFeatures().add(new org.talend.esb.policy.correlation.feature.CorrelationIDFeature());";
  protected final String TEXT_293 = NL + "                registry.put(\"";
  protected final String TEXT_294 = "\", factory_";
  protected final String TEXT_295 = ");";
  protected final String TEXT_296 = NL + "                    registry.put(";
  protected final String TEXT_297 = ", new ";
  protected final String TEXT_298 = "(";
  protected final String TEXT_299 = "));";
  protected final String TEXT_300 = NL + "                {" + NL + "                    Object beanInstance = null;";
  protected final String TEXT_301 = NL + "                    ";
  protected final String TEXT_302 = NL + "                    if(beanInstance != null){" + NL + "                        registry.put(";
  protected final String TEXT_303 = ", beanInstance);" + NL + "                    }" + NL + "                }";
  protected final String TEXT_304 = NL + "                registry.put(";
  protected final String TEXT_305 = ", new ";
  protected final String TEXT_306 = "(";
  protected final String TEXT_307 = "));";
  protected final String TEXT_308 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_309 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_310 = ");";
  protected final String TEXT_311 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_312 = " = ";
  protected final String TEXT_313 = "; ";
  protected final String TEXT_314 = NL + "                        javax.jms.ConnectionFactory jmsConnectionFactory_";
  protected final String TEXT_315 = " =" + NL + "                            new org.apache.activemq.ActiveMQConnectionFactory( ";
  protected final String TEXT_316 = ", decryptedPassword_";
  protected final String TEXT_317 = " ,";
  protected final String TEXT_318 = ");";
  protected final String TEXT_319 = NL + "                                org.apache.activemq.ActiveMQConnectionFactory jmsConnectionFactory_";
  protected final String TEXT_320 = " =" + NL + "                                    new org.apache.activemq.ActiveMQConnectionFactory(";
  protected final String TEXT_321 = ");" + NL + "                                jmsConnectionFactory_";
  protected final String TEXT_322 = ".setUseRetroactiveConsumer(true);";
  protected final String TEXT_323 = NL + "                                javax.jms.ConnectionFactory jmsConnectionFactory_";
  protected final String TEXT_324 = " =" + NL + "                                    new org.apache.activemq.ActiveMQConnectionFactory(";
  protected final String TEXT_325 = ");";
  protected final String TEXT_326 = NL;
  protected final String TEXT_327 = NL + "                        org.apache.activemq.pool.PooledConnectionFactory pooledConnectionFactory_";
  protected final String TEXT_328 = " " + NL + "                            = new org.apache.activemq.pool.PooledConnectionFactory();" + NL + "                        pooledConnectionFactory_";
  protected final String TEXT_329 = ".setConnectionFactory(jmsConnectionFactory_";
  protected final String TEXT_330 = ");" + NL + "                        pooledConnectionFactory_";
  protected final String TEXT_331 = ".setExpiryTimeout(Long.valueOf(";
  protected final String TEXT_332 = "));" + NL + "                        pooledConnectionFactory_";
  protected final String TEXT_333 = ".setIdleTimeout(";
  protected final String TEXT_334 = ");" + NL + "                        pooledConnectionFactory_";
  protected final String TEXT_335 = ".setMaxConnections(";
  protected final String TEXT_336 = ");" + NL + "                        pooledConnectionFactory_";
  protected final String TEXT_337 = ".setMaximumActiveSessionPerConnection(";
  protected final String TEXT_338 = ");" + NL + "" + NL + "                        if(camelContext.getComponent(";
  protected final String TEXT_339 = ")==null){" + NL + "                                                    camelContext.addComponent(";
  protected final String TEXT_340 = "," + NL + "                            org.apache.camel.component.jms.JmsComponent.jmsComponent";
  protected final String TEXT_341 = "(pooledConnectionFactory_";
  protected final String TEXT_342 = "));   " + NL + "                        }" + NL + " ";
  protected final String TEXT_343 = NL + "                        if(camelContext.getComponent(";
  protected final String TEXT_344 = ")==null){" + NL + "                            camelContext.addComponent(";
  protected final String TEXT_345 = "," + NL + "                                org.apache.camel.component.jms.JmsComponent.jmsComponent";
  protected final String TEXT_346 = "(jmsConnectionFactory_";
  protected final String TEXT_347 = "));" + NL + "                            }";
  protected final String TEXT_348 = NL + "                    {" + NL + "                    javax.jms.ConnectionFactory jmsConnectionFactory = new com.ibm.mq.jms.MQQueueConnectionFactory();" + NL + "                    ((com.ibm.mq.jms.MQConnectionFactory) jmsConnectionFactory).setHostName(";
  protected final String TEXT_349 = ");" + NL + "                    try {" + NL + "                        ((com.ibm.mq.jms.MQConnectionFactory) jmsConnectionFactory).setPort(";
  protected final String TEXT_350 = ");" + NL + "                        // ((com.ibm.mq.jms.MQConnectionFactory) jmsConnectionFactory).setCCSID(866);" + NL + "                        ((com.ibm.mq.jms.MQConnectionFactory) jmsConnectionFactory).setTransportType(";
  protected final String TEXT_351 = ");" + NL + "                        ((com.ibm.mq.jms.MQConnectionFactory) jmsConnectionFactory).setQueueManager(";
  protected final String TEXT_352 = ");";
  protected final String TEXT_353 = NL + "                            ((com.ibm.mq.jms.MQConnectionFactory) jmsConnectionFactory).setChannel(";
  protected final String TEXT_354 = ");";
  protected final String TEXT_355 = NL + NL + "                    } catch (javax.jms.JMSException e) {" + NL + "                        e.printStackTrace();" + NL + "                    }";
  protected final String TEXT_356 = NL + "                    if(camelContext.getComponent(";
  protected final String TEXT_357 = ")==null){" + NL + "                        camelContext.addComponent(";
  protected final String TEXT_358 = "," + NL + "                            org.apache.camel.component.jms.JmsComponent.jmsComponent";
  protected final String TEXT_359 = "(jmsConnectionFactory));" + NL + "                    }";
  protected final String TEXT_360 = NL + "                    org.springframework.jms.connection.UserCredentialsConnectionFactoryAdapter connectionFactoryAdapter";
  protected final String TEXT_361 = " " + NL + "                            = new org.springframework.jms.connection.UserCredentialsConnectionFactoryAdapter();" + NL + "                    connectionFactoryAdapter";
  protected final String TEXT_362 = ".setUsername(";
  protected final String TEXT_363 = ");" + NL;
  protected final String TEXT_364 = NL;
  protected final String TEXT_365 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_366 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_367 = ");";
  protected final String TEXT_368 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_369 = " = ";
  protected final String TEXT_370 = "; ";
  protected final String TEXT_371 = NL + NL + "                    connectionFactoryAdapter";
  protected final String TEXT_372 = ".setPassword(decryptedPassword_";
  protected final String TEXT_373 = ");" + NL + "                    connectionFactoryAdapter";
  protected final String TEXT_374 = ".setTargetConnectionFactory(jmsConnectionFactory);" + NL + "" + NL + "                    if(camelContext.getComponent(";
  protected final String TEXT_375 = ")==null){" + NL + "                        camelContext.addComponent(";
  protected final String TEXT_376 = "," + NL + "                            org.apache.camel.component.jms.JmsComponent.jmsComponent";
  protected final String TEXT_377 = "(connectionFactoryAdapter";
  protected final String TEXT_378 = "));" + NL + "                    }";
  protected final String TEXT_379 = NL + "                    }";
  protected final String TEXT_380 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_381 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_382 = ");";
  protected final String TEXT_383 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_384 = " = ";
  protected final String TEXT_385 = "; ";
  protected final String TEXT_386 = NL + "                    if(camelContext.getComponent(";
  protected final String TEXT_387 = ")==null){" + NL + "                        camelContext.addComponent(";
  protected final String TEXT_388 = "," + NL + "                                new org.apache.camel.component.amqp.AMQPComponent(org.apache.qpid.amqp_1_0.jms.impl.ConnectionFactoryImpl.createFromURL(";
  protected final String TEXT_389 = ")));" + NL + "                    }" + NL + "                    //((org.apache.camel.component.amqp.AMQPComponent) camelContext.getComponent(";
  protected final String TEXT_390 = ")).getConfiguration().setClientId(\"";
  protected final String TEXT_391 = "\" + java.util.UUID.randomUUID().toString());";
  protected final String TEXT_392 = NL + "                     org.apache.camel.component.mqtt.MQTTComponent mqttComponent_";
  protected final String TEXT_393 = " = new org.apache.camel.component.mqtt.MQTTComponent(){" + NL + "                         @Override" + NL + "                            protected org.apache.camel.Endpoint createEndpoint(String uri, String remaining, Map<String, Object> parameters) throws Exception {" + NL + "                             org.apache.camel.component.mqtt.MQTTEndpoint endpoint = " + NL + "                                     (org.apache.camel.component.mqtt.MQTTEndpoint) super.createEndpoint(uri, remaining, parameters);" + NL + "                             org.apache.camel.component.mqtt.MQTTConfiguration config = endpoint.getConfiguration();";
  protected final String TEXT_394 = NL + "                    {";
  protected final String TEXT_395 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_396 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_397 = ");";
  protected final String TEXT_398 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_399 = " = ";
  protected final String TEXT_400 = "; ";
  protected final String TEXT_401 = NL + "                    config.setPassword(decryptedPassword_";
  protected final String TEXT_402 = ");" + NL + "                    }" + NL + "                    config.setUserName(";
  protected final String TEXT_403 = ");";
  protected final String TEXT_404 = NL + "                            config.setHost(";
  protected final String TEXT_405 = ");" + NL + "                            config.setConnectAttemptsMax(";
  protected final String TEXT_406 = ");" + NL + "                            config.setReconnectAttemptsMax(";
  protected final String TEXT_407 = ");" + NL + "                            config.setReconnectDelay(";
  protected final String TEXT_408 = ");" + NL + "                            config.setQualityOfService(\"";
  protected final String TEXT_409 = "\");" + NL + "                            config.setConnectWaitInSeconds(";
  protected final String TEXT_410 = ");" + NL + "                            config.setDisconnectWaitInSeconds(";
  protected final String TEXT_411 = ");" + NL + "                            config.setSendWaitInSeconds(";
  protected final String TEXT_412 = ");";
  protected final String TEXT_413 = NL + "                                javax.net.ssl.TrustManagerFactory tmf = javax.net.ssl.TrustManagerFactory" + NL + "                                .getInstance(javax.net.ssl.TrustManagerFactory" + NL + "                                        .getDefaultAlgorithm());" + NL + "" + NL + "                                java.io.FileInputStream fis = new java.io.FileInputStream(";
  protected final String TEXT_414 = NL + "                                        ";
  protected final String TEXT_415 = ");" + NL + "                                java.security.KeyStore ks = java.security.KeyStore" + NL + "                                        .getInstance(java.security.KeyStore.getDefaultType());";
  protected final String TEXT_416 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_417 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_418 = ");";
  protected final String TEXT_419 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_420 = " = ";
  protected final String TEXT_421 = "; ";
  protected final String TEXT_422 = NL + "                       " + NL + "                                ks.load(fis, decryptedPassword_";
  protected final String TEXT_423 = ".toCharArray());" + NL + "                                fis.close();" + NL + "                                tmf.init(ks);" + NL + "" + NL + "                                javax.net.ssl.KeyManagerFactory kmf = javax.net.ssl.KeyManagerFactory" + NL + "                                .getInstance(javax.net.ssl.KeyManagerFactory" + NL + "                                        .getDefaultAlgorithm());" + NL + "" + NL + "                                java.io.FileInputStream kfis = new java.io.FileInputStream(";
  protected final String TEXT_424 = NL + "                                        ";
  protected final String TEXT_425 = ");" + NL + "                                java.security.KeyStore kks = java.security.KeyStore" + NL + "                                        .getInstance(java.security.KeyStore.getDefaultType());";
  protected final String TEXT_426 = NL;
  protected final String TEXT_427 = " " + NL + "                                    String kDecryptedPassword_";
  protected final String TEXT_428 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_429 = ");";
  protected final String TEXT_430 = NL + "                                    String kDecryptedPassword_";
  protected final String TEXT_431 = " = ";
  protected final String TEXT_432 = "; ";
  protected final String TEXT_433 = NL + "                                kks.load(kfis, kDecryptedPassword_";
  protected final String TEXT_434 = ".toCharArray());" + NL + "                                kfis.close();" + NL + "                                kmf.init(kks, kDecryptedPassword_";
  protected final String TEXT_435 = ".toCharArray());" + NL + "" + NL + "                                javax.net.ssl.SSLContext sslContext = javax.net.ssl.SSLContext.getInstance(\"SSL\");" + NL + "                                sslContext.init(kmf.getKeyManagers(), tmf.getTrustManagers(), new java.security.SecureRandom());" + NL + "                                config.setSslContext(sslContext);";
  protected final String TEXT_436 = NL + "                            return endpoint;" + NL + "                        }" + NL + "                     };" + NL + "                    if(camelContext.getComponent(";
  protected final String TEXT_437 = ")==null){" + NL + "                        camelContext.addComponent(";
  protected final String TEXT_438 = ", mqttComponent_";
  protected final String TEXT_439 = ");" + NL + "                    }";
  protected final String TEXT_440 = NL + "                    {" + NL + "                        javax.jms.ConnectionFactory jmsConnectionFactory;";
  protected final String TEXT_441 = NL + "                        ";
  protected final String TEXT_442 = NL + "                        if(camelContext.getComponent(";
  protected final String TEXT_443 = ")==null){" + NL + "                            camelContext.addComponent(";
  protected final String TEXT_444 = "," + NL + "                                org.apache.camel.component.jms.JmsComponent.jmsComponent";
  protected final String TEXT_445 = "(jmsConnectionFactory));" + NL + "                        }" + NL + "                    }";
  protected final String TEXT_446 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_447 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_448 = ");";
  protected final String TEXT_449 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_450 = " = ";
  protected final String TEXT_451 = "; ";
  protected final String TEXT_452 = NL + "                // CXF endpoint for ";
  protected final String TEXT_453 = NL + "                org.apache.camel.component.cxf.CxfEndpoint ";
  protected final String TEXT_454 = " = getCxfEndpoint(";
  protected final String TEXT_455 = ", ";
  protected final String TEXT_456 = ", ";
  protected final String TEXT_457 = ", ";
  protected final String TEXT_458 = ", ";
  protected final String TEXT_459 = NL + "                            ,";
  protected final String TEXT_460 = ",decryptedPassword_";
  protected final String TEXT_461 = ", ";
  protected final String TEXT_462 = ", ";
  protected final String TEXT_463 = NL + "                        );" + NL + "                        ";
  protected final String TEXT_464 = NL + "                        \t\t";
  protected final String TEXT_465 = ".getFeatures().add(new org.apache.cxf.transport.common.gzip.GZIPFeature());";
  protected final String TEXT_466 = NL + "                ";
  protected final String TEXT_467 = ".setCxfBinding(new CXFConsumerBinding(";
  protected final String TEXT_468 = "));";
  protected final String TEXT_469 = NL + "                final String correlationId_";
  protected final String TEXT_470 = " = ";
  protected final String TEXT_471 = ";" + NL + "                if (null != correlationId_";
  protected final String TEXT_472 = " && correlationId_";
  protected final String TEXT_473 = ".length() > 0) {" + NL + "                    correlationIDCallbackHandler_";
  protected final String TEXT_474 = ".setCorrelationId(correlationId_";
  protected final String TEXT_475 = ");" + NL + "                    java.util.Map<String, Object> properties = new java.util.HashMap<String, Object>();" + NL + "                    properties.put(org.talend.esb.policy.correlation.feature.CorrelationIDFeature.CORRELATION_ID_CALLBACK_HANDLER, " + NL + "                        correlationIDCallbackHandler_";
  protected final String TEXT_476 = ");";
  protected final String TEXT_477 = NL + "                    ";
  protected final String TEXT_478 = ".setProperties(properties);" + NL + "                }";
  protected final String TEXT_479 = NL + "                    ";
  protected final String TEXT_480 = ".getFeatures().add(new org.talend.esb.policy.correlation.feature.CorrelationIDFeature());";
  protected final String TEXT_481 = NL + "\t\t\t\t\tinitLocator(camelContext);";
  protected final String TEXT_482 = NL + "                    ";
  protected final String TEXT_483 = ".setAddress(\"locator://cSOAP\");";
  protected final String TEXT_484 = NL + "                // Add Service Locator Service to ";
  protected final String TEXT_485 = NL + "                        ";
  protected final String TEXT_486 = ".setBus(springBus());";
  protected final String TEXT_487 = NL + "                        ";
  protected final String TEXT_488 = ".setBus(new org.apache.cxf.bus.spring.SpringBusFactory().createBus(\"META-INF/tesb/locator/beans.xml\"));";
  protected final String TEXT_489 = NL + "                    if (!inOSGi) {";
  protected final String TEXT_490 = NL + "                        ";
  protected final String TEXT_491 = ".setBus(new org.apache.cxf.bus.spring.SpringBusFactory().createBus(\"META-INF/tesb/locator/beans.xml\"));" + NL + "                    }";
  protected final String TEXT_492 = NL + "                " + NL + "                org.talend.esb.servicelocator.cxf.LocatorFeature locatorFeature_";
  protected final String TEXT_493 = " = getLocatorFeature(";
  protected final String TEXT_494 = ".getBus());" + NL + "                ";
  protected final String TEXT_495 = NL + "\t                java.util.Map<String, String> slCustomProps_";
  protected final String TEXT_496 = " = new java.util.HashMap<String, String>();" + NL + "\t                ";
  protected final String TEXT_497 = NL + "\t                    slCustomProps_";
  protected final String TEXT_498 = ".put(";
  protected final String TEXT_499 = ", ";
  protected final String TEXT_500 = ");" + NL + "\t                ";
  protected final String TEXT_501 = NL + "\t" + NL + "\t                java.util.Map<String, Object> endpointProps_";
  protected final String TEXT_502 = " = ";
  protected final String TEXT_503 = ".getProperties();" + NL + "\t                if (endpointProps_";
  protected final String TEXT_504 = " == null) {" + NL + "\t                    endpointProps_";
  protected final String TEXT_505 = " = new java.util.HashMap<String, Object>();" + NL + "\t                }" + NL + "\t                endpointProps_";
  protected final String TEXT_506 = ".put(org.talend.esb.servicelocator.cxf.LocatorFeature.LOCATOR_PROPERTIES, slCustomProps_";
  protected final String TEXT_507 = ");" + NL + "\t                ";
  protected final String TEXT_508 = ".setProperties(endpointProps_";
  protected final String TEXT_509 = ");";
  protected final String TEXT_510 = NL;
  protected final String TEXT_511 = NL + "                ";
  protected final String TEXT_512 = ".getFeatures().add(locatorFeature_";
  protected final String TEXT_513 = ");";
  protected final String TEXT_514 = NL + "                    java.util.Map<String, String> slCustomProps_";
  protected final String TEXT_515 = " = new java.util.HashMap<String, String>();";
  protected final String TEXT_516 = NL + "                        slCustomProps_";
  protected final String TEXT_517 = ".put(";
  protected final String TEXT_518 = ", ";
  protected final String TEXT_519 = ");";
  protected final String TEXT_520 = NL + NL + "                    java.util.Map<String, Object> endpointProps_";
  protected final String TEXT_521 = " = ";
  protected final String TEXT_522 = ".getProperties();" + NL + "                    if (endpointProps_";
  protected final String TEXT_523 = " == null) {" + NL + "                        endpointProps_";
  protected final String TEXT_524 = " = new java.util.HashMap<String, Object>();" + NL + "                    }" + NL + "                    endpointProps_";
  protected final String TEXT_525 = ".put(org.talend.esb.servicelocator.cxf.LocatorFeature.LOCATOR_PROPERTIES, slCustomProps_";
  protected final String TEXT_526 = ");";
  protected final String TEXT_527 = NL + "                    ";
  protected final String TEXT_528 = ".setProperties(endpointProps_";
  protected final String TEXT_529 = ");";
  protected final String TEXT_530 = NL + "            //http://jira.talendforge.org/browse/TESB-3850" + NL + "            // !\"true\".equals(useRegistry) - https://jira.talendforge.org/browse/TESB-10725";
  protected final String TEXT_531 = NL + "                // Add Service Activity Monitor Service to ";
  protected final String TEXT_532 = NL + "                " + NL + "                org.talend.esb.sam.agent.feature.EventFeature eventFeature_";
  protected final String TEXT_533 = " = getEventFeature(";
  protected final String TEXT_534 = ".getBus());" + NL + "                " + NL + "                if (eventFeature_";
  protected final String TEXT_535 = " != null) {";
  protected final String TEXT_536 = NL + "                    ";
  protected final String TEXT_537 = ".getFeatures().add(eventFeature_";
  protected final String TEXT_538 = ");" + NL + "                }" + NL + "                ";
  protected final String TEXT_539 = "\t\t\t" + NL + "                // Avoid using Service Registry for Service Consumer (TESB-19181)" + NL + "                if (";
  protected final String TEXT_540 = ".getProperties() == null) {";
  protected final String TEXT_541 = NL + "                        ";
  protected final String TEXT_542 = ".setProperties(new java.util.HashMap<String, Object>());" + NL + "                }";
  protected final String TEXT_543 = NL + "                ";
  protected final String TEXT_544 = ".getProperties().put(\"use.service.registry\", \"false\");";
  protected final String TEXT_545 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_546 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_547 = ");";
  protected final String TEXT_548 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_549 = " = ";
  protected final String TEXT_550 = "; ";
  protected final String TEXT_551 = NL;
  protected final String TEXT_552 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_553 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_554 = ");";
  protected final String TEXT_555 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_556 = " = ";
  protected final String TEXT_557 = "; ";
  protected final String TEXT_558 = NL;
  protected final String TEXT_559 = NL + "                        org.apache.camel.spi.AggregationRepository repo_";
  protected final String TEXT_560 = " = new ";
  protected final String TEXT_561 = ";";
  protected final String TEXT_562 = NL + "                        org.apache.camel.spi.RecoverableAggregationRepository repo_";
  protected final String TEXT_563 = " = new ";
  protected final String TEXT_564 = ";";
  protected final String TEXT_565 = NL + "                            repo_";
  protected final String TEXT_566 = ".setUseRecovery(true);" + NL + "                            repo_";
  protected final String TEXT_567 = ".setMaximumRedeliveries(";
  protected final String TEXT_568 = ");" + NL + "                            repo_";
  protected final String TEXT_569 = ".setDeadLetterUri(";
  protected final String TEXT_570 = ");" + NL + "                            repo_";
  protected final String TEXT_571 = ".setRecoveryInterval(";
  protected final String TEXT_572 = ");";
  protected final String TEXT_573 = NL + "                            org.apache.camel.component.hawtdb.HawtDBAggregationRepository repo_";
  protected final String TEXT_574 = " = new org.apache.camel.component.hawtdb.HawtDBAggregationRepository(\"";
  protected final String TEXT_575 = "\", ";
  protected final String TEXT_576 = ");";
  protected final String TEXT_577 = NL + "                            org.apache.camel.component.hawtdb.HawtDBAggregationRepository repo_";
  protected final String TEXT_578 = " = new org.apache.camel.component.hawtdb.HawtDBAggregationRepository(\"";
  protected final String TEXT_579 = "\");";
  protected final String TEXT_580 = NL + "                            repo_";
  protected final String TEXT_581 = ".setUseRecovery(true);" + NL + "                            repo_";
  protected final String TEXT_582 = ".setMaximumRedeliveries(";
  protected final String TEXT_583 = ");" + NL + "                            repo_";
  protected final String TEXT_584 = ".setDeadLetterUri(";
  protected final String TEXT_585 = ");" + NL + "                            repo_";
  protected final String TEXT_586 = ".setRecoveryInterval(";
  protected final String TEXT_587 = ");";
  protected final String TEXT_588 = NL + "                Map<String, String> ";
  protected final String TEXT_589 = "NSMap = new HashMap<String, String>();" + NL + "                {";
  protected final String TEXT_590 = NL + "                        ";
  protected final String TEXT_591 = "NSMap.put(";
  protected final String TEXT_592 = ", ";
  protected final String TEXT_593 = ");";
  protected final String TEXT_594 = NL + "                }";
  protected final String TEXT_595 = NL + "        Map<String, String> ";
  protected final String TEXT_596 = "NSMap = new HashMap<String, String>();" + NL + "        {";
  protected final String TEXT_597 = NL + "                ";
  protected final String TEXT_598 = "NSMap.put(";
  protected final String TEXT_599 = ", ";
  protected final String TEXT_600 = ");";
  protected final String TEXT_601 = NL + "        }";
  protected final String TEXT_602 = NL + "            Map<String,String> ";
  protected final String TEXT_603 = "userDefinedHeaders = new HashMap<String,String>();";
  protected final String TEXT_604 = NL + "                ";
  protected final String TEXT_605 = "userDefinedHeaders.put(";
  protected final String TEXT_606 = ",";
  protected final String TEXT_607 = ");";
  protected final String TEXT_608 = NL + "                    java.util.List<String> ";
  protected final String TEXT_609 = "tos = java.util.Arrays.asList(";
  protected final String TEXT_610 = ".split(\",\"));";
  protected final String TEXT_611 = NL + "                    java.util.List<String> ";
  protected final String TEXT_612 = "replyToAddresses = java.util.Arrays.asList(";
  protected final String TEXT_613 = ".split(\",\"));";
  protected final String TEXT_614 = NL + "                Map<String, String> ";
  protected final String TEXT_615 = "NSMap = new HashMap<String, String>();" + NL + "                {";
  protected final String TEXT_616 = NL + "                ";
  protected final String TEXT_617 = "NSMap.put(";
  protected final String TEXT_618 = ", ";
  protected final String TEXT_619 = ");";
  protected final String TEXT_620 = NL + "                }";
  protected final String TEXT_621 = NL + "        Map<String, String> ";
  protected final String TEXT_622 = "NSMap = new HashMap<String, String>();" + NL + "        {";
  protected final String TEXT_623 = NL + "                ";
  protected final String TEXT_624 = "NSMap.put(";
  protected final String TEXT_625 = ", ";
  protected final String TEXT_626 = ");";
  protected final String TEXT_627 = NL + "        }";
  protected final String TEXT_628 = NL + "        Map<String, String> ";
  protected final String TEXT_629 = "NSMap = new HashMap<String, String>();" + NL + "        {";
  protected final String TEXT_630 = NL + "                ";
  protected final String TEXT_631 = "NSMap.put(";
  protected final String TEXT_632 = ", ";
  protected final String TEXT_633 = ");";
  protected final String TEXT_634 = NL + "        }";
  protected final String TEXT_635 = NL + "            camelContext.setStreamCaching(true);";
  protected final String TEXT_636 = NL + "        org.apache.camel.builder.xml.Namespaces ";
  protected final String TEXT_637 = "ns = ";
  protected final String TEXT_638 = NL + "                ";
  protected final String TEXT_639 = "(";
  protected final String TEXT_640 = ", ";
  protected final String TEXT_641 = ");";
  protected final String TEXT_642 = NL + "        org.talend.camel.TalendEndpoint endpoint_";
  protected final String TEXT_643 = " =" + NL + "            (org.talend.camel.TalendEndpoint) endpoint(\"talend:\" + ";
  protected final String TEXT_644 = " + \"?context=\" + ";
  protected final String TEXT_645 = " + \"&propagateHeader=";
  protected final String TEXT_646 = "&sticky=";
  protected final String TEXT_647 = "&componentId=";
  protected final String TEXT_648 = "\");";
  protected final String TEXT_649 = NL + "            org.talend.camel.TalendEndpoint endpoint_";
  protected final String TEXT_650 = " =" + NL + "                (org.talend.camel.TalendEndpoint) endpoint(\"talend:";
  protected final String TEXT_651 = "/";
  protected final String TEXT_652 = "?context=\" + ";
  protected final String TEXT_653 = " + \"&propagateHeader=";
  protected final String TEXT_654 = "&sticky=";
  protected final String TEXT_655 = "&componentId=";
  protected final String TEXT_656 = "\");";
  protected final String TEXT_657 = NL + "            org.talend.camel.TalendEndpoint endpoint_";
  protected final String TEXT_658 = " =" + NL + "                (org.talend.camel.TalendEndpoint) endpoint(\"talend:";
  protected final String TEXT_659 = "/";
  protected final String TEXT_660 = "?context=";
  protected final String TEXT_661 = "&propagateHeader=";
  protected final String TEXT_662 = "&sticky=";
  protected final String TEXT_663 = "&componentId=";
  protected final String TEXT_664 = "\");";
  protected final String TEXT_665 = NL + "{" + NL + "        Map <String, String> propertiesMap = new HashMap<String, String>();";
  protected final String TEXT_666 = NL + "                propertiesMap.put(";
  protected final String TEXT_667 = ", propertyToString(";
  protected final String TEXT_668 = "));";
  protected final String TEXT_669 = NL + "        endpoint_";
  protected final String TEXT_670 = ".setEndpointProperties(propertiesMap);" + NL + "}";
  protected final String TEXT_671 = NL + "        log.info(\"";
  protected final String TEXT_672 = " - Creating new connection.\");";
  protected final String TEXT_673 = NL + "        com.amazonaws.auth.AWSCredentialsProvider credentials_";
  protected final String TEXT_674 = " = new com.amazonaws.auth.InstanceProfileCredentialsProvider();";
  protected final String TEXT_675 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_676 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_677 = ");";
  protected final String TEXT_678 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_679 = " = ";
  protected final String TEXT_680 = "; ";
  protected final String TEXT_681 = NL + "        com.amazonaws.auth.AWSCredentials credentials_";
  protected final String TEXT_682 = " = new com.amazonaws.auth.BasicAWSCredentials(";
  protected final String TEXT_683 = ",decryptedPassword_";
  protected final String TEXT_684 = ");";
  protected final String TEXT_685 = NL + "        com.amazonaws.ClientConfiguration clientConfig_";
  protected final String TEXT_686 = " = new com.amazonaws.ClientConfiguration();";
  protected final String TEXT_687 = NL + "                int socketSendBufferSizeHints_";
  protected final String TEXT_688 = " = 0;" + NL + "                int socketReceiveBufferSizeHints_";
  protected final String TEXT_689 = " = 0;";
  protected final String TEXT_690 = NL + "                socketSendBufferSizeHints_";
  protected final String TEXT_691 = " = ";
  protected final String TEXT_692 = ";";
  protected final String TEXT_693 = NL + "                socketReceiveBufferSizeHints_";
  protected final String TEXT_694 = " = ";
  protected final String TEXT_695 = ";";
  protected final String TEXT_696 = NL + "                clientConfig_";
  protected final String TEXT_697 = ".setProtocol(com.amazonaws.Protocol.";
  protected final String TEXT_698 = ");";
  protected final String TEXT_699 = NL + "                clientConfig_";
  protected final String TEXT_700 = ".set";
  protected final String TEXT_701 = "(";
  protected final String TEXT_702 = ");";
  protected final String TEXT_703 = NL + "            clientConfig_";
  protected final String TEXT_704 = ".setSocketBufferSizeHints(socketSendBufferSizeHints_";
  protected final String TEXT_705 = ",socketReceiveBufferSizeHints_";
  protected final String TEXT_706 = ");";
  protected final String TEXT_707 = NL + "                    ";
  protected final String TEXT_708 = " ";
  protected final String TEXT_709 = " = new ";
  protected final String TEXT_710 = "(credentials_";
  protected final String TEXT_711 = ", clientConfig_";
  protected final String TEXT_712 = ");";
  protected final String TEXT_713 = NL + "                    ";
  protected final String TEXT_714 = " ";
  protected final String TEXT_715 = " = new ";
  protected final String TEXT_716 = "(credentials_";
  protected final String TEXT_717 = ");";
  protected final String TEXT_718 = NL + "                    ";
  protected final String TEXT_719 = ".setRegion(com.amazonaws.regions.RegionUtils.getRegion(";
  protected final String TEXT_720 = "));";
  protected final String TEXT_721 = NL + "                    registry.put(\"";
  protected final String TEXT_722 = "\", ";
  protected final String TEXT_723 = ");";
  protected final String TEXT_724 = "\t" + NL + "                    log.info(\"";
  protected final String TEXT_725 = " - Creating new connection successfully.\");";
  protected final String TEXT_726 = NL;

    public static java.util.Collection<String> getRoutelets(final org.talend.core.model.process.IProcess process) {
        java.util.Collection<String> routelets = new java.util.HashSet<String>();
        addRoutelets(routelets, process);
        return routelets;
    }

    private static void addRoutelets(final java.util.Collection<String> routelets, final org.talend.core.model.process.IProcess process) {
        for (org.talend.core.model.process.INode node : process.getGeneratingNodes()) {
            if ("Routelets".equals(node.getComponent().getOriginalFamilyName())) {
                org.talend.core.model.process.IProcess2 routelet = (org.talend.core.model.process.IProcess2) node.getComponent().getProcess();
                final String clazz = org.talend.core.model.utils.RouteUtil.resolveClassName(routelet);
                if (routelets.add(clazz)) {
                    addRoutelets(routelets, routelet);
                }
            }
        }
    }

	static boolean routeContextCodeGenerated = false;
	
	public static boolean hasRouteletComponent(final org.talend.core.model.process.IProcess process){
		for (org.talend.core.model.process.INode node : process.getGeneratingNodes()) {
            if ("Routelets".equals(node.getComponent().getOriginalFamilyName())) {
            	return true;
            }
        }
		return false;
	}

	public static String generateAddRouteletMethod(final org.talend.core.model.process.IProcess process){
		if(hasRouteletComponent(process)){
			routeContextCodeGenerated = false;
			StringBuilder code = new StringBuilder("private void addRoutelets(org.apache.camel.main.Main main) throws Exception{\n");
			addRouteletsWithContext(process, code);
			return code.append("}\n").toString();
		}else{
			return "";
		}
	}
	
	public static String generateAddRoutesMethod(final org.talend.core.model.process.IProcess process){
		StringBuilder code = new StringBuilder();
        for (org.talend.core.model.process.INode node : process.getGeneratingNodes()) {
            if ("Routelets".equals(node.getComponent().getOriginalFamilyName())) {
	            boolean useSelected = "true".equals(ElementParameterParser.getValue(node, "__SELECTED_CONTEXT__"));
	            boolean useRoute    = "true".equals(ElementParameterParser.getValue(node, "__ROUTE_CONTEXT__"));
	            List<Map<String,String>> userDefinedParams = useSelected ? (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__CONTEXT_PARAM__")
	            	: useRoute ? (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__ROUTE_CONTEXT_PARAM__") : null;
	            org.talend.core.model.process.IProcess2 routelet = (org.talend.core.model.process.IProcess2) node.getComponent().getProcess();
	            final String routeletClass = org.talend.core.model.utils.RouteUtil.resolveClassName(routelet);
	            final String instanceName = routeletClass.substring(routeletClass.lastIndexOf('.')+1);
	            code.append(routeletClass +" "+ instanceName +"=new "+ routeletClass+ "();\n");
	            if(useRoute){
	            	if(!routeContextCodeGenerated){
	            		routeContextCodeGenerated=true;
				        code.append("final Map<String, String> routeContext = new HashMap<String, String>();\n" + 
			                "readContextValues(contextStr);\n" + 
			                "for (java.util.Map.Entry<Object, Object> entry : context.entrySet()) {\n" + 
			                "    routeContext.put((String) entry.getKey(), (String) entry.getValue());\n" + 
			                "}\n");
	            	}
	            	code.append(instanceName +".setArguments(routeContext);\n");
	            }else if(useSelected){
	            	//do nothing
	            }
	            if(userDefinedParams!=null && userDefinedParams.size()>0){
	            	code.append("final Map<String, String> overwriteContext_"+instanceName+" = new HashMap<String, String>();\n"); 
	            	for(Map<String,String> map :userDefinedParams){
	            		code.append("overwriteContext_"+instanceName+".put(\""+map.get("Parameters")+"\", "+map.get("Values")+");\n"); 
	            	}
	            	code.append(instanceName +".setArguments(overwriteContext_"+instanceName+");\n");
	            }

	            code.append("camelContext.addRoutes("+instanceName+");");
            }
        }
        
        return code.toString();
    }

    private static void addRouteletsWithContext(final org.talend.core.model.process.IProcess process, StringBuilder code){
        for (org.talend.core.model.process.INode node : process.getGeneratingNodes()) {
            if ("Routelets".equals(node.getComponent().getOriginalFamilyName())) {
	            boolean useSelected = "true".equals(ElementParameterParser.getValue(node, "__SELECTED_CONTEXT__"));
	            boolean useRoute    = "true".equals(ElementParameterParser.getValue(node, "__ROUTE_CONTEXT__"));
	            List<Map<String,String>> userDefinedParams = useSelected ? (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__CONTEXT_PARAM__")
	            	: useRoute ? (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__ROUTE_CONTEXT_PARAM__") : null;
	            org.talend.core.model.process.IProcess2 routelet = (org.talend.core.model.process.IProcess2) node.getComponent().getProcess();
	            final String routeletClass = org.talend.core.model.utils.RouteUtil.resolveClassName(routelet);
	            final String instanceName = routeletClass.substring(routeletClass.lastIndexOf('.')+1);
	            code.append(routeletClass +" "+ instanceName +"=new "+ routeletClass+ "(){@Override\n public void configure() throws java.lang.Exception {this.doConfig();}};\n");
	            if(useRoute){
	            	if(!routeContextCodeGenerated){
	            		routeContextCodeGenerated=true;
				        code.append("final Map<String, String> routeContext = new HashMap<String, String>();\n" + 
			                "readContextValues(contextStr);\n" + 
			                "for (java.util.Map.Entry<Object, Object> entry : context.entrySet()) {\n" + 
			                "    routeContext.put((String) entry.getKey(), (String) entry.getValue());\n" + 
			                "}\n");
	            	}
	            	code.append(instanceName +".setArguments(routeContext);\n");
	            }else if(useSelected){
	            	//do nothing
	            }
	            if(userDefinedParams!=null && userDefinedParams.size()>0){
	            	code.append("final Map<String, String> overwriteContext_"+instanceName+" = new HashMap<String, String>();\n"); 
	            	for(Map<String,String> map :userDefinedParams){
	            		code.append("overwriteContext_"+instanceName+".put(\""+map.get("Parameters")+"\", "+map.get("Values")+");\n"); 
	            	}
	            	code.append(instanceName +".setArguments(overwriteContext_"+instanceName+");\n");
	            }

	            code.append("main.addRouteBuilder("+instanceName+");");
            }
        }
    }

    public String generate(CodeGeneratorArgument argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    Vector v = (Vector) codeGenArgument.getArgument();
    IProcess process = (IProcess) v.get(0);

    String version = (String) v.get(1);

    boolean isStudioEEVersion = org.talend.core.PluginChecker.isTIS();

    List<? extends INode> graphicalNodes = process.getGraphicalNodes();
    //boolean stats = codeGenArgument.isStatistics();
    //boolean trace = codeGenArgument.isTrace();
    //boolean isRunInMultiThread = codeGenArgument.getIsRunInMultiThread();
    //List<IContextParameter> params = new ArrayList<IContextParameter>();
    //params=process.getContextManager().getDefaultContext().getContextParameterList();
    boolean isTestContainer = ProcessUtils.isTestContainer(process);
    String className = isTestContainer ? process.getName() + "Test" : process.getName();
    String extendsClassName = isTestContainer ? "org.apache.camel.test.junit4.CamelTestSupport" : "org.apache.camel.builder.RouteBuilder";

    
IBrandingService service = (IBrandingService) GlobalServiceRegister.getDefault().getService(IBrandingService.class);
if (service instanceof AbstractBrandingService) {

    stringBuffer.append(TEXT_1);
    stringBuffer.append(((AbstractBrandingService) service).getJobLicenseHeader(version));
    
}

    String routeFolderName = "";
    IProcess baseProcess = ProcessUtils.getTestContainerBaseProcess(process);
    if (baseProcess != null) {
        routeFolderName = JavaResourcesHelper.getJobFolderName(baseProcess.getName(), baseProcess.getVersion()) + ".";
    }
    routeFolderName = routeFolderName + JavaResourcesHelper.getJobFolderName(process.getName(), process.getVersion());
    String packageName = codeGenArgument.getCurrentProjectName().toLowerCase() + "." + routeFolderName;


    stringBuffer.append(TEXT_2);
    stringBuffer.append( packageName );
    stringBuffer.append(TEXT_3);
    
    java.util.Set<String> importsSet = new java.util.TreeSet<String>();
/*  for (String routine : CodeGeneratorRoutine.getRequiredRoutineName(process)) {
        if (!routine.equals(ITalendSynchronizer.TEMPLATE)) {
            importsSet.add("import routines."+routine);
        }
    }
*/
    importsSet.add("import java.util.HashMap");
    importsSet.add("import java.util.Map");
    importsSet.add("import routines.TalendString");
    importsSet.add("import routines.system.api.TalendESBRoute");
    importsSet.add("import routines.*");
    importsSet.add("import routines.system.*");
    importsSet.add("import org.apache.camel.CamelContext");
    importsSet.add("import java.util.Properties");

    String headerImports = ElementParameterParser.getValue(process, "__HEADER_IMPORT__");
    if(headerImports!=null && !"".equals(headerImports.trim())){
        String[] imports = headerImports.split(";");
        for(String s: imports){
            if(s!=null && !"".equals(s.trim())){
                importsSet.add(s.trim());
            }
        }
    }
    String footerImports = ElementParameterParser.getValue(process, "__FOOTER_IMPORT__");
    if(footerImports!=null && !"".equals(footerImports.trim())){
        String[] imports = footerImports.split(";");
        for(String s: imports){
            if(s!=null && !"".equals(s.trim())){
                importsSet.add(s.trim());
            }
        }
    }

    List<? extends INode> generatingNodes = process.getGeneratingNodes();
    for(INode n: generatingNodes){
        List<? extends IElementParameter> elementParameters = n.getElementParameters();
        for(IElementParameter p: elementParameters){
            if(p.getShowIf() != null && !p.isShow(elementParameters)){
                continue;
            }
            if(EParameterFieldType.MEMO_IMPORT == p.getFieldType()){
                Object value = p.getValue();
                if(value == null || !(value instanceof String) || "".equals(((String)value).trim())){
                    continue;
                }
                String[] imports = ((String)value).trim().split(";");
                for(String s: imports){
                    if(s!=null && !"".equals(s.trim())){
                        importsSet.add(s.trim());
                    }
                }
            }
        }

    }

    if(isTestContainer){
        importsSet.add("import org.apache.camel.builder.RouteBuilder");
        importsSet.add("import org.junit.Test");
        importsSet.add("import org.apache.camel.component.mock.MockEndpoint");
    }

    for(String s: importsSet){

    stringBuffer.append(TEXT_4);
    stringBuffer.append(s);
    stringBuffer.append(TEXT_5);
    
    }

    stringBuffer.append(TEXT_6);
    stringBuffer.append(className);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(ElementParameterParser.getValue(process, "__PURPOSE__") );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(ElementParameterParser.getValue(process, "__DESCRIPTION__") );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(ElementParameterParser.getValue(process, "__AUTHOR__") );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(version );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(ElementParameterParser.getValue(process, "__STATUS__") );
    stringBuffer.append(TEXT_12);
    
        boolean exportTypeSpringBoot = process.getClass().getName().endsWith("MicroServiceProcess");
        boolean isRoutelet = ((IProcess2) process).getProperty().getItem().getClass().getName().endsWith("RouteletProcessItemImpl");
        
        boolean hasCSoapOrCRest = false;
        
        for (INode node : graphicalNodes) {
        	if ("cSOAP".equals(node.getComponent().getName()) || "cREST".equals(node.getComponent().getName())) {
        		hasCSoapOrCRest = true;
        	}
        }

        if(exportTypeSpringBoot){
 
    stringBuffer.append(TEXT_13);
     if(hasCSoapOrCRest) { 
    stringBuffer.append(TEXT_14);
     } 
    stringBuffer.append(TEXT_15);
    stringBuffer.append(className);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(className.toLowerCase());
    stringBuffer.append(TEXT_17);
    stringBuffer.append(className);
    stringBuffer.append(TEXT_18);
      
    }else {

    stringBuffer.append(TEXT_19);
    stringBuffer.append(className);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(extendsClassName );
    stringBuffer.append(TEXT_21);
     
   } 

    stringBuffer.append(TEXT_22);
    stringBuffer.append(className);
    stringBuffer.append(TEXT_23);
    

    boolean hasSam = false;
    boolean hasCorrelationID = false;
    boolean hasCXFRSProvider = false;
    boolean hasCXFRSServiceLocator = false;
    boolean hasCXFServiceLocator = false;
    boolean hasOidcAuthentication = false;
    boolean hasOidcClientAuthentication = false;
    for (INode node : graphicalNodes) {
        if ("cSOAP".equals(node.getComponent().getName())) {
            if(!hasCXFServiceLocator){
                hasCXFServiceLocator = Boolean.parseBoolean(ElementParameterParser.getValue(node, "__ENABLE_SL__"));
            }
            boolean useRegistry = false;
            String dataFormat = ElementParameterParser.getValue(node, "__DATAFORMAT__");
            if (isStudioEEVersion && !"RAW".equals(dataFormat) && !"CXF_MESSAGE".equals(dataFormat)) {
                useRegistry = "true".equals(ElementParameterParser.getValue(node, "__ENABLE_REGISTRY__"));
            }
            if ("true".equals(ElementParameterParser.getValue(node, "__ENABLE_SAM__"))
                    && !"RAW".equals(dataFormat) && !useRegistry) {
                hasSam = true;
            }
            if ("true".equals(ElementParameterParser.getValue(node, "__ENABLE_CORRELATION__")) || useRegistry) {
                hasCorrelationID = true;
                String cid = node.getUniqueName();

    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    
            } // CorrelationID
        } else if ("cREST".equals(node.getComponent().getName())) {
            if(!hasCXFRSServiceLocator){
                hasCXFRSServiceLocator = Boolean.parseBoolean(ElementParameterParser.getValue(node, "__SERVICE_LOCATOR__"));
            }
            String cid = node.getUniqueName();
            if ("true".equals(ElementParameterParser.getValue(node, "__SERVICE_ACTIVITY_MONITOR__"))) {
                hasSam = true;
            }

            if (!hasOidcClientAuthentication) {
                hasOidcClientAuthentication = "true".equals(ElementParameterParser.getValue(node, "__ENABLE_SECURITY__"))
                                                  && "OIDC".equals(ElementParameterParser.getValue(node, "__SECURITY_TYPE__"))
                                                  && !node.getIncomingConnections().isEmpty();
            }

            if (!hasOidcAuthentication) {
                hasOidcAuthentication = "true".equals(ElementParameterParser.getValue(node, "__ENABLE_SECURITY__"))
                                            && "OIDC".equals(ElementParameterParser.getValue(node, "__SECURITY_TYPE__"));
            }

            if (node.getIncomingConnections().isEmpty()) {
                hasCXFRSProvider = true;

                if ("MANUAL".equals(ElementParameterParser.getValue(node, "__SERVICE_TYPE__"))) {
final Map<String, String> contentTypes = new java.util.HashMap<String, String>() {{
        put("XML", "{ \"application/xml\", \"text/xml\" }");
        put("JSON", "{ \"application/json\" }");
        put("XML-JSON", "{ \"application/xml\", \"text/xml\", \"application/json\" }");
        put("FORM", "{ \"application/x-www-form-urlencoded\" }");
        put("MULTIPART", "{ \"multipart/form-data\", \"multipart/mixed\", \"multipart/related\" }");
        put("HTML", "{ \"text/html\" }");
        put("ANY", "{ \"*/*\" }");
    }};

    if ("true".equals(ElementParameterParser.getValue(node, "__EXPOSE_SWAGGER_SPEC__"))) {

    stringBuffer.append(TEXT_26);
    stringBuffer.append(className);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    
    }

    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
     
                List<Map<String, String>> mappings = (List<Map<String, String>>) ElementParameterParser.getObjectValue(node, "__SCHEMAS__");
                for (Map<String, String> mapping : mappings) {
                    String outputConn = mapping.get("SCHEMA");

                    String httpVerb = mapping.get("HTTP_VERB");
                    String uriPattern = mapping.get("URI_PATTERN");
                    String consumes = mapping.get("CONSUMES");
                    String produces = mapping.get("PRODUCES");
                    String beanClass = mapping.get("BEAN");

    stringBuffer.append(TEXT_31);
    stringBuffer.append(uriPattern);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(httpVerb);
    stringBuffer.append(TEXT_33);
    
            String consumesContentTypes = null;
            if (contentTypes.containsKey(consumes)) {
                consumesContentTypes = contentTypes.get(consumes);

    stringBuffer.append(TEXT_34);
    stringBuffer.append(consumesContentTypes);
    stringBuffer.append(TEXT_35);
    
            }

             //if (null != produces) {
            String producesContentTypes = null;
            if (contentTypes.containsKey(produces)) {
                producesContentTypes = contentTypes.get(produces);

    stringBuffer.append(TEXT_36);
    stringBuffer.append(producesContentTypes);
    stringBuffer.append(TEXT_37);
    
            }
            if ("true".equals(ElementParameterParser.getValue(node, "__EXPOSE_SWAGGER_SPEC__"))) {
                String opName = "Operation " + outputConn;
                String notes = "";
                if (producesContentTypes != null) {
                    notes += "Produces: " + producesContentTypes + " ";
                }
                if (consumesContentTypes != null) {
                    notes += "Consumes: " + consumesContentTypes;
                }
                notes = notes.replaceAll("\"", "");
            
    stringBuffer.append(TEXT_38);
    stringBuffer.append(opName);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(notes);
    stringBuffer.append(TEXT_40);
    
            }

    stringBuffer.append(TEXT_41);
    stringBuffer.append(outputConn);
    stringBuffer.append(TEXT_42);
    
    final class URITemplateUtils {

        public static final String TEMPLATE_PARAMETERS = "jaxrs.template.parameters";
        public static final String LIMITED_REGEX_SUFFIX = "(/.*)?";
        public static final String FINAL_MATCH_GROUP = "FINAL_MATCH_GROUP";
        private static final String DEFAULT_PATH_VARIABLE_REGEX = "([^/]+?)";
        private static final String CHARACTERS_TO_ESCAPE = ".*+";

        private final String template;
        private final List<String> variables = new ArrayList<String>();
        private final List<String> customVariables = new ArrayList<String>();
        private final Pattern templateRegexPattern;
        private final String literals;
        private final List<UriChunk> uriChunks;

        public URITemplateUtils(String theTemplate) {
            template = theTemplate;
            StringBuilder literalChars = new StringBuilder();
            StringBuilder patternBuilder = new StringBuilder();
            CurlyBraceTokenizer tok = new CurlyBraceTokenizer(template);
            uriChunks = new ArrayList<UriChunk>();
            while (tok.hasNext()) {
                String templatePart = tok.next();
                UriChunk chunk = createUriChunk(templatePart);
                uriChunks.add(chunk);
                if (chunk instanceof Literal) {
                    String encodedValue = encodePartiallyEncoded(chunk.getValue(), false);
                    String substr = escapeCharacters(encodedValue);
                    literalChars.append(substr);
                    patternBuilder.append(substr);
                } else if (chunk instanceof Variable) {
                    Variable var = (Variable)chunk;
                    variables.add(var.getName());
                    if (var.getPattern() != null) {
                        customVariables.add(var.getName());
                        patternBuilder.append('(');
                        patternBuilder.append(var.getPattern());
                        patternBuilder.append(')');
                    } else {
                        patternBuilder.append(DEFAULT_PATH_VARIABLE_REGEX);
                    }
                }
            }
            literals = literalChars.toString();

            int endPos = patternBuilder.length() - 1;
            boolean endsWithSlash = (endPos >= 0) ? patternBuilder.charAt(endPos) == '/' : false;
            if (endsWithSlash) {
                patternBuilder.deleteCharAt(endPos);
            }
            patternBuilder.append(LIMITED_REGEX_SUFFIX);

            templateRegexPattern = Pattern.compile(patternBuilder.toString());
        }



        public String getLiteralChars() {
            return literals;
        }

        public String getValue() {
            return template;
        }

        /**
         * List of all variables in order of appearance in template.
         *
         * @return unmodifiable list of variable names w/o patterns,
         * e.g. for "/foo/{v1:\\d}/{v2}" returned list is ["v1","v2"].
         */
        public List<String> getVariables() {
            return Collections.unmodifiableList(variables);
        }

        /**
         * List of variables with patterns (regexps). List is subset of elements from {@link #getVariables()}.
         *
         * @return unmodifiable list of variables names w/o patterns.
         */
        public List<String> getCustomVariables() {
            return Collections.unmodifiableList(customVariables);
        }

        private String escapeCharacters(String expression) {

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < expression.length(); i++) {
                char ch = expression.charAt(i);
                sb.append(isReservedCharacter(ch) ? "\\" + ch : ch);
            }
            return sb.toString();
        }

        private boolean isReservedCharacter(char ch) {
            return CHARACTERS_TO_ESCAPE.indexOf(ch) != -1;
        }




        /**
         * Creates object form string.
         *
         * @param uriChunk stringified uri chunk
         * @return If param has variable form then {@link Variable} instance is created,
         * otherwise chunk is treated as {@link Literal}.
         */
        public UriChunk createUriChunk(String uriChunk) {
            if (uriChunk == null || "".equals(uriChunk)) {
                throw new IllegalArgumentException("uriChunk is empty");
            }
            UriChunk uriChunkRepresentation = new Variable().create(uriChunk);
            if (uriChunkRepresentation == null) {
                uriChunkRepresentation = new Literal().create(uriChunk);
            }
            return uriChunkRepresentation;
        }

        /**
         * Stringified part of URI. Chunk is not URI segment; chunk can span over multiple URI segments or one URI
         * segments can have multiple chunks. Chunk is used to decompose URI of {@link URITemplate} into literals
         * and variables. Example: "foo/bar/{baz}{blah}" is decomposed into chunks: "foo/bar", "{baz}" and
         * "{blah}".
         */
        abstract class UriChunk {

            public abstract String getValue();

            @Override
            public String toString() {
                return getValue();
            }
        }

        final class Literal extends UriChunk {
            private String value;

            private Literal() {
                // empty constructor
            }

            public Literal create(String uriChunk) {
                if (uriChunk == null || "".equals(uriChunk)) {
                    throw new IllegalArgumentException("uriChunk is empty");
                }
                Literal literal = new Literal();
                literal.value = uriChunk;
                return literal;
            }

            @Override
            public String getValue() {
                return value;
            }

        }

        /**
         * Variable of URITemplate. Variable has either "{varname:pattern}" syntax or "{varname}".
         */
        final class Variable extends UriChunk {
            private final Pattern VARIABLE_PATTERN =
                    Pattern.compile("(\\w[-\\w\\.]*[ ]*)(\\:(.+))?");
            private String name;
            private Pattern pattern;

            private Variable() {
                // empty constructor
            }

            /**
             * Creates variable from stringified part of URI.
             *
             * @param uriChunk uriChunk chunk that depicts variable
             * @return Variable if variable was successfully created; null if uriChunk was not a variable
             */
            public Variable create(String uriChunk) {
                Variable newVariable = new Variable();
                if (uriChunk == null || "".equals(uriChunk)) {
                    return null;
                }
                if (insideBraces(uriChunk)) {
                    uriChunk = stripBraces(uriChunk).trim();
                    Matcher matcher = VARIABLE_PATTERN.matcher(uriChunk);
                    if (matcher.matches()) {
                        newVariable.name = matcher.group(1).trim();
                        if (matcher.group(2) != null && matcher.group(3) != null) {
                            String patternExpression = matcher.group(3).trim();
                            newVariable.pattern = Pattern.compile(patternExpression);
                        }
                        return newVariable;
                    }
                }
                return null;
            }

            public String getName() {
                return name;
            }

            public String getPattern() {
                return pattern != null ? pattern.pattern() : null;
            }

            @Override
            public String getValue() {
                if (pattern != null) {
                    return "{" + name + ":" + pattern + "}";
                } else {
                    return "{" + name + "}";
                }
            }
        }

        /**
         * Splits string into parts inside and outside curly braces. Nested curly braces are ignored and treated
         * as part inside top-level curly braces. Example: string "foo{bar{baz}}blah" is split into three tokens,
         * "foo","{bar{baz}}" and "blah". When closed bracket is missing, whole unclosed part is returned as one
         * token, e.g.: "foo{bar" is split into "foo" and "{bar". When opening bracket is missing, closing
         * bracket is ignored and taken as part of current token e.g.: "foo{bar}baz}blah" is split into "foo",
         * "{bar}" and "baz}blah".
         * <p>
         * This is helper class for {@link URITemplate} that enables recurring literals appearing next to regular
         * expressions e.g. "/foo/{zipcode:[0-9]{5}}/". Nested expressions with closed sections, like open-closed
         * brackets causes expression to be out of regular grammar (is context-free grammar) which are not
         * supported by Java regexp version.
         */
        class CurlyBraceTokenizer {

            private List<String> tokens = new ArrayList<String>();
            private int tokenIdx;

            public CurlyBraceTokenizer(String string) {
                boolean outside = true;
                int level = 0;
                int lastIdx = 0;
                int idx;
                for (idx = 0; idx < string.length(); idx++) {
                    if (string.charAt(idx) == '{') {
                        if (outside) {
                            if (lastIdx < idx) {
                                tokens.add(string.substring(lastIdx, idx));
                            }
                            lastIdx = idx;
                            outside = false;
                        } else {
                            level++;
                        }
                    } else if (string.charAt(idx) == '}' && !outside) {
                        if (level > 0) {
                            level--;
                        } else {
                            if (lastIdx < idx) {
                                tokens.add(string.substring(lastIdx, idx + 1));
                            }
                            lastIdx = idx + 1;
                            outside = true;
                        }
                    }
                }
                if (lastIdx < idx) {
                    tokens.add(string.substring(lastIdx, idx));
                }
            }

            public boolean hasNext() {
                return tokens.size() > tokenIdx;
            }

            public String next() {
                if (hasNext()) {
                    return tokens.get(tokenIdx++);
                } else {
                    throw new IllegalStateException("no more elements");
                }
            }
        }

        /**
         * Token is enclosed by curly braces.
         *
         * @param token text to verify
         * @return true if enclosed, false otherwise.
         */
        public boolean insideBraces(String token) {
            return token.charAt(0) == '{' && token.charAt(token.length() - 1) == '}';
        }

        /**
         * Strips token from enclosed curly braces. If token is not enclosed method
         * has no side effect.
         *
         * @param token text to verify
         * @return text stripped from curly brace begin-end pair.
         */
        public String stripBraces(String token) {
            if (insideBraces(token)) {
                return token.substring(1, token.length() - 1);
            } else {
                return token;
            }
        }




        // HttpUtils()

        private final Pattern ENCODE_PATTERN =
                Pattern.compile("%[0-9a-fA-F][0-9a-fA-F]");

        // there are more of such characters, ex, '*' but '*' is not affected by UrlEncode
        private static final String PATH_RESERVED_CHARACTERS = "=@/:";
        private static final String QUERY_RESERVED_CHARACTERS = "?/";

        private String componentEncode(String reservedChars, String value) {

            StringBuilder buffer = new StringBuilder();
            StringBuilder bufferToEncode = new StringBuilder();

            for (int i = 0; i < value.length(); i++) {
                char currentChar = value.charAt(i);
                if (reservedChars.indexOf(currentChar) != -1) {
                    if (bufferToEncode.length() > 0) {
                        buffer.append(urlEncode(bufferToEncode.toString()));
                        bufferToEncode.setLength(0);
                    }
                    buffer.append(currentChar);
                } else {
                    bufferToEncode.append(currentChar);
                }
            }

            if (bufferToEncode.length() > 0) {
                buffer.append(urlEncode(bufferToEncode.toString()));
            }

            return buffer.toString();
        }

        public String queryEncode(String value) {

            return componentEncode(QUERY_RESERVED_CHARACTERS, value);
        }

        public String urlEncode(String value) {

            try {
                value = java.net.URLEncoder.encode(value, "UTF-8");
            } catch (java.io.UnsupportedEncodingException ex) {
                // unlikely to happen
            }

            return value;
        }

        public String pathEncode(String value) {

            String result = componentEncode(PATH_RESERVED_CHARACTERS, value);
            // URLEncoder will encode '+' to %2B but will turn ' ' into '+'
            // We need to retain '+' and encode ' ' as %20
            if (result.indexOf('+') != -1) {
                result = result.replace("+", "%20");
            }
            if (result.indexOf("%2B") != -1) {
                result = result.replace("%2B", "+");
            }

            return result;
        }

        public boolean isPartiallyEncoded(String value) {
            return ENCODE_PATTERN.matcher(value).find();
        }

        /**
         * Encodes partially encoded string. Encode all values but those matching pattern
         * "percent char followed by two hexadecimal digits".
         *
         * @param encoded fully or partially encoded string.
         * @return fully encoded string
         */
        public String encodePartiallyEncoded(String encoded, boolean query) {
            if (encoded.length() == 0) {
                return encoded;
            }
            Matcher m = ENCODE_PATTERN.matcher(encoded);
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (m.find()) {
                String before = encoded.substring(i, m.start());
                sb.append(query ? queryEncode(before) : pathEncode(before));
                sb.append(m.group());
                i = m.end();
            }
            String tail = encoded.substring(i, encoded.length());
            sb.append(query ? queryEncode(tail) : pathEncode(tail));
            return sb.toString();
        }

    }

            boolean paramCommaWritten = false;

            URITemplateUtils uriTemplate = new URITemplateUtils(uriPattern);
            List<String> uriVariables = uriTemplate.getVariables();
            // we are going to declare all uri template variables ("Path" parameter type by REST)
            for (String uriVariable : uriVariables) {
                if (!paramCommaWritten) {
                    paramCommaWritten = true;
                } else {
                    
    stringBuffer.append(TEXT_43);
    
                }

    stringBuffer.append(TEXT_44);
    stringBuffer.append(uriVariable);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(uriVariable);
    
            }
            if (contentTypes.containsKey(consumes)) {
                if (!paramCommaWritten) {
                    paramCommaWritten = true;
                } else {
                    
    stringBuffer.append(TEXT_46);
    
                }
                String contentClass = null;
                 if ("XML".equals(consumes) || "JSON".equals(consumes) || "XML-JSON".equals(consumes))
                 {
                     contentClass = beanClass == null || beanClass.isEmpty() ? "org.w3c.dom.Document" : beanClass;
                 }
                 else
                 {
                     contentClass = "ANY".equals(consumes) ? "String" : "org.w3c.dom.Document";
                 }

    stringBuffer.append(TEXT_47);
    stringBuffer.append(contentClass);
    stringBuffer.append(TEXT_48);
    
            }

    stringBuffer.append(TEXT_49);
     
                } // mappings

    stringBuffer.append(TEXT_50);
    
                } // "MANUAL"
            } // service

            if ("true".equals(ElementParameterParser.getValue(node, "__ENABLE_CORRELATION__"))) {
                hasCorrelationID = true;

    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    
            } // CorrelationID

        } // "cREST"
    } // for

    if (hasSam) {

    stringBuffer.append(TEXT_53);
    
    }
    
    if (hasCXFServiceLocator || hasCXFRSServiceLocator) {

    stringBuffer.append(TEXT_54);
    
    }
    
    if (hasCorrelationID) {

    stringBuffer.append(TEXT_55);
    
    }

    if (hasCXFRSProvider) {
        String defaultUri = (String) System.getProperties().get("restServiceDefaultUri");
        if (null == defaultUri || defaultUri.trim().isEmpty() || !defaultUri.contains("://")) {
            defaultUri = "http://127.0.0.1:8090/";
        } else if (!defaultUri.endsWith("/")) {
            defaultUri = defaultUri + "/";
        }

    stringBuffer.append(TEXT_56);
    stringBuffer.append(defaultUri);
    stringBuffer.append(TEXT_57);
    
    }


    stringBuffer.append(TEXT_58);
    
            boolean hasCXFSamlTokenProvider = false;
            boolean hasCXFSamlTokenConsumer = false;
            boolean hasCXFSamlTokenAuthorizationConsumer = false;
            boolean hasCXFSamlTokenAuthorizationProvider = false;
            boolean hasCXFUsernameTokenProvider = false;
            boolean hasCXFUsernameTokenConsumer = false;
            boolean hasCXFHTTPAuthConsumer = false;
            boolean hasCXFHTTPAuthProvider = false;
            boolean hasCXFComponentConsumer = false;
            boolean hasCXFRegistryProvider = false;
            boolean hasCXFRegistryConsumer = false;
            boolean hasCXFSAMLPropagateConsumer = false;

            List<INode> allCxfNodes = new ArrayList<INode>();
            allCxfNodes.addAll(process.getNodesOfType("cSOAP"));
            boolean hasCXFComponent = !allCxfNodes.isEmpty();
            allCxfNodes.addAll(process.getNodesOfType("cREST"));
            boolean hasCXF = !allCxfNodes.isEmpty();
            for(INode n: allCxfNodes) {
                boolean isProvider = n.getIncomingConnections().isEmpty();
                hasCXFComponentConsumer |= !isProvider;

                String useRegistry = "false";
                if(isStudioEEVersion){
                    useRegistry = ElementParameterParser.getValue(n, "__ENABLE_REGISTRY__");
                }
                String useSecurity = ElementParameterParser.getValue(n, "__ENABLE_SECURITY__");
                String formatType = ElementParameterParser.getValue(n, "__DATAFORMAT__");
                if("RAW".equals(formatType) || "CXF_MESSAGE".equals(formatType)){
                    useRegistry = "false";
                    useSecurity = "false";
                }
                String securityType = ElementParameterParser.getValue(n, "__SECURITY_TYPE__");
                if(!hasCXFServiceLocator){
                    hasCXFServiceLocator = Boolean.parseBoolean(ElementParameterParser.getValue(n, "__ENABLE_SL__"));
                }

                if("true".equals(useRegistry)){
                    useSecurity = "false";
                    if (isProvider) {
                        hasCXFRegistryProvider = true;
                    } else {
                        hasCXFRegistryConsumer = true;
                        if(!hasCXFSAMLPropagateConsumer && Boolean.parseBoolean(ElementParameterParser.getValue(n, "__USE_PROPAGATE_CREDENTIAL__"))){
                            hasCXFSAMLPropagateConsumer = true;
                        }
                    }
                }
                if("true".equals(useSecurity)){
                    if("SAML".equals(securityType) && (!hasCXFSamlTokenProvider || !hasCXFSamlTokenConsumer || !hasCXFSAMLPropagateConsumer)){
                        if (isProvider) {
                            hasCXFSamlTokenProvider = true;
                            if(!hasCXFSamlTokenAuthorizationProvider && isStudioEEVersion){
                                if("true".equals(ElementParameterParser.getValue(n, "__USE_AUTHORIZATION__"))){
                                    hasCXFSamlTokenAuthorizationProvider = true;
                                }
                            }
                        } else {
                            hasCXFSamlTokenConsumer = true;
                            if(!hasCXFSamlTokenAuthorizationConsumer && isStudioEEVersion){
                                if("true".equals(ElementParameterParser.getValue(n, "__USE_AUTHORIZATION__"))){
                                    hasCXFSamlTokenAuthorizationConsumer = true;
                                }
                            }
                            if(!hasCXFSAMLPropagateConsumer){
                                String samlSecurityType = ElementParameterParser.getValue(n, "__SAML_SECURITY_TYPES__");
                                if("PROPAGATE_UP".equals(samlSecurityType) || "PROPAGATE_AP".equals(samlSecurityType)){
                                    hasCXFSAMLPropagateConsumer = true;
                                }
                            }
                        }
                    }else if("USER".equals(securityType) && (!hasCXFUsernameTokenProvider || !hasCXFUsernameTokenConsumer)){
                        if(isProvider){
                            hasCXFUsernameTokenProvider = true;
                        }else{
                            hasCXFUsernameTokenConsumer = true;
                        }
                    }else if(("BASIC".equals(securityType)||"DIGEST".equals(securityType)) && (!hasCXFHTTPAuthProvider || !hasCXFHTTPAuthConsumer)){
                        if(isProvider){
                            hasCXFHTTPAuthProvider = true;
                        }else{
                            hasCXFHTTPAuthConsumer = true;
                        }
                    }
                }
            }

        if(hasCXFSAMLPropagateConsumer){

    stringBuffer.append(TEXT_59);
          }
        if(hasCXFRegistryProvider || hasCXFSamlTokenProvider){

    stringBuffer.append(TEXT_60);
    
            } if(hasCXF && exportTypeSpringBoot){

    stringBuffer.append(TEXT_61);
     
                if(hasCXFServiceLocator || hasCXFRSServiceLocator){
                
    stringBuffer.append(TEXT_62);
    
                   } else {
                
    stringBuffer.append(TEXT_63);
    }
    stringBuffer.append(TEXT_64);
    
            } if(hasCXFComponent){

    stringBuffer.append(TEXT_65);
    if(exportTypeSpringBoot){
    stringBuffer.append(TEXT_66);
    }
    
                if(hasCXFHTTPAuthConsumer){

    stringBuffer.append(TEXT_67);
    
                }
                if(hasCXFUsernameTokenConsumer){

    stringBuffer.append(TEXT_68);
    
                }
if(hasCXFUsernameTokenProvider || hasCXFSamlTokenProvider || hasCXFSamlTokenConsumer || hasCXFHTTPAuthProvider || hasCXFRegistryProvider || hasCXFRegistryConsumer){
    
                if(!exportTypeSpringBoot){
               
    stringBuffer.append(TEXT_69);
    }
    
                    if(hasCXFHTTPAuthProvider){

    stringBuffer.append(TEXT_70);
    if(!exportTypeSpringBoot){
    stringBuffer.append(TEXT_71);
    }
    stringBuffer.append(TEXT_72);
    
                    }
                    if(hasCXFUsernameTokenProvider){

    stringBuffer.append(TEXT_73);
    
                    }
                    if(hasCXFSamlTokenProvider || hasCXFSamlTokenConsumer){


    stringBuffer.append(TEXT_74);
                      }
                    if(hasCXFRegistryProvider || hasCXFRegistryConsumer){

    stringBuffer.append(TEXT_75);
    }
    if(!exportTypeSpringBoot){
    stringBuffer.append(TEXT_76);
    }
    
}

    stringBuffer.append(TEXT_77);
    
            if (hasCXFHTTPAuthConsumer) {

    stringBuffer.append(TEXT_78);
    
            }
            if (hasCXFHTTPAuthProvider) {

    stringBuffer.append(TEXT_79);
    
            }

            if (hasCXFUsernameTokenProvider) {

    
            if(exportTypeSpringBoot){
           
    stringBuffer.append(TEXT_80);
    }else{
    stringBuffer.append(TEXT_81);
    }
    stringBuffer.append(TEXT_82);
    
            }
            if (hasCXFUsernameTokenConsumer) {

    stringBuffer.append(TEXT_83);
              }
        }
if(hasCXFSamlTokenConsumer || hasCXFRegistryConsumer){

    stringBuffer.append(TEXT_84);
    
}

if(hasCXFComponentConsumer){

    stringBuffer.append(TEXT_85);
    
}
if(hasCXFRegistryProvider || hasCXFRegistryConsumer){

    stringBuffer.append(TEXT_86);
    if(hasCXFRegistryConsumer){

    stringBuffer.append(TEXT_87);
     if(exportTypeSpringBoot) {
    stringBuffer.append(TEXT_88);
    }
    stringBuffer.append(TEXT_89);
     if(exportTypeSpringBoot){ 
    stringBuffer.append(TEXT_90);
    }
    stringBuffer.append(TEXT_91);
    //for fix [TESB-12172], set default address to null to avoid override after wsdl from registry initialized. 
        
    stringBuffer.append(TEXT_92);
    if(exportTypeSpringBoot){
    stringBuffer.append(TEXT_93);
    }else{
    stringBuffer.append(TEXT_94);
    }
    stringBuffer.append(TEXT_95);
    //for fix [TESB-12172], add locator feature when necessary. 
        
    stringBuffer.append(TEXT_96);
    
}
if(hasCXFRegistryProvider){

    stringBuffer.append(TEXT_97);
     if(exportTypeSpringBoot) {
    stringBuffer.append(TEXT_98);
    } else {
    stringBuffer.append(TEXT_99);
    }
    stringBuffer.append(TEXT_100);
    if(exportTypeSpringBoot){
    stringBuffer.append(TEXT_101);
    }
    stringBuffer.append(TEXT_102);
    }
    stringBuffer.append(TEXT_103);
    
}

if (hasCXFSamlTokenProvider || hasCXFRegistryProvider) {

    stringBuffer.append(TEXT_104);
    
}

if (hasCXFSamlTokenAuthorizationProvider && !hasCXFComponent) {

    stringBuffer.append(TEXT_105);
    
}

if(hasCXFComponent && (hasCXFUsernameTokenProvider || hasCXFUsernameTokenConsumer || hasCXFSamlTokenProvider || hasCXFSamlTokenConsumer
    ||hasCXFRegistryProvider || hasCXFRegistryConsumer)){

    stringBuffer.append(TEXT_106);
    
if(hasCXFSamlTokenConsumer || hasCXFSamlTokenProvider){

    stringBuffer.append(TEXT_107);
    
if(hasCXFSamlTokenConsumer){

    stringBuffer.append(TEXT_108);
     if(exportTypeSpringBoot) {
    stringBuffer.append(TEXT_109);
    }
    stringBuffer.append(TEXT_110);
    if(hasCXFSamlTokenAuthorizationConsumer){
    stringBuffer.append(TEXT_111);
    }
    stringBuffer.append(TEXT_112);
     if(exportTypeSpringBoot){ 
    stringBuffer.append(TEXT_113);
    }
    stringBuffer.append(TEXT_114);
    
}
if(hasCXFSamlTokenProvider){

    stringBuffer.append(TEXT_115);
    if(exportTypeSpringBoot){
    stringBuffer.append(TEXT_116);
    }
    stringBuffer.append(TEXT_117);
    if(exportTypeSpringBoot){
    stringBuffer.append(TEXT_118);
    }
    stringBuffer.append(TEXT_119);
    
}//end if(hasCXFSamlTokenProvider)

    stringBuffer.append(TEXT_120);
    if(exportTypeSpringBoot){
    stringBuffer.append(TEXT_121);
    } else {
    stringBuffer.append(TEXT_122);
    }
    stringBuffer.append(TEXT_123);
    
}//end if(hasCXFSamlTokenConsumer || hasCXFSamlTokenProvider)
}//end if(hasCXFSamlTokenProvider || hasCXFSamlTokenConsumer || hasCXFRegistryProvider || hasCXFRegistryConsumer)

    stringBuffer.append(TEXT_124);
    
    if(isTestContainer){

        if(hasCXFComponent){

    stringBuffer.append(TEXT_125);
    
        }// end if cCxf

    stringBuffer.append(TEXT_126);
    
    }//end if(isTestContainer)

    if (hasOidcAuthentication) {

    
    stringBuffer.append(TEXT_127);
     if(!exportTypeSpringBoot) {
    stringBuffer.append(TEXT_128);
     } 
    stringBuffer.append(TEXT_129);
    
    } // end if hasOidcAuthentication

    if (hasOidcClientAuthentication) {
        
    stringBuffer.append(TEXT_130);
    
	}

    stringBuffer.append(TEXT_131);
    if(exportTypeSpringBoot){
    stringBuffer.append(TEXT_132);
    if(!isRoutelet){
    stringBuffer.append(TEXT_133);
    stringBuffer.append( generateAddRoutesMethod(process));
    stringBuffer.append(TEXT_134);
    }
    }else{
    stringBuffer.append(TEXT_135);
    }
    stringBuffer.append(TEXT_136);
    
            //process cConfig components first 
            List<? extends INode> camelContextNodes = process.getNodesOfType("cConfig");
            for(INode node: camelContextNodes){
                boolean useMdcLogging = Boolean.parseBoolean(ElementParameterParser.getValue(node, "__USE_MDC_LOGGING__"));
                if(useMdcLogging){

    stringBuffer.append(TEXT_137);
    
                }

    stringBuffer.append(TEXT_138);
    stringBuffer.append(ElementParameterParser.getValue(node, "__CODE__"));
    
            } 

    stringBuffer.append(TEXT_139);
    
            List<? extends INode> cxfNodes = process.getNodesOfType("cSOAP");
            if (null != cxfNodes && !cxfNodes.isEmpty()){
                boolean hasCXFConsumer = false;
                boolean hasCXFSAMLProvider = false;
                for(INode n: cxfNodes){
                    int incomingConnections = n.getIncomingConnections().size();
                    if(incomingConnections > 0){
                        hasCXFConsumer = true;
                    }else{
                        String dataformat = ElementParameterParser.getValue(n, "__DATAFORMAT__");

                        String useServiceRegistry = ElementParameterParser.getValue(n, "__ENABLE_REGISTRY__");
                        if(!isStudioEEVersion || "RAW".equals(dataformat) || "CXF_MESSAGE".equals(dataformat)){
                            useServiceRegistry = "false";
                        }

                        String useSecurity = ElementParameterParser.getValue(n, "__ENABLE_SECURITY__");
                        if("true".equals(useServiceRegistry) || "RAW".equals(dataformat) || "CXF_MESSAGE".equals(dataformat)){
                            useSecurity = "false";
                        }

                        if("true".equals(useServiceRegistry) || ("true".equals(useSecurity) && "SAML".equals(ElementParameterParser.getValue(n, "__SECURITY_TYPE__")))){
                            hasCXFSAMLProvider = true;
                        }
                        if(hasCXFConsumer && hasCXFSAMLProvider){
                            break;
                        }
                    }
                }
                if(hasCXFConsumer){

    stringBuffer.append(TEXT_140);
    
                }
                if(hasCXFSAMLProvider){

    stringBuffer.append(TEXT_141);
                  }
            }

            for (INode node : process.getNodesOfType("cREST")) {
                String cid = node.getUniqueName();

    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    
                boolean isProvider = node.getIncomingConnections().isEmpty();
                if (isProvider) {
                    String serviceClass = ("MANUAL".equals(ElementParameterParser.getValue(node, "__SERVICE_TYPE__")))
                        ? ("Service_" + cid) : ElementParameterParser.getValue(node, "__RESOURCE_CLASS__");

    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(serviceClass);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(serviceClass);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(serviceClass);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    
                    if ("true".equals(ElementParameterParser.getValue(node, "__ENABLE_SECURITY__"))) {
                        if("BASIC".equals(ElementParameterParser.getValue(node, "__SECURITY_TYPE__"))) {

    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    
                        } else if ("SAML".equals(ElementParameterParser.getValue(node, "__SECURITY_TYPE__"))) {

    stringBuffer.append(TEXT_160);
    if(exportTypeSpringBoot){
    stringBuffer.append(TEXT_161);
    
                                    if (hasCXFSamlTokenAuthorizationProvider && !hasCXFComponent) {
                                
    stringBuffer.append(TEXT_162);
    }
    stringBuffer.append(TEXT_163);
    }
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
     if ("true".equals(ElementParameterParser.getValue(node, "__USE_AUTHORIZATION__"))) { 
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
     } 
    stringBuffer.append(TEXT_168);
    
                        } else if ("OIDC".equals(ElementParameterParser.getValue(node, "__SECURITY_TYPE__"))) {
                            
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    
                        }
                    }
                    if ("true".equals(ElementParameterParser.getValue(node, "__EXPOSE_SWAGGER_SPEC__"))) {

    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    
                        String epForSwagger = ElementParameterParser.getValue(node, "__URL__");
                        epForSwagger = epForSwagger.trim();
                        if (epForSwagger.startsWith("\"") && epForSwagger.endsWith("\"")) {
                            epForSwagger = epForSwagger.substring(1, epForSwagger.length() - 1);
                        }
                        epForSwagger = "/services" + epForSwagger;
                        if (epForSwagger.endsWith("\"")) {
                            epForSwagger = epForSwagger.substring(0, epForSwagger.length() - 1);
                        }

                        String swaggerTitle = className + " REST Application";
                        String swaggerDescription = "";
                        if ("true".equals(ElementParameterParser.getValue(node, "__INCLUDE_DOC_INTO_SWAGGER_SPEC__"))) {
                            swaggerDescription = ElementParameterParser.getValue(node, "__COMMENT__");
                            if (swaggerDescription.contains("\r\n")) {
                              swaggerDescription = swaggerDescription.replace("\r\n", "\\n\" + \n\"");
                            } else {
                               swaggerDescription = swaggerDescription.replace("\n", "\\n\" + \n\"");
                            }
                        }
                    
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(epForSwagger);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(swaggerTitle);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(swaggerDescription);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    
                    }
                } else {

    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    if(exportTypeSpringBoot){
    stringBuffer.append(TEXT_191);
    stringBuffer.append(node.getUniqueName());
    stringBuffer.append(TEXT_192);
    stringBuffer.append(ElementParameterParser.getValue(node, "__URL__"));
    stringBuffer.append(TEXT_193);
    }
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    
                    if ("RESOURCECLASS".equals(ElementParameterParser.getValue(node, "__SERVICE_TYPE__"))) {

    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(ElementParameterParser.getValue(node, "__RESOURCE_CLASS__"));
    stringBuffer.append(TEXT_199);
    
                    }
                    if ("true".equals(ElementParameterParser.getValue(node, "__ENABLE_SECURITY__"))) {
                        String passwordFieldName = "__PASSWORD__";

    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_202);
    } else {
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_204);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_205);
    }
    
                        if ("BASIC".equals(ElementParameterParser.getValue(node, "__SECURITY_TYPE__"))) {

    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(ElementParameterParser.getValue(node, "__USERNAME__"));
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_210);
    
                        } else if ("SAML".equals(ElementParameterParser.getValue(node, "__SECURITY_TYPE__"))) {

    stringBuffer.append(TEXT_211);
    if(exportTypeSpringBoot){
    stringBuffer.append(TEXT_212);
    }else{
    stringBuffer.append(TEXT_213);
    }
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(ElementParameterParser.getValue(node, "__USERNAME__"));
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_219);
     if ("true".equals(ElementParameterParser.getValue(node, "__USE_AUTHORIZATION__"))) { 
    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_221);
    stringBuffer.append(ElementParameterParser.getValue(node, "__ROLE_NAME__"));
    stringBuffer.append(TEXT_222);
     } 
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_225);
    
                        }
                    }
                }

     
                if (isProvider) {

    stringBuffer.append(TEXT_226);
    if(exportTypeSpringBoot){
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(ElementParameterParser.getValue(node, "__URL__"));
    stringBuffer.append(TEXT_229);
    }else{
    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_231);
    stringBuffer.append(ElementParameterParser.getValue(node, "__URL__"));
    stringBuffer.append(TEXT_232);
    }
                  } else {

    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_234);
    stringBuffer.append(ElementParameterParser.getValue(node, "__URL__"));
    stringBuffer.append(TEXT_235);
     
                }

    
                if ("true".equals(ElementParameterParser.getValue(node, "__SERVICE_LOCATOR__"))) {

    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_237);
    stringBuffer.append(TEXT_238);
    stringBuffer.append(ElementParameterParser.getValue(node, "__SERVICE_NAMESPACE__"));
    stringBuffer.append(TEXT_239);
    stringBuffer.append(TEXT_240);
    stringBuffer.append(ElementParameterParser.getValue(node, "__SERVICE_NAME__"));
    stringBuffer.append(TEXT_241);
    
                        if (!isProvider) {

    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_244);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_245);
    
                        }else{

    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_247);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_248);
    
						}

    stringBuffer.append(TEXT_249);
    
                    List<Map<String, String>> customProperties = (List<Map<String,String>>) ElementParameterParser.getObjectValue(node, "__SL_META_DATA__");
					if (!customProperties.isEmpty()) 
					{ 

    stringBuffer.append(TEXT_250);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_251);
     for (Map<String, String> custProp : customProperties) { 
    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_253);
    stringBuffer.append(custProp.get("NAME"));
    stringBuffer.append(TEXT_254);
    stringBuffer.append(custProp.get("VALUE"));
    stringBuffer.append(TEXT_255);
     } 
    stringBuffer.append(TEXT_256);
    if(!isProvider){
    stringBuffer.append(TEXT_257);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_258);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_261);
    }else{
    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_263);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_265);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_266);
    }
     
					} 

    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_268);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_269);
    
                } else if (!isProvider) {

    stringBuffer.append(TEXT_270);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_271);
    stringBuffer.append(ElementParameterParser.getValue(node, "__URL__"));
    stringBuffer.append(TEXT_272);
    
                }

                if ("true".equals(ElementParameterParser.getValue(node, "__SERVICE_ACTIVITY_MONITOR__"))) {
                

    
                        if (!isProvider) {

    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_274);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_275);
    
                        }else{

    stringBuffer.append(TEXT_276);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_277);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_278);
    
						}

    stringBuffer.append(TEXT_279);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_280);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_282);
    
                }

                if ("true".equals(ElementParameterParser.getValue(node, "__ENABLE_CORRELATION__"))) {

    stringBuffer.append(TEXT_283);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_284);
    stringBuffer.append(ElementParameterParser.getValue(node, "__CORRELATION_VALUE__"));
    stringBuffer.append(TEXT_285);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_286);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_287);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_288);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_289);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_290);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_291);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_292);
    
                }

    stringBuffer.append(TEXT_293);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_294);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_295);
    
            }

            //then process cBeanRegister components
            List<? extends INode> beanRegisterNodes = process.getNodesOfType("cBeanRegister");
            if(beanRegisterNodes != null && beanRegisterNodes.size()>0){
            for(INode node: beanRegisterNodes){
                String id = ElementParameterParser.getValue(node, "__ID__");
                String isSimple = ElementParameterParser.getValue(node, "__SIMPLE_CONFIG__");
                String classQualifiedName = ElementParameterParser.getValue(node, "__CLASS_QUALIFIED_NAME__");
                String hasArguments = ElementParameterParser.getValue(node, "__SPECIFY_ARGUMENTS__");
                List<Map<String, String>> arguments = (List<Map<String, String>>) ElementParameterParser.getObjectValue(node, "__ARGUMENTS__");

                String code = ElementParameterParser.getValue(node, "__CODE__");

                if("true".equals(isSimple)){
                    StringBuilder sb = new StringBuilder();
                    if("true".equals(hasArguments)){
                        for(Map<String, String> s: arguments){
                            if(sb.length() == 0){
                                sb.append(s.get("VALUE"));
                            }else{
                                sb.append(",");
                                sb.append(s.get("VALUE"));
                            }
                        }
                    }

    stringBuffer.append(TEXT_296);
    stringBuffer.append(id);
    stringBuffer.append(TEXT_297);
    stringBuffer.append(classQualifiedName);
    stringBuffer.append(TEXT_298);
    stringBuffer.append(sb.toString());
    stringBuffer.append(TEXT_299);
    
                }else{

    stringBuffer.append(TEXT_300);
    stringBuffer.append(TEXT_301);
    stringBuffer.append(code);
    stringBuffer.append(TEXT_302);
    stringBuffer.append(id);
    stringBuffer.append(TEXT_303);
    
                }
            }
            }

            //after, process cDataset 
            List<? extends INode> datasetNodes = process.getNodesOfType("cDataset");
            for(INode n: datasetNodes){
                String beanID = ElementParameterParser.getValue(n, "__DATASET_NAME__");
                String registerNewBean = ElementParameterParser.getValue(n, "__REGISTER_DATASET_BEAN__");
                if(!"true".equals(registerNewBean)){
                    continue;
                }
                String beanClass = ElementParameterParser.getValue(n, "__BEAN_CLASS__");
                List<Map<String, String>> beanArguments = (List<Map<String, String>>) ElementParameterParser.getObjectValue(n, "__BEAN_ARGUMENTS__");
                StringBuilder sb = new StringBuilder();
                if(beanArguments != null){
                    for(Map<String,String> map: beanArguments){
                        if(sb.length() == 0){
                            sb.append(map.get("VALUE"));
                        }else{
                            sb.append(",");
                            sb.append(map.get("VALUE"));
                        }
                    }
                }

    stringBuffer.append(TEXT_304);
    stringBuffer.append(beanID);
    stringBuffer.append(TEXT_305);
    stringBuffer.append(beanClass);
    stringBuffer.append(TEXT_306);
    stringBuffer.append(sb.toString());
    stringBuffer.append(TEXT_307);
    
            }
            //cMQConnectionFactory http://jira.talendforge.org/browse/TESB-4860
            for (INode node: process.getNodesOfType("cMQConnectionFactory")) {
                NodeParamsHelper helper = new NodeParamsHelper(node);
                //Use transaction http://jira.talendforge.org/browse/TESB-5160 By LiXiaopeng
                String useTransaction = ElementParameterParser.getValue(node, "__USE_TRANSACTION__");
                String transactedMethodStr = "";
                if("true".equals(useTransaction)){
                    transactedMethodStr = "Transacted";
                }
                final String cid = node.getUniqueName();
                //Component Name
                String name = cid.replace("_", "");
                name = "\"" + name + "\"";

                //ActiveMQ
                String mqType = ElementParameterParser.getValue(node, "__MQ_TYPE__");
                String amqUseRetroactiveConsumer = ElementParameterParser.getValue(node, "__AMQ_USE_RETROACTIVE_CONSUMER__").trim();
                if("ActiveMQ".equals(mqType)){
                    String amqUri = ElementParameterParser.getValue(node, "__AMQ_BROKER_URI__").trim();
                    String useActiveMQAuth = ElementParameterParser.getValue(node, "__AMQ_AUTH__");
                    if ("true".equals(useActiveMQAuth)) {
                        String username = ElementParameterParser.getValue(node, "__AMQ_USERNAME__");
                        String passwordFieldName = "__AMQ_PASSWORD__";

    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_308);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_309);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_310);
    } else {
    stringBuffer.append(TEXT_311);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_312);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_313);
    }
    stringBuffer.append(TEXT_314);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_315);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_316);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_317);
    stringBuffer.append(amqUri);
    stringBuffer.append(TEXT_318);
    
                    } else {

    
                                if("true".equals(amqUseRetroactiveConsumer)){
                            
    stringBuffer.append(TEXT_319);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_320);
    stringBuffer.append(amqUri);
    stringBuffer.append(TEXT_321);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_322);
    
                                } else {
                            
    stringBuffer.append(TEXT_323);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_324);
    stringBuffer.append(amqUri);
    stringBuffer.append(TEXT_325);
    
                                }
                            
    stringBuffer.append(TEXT_326);
    
                    }
                    String amqPool = ElementParameterParser.getValue(node, "__AMQ_POOL__").trim();

                    if("true".equals(amqPool)){
                         String amq_pool_max_connections = ElementParameterParser.getValue(node, "__AMQ_POOL_MAX_CONNECTIONS__").trim();
                         String amq_pool_max_active = ElementParameterParser.getValue(node, "__AMQ_POOL_MAX_ACTIVE__").trim();
                         String amq_pool_idle_timeout = ElementParameterParser.getValue(node, "__AMQ_POOL_IDLE_TIMEOUT__").trim();
                         String amq_pool_expiry_timeout = ElementParameterParser.getValue(node, "__AMQ_POOL_EXPIRY_TIMEOUT__").trim();

                         if(amq_pool_max_connections.startsWith("\"")){
                            amq_pool_max_connections = amq_pool_max_connections.substring(1);
                        }
                        if(amq_pool_max_connections.endsWith("\"")){
                            amq_pool_max_connections = amq_pool_max_connections.substring(0, amq_pool_max_connections.length() - 1);
                        }
                        if(amq_pool_max_active.startsWith("\"")){
                            amq_pool_max_active = amq_pool_max_active.substring(1);
                        }
                        if(amq_pool_max_active.endsWith("\"")){
                            amq_pool_max_active = amq_pool_max_active.substring(0, amq_pool_max_active.length() - 1);
                        }
                        if(amq_pool_idle_timeout.startsWith("\"")){
                            amq_pool_idle_timeout = amq_pool_idle_timeout.substring(1);
                        }
                        if(amq_pool_idle_timeout.endsWith("\"")){
                            amq_pool_idle_timeout = amq_pool_idle_timeout.substring(0, amq_pool_idle_timeout.length() - 1);
                        }
                        if(amq_pool_expiry_timeout.startsWith("\"")){
                             amq_pool_expiry_timeout = amq_pool_expiry_timeout.substring(1);
                        }
                        if(amq_pool_expiry_timeout.endsWith("\"")){
                            amq_pool_expiry_timeout = amq_pool_expiry_timeout.substring(0, amq_pool_expiry_timeout.length() - 1);
                        }

    stringBuffer.append(TEXT_327);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_328);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_329);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_330);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_331);
    stringBuffer.append(amq_pool_expiry_timeout);
    stringBuffer.append(TEXT_332);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_333);
    stringBuffer.append(amq_pool_idle_timeout);
    stringBuffer.append(TEXT_334);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_335);
    stringBuffer.append(amq_pool_max_connections);
    stringBuffer.append(TEXT_336);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_337);
    stringBuffer.append(amq_pool_max_active);
    stringBuffer.append(TEXT_338);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_339);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_340);
    stringBuffer.append(transactedMethodStr);
    stringBuffer.append(TEXT_341);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_342);
    
                    } else {

    stringBuffer.append(TEXT_343);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_344);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_345);
    stringBuffer.append(transactedMethodStr);
    stringBuffer.append(TEXT_346);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_347);
    
                    }
                } else if ("WebSphere MQ Jms".equals(mqType)) {
                    String wmqServer = ElementParameterParser.getValue(node, "__WQM_SEVER__");
                    String wmqPort = ElementParameterParser.getValue(node, "__WMQ_PORT__");
                    String wmqTransportType = ElementParameterParser.getValue(node, "__WMQ_TRANSPORT_TYPE__");
                    String wmqUM = ElementParameterParser.getValue(node, "__WMQ_QUEUE_MANAGER__");
                    String wmqChannel = ElementParameterParser.getValue(node, "__WMQ_CHANNEL__");

                    //Username and password, http://jira.talendforge.org/browse/TESB-4073
                    String username = ElementParameterParser.getValue(node, "__WMQ_USERNAME__");
                    String useAuth = ElementParameterParser.getValue(node, "__WMQ_AUTH__");

                    if(wmqPort.startsWith("\"")){
                        wmqPort = wmqPort.substring(1);
                    }
                    if(wmqPort.endsWith("\"")){
                        wmqPort = wmqPort.substring(0, wmqPort.length() - 1);
                    }
                    if(wmqTransportType.startsWith("\"")){
                        wmqTransportType = wmqTransportType.substring(1);
                    }
                    if(wmqTransportType.endsWith("\"")){
                        wmqTransportType = wmqTransportType.substring(0, wmqTransportType.length() - 1);
                    }


    stringBuffer.append(TEXT_348);
    stringBuffer.append(wmqServer);
    stringBuffer.append(TEXT_349);
    stringBuffer.append(wmqPort);
    stringBuffer.append(TEXT_350);
    stringBuffer.append(wmqTransportType);
    stringBuffer.append(TEXT_351);
    stringBuffer.append(wmqUM);
    stringBuffer.append(TEXT_352);
    
                        if (wmqTransportType.equals("1") && (wmqChannel != null) && !wmqChannel.equals("")){

    stringBuffer.append(TEXT_353);
    stringBuffer.append(wmqChannel);
    stringBuffer.append(TEXT_354);
    
                        }

    stringBuffer.append(TEXT_355);
    
                    if("false".equals(useAuth)){

    stringBuffer.append(TEXT_356);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_357);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_358);
    stringBuffer.append(transactedMethodStr);
    stringBuffer.append(TEXT_359);
    
                    }else{

    stringBuffer.append(TEXT_360);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_361);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_362);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_363);
    
                    String passwordFieldName = "__WMQ_PASSWORD__";
                    
    stringBuffer.append(TEXT_364);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_365);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_366);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_367);
    } else {
    stringBuffer.append(TEXT_368);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_369);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_370);
    }
    stringBuffer.append(TEXT_371);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_372);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_373);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_374);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_375);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_376);
    stringBuffer.append(transactedMethodStr);
    stringBuffer.append(TEXT_377);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_378);
    
                    }

    stringBuffer.append(TEXT_379);
    
                }else if("AMQP".equals(mqType)){
                    String host = helper.getStringParam("__AMQP_BROKER_URI__");
                    boolean useSSL = helper.getBoolParam("__AMQP_SSL__");
                    boolean useAuth = helper.getBoolParam("__AMQP_USE_AUTH__");

                    StringBuilder ep = new StringBuilder();
                    ep.append("\"");
                    ep.append(useSSL?"amqps":"amqp");
                    ep.append("://\" + ");
                    if(useAuth) {
                        ep.append(helper.getStringParam("__AMQP_USERNAME__"));
                        ep.append("+ \":\" +");
                        String passwordFieldName = "__AMQP_PASSWORD__";

                        
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_380);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_381);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_382);
    } else {
    stringBuffer.append(TEXT_383);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_384);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_385);
    }
    

                        ep.append("decryptedPassword_");
                        ep.append(cid);
                        ep.append("+ \"@\" +");
                    }
                    ep.append(host);
                    String port = helper.getStringParam("__AMQP_PORT__");
                    if (!port.isEmpty()) {
                        ep.append("+ \":\" + ");
                        ep.append(port);
                    }

    stringBuffer.append(TEXT_386);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_387);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_388);
    stringBuffer.append(ep.toString());
    stringBuffer.append(TEXT_389);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_390);
    stringBuffer.append(process.getName().toLowerCase());
    stringBuffer.append(TEXT_391);
    
                } else if("MQTT".equals(mqType)) {
                    String host = helper.getStringParam("__MQTT_HOST__");
                    String port = helper.getStringParam("__MQTT_PORT__");
                    boolean useSSL = helper.getBoolParam("__MQTT_SSL__");
                    String brokerUri = "\""+(useSSL?"ssl":"tcp") + "://\"+" + host + "+\":\"+" + port;

    stringBuffer.append(TEXT_392);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_393);
    
                String useActiveMQTTAuth = ElementParameterParser.getValue(node, "__MQTT_AUTH__");
                if ("true".equals(useActiveMQTTAuth)){
                    String username = ElementParameterParser.getValue(node, "__MQTT_USERNAME__");
                    String passwordFieldName = "__MQTT_PASSWORD__";

    stringBuffer.append(TEXT_394);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_395);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_396);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_397);
    } else {
    stringBuffer.append(TEXT_398);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_399);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_400);
    }
    stringBuffer.append(TEXT_401);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_402);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_403);
    
                }

    stringBuffer.append(TEXT_404);
    stringBuffer.append(brokerUri);
    stringBuffer.append(TEXT_405);
    stringBuffer.append(helper.getStringParam("__MQTT_CONNECT_ATTEMPTS__"));
    stringBuffer.append(TEXT_406);
    stringBuffer.append(helper.getStringParam("__MQTT_RECONNECT_ATTEMPTS__"));
    stringBuffer.append(TEXT_407);
    stringBuffer.append(helper.getStringParam("__MQTT_RECONNECT_DELAY__"));
    stringBuffer.append(TEXT_408);
    stringBuffer.append(helper.getStringParam("__MQTT_QOS__"));
    stringBuffer.append(TEXT_409);
    stringBuffer.append(helper.getStringParam("__MQTT_CONNECT_WAIT_IN_SECONDS__"));
    stringBuffer.append(TEXT_410);
    stringBuffer.append(helper.getStringParam("__MQTT_DISCONNECT_WAIT_IN_SECONDS__"));
    stringBuffer.append(TEXT_411);
    stringBuffer.append(helper.getStringParam("__MQTT_SEND_WAIT_IN_SECONDS__"));
    stringBuffer.append(TEXT_412);
    if("true".equals(helper.getStringParam("__MQTT_SSL__"))){
    stringBuffer.append(TEXT_413);
    stringBuffer.append(TEXT_414);
    stringBuffer.append(helper.getStringParam("__MQTT_SSL_TRUST_STORE__"));
    stringBuffer.append(TEXT_415);
    String passwordFieldName = "__MQTT_SSL_TRUST_STORE_PASSWORD__";
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_416);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_417);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_418);
    } else {
    stringBuffer.append(TEXT_419);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_420);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_421);
    }
    stringBuffer.append(TEXT_422);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_423);
    stringBuffer.append(TEXT_424);
    stringBuffer.append(helper.getStringParam("__MQTT_SSL_KEY_STORE__"));
    stringBuffer.append(TEXT_425);
    passwordFieldName = "__MQTT_SSL_KEY_STORE_PASSWORD__";
    stringBuffer.append(TEXT_426);
     if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_427);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_428);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_429);
    } else {
    stringBuffer.append(TEXT_430);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_431);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_432);
    }
    stringBuffer.append(TEXT_433);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_434);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_435);
    }
    stringBuffer.append(TEXT_436);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_437);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_438);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_439);
    
                } else if ("Other".equals(mqType)) {

    stringBuffer.append(TEXT_440);
    stringBuffer.append(TEXT_441);
    stringBuffer.append(ElementParameterParser.getValue(node, "__OTHER_CODE__"));
    stringBuffer.append(TEXT_442);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_443);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_444);
    stringBuffer.append(transactedMethodStr);
    stringBuffer.append(TEXT_445);
    
                }

            }

    List< ? extends INode> processNodes = (List< ? extends INode>)process.getGraphicalNodes();
    for (INode node : processNodes) {
            if (!node.isActivate()) {
                continue;
            }
            String nodeComponentName = node.getComponent().getName();
    if("cSOAP".equals(nodeComponentName)){
            IElementParameter param = node.getElementParameter("LABEL");
            String cid = node.getUniqueName();
            NodeParamsHelper helper = new NodeParamsHelper(node);
            String uri = "";
            String statements = null;
            // http://jira.talendforge.org/browse/TESB-5241
            /*
             * change to use label + unique to make it unique but readable
             */
//          if(param != null && !"__UNIQUE_NAME__".equals(param.getValue())){
//              cid = (String)param.getValue()+"_"+cid;
//          }
            String endpointVar = "endpoint_" + node.getUniqueName();
            
    
// included in header_route.javajet
// available variables :
// INode node;
// String cid;
// String componentName;
// NodeParamsHelper helper;
// return values:
// String uri = ""; generate the endpoint uri.
// String statements = null; generate the statements before wrapping endpoint uri.

String url = ElementParameterParser.getValue(node, "__ADDRESS__").trim();

String dataformat = ElementParameterParser.getValue(node, "__DATAFORMAT__");

boolean useServiceRegistry = helper.getVisibleBoolParam("__ENABLE_REGISTRY__");
if(!isStudioEEVersion || "RAW".equals(dataformat) || "CXF_MESSAGE".equals(dataformat)){
	useServiceRegistry = false;
}

boolean useSecurity = helper.getVisibleBoolParam("__ENABLE_SECURITY__");
if(useServiceRegistry || "RAW".equals(dataformat) || "CXF_MESSAGE".equals(dataformat)){
	useSecurity = false;
}

List<? extends IConnection> conns = node.getIncomingConnections();
if ("true".equals(ElementParameterParser.getValue(node, "__ENABLE_SL__")) 
		&&  (!useServiceRegistry)) {
	if (!conns.isEmpty()) {
		// consumer role
		url = "\"locator://locator/\"";
	}
}

String serviceType = ElementParameterParser.getValue(node, "__SERVICE_TYPE__");

StringBuilder sb = new StringBuilder();
sb.append("\"cxf://\"+").append(url);
sb.append("+\"?dataFormat=" + dataformat + "\"");
if("PAYLOAD".equals(dataformat)){
	sb.append("+\"&allowStreaming="+ElementParameterParser.getValue(node, "__ALLOW_STREAMING__")+"\"");
}
if ("true".equals(ElementParameterParser.getValue(node, "__LOG_MESSAGES__"))) {
	sb.append("+\"&loggingFeatureEnabled=true\"");
}

if ("wsdlURL".equals(serviceType)) {
	if(!useServiceRegistry){
		sb.append("+\"&" + serviceType + "=\"");
		//http://jira.talendforge.org/browse/TESB-6226
        final String filePath;
		if("file".equals(ElementParameterParser.getValue(node, "__WSDL_TYPE__"))){
		    filePath =  ElementParameterParser.getValue(node, "__WSDL_FILE__");
		}else{
			filePath = "getClass().getResource(\"/"
			    + org.talend.core.model.utils.JavaResourcesHelper.getResouceClasspath(
			        ElementParameterParser.getValue(node, "__WSDL_FILE_REPO__"),
			        ElementParameterParser.getValue(node, "__ROUTE_RESOURCE_TYPE_VERSION__"))
			    + "\").toString()";
		}
		sb.append("+").append(filePath.replaceAll("\\\\","/"));
	} else {
		sb.append("+\"&wsdlURL=\"");
	}
} else {
	sb.append("+\"&" + serviceType + "=\"");
	sb.append("+" + ElementParameterParser.getValue(node, "__SERVICE_CLASS__"));
}




String serviceName = helper.getVisibleStringParam("__SERVICE_NAME__").trim();
if(!serviceName.isEmpty() && !serviceName.equals("\"\"")) {
	sb.append("+\"&serviceName=\"+").append(serviceName);
}
String portName = helper.getVisibleStringParam("__PORT_NAME__").trim();
if(!portName.isEmpty() && !portName.equals("\"\"")) {
	sb.append("+\"&endpointName=\"+").append(portName);
}
String operationName = helper.getVisibleStringParam("__OPERATION_NAME__").trim();
if(!operationName.isEmpty() && !operationName.equals("") && !operationName.equals("\"\"") ) {
	sb.append("+\"&defaultOperationNamespace=\"+javax.xml.namespace.QName.valueOf(").append(operationName).append(").getNamespaceURI()")
	.append("+\"&defaultOperationName=\"+javax.xml.namespace.QName.valueOf(").append(operationName).append(").getLocalPart()");
}

List<Map<String, String>> tableValues = (List<Map<String, String>>) ElementParameterParser.getObjectValue(node, "__ADVARGUMENTS__");
for (Map<String, String> map : tableValues) {
	String argName = map.get("NAME").trim();
	String argValue = map.get("VALUE").trim();
	sb.append("+\"&\"+" + argName + "+\"=\"+" + argValue);
}

if(!conns.isEmpty()){
	sb.append("+\"&headerFilterStrategy=#CXF_PAYLOAD_HEADER_FILTER\"");
	sb.append("+\"&properties.id=\"+\"");
	sb.append(node.getUniqueName());
	sb.append("\"");
}else if(useServiceRegistry || (useSecurity && "SAML".equals(ElementParameterParser.getValue(node, "__SECURITY_TYPE__")))) {
	sb.append("+\"&cxfBinding=#DEFAULT_CXF_BINDING\"");
}
uri = sb.toString();

    
            String formatType = ElementParameterParser.getValue(node, "__DATAFORMAT__");

            boolean useRegistry = false;
            useSecurity = false;
            if(!"RAW".equals(formatType) && !"CXF_MESSAGE".equals(formatType)){
                if(isStudioEEVersion){
                    useRegistry = "true".equals(ElementParameterParser.getValue(node, "__ENABLE_REGISTRY__"));
                }
                if(!useRegistry){
                    useSecurity = "true".equals(ElementParameterParser.getValue(node, "__ENABLE_SECURITY__"));
                }
            }

            String securityType = ElementParameterParser.getValue(node, "__SECURITY_TYPE__");
            String username = ElementParameterParser.getValue(node, "__USERNAME__");
            String alias = ElementParameterParser.getValue(node, "__ALIASNAME__").trim();
            boolean isProvider = node.getIncomingConnections().isEmpty();
            boolean isUseAuthorization = false;
            String securityToken = "(String[])null";
            boolean isUsePropagateSamlUP = false;
            boolean isUsePropagateSamlAP = false;
            if(useRegistry){
                securityToken = "\"Registry\"";
                    String usePropagate = ElementParameterParser.getValue(node, "__USE_PROPAGATE_CREDENTIAL__");
                    if("true".equals(usePropagate)){
                        if(alias == null || alias.matches("\"?\\s*\"?")) {
                            //no alias.
                            isUsePropagateSamlUP = true;
                        }else {
                            isUsePropagateSamlUP = false;
                        }
                        isUsePropagateSamlAP = !isUsePropagateSamlUP;
                    }
            }else if(useSecurity){
                if("USER".equals(securityType)){
                    securityToken = "\"UsernameToken\"";
                }else if("SAML".equals(securityType)){
                    securityToken = "\"SAMLToken\"";
                    String samlSecurityType = ElementParameterParser.getValue(node, "__SAML_SECURITY_TYPES__");
                    if("PROPAGATE_UP".equals(samlSecurityType)) {
                            isUsePropagateSamlUP = true;
                    }else if ("PROPAGATE_AP".equals(samlSecurityType)) {
                        isUsePropagateSamlAP = true;
                        username = "null";
                    }
                    if(isStudioEEVersion){
                        isUseAuthorization = "true".equals(ElementParameterParser.getValue(node, "__USE_AUTHORIZATION__"));
                    }
                }else if("BASIC".equals(securityType)){
                    securityToken = "org.apache.cxf.transport.http.auth.HttpAuthHeader.AUTH_TYPE_BASIC";
                }else if("DIGEST".equals(securityType)){
                    securityToken = "org.apache.cxf.transport.http.auth.HttpAuthHeader.AUTH_TYPE_DIGEST";
                }
            }
            String roleName = "\"\"";
            if(!isProvider && (useRegistry || isUseAuthorization)) {
                roleName = ElementParameterParser.getValue(node, "__ROLE_NAME__");
                if(null == roleName || "".equals(roleName)){
                    roleName = "\"\"";
                }
            }

            if((useSecurity || useRegistry) && !isProvider) {
                String passwordFieldName = "__PASSWORD__";

    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_446);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_447);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_448);
    } else {
    stringBuffer.append(TEXT_449);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_450);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_451);
    }
    
            }

    stringBuffer.append(TEXT_452);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_453);
    stringBuffer.append(endpointVar);
    stringBuffer.append(TEXT_454);
    stringBuffer.append(uri);
    stringBuffer.append(TEXT_455);
    stringBuffer.append(isProvider);
    stringBuffer.append(TEXT_456);
    stringBuffer.append(isUseAuthorization);
    stringBuffer.append(TEXT_457);
    stringBuffer.append(isUsePropagateSamlAP);
    stringBuffer.append(TEXT_458);
    stringBuffer.append(securityToken);
    
                if((useSecurity || useRegistry) && !isProvider){

    stringBuffer.append(TEXT_459);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_460);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_461);
    stringBuffer.append(roleName);
    stringBuffer.append(TEXT_462);
    stringBuffer.append(alias);
    
                }

    stringBuffer.append(TEXT_463);
    if("true".equals(ElementParameterParser.getValue(node, "__ENABLE_CXF_MESSAGE_GZIP__"))){
    stringBuffer.append(TEXT_464);
    stringBuffer.append(endpointVar);
    stringBuffer.append(TEXT_465);
    }
    

            if((isUsePropagateSamlUP || isUsePropagateSamlAP) && !isProvider){

    stringBuffer.append(TEXT_466);
    stringBuffer.append(endpointVar);
    stringBuffer.append(TEXT_467);
    stringBuffer.append(endpointVar);
    stringBuffer.append(TEXT_468);
    
            }
            String useSL = ElementParameterParser.getValue(node, "__ENABLE_SL__");
            String useSAM = ElementParameterParser.getValue(node, "__ENABLE_SAM__");
            String useCorrelation = ElementParameterParser.getValue(node, "__ENABLE_CORRELATION__");
            if("RAW".equals(formatType)){
                useCorrelation = "false";
            }

            if ("true".equals(useCorrelation) || useRegistry) {

    stringBuffer.append(TEXT_469);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_470);
    stringBuffer.append(ElementParameterParser.getValue(node, "__CORRELATION_VALUE__"));
    stringBuffer.append(TEXT_471);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_472);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_473);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_474);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_475);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_476);
    stringBuffer.append(TEXT_477);
    stringBuffer.append(endpointVar);
    stringBuffer.append(TEXT_478);
     if (!useRegistry) { 
    stringBuffer.append(TEXT_479);
    stringBuffer.append(endpointVar);
    stringBuffer.append(TEXT_480);
     } 
              }
            if ("true".equals(useSL) && (isProvider || !useRegistry)) {
                if (!isProvider) {

    stringBuffer.append(TEXT_481);
    stringBuffer.append(TEXT_482);
    stringBuffer.append(endpointVar);
    stringBuffer.append(TEXT_483);
    
                }
                List<Map<String, String>> customProperties = (List<Map<String,String>>) ElementParameterParser.getObjectValue(node, "__SL_META_DATA__");

    stringBuffer.append(TEXT_484);
    stringBuffer.append(endpointVar);
    if(exportTypeSpringBoot){
    if(isProvider){
    stringBuffer.append(TEXT_485);
    stringBuffer.append(endpointVar);
    stringBuffer.append(TEXT_486);
     }else {
    stringBuffer.append(TEXT_487);
    stringBuffer.append(endpointVar);
    stringBuffer.append(TEXT_488);
    }
    }else{
    stringBuffer.append(TEXT_489);
    stringBuffer.append(TEXT_490);
    stringBuffer.append(endpointVar);
    stringBuffer.append(TEXT_491);
    }
    stringBuffer.append(TEXT_492);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_493);
    stringBuffer.append(endpointVar);
    stringBuffer.append(TEXT_494);
     if (!customProperties.isEmpty()) { 
    stringBuffer.append(TEXT_495);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_496);
     for (Map<String, String> custProp : customProperties) { 
    stringBuffer.append(TEXT_497);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_498);
    stringBuffer.append(custProp.get("NAME"));
    stringBuffer.append(TEXT_499);
    stringBuffer.append(custProp.get("VALUE"));
    stringBuffer.append(TEXT_500);
     } 
    stringBuffer.append(TEXT_501);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_502);
    stringBuffer.append(endpointVar);
    stringBuffer.append(TEXT_503);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_504);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_505);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_506);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_507);
    stringBuffer.append(endpointVar);
    stringBuffer.append(TEXT_508);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_509);
     } 
    stringBuffer.append(TEXT_510);
    stringBuffer.append(TEXT_511);
    stringBuffer.append(endpointVar);
    stringBuffer.append(TEXT_512);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_513);
    
            } else if (useRegistry && !isProvider) {
                List<Map<String, String>> customProperties = (List<Map<String,String>>) ElementParameterParser.getObjectValue(node, "__SL_META_DATA__");
                if (!customProperties.isEmpty()) { 

    stringBuffer.append(TEXT_514);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_515);
     for (Map<String, String> custProp : customProperties) { 
    stringBuffer.append(TEXT_516);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_517);
    stringBuffer.append(custProp.get("NAME"));
    stringBuffer.append(TEXT_518);
    stringBuffer.append(custProp.get("VALUE"));
    stringBuffer.append(TEXT_519);
     } 
    stringBuffer.append(TEXT_520);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_521);
    stringBuffer.append(endpointVar);
    stringBuffer.append(TEXT_522);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_523);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_524);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_525);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_526);
    stringBuffer.append(TEXT_527);
    stringBuffer.append(endpointVar);
    stringBuffer.append(TEXT_528);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_529);
    
                }
            }

    stringBuffer.append(TEXT_530);
    
            if ("true".equals(useSAM) && !"RAW".equals(formatType) && !useRegistry) {

    stringBuffer.append(TEXT_531);
    stringBuffer.append(endpointVar);
    stringBuffer.append(TEXT_532);
    stringBuffer.append(endpointVar);
    stringBuffer.append(TEXT_533);
    stringBuffer.append(endpointVar);
    stringBuffer.append(TEXT_534);
    stringBuffer.append(endpointVar);
    stringBuffer.append(TEXT_535);
    stringBuffer.append(TEXT_536);
    stringBuffer.append(endpointVar);
    stringBuffer.append(TEXT_537);
    stringBuffer.append(endpointVar);
    stringBuffer.append(TEXT_538);
    
            }
            if (!useRegistry && !isProvider) {

    stringBuffer.append(TEXT_539);
    stringBuffer.append(endpointVar);
    stringBuffer.append(TEXT_540);
    stringBuffer.append(TEXT_541);
    stringBuffer.append(endpointVar);
    stringBuffer.append(TEXT_542);
    stringBuffer.append(TEXT_543);
    stringBuffer.append(endpointVar);
    stringBuffer.append(TEXT_544);
    
            } 
			
    }else if("cFtp".equals(nodeComponentName)){
            String cid = node.getUniqueName();
            String passwordFieldName = "__PASSWORD__";

    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_545);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_546);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_547);
    } else {
    stringBuffer.append(TEXT_548);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_549);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_550);
    }
    stringBuffer.append(TEXT_551);
    

    }else if("cMail".equals(nodeComponentName)){
            String cid = node.getUniqueName();
            String passwordFieldName = "__PASSWORD__";

    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_552);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_553);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_554);
    } else {
    stringBuffer.append(TEXT_555);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_556);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_557);
    }
    stringBuffer.append(TEXT_558);
      }else if("cAggregate".equals(nodeComponentName)){
                boolean usePersistence = "true".equals(ElementParameterParser.getValue(node, "__USE_PERSISTENCE__"));
                String repository = ElementParameterParser.getValue(node, "__REPOSITORY__");
                if (usePersistence) {
                    boolean useRecovery = "true".equals(ElementParameterParser.getValue(node, "__USE_RECOVERY__"));
                    String recoveryInterval = ElementParameterParser.getValue(node, "__RECOVERY_INTERVAL__");
                    String deadLetterUri = ElementParameterParser.getValue(node, "__DEAD_LETTER_URI__");
                    String maximumRedeliveries = ElementParameterParser.getValue(node, "__MAXIMUM_REDELIVERIES__");

                    if ("AGGREGATION".equals(repository)) {

    stringBuffer.append(TEXT_559);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_560);
    stringBuffer.append(ElementParameterParser.getValue(node, "__CUSTOM_REPOSITORY__") );
    stringBuffer.append(TEXT_561);
    
                    } else if ("RECOVERABLE".equals(repository)) {

    stringBuffer.append(TEXT_562);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_563);
    stringBuffer.append(ElementParameterParser.getValue(node, "__CUSTOM_REPOSITORY__") );
    stringBuffer.append(TEXT_564);
    
                        if (useRecovery) {

    stringBuffer.append(TEXT_565);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_566);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_567);
    stringBuffer.append(maximumRedeliveries);
    stringBuffer.append(TEXT_568);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_569);
    stringBuffer.append(deadLetterUri);
    stringBuffer.append(TEXT_570);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_571);
    stringBuffer.append(recoveryInterval);
    stringBuffer.append(TEXT_572);
    
                        }
                    } else if ("HAWTDB".equals(repository)) {
                        boolean usePersistentFile = "true".equals(ElementParameterParser.getValue(node, "__USE_PERSISTENT_FILE__"));
                        String persistentFile = ElementParameterParser.getValue(node, "__PERSISTENT_FILENAME__");
                        if (usePersistentFile) {

    stringBuffer.append(TEXT_573);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_574);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_575);
    stringBuffer.append(persistentFile);
    stringBuffer.append(TEXT_576);
    
                        } else {

    stringBuffer.append(TEXT_577);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_578);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_579);
    
                        }
                        if (useRecovery) {

    stringBuffer.append(TEXT_580);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_581);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_582);
    stringBuffer.append(maximumRedeliveries);
    stringBuffer.append(TEXT_583);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_584);
    stringBuffer.append(deadLetterUri);
    stringBuffer.append(TEXT_585);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_586);
    stringBuffer.append(recoveryInterval);
    stringBuffer.append(TEXT_587);
    
                        }
                    }
                }

                String language = ElementParameterParser.getValue(node, "__LANGUAGES__");
                String useNamespaces = ElementParameterParser.getValue(node, "__USE_NAMESPACES__");
                List<Map<String, String>> namespaceValues = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__NAMESPACES__");
                if("xpath".equals(language)&&"true".equals(useNamespaces)){
                    String cid = node.getUniqueName();


    stringBuffer.append(TEXT_588);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_589);
    
                    for(Map<String, String> m: namespaceValues){
                        String pre = m.get("PREFIX");
                        String uri = m.get("URI");

    stringBuffer.append(TEXT_590);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_591);
    stringBuffer.append(pre);
    stringBuffer.append(TEXT_592);
    stringBuffer.append(uri);
    stringBuffer.append(TEXT_593);
    
                    }

    stringBuffer.append(TEXT_594);
    
                }
    }else if("cLoop".equals(nodeComponentName)){
        String type = ElementParameterParser.getValue(node, "__LOOP_TYPE__");
        if(!"EXPRESSION_TYPE".equals(type)){
            continue;
        }
        String language = ElementParameterParser.getValue(node, "__LANGUAGES__");
        if(!"xpath".equals(language)){
            continue;
        }
        String useNamespaces = ElementParameterParser.getValue(node, "__USE_NAMESPACES__");
        if(!"true".equals(useNamespaces)){
            continue;
        }
        String cid = node.getUniqueName();
        List<Map<String, String>> namespaceValues = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__NAMESPACES__");

    stringBuffer.append(TEXT_595);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_596);
    
            for(Map<String, String> m: namespaceValues){
                String pre = m.get("PREFIX");
                String uri = m.get("URI");

    stringBuffer.append(TEXT_597);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_598);
    stringBuffer.append(pre);
    stringBuffer.append(TEXT_599);
    stringBuffer.append(uri);
    stringBuffer.append(TEXT_600);
    
            }

    stringBuffer.append(TEXT_601);
      } else if("cAWSS3".equals(nodeComponentName)){
       String cid = node.getUniqueName();
       List<Map<String, String>> userDefinedHeaders = (List<Map<String, String>>) ElementParameterParser.getObjectValue(node, "__MESSAGE_HEADERS_USER_DEFINED__");
       String useMessageHeadersUserDefined = ElementParameterParser.getValue(node, "__USE_MESSAGE_HEADERS_USER_DEFINED__");

    if(("true".equals(useMessageHeadersUserDefined)) && (userDefinedHeaders.size()>0)){
    stringBuffer.append(TEXT_602);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_603);
    
                for (Map<String, String> map : userDefinedHeaders) {
            
    stringBuffer.append(TEXT_604);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_605);
    stringBuffer.append(map.get("MESSAGE_HEADER_USER_DEFINED"));
    stringBuffer.append(TEXT_606);
    stringBuffer.append(map.get("MESSAGE_HEADER_VALUE_USER_DEFINED"));
    stringBuffer.append(TEXT_607);
    }
    }
      } else if("cAWSSES".equals(nodeComponentName)){
       String cid = node.getUniqueName();
       List<Map<String, String>> messageHeaders = (List<Map<String, String>>) ElementParameterParser.getObjectValue(node, "__MESSAGE_HEADERS__");

    if(messageHeaders.size()>0){ 
            for (Map<String, String> map : messageHeaders) {
        
    if(map.get("MESSAGE_HEADER").equals("CamelAwsSesTo")){
    stringBuffer.append(TEXT_608);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_609);
    stringBuffer.append(map.get("MESSAGE_HEADER_VALUE"));
    stringBuffer.append(TEXT_610);
    }else if(map.get("MESSAGE_HEADER").equals("CamelAwsSesReplyToAddresses")){
    stringBuffer.append(TEXT_611);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_612);
    stringBuffer.append(map.get("MESSAGE_HEADER_VALUE"));
    stringBuffer.append(TEXT_613);
    }
    
            }
         }
       
    
    } else if("cMessageRouter".equals(nodeComponentName)){
        for (IConnection param : node.getOutgoingConnections()) {
            String ct = param.getRouteConnectionType();
            if ("xpath".equals(ct)) {
                String language = ElementParameterParser.getValue(param, "__ROUTETYPE__");
                String useNamespaces = ElementParameterParser.getValue(param, "__USE_NAMESPACES__");
                if(!"true".equals(useNamespaces)){
                    continue;
                }
                String cid = param.getUniqueName();
                List<Map<String, String>> namespaceValues = (List<Map<String,String>>)ElementParameterParser.getObjectValue(param, "__NAMESPACES__");

    stringBuffer.append(TEXT_614);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_615);
    
            for(Map<String, String> m: namespaceValues){
                String pre = m.get("PREFIX");
                String uri = m.get("URI");

    stringBuffer.append(TEXT_616);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_617);
    stringBuffer.append(pre);
    stringBuffer.append(TEXT_618);
    stringBuffer.append(uri);
    stringBuffer.append(TEXT_619);
    
            }

    stringBuffer.append(TEXT_620);
    
            }
        }
    } else if("cRecipientList".equals(nodeComponentName)||"cSplitter".equals(nodeComponentName) 
            || "cSetBody".equals(nodeComponentName) || "cMessageFilter".equals(nodeComponentName)) {
        String language = ElementParameterParser.getValue(node, "__LANGUAGES__");
        if(!"xpath".equals(language)){
            continue;
        }
        String useNamespaces = ElementParameterParser.getValue(node, "__USE_NAMESPACES__");
        if(!"true".equals(useNamespaces)){
            continue;
        }
        String cid = node.getUniqueName();
        List<Map<String, String>> namespaceValues = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__NAMESPACES__");

    stringBuffer.append(TEXT_621);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_622);
    
            for(Map<String, String> m: namespaceValues){
                String pre = m.get("PREFIX");
                String uri = m.get("URI");

    stringBuffer.append(TEXT_623);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_624);
    stringBuffer.append(pre);
    stringBuffer.append(TEXT_625);
    stringBuffer.append(uri);
    stringBuffer.append(TEXT_626);
    
            }

    stringBuffer.append(TEXT_627);
    
    }else if("cSetHeader".equals(nodeComponentName) || "cSetProperty".equals(nodeComponentName)){
        String useNamespaces = ElementParameterParser.getValue(node, "__USE_NAMESPACES__");
        if(!"true".equals(useNamespaces)){
            continue;
        }
        List<Map<String, String>> tableValues =
            (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__VALUES__");
        boolean hasXPath = false;
        for(Map<String, String> propertiesMap: tableValues){
            String propertyLanguage = propertiesMap.get("LANGUAGE");
            if ("xpath".equals(propertyLanguage)) {
                hasXPath = true;
                break;
            }
        }
        if (hasXPath) {
            String cid = node.getUniqueName();
            List<Map<String, String>> namespaceValues = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__NAMESPACES__");

    stringBuffer.append(TEXT_628);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_629);
    
            for(Map<String, String> m: namespaceValues){
                String pre = m.get("PREFIX");
                String uri = m.get("URI");

    stringBuffer.append(TEXT_630);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_631);
    stringBuffer.append(pre);
    stringBuffer.append(TEXT_632);
    stringBuffer.append(uri);
    stringBuffer.append(TEXT_633);
    
            }

    stringBuffer.append(TEXT_634);
          }
    } else if ("cWireTap".equals(nodeComponentName) || "cLoadBalancer".equals(nodeComponentName) || "cIdempotentConsumer".equals(nodeComponentName)) {
        if("cWireTap".equals(nodeComponentName) && "true".equals(ElementParameterParser.getValue(node, "__COPY_ORIGINAL_MESSAGE__"))){

    stringBuffer.append(TEXT_635);
    
        }
        String language = ElementParameterParser.getValue(node, "__LANGUAGES__");
        if(!"xpath".equals(language)){
            continue;
        }
        String useNamespaces = ElementParameterParser.getValue(node, "__USE_NAMESPACES__");
        if(!"true".equals(useNamespaces)){
            continue;
        }
        String cid = node.getUniqueName();
        List<Map<String, String>> namespaceValues = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__NAMESPACES__");
        if (!namespaceValues.isEmpty()) {

    stringBuffer.append(TEXT_636);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_637);
    

            String ns = "new org.apache.camel.builder.xml.Namespaces";
            for(Map<String, String> m: namespaceValues){
                String pre = m.get("PREFIX");
                String uri = m.get("URI");

    stringBuffer.append(TEXT_638);
    stringBuffer.append(ns);
    stringBuffer.append(TEXT_639);
    stringBuffer.append(pre);
    stringBuffer.append(TEXT_640);
    stringBuffer.append(uri);
    stringBuffer.append(TEXT_641);
    
                ns = cid + "ns.add";
            }
        }

      } else if("cTalendJob".equals(nodeComponentName)){
    if (!node.getIncomingConnections().isEmpty()) {
        String ownerName = process.getName();
        String cid = node.getUniqueName();
        List<Map<String, String>> contextParams = null;
        String useJar = ElementParameterParser.getValue(node, "__FROM_EXTERNAL_JAR__");
        // when propagateHeader parameter will be removed the https://github.com/Talend/tesb-rt-se/blob/master/camel-talendjob/src/main/java/org/talend/camel/TalendProducer.java
        // have to be changed - remove populateTalendContextParamsWithCamelHeaders(exchange, args);
        String propagateHeader = ElementParameterParser.getValue(node, "__PROPAGATE_HEADER__");
        String stickyJob = ElementParameterParser.getValue(node, "__STICKY_JOB__");
        if("true".equals(useJar)){
            String typeName = ElementParameterParser.getValue(node, "__JOB__");
            String context = ElementParameterParser.getValue(node, "__CONTEXT__");
            contextParams = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__EXTERNAL_JAR_CONTEXTPARAMS__");

    stringBuffer.append(TEXT_642);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_643);
    stringBuffer.append(typeName);
    stringBuffer.append(TEXT_644);
    stringBuffer.append(context);
    stringBuffer.append(TEXT_645);
    stringBuffer.append(propagateHeader);
    stringBuffer.append(TEXT_646);
    stringBuffer.append(stickyJob);
    stringBuffer.append(TEXT_647);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_648);
    
        }else{
            String typeName = "";
            contextParams = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__CONTEXTPARAMS__");
            String context = (String) node.getElementParameter("PROCESS_TYPE_CONTEXT").getValue();
            String id = (String) node.getElementParameter("PROCESS_TYPE_PROCESS").getValue();
            if(id != null){
                String useSelectedContext = ElementParameterParser.getValue(node, "__USE_SELECTED_CONTEXT__");
                String useRouteContext = ElementParameterParser.getValue(node, "__USE_ROUTE_CONTEXT__");
                String useJobContext = ElementParameterParser.getValue(node, "__USE_JOB_CONTEXT__");
                if("true".equals(useRouteContext)){
                    // TESB-13614
                    // we can't define context during codegeneration in this case, because
                    // context will provided to the job before execution
                    context = "NOT_DEFINED";

                }else if("true".equals(useJobContext)){
                    context = ElementParameterParser.getProcessSelectedContext(id);
                }

                String jobName = ElementParameterParser.getStringElementParameterValue(node.getElementParameter("SELECTED_JOB_NAME"));
//              String jobName = (String) node.getElementParameter("SELECTED_JOB_NAME").getValue();
                String jobVersion = ElementParameterParser.getStringElementParameterValue(node.getElementParameter("PROCESS_TYPE_VERSION"));
                String jobFolderName = JavaResourcesHelper.getJobFolderName(jobName, jobVersion);

                try{
                    String selectedId = (String) node.getElementParameter("PROCESS_TYPE_PROCESS").getValue();
                    String selectedContext = (String) node.getElementParameter("PROCESS_TYPE_CONTEXT").getValue();
                    String selectedVersion = (String) node.getElementParameter("PROCESS_TYPE_VERSION").getValue();

                    typeName = org.talend.designer.runprocess.ProcessorUtilities.getMainCommand(selectedId,selectedVersion, selectedContext,org.talend.designer.runprocess.IProcessor.NO_STATISTICS,org.talend.designer.runprocess.IProcessor.NO_TRACES, null)[0];
                }catch(Exception e){
                    typeName = codeGenArgument.getCurrentProjectName().toLowerCase() + "." + jobFolderName + "." + jobName;
                }
            }

            if("NOT_DEFINED".equals(context)){
                String executionContextVariable = "contextStr";

    stringBuffer.append(TEXT_649);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_650);
    stringBuffer.append(ownerName);
    stringBuffer.append(TEXT_651);
    stringBuffer.append(typeName);
    stringBuffer.append(TEXT_652);
    stringBuffer.append(executionContextVariable);
    stringBuffer.append(TEXT_653);
    stringBuffer.append(propagateHeader);
    stringBuffer.append(TEXT_654);
    stringBuffer.append(stickyJob);
    stringBuffer.append(TEXT_655);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_656);
    
            } else {

    stringBuffer.append(TEXT_657);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_658);
    stringBuffer.append(ownerName);
    stringBuffer.append(TEXT_659);
    stringBuffer.append(typeName);
    stringBuffer.append(TEXT_660);
    stringBuffer.append(context);
    stringBuffer.append(TEXT_661);
    stringBuffer.append(propagateHeader);
    stringBuffer.append(TEXT_662);
    stringBuffer.append(stickyJob);
    stringBuffer.append(TEXT_663);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_664);
    
            }
        }
        int contextParamsSize = contextParams.size();
        if(contextParamsSize > 0){

    stringBuffer.append(TEXT_665);
    
        for (int i=0; i<contextParamsSize; i++) {
                Map<String, String> contextParam = contextParams.get(i);
                String paramName;
                String paramValue;
                if("true".equals(useJar)){
                    paramName = contextParam.get("EXTERNAL_JAR_PARAM_NAME_COLUMN");
                    paramValue = contextParam.get("EXTERNAL_JAR_PARAM_VALUE_COLUMN");

                } else {
                    paramName = "\"" + contextParam.get("PARAM_NAME_COLUMN") + "\"";
                    paramValue = contextParam.get("PARAM_VALUE_COLUMN");
                }

    stringBuffer.append(TEXT_666);
    stringBuffer.append(paramName);
    stringBuffer.append(TEXT_667);
    stringBuffer.append(paramValue);
    stringBuffer.append(TEXT_668);
    
        }

    stringBuffer.append(TEXT_669);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_670);
    
    }
    }
    } else if("cAWSConnection".equals(nodeComponentName)){
        String cid = node.getUniqueName();

    
    boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
    boolean hasCredentials = false;
    boolean hasClientConfiguration = false;

    Map<String, String> awsTypeMap = new java.util.HashMap<String, String>() {
        {
            put("cAWSS3",  "com.amazonaws.services.s3.AmazonS3Client");
            put("cAWSSES", "com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClient");
            put("cAWSSQS", "com.amazonaws.services.sqs.AmazonSQSClient");
            put("cAWSSNS", "com.amazonaws.services.sns.AmazonSNSClient");
        }
    };

    boolean configClient = "true".equals(ElementParameterParser.getValue(node, "__CONFIG_CLIENT__"));

    List<Map<String,String>> clientConfiguration = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__CLIENT_CONFIGURATION__");
    String region = ElementParameterParser.getValue(node,"__REGION__");

    if (isLog4jEnabled) {
    
    stringBuffer.append(TEXT_671);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_672);
    
    }

    boolean inheritCredentials = "true".equals(ElementParameterParser.getValue(node, "__INHERIT_CREDENTIALS__"));
    if (inheritCredentials) {
        
    stringBuffer.append(TEXT_673);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_674);
    
    } else {
        String accessKey = ElementParameterParser.getValue(node, "__ACCESS_KEY__");
        String passwordFieldName = "__SECRET_KEY__";
        
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_675);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_676);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_677);
    } else {
    stringBuffer.append(TEXT_678);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_679);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_680);
    }
    stringBuffer.append(TEXT_681);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_682);
    stringBuffer.append(accessKey);
    stringBuffer.append(TEXT_683);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_684);
    
    }

    if (configClient && clientConfiguration.size()>0) {
        
    stringBuffer.append(TEXT_685);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_686);
    
        boolean setBuffer = false;
        for (Map<String,String> map :clientConfiguration) {
            String client_parameter = map.get("CLIENT_PARAMETER");
            String value = map.get("VALUE");
            if (!setBuffer && ("SocketSendBufferSizeHints".equals(client_parameter) || "SocketReceiveBufferSizeHints".equals(client_parameter))) {
                setBuffer=true;
                
    stringBuffer.append(TEXT_687);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_688);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_689);
    
            }
            if("SocketSendBufferSizeHints".equals(client_parameter)){
            
    stringBuffer.append(TEXT_690);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_691);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_692);
    
            }else if("SocketReceiveBufferSizeHints".equals(client_parameter)){
            
    stringBuffer.append(TEXT_693);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_694);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_695);
    
            }else if("Protocol".equals(client_parameter)){
            
    stringBuffer.append(TEXT_696);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_697);
    stringBuffer.append(value.toUpperCase().replaceAll("\"",""));
    stringBuffer.append(TEXT_698);
    
            }else{
            
    stringBuffer.append(TEXT_699);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_700);
    stringBuffer.append(client_parameter);
    stringBuffer.append(TEXT_701);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_702);
    
            }
        }
        if (setBuffer) {
        
    stringBuffer.append(TEXT_703);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_704);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_705);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_706);
    
        }
        hasClientConfiguration = true;
    }

    //generate different aws client for different aws components
    for (INode processNode : process.getGeneratingNodes()) {
        if (processNode.isActivate() && awsTypeMap.containsKey(processNode.getComponent().getName())) {
            String client = ElementParameterParser.getValue(processNode, "__AWS_CONNECTION_CLIENT__");
            if (cid.equals(client)) {
                String clientClass = awsTypeMap.get(processNode.getComponent().getName());
                String clientName = processNode.getComponent().getName() + "_" + cid;
                if(hasClientConfiguration){
                
    stringBuffer.append(TEXT_707);
    stringBuffer.append(clientClass);
    stringBuffer.append(TEXT_708);
    stringBuffer.append(clientName);
    stringBuffer.append(TEXT_709);
    stringBuffer.append(clientClass);
    stringBuffer.append(TEXT_710);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_711);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_712);
    
                }else{
                
    stringBuffer.append(TEXT_713);
    stringBuffer.append(clientClass);
    stringBuffer.append(TEXT_714);
    stringBuffer.append(clientName);
    stringBuffer.append(TEXT_715);
    stringBuffer.append(clientClass);
    stringBuffer.append(TEXT_716);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_717);
                          
                }
                if(region!=null && !region.isEmpty() && !"DEFAULT".equalsIgnoreCase(region)){
                
    stringBuffer.append(TEXT_718);
    stringBuffer.append(clientName);
    stringBuffer.append(TEXT_719);
    stringBuffer.append(region);
    stringBuffer.append(TEXT_720);
    
                }
                
    stringBuffer.append(TEXT_721);
    stringBuffer.append(clientName);
    stringBuffer.append(TEXT_722);
    stringBuffer.append(clientName);
    stringBuffer.append(TEXT_723);
           
                if(isLog4jEnabled){
                
    stringBuffer.append(TEXT_724);
    stringBuffer.append(clientName);
    stringBuffer.append(TEXT_725);
    
                }          
                awsTypeMap.remove(processNode.getComponent().getName());//generate once
            }
        }
    }


    
    }//end cAWSConnection
}

    stringBuffer.append(TEXT_726);
    return stringBuffer.toString();
  }
}