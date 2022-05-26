// ============================================================================
//
// Copyright (c) 2006-2015, Talend SA
//
// Ce code source a été automatiquement généré par_Talend Open Studio for Data Integration
// / Soumis à la Licence Apache, Version 2.0 (la "Licence") ;
// votre utilisation de ce fichier doit respecter les termes de la Licence.
// Vous pouvez obtenir une copie de la Licence sur
// http://www.apache.org/licenses/LICENSE-2.0
// 
// Sauf lorsqu'explicitement prévu par la loi en vigueur ou accepté par écrit, le logiciel
// distribué sous la Licence est distribué "TEL QUEL",
// SANS GARANTIE OU CONDITION D'AUCUNE SORTE, expresse ou implicite.
// Consultez la Licence pour connaître la terminologie spécifique régissant les autorisations et
// les limites prévues par la Licence.

package keyrus.readfile_v04_2_0_1;

import routines.Numeric;
import routines.DataOperation;
import routines.TalendDataGenerator;
import routines.TalendStringUtil;
import routines.TalendString;
import routines.StringHandling;
import routines.Relational;
import routines.TalendDate;
import routines.Mathematical;
import routines.system.*;
import routines.system.api.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.Comparator;

//the import part of tJavaFlex_3
//import java.util.List;

//the import part of tJavaFlex_4
//import java.util.List;

@SuppressWarnings("unused")

/**
 * Job: ReadFile_V04_2 Purpose: Test creation of the ODS<br>
 * Description: <br>
 * 
 * @author user@talend.com
 * @version 8.0.1.20211109_1610
 * @status
 */
public class ReadFile_V04_2 implements TalendJob {

	protected static void logIgnoredError(String message, Throwable cause) {
		System.err.println(message);
		if (cause != null) {
			cause.printStackTrace();
		}

	}

	public final Object obj = new Object();

	// for transmiting parameters purpose
	private Object valueObject = null;

	public Object getValueObject() {
		return this.valueObject;
	}

	public void setValueObject(Object valueObject) {
		this.valueObject = valueObject;
	}

	private final static String defaultCharset = java.nio.charset.Charset.defaultCharset().name();

	private final static String utf8Charset = "UTF-8";

	// contains type for every context property
	public class PropertiesWithType extends java.util.Properties {
		private static final long serialVersionUID = 1L;
		private java.util.Map<String, String> propertyTypes = new java.util.HashMap<>();

		public PropertiesWithType(java.util.Properties properties) {
			super(properties);
		}

		public PropertiesWithType() {
			super();
		}

		public void setContextType(String key, String type) {
			propertyTypes.put(key, type);
		}

		public String getContextType(String key) {
			return propertyTypes.get(key);
		}
	}

	// create and load default properties
	private java.util.Properties defaultProps = new java.util.Properties();

	// create application properties with default
	public class ContextProperties extends PropertiesWithType {

		private static final long serialVersionUID = 1L;

		public ContextProperties(java.util.Properties properties) {
			super(properties);
		}

		public ContextProperties() {
			super();
		}

		public void synchronizeContext() {

			if (pathFile != null) {

				this.setProperty("pathFile", pathFile.toString());

			}

			if (Logs != null) {

				this.setProperty("Logs", Logs.toString());

			}

			if (ODS_IFRI1_Login != null) {

				this.setProperty("ODS_IFRI1_Login", ODS_IFRI1_Login.toString());

			}

			if (ODS_IFRI1_AdditionalParams != null) {

				this.setProperty("ODS_IFRI1_AdditionalParams", ODS_IFRI1_AdditionalParams.toString());

			}

			if (ODS_IFRI1_Port != null) {

				this.setProperty("ODS_IFRI1_Port", ODS_IFRI1_Port.toString());

			}

			if (ODS_IFRI1_Server != null) {

				this.setProperty("ODS_IFRI1_Server", ODS_IFRI1_Server.toString());

			}

			if (ODS_IFRI1_Schema != null) {

				this.setProperty("ODS_IFRI1_Schema", ODS_IFRI1_Schema.toString());

			}

			if (ODS_IFRI1_Database != null) {

				this.setProperty("ODS_IFRI1_Database", ODS_IFRI1_Database.toString());

			}

			if (ODS_IFRI1_Password != null) {

				this.setProperty("ODS_IFRI1_Password", ODS_IFRI1_Password.toString());

			}

		}

		// if the stored or passed value is "<TALEND_NULL>" string, it mean null
		public String getStringValue(String key) {
			String origin_value = this.getProperty(key);
			if (NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY.equals(origin_value)) {
				return null;
			}
			return origin_value;
		}

		public String pathFile;

		public String getPathFile() {
			return this.pathFile;
		}

		public String Logs;

		public String getLogs() {
			return this.Logs;
		}

		public String ODS_IFRI1_Login;

		public String getODS_IFRI1_Login() {
			return this.ODS_IFRI1_Login;
		}

		public String ODS_IFRI1_AdditionalParams;

		public String getODS_IFRI1_AdditionalParams() {
			return this.ODS_IFRI1_AdditionalParams;
		}

		public String ODS_IFRI1_Port;

		public String getODS_IFRI1_Port() {
			return this.ODS_IFRI1_Port;
		}

		public String ODS_IFRI1_Server;

		public String getODS_IFRI1_Server() {
			return this.ODS_IFRI1_Server;
		}

		public String ODS_IFRI1_Schema;

		public String getODS_IFRI1_Schema() {
			return this.ODS_IFRI1_Schema;
		}

		public String ODS_IFRI1_Database;

		public String getODS_IFRI1_Database() {
			return this.ODS_IFRI1_Database;
		}

		public java.lang.String ODS_IFRI1_Password;

		public java.lang.String getODS_IFRI1_Password() {
			return this.ODS_IFRI1_Password;
		}
	}

	protected ContextProperties context = new ContextProperties(); // will be instanciated by MS.

	public ContextProperties getContext() {
		return this.context;
	}

	private final String jobVersion = "0.1";
	private final String jobName = "ReadFile_V04_2";
	private final String projectName = "KEYRUS";
	public Integer errorCode = null;
	private String currentComponent = "";

	private final java.util.Map<String, Object> globalMap = new java.util.HashMap<String, Object>();
	private final static java.util.Map<String, Object> junitGlobalMap = new java.util.HashMap<String, Object>();

	private final java.util.Map<String, Long> start_Hash = new java.util.HashMap<String, Long>();
	private final java.util.Map<String, Long> end_Hash = new java.util.HashMap<String, Long>();
	private final java.util.Map<String, Boolean> ok_Hash = new java.util.HashMap<String, Boolean>();
	public final java.util.List<String[]> globalBuffer = new java.util.ArrayList<String[]>();

	private RunStat runStat = new RunStat();

	// OSGi DataSource
	private final static String KEY_DB_DATASOURCES = "KEY_DB_DATASOURCES";

	private final static String KEY_DB_DATASOURCES_RAW = "KEY_DB_DATASOURCES_RAW";

	public void setDataSources(java.util.Map<String, javax.sql.DataSource> dataSources) {
		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		for (java.util.Map.Entry<String, javax.sql.DataSource> dataSourceEntry : dataSources.entrySet()) {
			talendDataSources.put(dataSourceEntry.getKey(),
					new routines.system.TalendDataSource(dataSourceEntry.getValue()));
		}
		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}

	public void setDataSourceReferences(List serviceReferences) throws Exception {

		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		java.util.Map<String, javax.sql.DataSource> dataSources = new java.util.HashMap<String, javax.sql.DataSource>();

		for (java.util.Map.Entry<String, javax.sql.DataSource> entry : BundleUtils
				.getServices(serviceReferences, javax.sql.DataSource.class).entrySet()) {
			dataSources.put(entry.getKey(), entry.getValue());
			talendDataSources.put(entry.getKey(), new routines.system.TalendDataSource(entry.getValue()));
		}

		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}

	private final java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
	private final java.io.PrintStream errorMessagePS = new java.io.PrintStream(new java.io.BufferedOutputStream(baos));

	public String getExceptionStackTrace() {
		if ("failure".equals(this.getStatus())) {
			errorMessagePS.flush();
			return baos.toString();
		}
		return null;
	}

	private Exception exception;

	public Exception getException() {
		if ("failure".equals(this.getStatus())) {
			return this.exception;
		}
		return null;
	}

	private class TalendException extends Exception {

		private static final long serialVersionUID = 1L;

		private java.util.Map<String, Object> globalMap = null;
		private Exception e = null;
		private String currentComponent = null;
		private String virtualComponentName = null;

		public void setVirtualComponentName(String virtualComponentName) {
			this.virtualComponentName = virtualComponentName;
		}

		private TalendException(Exception e, String errorComponent, final java.util.Map<String, Object> globalMap) {
			this.currentComponent = errorComponent;
			this.globalMap = globalMap;
			this.e = e;
		}

		public Exception getException() {
			return this.e;
		}

		public String getCurrentComponent() {
			return this.currentComponent;
		}

		public String getExceptionCauseMessage(Exception e) {
			Throwable cause = e;
			String message = null;
			int i = 10;
			while (null != cause && 0 < i--) {
				message = cause.getMessage();
				if (null == message) {
					cause = cause.getCause();
				} else {
					break;
				}
			}
			if (null == message) {
				message = e.getClass().getName();
			}
			return message;
		}

		@Override
		public void printStackTrace() {
			if (!(e instanceof TalendException || e instanceof TDieException)) {
				if (virtualComponentName != null && currentComponent.indexOf(virtualComponentName + "_") == 0) {
					globalMap.put(virtualComponentName + "_ERROR_MESSAGE", getExceptionCauseMessage(e));
				}
				globalMap.put(currentComponent + "_ERROR_MESSAGE", getExceptionCauseMessage(e));
				System.err.println("Exception in component " + currentComponent + " (" + jobName + ")");
			}
			if (!(e instanceof TDieException)) {
				if (e instanceof TalendException) {
					e.printStackTrace();
				} else {
					e.printStackTrace();
					e.printStackTrace(errorMessagePS);
					ReadFile_V04_2.this.exception = e;
				}
			}
			if (!(e instanceof TalendException)) {
				try {
					for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
						if (m.getName().compareTo(currentComponent + "_error") == 0) {
							m.invoke(ReadFile_V04_2.this, new Object[] { e, currentComponent, globalMap });
							break;
						}
					}

					if (!(e instanceof TDieException)) {
					}
				} catch (Exception e) {
					this.e.printStackTrace();
				}
			}
		}
	}

	public void tFileList_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileList_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tFileInputExcel_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileList_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tMap_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileList_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tJavaFlex_3_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileList_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tJavaFlex_4_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileList_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tReplace_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileList_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tUnpivotRow_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileList_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tLogRow_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileList_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tSortRow_2_SortOut_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		tSortRow_2_SortIn_error(exception, errorComponent, globalMap);

	}

	public void tSortRow_2_SortIn_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileList_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tFileList_1_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public static class row3Struct implements routines.system.IPersistableRow<row3Struct> {
		final static byte[] commonByteArrayLock_KEYRUS_ReadFile_V04_2 = new byte[0];
		static byte[] commonByteArray_KEYRUS_ReadFile_V04_2 = new byte[0];

		public Integer ID;

		public Integer getID() {
			return this.ID;
		}

		public String WEEK;

		public String getWEEK() {
			return this.WEEK;
		}

		public String DAY;

		public String getDAY() {
			return this.DAY;
		}

		public String Date;

		public String getDate() {
			return this.Date;
		}

		public String Circuit;

		public String getCircuit() {
			return this.Circuit;
		}

		public String Van;

		public String getVan() {
			return this.Van;
		}

		public String pivot_key;

		public String getPivot_key() {
			return this.pivot_key;
		}

		public String pivot_value;

		public String getPivot_value() {
			return this.pivot_value;
		}

		public String Routes;

		public String getRoutes() {
			return this.Routes;
		}

		public String Univers;

		public String getUnivers() {
			return this.Univers;
		}

		public String Nb_visites;

		public String getNb_visites() {
			return this.Nb_visites;
		}

		public String Nb_visites_achat;

		public String getNb_visites_achat() {
			return this.Nb_visites_achat;
		}

		private Integer readInteger(ObjectInputStream dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException {
			if (intNum == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeInt(intNum);
			}
		}

		private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (intNum == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeInt(intNum);
			}
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_KEYRUS_ReadFile_V04_2.length) {
					if (length < 1024 && commonByteArray_KEYRUS_ReadFile_V04_2.length == 0) {
						commonByteArray_KEYRUS_ReadFile_V04_2 = new byte[1024];
					} else {
						commonByteArray_KEYRUS_ReadFile_V04_2 = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_KEYRUS_ReadFile_V04_2, 0, length);
				strReturn = new String(commonByteArray_KEYRUS_ReadFile_V04_2, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_KEYRUS_ReadFile_V04_2.length) {
					if (length < 1024 && commonByteArray_KEYRUS_ReadFile_V04_2.length == 0) {
						commonByteArray_KEYRUS_ReadFile_V04_2 = new byte[1024];
					} else {
						commonByteArray_KEYRUS_ReadFile_V04_2 = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_KEYRUS_ReadFile_V04_2, 0, length);
				strReturn = new String(commonByteArray_KEYRUS_ReadFile_V04_2, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_KEYRUS_ReadFile_V04_2) {

				try {

					int length = 0;

					this.ID = readInteger(dis);

					this.WEEK = readString(dis);

					this.DAY = readString(dis);

					this.Date = readString(dis);

					this.Circuit = readString(dis);

					this.Van = readString(dis);

					this.pivot_key = readString(dis);

					this.pivot_value = readString(dis);

					this.Routes = readString(dis);

					this.Univers = readString(dis);

					this.Nb_visites = readString(dis);

					this.Nb_visites_achat = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_KEYRUS_ReadFile_V04_2) {

				try {

					int length = 0;

					this.ID = readInteger(dis);

					this.WEEK = readString(dis);

					this.DAY = readString(dis);

					this.Date = readString(dis);

					this.Circuit = readString(dis);

					this.Van = readString(dis);

					this.pivot_key = readString(dis);

					this.pivot_value = readString(dis);

					this.Routes = readString(dis);

					this.Univers = readString(dis);

					this.Nb_visites = readString(dis);

					this.Nb_visites_achat = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// Integer

				writeInteger(this.ID, dos);

				// String

				writeString(this.WEEK, dos);

				// String

				writeString(this.DAY, dos);

				// String

				writeString(this.Date, dos);

				// String

				writeString(this.Circuit, dos);

				// String

				writeString(this.Van, dos);

				// String

				writeString(this.pivot_key, dos);

				// String

				writeString(this.pivot_value, dos);

				// String

				writeString(this.Routes, dos);

				// String

				writeString(this.Univers, dos);

				// String

				writeString(this.Nb_visites, dos);

				// String

				writeString(this.Nb_visites_achat, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// Integer

				writeInteger(this.ID, dos);

				// String

				writeString(this.WEEK, dos);

				// String

				writeString(this.DAY, dos);

				// String

				writeString(this.Date, dos);

				// String

				writeString(this.Circuit, dos);

				// String

				writeString(this.Van, dos);

				// String

				writeString(this.pivot_key, dos);

				// String

				writeString(this.pivot_value, dos);

				// String

				writeString(this.Routes, dos);

				// String

				writeString(this.Univers, dos);

				// String

				writeString(this.Nb_visites, dos);

				// String

				writeString(this.Nb_visites_achat, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("ID=" + String.valueOf(ID));
			sb.append(",WEEK=" + WEEK);
			sb.append(",DAY=" + DAY);
			sb.append(",Date=" + Date);
			sb.append(",Circuit=" + Circuit);
			sb.append(",Van=" + Van);
			sb.append(",pivot_key=" + pivot_key);
			sb.append(",pivot_value=" + pivot_value);
			sb.append(",Routes=" + Routes);
			sb.append(",Univers=" + Univers);
			sb.append(",Nb_visites=" + Nb_visites);
			sb.append(",Nb_visites_achat=" + Nb_visites_achat);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row3Struct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public static class row8Struct implements routines.system.IPersistableRow<row8Struct> {
		final static byte[] commonByteArrayLock_KEYRUS_ReadFile_V04_2 = new byte[0];
		static byte[] commonByteArray_KEYRUS_ReadFile_V04_2 = new byte[0];

		public Integer ID;

		public Integer getID() {
			return this.ID;
		}

		public String WEEK;

		public String getWEEK() {
			return this.WEEK;
		}

		public String DAY;

		public String getDAY() {
			return this.DAY;
		}

		public String Date;

		public String getDate() {
			return this.Date;
		}

		public String Circuit;

		public String getCircuit() {
			return this.Circuit;
		}

		public String Van;

		public String getVan() {
			return this.Van;
		}

		public String PET_EMN_33CL;

		public String getPET_EMN_33CL() {
			return this.PET_EMN_33CL;
		}

		public String PET_EMN_33CL_B_S_Junior;

		public String getPET_EMN_33CL_B_S_Junior() {
			return this.PET_EMN_33CL_B_S_Junior;
		}

		public String PET_EMN_50CL;

		public String getPET_EMN_50CL() {
			return this.PET_EMN_50CL;
		}

		public String PET_EMN_50CL_B_S;

		public String getPET_EMN_50CL_B_S() {
			return this.PET_EMN_50CL_B_S;
		}

		public String PET_EMN_150CL;

		public String getPET_EMN_150CL() {
			return this.PET_EMN_150CL;
		}

		public String PET_EMG_33CL;

		public String getPET_EMG_33CL() {
			return this.PET_EMG_33CL;
		}

		public String PET_EMG_50CL;

		public String getPET_EMG_50CL() {
			return this.PET_EMG_50CL;
		}

		public String PET_EMG_100CL;

		public String getPET_EMG_100CL() {
			return this.PET_EMG_100CL;
		}

		public String PET_SODA_PREMIUM_33CL;

		public String getPET_SODA_PREMIUM_33CL() {
			return this.PET_SODA_PREMIUM_33CL;
		}

		public String PET_SODA_PREMIUM_100CL;

		public String getPET_SODA_PREMIUM_100CL() {
			return this.PET_SODA_PREMIUM_100CL;
		}

		public String PET_SODA_PREMIUM_150CL;

		public String getPET_SODA_PREMIUM_150CL() {
			return this.PET_SODA_PREMIUM_150CL;
		}

		public String PET_SODA_PREMIUM_200CL;

		public String getPET_SODA_PREMIUM_200CL() {
			return this.PET_SODA_PREMIUM_200CL;
		}

		public String PET_PET_SODA_COLA_33CL;

		public String getPET_PET_SODA_COLA_33CL() {
			return this.PET_PET_SODA_COLA_33CL;
		}

		public String PET_SODA_COLA_100CL;

		public String getPET_SODA_COLA_100CL() {
			return this.PET_SODA_COLA_100CL;
		}

		public String PET_SODA_COLA_150CL;

		public String getPET_SODA_COLA_150CL() {
			return this.PET_SODA_COLA_150CL;
		}

		public String PET_SODA_COLA_200CL;

		public String getPET_SODA_COLA_200CL() {
			return this.PET_SODA_COLA_200CL;
		}

		public String PET_EF_P_tifruit_20CL;

		public String getPET_EF_P_tifruit_20CL() {
			return this.PET_EF_P_tifruit_20CL;
		}

		public String PET_EF_33CL;

		public String getPET_EF_33CL() {
			return this.PET_EF_33CL;
		}

		public String PET_EF_100CL;

		public String getPET_EF_100CL() {
			return this.PET_EF_100CL;
		}

		public String PET_EF_150CL;

		public String getPET_EF_150CL() {
			return this.PET_EF_150CL;
		}

		public String PET_EF_200CL;

		public String getPET_EF_200CL() {
			return this.PET_EF_200CL;
		}

		public String PET_EF_Unknown;

		public String getPET_EF_Unknown() {
			return this.PET_EF_Unknown;
		}

		public String PET_EFL_P_tifruit_20CL;

		public String getPET_EFL_P_tifruit_20CL() {
			return this.PET_EFL_P_tifruit_20CL;
		}

		public String PET_EFL_20CL;

		public String getPET_EFL_20CL() {
			return this.PET_EFL_20CL;
		}

		public String PET_EFL_33CL;

		public String getPET_EFL_33CL() {
			return this.PET_EFL_33CL;
		}

		public String PET_EFL_100CL;

		public String getPET_EFL_100CL() {
			return this.PET_EFL_100CL;
		}

		public String PET_EFL_150CL;

		public String getPET_EFL_150CL() {
			return this.PET_EFL_150CL;
		}

		public String PET_SPORTDRINK_50CL;

		public String getPET_SPORTDRINK_50CL() {
			return this.PET_SPORTDRINK_50CL;
		}

		public String PET_SPORTDRINK_Unknown;

		public String getPET_SPORTDRINK_Unknown() {
			return this.PET_SPORTDRINK_Unknown;
		}

		public String PET_JUSPUR_20CL;

		public String getPET_JUSPUR_20CL() {
			return this.PET_JUSPUR_20CL;
		}

		public String PET_JUSPUR_100CL;

		public String getPET_JUSPUR_100CL() {
			return this.PET_JUSPUR_100CL;
		}

		public String PET_BEIZEM_33CL;

		public String getPET_BEIZEM_33CL() {
			return this.PET_BEIZEM_33CL;
		}

		public String PET_BEIZEM_Unknown;

		public String getPET_BEIZEM_Unknown() {
			return this.PET_BEIZEM_Unknown;
		}

		public String PET_EFG_25CL;

		public String getPET_EFG_25CL() {
			return this.PET_EFG_25CL;
		}

		public String PET_EFG_33CL;

		public String getPET_EFG_33CL() {
			return this.PET_EFG_33CL;
		}

		public String PET_EFG_100CL;

		public String getPET_EFG_100CL() {
			return this.PET_EFG_100CL;
		}

		public String PET_EFG_150CL;

		public String getPET_EFG_150CL() {
			return this.PET_EFG_150CL;
		}

		public String PET_ICETHE_25CL;

		public String getPET_ICETHE_25CL() {
			return this.PET_ICETHE_25CL;
		}

		public String PET_ICETHE_100CL;

		public String getPET_ICETHE_100CL() {
			return this.PET_ICETHE_100CL;
		}

		public String PET_ICETHE_150CL;

		public String getPET_ICETHE_150CL() {
			return this.PET_ICETHE_150CL;
		}

		public String VERRE_EMN_25CL;

		public String getVERRE_EMN_25CL() {
			return this.VERRE_EMN_25CL;
		}

		public String VERRE_EMN_50CL;

		public String getVERRE_EMN_50CL() {
			return this.VERRE_EMN_50CL;
		}

		public String VERRE_EMN_100CL;

		public String getVERRE_EMN_100CL() {
			return this.VERRE_EMN_100CL;
		}

		public String VERRE_EMG_25CL;

		public String getVERRE_EMG_25CL() {
			return this.VERRE_EMG_25CL;
		}

		public String VERRE_EMG_50CL;

		public String getVERRE_EMG_50CL() {
			return this.VERRE_EMG_50CL;
		}

		public String VERRE_EMG_100CL;

		public String getVERRE_EMG_100CL() {
			return this.VERRE_EMG_100CL;
		}

		public String VERRE_SODA_25CL;

		public String getVERRE_SODA_25CL() {
			return this.VERRE_SODA_25CL;
		}

		public String VERRE_SODA_100CL;

		public String getVERRE_SODA_100CL() {
			return this.VERRE_SODA_100CL;
		}

		public String VERRE_SODACOLA_25CL;

		public String getVERRE_SODACOLA_25CL() {
			return this.VERRE_SODACOLA_25CL;
		}

		public String VERRE_SODACOLA_100CL;

		public String getVERRE_SODACOLA_100CL() {
			return this.VERRE_SODACOLA_100CL;
		}

		public String VERRE_EF_25CL;

		public String getVERRE_EF_25CL() {
			return this.VERRE_EF_25CL;
		}

		public String VERRE_EF_Unknown;

		public String getVERRE_EF_Unknown() {
			return this.VERRE_EF_Unknown;
		}

		public String VERRE_EFL_25CL;

		public String getVERRE_EFL_25CL() {
			return this.VERRE_EFL_25CL;
		}

		public String VERRE_EFL_Unknown;

		public String getVERRE_EFL_Unknown() {
			return this.VERRE_EFL_Unknown;
		}

		public String VERRE_CF_25CL;

		public String getVERRE_CF_25CL() {
			return this.VERRE_CF_25CL;
		}

		public String VERRE_CF_Unknown;

		public String getVERRE_CF_Unknown() {
			return this.VERRE_CF_Unknown;
		}

		public String VERRE_BOISSON_25CL;

		public String getVERRE_BOISSON_25CL() {
			return this.VERRE_BOISSON_25CL;
		}

		public String VERRE_BOISSON_Unknown;

		public String getVERRE_BOISSON_Unknown() {
			return this.VERRE_BOISSON_Unknown;
		}

		public String VERRE_IZEM_25CL;

		public String getVERRE_IZEM_25CL() {
			return this.VERRE_IZEM_25CL;
		}

		public String VERRE_BG_25CL;

		public String getVERRE_BG_25CL() {
			return this.VERRE_BG_25CL;
		}

		public String VERRE_BG_Unknown;

		public String getVERRE_BG_Unknown() {
			return this.VERRE_BG_Unknown;
		}

		public String VERRE_ICETHE_25CL;

		public String getVERRE_ICETHE_25CL() {
			return this.VERRE_ICETHE_25CL;
		}

		public String VERRE_ICETHE_Unknown;

		public String getVERRE_ICETHE_Unknown() {
			return this.VERRE_ICETHE_Unknown;
		}

		public String CANNETTE_SODA_33CL;

		public String getCANNETTE_SODA_33CL() {
			return this.CANNETTE_SODA_33CL;
		}

		public String CANNETTE_JUS_33CL;

		public String getCANNETTE_JUS_33CL() {
			return this.CANNETTE_JUS_33CL;
		}

		public String CANNETTE_ENERGY_25CL;

		public String getCANNETTE_ENERGY_25CL() {
			return this.CANNETTE_ENERGY_25CL;
		}

		public String CANNETTE_SODACOLA_25CL;

		public String getCANNETTE_SODACOLA_25CL() {
			return this.CANNETTE_SODACOLA_25CL;
		}

		public String CANNETTE_BG_25CL;

		public String getCANNETTE_BG_25CL() {
			return this.CANNETTE_BG_25CL;
		}

		public String Routes;

		public String getRoutes() {
			return this.Routes;
		}

		public String Univers;

		public String getUnivers() {
			return this.Univers;
		}

		public String Nb_visites;

		public String getNb_visites() {
			return this.Nb_visites;
		}

		public String Nb_visites_achat;

		public String getNb_visites_achat() {
			return this.Nb_visites_achat;
		}

		private Integer readInteger(ObjectInputStream dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException {
			if (intNum == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeInt(intNum);
			}
		}

		private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (intNum == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeInt(intNum);
			}
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_KEYRUS_ReadFile_V04_2.length) {
					if (length < 1024 && commonByteArray_KEYRUS_ReadFile_V04_2.length == 0) {
						commonByteArray_KEYRUS_ReadFile_V04_2 = new byte[1024];
					} else {
						commonByteArray_KEYRUS_ReadFile_V04_2 = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_KEYRUS_ReadFile_V04_2, 0, length);
				strReturn = new String(commonByteArray_KEYRUS_ReadFile_V04_2, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_KEYRUS_ReadFile_V04_2.length) {
					if (length < 1024 && commonByteArray_KEYRUS_ReadFile_V04_2.length == 0) {
						commonByteArray_KEYRUS_ReadFile_V04_2 = new byte[1024];
					} else {
						commonByteArray_KEYRUS_ReadFile_V04_2 = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_KEYRUS_ReadFile_V04_2, 0, length);
				strReturn = new String(commonByteArray_KEYRUS_ReadFile_V04_2, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_KEYRUS_ReadFile_V04_2) {

				try {

					int length = 0;

					this.ID = readInteger(dis);

					this.WEEK = readString(dis);

					this.DAY = readString(dis);

					this.Date = readString(dis);

					this.Circuit = readString(dis);

					this.Van = readString(dis);

					this.PET_EMN_33CL = readString(dis);

					this.PET_EMN_33CL_B_S_Junior = readString(dis);

					this.PET_EMN_50CL = readString(dis);

					this.PET_EMN_50CL_B_S = readString(dis);

					this.PET_EMN_150CL = readString(dis);

					this.PET_EMG_33CL = readString(dis);

					this.PET_EMG_50CL = readString(dis);

					this.PET_EMG_100CL = readString(dis);

					this.PET_SODA_PREMIUM_33CL = readString(dis);

					this.PET_SODA_PREMIUM_100CL = readString(dis);

					this.PET_SODA_PREMIUM_150CL = readString(dis);

					this.PET_SODA_PREMIUM_200CL = readString(dis);

					this.PET_PET_SODA_COLA_33CL = readString(dis);

					this.PET_SODA_COLA_100CL = readString(dis);

					this.PET_SODA_COLA_150CL = readString(dis);

					this.PET_SODA_COLA_200CL = readString(dis);

					this.PET_EF_P_tifruit_20CL = readString(dis);

					this.PET_EF_33CL = readString(dis);

					this.PET_EF_100CL = readString(dis);

					this.PET_EF_150CL = readString(dis);

					this.PET_EF_200CL = readString(dis);

					this.PET_EF_Unknown = readString(dis);

					this.PET_EFL_P_tifruit_20CL = readString(dis);

					this.PET_EFL_20CL = readString(dis);

					this.PET_EFL_33CL = readString(dis);

					this.PET_EFL_100CL = readString(dis);

					this.PET_EFL_150CL = readString(dis);

					this.PET_SPORTDRINK_50CL = readString(dis);

					this.PET_SPORTDRINK_Unknown = readString(dis);

					this.PET_JUSPUR_20CL = readString(dis);

					this.PET_JUSPUR_100CL = readString(dis);

					this.PET_BEIZEM_33CL = readString(dis);

					this.PET_BEIZEM_Unknown = readString(dis);

					this.PET_EFG_25CL = readString(dis);

					this.PET_EFG_33CL = readString(dis);

					this.PET_EFG_100CL = readString(dis);

					this.PET_EFG_150CL = readString(dis);

					this.PET_ICETHE_25CL = readString(dis);

					this.PET_ICETHE_100CL = readString(dis);

					this.PET_ICETHE_150CL = readString(dis);

					this.VERRE_EMN_25CL = readString(dis);

					this.VERRE_EMN_50CL = readString(dis);

					this.VERRE_EMN_100CL = readString(dis);

					this.VERRE_EMG_25CL = readString(dis);

					this.VERRE_EMG_50CL = readString(dis);

					this.VERRE_EMG_100CL = readString(dis);

					this.VERRE_SODA_25CL = readString(dis);

					this.VERRE_SODA_100CL = readString(dis);

					this.VERRE_SODACOLA_25CL = readString(dis);

					this.VERRE_SODACOLA_100CL = readString(dis);

					this.VERRE_EF_25CL = readString(dis);

					this.VERRE_EF_Unknown = readString(dis);

					this.VERRE_EFL_25CL = readString(dis);

					this.VERRE_EFL_Unknown = readString(dis);

					this.VERRE_CF_25CL = readString(dis);

					this.VERRE_CF_Unknown = readString(dis);

					this.VERRE_BOISSON_25CL = readString(dis);

					this.VERRE_BOISSON_Unknown = readString(dis);

					this.VERRE_IZEM_25CL = readString(dis);

					this.VERRE_BG_25CL = readString(dis);

					this.VERRE_BG_Unknown = readString(dis);

					this.VERRE_ICETHE_25CL = readString(dis);

					this.VERRE_ICETHE_Unknown = readString(dis);

					this.CANNETTE_SODA_33CL = readString(dis);

					this.CANNETTE_JUS_33CL = readString(dis);

					this.CANNETTE_ENERGY_25CL = readString(dis);

					this.CANNETTE_SODACOLA_25CL = readString(dis);

					this.CANNETTE_BG_25CL = readString(dis);

					this.Routes = readString(dis);

					this.Univers = readString(dis);

					this.Nb_visites = readString(dis);

					this.Nb_visites_achat = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_KEYRUS_ReadFile_V04_2) {

				try {

					int length = 0;

					this.ID = readInteger(dis);

					this.WEEK = readString(dis);

					this.DAY = readString(dis);

					this.Date = readString(dis);

					this.Circuit = readString(dis);

					this.Van = readString(dis);

					this.PET_EMN_33CL = readString(dis);

					this.PET_EMN_33CL_B_S_Junior = readString(dis);

					this.PET_EMN_50CL = readString(dis);

					this.PET_EMN_50CL_B_S = readString(dis);

					this.PET_EMN_150CL = readString(dis);

					this.PET_EMG_33CL = readString(dis);

					this.PET_EMG_50CL = readString(dis);

					this.PET_EMG_100CL = readString(dis);

					this.PET_SODA_PREMIUM_33CL = readString(dis);

					this.PET_SODA_PREMIUM_100CL = readString(dis);

					this.PET_SODA_PREMIUM_150CL = readString(dis);

					this.PET_SODA_PREMIUM_200CL = readString(dis);

					this.PET_PET_SODA_COLA_33CL = readString(dis);

					this.PET_SODA_COLA_100CL = readString(dis);

					this.PET_SODA_COLA_150CL = readString(dis);

					this.PET_SODA_COLA_200CL = readString(dis);

					this.PET_EF_P_tifruit_20CL = readString(dis);

					this.PET_EF_33CL = readString(dis);

					this.PET_EF_100CL = readString(dis);

					this.PET_EF_150CL = readString(dis);

					this.PET_EF_200CL = readString(dis);

					this.PET_EF_Unknown = readString(dis);

					this.PET_EFL_P_tifruit_20CL = readString(dis);

					this.PET_EFL_20CL = readString(dis);

					this.PET_EFL_33CL = readString(dis);

					this.PET_EFL_100CL = readString(dis);

					this.PET_EFL_150CL = readString(dis);

					this.PET_SPORTDRINK_50CL = readString(dis);

					this.PET_SPORTDRINK_Unknown = readString(dis);

					this.PET_JUSPUR_20CL = readString(dis);

					this.PET_JUSPUR_100CL = readString(dis);

					this.PET_BEIZEM_33CL = readString(dis);

					this.PET_BEIZEM_Unknown = readString(dis);

					this.PET_EFG_25CL = readString(dis);

					this.PET_EFG_33CL = readString(dis);

					this.PET_EFG_100CL = readString(dis);

					this.PET_EFG_150CL = readString(dis);

					this.PET_ICETHE_25CL = readString(dis);

					this.PET_ICETHE_100CL = readString(dis);

					this.PET_ICETHE_150CL = readString(dis);

					this.VERRE_EMN_25CL = readString(dis);

					this.VERRE_EMN_50CL = readString(dis);

					this.VERRE_EMN_100CL = readString(dis);

					this.VERRE_EMG_25CL = readString(dis);

					this.VERRE_EMG_50CL = readString(dis);

					this.VERRE_EMG_100CL = readString(dis);

					this.VERRE_SODA_25CL = readString(dis);

					this.VERRE_SODA_100CL = readString(dis);

					this.VERRE_SODACOLA_25CL = readString(dis);

					this.VERRE_SODACOLA_100CL = readString(dis);

					this.VERRE_EF_25CL = readString(dis);

					this.VERRE_EF_Unknown = readString(dis);

					this.VERRE_EFL_25CL = readString(dis);

					this.VERRE_EFL_Unknown = readString(dis);

					this.VERRE_CF_25CL = readString(dis);

					this.VERRE_CF_Unknown = readString(dis);

					this.VERRE_BOISSON_25CL = readString(dis);

					this.VERRE_BOISSON_Unknown = readString(dis);

					this.VERRE_IZEM_25CL = readString(dis);

					this.VERRE_BG_25CL = readString(dis);

					this.VERRE_BG_Unknown = readString(dis);

					this.VERRE_ICETHE_25CL = readString(dis);

					this.VERRE_ICETHE_Unknown = readString(dis);

					this.CANNETTE_SODA_33CL = readString(dis);

					this.CANNETTE_JUS_33CL = readString(dis);

					this.CANNETTE_ENERGY_25CL = readString(dis);

					this.CANNETTE_SODACOLA_25CL = readString(dis);

					this.CANNETTE_BG_25CL = readString(dis);

					this.Routes = readString(dis);

					this.Univers = readString(dis);

					this.Nb_visites = readString(dis);

					this.Nb_visites_achat = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// Integer

				writeInteger(this.ID, dos);

				// String

				writeString(this.WEEK, dos);

				// String

				writeString(this.DAY, dos);

				// String

				writeString(this.Date, dos);

				// String

				writeString(this.Circuit, dos);

				// String

				writeString(this.Van, dos);

				// String

				writeString(this.PET_EMN_33CL, dos);

				// String

				writeString(this.PET_EMN_33CL_B_S_Junior, dos);

				// String

				writeString(this.PET_EMN_50CL, dos);

				// String

				writeString(this.PET_EMN_50CL_B_S, dos);

				// String

				writeString(this.PET_EMN_150CL, dos);

				// String

				writeString(this.PET_EMG_33CL, dos);

				// String

				writeString(this.PET_EMG_50CL, dos);

				// String

				writeString(this.PET_EMG_100CL, dos);

				// String

				writeString(this.PET_SODA_PREMIUM_33CL, dos);

				// String

				writeString(this.PET_SODA_PREMIUM_100CL, dos);

				// String

				writeString(this.PET_SODA_PREMIUM_150CL, dos);

				// String

				writeString(this.PET_SODA_PREMIUM_200CL, dos);

				// String

				writeString(this.PET_PET_SODA_COLA_33CL, dos);

				// String

				writeString(this.PET_SODA_COLA_100CL, dos);

				// String

				writeString(this.PET_SODA_COLA_150CL, dos);

				// String

				writeString(this.PET_SODA_COLA_200CL, dos);

				// String

				writeString(this.PET_EF_P_tifruit_20CL, dos);

				// String

				writeString(this.PET_EF_33CL, dos);

				// String

				writeString(this.PET_EF_100CL, dos);

				// String

				writeString(this.PET_EF_150CL, dos);

				// String

				writeString(this.PET_EF_200CL, dos);

				// String

				writeString(this.PET_EF_Unknown, dos);

				// String

				writeString(this.PET_EFL_P_tifruit_20CL, dos);

				// String

				writeString(this.PET_EFL_20CL, dos);

				// String

				writeString(this.PET_EFL_33CL, dos);

				// String

				writeString(this.PET_EFL_100CL, dos);

				// String

				writeString(this.PET_EFL_150CL, dos);

				// String

				writeString(this.PET_SPORTDRINK_50CL, dos);

				// String

				writeString(this.PET_SPORTDRINK_Unknown, dos);

				// String

				writeString(this.PET_JUSPUR_20CL, dos);

				// String

				writeString(this.PET_JUSPUR_100CL, dos);

				// String

				writeString(this.PET_BEIZEM_33CL, dos);

				// String

				writeString(this.PET_BEIZEM_Unknown, dos);

				// String

				writeString(this.PET_EFG_25CL, dos);

				// String

				writeString(this.PET_EFG_33CL, dos);

				// String

				writeString(this.PET_EFG_100CL, dos);

				// String

				writeString(this.PET_EFG_150CL, dos);

				// String

				writeString(this.PET_ICETHE_25CL, dos);

				// String

				writeString(this.PET_ICETHE_100CL, dos);

				// String

				writeString(this.PET_ICETHE_150CL, dos);

				// String

				writeString(this.VERRE_EMN_25CL, dos);

				// String

				writeString(this.VERRE_EMN_50CL, dos);

				// String

				writeString(this.VERRE_EMN_100CL, dos);

				// String

				writeString(this.VERRE_EMG_25CL, dos);

				// String

				writeString(this.VERRE_EMG_50CL, dos);

				// String

				writeString(this.VERRE_EMG_100CL, dos);

				// String

				writeString(this.VERRE_SODA_25CL, dos);

				// String

				writeString(this.VERRE_SODA_100CL, dos);

				// String

				writeString(this.VERRE_SODACOLA_25CL, dos);

				// String

				writeString(this.VERRE_SODACOLA_100CL, dos);

				// String

				writeString(this.VERRE_EF_25CL, dos);

				// String

				writeString(this.VERRE_EF_Unknown, dos);

				// String

				writeString(this.VERRE_EFL_25CL, dos);

				// String

				writeString(this.VERRE_EFL_Unknown, dos);

				// String

				writeString(this.VERRE_CF_25CL, dos);

				// String

				writeString(this.VERRE_CF_Unknown, dos);

				// String

				writeString(this.VERRE_BOISSON_25CL, dos);

				// String

				writeString(this.VERRE_BOISSON_Unknown, dos);

				// String

				writeString(this.VERRE_IZEM_25CL, dos);

				// String

				writeString(this.VERRE_BG_25CL, dos);

				// String

				writeString(this.VERRE_BG_Unknown, dos);

				// String

				writeString(this.VERRE_ICETHE_25CL, dos);

				// String

				writeString(this.VERRE_ICETHE_Unknown, dos);

				// String

				writeString(this.CANNETTE_SODA_33CL, dos);

				// String

				writeString(this.CANNETTE_JUS_33CL, dos);

				// String

				writeString(this.CANNETTE_ENERGY_25CL, dos);

				// String

				writeString(this.CANNETTE_SODACOLA_25CL, dos);

				// String

				writeString(this.CANNETTE_BG_25CL, dos);

				// String

				writeString(this.Routes, dos);

				// String

				writeString(this.Univers, dos);

				// String

				writeString(this.Nb_visites, dos);

				// String

				writeString(this.Nb_visites_achat, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// Integer

				writeInteger(this.ID, dos);

				// String

				writeString(this.WEEK, dos);

				// String

				writeString(this.DAY, dos);

				// String

				writeString(this.Date, dos);

				// String

				writeString(this.Circuit, dos);

				// String

				writeString(this.Van, dos);

				// String

				writeString(this.PET_EMN_33CL, dos);

				// String

				writeString(this.PET_EMN_33CL_B_S_Junior, dos);

				// String

				writeString(this.PET_EMN_50CL, dos);

				// String

				writeString(this.PET_EMN_50CL_B_S, dos);

				// String

				writeString(this.PET_EMN_150CL, dos);

				// String

				writeString(this.PET_EMG_33CL, dos);

				// String

				writeString(this.PET_EMG_50CL, dos);

				// String

				writeString(this.PET_EMG_100CL, dos);

				// String

				writeString(this.PET_SODA_PREMIUM_33CL, dos);

				// String

				writeString(this.PET_SODA_PREMIUM_100CL, dos);

				// String

				writeString(this.PET_SODA_PREMIUM_150CL, dos);

				// String

				writeString(this.PET_SODA_PREMIUM_200CL, dos);

				// String

				writeString(this.PET_PET_SODA_COLA_33CL, dos);

				// String

				writeString(this.PET_SODA_COLA_100CL, dos);

				// String

				writeString(this.PET_SODA_COLA_150CL, dos);

				// String

				writeString(this.PET_SODA_COLA_200CL, dos);

				// String

				writeString(this.PET_EF_P_tifruit_20CL, dos);

				// String

				writeString(this.PET_EF_33CL, dos);

				// String

				writeString(this.PET_EF_100CL, dos);

				// String

				writeString(this.PET_EF_150CL, dos);

				// String

				writeString(this.PET_EF_200CL, dos);

				// String

				writeString(this.PET_EF_Unknown, dos);

				// String

				writeString(this.PET_EFL_P_tifruit_20CL, dos);

				// String

				writeString(this.PET_EFL_20CL, dos);

				// String

				writeString(this.PET_EFL_33CL, dos);

				// String

				writeString(this.PET_EFL_100CL, dos);

				// String

				writeString(this.PET_EFL_150CL, dos);

				// String

				writeString(this.PET_SPORTDRINK_50CL, dos);

				// String

				writeString(this.PET_SPORTDRINK_Unknown, dos);

				// String

				writeString(this.PET_JUSPUR_20CL, dos);

				// String

				writeString(this.PET_JUSPUR_100CL, dos);

				// String

				writeString(this.PET_BEIZEM_33CL, dos);

				// String

				writeString(this.PET_BEIZEM_Unknown, dos);

				// String

				writeString(this.PET_EFG_25CL, dos);

				// String

				writeString(this.PET_EFG_33CL, dos);

				// String

				writeString(this.PET_EFG_100CL, dos);

				// String

				writeString(this.PET_EFG_150CL, dos);

				// String

				writeString(this.PET_ICETHE_25CL, dos);

				// String

				writeString(this.PET_ICETHE_100CL, dos);

				// String

				writeString(this.PET_ICETHE_150CL, dos);

				// String

				writeString(this.VERRE_EMN_25CL, dos);

				// String

				writeString(this.VERRE_EMN_50CL, dos);

				// String

				writeString(this.VERRE_EMN_100CL, dos);

				// String

				writeString(this.VERRE_EMG_25CL, dos);

				// String

				writeString(this.VERRE_EMG_50CL, dos);

				// String

				writeString(this.VERRE_EMG_100CL, dos);

				// String

				writeString(this.VERRE_SODA_25CL, dos);

				// String

				writeString(this.VERRE_SODA_100CL, dos);

				// String

				writeString(this.VERRE_SODACOLA_25CL, dos);

				// String

				writeString(this.VERRE_SODACOLA_100CL, dos);

				// String

				writeString(this.VERRE_EF_25CL, dos);

				// String

				writeString(this.VERRE_EF_Unknown, dos);

				// String

				writeString(this.VERRE_EFL_25CL, dos);

				// String

				writeString(this.VERRE_EFL_Unknown, dos);

				// String

				writeString(this.VERRE_CF_25CL, dos);

				// String

				writeString(this.VERRE_CF_Unknown, dos);

				// String

				writeString(this.VERRE_BOISSON_25CL, dos);

				// String

				writeString(this.VERRE_BOISSON_Unknown, dos);

				// String

				writeString(this.VERRE_IZEM_25CL, dos);

				// String

				writeString(this.VERRE_BG_25CL, dos);

				// String

				writeString(this.VERRE_BG_Unknown, dos);

				// String

				writeString(this.VERRE_ICETHE_25CL, dos);

				// String

				writeString(this.VERRE_ICETHE_Unknown, dos);

				// String

				writeString(this.CANNETTE_SODA_33CL, dos);

				// String

				writeString(this.CANNETTE_JUS_33CL, dos);

				// String

				writeString(this.CANNETTE_ENERGY_25CL, dos);

				// String

				writeString(this.CANNETTE_SODACOLA_25CL, dos);

				// String

				writeString(this.CANNETTE_BG_25CL, dos);

				// String

				writeString(this.Routes, dos);

				// String

				writeString(this.Univers, dos);

				// String

				writeString(this.Nb_visites, dos);

				// String

				writeString(this.Nb_visites_achat, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("ID=" + String.valueOf(ID));
			sb.append(",WEEK=" + WEEK);
			sb.append(",DAY=" + DAY);
			sb.append(",Date=" + Date);
			sb.append(",Circuit=" + Circuit);
			sb.append(",Van=" + Van);
			sb.append(",PET_EMN_33CL=" + PET_EMN_33CL);
			sb.append(",PET_EMN_33CL_B_S_Junior=" + PET_EMN_33CL_B_S_Junior);
			sb.append(",PET_EMN_50CL=" + PET_EMN_50CL);
			sb.append(",PET_EMN_50CL_B_S=" + PET_EMN_50CL_B_S);
			sb.append(",PET_EMN_150CL=" + PET_EMN_150CL);
			sb.append(",PET_EMG_33CL=" + PET_EMG_33CL);
			sb.append(",PET_EMG_50CL=" + PET_EMG_50CL);
			sb.append(",PET_EMG_100CL=" + PET_EMG_100CL);
			sb.append(",PET_SODA_PREMIUM_33CL=" + PET_SODA_PREMIUM_33CL);
			sb.append(",PET_SODA_PREMIUM_100CL=" + PET_SODA_PREMIUM_100CL);
			sb.append(",PET_SODA_PREMIUM_150CL=" + PET_SODA_PREMIUM_150CL);
			sb.append(",PET_SODA_PREMIUM_200CL=" + PET_SODA_PREMIUM_200CL);
			sb.append(",PET_PET_SODA_COLA_33CL=" + PET_PET_SODA_COLA_33CL);
			sb.append(",PET_SODA_COLA_100CL=" + PET_SODA_COLA_100CL);
			sb.append(",PET_SODA_COLA_150CL=" + PET_SODA_COLA_150CL);
			sb.append(",PET_SODA_COLA_200CL=" + PET_SODA_COLA_200CL);
			sb.append(",PET_EF_P_tifruit_20CL=" + PET_EF_P_tifruit_20CL);
			sb.append(",PET_EF_33CL=" + PET_EF_33CL);
			sb.append(",PET_EF_100CL=" + PET_EF_100CL);
			sb.append(",PET_EF_150CL=" + PET_EF_150CL);
			sb.append(",PET_EF_200CL=" + PET_EF_200CL);
			sb.append(",PET_EF_Unknown=" + PET_EF_Unknown);
			sb.append(",PET_EFL_P_tifruit_20CL=" + PET_EFL_P_tifruit_20CL);
			sb.append(",PET_EFL_20CL=" + PET_EFL_20CL);
			sb.append(",PET_EFL_33CL=" + PET_EFL_33CL);
			sb.append(",PET_EFL_100CL=" + PET_EFL_100CL);
			sb.append(",PET_EFL_150CL=" + PET_EFL_150CL);
			sb.append(",PET_SPORTDRINK_50CL=" + PET_SPORTDRINK_50CL);
			sb.append(",PET_SPORTDRINK_Unknown=" + PET_SPORTDRINK_Unknown);
			sb.append(",PET_JUSPUR_20CL=" + PET_JUSPUR_20CL);
			sb.append(",PET_JUSPUR_100CL=" + PET_JUSPUR_100CL);
			sb.append(",PET_BEIZEM_33CL=" + PET_BEIZEM_33CL);
			sb.append(",PET_BEIZEM_Unknown=" + PET_BEIZEM_Unknown);
			sb.append(",PET_EFG_25CL=" + PET_EFG_25CL);
			sb.append(",PET_EFG_33CL=" + PET_EFG_33CL);
			sb.append(",PET_EFG_100CL=" + PET_EFG_100CL);
			sb.append(",PET_EFG_150CL=" + PET_EFG_150CL);
			sb.append(",PET_ICETHE_25CL=" + PET_ICETHE_25CL);
			sb.append(",PET_ICETHE_100CL=" + PET_ICETHE_100CL);
			sb.append(",PET_ICETHE_150CL=" + PET_ICETHE_150CL);
			sb.append(",VERRE_EMN_25CL=" + VERRE_EMN_25CL);
			sb.append(",VERRE_EMN_50CL=" + VERRE_EMN_50CL);
			sb.append(",VERRE_EMN_100CL=" + VERRE_EMN_100CL);
			sb.append(",VERRE_EMG_25CL=" + VERRE_EMG_25CL);
			sb.append(",VERRE_EMG_50CL=" + VERRE_EMG_50CL);
			sb.append(",VERRE_EMG_100CL=" + VERRE_EMG_100CL);
			sb.append(",VERRE_SODA_25CL=" + VERRE_SODA_25CL);
			sb.append(",VERRE_SODA_100CL=" + VERRE_SODA_100CL);
			sb.append(",VERRE_SODACOLA_25CL=" + VERRE_SODACOLA_25CL);
			sb.append(",VERRE_SODACOLA_100CL=" + VERRE_SODACOLA_100CL);
			sb.append(",VERRE_EF_25CL=" + VERRE_EF_25CL);
			sb.append(",VERRE_EF_Unknown=" + VERRE_EF_Unknown);
			sb.append(",VERRE_EFL_25CL=" + VERRE_EFL_25CL);
			sb.append(",VERRE_EFL_Unknown=" + VERRE_EFL_Unknown);
			sb.append(",VERRE_CF_25CL=" + VERRE_CF_25CL);
			sb.append(",VERRE_CF_Unknown=" + VERRE_CF_Unknown);
			sb.append(",VERRE_BOISSON_25CL=" + VERRE_BOISSON_25CL);
			sb.append(",VERRE_BOISSON_Unknown=" + VERRE_BOISSON_Unknown);
			sb.append(",VERRE_IZEM_25CL=" + VERRE_IZEM_25CL);
			sb.append(",VERRE_BG_25CL=" + VERRE_BG_25CL);
			sb.append(",VERRE_BG_Unknown=" + VERRE_BG_Unknown);
			sb.append(",VERRE_ICETHE_25CL=" + VERRE_ICETHE_25CL);
			sb.append(",VERRE_ICETHE_Unknown=" + VERRE_ICETHE_Unknown);
			sb.append(",CANNETTE_SODA_33CL=" + CANNETTE_SODA_33CL);
			sb.append(",CANNETTE_JUS_33CL=" + CANNETTE_JUS_33CL);
			sb.append(",CANNETTE_ENERGY_25CL=" + CANNETTE_ENERGY_25CL);
			sb.append(",CANNETTE_SODACOLA_25CL=" + CANNETTE_SODACOLA_25CL);
			sb.append(",CANNETTE_BG_25CL=" + CANNETTE_BG_25CL);
			sb.append(",Routes=" + Routes);
			sb.append(",Univers=" + Univers);
			sb.append(",Nb_visites=" + Nb_visites);
			sb.append(",Nb_visites_achat=" + Nb_visites_achat);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row8Struct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public static class row7Struct implements routines.system.IPersistableRow<row7Struct> {
		final static byte[] commonByteArrayLock_KEYRUS_ReadFile_V04_2 = new byte[0];
		static byte[] commonByteArray_KEYRUS_ReadFile_V04_2 = new byte[0];

		public Integer ID;

		public Integer getID() {
			return this.ID;
		}

		public String WEEK;

		public String getWEEK() {
			return this.WEEK;
		}

		public String DAY;

		public String getDAY() {
			return this.DAY;
		}

		public String Date;

		public String getDate() {
			return this.Date;
		}

		public String Circuit;

		public String getCircuit() {
			return this.Circuit;
		}

		public String Van;

		public String getVan() {
			return this.Van;
		}

		public String PET_EMN_33CL;

		public String getPET_EMN_33CL() {
			return this.PET_EMN_33CL;
		}

		public String PET_EMN_33CL_B_S_Junior;

		public String getPET_EMN_33CL_B_S_Junior() {
			return this.PET_EMN_33CL_B_S_Junior;
		}

		public String PET_EMN_50CL;

		public String getPET_EMN_50CL() {
			return this.PET_EMN_50CL;
		}

		public String PET_EMN_50CL_B_S;

		public String getPET_EMN_50CL_B_S() {
			return this.PET_EMN_50CL_B_S;
		}

		public String PET_EMN_150CL;

		public String getPET_EMN_150CL() {
			return this.PET_EMN_150CL;
		}

		public String PET_EMG_33CL;

		public String getPET_EMG_33CL() {
			return this.PET_EMG_33CL;
		}

		public String PET_EMG_50CL;

		public String getPET_EMG_50CL() {
			return this.PET_EMG_50CL;
		}

		public String PET_EMG_100CL;

		public String getPET_EMG_100CL() {
			return this.PET_EMG_100CL;
		}

		public String PET_SODA_PREMIUM_33CL;

		public String getPET_SODA_PREMIUM_33CL() {
			return this.PET_SODA_PREMIUM_33CL;
		}

		public String PET_SODA_PREMIUM_100CL;

		public String getPET_SODA_PREMIUM_100CL() {
			return this.PET_SODA_PREMIUM_100CL;
		}

		public String PET_SODA_PREMIUM_150CL;

		public String getPET_SODA_PREMIUM_150CL() {
			return this.PET_SODA_PREMIUM_150CL;
		}

		public String PET_SODA_PREMIUM_200CL;

		public String getPET_SODA_PREMIUM_200CL() {
			return this.PET_SODA_PREMIUM_200CL;
		}

		public String PET_PET_SODA_COLA_33CL;

		public String getPET_PET_SODA_COLA_33CL() {
			return this.PET_PET_SODA_COLA_33CL;
		}

		public String PET_SODA_COLA_100CL;

		public String getPET_SODA_COLA_100CL() {
			return this.PET_SODA_COLA_100CL;
		}

		public String PET_SODA_COLA_150CL;

		public String getPET_SODA_COLA_150CL() {
			return this.PET_SODA_COLA_150CL;
		}

		public String PET_SODA_COLA_200CL;

		public String getPET_SODA_COLA_200CL() {
			return this.PET_SODA_COLA_200CL;
		}

		public String PET_EF_P_tifruit_20CL;

		public String getPET_EF_P_tifruit_20CL() {
			return this.PET_EF_P_tifruit_20CL;
		}

		public String PET_EF_33CL;

		public String getPET_EF_33CL() {
			return this.PET_EF_33CL;
		}

		public String PET_EF_100CL;

		public String getPET_EF_100CL() {
			return this.PET_EF_100CL;
		}

		public String PET_EF_150CL;

		public String getPET_EF_150CL() {
			return this.PET_EF_150CL;
		}

		public String PET_EF_200CL;

		public String getPET_EF_200CL() {
			return this.PET_EF_200CL;
		}

		public String PET_EF_Unknown;

		public String getPET_EF_Unknown() {
			return this.PET_EF_Unknown;
		}

		public String PET_EFL_P_tifruit_20CL;

		public String getPET_EFL_P_tifruit_20CL() {
			return this.PET_EFL_P_tifruit_20CL;
		}

		public String PET_EFL_20CL;

		public String getPET_EFL_20CL() {
			return this.PET_EFL_20CL;
		}

		public String PET_EFL_33CL;

		public String getPET_EFL_33CL() {
			return this.PET_EFL_33CL;
		}

		public String PET_EFL_100CL;

		public String getPET_EFL_100CL() {
			return this.PET_EFL_100CL;
		}

		public String PET_EFL_150CL;

		public String getPET_EFL_150CL() {
			return this.PET_EFL_150CL;
		}

		public String PET_SPORTDRINK_50CL;

		public String getPET_SPORTDRINK_50CL() {
			return this.PET_SPORTDRINK_50CL;
		}

		public String PET_SPORTDRINK_Unknown;

		public String getPET_SPORTDRINK_Unknown() {
			return this.PET_SPORTDRINK_Unknown;
		}

		public String PET_JUSPUR_20CL;

		public String getPET_JUSPUR_20CL() {
			return this.PET_JUSPUR_20CL;
		}

		public String PET_JUSPUR_100CL;

		public String getPET_JUSPUR_100CL() {
			return this.PET_JUSPUR_100CL;
		}

		public String PET_BEIZEM_33CL;

		public String getPET_BEIZEM_33CL() {
			return this.PET_BEIZEM_33CL;
		}

		public String PET_BEIZEM_Unknown;

		public String getPET_BEIZEM_Unknown() {
			return this.PET_BEIZEM_Unknown;
		}

		public String PET_EFG_25CL;

		public String getPET_EFG_25CL() {
			return this.PET_EFG_25CL;
		}

		public String PET_EFG_33CL;

		public String getPET_EFG_33CL() {
			return this.PET_EFG_33CL;
		}

		public String PET_EFG_100CL;

		public String getPET_EFG_100CL() {
			return this.PET_EFG_100CL;
		}

		public String PET_EFG_150CL;

		public String getPET_EFG_150CL() {
			return this.PET_EFG_150CL;
		}

		public String PET_ICETHE_25CL;

		public String getPET_ICETHE_25CL() {
			return this.PET_ICETHE_25CL;
		}

		public String PET_ICETHE_100CL;

		public String getPET_ICETHE_100CL() {
			return this.PET_ICETHE_100CL;
		}

		public String PET_ICETHE_150CL;

		public String getPET_ICETHE_150CL() {
			return this.PET_ICETHE_150CL;
		}

		public String VERRE_EMN_25CL;

		public String getVERRE_EMN_25CL() {
			return this.VERRE_EMN_25CL;
		}

		public String VERRE_EMN_50CL;

		public String getVERRE_EMN_50CL() {
			return this.VERRE_EMN_50CL;
		}

		public String VERRE_EMN_100CL;

		public String getVERRE_EMN_100CL() {
			return this.VERRE_EMN_100CL;
		}

		public String VERRE_EMG_25CL;

		public String getVERRE_EMG_25CL() {
			return this.VERRE_EMG_25CL;
		}

		public String VERRE_EMG_50CL;

		public String getVERRE_EMG_50CL() {
			return this.VERRE_EMG_50CL;
		}

		public String VERRE_EMG_100CL;

		public String getVERRE_EMG_100CL() {
			return this.VERRE_EMG_100CL;
		}

		public String VERRE_SODA_25CL;

		public String getVERRE_SODA_25CL() {
			return this.VERRE_SODA_25CL;
		}

		public String VERRE_SODA_100CL;

		public String getVERRE_SODA_100CL() {
			return this.VERRE_SODA_100CL;
		}

		public String VERRE_SODACOLA_25CL;

		public String getVERRE_SODACOLA_25CL() {
			return this.VERRE_SODACOLA_25CL;
		}

		public String VERRE_SODACOLA_100CL;

		public String getVERRE_SODACOLA_100CL() {
			return this.VERRE_SODACOLA_100CL;
		}

		public String VERRE_EF_25CL;

		public String getVERRE_EF_25CL() {
			return this.VERRE_EF_25CL;
		}

		public String VERRE_EF_Unknown;

		public String getVERRE_EF_Unknown() {
			return this.VERRE_EF_Unknown;
		}

		public String VERRE_EFL_25CL;

		public String getVERRE_EFL_25CL() {
			return this.VERRE_EFL_25CL;
		}

		public String VERRE_EFL_Unknown;

		public String getVERRE_EFL_Unknown() {
			return this.VERRE_EFL_Unknown;
		}

		public String VERRE_CF_25CL;

		public String getVERRE_CF_25CL() {
			return this.VERRE_CF_25CL;
		}

		public String VERRE_CF_Unknown;

		public String getVERRE_CF_Unknown() {
			return this.VERRE_CF_Unknown;
		}

		public String VERRE_BOISSON_25CL;

		public String getVERRE_BOISSON_25CL() {
			return this.VERRE_BOISSON_25CL;
		}

		public String VERRE_BOISSON_Unknown;

		public String getVERRE_BOISSON_Unknown() {
			return this.VERRE_BOISSON_Unknown;
		}

		public String VERRE_IZEM_25CL;

		public String getVERRE_IZEM_25CL() {
			return this.VERRE_IZEM_25CL;
		}

		public String VERRE_BG_25CL;

		public String getVERRE_BG_25CL() {
			return this.VERRE_BG_25CL;
		}

		public String VERRE_BG_Unknown;

		public String getVERRE_BG_Unknown() {
			return this.VERRE_BG_Unknown;
		}

		public String VERRE_ICETHE_25CL;

		public String getVERRE_ICETHE_25CL() {
			return this.VERRE_ICETHE_25CL;
		}

		public String VERRE_ICETHE_Unknown;

		public String getVERRE_ICETHE_Unknown() {
			return this.VERRE_ICETHE_Unknown;
		}

		public String CANNETTE_SODA_33CL;

		public String getCANNETTE_SODA_33CL() {
			return this.CANNETTE_SODA_33CL;
		}

		public String CANNETTE_JUS_33CL;

		public String getCANNETTE_JUS_33CL() {
			return this.CANNETTE_JUS_33CL;
		}

		public String CANNETTE_ENERGY_25CL;

		public String getCANNETTE_ENERGY_25CL() {
			return this.CANNETTE_ENERGY_25CL;
		}

		public String CANNETTE_SODACOLA_25CL;

		public String getCANNETTE_SODACOLA_25CL() {
			return this.CANNETTE_SODACOLA_25CL;
		}

		public String CANNETTE_BG_25CL;

		public String getCANNETTE_BG_25CL() {
			return this.CANNETTE_BG_25CL;
		}

		public String Routes;

		public String getRoutes() {
			return this.Routes;
		}

		public String Univers;

		public String getUnivers() {
			return this.Univers;
		}

		public String Nb_visites;

		public String getNb_visites() {
			return this.Nb_visites;
		}

		public String Nb_visites_achat;

		public String getNb_visites_achat() {
			return this.Nb_visites_achat;
		}

		private Integer readInteger(ObjectInputStream dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException {
			if (intNum == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeInt(intNum);
			}
		}

		private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (intNum == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeInt(intNum);
			}
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_KEYRUS_ReadFile_V04_2.length) {
					if (length < 1024 && commonByteArray_KEYRUS_ReadFile_V04_2.length == 0) {
						commonByteArray_KEYRUS_ReadFile_V04_2 = new byte[1024];
					} else {
						commonByteArray_KEYRUS_ReadFile_V04_2 = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_KEYRUS_ReadFile_V04_2, 0, length);
				strReturn = new String(commonByteArray_KEYRUS_ReadFile_V04_2, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_KEYRUS_ReadFile_V04_2.length) {
					if (length < 1024 && commonByteArray_KEYRUS_ReadFile_V04_2.length == 0) {
						commonByteArray_KEYRUS_ReadFile_V04_2 = new byte[1024];
					} else {
						commonByteArray_KEYRUS_ReadFile_V04_2 = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_KEYRUS_ReadFile_V04_2, 0, length);
				strReturn = new String(commonByteArray_KEYRUS_ReadFile_V04_2, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_KEYRUS_ReadFile_V04_2) {

				try {

					int length = 0;

					this.ID = readInteger(dis);

					this.WEEK = readString(dis);

					this.DAY = readString(dis);

					this.Date = readString(dis);

					this.Circuit = readString(dis);

					this.Van = readString(dis);

					this.PET_EMN_33CL = readString(dis);

					this.PET_EMN_33CL_B_S_Junior = readString(dis);

					this.PET_EMN_50CL = readString(dis);

					this.PET_EMN_50CL_B_S = readString(dis);

					this.PET_EMN_150CL = readString(dis);

					this.PET_EMG_33CL = readString(dis);

					this.PET_EMG_50CL = readString(dis);

					this.PET_EMG_100CL = readString(dis);

					this.PET_SODA_PREMIUM_33CL = readString(dis);

					this.PET_SODA_PREMIUM_100CL = readString(dis);

					this.PET_SODA_PREMIUM_150CL = readString(dis);

					this.PET_SODA_PREMIUM_200CL = readString(dis);

					this.PET_PET_SODA_COLA_33CL = readString(dis);

					this.PET_SODA_COLA_100CL = readString(dis);

					this.PET_SODA_COLA_150CL = readString(dis);

					this.PET_SODA_COLA_200CL = readString(dis);

					this.PET_EF_P_tifruit_20CL = readString(dis);

					this.PET_EF_33CL = readString(dis);

					this.PET_EF_100CL = readString(dis);

					this.PET_EF_150CL = readString(dis);

					this.PET_EF_200CL = readString(dis);

					this.PET_EF_Unknown = readString(dis);

					this.PET_EFL_P_tifruit_20CL = readString(dis);

					this.PET_EFL_20CL = readString(dis);

					this.PET_EFL_33CL = readString(dis);

					this.PET_EFL_100CL = readString(dis);

					this.PET_EFL_150CL = readString(dis);

					this.PET_SPORTDRINK_50CL = readString(dis);

					this.PET_SPORTDRINK_Unknown = readString(dis);

					this.PET_JUSPUR_20CL = readString(dis);

					this.PET_JUSPUR_100CL = readString(dis);

					this.PET_BEIZEM_33CL = readString(dis);

					this.PET_BEIZEM_Unknown = readString(dis);

					this.PET_EFG_25CL = readString(dis);

					this.PET_EFG_33CL = readString(dis);

					this.PET_EFG_100CL = readString(dis);

					this.PET_EFG_150CL = readString(dis);

					this.PET_ICETHE_25CL = readString(dis);

					this.PET_ICETHE_100CL = readString(dis);

					this.PET_ICETHE_150CL = readString(dis);

					this.VERRE_EMN_25CL = readString(dis);

					this.VERRE_EMN_50CL = readString(dis);

					this.VERRE_EMN_100CL = readString(dis);

					this.VERRE_EMG_25CL = readString(dis);

					this.VERRE_EMG_50CL = readString(dis);

					this.VERRE_EMG_100CL = readString(dis);

					this.VERRE_SODA_25CL = readString(dis);

					this.VERRE_SODA_100CL = readString(dis);

					this.VERRE_SODACOLA_25CL = readString(dis);

					this.VERRE_SODACOLA_100CL = readString(dis);

					this.VERRE_EF_25CL = readString(dis);

					this.VERRE_EF_Unknown = readString(dis);

					this.VERRE_EFL_25CL = readString(dis);

					this.VERRE_EFL_Unknown = readString(dis);

					this.VERRE_CF_25CL = readString(dis);

					this.VERRE_CF_Unknown = readString(dis);

					this.VERRE_BOISSON_25CL = readString(dis);

					this.VERRE_BOISSON_Unknown = readString(dis);

					this.VERRE_IZEM_25CL = readString(dis);

					this.VERRE_BG_25CL = readString(dis);

					this.VERRE_BG_Unknown = readString(dis);

					this.VERRE_ICETHE_25CL = readString(dis);

					this.VERRE_ICETHE_Unknown = readString(dis);

					this.CANNETTE_SODA_33CL = readString(dis);

					this.CANNETTE_JUS_33CL = readString(dis);

					this.CANNETTE_ENERGY_25CL = readString(dis);

					this.CANNETTE_SODACOLA_25CL = readString(dis);

					this.CANNETTE_BG_25CL = readString(dis);

					this.Routes = readString(dis);

					this.Univers = readString(dis);

					this.Nb_visites = readString(dis);

					this.Nb_visites_achat = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_KEYRUS_ReadFile_V04_2) {

				try {

					int length = 0;

					this.ID = readInteger(dis);

					this.WEEK = readString(dis);

					this.DAY = readString(dis);

					this.Date = readString(dis);

					this.Circuit = readString(dis);

					this.Van = readString(dis);

					this.PET_EMN_33CL = readString(dis);

					this.PET_EMN_33CL_B_S_Junior = readString(dis);

					this.PET_EMN_50CL = readString(dis);

					this.PET_EMN_50CL_B_S = readString(dis);

					this.PET_EMN_150CL = readString(dis);

					this.PET_EMG_33CL = readString(dis);

					this.PET_EMG_50CL = readString(dis);

					this.PET_EMG_100CL = readString(dis);

					this.PET_SODA_PREMIUM_33CL = readString(dis);

					this.PET_SODA_PREMIUM_100CL = readString(dis);

					this.PET_SODA_PREMIUM_150CL = readString(dis);

					this.PET_SODA_PREMIUM_200CL = readString(dis);

					this.PET_PET_SODA_COLA_33CL = readString(dis);

					this.PET_SODA_COLA_100CL = readString(dis);

					this.PET_SODA_COLA_150CL = readString(dis);

					this.PET_SODA_COLA_200CL = readString(dis);

					this.PET_EF_P_tifruit_20CL = readString(dis);

					this.PET_EF_33CL = readString(dis);

					this.PET_EF_100CL = readString(dis);

					this.PET_EF_150CL = readString(dis);

					this.PET_EF_200CL = readString(dis);

					this.PET_EF_Unknown = readString(dis);

					this.PET_EFL_P_tifruit_20CL = readString(dis);

					this.PET_EFL_20CL = readString(dis);

					this.PET_EFL_33CL = readString(dis);

					this.PET_EFL_100CL = readString(dis);

					this.PET_EFL_150CL = readString(dis);

					this.PET_SPORTDRINK_50CL = readString(dis);

					this.PET_SPORTDRINK_Unknown = readString(dis);

					this.PET_JUSPUR_20CL = readString(dis);

					this.PET_JUSPUR_100CL = readString(dis);

					this.PET_BEIZEM_33CL = readString(dis);

					this.PET_BEIZEM_Unknown = readString(dis);

					this.PET_EFG_25CL = readString(dis);

					this.PET_EFG_33CL = readString(dis);

					this.PET_EFG_100CL = readString(dis);

					this.PET_EFG_150CL = readString(dis);

					this.PET_ICETHE_25CL = readString(dis);

					this.PET_ICETHE_100CL = readString(dis);

					this.PET_ICETHE_150CL = readString(dis);

					this.VERRE_EMN_25CL = readString(dis);

					this.VERRE_EMN_50CL = readString(dis);

					this.VERRE_EMN_100CL = readString(dis);

					this.VERRE_EMG_25CL = readString(dis);

					this.VERRE_EMG_50CL = readString(dis);

					this.VERRE_EMG_100CL = readString(dis);

					this.VERRE_SODA_25CL = readString(dis);

					this.VERRE_SODA_100CL = readString(dis);

					this.VERRE_SODACOLA_25CL = readString(dis);

					this.VERRE_SODACOLA_100CL = readString(dis);

					this.VERRE_EF_25CL = readString(dis);

					this.VERRE_EF_Unknown = readString(dis);

					this.VERRE_EFL_25CL = readString(dis);

					this.VERRE_EFL_Unknown = readString(dis);

					this.VERRE_CF_25CL = readString(dis);

					this.VERRE_CF_Unknown = readString(dis);

					this.VERRE_BOISSON_25CL = readString(dis);

					this.VERRE_BOISSON_Unknown = readString(dis);

					this.VERRE_IZEM_25CL = readString(dis);

					this.VERRE_BG_25CL = readString(dis);

					this.VERRE_BG_Unknown = readString(dis);

					this.VERRE_ICETHE_25CL = readString(dis);

					this.VERRE_ICETHE_Unknown = readString(dis);

					this.CANNETTE_SODA_33CL = readString(dis);

					this.CANNETTE_JUS_33CL = readString(dis);

					this.CANNETTE_ENERGY_25CL = readString(dis);

					this.CANNETTE_SODACOLA_25CL = readString(dis);

					this.CANNETTE_BG_25CL = readString(dis);

					this.Routes = readString(dis);

					this.Univers = readString(dis);

					this.Nb_visites = readString(dis);

					this.Nb_visites_achat = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// Integer

				writeInteger(this.ID, dos);

				// String

				writeString(this.WEEK, dos);

				// String

				writeString(this.DAY, dos);

				// String

				writeString(this.Date, dos);

				// String

				writeString(this.Circuit, dos);

				// String

				writeString(this.Van, dos);

				// String

				writeString(this.PET_EMN_33CL, dos);

				// String

				writeString(this.PET_EMN_33CL_B_S_Junior, dos);

				// String

				writeString(this.PET_EMN_50CL, dos);

				// String

				writeString(this.PET_EMN_50CL_B_S, dos);

				// String

				writeString(this.PET_EMN_150CL, dos);

				// String

				writeString(this.PET_EMG_33CL, dos);

				// String

				writeString(this.PET_EMG_50CL, dos);

				// String

				writeString(this.PET_EMG_100CL, dos);

				// String

				writeString(this.PET_SODA_PREMIUM_33CL, dos);

				// String

				writeString(this.PET_SODA_PREMIUM_100CL, dos);

				// String

				writeString(this.PET_SODA_PREMIUM_150CL, dos);

				// String

				writeString(this.PET_SODA_PREMIUM_200CL, dos);

				// String

				writeString(this.PET_PET_SODA_COLA_33CL, dos);

				// String

				writeString(this.PET_SODA_COLA_100CL, dos);

				// String

				writeString(this.PET_SODA_COLA_150CL, dos);

				// String

				writeString(this.PET_SODA_COLA_200CL, dos);

				// String

				writeString(this.PET_EF_P_tifruit_20CL, dos);

				// String

				writeString(this.PET_EF_33CL, dos);

				// String

				writeString(this.PET_EF_100CL, dos);

				// String

				writeString(this.PET_EF_150CL, dos);

				// String

				writeString(this.PET_EF_200CL, dos);

				// String

				writeString(this.PET_EF_Unknown, dos);

				// String

				writeString(this.PET_EFL_P_tifruit_20CL, dos);

				// String

				writeString(this.PET_EFL_20CL, dos);

				// String

				writeString(this.PET_EFL_33CL, dos);

				// String

				writeString(this.PET_EFL_100CL, dos);

				// String

				writeString(this.PET_EFL_150CL, dos);

				// String

				writeString(this.PET_SPORTDRINK_50CL, dos);

				// String

				writeString(this.PET_SPORTDRINK_Unknown, dos);

				// String

				writeString(this.PET_JUSPUR_20CL, dos);

				// String

				writeString(this.PET_JUSPUR_100CL, dos);

				// String

				writeString(this.PET_BEIZEM_33CL, dos);

				// String

				writeString(this.PET_BEIZEM_Unknown, dos);

				// String

				writeString(this.PET_EFG_25CL, dos);

				// String

				writeString(this.PET_EFG_33CL, dos);

				// String

				writeString(this.PET_EFG_100CL, dos);

				// String

				writeString(this.PET_EFG_150CL, dos);

				// String

				writeString(this.PET_ICETHE_25CL, dos);

				// String

				writeString(this.PET_ICETHE_100CL, dos);

				// String

				writeString(this.PET_ICETHE_150CL, dos);

				// String

				writeString(this.VERRE_EMN_25CL, dos);

				// String

				writeString(this.VERRE_EMN_50CL, dos);

				// String

				writeString(this.VERRE_EMN_100CL, dos);

				// String

				writeString(this.VERRE_EMG_25CL, dos);

				// String

				writeString(this.VERRE_EMG_50CL, dos);

				// String

				writeString(this.VERRE_EMG_100CL, dos);

				// String

				writeString(this.VERRE_SODA_25CL, dos);

				// String

				writeString(this.VERRE_SODA_100CL, dos);

				// String

				writeString(this.VERRE_SODACOLA_25CL, dos);

				// String

				writeString(this.VERRE_SODACOLA_100CL, dos);

				// String

				writeString(this.VERRE_EF_25CL, dos);

				// String

				writeString(this.VERRE_EF_Unknown, dos);

				// String

				writeString(this.VERRE_EFL_25CL, dos);

				// String

				writeString(this.VERRE_EFL_Unknown, dos);

				// String

				writeString(this.VERRE_CF_25CL, dos);

				// String

				writeString(this.VERRE_CF_Unknown, dos);

				// String

				writeString(this.VERRE_BOISSON_25CL, dos);

				// String

				writeString(this.VERRE_BOISSON_Unknown, dos);

				// String

				writeString(this.VERRE_IZEM_25CL, dos);

				// String

				writeString(this.VERRE_BG_25CL, dos);

				// String

				writeString(this.VERRE_BG_Unknown, dos);

				// String

				writeString(this.VERRE_ICETHE_25CL, dos);

				// String

				writeString(this.VERRE_ICETHE_Unknown, dos);

				// String

				writeString(this.CANNETTE_SODA_33CL, dos);

				// String

				writeString(this.CANNETTE_JUS_33CL, dos);

				// String

				writeString(this.CANNETTE_ENERGY_25CL, dos);

				// String

				writeString(this.CANNETTE_SODACOLA_25CL, dos);

				// String

				writeString(this.CANNETTE_BG_25CL, dos);

				// String

				writeString(this.Routes, dos);

				// String

				writeString(this.Univers, dos);

				// String

				writeString(this.Nb_visites, dos);

				// String

				writeString(this.Nb_visites_achat, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// Integer

				writeInteger(this.ID, dos);

				// String

				writeString(this.WEEK, dos);

				// String

				writeString(this.DAY, dos);

				// String

				writeString(this.Date, dos);

				// String

				writeString(this.Circuit, dos);

				// String

				writeString(this.Van, dos);

				// String

				writeString(this.PET_EMN_33CL, dos);

				// String

				writeString(this.PET_EMN_33CL_B_S_Junior, dos);

				// String

				writeString(this.PET_EMN_50CL, dos);

				// String

				writeString(this.PET_EMN_50CL_B_S, dos);

				// String

				writeString(this.PET_EMN_150CL, dos);

				// String

				writeString(this.PET_EMG_33CL, dos);

				// String

				writeString(this.PET_EMG_50CL, dos);

				// String

				writeString(this.PET_EMG_100CL, dos);

				// String

				writeString(this.PET_SODA_PREMIUM_33CL, dos);

				// String

				writeString(this.PET_SODA_PREMIUM_100CL, dos);

				// String

				writeString(this.PET_SODA_PREMIUM_150CL, dos);

				// String

				writeString(this.PET_SODA_PREMIUM_200CL, dos);

				// String

				writeString(this.PET_PET_SODA_COLA_33CL, dos);

				// String

				writeString(this.PET_SODA_COLA_100CL, dos);

				// String

				writeString(this.PET_SODA_COLA_150CL, dos);

				// String

				writeString(this.PET_SODA_COLA_200CL, dos);

				// String

				writeString(this.PET_EF_P_tifruit_20CL, dos);

				// String

				writeString(this.PET_EF_33CL, dos);

				// String

				writeString(this.PET_EF_100CL, dos);

				// String

				writeString(this.PET_EF_150CL, dos);

				// String

				writeString(this.PET_EF_200CL, dos);

				// String

				writeString(this.PET_EF_Unknown, dos);

				// String

				writeString(this.PET_EFL_P_tifruit_20CL, dos);

				// String

				writeString(this.PET_EFL_20CL, dos);

				// String

				writeString(this.PET_EFL_33CL, dos);

				// String

				writeString(this.PET_EFL_100CL, dos);

				// String

				writeString(this.PET_EFL_150CL, dos);

				// String

				writeString(this.PET_SPORTDRINK_50CL, dos);

				// String

				writeString(this.PET_SPORTDRINK_Unknown, dos);

				// String

				writeString(this.PET_JUSPUR_20CL, dos);

				// String

				writeString(this.PET_JUSPUR_100CL, dos);

				// String

				writeString(this.PET_BEIZEM_33CL, dos);

				// String

				writeString(this.PET_BEIZEM_Unknown, dos);

				// String

				writeString(this.PET_EFG_25CL, dos);

				// String

				writeString(this.PET_EFG_33CL, dos);

				// String

				writeString(this.PET_EFG_100CL, dos);

				// String

				writeString(this.PET_EFG_150CL, dos);

				// String

				writeString(this.PET_ICETHE_25CL, dos);

				// String

				writeString(this.PET_ICETHE_100CL, dos);

				// String

				writeString(this.PET_ICETHE_150CL, dos);

				// String

				writeString(this.VERRE_EMN_25CL, dos);

				// String

				writeString(this.VERRE_EMN_50CL, dos);

				// String

				writeString(this.VERRE_EMN_100CL, dos);

				// String

				writeString(this.VERRE_EMG_25CL, dos);

				// String

				writeString(this.VERRE_EMG_50CL, dos);

				// String

				writeString(this.VERRE_EMG_100CL, dos);

				// String

				writeString(this.VERRE_SODA_25CL, dos);

				// String

				writeString(this.VERRE_SODA_100CL, dos);

				// String

				writeString(this.VERRE_SODACOLA_25CL, dos);

				// String

				writeString(this.VERRE_SODACOLA_100CL, dos);

				// String

				writeString(this.VERRE_EF_25CL, dos);

				// String

				writeString(this.VERRE_EF_Unknown, dos);

				// String

				writeString(this.VERRE_EFL_25CL, dos);

				// String

				writeString(this.VERRE_EFL_Unknown, dos);

				// String

				writeString(this.VERRE_CF_25CL, dos);

				// String

				writeString(this.VERRE_CF_Unknown, dos);

				// String

				writeString(this.VERRE_BOISSON_25CL, dos);

				// String

				writeString(this.VERRE_BOISSON_Unknown, dos);

				// String

				writeString(this.VERRE_IZEM_25CL, dos);

				// String

				writeString(this.VERRE_BG_25CL, dos);

				// String

				writeString(this.VERRE_BG_Unknown, dos);

				// String

				writeString(this.VERRE_ICETHE_25CL, dos);

				// String

				writeString(this.VERRE_ICETHE_Unknown, dos);

				// String

				writeString(this.CANNETTE_SODA_33CL, dos);

				// String

				writeString(this.CANNETTE_JUS_33CL, dos);

				// String

				writeString(this.CANNETTE_ENERGY_25CL, dos);

				// String

				writeString(this.CANNETTE_SODACOLA_25CL, dos);

				// String

				writeString(this.CANNETTE_BG_25CL, dos);

				// String

				writeString(this.Routes, dos);

				// String

				writeString(this.Univers, dos);

				// String

				writeString(this.Nb_visites, dos);

				// String

				writeString(this.Nb_visites_achat, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("ID=" + String.valueOf(ID));
			sb.append(",WEEK=" + WEEK);
			sb.append(",DAY=" + DAY);
			sb.append(",Date=" + Date);
			sb.append(",Circuit=" + Circuit);
			sb.append(",Van=" + Van);
			sb.append(",PET_EMN_33CL=" + PET_EMN_33CL);
			sb.append(",PET_EMN_33CL_B_S_Junior=" + PET_EMN_33CL_B_S_Junior);
			sb.append(",PET_EMN_50CL=" + PET_EMN_50CL);
			sb.append(",PET_EMN_50CL_B_S=" + PET_EMN_50CL_B_S);
			sb.append(",PET_EMN_150CL=" + PET_EMN_150CL);
			sb.append(",PET_EMG_33CL=" + PET_EMG_33CL);
			sb.append(",PET_EMG_50CL=" + PET_EMG_50CL);
			sb.append(",PET_EMG_100CL=" + PET_EMG_100CL);
			sb.append(",PET_SODA_PREMIUM_33CL=" + PET_SODA_PREMIUM_33CL);
			sb.append(",PET_SODA_PREMIUM_100CL=" + PET_SODA_PREMIUM_100CL);
			sb.append(",PET_SODA_PREMIUM_150CL=" + PET_SODA_PREMIUM_150CL);
			sb.append(",PET_SODA_PREMIUM_200CL=" + PET_SODA_PREMIUM_200CL);
			sb.append(",PET_PET_SODA_COLA_33CL=" + PET_PET_SODA_COLA_33CL);
			sb.append(",PET_SODA_COLA_100CL=" + PET_SODA_COLA_100CL);
			sb.append(",PET_SODA_COLA_150CL=" + PET_SODA_COLA_150CL);
			sb.append(",PET_SODA_COLA_200CL=" + PET_SODA_COLA_200CL);
			sb.append(",PET_EF_P_tifruit_20CL=" + PET_EF_P_tifruit_20CL);
			sb.append(",PET_EF_33CL=" + PET_EF_33CL);
			sb.append(",PET_EF_100CL=" + PET_EF_100CL);
			sb.append(",PET_EF_150CL=" + PET_EF_150CL);
			sb.append(",PET_EF_200CL=" + PET_EF_200CL);
			sb.append(",PET_EF_Unknown=" + PET_EF_Unknown);
			sb.append(",PET_EFL_P_tifruit_20CL=" + PET_EFL_P_tifruit_20CL);
			sb.append(",PET_EFL_20CL=" + PET_EFL_20CL);
			sb.append(",PET_EFL_33CL=" + PET_EFL_33CL);
			sb.append(",PET_EFL_100CL=" + PET_EFL_100CL);
			sb.append(",PET_EFL_150CL=" + PET_EFL_150CL);
			sb.append(",PET_SPORTDRINK_50CL=" + PET_SPORTDRINK_50CL);
			sb.append(",PET_SPORTDRINK_Unknown=" + PET_SPORTDRINK_Unknown);
			sb.append(",PET_JUSPUR_20CL=" + PET_JUSPUR_20CL);
			sb.append(",PET_JUSPUR_100CL=" + PET_JUSPUR_100CL);
			sb.append(",PET_BEIZEM_33CL=" + PET_BEIZEM_33CL);
			sb.append(",PET_BEIZEM_Unknown=" + PET_BEIZEM_Unknown);
			sb.append(",PET_EFG_25CL=" + PET_EFG_25CL);
			sb.append(",PET_EFG_33CL=" + PET_EFG_33CL);
			sb.append(",PET_EFG_100CL=" + PET_EFG_100CL);
			sb.append(",PET_EFG_150CL=" + PET_EFG_150CL);
			sb.append(",PET_ICETHE_25CL=" + PET_ICETHE_25CL);
			sb.append(",PET_ICETHE_100CL=" + PET_ICETHE_100CL);
			sb.append(",PET_ICETHE_150CL=" + PET_ICETHE_150CL);
			sb.append(",VERRE_EMN_25CL=" + VERRE_EMN_25CL);
			sb.append(",VERRE_EMN_50CL=" + VERRE_EMN_50CL);
			sb.append(",VERRE_EMN_100CL=" + VERRE_EMN_100CL);
			sb.append(",VERRE_EMG_25CL=" + VERRE_EMG_25CL);
			sb.append(",VERRE_EMG_50CL=" + VERRE_EMG_50CL);
			sb.append(",VERRE_EMG_100CL=" + VERRE_EMG_100CL);
			sb.append(",VERRE_SODA_25CL=" + VERRE_SODA_25CL);
			sb.append(",VERRE_SODA_100CL=" + VERRE_SODA_100CL);
			sb.append(",VERRE_SODACOLA_25CL=" + VERRE_SODACOLA_25CL);
			sb.append(",VERRE_SODACOLA_100CL=" + VERRE_SODACOLA_100CL);
			sb.append(",VERRE_EF_25CL=" + VERRE_EF_25CL);
			sb.append(",VERRE_EF_Unknown=" + VERRE_EF_Unknown);
			sb.append(",VERRE_EFL_25CL=" + VERRE_EFL_25CL);
			sb.append(",VERRE_EFL_Unknown=" + VERRE_EFL_Unknown);
			sb.append(",VERRE_CF_25CL=" + VERRE_CF_25CL);
			sb.append(",VERRE_CF_Unknown=" + VERRE_CF_Unknown);
			sb.append(",VERRE_BOISSON_25CL=" + VERRE_BOISSON_25CL);
			sb.append(",VERRE_BOISSON_Unknown=" + VERRE_BOISSON_Unknown);
			sb.append(",VERRE_IZEM_25CL=" + VERRE_IZEM_25CL);
			sb.append(",VERRE_BG_25CL=" + VERRE_BG_25CL);
			sb.append(",VERRE_BG_Unknown=" + VERRE_BG_Unknown);
			sb.append(",VERRE_ICETHE_25CL=" + VERRE_ICETHE_25CL);
			sb.append(",VERRE_ICETHE_Unknown=" + VERRE_ICETHE_Unknown);
			sb.append(",CANNETTE_SODA_33CL=" + CANNETTE_SODA_33CL);
			sb.append(",CANNETTE_JUS_33CL=" + CANNETTE_JUS_33CL);
			sb.append(",CANNETTE_ENERGY_25CL=" + CANNETTE_ENERGY_25CL);
			sb.append(",CANNETTE_SODACOLA_25CL=" + CANNETTE_SODACOLA_25CL);
			sb.append(",CANNETTE_BG_25CL=" + CANNETTE_BG_25CL);
			sb.append(",Routes=" + Routes);
			sb.append(",Univers=" + Univers);
			sb.append(",Nb_visites=" + Nb_visites);
			sb.append(",Nb_visites_achat=" + Nb_visites_achat);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row7Struct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public static class row6Struct implements routines.system.IPersistableRow<row6Struct> {
		final static byte[] commonByteArrayLock_KEYRUS_ReadFile_V04_2 = new byte[0];
		static byte[] commonByteArray_KEYRUS_ReadFile_V04_2 = new byte[0];

		public Integer ID;

		public Integer getID() {
			return this.ID;
		}

		public String WEEK;

		public String getWEEK() {
			return this.WEEK;
		}

		public String DAY;

		public String getDAY() {
			return this.DAY;
		}

		public String Date;

		public String getDate() {
			return this.Date;
		}

		public String Circuit;

		public String getCircuit() {
			return this.Circuit;
		}

		public String Van;

		public String getVan() {
			return this.Van;
		}

		public String PET_EMN_33CL;

		public String getPET_EMN_33CL() {
			return this.PET_EMN_33CL;
		}

		public String PET_EMN_33CL_B_S_Junior;

		public String getPET_EMN_33CL_B_S_Junior() {
			return this.PET_EMN_33CL_B_S_Junior;
		}

		public String PET_EMN_50CL;

		public String getPET_EMN_50CL() {
			return this.PET_EMN_50CL;
		}

		public String PET_EMN_50CL_B_S;

		public String getPET_EMN_50CL_B_S() {
			return this.PET_EMN_50CL_B_S;
		}

		public String PET_EMN_150CL;

		public String getPET_EMN_150CL() {
			return this.PET_EMN_150CL;
		}

		public String PET_EMG_33CL;

		public String getPET_EMG_33CL() {
			return this.PET_EMG_33CL;
		}

		public String PET_EMG_50CL;

		public String getPET_EMG_50CL() {
			return this.PET_EMG_50CL;
		}

		public String PET_EMG_100CL;

		public String getPET_EMG_100CL() {
			return this.PET_EMG_100CL;
		}

		public String PET_SODA_PREMIUM_33CL;

		public String getPET_SODA_PREMIUM_33CL() {
			return this.PET_SODA_PREMIUM_33CL;
		}

		public String PET_SODA_PREMIUM_100CL;

		public String getPET_SODA_PREMIUM_100CL() {
			return this.PET_SODA_PREMIUM_100CL;
		}

		public String PET_SODA_PREMIUM_150CL;

		public String getPET_SODA_PREMIUM_150CL() {
			return this.PET_SODA_PREMIUM_150CL;
		}

		public String PET_SODA_PREMIUM_200CL;

		public String getPET_SODA_PREMIUM_200CL() {
			return this.PET_SODA_PREMIUM_200CL;
		}

		public String PET_PET_SODA_COLA_33CL;

		public String getPET_PET_SODA_COLA_33CL() {
			return this.PET_PET_SODA_COLA_33CL;
		}

		public String PET_SODA_COLA_100CL;

		public String getPET_SODA_COLA_100CL() {
			return this.PET_SODA_COLA_100CL;
		}

		public String PET_SODA_COLA_150CL;

		public String getPET_SODA_COLA_150CL() {
			return this.PET_SODA_COLA_150CL;
		}

		public String PET_SODA_COLA_200CL;

		public String getPET_SODA_COLA_200CL() {
			return this.PET_SODA_COLA_200CL;
		}

		public String PET_EF_P_tifruit_20CL;

		public String getPET_EF_P_tifruit_20CL() {
			return this.PET_EF_P_tifruit_20CL;
		}

		public String PET_EF_33CL;

		public String getPET_EF_33CL() {
			return this.PET_EF_33CL;
		}

		public String PET_EF_100CL;

		public String getPET_EF_100CL() {
			return this.PET_EF_100CL;
		}

		public String PET_EF_150CL;

		public String getPET_EF_150CL() {
			return this.PET_EF_150CL;
		}

		public String PET_EF_200CL;

		public String getPET_EF_200CL() {
			return this.PET_EF_200CL;
		}

		public String PET_EF_Unknown;

		public String getPET_EF_Unknown() {
			return this.PET_EF_Unknown;
		}

		public String PET_EFL_P_tifruit_20CL;

		public String getPET_EFL_P_tifruit_20CL() {
			return this.PET_EFL_P_tifruit_20CL;
		}

		public String PET_EFL_20CL;

		public String getPET_EFL_20CL() {
			return this.PET_EFL_20CL;
		}

		public String PET_EFL_33CL;

		public String getPET_EFL_33CL() {
			return this.PET_EFL_33CL;
		}

		public String PET_EFL_100CL;

		public String getPET_EFL_100CL() {
			return this.PET_EFL_100CL;
		}

		public String PET_EFL_150CL;

		public String getPET_EFL_150CL() {
			return this.PET_EFL_150CL;
		}

		public String PET_SPORTDRINK_50CL;

		public String getPET_SPORTDRINK_50CL() {
			return this.PET_SPORTDRINK_50CL;
		}

		public String PET_SPORTDRINK_Unknown;

		public String getPET_SPORTDRINK_Unknown() {
			return this.PET_SPORTDRINK_Unknown;
		}

		public String PET_JUSPUR_20CL;

		public String getPET_JUSPUR_20CL() {
			return this.PET_JUSPUR_20CL;
		}

		public String PET_JUSPUR_100CL;

		public String getPET_JUSPUR_100CL() {
			return this.PET_JUSPUR_100CL;
		}

		public String PET_BEIZEM_33CL;

		public String getPET_BEIZEM_33CL() {
			return this.PET_BEIZEM_33CL;
		}

		public String PET_BEIZEM_Unknown;

		public String getPET_BEIZEM_Unknown() {
			return this.PET_BEIZEM_Unknown;
		}

		public String PET_EFG_25CL;

		public String getPET_EFG_25CL() {
			return this.PET_EFG_25CL;
		}

		public String PET_EFG_33CL;

		public String getPET_EFG_33CL() {
			return this.PET_EFG_33CL;
		}

		public String PET_EFG_100CL;

		public String getPET_EFG_100CL() {
			return this.PET_EFG_100CL;
		}

		public String PET_EFG_150CL;

		public String getPET_EFG_150CL() {
			return this.PET_EFG_150CL;
		}

		public String PET_ICETHE_25CL;

		public String getPET_ICETHE_25CL() {
			return this.PET_ICETHE_25CL;
		}

		public String PET_ICETHE_100CL;

		public String getPET_ICETHE_100CL() {
			return this.PET_ICETHE_100CL;
		}

		public String PET_ICETHE_150CL;

		public String getPET_ICETHE_150CL() {
			return this.PET_ICETHE_150CL;
		}

		public String VERRE_EMN_25CL;

		public String getVERRE_EMN_25CL() {
			return this.VERRE_EMN_25CL;
		}

		public String VERRE_EMN_50CL;

		public String getVERRE_EMN_50CL() {
			return this.VERRE_EMN_50CL;
		}

		public String VERRE_EMN_100CL;

		public String getVERRE_EMN_100CL() {
			return this.VERRE_EMN_100CL;
		}

		public String VERRE_EMG_25CL;

		public String getVERRE_EMG_25CL() {
			return this.VERRE_EMG_25CL;
		}

		public String VERRE_EMG_50CL;

		public String getVERRE_EMG_50CL() {
			return this.VERRE_EMG_50CL;
		}

		public String VERRE_EMG_100CL;

		public String getVERRE_EMG_100CL() {
			return this.VERRE_EMG_100CL;
		}

		public String VERRE_SODA_25CL;

		public String getVERRE_SODA_25CL() {
			return this.VERRE_SODA_25CL;
		}

		public String VERRE_SODA_100CL;

		public String getVERRE_SODA_100CL() {
			return this.VERRE_SODA_100CL;
		}

		public String VERRE_SODACOLA_25CL;

		public String getVERRE_SODACOLA_25CL() {
			return this.VERRE_SODACOLA_25CL;
		}

		public String VERRE_SODACOLA_100CL;

		public String getVERRE_SODACOLA_100CL() {
			return this.VERRE_SODACOLA_100CL;
		}

		public String VERRE_EF_25CL;

		public String getVERRE_EF_25CL() {
			return this.VERRE_EF_25CL;
		}

		public String VERRE_EF_Unknown;

		public String getVERRE_EF_Unknown() {
			return this.VERRE_EF_Unknown;
		}

		public String VERRE_EFL_25CL;

		public String getVERRE_EFL_25CL() {
			return this.VERRE_EFL_25CL;
		}

		public String VERRE_EFL_Unknown;

		public String getVERRE_EFL_Unknown() {
			return this.VERRE_EFL_Unknown;
		}

		public String VERRE_CF_25CL;

		public String getVERRE_CF_25CL() {
			return this.VERRE_CF_25CL;
		}

		public String VERRE_CF_Unknown;

		public String getVERRE_CF_Unknown() {
			return this.VERRE_CF_Unknown;
		}

		public String VERRE_BOISSON_25CL;

		public String getVERRE_BOISSON_25CL() {
			return this.VERRE_BOISSON_25CL;
		}

		public String VERRE_BOISSON_Unknown;

		public String getVERRE_BOISSON_Unknown() {
			return this.VERRE_BOISSON_Unknown;
		}

		public String VERRE_IZEM_25CL;

		public String getVERRE_IZEM_25CL() {
			return this.VERRE_IZEM_25CL;
		}

		public String VERRE_BG_25CL;

		public String getVERRE_BG_25CL() {
			return this.VERRE_BG_25CL;
		}

		public String VERRE_BG_Unknown;

		public String getVERRE_BG_Unknown() {
			return this.VERRE_BG_Unknown;
		}

		public String VERRE_ICETHE_25CL;

		public String getVERRE_ICETHE_25CL() {
			return this.VERRE_ICETHE_25CL;
		}

		public String VERRE_ICETHE_Unknown;

		public String getVERRE_ICETHE_Unknown() {
			return this.VERRE_ICETHE_Unknown;
		}

		public String CANNETTE_SODA_33CL;

		public String getCANNETTE_SODA_33CL() {
			return this.CANNETTE_SODA_33CL;
		}

		public String CANNETTE_JUS_33CL;

		public String getCANNETTE_JUS_33CL() {
			return this.CANNETTE_JUS_33CL;
		}

		public String CANNETTE_ENERGY_25CL;

		public String getCANNETTE_ENERGY_25CL() {
			return this.CANNETTE_ENERGY_25CL;
		}

		public String CANNETTE_SODACOLA_25CL;

		public String getCANNETTE_SODACOLA_25CL() {
			return this.CANNETTE_SODACOLA_25CL;
		}

		public String CANNETTE_BG_25CL;

		public String getCANNETTE_BG_25CL() {
			return this.CANNETTE_BG_25CL;
		}

		public String Routes;

		public String getRoutes() {
			return this.Routes;
		}

		public String Univers;

		public String getUnivers() {
			return this.Univers;
		}

		public String Nb_visites;

		public String getNb_visites() {
			return this.Nb_visites;
		}

		public String Nb_visites_achat;

		public String getNb_visites_achat() {
			return this.Nb_visites_achat;
		}

		private Integer readInteger(ObjectInputStream dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException {
			if (intNum == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeInt(intNum);
			}
		}

		private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (intNum == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeInt(intNum);
			}
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_KEYRUS_ReadFile_V04_2.length) {
					if (length < 1024 && commonByteArray_KEYRUS_ReadFile_V04_2.length == 0) {
						commonByteArray_KEYRUS_ReadFile_V04_2 = new byte[1024];
					} else {
						commonByteArray_KEYRUS_ReadFile_V04_2 = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_KEYRUS_ReadFile_V04_2, 0, length);
				strReturn = new String(commonByteArray_KEYRUS_ReadFile_V04_2, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_KEYRUS_ReadFile_V04_2.length) {
					if (length < 1024 && commonByteArray_KEYRUS_ReadFile_V04_2.length == 0) {
						commonByteArray_KEYRUS_ReadFile_V04_2 = new byte[1024];
					} else {
						commonByteArray_KEYRUS_ReadFile_V04_2 = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_KEYRUS_ReadFile_V04_2, 0, length);
				strReturn = new String(commonByteArray_KEYRUS_ReadFile_V04_2, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_KEYRUS_ReadFile_V04_2) {

				try {

					int length = 0;

					this.ID = readInteger(dis);

					this.WEEK = readString(dis);

					this.DAY = readString(dis);

					this.Date = readString(dis);

					this.Circuit = readString(dis);

					this.Van = readString(dis);

					this.PET_EMN_33CL = readString(dis);

					this.PET_EMN_33CL_B_S_Junior = readString(dis);

					this.PET_EMN_50CL = readString(dis);

					this.PET_EMN_50CL_B_S = readString(dis);

					this.PET_EMN_150CL = readString(dis);

					this.PET_EMG_33CL = readString(dis);

					this.PET_EMG_50CL = readString(dis);

					this.PET_EMG_100CL = readString(dis);

					this.PET_SODA_PREMIUM_33CL = readString(dis);

					this.PET_SODA_PREMIUM_100CL = readString(dis);

					this.PET_SODA_PREMIUM_150CL = readString(dis);

					this.PET_SODA_PREMIUM_200CL = readString(dis);

					this.PET_PET_SODA_COLA_33CL = readString(dis);

					this.PET_SODA_COLA_100CL = readString(dis);

					this.PET_SODA_COLA_150CL = readString(dis);

					this.PET_SODA_COLA_200CL = readString(dis);

					this.PET_EF_P_tifruit_20CL = readString(dis);

					this.PET_EF_33CL = readString(dis);

					this.PET_EF_100CL = readString(dis);

					this.PET_EF_150CL = readString(dis);

					this.PET_EF_200CL = readString(dis);

					this.PET_EF_Unknown = readString(dis);

					this.PET_EFL_P_tifruit_20CL = readString(dis);

					this.PET_EFL_20CL = readString(dis);

					this.PET_EFL_33CL = readString(dis);

					this.PET_EFL_100CL = readString(dis);

					this.PET_EFL_150CL = readString(dis);

					this.PET_SPORTDRINK_50CL = readString(dis);

					this.PET_SPORTDRINK_Unknown = readString(dis);

					this.PET_JUSPUR_20CL = readString(dis);

					this.PET_JUSPUR_100CL = readString(dis);

					this.PET_BEIZEM_33CL = readString(dis);

					this.PET_BEIZEM_Unknown = readString(dis);

					this.PET_EFG_25CL = readString(dis);

					this.PET_EFG_33CL = readString(dis);

					this.PET_EFG_100CL = readString(dis);

					this.PET_EFG_150CL = readString(dis);

					this.PET_ICETHE_25CL = readString(dis);

					this.PET_ICETHE_100CL = readString(dis);

					this.PET_ICETHE_150CL = readString(dis);

					this.VERRE_EMN_25CL = readString(dis);

					this.VERRE_EMN_50CL = readString(dis);

					this.VERRE_EMN_100CL = readString(dis);

					this.VERRE_EMG_25CL = readString(dis);

					this.VERRE_EMG_50CL = readString(dis);

					this.VERRE_EMG_100CL = readString(dis);

					this.VERRE_SODA_25CL = readString(dis);

					this.VERRE_SODA_100CL = readString(dis);

					this.VERRE_SODACOLA_25CL = readString(dis);

					this.VERRE_SODACOLA_100CL = readString(dis);

					this.VERRE_EF_25CL = readString(dis);

					this.VERRE_EF_Unknown = readString(dis);

					this.VERRE_EFL_25CL = readString(dis);

					this.VERRE_EFL_Unknown = readString(dis);

					this.VERRE_CF_25CL = readString(dis);

					this.VERRE_CF_Unknown = readString(dis);

					this.VERRE_BOISSON_25CL = readString(dis);

					this.VERRE_BOISSON_Unknown = readString(dis);

					this.VERRE_IZEM_25CL = readString(dis);

					this.VERRE_BG_25CL = readString(dis);

					this.VERRE_BG_Unknown = readString(dis);

					this.VERRE_ICETHE_25CL = readString(dis);

					this.VERRE_ICETHE_Unknown = readString(dis);

					this.CANNETTE_SODA_33CL = readString(dis);

					this.CANNETTE_JUS_33CL = readString(dis);

					this.CANNETTE_ENERGY_25CL = readString(dis);

					this.CANNETTE_SODACOLA_25CL = readString(dis);

					this.CANNETTE_BG_25CL = readString(dis);

					this.Routes = readString(dis);

					this.Univers = readString(dis);

					this.Nb_visites = readString(dis);

					this.Nb_visites_achat = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_KEYRUS_ReadFile_V04_2) {

				try {

					int length = 0;

					this.ID = readInteger(dis);

					this.WEEK = readString(dis);

					this.DAY = readString(dis);

					this.Date = readString(dis);

					this.Circuit = readString(dis);

					this.Van = readString(dis);

					this.PET_EMN_33CL = readString(dis);

					this.PET_EMN_33CL_B_S_Junior = readString(dis);

					this.PET_EMN_50CL = readString(dis);

					this.PET_EMN_50CL_B_S = readString(dis);

					this.PET_EMN_150CL = readString(dis);

					this.PET_EMG_33CL = readString(dis);

					this.PET_EMG_50CL = readString(dis);

					this.PET_EMG_100CL = readString(dis);

					this.PET_SODA_PREMIUM_33CL = readString(dis);

					this.PET_SODA_PREMIUM_100CL = readString(dis);

					this.PET_SODA_PREMIUM_150CL = readString(dis);

					this.PET_SODA_PREMIUM_200CL = readString(dis);

					this.PET_PET_SODA_COLA_33CL = readString(dis);

					this.PET_SODA_COLA_100CL = readString(dis);

					this.PET_SODA_COLA_150CL = readString(dis);

					this.PET_SODA_COLA_200CL = readString(dis);

					this.PET_EF_P_tifruit_20CL = readString(dis);

					this.PET_EF_33CL = readString(dis);

					this.PET_EF_100CL = readString(dis);

					this.PET_EF_150CL = readString(dis);

					this.PET_EF_200CL = readString(dis);

					this.PET_EF_Unknown = readString(dis);

					this.PET_EFL_P_tifruit_20CL = readString(dis);

					this.PET_EFL_20CL = readString(dis);

					this.PET_EFL_33CL = readString(dis);

					this.PET_EFL_100CL = readString(dis);

					this.PET_EFL_150CL = readString(dis);

					this.PET_SPORTDRINK_50CL = readString(dis);

					this.PET_SPORTDRINK_Unknown = readString(dis);

					this.PET_JUSPUR_20CL = readString(dis);

					this.PET_JUSPUR_100CL = readString(dis);

					this.PET_BEIZEM_33CL = readString(dis);

					this.PET_BEIZEM_Unknown = readString(dis);

					this.PET_EFG_25CL = readString(dis);

					this.PET_EFG_33CL = readString(dis);

					this.PET_EFG_100CL = readString(dis);

					this.PET_EFG_150CL = readString(dis);

					this.PET_ICETHE_25CL = readString(dis);

					this.PET_ICETHE_100CL = readString(dis);

					this.PET_ICETHE_150CL = readString(dis);

					this.VERRE_EMN_25CL = readString(dis);

					this.VERRE_EMN_50CL = readString(dis);

					this.VERRE_EMN_100CL = readString(dis);

					this.VERRE_EMG_25CL = readString(dis);

					this.VERRE_EMG_50CL = readString(dis);

					this.VERRE_EMG_100CL = readString(dis);

					this.VERRE_SODA_25CL = readString(dis);

					this.VERRE_SODA_100CL = readString(dis);

					this.VERRE_SODACOLA_25CL = readString(dis);

					this.VERRE_SODACOLA_100CL = readString(dis);

					this.VERRE_EF_25CL = readString(dis);

					this.VERRE_EF_Unknown = readString(dis);

					this.VERRE_EFL_25CL = readString(dis);

					this.VERRE_EFL_Unknown = readString(dis);

					this.VERRE_CF_25CL = readString(dis);

					this.VERRE_CF_Unknown = readString(dis);

					this.VERRE_BOISSON_25CL = readString(dis);

					this.VERRE_BOISSON_Unknown = readString(dis);

					this.VERRE_IZEM_25CL = readString(dis);

					this.VERRE_BG_25CL = readString(dis);

					this.VERRE_BG_Unknown = readString(dis);

					this.VERRE_ICETHE_25CL = readString(dis);

					this.VERRE_ICETHE_Unknown = readString(dis);

					this.CANNETTE_SODA_33CL = readString(dis);

					this.CANNETTE_JUS_33CL = readString(dis);

					this.CANNETTE_ENERGY_25CL = readString(dis);

					this.CANNETTE_SODACOLA_25CL = readString(dis);

					this.CANNETTE_BG_25CL = readString(dis);

					this.Routes = readString(dis);

					this.Univers = readString(dis);

					this.Nb_visites = readString(dis);

					this.Nb_visites_achat = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// Integer

				writeInteger(this.ID, dos);

				// String

				writeString(this.WEEK, dos);

				// String

				writeString(this.DAY, dos);

				// String

				writeString(this.Date, dos);

				// String

				writeString(this.Circuit, dos);

				// String

				writeString(this.Van, dos);

				// String

				writeString(this.PET_EMN_33CL, dos);

				// String

				writeString(this.PET_EMN_33CL_B_S_Junior, dos);

				// String

				writeString(this.PET_EMN_50CL, dos);

				// String

				writeString(this.PET_EMN_50CL_B_S, dos);

				// String

				writeString(this.PET_EMN_150CL, dos);

				// String

				writeString(this.PET_EMG_33CL, dos);

				// String

				writeString(this.PET_EMG_50CL, dos);

				// String

				writeString(this.PET_EMG_100CL, dos);

				// String

				writeString(this.PET_SODA_PREMIUM_33CL, dos);

				// String

				writeString(this.PET_SODA_PREMIUM_100CL, dos);

				// String

				writeString(this.PET_SODA_PREMIUM_150CL, dos);

				// String

				writeString(this.PET_SODA_PREMIUM_200CL, dos);

				// String

				writeString(this.PET_PET_SODA_COLA_33CL, dos);

				// String

				writeString(this.PET_SODA_COLA_100CL, dos);

				// String

				writeString(this.PET_SODA_COLA_150CL, dos);

				// String

				writeString(this.PET_SODA_COLA_200CL, dos);

				// String

				writeString(this.PET_EF_P_tifruit_20CL, dos);

				// String

				writeString(this.PET_EF_33CL, dos);

				// String

				writeString(this.PET_EF_100CL, dos);

				// String

				writeString(this.PET_EF_150CL, dos);

				// String

				writeString(this.PET_EF_200CL, dos);

				// String

				writeString(this.PET_EF_Unknown, dos);

				// String

				writeString(this.PET_EFL_P_tifruit_20CL, dos);

				// String

				writeString(this.PET_EFL_20CL, dos);

				// String

				writeString(this.PET_EFL_33CL, dos);

				// String

				writeString(this.PET_EFL_100CL, dos);

				// String

				writeString(this.PET_EFL_150CL, dos);

				// String

				writeString(this.PET_SPORTDRINK_50CL, dos);

				// String

				writeString(this.PET_SPORTDRINK_Unknown, dos);

				// String

				writeString(this.PET_JUSPUR_20CL, dos);

				// String

				writeString(this.PET_JUSPUR_100CL, dos);

				// String

				writeString(this.PET_BEIZEM_33CL, dos);

				// String

				writeString(this.PET_BEIZEM_Unknown, dos);

				// String

				writeString(this.PET_EFG_25CL, dos);

				// String

				writeString(this.PET_EFG_33CL, dos);

				// String

				writeString(this.PET_EFG_100CL, dos);

				// String

				writeString(this.PET_EFG_150CL, dos);

				// String

				writeString(this.PET_ICETHE_25CL, dos);

				// String

				writeString(this.PET_ICETHE_100CL, dos);

				// String

				writeString(this.PET_ICETHE_150CL, dos);

				// String

				writeString(this.VERRE_EMN_25CL, dos);

				// String

				writeString(this.VERRE_EMN_50CL, dos);

				// String

				writeString(this.VERRE_EMN_100CL, dos);

				// String

				writeString(this.VERRE_EMG_25CL, dos);

				// String

				writeString(this.VERRE_EMG_50CL, dos);

				// String

				writeString(this.VERRE_EMG_100CL, dos);

				// String

				writeString(this.VERRE_SODA_25CL, dos);

				// String

				writeString(this.VERRE_SODA_100CL, dos);

				// String

				writeString(this.VERRE_SODACOLA_25CL, dos);

				// String

				writeString(this.VERRE_SODACOLA_100CL, dos);

				// String

				writeString(this.VERRE_EF_25CL, dos);

				// String

				writeString(this.VERRE_EF_Unknown, dos);

				// String

				writeString(this.VERRE_EFL_25CL, dos);

				// String

				writeString(this.VERRE_EFL_Unknown, dos);

				// String

				writeString(this.VERRE_CF_25CL, dos);

				// String

				writeString(this.VERRE_CF_Unknown, dos);

				// String

				writeString(this.VERRE_BOISSON_25CL, dos);

				// String

				writeString(this.VERRE_BOISSON_Unknown, dos);

				// String

				writeString(this.VERRE_IZEM_25CL, dos);

				// String

				writeString(this.VERRE_BG_25CL, dos);

				// String

				writeString(this.VERRE_BG_Unknown, dos);

				// String

				writeString(this.VERRE_ICETHE_25CL, dos);

				// String

				writeString(this.VERRE_ICETHE_Unknown, dos);

				// String

				writeString(this.CANNETTE_SODA_33CL, dos);

				// String

				writeString(this.CANNETTE_JUS_33CL, dos);

				// String

				writeString(this.CANNETTE_ENERGY_25CL, dos);

				// String

				writeString(this.CANNETTE_SODACOLA_25CL, dos);

				// String

				writeString(this.CANNETTE_BG_25CL, dos);

				// String

				writeString(this.Routes, dos);

				// String

				writeString(this.Univers, dos);

				// String

				writeString(this.Nb_visites, dos);

				// String

				writeString(this.Nb_visites_achat, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// Integer

				writeInteger(this.ID, dos);

				// String

				writeString(this.WEEK, dos);

				// String

				writeString(this.DAY, dos);

				// String

				writeString(this.Date, dos);

				// String

				writeString(this.Circuit, dos);

				// String

				writeString(this.Van, dos);

				// String

				writeString(this.PET_EMN_33CL, dos);

				// String

				writeString(this.PET_EMN_33CL_B_S_Junior, dos);

				// String

				writeString(this.PET_EMN_50CL, dos);

				// String

				writeString(this.PET_EMN_50CL_B_S, dos);

				// String

				writeString(this.PET_EMN_150CL, dos);

				// String

				writeString(this.PET_EMG_33CL, dos);

				// String

				writeString(this.PET_EMG_50CL, dos);

				// String

				writeString(this.PET_EMG_100CL, dos);

				// String

				writeString(this.PET_SODA_PREMIUM_33CL, dos);

				// String

				writeString(this.PET_SODA_PREMIUM_100CL, dos);

				// String

				writeString(this.PET_SODA_PREMIUM_150CL, dos);

				// String

				writeString(this.PET_SODA_PREMIUM_200CL, dos);

				// String

				writeString(this.PET_PET_SODA_COLA_33CL, dos);

				// String

				writeString(this.PET_SODA_COLA_100CL, dos);

				// String

				writeString(this.PET_SODA_COLA_150CL, dos);

				// String

				writeString(this.PET_SODA_COLA_200CL, dos);

				// String

				writeString(this.PET_EF_P_tifruit_20CL, dos);

				// String

				writeString(this.PET_EF_33CL, dos);

				// String

				writeString(this.PET_EF_100CL, dos);

				// String

				writeString(this.PET_EF_150CL, dos);

				// String

				writeString(this.PET_EF_200CL, dos);

				// String

				writeString(this.PET_EF_Unknown, dos);

				// String

				writeString(this.PET_EFL_P_tifruit_20CL, dos);

				// String

				writeString(this.PET_EFL_20CL, dos);

				// String

				writeString(this.PET_EFL_33CL, dos);

				// String

				writeString(this.PET_EFL_100CL, dos);

				// String

				writeString(this.PET_EFL_150CL, dos);

				// String

				writeString(this.PET_SPORTDRINK_50CL, dos);

				// String

				writeString(this.PET_SPORTDRINK_Unknown, dos);

				// String

				writeString(this.PET_JUSPUR_20CL, dos);

				// String

				writeString(this.PET_JUSPUR_100CL, dos);

				// String

				writeString(this.PET_BEIZEM_33CL, dos);

				// String

				writeString(this.PET_BEIZEM_Unknown, dos);

				// String

				writeString(this.PET_EFG_25CL, dos);

				// String

				writeString(this.PET_EFG_33CL, dos);

				// String

				writeString(this.PET_EFG_100CL, dos);

				// String

				writeString(this.PET_EFG_150CL, dos);

				// String

				writeString(this.PET_ICETHE_25CL, dos);

				// String

				writeString(this.PET_ICETHE_100CL, dos);

				// String

				writeString(this.PET_ICETHE_150CL, dos);

				// String

				writeString(this.VERRE_EMN_25CL, dos);

				// String

				writeString(this.VERRE_EMN_50CL, dos);

				// String

				writeString(this.VERRE_EMN_100CL, dos);

				// String

				writeString(this.VERRE_EMG_25CL, dos);

				// String

				writeString(this.VERRE_EMG_50CL, dos);

				// String

				writeString(this.VERRE_EMG_100CL, dos);

				// String

				writeString(this.VERRE_SODA_25CL, dos);

				// String

				writeString(this.VERRE_SODA_100CL, dos);

				// String

				writeString(this.VERRE_SODACOLA_25CL, dos);

				// String

				writeString(this.VERRE_SODACOLA_100CL, dos);

				// String

				writeString(this.VERRE_EF_25CL, dos);

				// String

				writeString(this.VERRE_EF_Unknown, dos);

				// String

				writeString(this.VERRE_EFL_25CL, dos);

				// String

				writeString(this.VERRE_EFL_Unknown, dos);

				// String

				writeString(this.VERRE_CF_25CL, dos);

				// String

				writeString(this.VERRE_CF_Unknown, dos);

				// String

				writeString(this.VERRE_BOISSON_25CL, dos);

				// String

				writeString(this.VERRE_BOISSON_Unknown, dos);

				// String

				writeString(this.VERRE_IZEM_25CL, dos);

				// String

				writeString(this.VERRE_BG_25CL, dos);

				// String

				writeString(this.VERRE_BG_Unknown, dos);

				// String

				writeString(this.VERRE_ICETHE_25CL, dos);

				// String

				writeString(this.VERRE_ICETHE_Unknown, dos);

				// String

				writeString(this.CANNETTE_SODA_33CL, dos);

				// String

				writeString(this.CANNETTE_JUS_33CL, dos);

				// String

				writeString(this.CANNETTE_ENERGY_25CL, dos);

				// String

				writeString(this.CANNETTE_SODACOLA_25CL, dos);

				// String

				writeString(this.CANNETTE_BG_25CL, dos);

				// String

				writeString(this.Routes, dos);

				// String

				writeString(this.Univers, dos);

				// String

				writeString(this.Nb_visites, dos);

				// String

				writeString(this.Nb_visites_achat, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("ID=" + String.valueOf(ID));
			sb.append(",WEEK=" + WEEK);
			sb.append(",DAY=" + DAY);
			sb.append(",Date=" + Date);
			sb.append(",Circuit=" + Circuit);
			sb.append(",Van=" + Van);
			sb.append(",PET_EMN_33CL=" + PET_EMN_33CL);
			sb.append(",PET_EMN_33CL_B_S_Junior=" + PET_EMN_33CL_B_S_Junior);
			sb.append(",PET_EMN_50CL=" + PET_EMN_50CL);
			sb.append(",PET_EMN_50CL_B_S=" + PET_EMN_50CL_B_S);
			sb.append(",PET_EMN_150CL=" + PET_EMN_150CL);
			sb.append(",PET_EMG_33CL=" + PET_EMG_33CL);
			sb.append(",PET_EMG_50CL=" + PET_EMG_50CL);
			sb.append(",PET_EMG_100CL=" + PET_EMG_100CL);
			sb.append(",PET_SODA_PREMIUM_33CL=" + PET_SODA_PREMIUM_33CL);
			sb.append(",PET_SODA_PREMIUM_100CL=" + PET_SODA_PREMIUM_100CL);
			sb.append(",PET_SODA_PREMIUM_150CL=" + PET_SODA_PREMIUM_150CL);
			sb.append(",PET_SODA_PREMIUM_200CL=" + PET_SODA_PREMIUM_200CL);
			sb.append(",PET_PET_SODA_COLA_33CL=" + PET_PET_SODA_COLA_33CL);
			sb.append(",PET_SODA_COLA_100CL=" + PET_SODA_COLA_100CL);
			sb.append(",PET_SODA_COLA_150CL=" + PET_SODA_COLA_150CL);
			sb.append(",PET_SODA_COLA_200CL=" + PET_SODA_COLA_200CL);
			sb.append(",PET_EF_P_tifruit_20CL=" + PET_EF_P_tifruit_20CL);
			sb.append(",PET_EF_33CL=" + PET_EF_33CL);
			sb.append(",PET_EF_100CL=" + PET_EF_100CL);
			sb.append(",PET_EF_150CL=" + PET_EF_150CL);
			sb.append(",PET_EF_200CL=" + PET_EF_200CL);
			sb.append(",PET_EF_Unknown=" + PET_EF_Unknown);
			sb.append(",PET_EFL_P_tifruit_20CL=" + PET_EFL_P_tifruit_20CL);
			sb.append(",PET_EFL_20CL=" + PET_EFL_20CL);
			sb.append(",PET_EFL_33CL=" + PET_EFL_33CL);
			sb.append(",PET_EFL_100CL=" + PET_EFL_100CL);
			sb.append(",PET_EFL_150CL=" + PET_EFL_150CL);
			sb.append(",PET_SPORTDRINK_50CL=" + PET_SPORTDRINK_50CL);
			sb.append(",PET_SPORTDRINK_Unknown=" + PET_SPORTDRINK_Unknown);
			sb.append(",PET_JUSPUR_20CL=" + PET_JUSPUR_20CL);
			sb.append(",PET_JUSPUR_100CL=" + PET_JUSPUR_100CL);
			sb.append(",PET_BEIZEM_33CL=" + PET_BEIZEM_33CL);
			sb.append(",PET_BEIZEM_Unknown=" + PET_BEIZEM_Unknown);
			sb.append(",PET_EFG_25CL=" + PET_EFG_25CL);
			sb.append(",PET_EFG_33CL=" + PET_EFG_33CL);
			sb.append(",PET_EFG_100CL=" + PET_EFG_100CL);
			sb.append(",PET_EFG_150CL=" + PET_EFG_150CL);
			sb.append(",PET_ICETHE_25CL=" + PET_ICETHE_25CL);
			sb.append(",PET_ICETHE_100CL=" + PET_ICETHE_100CL);
			sb.append(",PET_ICETHE_150CL=" + PET_ICETHE_150CL);
			sb.append(",VERRE_EMN_25CL=" + VERRE_EMN_25CL);
			sb.append(",VERRE_EMN_50CL=" + VERRE_EMN_50CL);
			sb.append(",VERRE_EMN_100CL=" + VERRE_EMN_100CL);
			sb.append(",VERRE_EMG_25CL=" + VERRE_EMG_25CL);
			sb.append(",VERRE_EMG_50CL=" + VERRE_EMG_50CL);
			sb.append(",VERRE_EMG_100CL=" + VERRE_EMG_100CL);
			sb.append(",VERRE_SODA_25CL=" + VERRE_SODA_25CL);
			sb.append(",VERRE_SODA_100CL=" + VERRE_SODA_100CL);
			sb.append(",VERRE_SODACOLA_25CL=" + VERRE_SODACOLA_25CL);
			sb.append(",VERRE_SODACOLA_100CL=" + VERRE_SODACOLA_100CL);
			sb.append(",VERRE_EF_25CL=" + VERRE_EF_25CL);
			sb.append(",VERRE_EF_Unknown=" + VERRE_EF_Unknown);
			sb.append(",VERRE_EFL_25CL=" + VERRE_EFL_25CL);
			sb.append(",VERRE_EFL_Unknown=" + VERRE_EFL_Unknown);
			sb.append(",VERRE_CF_25CL=" + VERRE_CF_25CL);
			sb.append(",VERRE_CF_Unknown=" + VERRE_CF_Unknown);
			sb.append(",VERRE_BOISSON_25CL=" + VERRE_BOISSON_25CL);
			sb.append(",VERRE_BOISSON_Unknown=" + VERRE_BOISSON_Unknown);
			sb.append(",VERRE_IZEM_25CL=" + VERRE_IZEM_25CL);
			sb.append(",VERRE_BG_25CL=" + VERRE_BG_25CL);
			sb.append(",VERRE_BG_Unknown=" + VERRE_BG_Unknown);
			sb.append(",VERRE_ICETHE_25CL=" + VERRE_ICETHE_25CL);
			sb.append(",VERRE_ICETHE_Unknown=" + VERRE_ICETHE_Unknown);
			sb.append(",CANNETTE_SODA_33CL=" + CANNETTE_SODA_33CL);
			sb.append(",CANNETTE_JUS_33CL=" + CANNETTE_JUS_33CL);
			sb.append(",CANNETTE_ENERGY_25CL=" + CANNETTE_ENERGY_25CL);
			sb.append(",CANNETTE_SODACOLA_25CL=" + CANNETTE_SODACOLA_25CL);
			sb.append(",CANNETTE_BG_25CL=" + CANNETTE_BG_25CL);
			sb.append(",Routes=" + Routes);
			sb.append(",Univers=" + Univers);
			sb.append(",Nb_visites=" + Nb_visites);
			sb.append(",Nb_visites_achat=" + Nb_visites_achat);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row6Struct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public static class OnRowsEndStructtSortRow_2
			implements routines.system.IPersistableRow<OnRowsEndStructtSortRow_2> {
		final static byte[] commonByteArrayLock_KEYRUS_ReadFile_V04_2 = new byte[0];
		static byte[] commonByteArray_KEYRUS_ReadFile_V04_2 = new byte[0];

		public Integer ID;

		public Integer getID() {
			return this.ID;
		}

		public String WEEK;

		public String getWEEK() {
			return this.WEEK;
		}

		public String DAY;

		public String getDAY() {
			return this.DAY;
		}

		public String Date;

		public String getDate() {
			return this.Date;
		}

		public String Circuit;

		public String getCircuit() {
			return this.Circuit;
		}

		public String Van;

		public String getVan() {
			return this.Van;
		}

		public String PET_EMN_33CL;

		public String getPET_EMN_33CL() {
			return this.PET_EMN_33CL;
		}

		public String PET_EMN_33CL_B_S_Junior;

		public String getPET_EMN_33CL_B_S_Junior() {
			return this.PET_EMN_33CL_B_S_Junior;
		}

		public String PET_EMN_50CL;

		public String getPET_EMN_50CL() {
			return this.PET_EMN_50CL;
		}

		public String PET_EMN_50CL_B_S;

		public String getPET_EMN_50CL_B_S() {
			return this.PET_EMN_50CL_B_S;
		}

		public String PET_EMN_150CL;

		public String getPET_EMN_150CL() {
			return this.PET_EMN_150CL;
		}

		public String PET_EMG_33CL;

		public String getPET_EMG_33CL() {
			return this.PET_EMG_33CL;
		}

		public String PET_EMG_50CL;

		public String getPET_EMG_50CL() {
			return this.PET_EMG_50CL;
		}

		public String PET_EMG_100CL;

		public String getPET_EMG_100CL() {
			return this.PET_EMG_100CL;
		}

		public String PET_SODA_PREMIUM_33CL;

		public String getPET_SODA_PREMIUM_33CL() {
			return this.PET_SODA_PREMIUM_33CL;
		}

		public String PET_SODA_PREMIUM_100CL;

		public String getPET_SODA_PREMIUM_100CL() {
			return this.PET_SODA_PREMIUM_100CL;
		}

		public String PET_SODA_PREMIUM_150CL;

		public String getPET_SODA_PREMIUM_150CL() {
			return this.PET_SODA_PREMIUM_150CL;
		}

		public String PET_SODA_PREMIUM_200CL;

		public String getPET_SODA_PREMIUM_200CL() {
			return this.PET_SODA_PREMIUM_200CL;
		}

		public String PET_PET_SODA_COLA_33CL;

		public String getPET_PET_SODA_COLA_33CL() {
			return this.PET_PET_SODA_COLA_33CL;
		}

		public String PET_SODA_COLA_100CL;

		public String getPET_SODA_COLA_100CL() {
			return this.PET_SODA_COLA_100CL;
		}

		public String PET_SODA_COLA_150CL;

		public String getPET_SODA_COLA_150CL() {
			return this.PET_SODA_COLA_150CL;
		}

		public String PET_SODA_COLA_200CL;

		public String getPET_SODA_COLA_200CL() {
			return this.PET_SODA_COLA_200CL;
		}

		public String PET_EF_P_tifruit_20CL;

		public String getPET_EF_P_tifruit_20CL() {
			return this.PET_EF_P_tifruit_20CL;
		}

		public String PET_EF_33CL;

		public String getPET_EF_33CL() {
			return this.PET_EF_33CL;
		}

		public String PET_EF_100CL;

		public String getPET_EF_100CL() {
			return this.PET_EF_100CL;
		}

		public String PET_EF_150CL;

		public String getPET_EF_150CL() {
			return this.PET_EF_150CL;
		}

		public String PET_EF_200CL;

		public String getPET_EF_200CL() {
			return this.PET_EF_200CL;
		}

		public String PET_EF_Unknown;

		public String getPET_EF_Unknown() {
			return this.PET_EF_Unknown;
		}

		public String PET_EFL_P_tifruit_20CL;

		public String getPET_EFL_P_tifruit_20CL() {
			return this.PET_EFL_P_tifruit_20CL;
		}

		public String PET_EFL_20CL;

		public String getPET_EFL_20CL() {
			return this.PET_EFL_20CL;
		}

		public String PET_EFL_33CL;

		public String getPET_EFL_33CL() {
			return this.PET_EFL_33CL;
		}

		public String PET_EFL_100CL;

		public String getPET_EFL_100CL() {
			return this.PET_EFL_100CL;
		}

		public String PET_EFL_150CL;

		public String getPET_EFL_150CL() {
			return this.PET_EFL_150CL;
		}

		public String PET_SPORTDRINK_50CL;

		public String getPET_SPORTDRINK_50CL() {
			return this.PET_SPORTDRINK_50CL;
		}

		public String PET_SPORTDRINK_Unknown;

		public String getPET_SPORTDRINK_Unknown() {
			return this.PET_SPORTDRINK_Unknown;
		}

		public String PET_JUSPUR_20CL;

		public String getPET_JUSPUR_20CL() {
			return this.PET_JUSPUR_20CL;
		}

		public String PET_JUSPUR_100CL;

		public String getPET_JUSPUR_100CL() {
			return this.PET_JUSPUR_100CL;
		}

		public String PET_BEIZEM_33CL;

		public String getPET_BEIZEM_33CL() {
			return this.PET_BEIZEM_33CL;
		}

		public String PET_BEIZEM_Unknown;

		public String getPET_BEIZEM_Unknown() {
			return this.PET_BEIZEM_Unknown;
		}

		public String PET_EFG_25CL;

		public String getPET_EFG_25CL() {
			return this.PET_EFG_25CL;
		}

		public String PET_EFG_33CL;

		public String getPET_EFG_33CL() {
			return this.PET_EFG_33CL;
		}

		public String PET_EFG_100CL;

		public String getPET_EFG_100CL() {
			return this.PET_EFG_100CL;
		}

		public String PET_EFG_150CL;

		public String getPET_EFG_150CL() {
			return this.PET_EFG_150CL;
		}

		public String PET_ICETHE_25CL;

		public String getPET_ICETHE_25CL() {
			return this.PET_ICETHE_25CL;
		}

		public String PET_ICETHE_100CL;

		public String getPET_ICETHE_100CL() {
			return this.PET_ICETHE_100CL;
		}

		public String PET_ICETHE_150CL;

		public String getPET_ICETHE_150CL() {
			return this.PET_ICETHE_150CL;
		}

		public String VERRE_EMN_25CL;

		public String getVERRE_EMN_25CL() {
			return this.VERRE_EMN_25CL;
		}

		public String VERRE_EMN_50CL;

		public String getVERRE_EMN_50CL() {
			return this.VERRE_EMN_50CL;
		}

		public String VERRE_EMN_100CL;

		public String getVERRE_EMN_100CL() {
			return this.VERRE_EMN_100CL;
		}

		public String VERRE_EMG_25CL;

		public String getVERRE_EMG_25CL() {
			return this.VERRE_EMG_25CL;
		}

		public String VERRE_EMG_50CL;

		public String getVERRE_EMG_50CL() {
			return this.VERRE_EMG_50CL;
		}

		public String VERRE_EMG_100CL;

		public String getVERRE_EMG_100CL() {
			return this.VERRE_EMG_100CL;
		}

		public String VERRE_SODA_25CL;

		public String getVERRE_SODA_25CL() {
			return this.VERRE_SODA_25CL;
		}

		public String VERRE_SODA_100CL;

		public String getVERRE_SODA_100CL() {
			return this.VERRE_SODA_100CL;
		}

		public String VERRE_SODACOLA_25CL;

		public String getVERRE_SODACOLA_25CL() {
			return this.VERRE_SODACOLA_25CL;
		}

		public String VERRE_SODACOLA_100CL;

		public String getVERRE_SODACOLA_100CL() {
			return this.VERRE_SODACOLA_100CL;
		}

		public String VERRE_EF_25CL;

		public String getVERRE_EF_25CL() {
			return this.VERRE_EF_25CL;
		}

		public String VERRE_EF_Unknown;

		public String getVERRE_EF_Unknown() {
			return this.VERRE_EF_Unknown;
		}

		public String VERRE_EFL_25CL;

		public String getVERRE_EFL_25CL() {
			return this.VERRE_EFL_25CL;
		}

		public String VERRE_EFL_Unknown;

		public String getVERRE_EFL_Unknown() {
			return this.VERRE_EFL_Unknown;
		}

		public String VERRE_CF_25CL;

		public String getVERRE_CF_25CL() {
			return this.VERRE_CF_25CL;
		}

		public String VERRE_CF_Unknown;

		public String getVERRE_CF_Unknown() {
			return this.VERRE_CF_Unknown;
		}

		public String VERRE_BOISSON_25CL;

		public String getVERRE_BOISSON_25CL() {
			return this.VERRE_BOISSON_25CL;
		}

		public String VERRE_BOISSON_Unknown;

		public String getVERRE_BOISSON_Unknown() {
			return this.VERRE_BOISSON_Unknown;
		}

		public String VERRE_IZEM_25CL;

		public String getVERRE_IZEM_25CL() {
			return this.VERRE_IZEM_25CL;
		}

		public String VERRE_BG_25CL;

		public String getVERRE_BG_25CL() {
			return this.VERRE_BG_25CL;
		}

		public String VERRE_BG_Unknown;

		public String getVERRE_BG_Unknown() {
			return this.VERRE_BG_Unknown;
		}

		public String VERRE_ICETHE_25CL;

		public String getVERRE_ICETHE_25CL() {
			return this.VERRE_ICETHE_25CL;
		}

		public String VERRE_ICETHE_Unknown;

		public String getVERRE_ICETHE_Unknown() {
			return this.VERRE_ICETHE_Unknown;
		}

		public String CANNETTE_SODA_33CL;

		public String getCANNETTE_SODA_33CL() {
			return this.CANNETTE_SODA_33CL;
		}

		public String CANNETTE_JUS_33CL;

		public String getCANNETTE_JUS_33CL() {
			return this.CANNETTE_JUS_33CL;
		}

		public String CANNETTE_ENERGY_25CL;

		public String getCANNETTE_ENERGY_25CL() {
			return this.CANNETTE_ENERGY_25CL;
		}

		public String CANNETTE_SODACOLA_25CL;

		public String getCANNETTE_SODACOLA_25CL() {
			return this.CANNETTE_SODACOLA_25CL;
		}

		public String CANNETTE_BG_25CL;

		public String getCANNETTE_BG_25CL() {
			return this.CANNETTE_BG_25CL;
		}

		public String Routes;

		public String getRoutes() {
			return this.Routes;
		}

		public String Univers;

		public String getUnivers() {
			return this.Univers;
		}

		public String Nb_visites;

		public String getNb_visites() {
			return this.Nb_visites;
		}

		public String Nb_visites_achat;

		public String getNb_visites_achat() {
			return this.Nb_visites_achat;
		}

		private Integer readInteger(ObjectInputStream dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException {
			if (intNum == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeInt(intNum);
			}
		}

		private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (intNum == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeInt(intNum);
			}
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_KEYRUS_ReadFile_V04_2.length) {
					if (length < 1024 && commonByteArray_KEYRUS_ReadFile_V04_2.length == 0) {
						commonByteArray_KEYRUS_ReadFile_V04_2 = new byte[1024];
					} else {
						commonByteArray_KEYRUS_ReadFile_V04_2 = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_KEYRUS_ReadFile_V04_2, 0, length);
				strReturn = new String(commonByteArray_KEYRUS_ReadFile_V04_2, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_KEYRUS_ReadFile_V04_2.length) {
					if (length < 1024 && commonByteArray_KEYRUS_ReadFile_V04_2.length == 0) {
						commonByteArray_KEYRUS_ReadFile_V04_2 = new byte[1024];
					} else {
						commonByteArray_KEYRUS_ReadFile_V04_2 = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_KEYRUS_ReadFile_V04_2, 0, length);
				strReturn = new String(commonByteArray_KEYRUS_ReadFile_V04_2, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_KEYRUS_ReadFile_V04_2) {

				try {

					int length = 0;

					this.ID = readInteger(dis);

					this.WEEK = readString(dis);

					this.DAY = readString(dis);

					this.Date = readString(dis);

					this.Circuit = readString(dis);

					this.Van = readString(dis);

					this.PET_EMN_33CL = readString(dis);

					this.PET_EMN_33CL_B_S_Junior = readString(dis);

					this.PET_EMN_50CL = readString(dis);

					this.PET_EMN_50CL_B_S = readString(dis);

					this.PET_EMN_150CL = readString(dis);

					this.PET_EMG_33CL = readString(dis);

					this.PET_EMG_50CL = readString(dis);

					this.PET_EMG_100CL = readString(dis);

					this.PET_SODA_PREMIUM_33CL = readString(dis);

					this.PET_SODA_PREMIUM_100CL = readString(dis);

					this.PET_SODA_PREMIUM_150CL = readString(dis);

					this.PET_SODA_PREMIUM_200CL = readString(dis);

					this.PET_PET_SODA_COLA_33CL = readString(dis);

					this.PET_SODA_COLA_100CL = readString(dis);

					this.PET_SODA_COLA_150CL = readString(dis);

					this.PET_SODA_COLA_200CL = readString(dis);

					this.PET_EF_P_tifruit_20CL = readString(dis);

					this.PET_EF_33CL = readString(dis);

					this.PET_EF_100CL = readString(dis);

					this.PET_EF_150CL = readString(dis);

					this.PET_EF_200CL = readString(dis);

					this.PET_EF_Unknown = readString(dis);

					this.PET_EFL_P_tifruit_20CL = readString(dis);

					this.PET_EFL_20CL = readString(dis);

					this.PET_EFL_33CL = readString(dis);

					this.PET_EFL_100CL = readString(dis);

					this.PET_EFL_150CL = readString(dis);

					this.PET_SPORTDRINK_50CL = readString(dis);

					this.PET_SPORTDRINK_Unknown = readString(dis);

					this.PET_JUSPUR_20CL = readString(dis);

					this.PET_JUSPUR_100CL = readString(dis);

					this.PET_BEIZEM_33CL = readString(dis);

					this.PET_BEIZEM_Unknown = readString(dis);

					this.PET_EFG_25CL = readString(dis);

					this.PET_EFG_33CL = readString(dis);

					this.PET_EFG_100CL = readString(dis);

					this.PET_EFG_150CL = readString(dis);

					this.PET_ICETHE_25CL = readString(dis);

					this.PET_ICETHE_100CL = readString(dis);

					this.PET_ICETHE_150CL = readString(dis);

					this.VERRE_EMN_25CL = readString(dis);

					this.VERRE_EMN_50CL = readString(dis);

					this.VERRE_EMN_100CL = readString(dis);

					this.VERRE_EMG_25CL = readString(dis);

					this.VERRE_EMG_50CL = readString(dis);

					this.VERRE_EMG_100CL = readString(dis);

					this.VERRE_SODA_25CL = readString(dis);

					this.VERRE_SODA_100CL = readString(dis);

					this.VERRE_SODACOLA_25CL = readString(dis);

					this.VERRE_SODACOLA_100CL = readString(dis);

					this.VERRE_EF_25CL = readString(dis);

					this.VERRE_EF_Unknown = readString(dis);

					this.VERRE_EFL_25CL = readString(dis);

					this.VERRE_EFL_Unknown = readString(dis);

					this.VERRE_CF_25CL = readString(dis);

					this.VERRE_CF_Unknown = readString(dis);

					this.VERRE_BOISSON_25CL = readString(dis);

					this.VERRE_BOISSON_Unknown = readString(dis);

					this.VERRE_IZEM_25CL = readString(dis);

					this.VERRE_BG_25CL = readString(dis);

					this.VERRE_BG_Unknown = readString(dis);

					this.VERRE_ICETHE_25CL = readString(dis);

					this.VERRE_ICETHE_Unknown = readString(dis);

					this.CANNETTE_SODA_33CL = readString(dis);

					this.CANNETTE_JUS_33CL = readString(dis);

					this.CANNETTE_ENERGY_25CL = readString(dis);

					this.CANNETTE_SODACOLA_25CL = readString(dis);

					this.CANNETTE_BG_25CL = readString(dis);

					this.Routes = readString(dis);

					this.Univers = readString(dis);

					this.Nb_visites = readString(dis);

					this.Nb_visites_achat = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_KEYRUS_ReadFile_V04_2) {

				try {

					int length = 0;

					this.ID = readInteger(dis);

					this.WEEK = readString(dis);

					this.DAY = readString(dis);

					this.Date = readString(dis);

					this.Circuit = readString(dis);

					this.Van = readString(dis);

					this.PET_EMN_33CL = readString(dis);

					this.PET_EMN_33CL_B_S_Junior = readString(dis);

					this.PET_EMN_50CL = readString(dis);

					this.PET_EMN_50CL_B_S = readString(dis);

					this.PET_EMN_150CL = readString(dis);

					this.PET_EMG_33CL = readString(dis);

					this.PET_EMG_50CL = readString(dis);

					this.PET_EMG_100CL = readString(dis);

					this.PET_SODA_PREMIUM_33CL = readString(dis);

					this.PET_SODA_PREMIUM_100CL = readString(dis);

					this.PET_SODA_PREMIUM_150CL = readString(dis);

					this.PET_SODA_PREMIUM_200CL = readString(dis);

					this.PET_PET_SODA_COLA_33CL = readString(dis);

					this.PET_SODA_COLA_100CL = readString(dis);

					this.PET_SODA_COLA_150CL = readString(dis);

					this.PET_SODA_COLA_200CL = readString(dis);

					this.PET_EF_P_tifruit_20CL = readString(dis);

					this.PET_EF_33CL = readString(dis);

					this.PET_EF_100CL = readString(dis);

					this.PET_EF_150CL = readString(dis);

					this.PET_EF_200CL = readString(dis);

					this.PET_EF_Unknown = readString(dis);

					this.PET_EFL_P_tifruit_20CL = readString(dis);

					this.PET_EFL_20CL = readString(dis);

					this.PET_EFL_33CL = readString(dis);

					this.PET_EFL_100CL = readString(dis);

					this.PET_EFL_150CL = readString(dis);

					this.PET_SPORTDRINK_50CL = readString(dis);

					this.PET_SPORTDRINK_Unknown = readString(dis);

					this.PET_JUSPUR_20CL = readString(dis);

					this.PET_JUSPUR_100CL = readString(dis);

					this.PET_BEIZEM_33CL = readString(dis);

					this.PET_BEIZEM_Unknown = readString(dis);

					this.PET_EFG_25CL = readString(dis);

					this.PET_EFG_33CL = readString(dis);

					this.PET_EFG_100CL = readString(dis);

					this.PET_EFG_150CL = readString(dis);

					this.PET_ICETHE_25CL = readString(dis);

					this.PET_ICETHE_100CL = readString(dis);

					this.PET_ICETHE_150CL = readString(dis);

					this.VERRE_EMN_25CL = readString(dis);

					this.VERRE_EMN_50CL = readString(dis);

					this.VERRE_EMN_100CL = readString(dis);

					this.VERRE_EMG_25CL = readString(dis);

					this.VERRE_EMG_50CL = readString(dis);

					this.VERRE_EMG_100CL = readString(dis);

					this.VERRE_SODA_25CL = readString(dis);

					this.VERRE_SODA_100CL = readString(dis);

					this.VERRE_SODACOLA_25CL = readString(dis);

					this.VERRE_SODACOLA_100CL = readString(dis);

					this.VERRE_EF_25CL = readString(dis);

					this.VERRE_EF_Unknown = readString(dis);

					this.VERRE_EFL_25CL = readString(dis);

					this.VERRE_EFL_Unknown = readString(dis);

					this.VERRE_CF_25CL = readString(dis);

					this.VERRE_CF_Unknown = readString(dis);

					this.VERRE_BOISSON_25CL = readString(dis);

					this.VERRE_BOISSON_Unknown = readString(dis);

					this.VERRE_IZEM_25CL = readString(dis);

					this.VERRE_BG_25CL = readString(dis);

					this.VERRE_BG_Unknown = readString(dis);

					this.VERRE_ICETHE_25CL = readString(dis);

					this.VERRE_ICETHE_Unknown = readString(dis);

					this.CANNETTE_SODA_33CL = readString(dis);

					this.CANNETTE_JUS_33CL = readString(dis);

					this.CANNETTE_ENERGY_25CL = readString(dis);

					this.CANNETTE_SODACOLA_25CL = readString(dis);

					this.CANNETTE_BG_25CL = readString(dis);

					this.Routes = readString(dis);

					this.Univers = readString(dis);

					this.Nb_visites = readString(dis);

					this.Nb_visites_achat = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// Integer

				writeInteger(this.ID, dos);

				// String

				writeString(this.WEEK, dos);

				// String

				writeString(this.DAY, dos);

				// String

				writeString(this.Date, dos);

				// String

				writeString(this.Circuit, dos);

				// String

				writeString(this.Van, dos);

				// String

				writeString(this.PET_EMN_33CL, dos);

				// String

				writeString(this.PET_EMN_33CL_B_S_Junior, dos);

				// String

				writeString(this.PET_EMN_50CL, dos);

				// String

				writeString(this.PET_EMN_50CL_B_S, dos);

				// String

				writeString(this.PET_EMN_150CL, dos);

				// String

				writeString(this.PET_EMG_33CL, dos);

				// String

				writeString(this.PET_EMG_50CL, dos);

				// String

				writeString(this.PET_EMG_100CL, dos);

				// String

				writeString(this.PET_SODA_PREMIUM_33CL, dos);

				// String

				writeString(this.PET_SODA_PREMIUM_100CL, dos);

				// String

				writeString(this.PET_SODA_PREMIUM_150CL, dos);

				// String

				writeString(this.PET_SODA_PREMIUM_200CL, dos);

				// String

				writeString(this.PET_PET_SODA_COLA_33CL, dos);

				// String

				writeString(this.PET_SODA_COLA_100CL, dos);

				// String

				writeString(this.PET_SODA_COLA_150CL, dos);

				// String

				writeString(this.PET_SODA_COLA_200CL, dos);

				// String

				writeString(this.PET_EF_P_tifruit_20CL, dos);

				// String

				writeString(this.PET_EF_33CL, dos);

				// String

				writeString(this.PET_EF_100CL, dos);

				// String

				writeString(this.PET_EF_150CL, dos);

				// String

				writeString(this.PET_EF_200CL, dos);

				// String

				writeString(this.PET_EF_Unknown, dos);

				// String

				writeString(this.PET_EFL_P_tifruit_20CL, dos);

				// String

				writeString(this.PET_EFL_20CL, dos);

				// String

				writeString(this.PET_EFL_33CL, dos);

				// String

				writeString(this.PET_EFL_100CL, dos);

				// String

				writeString(this.PET_EFL_150CL, dos);

				// String

				writeString(this.PET_SPORTDRINK_50CL, dos);

				// String

				writeString(this.PET_SPORTDRINK_Unknown, dos);

				// String

				writeString(this.PET_JUSPUR_20CL, dos);

				// String

				writeString(this.PET_JUSPUR_100CL, dos);

				// String

				writeString(this.PET_BEIZEM_33CL, dos);

				// String

				writeString(this.PET_BEIZEM_Unknown, dos);

				// String

				writeString(this.PET_EFG_25CL, dos);

				// String

				writeString(this.PET_EFG_33CL, dos);

				// String

				writeString(this.PET_EFG_100CL, dos);

				// String

				writeString(this.PET_EFG_150CL, dos);

				// String

				writeString(this.PET_ICETHE_25CL, dos);

				// String

				writeString(this.PET_ICETHE_100CL, dos);

				// String

				writeString(this.PET_ICETHE_150CL, dos);

				// String

				writeString(this.VERRE_EMN_25CL, dos);

				// String

				writeString(this.VERRE_EMN_50CL, dos);

				// String

				writeString(this.VERRE_EMN_100CL, dos);

				// String

				writeString(this.VERRE_EMG_25CL, dos);

				// String

				writeString(this.VERRE_EMG_50CL, dos);

				// String

				writeString(this.VERRE_EMG_100CL, dos);

				// String

				writeString(this.VERRE_SODA_25CL, dos);

				// String

				writeString(this.VERRE_SODA_100CL, dos);

				// String

				writeString(this.VERRE_SODACOLA_25CL, dos);

				// String

				writeString(this.VERRE_SODACOLA_100CL, dos);

				// String

				writeString(this.VERRE_EF_25CL, dos);

				// String

				writeString(this.VERRE_EF_Unknown, dos);

				// String

				writeString(this.VERRE_EFL_25CL, dos);

				// String

				writeString(this.VERRE_EFL_Unknown, dos);

				// String

				writeString(this.VERRE_CF_25CL, dos);

				// String

				writeString(this.VERRE_CF_Unknown, dos);

				// String

				writeString(this.VERRE_BOISSON_25CL, dos);

				// String

				writeString(this.VERRE_BOISSON_Unknown, dos);

				// String

				writeString(this.VERRE_IZEM_25CL, dos);

				// String

				writeString(this.VERRE_BG_25CL, dos);

				// String

				writeString(this.VERRE_BG_Unknown, dos);

				// String

				writeString(this.VERRE_ICETHE_25CL, dos);

				// String

				writeString(this.VERRE_ICETHE_Unknown, dos);

				// String

				writeString(this.CANNETTE_SODA_33CL, dos);

				// String

				writeString(this.CANNETTE_JUS_33CL, dos);

				// String

				writeString(this.CANNETTE_ENERGY_25CL, dos);

				// String

				writeString(this.CANNETTE_SODACOLA_25CL, dos);

				// String

				writeString(this.CANNETTE_BG_25CL, dos);

				// String

				writeString(this.Routes, dos);

				// String

				writeString(this.Univers, dos);

				// String

				writeString(this.Nb_visites, dos);

				// String

				writeString(this.Nb_visites_achat, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// Integer

				writeInteger(this.ID, dos);

				// String

				writeString(this.WEEK, dos);

				// String

				writeString(this.DAY, dos);

				// String

				writeString(this.Date, dos);

				// String

				writeString(this.Circuit, dos);

				// String

				writeString(this.Van, dos);

				// String

				writeString(this.PET_EMN_33CL, dos);

				// String

				writeString(this.PET_EMN_33CL_B_S_Junior, dos);

				// String

				writeString(this.PET_EMN_50CL, dos);

				// String

				writeString(this.PET_EMN_50CL_B_S, dos);

				// String

				writeString(this.PET_EMN_150CL, dos);

				// String

				writeString(this.PET_EMG_33CL, dos);

				// String

				writeString(this.PET_EMG_50CL, dos);

				// String

				writeString(this.PET_EMG_100CL, dos);

				// String

				writeString(this.PET_SODA_PREMIUM_33CL, dos);

				// String

				writeString(this.PET_SODA_PREMIUM_100CL, dos);

				// String

				writeString(this.PET_SODA_PREMIUM_150CL, dos);

				// String

				writeString(this.PET_SODA_PREMIUM_200CL, dos);

				// String

				writeString(this.PET_PET_SODA_COLA_33CL, dos);

				// String

				writeString(this.PET_SODA_COLA_100CL, dos);

				// String

				writeString(this.PET_SODA_COLA_150CL, dos);

				// String

				writeString(this.PET_SODA_COLA_200CL, dos);

				// String

				writeString(this.PET_EF_P_tifruit_20CL, dos);

				// String

				writeString(this.PET_EF_33CL, dos);

				// String

				writeString(this.PET_EF_100CL, dos);

				// String

				writeString(this.PET_EF_150CL, dos);

				// String

				writeString(this.PET_EF_200CL, dos);

				// String

				writeString(this.PET_EF_Unknown, dos);

				// String

				writeString(this.PET_EFL_P_tifruit_20CL, dos);

				// String

				writeString(this.PET_EFL_20CL, dos);

				// String

				writeString(this.PET_EFL_33CL, dos);

				// String

				writeString(this.PET_EFL_100CL, dos);

				// String

				writeString(this.PET_EFL_150CL, dos);

				// String

				writeString(this.PET_SPORTDRINK_50CL, dos);

				// String

				writeString(this.PET_SPORTDRINK_Unknown, dos);

				// String

				writeString(this.PET_JUSPUR_20CL, dos);

				// String

				writeString(this.PET_JUSPUR_100CL, dos);

				// String

				writeString(this.PET_BEIZEM_33CL, dos);

				// String

				writeString(this.PET_BEIZEM_Unknown, dos);

				// String

				writeString(this.PET_EFG_25CL, dos);

				// String

				writeString(this.PET_EFG_33CL, dos);

				// String

				writeString(this.PET_EFG_100CL, dos);

				// String

				writeString(this.PET_EFG_150CL, dos);

				// String

				writeString(this.PET_ICETHE_25CL, dos);

				// String

				writeString(this.PET_ICETHE_100CL, dos);

				// String

				writeString(this.PET_ICETHE_150CL, dos);

				// String

				writeString(this.VERRE_EMN_25CL, dos);

				// String

				writeString(this.VERRE_EMN_50CL, dos);

				// String

				writeString(this.VERRE_EMN_100CL, dos);

				// String

				writeString(this.VERRE_EMG_25CL, dos);

				// String

				writeString(this.VERRE_EMG_50CL, dos);

				// String

				writeString(this.VERRE_EMG_100CL, dos);

				// String

				writeString(this.VERRE_SODA_25CL, dos);

				// String

				writeString(this.VERRE_SODA_100CL, dos);

				// String

				writeString(this.VERRE_SODACOLA_25CL, dos);

				// String

				writeString(this.VERRE_SODACOLA_100CL, dos);

				// String

				writeString(this.VERRE_EF_25CL, dos);

				// String

				writeString(this.VERRE_EF_Unknown, dos);

				// String

				writeString(this.VERRE_EFL_25CL, dos);

				// String

				writeString(this.VERRE_EFL_Unknown, dos);

				// String

				writeString(this.VERRE_CF_25CL, dos);

				// String

				writeString(this.VERRE_CF_Unknown, dos);

				// String

				writeString(this.VERRE_BOISSON_25CL, dos);

				// String

				writeString(this.VERRE_BOISSON_Unknown, dos);

				// String

				writeString(this.VERRE_IZEM_25CL, dos);

				// String

				writeString(this.VERRE_BG_25CL, dos);

				// String

				writeString(this.VERRE_BG_Unknown, dos);

				// String

				writeString(this.VERRE_ICETHE_25CL, dos);

				// String

				writeString(this.VERRE_ICETHE_Unknown, dos);

				// String

				writeString(this.CANNETTE_SODA_33CL, dos);

				// String

				writeString(this.CANNETTE_JUS_33CL, dos);

				// String

				writeString(this.CANNETTE_ENERGY_25CL, dos);

				// String

				writeString(this.CANNETTE_SODACOLA_25CL, dos);

				// String

				writeString(this.CANNETTE_BG_25CL, dos);

				// String

				writeString(this.Routes, dos);

				// String

				writeString(this.Univers, dos);

				// String

				writeString(this.Nb_visites, dos);

				// String

				writeString(this.Nb_visites_achat, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("ID=" + String.valueOf(ID));
			sb.append(",WEEK=" + WEEK);
			sb.append(",DAY=" + DAY);
			sb.append(",Date=" + Date);
			sb.append(",Circuit=" + Circuit);
			sb.append(",Van=" + Van);
			sb.append(",PET_EMN_33CL=" + PET_EMN_33CL);
			sb.append(",PET_EMN_33CL_B_S_Junior=" + PET_EMN_33CL_B_S_Junior);
			sb.append(",PET_EMN_50CL=" + PET_EMN_50CL);
			sb.append(",PET_EMN_50CL_B_S=" + PET_EMN_50CL_B_S);
			sb.append(",PET_EMN_150CL=" + PET_EMN_150CL);
			sb.append(",PET_EMG_33CL=" + PET_EMG_33CL);
			sb.append(",PET_EMG_50CL=" + PET_EMG_50CL);
			sb.append(",PET_EMG_100CL=" + PET_EMG_100CL);
			sb.append(",PET_SODA_PREMIUM_33CL=" + PET_SODA_PREMIUM_33CL);
			sb.append(",PET_SODA_PREMIUM_100CL=" + PET_SODA_PREMIUM_100CL);
			sb.append(",PET_SODA_PREMIUM_150CL=" + PET_SODA_PREMIUM_150CL);
			sb.append(",PET_SODA_PREMIUM_200CL=" + PET_SODA_PREMIUM_200CL);
			sb.append(",PET_PET_SODA_COLA_33CL=" + PET_PET_SODA_COLA_33CL);
			sb.append(",PET_SODA_COLA_100CL=" + PET_SODA_COLA_100CL);
			sb.append(",PET_SODA_COLA_150CL=" + PET_SODA_COLA_150CL);
			sb.append(",PET_SODA_COLA_200CL=" + PET_SODA_COLA_200CL);
			sb.append(",PET_EF_P_tifruit_20CL=" + PET_EF_P_tifruit_20CL);
			sb.append(",PET_EF_33CL=" + PET_EF_33CL);
			sb.append(",PET_EF_100CL=" + PET_EF_100CL);
			sb.append(",PET_EF_150CL=" + PET_EF_150CL);
			sb.append(",PET_EF_200CL=" + PET_EF_200CL);
			sb.append(",PET_EF_Unknown=" + PET_EF_Unknown);
			sb.append(",PET_EFL_P_tifruit_20CL=" + PET_EFL_P_tifruit_20CL);
			sb.append(",PET_EFL_20CL=" + PET_EFL_20CL);
			sb.append(",PET_EFL_33CL=" + PET_EFL_33CL);
			sb.append(",PET_EFL_100CL=" + PET_EFL_100CL);
			sb.append(",PET_EFL_150CL=" + PET_EFL_150CL);
			sb.append(",PET_SPORTDRINK_50CL=" + PET_SPORTDRINK_50CL);
			sb.append(",PET_SPORTDRINK_Unknown=" + PET_SPORTDRINK_Unknown);
			sb.append(",PET_JUSPUR_20CL=" + PET_JUSPUR_20CL);
			sb.append(",PET_JUSPUR_100CL=" + PET_JUSPUR_100CL);
			sb.append(",PET_BEIZEM_33CL=" + PET_BEIZEM_33CL);
			sb.append(",PET_BEIZEM_Unknown=" + PET_BEIZEM_Unknown);
			sb.append(",PET_EFG_25CL=" + PET_EFG_25CL);
			sb.append(",PET_EFG_33CL=" + PET_EFG_33CL);
			sb.append(",PET_EFG_100CL=" + PET_EFG_100CL);
			sb.append(",PET_EFG_150CL=" + PET_EFG_150CL);
			sb.append(",PET_ICETHE_25CL=" + PET_ICETHE_25CL);
			sb.append(",PET_ICETHE_100CL=" + PET_ICETHE_100CL);
			sb.append(",PET_ICETHE_150CL=" + PET_ICETHE_150CL);
			sb.append(",VERRE_EMN_25CL=" + VERRE_EMN_25CL);
			sb.append(",VERRE_EMN_50CL=" + VERRE_EMN_50CL);
			sb.append(",VERRE_EMN_100CL=" + VERRE_EMN_100CL);
			sb.append(",VERRE_EMG_25CL=" + VERRE_EMG_25CL);
			sb.append(",VERRE_EMG_50CL=" + VERRE_EMG_50CL);
			sb.append(",VERRE_EMG_100CL=" + VERRE_EMG_100CL);
			sb.append(",VERRE_SODA_25CL=" + VERRE_SODA_25CL);
			sb.append(",VERRE_SODA_100CL=" + VERRE_SODA_100CL);
			sb.append(",VERRE_SODACOLA_25CL=" + VERRE_SODACOLA_25CL);
			sb.append(",VERRE_SODACOLA_100CL=" + VERRE_SODACOLA_100CL);
			sb.append(",VERRE_EF_25CL=" + VERRE_EF_25CL);
			sb.append(",VERRE_EF_Unknown=" + VERRE_EF_Unknown);
			sb.append(",VERRE_EFL_25CL=" + VERRE_EFL_25CL);
			sb.append(",VERRE_EFL_Unknown=" + VERRE_EFL_Unknown);
			sb.append(",VERRE_CF_25CL=" + VERRE_CF_25CL);
			sb.append(",VERRE_CF_Unknown=" + VERRE_CF_Unknown);
			sb.append(",VERRE_BOISSON_25CL=" + VERRE_BOISSON_25CL);
			sb.append(",VERRE_BOISSON_Unknown=" + VERRE_BOISSON_Unknown);
			sb.append(",VERRE_IZEM_25CL=" + VERRE_IZEM_25CL);
			sb.append(",VERRE_BG_25CL=" + VERRE_BG_25CL);
			sb.append(",VERRE_BG_Unknown=" + VERRE_BG_Unknown);
			sb.append(",VERRE_ICETHE_25CL=" + VERRE_ICETHE_25CL);
			sb.append(",VERRE_ICETHE_Unknown=" + VERRE_ICETHE_Unknown);
			sb.append(",CANNETTE_SODA_33CL=" + CANNETTE_SODA_33CL);
			sb.append(",CANNETTE_JUS_33CL=" + CANNETTE_JUS_33CL);
			sb.append(",CANNETTE_ENERGY_25CL=" + CANNETTE_ENERGY_25CL);
			sb.append(",CANNETTE_SODACOLA_25CL=" + CANNETTE_SODACOLA_25CL);
			sb.append(",CANNETTE_BG_25CL=" + CANNETTE_BG_25CL);
			sb.append(",Routes=" + Routes);
			sb.append(",Univers=" + Univers);
			sb.append(",Nb_visites=" + Nb_visites);
			sb.append(",Nb_visites_achat=" + Nb_visites_achat);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(OnRowsEndStructtSortRow_2 other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public static class row2Struct implements routines.system.IPersistableRow<row2Struct> {
		final static byte[] commonByteArrayLock_KEYRUS_ReadFile_V04_2 = new byte[0];
		static byte[] commonByteArray_KEYRUS_ReadFile_V04_2 = new byte[0];

		public Integer ID;

		public Integer getID() {
			return this.ID;
		}

		public String WEEK;

		public String getWEEK() {
			return this.WEEK;
		}

		public String DAY;

		public String getDAY() {
			return this.DAY;
		}

		public String Date;

		public String getDate() {
			return this.Date;
		}

		public String Circuit;

		public String getCircuit() {
			return this.Circuit;
		}

		public String Van;

		public String getVan() {
			return this.Van;
		}

		public String PET_EMN_33CL;

		public String getPET_EMN_33CL() {
			return this.PET_EMN_33CL;
		}

		public String PET_EMN_33CL_B_S_Junior;

		public String getPET_EMN_33CL_B_S_Junior() {
			return this.PET_EMN_33CL_B_S_Junior;
		}

		public String PET_EMN_50CL;

		public String getPET_EMN_50CL() {
			return this.PET_EMN_50CL;
		}

		public String PET_EMN_50CL_B_S;

		public String getPET_EMN_50CL_B_S() {
			return this.PET_EMN_50CL_B_S;
		}

		public String PET_EMN_150CL;

		public String getPET_EMN_150CL() {
			return this.PET_EMN_150CL;
		}

		public String PET_EMG_33CL;

		public String getPET_EMG_33CL() {
			return this.PET_EMG_33CL;
		}

		public String PET_EMG_50CL;

		public String getPET_EMG_50CL() {
			return this.PET_EMG_50CL;
		}

		public String PET_EMG_100CL;

		public String getPET_EMG_100CL() {
			return this.PET_EMG_100CL;
		}

		public String PET_SODA_PREMIUM_33CL;

		public String getPET_SODA_PREMIUM_33CL() {
			return this.PET_SODA_PREMIUM_33CL;
		}

		public String PET_SODA_PREMIUM_100CL;

		public String getPET_SODA_PREMIUM_100CL() {
			return this.PET_SODA_PREMIUM_100CL;
		}

		public String PET_SODA_PREMIUM_150CL;

		public String getPET_SODA_PREMIUM_150CL() {
			return this.PET_SODA_PREMIUM_150CL;
		}

		public String PET_SODA_PREMIUM_200CL;

		public String getPET_SODA_PREMIUM_200CL() {
			return this.PET_SODA_PREMIUM_200CL;
		}

		public String PET_PET_SODA_COLA_33CL;

		public String getPET_PET_SODA_COLA_33CL() {
			return this.PET_PET_SODA_COLA_33CL;
		}

		public String PET_SODA_COLA_100CL;

		public String getPET_SODA_COLA_100CL() {
			return this.PET_SODA_COLA_100CL;
		}

		public String PET_SODA_COLA_150CL;

		public String getPET_SODA_COLA_150CL() {
			return this.PET_SODA_COLA_150CL;
		}

		public String PET_SODA_COLA_200CL;

		public String getPET_SODA_COLA_200CL() {
			return this.PET_SODA_COLA_200CL;
		}

		public String PET_EF_P_tifruit_20CL;

		public String getPET_EF_P_tifruit_20CL() {
			return this.PET_EF_P_tifruit_20CL;
		}

		public String PET_EF_33CL;

		public String getPET_EF_33CL() {
			return this.PET_EF_33CL;
		}

		public String PET_EF_100CL;

		public String getPET_EF_100CL() {
			return this.PET_EF_100CL;
		}

		public String PET_EF_150CL;

		public String getPET_EF_150CL() {
			return this.PET_EF_150CL;
		}

		public String PET_EF_200CL;

		public String getPET_EF_200CL() {
			return this.PET_EF_200CL;
		}

		public String PET_EF_Unknown;

		public String getPET_EF_Unknown() {
			return this.PET_EF_Unknown;
		}

		public String PET_EFL_P_tifruit_20CL;

		public String getPET_EFL_P_tifruit_20CL() {
			return this.PET_EFL_P_tifruit_20CL;
		}

		public String PET_EFL_20CL;

		public String getPET_EFL_20CL() {
			return this.PET_EFL_20CL;
		}

		public String PET_EFL_33CL;

		public String getPET_EFL_33CL() {
			return this.PET_EFL_33CL;
		}

		public String PET_EFL_100CL;

		public String getPET_EFL_100CL() {
			return this.PET_EFL_100CL;
		}

		public String PET_EFL_150CL;

		public String getPET_EFL_150CL() {
			return this.PET_EFL_150CL;
		}

		public String PET_SPORTDRINK_50CL;

		public String getPET_SPORTDRINK_50CL() {
			return this.PET_SPORTDRINK_50CL;
		}

		public String PET_SPORTDRINK_Unknown;

		public String getPET_SPORTDRINK_Unknown() {
			return this.PET_SPORTDRINK_Unknown;
		}

		public String PET_JUSPUR_20CL;

		public String getPET_JUSPUR_20CL() {
			return this.PET_JUSPUR_20CL;
		}

		public String PET_JUSPUR_100CL;

		public String getPET_JUSPUR_100CL() {
			return this.PET_JUSPUR_100CL;
		}

		public String PET_BEIZEM_33CL;

		public String getPET_BEIZEM_33CL() {
			return this.PET_BEIZEM_33CL;
		}

		public String PET_BEIZEM_Unknown;

		public String getPET_BEIZEM_Unknown() {
			return this.PET_BEIZEM_Unknown;
		}

		public String PET_EFG_25CL;

		public String getPET_EFG_25CL() {
			return this.PET_EFG_25CL;
		}

		public String PET_EFG_33CL;

		public String getPET_EFG_33CL() {
			return this.PET_EFG_33CL;
		}

		public String PET_EFG_100CL;

		public String getPET_EFG_100CL() {
			return this.PET_EFG_100CL;
		}

		public String PET_EFG_150CL;

		public String getPET_EFG_150CL() {
			return this.PET_EFG_150CL;
		}

		public String PET_ICETHE_25CL;

		public String getPET_ICETHE_25CL() {
			return this.PET_ICETHE_25CL;
		}

		public String PET_ICETHE_100CL;

		public String getPET_ICETHE_100CL() {
			return this.PET_ICETHE_100CL;
		}

		public String PET_ICETHE_150CL;

		public String getPET_ICETHE_150CL() {
			return this.PET_ICETHE_150CL;
		}

		public String VERRE_EMN_25CL;

		public String getVERRE_EMN_25CL() {
			return this.VERRE_EMN_25CL;
		}

		public String VERRE_EMN_50CL;

		public String getVERRE_EMN_50CL() {
			return this.VERRE_EMN_50CL;
		}

		public String VERRE_EMN_100CL;

		public String getVERRE_EMN_100CL() {
			return this.VERRE_EMN_100CL;
		}

		public String VERRE_EMG_25CL;

		public String getVERRE_EMG_25CL() {
			return this.VERRE_EMG_25CL;
		}

		public String VERRE_EMG_50CL;

		public String getVERRE_EMG_50CL() {
			return this.VERRE_EMG_50CL;
		}

		public String VERRE_EMG_100CL;

		public String getVERRE_EMG_100CL() {
			return this.VERRE_EMG_100CL;
		}

		public String VERRE_SODA_25CL;

		public String getVERRE_SODA_25CL() {
			return this.VERRE_SODA_25CL;
		}

		public String VERRE_SODA_100CL;

		public String getVERRE_SODA_100CL() {
			return this.VERRE_SODA_100CL;
		}

		public String VERRE_SODACOLA_25CL;

		public String getVERRE_SODACOLA_25CL() {
			return this.VERRE_SODACOLA_25CL;
		}

		public String VERRE_SODACOLA_100CL;

		public String getVERRE_SODACOLA_100CL() {
			return this.VERRE_SODACOLA_100CL;
		}

		public String VERRE_EF_25CL;

		public String getVERRE_EF_25CL() {
			return this.VERRE_EF_25CL;
		}

		public String VERRE_EF_Unknown;

		public String getVERRE_EF_Unknown() {
			return this.VERRE_EF_Unknown;
		}

		public String VERRE_EFL_25CL;

		public String getVERRE_EFL_25CL() {
			return this.VERRE_EFL_25CL;
		}

		public String VERRE_EFL_Unknown;

		public String getVERRE_EFL_Unknown() {
			return this.VERRE_EFL_Unknown;
		}

		public String VERRE_CF_25CL;

		public String getVERRE_CF_25CL() {
			return this.VERRE_CF_25CL;
		}

		public String VERRE_CF_Unknown;

		public String getVERRE_CF_Unknown() {
			return this.VERRE_CF_Unknown;
		}

		public String VERRE_BOISSON_25CL;

		public String getVERRE_BOISSON_25CL() {
			return this.VERRE_BOISSON_25CL;
		}

		public String VERRE_BOISSON_Unknown;

		public String getVERRE_BOISSON_Unknown() {
			return this.VERRE_BOISSON_Unknown;
		}

		public String VERRE_IZEM_25CL;

		public String getVERRE_IZEM_25CL() {
			return this.VERRE_IZEM_25CL;
		}

		public String VERRE_BG_25CL;

		public String getVERRE_BG_25CL() {
			return this.VERRE_BG_25CL;
		}

		public String VERRE_BG_Unknown;

		public String getVERRE_BG_Unknown() {
			return this.VERRE_BG_Unknown;
		}

		public String VERRE_ICETHE_25CL;

		public String getVERRE_ICETHE_25CL() {
			return this.VERRE_ICETHE_25CL;
		}

		public String VERRE_ICETHE_Unknown;

		public String getVERRE_ICETHE_Unknown() {
			return this.VERRE_ICETHE_Unknown;
		}

		public String CANNETTE_SODA_33CL;

		public String getCANNETTE_SODA_33CL() {
			return this.CANNETTE_SODA_33CL;
		}

		public String CANNETTE_JUS_33CL;

		public String getCANNETTE_JUS_33CL() {
			return this.CANNETTE_JUS_33CL;
		}

		public String CANNETTE_ENERGY_25CL;

		public String getCANNETTE_ENERGY_25CL() {
			return this.CANNETTE_ENERGY_25CL;
		}

		public String CANNETTE_SODACOLA_25CL;

		public String getCANNETTE_SODACOLA_25CL() {
			return this.CANNETTE_SODACOLA_25CL;
		}

		public String CANNETTE_BG_25CL;

		public String getCANNETTE_BG_25CL() {
			return this.CANNETTE_BG_25CL;
		}

		public String Routes;

		public String getRoutes() {
			return this.Routes;
		}

		public String Univers;

		public String getUnivers() {
			return this.Univers;
		}

		public String Nb_visites;

		public String getNb_visites() {
			return this.Nb_visites;
		}

		public String Nb_visites_achat;

		public String getNb_visites_achat() {
			return this.Nb_visites_achat;
		}

		private Integer readInteger(ObjectInputStream dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException {
			if (intNum == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeInt(intNum);
			}
		}

		private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (intNum == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeInt(intNum);
			}
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_KEYRUS_ReadFile_V04_2.length) {
					if (length < 1024 && commonByteArray_KEYRUS_ReadFile_V04_2.length == 0) {
						commonByteArray_KEYRUS_ReadFile_V04_2 = new byte[1024];
					} else {
						commonByteArray_KEYRUS_ReadFile_V04_2 = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_KEYRUS_ReadFile_V04_2, 0, length);
				strReturn = new String(commonByteArray_KEYRUS_ReadFile_V04_2, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_KEYRUS_ReadFile_V04_2.length) {
					if (length < 1024 && commonByteArray_KEYRUS_ReadFile_V04_2.length == 0) {
						commonByteArray_KEYRUS_ReadFile_V04_2 = new byte[1024];
					} else {
						commonByteArray_KEYRUS_ReadFile_V04_2 = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_KEYRUS_ReadFile_V04_2, 0, length);
				strReturn = new String(commonByteArray_KEYRUS_ReadFile_V04_2, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_KEYRUS_ReadFile_V04_2) {

				try {

					int length = 0;

					this.ID = readInteger(dis);

					this.WEEK = readString(dis);

					this.DAY = readString(dis);

					this.Date = readString(dis);

					this.Circuit = readString(dis);

					this.Van = readString(dis);

					this.PET_EMN_33CL = readString(dis);

					this.PET_EMN_33CL_B_S_Junior = readString(dis);

					this.PET_EMN_50CL = readString(dis);

					this.PET_EMN_50CL_B_S = readString(dis);

					this.PET_EMN_150CL = readString(dis);

					this.PET_EMG_33CL = readString(dis);

					this.PET_EMG_50CL = readString(dis);

					this.PET_EMG_100CL = readString(dis);

					this.PET_SODA_PREMIUM_33CL = readString(dis);

					this.PET_SODA_PREMIUM_100CL = readString(dis);

					this.PET_SODA_PREMIUM_150CL = readString(dis);

					this.PET_SODA_PREMIUM_200CL = readString(dis);

					this.PET_PET_SODA_COLA_33CL = readString(dis);

					this.PET_SODA_COLA_100CL = readString(dis);

					this.PET_SODA_COLA_150CL = readString(dis);

					this.PET_SODA_COLA_200CL = readString(dis);

					this.PET_EF_P_tifruit_20CL = readString(dis);

					this.PET_EF_33CL = readString(dis);

					this.PET_EF_100CL = readString(dis);

					this.PET_EF_150CL = readString(dis);

					this.PET_EF_200CL = readString(dis);

					this.PET_EF_Unknown = readString(dis);

					this.PET_EFL_P_tifruit_20CL = readString(dis);

					this.PET_EFL_20CL = readString(dis);

					this.PET_EFL_33CL = readString(dis);

					this.PET_EFL_100CL = readString(dis);

					this.PET_EFL_150CL = readString(dis);

					this.PET_SPORTDRINK_50CL = readString(dis);

					this.PET_SPORTDRINK_Unknown = readString(dis);

					this.PET_JUSPUR_20CL = readString(dis);

					this.PET_JUSPUR_100CL = readString(dis);

					this.PET_BEIZEM_33CL = readString(dis);

					this.PET_BEIZEM_Unknown = readString(dis);

					this.PET_EFG_25CL = readString(dis);

					this.PET_EFG_33CL = readString(dis);

					this.PET_EFG_100CL = readString(dis);

					this.PET_EFG_150CL = readString(dis);

					this.PET_ICETHE_25CL = readString(dis);

					this.PET_ICETHE_100CL = readString(dis);

					this.PET_ICETHE_150CL = readString(dis);

					this.VERRE_EMN_25CL = readString(dis);

					this.VERRE_EMN_50CL = readString(dis);

					this.VERRE_EMN_100CL = readString(dis);

					this.VERRE_EMG_25CL = readString(dis);

					this.VERRE_EMG_50CL = readString(dis);

					this.VERRE_EMG_100CL = readString(dis);

					this.VERRE_SODA_25CL = readString(dis);

					this.VERRE_SODA_100CL = readString(dis);

					this.VERRE_SODACOLA_25CL = readString(dis);

					this.VERRE_SODACOLA_100CL = readString(dis);

					this.VERRE_EF_25CL = readString(dis);

					this.VERRE_EF_Unknown = readString(dis);

					this.VERRE_EFL_25CL = readString(dis);

					this.VERRE_EFL_Unknown = readString(dis);

					this.VERRE_CF_25CL = readString(dis);

					this.VERRE_CF_Unknown = readString(dis);

					this.VERRE_BOISSON_25CL = readString(dis);

					this.VERRE_BOISSON_Unknown = readString(dis);

					this.VERRE_IZEM_25CL = readString(dis);

					this.VERRE_BG_25CL = readString(dis);

					this.VERRE_BG_Unknown = readString(dis);

					this.VERRE_ICETHE_25CL = readString(dis);

					this.VERRE_ICETHE_Unknown = readString(dis);

					this.CANNETTE_SODA_33CL = readString(dis);

					this.CANNETTE_JUS_33CL = readString(dis);

					this.CANNETTE_ENERGY_25CL = readString(dis);

					this.CANNETTE_SODACOLA_25CL = readString(dis);

					this.CANNETTE_BG_25CL = readString(dis);

					this.Routes = readString(dis);

					this.Univers = readString(dis);

					this.Nb_visites = readString(dis);

					this.Nb_visites_achat = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_KEYRUS_ReadFile_V04_2) {

				try {

					int length = 0;

					this.ID = readInteger(dis);

					this.WEEK = readString(dis);

					this.DAY = readString(dis);

					this.Date = readString(dis);

					this.Circuit = readString(dis);

					this.Van = readString(dis);

					this.PET_EMN_33CL = readString(dis);

					this.PET_EMN_33CL_B_S_Junior = readString(dis);

					this.PET_EMN_50CL = readString(dis);

					this.PET_EMN_50CL_B_S = readString(dis);

					this.PET_EMN_150CL = readString(dis);

					this.PET_EMG_33CL = readString(dis);

					this.PET_EMG_50CL = readString(dis);

					this.PET_EMG_100CL = readString(dis);

					this.PET_SODA_PREMIUM_33CL = readString(dis);

					this.PET_SODA_PREMIUM_100CL = readString(dis);

					this.PET_SODA_PREMIUM_150CL = readString(dis);

					this.PET_SODA_PREMIUM_200CL = readString(dis);

					this.PET_PET_SODA_COLA_33CL = readString(dis);

					this.PET_SODA_COLA_100CL = readString(dis);

					this.PET_SODA_COLA_150CL = readString(dis);

					this.PET_SODA_COLA_200CL = readString(dis);

					this.PET_EF_P_tifruit_20CL = readString(dis);

					this.PET_EF_33CL = readString(dis);

					this.PET_EF_100CL = readString(dis);

					this.PET_EF_150CL = readString(dis);

					this.PET_EF_200CL = readString(dis);

					this.PET_EF_Unknown = readString(dis);

					this.PET_EFL_P_tifruit_20CL = readString(dis);

					this.PET_EFL_20CL = readString(dis);

					this.PET_EFL_33CL = readString(dis);

					this.PET_EFL_100CL = readString(dis);

					this.PET_EFL_150CL = readString(dis);

					this.PET_SPORTDRINK_50CL = readString(dis);

					this.PET_SPORTDRINK_Unknown = readString(dis);

					this.PET_JUSPUR_20CL = readString(dis);

					this.PET_JUSPUR_100CL = readString(dis);

					this.PET_BEIZEM_33CL = readString(dis);

					this.PET_BEIZEM_Unknown = readString(dis);

					this.PET_EFG_25CL = readString(dis);

					this.PET_EFG_33CL = readString(dis);

					this.PET_EFG_100CL = readString(dis);

					this.PET_EFG_150CL = readString(dis);

					this.PET_ICETHE_25CL = readString(dis);

					this.PET_ICETHE_100CL = readString(dis);

					this.PET_ICETHE_150CL = readString(dis);

					this.VERRE_EMN_25CL = readString(dis);

					this.VERRE_EMN_50CL = readString(dis);

					this.VERRE_EMN_100CL = readString(dis);

					this.VERRE_EMG_25CL = readString(dis);

					this.VERRE_EMG_50CL = readString(dis);

					this.VERRE_EMG_100CL = readString(dis);

					this.VERRE_SODA_25CL = readString(dis);

					this.VERRE_SODA_100CL = readString(dis);

					this.VERRE_SODACOLA_25CL = readString(dis);

					this.VERRE_SODACOLA_100CL = readString(dis);

					this.VERRE_EF_25CL = readString(dis);

					this.VERRE_EF_Unknown = readString(dis);

					this.VERRE_EFL_25CL = readString(dis);

					this.VERRE_EFL_Unknown = readString(dis);

					this.VERRE_CF_25CL = readString(dis);

					this.VERRE_CF_Unknown = readString(dis);

					this.VERRE_BOISSON_25CL = readString(dis);

					this.VERRE_BOISSON_Unknown = readString(dis);

					this.VERRE_IZEM_25CL = readString(dis);

					this.VERRE_BG_25CL = readString(dis);

					this.VERRE_BG_Unknown = readString(dis);

					this.VERRE_ICETHE_25CL = readString(dis);

					this.VERRE_ICETHE_Unknown = readString(dis);

					this.CANNETTE_SODA_33CL = readString(dis);

					this.CANNETTE_JUS_33CL = readString(dis);

					this.CANNETTE_ENERGY_25CL = readString(dis);

					this.CANNETTE_SODACOLA_25CL = readString(dis);

					this.CANNETTE_BG_25CL = readString(dis);

					this.Routes = readString(dis);

					this.Univers = readString(dis);

					this.Nb_visites = readString(dis);

					this.Nb_visites_achat = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// Integer

				writeInteger(this.ID, dos);

				// String

				writeString(this.WEEK, dos);

				// String

				writeString(this.DAY, dos);

				// String

				writeString(this.Date, dos);

				// String

				writeString(this.Circuit, dos);

				// String

				writeString(this.Van, dos);

				// String

				writeString(this.PET_EMN_33CL, dos);

				// String

				writeString(this.PET_EMN_33CL_B_S_Junior, dos);

				// String

				writeString(this.PET_EMN_50CL, dos);

				// String

				writeString(this.PET_EMN_50CL_B_S, dos);

				// String

				writeString(this.PET_EMN_150CL, dos);

				// String

				writeString(this.PET_EMG_33CL, dos);

				// String

				writeString(this.PET_EMG_50CL, dos);

				// String

				writeString(this.PET_EMG_100CL, dos);

				// String

				writeString(this.PET_SODA_PREMIUM_33CL, dos);

				// String

				writeString(this.PET_SODA_PREMIUM_100CL, dos);

				// String

				writeString(this.PET_SODA_PREMIUM_150CL, dos);

				// String

				writeString(this.PET_SODA_PREMIUM_200CL, dos);

				// String

				writeString(this.PET_PET_SODA_COLA_33CL, dos);

				// String

				writeString(this.PET_SODA_COLA_100CL, dos);

				// String

				writeString(this.PET_SODA_COLA_150CL, dos);

				// String

				writeString(this.PET_SODA_COLA_200CL, dos);

				// String

				writeString(this.PET_EF_P_tifruit_20CL, dos);

				// String

				writeString(this.PET_EF_33CL, dos);

				// String

				writeString(this.PET_EF_100CL, dos);

				// String

				writeString(this.PET_EF_150CL, dos);

				// String

				writeString(this.PET_EF_200CL, dos);

				// String

				writeString(this.PET_EF_Unknown, dos);

				// String

				writeString(this.PET_EFL_P_tifruit_20CL, dos);

				// String

				writeString(this.PET_EFL_20CL, dos);

				// String

				writeString(this.PET_EFL_33CL, dos);

				// String

				writeString(this.PET_EFL_100CL, dos);

				// String

				writeString(this.PET_EFL_150CL, dos);

				// String

				writeString(this.PET_SPORTDRINK_50CL, dos);

				// String

				writeString(this.PET_SPORTDRINK_Unknown, dos);

				// String

				writeString(this.PET_JUSPUR_20CL, dos);

				// String

				writeString(this.PET_JUSPUR_100CL, dos);

				// String

				writeString(this.PET_BEIZEM_33CL, dos);

				// String

				writeString(this.PET_BEIZEM_Unknown, dos);

				// String

				writeString(this.PET_EFG_25CL, dos);

				// String

				writeString(this.PET_EFG_33CL, dos);

				// String

				writeString(this.PET_EFG_100CL, dos);

				// String

				writeString(this.PET_EFG_150CL, dos);

				// String

				writeString(this.PET_ICETHE_25CL, dos);

				// String

				writeString(this.PET_ICETHE_100CL, dos);

				// String

				writeString(this.PET_ICETHE_150CL, dos);

				// String

				writeString(this.VERRE_EMN_25CL, dos);

				// String

				writeString(this.VERRE_EMN_50CL, dos);

				// String

				writeString(this.VERRE_EMN_100CL, dos);

				// String

				writeString(this.VERRE_EMG_25CL, dos);

				// String

				writeString(this.VERRE_EMG_50CL, dos);

				// String

				writeString(this.VERRE_EMG_100CL, dos);

				// String

				writeString(this.VERRE_SODA_25CL, dos);

				// String

				writeString(this.VERRE_SODA_100CL, dos);

				// String

				writeString(this.VERRE_SODACOLA_25CL, dos);

				// String

				writeString(this.VERRE_SODACOLA_100CL, dos);

				// String

				writeString(this.VERRE_EF_25CL, dos);

				// String

				writeString(this.VERRE_EF_Unknown, dos);

				// String

				writeString(this.VERRE_EFL_25CL, dos);

				// String

				writeString(this.VERRE_EFL_Unknown, dos);

				// String

				writeString(this.VERRE_CF_25CL, dos);

				// String

				writeString(this.VERRE_CF_Unknown, dos);

				// String

				writeString(this.VERRE_BOISSON_25CL, dos);

				// String

				writeString(this.VERRE_BOISSON_Unknown, dos);

				// String

				writeString(this.VERRE_IZEM_25CL, dos);

				// String

				writeString(this.VERRE_BG_25CL, dos);

				// String

				writeString(this.VERRE_BG_Unknown, dos);

				// String

				writeString(this.VERRE_ICETHE_25CL, dos);

				// String

				writeString(this.VERRE_ICETHE_Unknown, dos);

				// String

				writeString(this.CANNETTE_SODA_33CL, dos);

				// String

				writeString(this.CANNETTE_JUS_33CL, dos);

				// String

				writeString(this.CANNETTE_ENERGY_25CL, dos);

				// String

				writeString(this.CANNETTE_SODACOLA_25CL, dos);

				// String

				writeString(this.CANNETTE_BG_25CL, dos);

				// String

				writeString(this.Routes, dos);

				// String

				writeString(this.Univers, dos);

				// String

				writeString(this.Nb_visites, dos);

				// String

				writeString(this.Nb_visites_achat, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// Integer

				writeInteger(this.ID, dos);

				// String

				writeString(this.WEEK, dos);

				// String

				writeString(this.DAY, dos);

				// String

				writeString(this.Date, dos);

				// String

				writeString(this.Circuit, dos);

				// String

				writeString(this.Van, dos);

				// String

				writeString(this.PET_EMN_33CL, dos);

				// String

				writeString(this.PET_EMN_33CL_B_S_Junior, dos);

				// String

				writeString(this.PET_EMN_50CL, dos);

				// String

				writeString(this.PET_EMN_50CL_B_S, dos);

				// String

				writeString(this.PET_EMN_150CL, dos);

				// String

				writeString(this.PET_EMG_33CL, dos);

				// String

				writeString(this.PET_EMG_50CL, dos);

				// String

				writeString(this.PET_EMG_100CL, dos);

				// String

				writeString(this.PET_SODA_PREMIUM_33CL, dos);

				// String

				writeString(this.PET_SODA_PREMIUM_100CL, dos);

				// String

				writeString(this.PET_SODA_PREMIUM_150CL, dos);

				// String

				writeString(this.PET_SODA_PREMIUM_200CL, dos);

				// String

				writeString(this.PET_PET_SODA_COLA_33CL, dos);

				// String

				writeString(this.PET_SODA_COLA_100CL, dos);

				// String

				writeString(this.PET_SODA_COLA_150CL, dos);

				// String

				writeString(this.PET_SODA_COLA_200CL, dos);

				// String

				writeString(this.PET_EF_P_tifruit_20CL, dos);

				// String

				writeString(this.PET_EF_33CL, dos);

				// String

				writeString(this.PET_EF_100CL, dos);

				// String

				writeString(this.PET_EF_150CL, dos);

				// String

				writeString(this.PET_EF_200CL, dos);

				// String

				writeString(this.PET_EF_Unknown, dos);

				// String

				writeString(this.PET_EFL_P_tifruit_20CL, dos);

				// String

				writeString(this.PET_EFL_20CL, dos);

				// String

				writeString(this.PET_EFL_33CL, dos);

				// String

				writeString(this.PET_EFL_100CL, dos);

				// String

				writeString(this.PET_EFL_150CL, dos);

				// String

				writeString(this.PET_SPORTDRINK_50CL, dos);

				// String

				writeString(this.PET_SPORTDRINK_Unknown, dos);

				// String

				writeString(this.PET_JUSPUR_20CL, dos);

				// String

				writeString(this.PET_JUSPUR_100CL, dos);

				// String

				writeString(this.PET_BEIZEM_33CL, dos);

				// String

				writeString(this.PET_BEIZEM_Unknown, dos);

				// String

				writeString(this.PET_EFG_25CL, dos);

				// String

				writeString(this.PET_EFG_33CL, dos);

				// String

				writeString(this.PET_EFG_100CL, dos);

				// String

				writeString(this.PET_EFG_150CL, dos);

				// String

				writeString(this.PET_ICETHE_25CL, dos);

				// String

				writeString(this.PET_ICETHE_100CL, dos);

				// String

				writeString(this.PET_ICETHE_150CL, dos);

				// String

				writeString(this.VERRE_EMN_25CL, dos);

				// String

				writeString(this.VERRE_EMN_50CL, dos);

				// String

				writeString(this.VERRE_EMN_100CL, dos);

				// String

				writeString(this.VERRE_EMG_25CL, dos);

				// String

				writeString(this.VERRE_EMG_50CL, dos);

				// String

				writeString(this.VERRE_EMG_100CL, dos);

				// String

				writeString(this.VERRE_SODA_25CL, dos);

				// String

				writeString(this.VERRE_SODA_100CL, dos);

				// String

				writeString(this.VERRE_SODACOLA_25CL, dos);

				// String

				writeString(this.VERRE_SODACOLA_100CL, dos);

				// String

				writeString(this.VERRE_EF_25CL, dos);

				// String

				writeString(this.VERRE_EF_Unknown, dos);

				// String

				writeString(this.VERRE_EFL_25CL, dos);

				// String

				writeString(this.VERRE_EFL_Unknown, dos);

				// String

				writeString(this.VERRE_CF_25CL, dos);

				// String

				writeString(this.VERRE_CF_Unknown, dos);

				// String

				writeString(this.VERRE_BOISSON_25CL, dos);

				// String

				writeString(this.VERRE_BOISSON_Unknown, dos);

				// String

				writeString(this.VERRE_IZEM_25CL, dos);

				// String

				writeString(this.VERRE_BG_25CL, dos);

				// String

				writeString(this.VERRE_BG_Unknown, dos);

				// String

				writeString(this.VERRE_ICETHE_25CL, dos);

				// String

				writeString(this.VERRE_ICETHE_Unknown, dos);

				// String

				writeString(this.CANNETTE_SODA_33CL, dos);

				// String

				writeString(this.CANNETTE_JUS_33CL, dos);

				// String

				writeString(this.CANNETTE_ENERGY_25CL, dos);

				// String

				writeString(this.CANNETTE_SODACOLA_25CL, dos);

				// String

				writeString(this.CANNETTE_BG_25CL, dos);

				// String

				writeString(this.Routes, dos);

				// String

				writeString(this.Univers, dos);

				// String

				writeString(this.Nb_visites, dos);

				// String

				writeString(this.Nb_visites_achat, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("ID=" + String.valueOf(ID));
			sb.append(",WEEK=" + WEEK);
			sb.append(",DAY=" + DAY);
			sb.append(",Date=" + Date);
			sb.append(",Circuit=" + Circuit);
			sb.append(",Van=" + Van);
			sb.append(",PET_EMN_33CL=" + PET_EMN_33CL);
			sb.append(",PET_EMN_33CL_B_S_Junior=" + PET_EMN_33CL_B_S_Junior);
			sb.append(",PET_EMN_50CL=" + PET_EMN_50CL);
			sb.append(",PET_EMN_50CL_B_S=" + PET_EMN_50CL_B_S);
			sb.append(",PET_EMN_150CL=" + PET_EMN_150CL);
			sb.append(",PET_EMG_33CL=" + PET_EMG_33CL);
			sb.append(",PET_EMG_50CL=" + PET_EMG_50CL);
			sb.append(",PET_EMG_100CL=" + PET_EMG_100CL);
			sb.append(",PET_SODA_PREMIUM_33CL=" + PET_SODA_PREMIUM_33CL);
			sb.append(",PET_SODA_PREMIUM_100CL=" + PET_SODA_PREMIUM_100CL);
			sb.append(",PET_SODA_PREMIUM_150CL=" + PET_SODA_PREMIUM_150CL);
			sb.append(",PET_SODA_PREMIUM_200CL=" + PET_SODA_PREMIUM_200CL);
			sb.append(",PET_PET_SODA_COLA_33CL=" + PET_PET_SODA_COLA_33CL);
			sb.append(",PET_SODA_COLA_100CL=" + PET_SODA_COLA_100CL);
			sb.append(",PET_SODA_COLA_150CL=" + PET_SODA_COLA_150CL);
			sb.append(",PET_SODA_COLA_200CL=" + PET_SODA_COLA_200CL);
			sb.append(",PET_EF_P_tifruit_20CL=" + PET_EF_P_tifruit_20CL);
			sb.append(",PET_EF_33CL=" + PET_EF_33CL);
			sb.append(",PET_EF_100CL=" + PET_EF_100CL);
			sb.append(",PET_EF_150CL=" + PET_EF_150CL);
			sb.append(",PET_EF_200CL=" + PET_EF_200CL);
			sb.append(",PET_EF_Unknown=" + PET_EF_Unknown);
			sb.append(",PET_EFL_P_tifruit_20CL=" + PET_EFL_P_tifruit_20CL);
			sb.append(",PET_EFL_20CL=" + PET_EFL_20CL);
			sb.append(",PET_EFL_33CL=" + PET_EFL_33CL);
			sb.append(",PET_EFL_100CL=" + PET_EFL_100CL);
			sb.append(",PET_EFL_150CL=" + PET_EFL_150CL);
			sb.append(",PET_SPORTDRINK_50CL=" + PET_SPORTDRINK_50CL);
			sb.append(",PET_SPORTDRINK_Unknown=" + PET_SPORTDRINK_Unknown);
			sb.append(",PET_JUSPUR_20CL=" + PET_JUSPUR_20CL);
			sb.append(",PET_JUSPUR_100CL=" + PET_JUSPUR_100CL);
			sb.append(",PET_BEIZEM_33CL=" + PET_BEIZEM_33CL);
			sb.append(",PET_BEIZEM_Unknown=" + PET_BEIZEM_Unknown);
			sb.append(",PET_EFG_25CL=" + PET_EFG_25CL);
			sb.append(",PET_EFG_33CL=" + PET_EFG_33CL);
			sb.append(",PET_EFG_100CL=" + PET_EFG_100CL);
			sb.append(",PET_EFG_150CL=" + PET_EFG_150CL);
			sb.append(",PET_ICETHE_25CL=" + PET_ICETHE_25CL);
			sb.append(",PET_ICETHE_100CL=" + PET_ICETHE_100CL);
			sb.append(",PET_ICETHE_150CL=" + PET_ICETHE_150CL);
			sb.append(",VERRE_EMN_25CL=" + VERRE_EMN_25CL);
			sb.append(",VERRE_EMN_50CL=" + VERRE_EMN_50CL);
			sb.append(",VERRE_EMN_100CL=" + VERRE_EMN_100CL);
			sb.append(",VERRE_EMG_25CL=" + VERRE_EMG_25CL);
			sb.append(",VERRE_EMG_50CL=" + VERRE_EMG_50CL);
			sb.append(",VERRE_EMG_100CL=" + VERRE_EMG_100CL);
			sb.append(",VERRE_SODA_25CL=" + VERRE_SODA_25CL);
			sb.append(",VERRE_SODA_100CL=" + VERRE_SODA_100CL);
			sb.append(",VERRE_SODACOLA_25CL=" + VERRE_SODACOLA_25CL);
			sb.append(",VERRE_SODACOLA_100CL=" + VERRE_SODACOLA_100CL);
			sb.append(",VERRE_EF_25CL=" + VERRE_EF_25CL);
			sb.append(",VERRE_EF_Unknown=" + VERRE_EF_Unknown);
			sb.append(",VERRE_EFL_25CL=" + VERRE_EFL_25CL);
			sb.append(",VERRE_EFL_Unknown=" + VERRE_EFL_Unknown);
			sb.append(",VERRE_CF_25CL=" + VERRE_CF_25CL);
			sb.append(",VERRE_CF_Unknown=" + VERRE_CF_Unknown);
			sb.append(",VERRE_BOISSON_25CL=" + VERRE_BOISSON_25CL);
			sb.append(",VERRE_BOISSON_Unknown=" + VERRE_BOISSON_Unknown);
			sb.append(",VERRE_IZEM_25CL=" + VERRE_IZEM_25CL);
			sb.append(",VERRE_BG_25CL=" + VERRE_BG_25CL);
			sb.append(",VERRE_BG_Unknown=" + VERRE_BG_Unknown);
			sb.append(",VERRE_ICETHE_25CL=" + VERRE_ICETHE_25CL);
			sb.append(",VERRE_ICETHE_Unknown=" + VERRE_ICETHE_Unknown);
			sb.append(",CANNETTE_SODA_33CL=" + CANNETTE_SODA_33CL);
			sb.append(",CANNETTE_JUS_33CL=" + CANNETTE_JUS_33CL);
			sb.append(",CANNETTE_ENERGY_25CL=" + CANNETTE_ENERGY_25CL);
			sb.append(",CANNETTE_SODACOLA_25CL=" + CANNETTE_SODACOLA_25CL);
			sb.append(",CANNETTE_BG_25CL=" + CANNETTE_BG_25CL);
			sb.append(",Routes=" + Routes);
			sb.append(",Univers=" + Univers);
			sb.append(",Nb_visites=" + Nb_visites);
			sb.append(",Nb_visites_achat=" + Nb_visites_achat);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row2Struct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public static class out10Struct implements routines.system.IPersistableRow<out10Struct> {
		final static byte[] commonByteArrayLock_KEYRUS_ReadFile_V04_2 = new byte[0];
		static byte[] commonByteArray_KEYRUS_ReadFile_V04_2 = new byte[0];

		public Integer ID;

		public Integer getID() {
			return this.ID;
		}

		public String WEEK;

		public String getWEEK() {
			return this.WEEK;
		}

		public String DAY;

		public String getDAY() {
			return this.DAY;
		}

		public String Date;

		public String getDate() {
			return this.Date;
		}

		public String Circuit;

		public String getCircuit() {
			return this.Circuit;
		}

		public String Van;

		public String getVan() {
			return this.Van;
		}

		public String PET_EMN_33CL;

		public String getPET_EMN_33CL() {
			return this.PET_EMN_33CL;
		}

		public String PET_EMN_33CL_B_S_Junior;

		public String getPET_EMN_33CL_B_S_Junior() {
			return this.PET_EMN_33CL_B_S_Junior;
		}

		public String PET_EMN_50CL;

		public String getPET_EMN_50CL() {
			return this.PET_EMN_50CL;
		}

		public String PET_EMN_50CL_B_S;

		public String getPET_EMN_50CL_B_S() {
			return this.PET_EMN_50CL_B_S;
		}

		public String PET_EMN_150CL;

		public String getPET_EMN_150CL() {
			return this.PET_EMN_150CL;
		}

		public String PET_EMG_33CL;

		public String getPET_EMG_33CL() {
			return this.PET_EMG_33CL;
		}

		public String PET_EMG_50CL;

		public String getPET_EMG_50CL() {
			return this.PET_EMG_50CL;
		}

		public String PET_EMG_100CL;

		public String getPET_EMG_100CL() {
			return this.PET_EMG_100CL;
		}

		public String PET_SODA_PREMIUM_33CL;

		public String getPET_SODA_PREMIUM_33CL() {
			return this.PET_SODA_PREMIUM_33CL;
		}

		public String PET_SODA_PREMIUM_100CL;

		public String getPET_SODA_PREMIUM_100CL() {
			return this.PET_SODA_PREMIUM_100CL;
		}

		public String PET_SODA_PREMIUM_150CL;

		public String getPET_SODA_PREMIUM_150CL() {
			return this.PET_SODA_PREMIUM_150CL;
		}

		public String PET_SODA_PREMIUM_200CL;

		public String getPET_SODA_PREMIUM_200CL() {
			return this.PET_SODA_PREMIUM_200CL;
		}

		public String PET_PET_SODA_COLA_33CL;

		public String getPET_PET_SODA_COLA_33CL() {
			return this.PET_PET_SODA_COLA_33CL;
		}

		public String PET_SODA_COLA_100CL;

		public String getPET_SODA_COLA_100CL() {
			return this.PET_SODA_COLA_100CL;
		}

		public String PET_SODA_COLA_150CL;

		public String getPET_SODA_COLA_150CL() {
			return this.PET_SODA_COLA_150CL;
		}

		public String PET_SODA_COLA_200CL;

		public String getPET_SODA_COLA_200CL() {
			return this.PET_SODA_COLA_200CL;
		}

		public String PET_EF_P_tifruit_20CL;

		public String getPET_EF_P_tifruit_20CL() {
			return this.PET_EF_P_tifruit_20CL;
		}

		public String PET_EF_33CL;

		public String getPET_EF_33CL() {
			return this.PET_EF_33CL;
		}

		public String PET_EF_100CL;

		public String getPET_EF_100CL() {
			return this.PET_EF_100CL;
		}

		public String PET_EF_150CL;

		public String getPET_EF_150CL() {
			return this.PET_EF_150CL;
		}

		public String PET_EF_200CL;

		public String getPET_EF_200CL() {
			return this.PET_EF_200CL;
		}

		public String PET_EF_Unknown;

		public String getPET_EF_Unknown() {
			return this.PET_EF_Unknown;
		}

		public String PET_EFL_P_tifruit_20CL;

		public String getPET_EFL_P_tifruit_20CL() {
			return this.PET_EFL_P_tifruit_20CL;
		}

		public String PET_EFL_20CL;

		public String getPET_EFL_20CL() {
			return this.PET_EFL_20CL;
		}

		public String PET_EFL_33CL;

		public String getPET_EFL_33CL() {
			return this.PET_EFL_33CL;
		}

		public String PET_EFL_100CL;

		public String getPET_EFL_100CL() {
			return this.PET_EFL_100CL;
		}

		public String PET_EFL_150CL;

		public String getPET_EFL_150CL() {
			return this.PET_EFL_150CL;
		}

		public String PET_SPORTDRINK_50CL;

		public String getPET_SPORTDRINK_50CL() {
			return this.PET_SPORTDRINK_50CL;
		}

		public String PET_SPORTDRINK_Unknown;

		public String getPET_SPORTDRINK_Unknown() {
			return this.PET_SPORTDRINK_Unknown;
		}

		public String PET_JUSPUR_20CL;

		public String getPET_JUSPUR_20CL() {
			return this.PET_JUSPUR_20CL;
		}

		public String PET_JUSPUR_100CL;

		public String getPET_JUSPUR_100CL() {
			return this.PET_JUSPUR_100CL;
		}

		public String PET_BEIZEM_33CL;

		public String getPET_BEIZEM_33CL() {
			return this.PET_BEIZEM_33CL;
		}

		public String PET_BEIZEM_Unknown;

		public String getPET_BEIZEM_Unknown() {
			return this.PET_BEIZEM_Unknown;
		}

		public String PET_EFG_25CL;

		public String getPET_EFG_25CL() {
			return this.PET_EFG_25CL;
		}

		public String PET_EFG_33CL;

		public String getPET_EFG_33CL() {
			return this.PET_EFG_33CL;
		}

		public String PET_EFG_100CL;

		public String getPET_EFG_100CL() {
			return this.PET_EFG_100CL;
		}

		public String PET_EFG_150CL;

		public String getPET_EFG_150CL() {
			return this.PET_EFG_150CL;
		}

		public String PET_ICETHE_25CL;

		public String getPET_ICETHE_25CL() {
			return this.PET_ICETHE_25CL;
		}

		public String PET_ICETHE_100CL;

		public String getPET_ICETHE_100CL() {
			return this.PET_ICETHE_100CL;
		}

		public String PET_ICETHE_150CL;

		public String getPET_ICETHE_150CL() {
			return this.PET_ICETHE_150CL;
		}

		public String VERRE_EMN_25CL;

		public String getVERRE_EMN_25CL() {
			return this.VERRE_EMN_25CL;
		}

		public String VERRE_EMN_50CL;

		public String getVERRE_EMN_50CL() {
			return this.VERRE_EMN_50CL;
		}

		public String VERRE_EMN_100CL;

		public String getVERRE_EMN_100CL() {
			return this.VERRE_EMN_100CL;
		}

		public String VERRE_EMG_25CL;

		public String getVERRE_EMG_25CL() {
			return this.VERRE_EMG_25CL;
		}

		public String VERRE_EMG_50CL;

		public String getVERRE_EMG_50CL() {
			return this.VERRE_EMG_50CL;
		}

		public String VERRE_EMG_100CL;

		public String getVERRE_EMG_100CL() {
			return this.VERRE_EMG_100CL;
		}

		public String VERRE_SODA_25CL;

		public String getVERRE_SODA_25CL() {
			return this.VERRE_SODA_25CL;
		}

		public String VERRE_SODA_100CL;

		public String getVERRE_SODA_100CL() {
			return this.VERRE_SODA_100CL;
		}

		public String VERRE_SODACOLA_25CL;

		public String getVERRE_SODACOLA_25CL() {
			return this.VERRE_SODACOLA_25CL;
		}

		public String VERRE_SODACOLA_100CL;

		public String getVERRE_SODACOLA_100CL() {
			return this.VERRE_SODACOLA_100CL;
		}

		public String VERRE_EF_25CL;

		public String getVERRE_EF_25CL() {
			return this.VERRE_EF_25CL;
		}

		public String VERRE_EF_Unknown;

		public String getVERRE_EF_Unknown() {
			return this.VERRE_EF_Unknown;
		}

		public String VERRE_EFL_25CL;

		public String getVERRE_EFL_25CL() {
			return this.VERRE_EFL_25CL;
		}

		public String VERRE_EFL_Unknown;

		public String getVERRE_EFL_Unknown() {
			return this.VERRE_EFL_Unknown;
		}

		public String VERRE_CF_25CL;

		public String getVERRE_CF_25CL() {
			return this.VERRE_CF_25CL;
		}

		public String VERRE_CF_Unknown;

		public String getVERRE_CF_Unknown() {
			return this.VERRE_CF_Unknown;
		}

		public String VERRE_BOISSON_25CL;

		public String getVERRE_BOISSON_25CL() {
			return this.VERRE_BOISSON_25CL;
		}

		public String VERRE_BOISSON_Unknown;

		public String getVERRE_BOISSON_Unknown() {
			return this.VERRE_BOISSON_Unknown;
		}

		public String VERRE_IZEM_25CL;

		public String getVERRE_IZEM_25CL() {
			return this.VERRE_IZEM_25CL;
		}

		public String VERRE_BG_25CL;

		public String getVERRE_BG_25CL() {
			return this.VERRE_BG_25CL;
		}

		public String VERRE_BG_Unknown;

		public String getVERRE_BG_Unknown() {
			return this.VERRE_BG_Unknown;
		}

		public String VERRE_ICETHE_25CL;

		public String getVERRE_ICETHE_25CL() {
			return this.VERRE_ICETHE_25CL;
		}

		public String VERRE_ICETHE_Unknown;

		public String getVERRE_ICETHE_Unknown() {
			return this.VERRE_ICETHE_Unknown;
		}

		public String CANNETTE_SODA_33CL;

		public String getCANNETTE_SODA_33CL() {
			return this.CANNETTE_SODA_33CL;
		}

		public String CANNETTE_JUS_33CL;

		public String getCANNETTE_JUS_33CL() {
			return this.CANNETTE_JUS_33CL;
		}

		public String CANNETTE_ENERGY_25CL;

		public String getCANNETTE_ENERGY_25CL() {
			return this.CANNETTE_ENERGY_25CL;
		}

		public String CANNETTE_SODACOLA_25CL;

		public String getCANNETTE_SODACOLA_25CL() {
			return this.CANNETTE_SODACOLA_25CL;
		}

		public String CANNETTE_BG_25CL;

		public String getCANNETTE_BG_25CL() {
			return this.CANNETTE_BG_25CL;
		}

		public String Routes;

		public String getRoutes() {
			return this.Routes;
		}

		public String Univers;

		public String getUnivers() {
			return this.Univers;
		}

		public String Nb_visites;

		public String getNb_visites() {
			return this.Nb_visites;
		}

		public String Nb_visites_achat;

		public String getNb_visites_achat() {
			return this.Nb_visites_achat;
		}

		private Integer readInteger(ObjectInputStream dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException {
			if (intNum == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeInt(intNum);
			}
		}

		private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (intNum == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeInt(intNum);
			}
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_KEYRUS_ReadFile_V04_2.length) {
					if (length < 1024 && commonByteArray_KEYRUS_ReadFile_V04_2.length == 0) {
						commonByteArray_KEYRUS_ReadFile_V04_2 = new byte[1024];
					} else {
						commonByteArray_KEYRUS_ReadFile_V04_2 = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_KEYRUS_ReadFile_V04_2, 0, length);
				strReturn = new String(commonByteArray_KEYRUS_ReadFile_V04_2, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_KEYRUS_ReadFile_V04_2.length) {
					if (length < 1024 && commonByteArray_KEYRUS_ReadFile_V04_2.length == 0) {
						commonByteArray_KEYRUS_ReadFile_V04_2 = new byte[1024];
					} else {
						commonByteArray_KEYRUS_ReadFile_V04_2 = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_KEYRUS_ReadFile_V04_2, 0, length);
				strReturn = new String(commonByteArray_KEYRUS_ReadFile_V04_2, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_KEYRUS_ReadFile_V04_2) {

				try {

					int length = 0;

					this.ID = readInteger(dis);

					this.WEEK = readString(dis);

					this.DAY = readString(dis);

					this.Date = readString(dis);

					this.Circuit = readString(dis);

					this.Van = readString(dis);

					this.PET_EMN_33CL = readString(dis);

					this.PET_EMN_33CL_B_S_Junior = readString(dis);

					this.PET_EMN_50CL = readString(dis);

					this.PET_EMN_50CL_B_S = readString(dis);

					this.PET_EMN_150CL = readString(dis);

					this.PET_EMG_33CL = readString(dis);

					this.PET_EMG_50CL = readString(dis);

					this.PET_EMG_100CL = readString(dis);

					this.PET_SODA_PREMIUM_33CL = readString(dis);

					this.PET_SODA_PREMIUM_100CL = readString(dis);

					this.PET_SODA_PREMIUM_150CL = readString(dis);

					this.PET_SODA_PREMIUM_200CL = readString(dis);

					this.PET_PET_SODA_COLA_33CL = readString(dis);

					this.PET_SODA_COLA_100CL = readString(dis);

					this.PET_SODA_COLA_150CL = readString(dis);

					this.PET_SODA_COLA_200CL = readString(dis);

					this.PET_EF_P_tifruit_20CL = readString(dis);

					this.PET_EF_33CL = readString(dis);

					this.PET_EF_100CL = readString(dis);

					this.PET_EF_150CL = readString(dis);

					this.PET_EF_200CL = readString(dis);

					this.PET_EF_Unknown = readString(dis);

					this.PET_EFL_P_tifruit_20CL = readString(dis);

					this.PET_EFL_20CL = readString(dis);

					this.PET_EFL_33CL = readString(dis);

					this.PET_EFL_100CL = readString(dis);

					this.PET_EFL_150CL = readString(dis);

					this.PET_SPORTDRINK_50CL = readString(dis);

					this.PET_SPORTDRINK_Unknown = readString(dis);

					this.PET_JUSPUR_20CL = readString(dis);

					this.PET_JUSPUR_100CL = readString(dis);

					this.PET_BEIZEM_33CL = readString(dis);

					this.PET_BEIZEM_Unknown = readString(dis);

					this.PET_EFG_25CL = readString(dis);

					this.PET_EFG_33CL = readString(dis);

					this.PET_EFG_100CL = readString(dis);

					this.PET_EFG_150CL = readString(dis);

					this.PET_ICETHE_25CL = readString(dis);

					this.PET_ICETHE_100CL = readString(dis);

					this.PET_ICETHE_150CL = readString(dis);

					this.VERRE_EMN_25CL = readString(dis);

					this.VERRE_EMN_50CL = readString(dis);

					this.VERRE_EMN_100CL = readString(dis);

					this.VERRE_EMG_25CL = readString(dis);

					this.VERRE_EMG_50CL = readString(dis);

					this.VERRE_EMG_100CL = readString(dis);

					this.VERRE_SODA_25CL = readString(dis);

					this.VERRE_SODA_100CL = readString(dis);

					this.VERRE_SODACOLA_25CL = readString(dis);

					this.VERRE_SODACOLA_100CL = readString(dis);

					this.VERRE_EF_25CL = readString(dis);

					this.VERRE_EF_Unknown = readString(dis);

					this.VERRE_EFL_25CL = readString(dis);

					this.VERRE_EFL_Unknown = readString(dis);

					this.VERRE_CF_25CL = readString(dis);

					this.VERRE_CF_Unknown = readString(dis);

					this.VERRE_BOISSON_25CL = readString(dis);

					this.VERRE_BOISSON_Unknown = readString(dis);

					this.VERRE_IZEM_25CL = readString(dis);

					this.VERRE_BG_25CL = readString(dis);

					this.VERRE_BG_Unknown = readString(dis);

					this.VERRE_ICETHE_25CL = readString(dis);

					this.VERRE_ICETHE_Unknown = readString(dis);

					this.CANNETTE_SODA_33CL = readString(dis);

					this.CANNETTE_JUS_33CL = readString(dis);

					this.CANNETTE_ENERGY_25CL = readString(dis);

					this.CANNETTE_SODACOLA_25CL = readString(dis);

					this.CANNETTE_BG_25CL = readString(dis);

					this.Routes = readString(dis);

					this.Univers = readString(dis);

					this.Nb_visites = readString(dis);

					this.Nb_visites_achat = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_KEYRUS_ReadFile_V04_2) {

				try {

					int length = 0;

					this.ID = readInteger(dis);

					this.WEEK = readString(dis);

					this.DAY = readString(dis);

					this.Date = readString(dis);

					this.Circuit = readString(dis);

					this.Van = readString(dis);

					this.PET_EMN_33CL = readString(dis);

					this.PET_EMN_33CL_B_S_Junior = readString(dis);

					this.PET_EMN_50CL = readString(dis);

					this.PET_EMN_50CL_B_S = readString(dis);

					this.PET_EMN_150CL = readString(dis);

					this.PET_EMG_33CL = readString(dis);

					this.PET_EMG_50CL = readString(dis);

					this.PET_EMG_100CL = readString(dis);

					this.PET_SODA_PREMIUM_33CL = readString(dis);

					this.PET_SODA_PREMIUM_100CL = readString(dis);

					this.PET_SODA_PREMIUM_150CL = readString(dis);

					this.PET_SODA_PREMIUM_200CL = readString(dis);

					this.PET_PET_SODA_COLA_33CL = readString(dis);

					this.PET_SODA_COLA_100CL = readString(dis);

					this.PET_SODA_COLA_150CL = readString(dis);

					this.PET_SODA_COLA_200CL = readString(dis);

					this.PET_EF_P_tifruit_20CL = readString(dis);

					this.PET_EF_33CL = readString(dis);

					this.PET_EF_100CL = readString(dis);

					this.PET_EF_150CL = readString(dis);

					this.PET_EF_200CL = readString(dis);

					this.PET_EF_Unknown = readString(dis);

					this.PET_EFL_P_tifruit_20CL = readString(dis);

					this.PET_EFL_20CL = readString(dis);

					this.PET_EFL_33CL = readString(dis);

					this.PET_EFL_100CL = readString(dis);

					this.PET_EFL_150CL = readString(dis);

					this.PET_SPORTDRINK_50CL = readString(dis);

					this.PET_SPORTDRINK_Unknown = readString(dis);

					this.PET_JUSPUR_20CL = readString(dis);

					this.PET_JUSPUR_100CL = readString(dis);

					this.PET_BEIZEM_33CL = readString(dis);

					this.PET_BEIZEM_Unknown = readString(dis);

					this.PET_EFG_25CL = readString(dis);

					this.PET_EFG_33CL = readString(dis);

					this.PET_EFG_100CL = readString(dis);

					this.PET_EFG_150CL = readString(dis);

					this.PET_ICETHE_25CL = readString(dis);

					this.PET_ICETHE_100CL = readString(dis);

					this.PET_ICETHE_150CL = readString(dis);

					this.VERRE_EMN_25CL = readString(dis);

					this.VERRE_EMN_50CL = readString(dis);

					this.VERRE_EMN_100CL = readString(dis);

					this.VERRE_EMG_25CL = readString(dis);

					this.VERRE_EMG_50CL = readString(dis);

					this.VERRE_EMG_100CL = readString(dis);

					this.VERRE_SODA_25CL = readString(dis);

					this.VERRE_SODA_100CL = readString(dis);

					this.VERRE_SODACOLA_25CL = readString(dis);

					this.VERRE_SODACOLA_100CL = readString(dis);

					this.VERRE_EF_25CL = readString(dis);

					this.VERRE_EF_Unknown = readString(dis);

					this.VERRE_EFL_25CL = readString(dis);

					this.VERRE_EFL_Unknown = readString(dis);

					this.VERRE_CF_25CL = readString(dis);

					this.VERRE_CF_Unknown = readString(dis);

					this.VERRE_BOISSON_25CL = readString(dis);

					this.VERRE_BOISSON_Unknown = readString(dis);

					this.VERRE_IZEM_25CL = readString(dis);

					this.VERRE_BG_25CL = readString(dis);

					this.VERRE_BG_Unknown = readString(dis);

					this.VERRE_ICETHE_25CL = readString(dis);

					this.VERRE_ICETHE_Unknown = readString(dis);

					this.CANNETTE_SODA_33CL = readString(dis);

					this.CANNETTE_JUS_33CL = readString(dis);

					this.CANNETTE_ENERGY_25CL = readString(dis);

					this.CANNETTE_SODACOLA_25CL = readString(dis);

					this.CANNETTE_BG_25CL = readString(dis);

					this.Routes = readString(dis);

					this.Univers = readString(dis);

					this.Nb_visites = readString(dis);

					this.Nb_visites_achat = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// Integer

				writeInteger(this.ID, dos);

				// String

				writeString(this.WEEK, dos);

				// String

				writeString(this.DAY, dos);

				// String

				writeString(this.Date, dos);

				// String

				writeString(this.Circuit, dos);

				// String

				writeString(this.Van, dos);

				// String

				writeString(this.PET_EMN_33CL, dos);

				// String

				writeString(this.PET_EMN_33CL_B_S_Junior, dos);

				// String

				writeString(this.PET_EMN_50CL, dos);

				// String

				writeString(this.PET_EMN_50CL_B_S, dos);

				// String

				writeString(this.PET_EMN_150CL, dos);

				// String

				writeString(this.PET_EMG_33CL, dos);

				// String

				writeString(this.PET_EMG_50CL, dos);

				// String

				writeString(this.PET_EMG_100CL, dos);

				// String

				writeString(this.PET_SODA_PREMIUM_33CL, dos);

				// String

				writeString(this.PET_SODA_PREMIUM_100CL, dos);

				// String

				writeString(this.PET_SODA_PREMIUM_150CL, dos);

				// String

				writeString(this.PET_SODA_PREMIUM_200CL, dos);

				// String

				writeString(this.PET_PET_SODA_COLA_33CL, dos);

				// String

				writeString(this.PET_SODA_COLA_100CL, dos);

				// String

				writeString(this.PET_SODA_COLA_150CL, dos);

				// String

				writeString(this.PET_SODA_COLA_200CL, dos);

				// String

				writeString(this.PET_EF_P_tifruit_20CL, dos);

				// String

				writeString(this.PET_EF_33CL, dos);

				// String

				writeString(this.PET_EF_100CL, dos);

				// String

				writeString(this.PET_EF_150CL, dos);

				// String

				writeString(this.PET_EF_200CL, dos);

				// String

				writeString(this.PET_EF_Unknown, dos);

				// String

				writeString(this.PET_EFL_P_tifruit_20CL, dos);

				// String

				writeString(this.PET_EFL_20CL, dos);

				// String

				writeString(this.PET_EFL_33CL, dos);

				// String

				writeString(this.PET_EFL_100CL, dos);

				// String

				writeString(this.PET_EFL_150CL, dos);

				// String

				writeString(this.PET_SPORTDRINK_50CL, dos);

				// String

				writeString(this.PET_SPORTDRINK_Unknown, dos);

				// String

				writeString(this.PET_JUSPUR_20CL, dos);

				// String

				writeString(this.PET_JUSPUR_100CL, dos);

				// String

				writeString(this.PET_BEIZEM_33CL, dos);

				// String

				writeString(this.PET_BEIZEM_Unknown, dos);

				// String

				writeString(this.PET_EFG_25CL, dos);

				// String

				writeString(this.PET_EFG_33CL, dos);

				// String

				writeString(this.PET_EFG_100CL, dos);

				// String

				writeString(this.PET_EFG_150CL, dos);

				// String

				writeString(this.PET_ICETHE_25CL, dos);

				// String

				writeString(this.PET_ICETHE_100CL, dos);

				// String

				writeString(this.PET_ICETHE_150CL, dos);

				// String

				writeString(this.VERRE_EMN_25CL, dos);

				// String

				writeString(this.VERRE_EMN_50CL, dos);

				// String

				writeString(this.VERRE_EMN_100CL, dos);

				// String

				writeString(this.VERRE_EMG_25CL, dos);

				// String

				writeString(this.VERRE_EMG_50CL, dos);

				// String

				writeString(this.VERRE_EMG_100CL, dos);

				// String

				writeString(this.VERRE_SODA_25CL, dos);

				// String

				writeString(this.VERRE_SODA_100CL, dos);

				// String

				writeString(this.VERRE_SODACOLA_25CL, dos);

				// String

				writeString(this.VERRE_SODACOLA_100CL, dos);

				// String

				writeString(this.VERRE_EF_25CL, dos);

				// String

				writeString(this.VERRE_EF_Unknown, dos);

				// String

				writeString(this.VERRE_EFL_25CL, dos);

				// String

				writeString(this.VERRE_EFL_Unknown, dos);

				// String

				writeString(this.VERRE_CF_25CL, dos);

				// String

				writeString(this.VERRE_CF_Unknown, dos);

				// String

				writeString(this.VERRE_BOISSON_25CL, dos);

				// String

				writeString(this.VERRE_BOISSON_Unknown, dos);

				// String

				writeString(this.VERRE_IZEM_25CL, dos);

				// String

				writeString(this.VERRE_BG_25CL, dos);

				// String

				writeString(this.VERRE_BG_Unknown, dos);

				// String

				writeString(this.VERRE_ICETHE_25CL, dos);

				// String

				writeString(this.VERRE_ICETHE_Unknown, dos);

				// String

				writeString(this.CANNETTE_SODA_33CL, dos);

				// String

				writeString(this.CANNETTE_JUS_33CL, dos);

				// String

				writeString(this.CANNETTE_ENERGY_25CL, dos);

				// String

				writeString(this.CANNETTE_SODACOLA_25CL, dos);

				// String

				writeString(this.CANNETTE_BG_25CL, dos);

				// String

				writeString(this.Routes, dos);

				// String

				writeString(this.Univers, dos);

				// String

				writeString(this.Nb_visites, dos);

				// String

				writeString(this.Nb_visites_achat, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// Integer

				writeInteger(this.ID, dos);

				// String

				writeString(this.WEEK, dos);

				// String

				writeString(this.DAY, dos);

				// String

				writeString(this.Date, dos);

				// String

				writeString(this.Circuit, dos);

				// String

				writeString(this.Van, dos);

				// String

				writeString(this.PET_EMN_33CL, dos);

				// String

				writeString(this.PET_EMN_33CL_B_S_Junior, dos);

				// String

				writeString(this.PET_EMN_50CL, dos);

				// String

				writeString(this.PET_EMN_50CL_B_S, dos);

				// String

				writeString(this.PET_EMN_150CL, dos);

				// String

				writeString(this.PET_EMG_33CL, dos);

				// String

				writeString(this.PET_EMG_50CL, dos);

				// String

				writeString(this.PET_EMG_100CL, dos);

				// String

				writeString(this.PET_SODA_PREMIUM_33CL, dos);

				// String

				writeString(this.PET_SODA_PREMIUM_100CL, dos);

				// String

				writeString(this.PET_SODA_PREMIUM_150CL, dos);

				// String

				writeString(this.PET_SODA_PREMIUM_200CL, dos);

				// String

				writeString(this.PET_PET_SODA_COLA_33CL, dos);

				// String

				writeString(this.PET_SODA_COLA_100CL, dos);

				// String

				writeString(this.PET_SODA_COLA_150CL, dos);

				// String

				writeString(this.PET_SODA_COLA_200CL, dos);

				// String

				writeString(this.PET_EF_P_tifruit_20CL, dos);

				// String

				writeString(this.PET_EF_33CL, dos);

				// String

				writeString(this.PET_EF_100CL, dos);

				// String

				writeString(this.PET_EF_150CL, dos);

				// String

				writeString(this.PET_EF_200CL, dos);

				// String

				writeString(this.PET_EF_Unknown, dos);

				// String

				writeString(this.PET_EFL_P_tifruit_20CL, dos);

				// String

				writeString(this.PET_EFL_20CL, dos);

				// String

				writeString(this.PET_EFL_33CL, dos);

				// String

				writeString(this.PET_EFL_100CL, dos);

				// String

				writeString(this.PET_EFL_150CL, dos);

				// String

				writeString(this.PET_SPORTDRINK_50CL, dos);

				// String

				writeString(this.PET_SPORTDRINK_Unknown, dos);

				// String

				writeString(this.PET_JUSPUR_20CL, dos);

				// String

				writeString(this.PET_JUSPUR_100CL, dos);

				// String

				writeString(this.PET_BEIZEM_33CL, dos);

				// String

				writeString(this.PET_BEIZEM_Unknown, dos);

				// String

				writeString(this.PET_EFG_25CL, dos);

				// String

				writeString(this.PET_EFG_33CL, dos);

				// String

				writeString(this.PET_EFG_100CL, dos);

				// String

				writeString(this.PET_EFG_150CL, dos);

				// String

				writeString(this.PET_ICETHE_25CL, dos);

				// String

				writeString(this.PET_ICETHE_100CL, dos);

				// String

				writeString(this.PET_ICETHE_150CL, dos);

				// String

				writeString(this.VERRE_EMN_25CL, dos);

				// String

				writeString(this.VERRE_EMN_50CL, dos);

				// String

				writeString(this.VERRE_EMN_100CL, dos);

				// String

				writeString(this.VERRE_EMG_25CL, dos);

				// String

				writeString(this.VERRE_EMG_50CL, dos);

				// String

				writeString(this.VERRE_EMG_100CL, dos);

				// String

				writeString(this.VERRE_SODA_25CL, dos);

				// String

				writeString(this.VERRE_SODA_100CL, dos);

				// String

				writeString(this.VERRE_SODACOLA_25CL, dos);

				// String

				writeString(this.VERRE_SODACOLA_100CL, dos);

				// String

				writeString(this.VERRE_EF_25CL, dos);

				// String

				writeString(this.VERRE_EF_Unknown, dos);

				// String

				writeString(this.VERRE_EFL_25CL, dos);

				// String

				writeString(this.VERRE_EFL_Unknown, dos);

				// String

				writeString(this.VERRE_CF_25CL, dos);

				// String

				writeString(this.VERRE_CF_Unknown, dos);

				// String

				writeString(this.VERRE_BOISSON_25CL, dos);

				// String

				writeString(this.VERRE_BOISSON_Unknown, dos);

				// String

				writeString(this.VERRE_IZEM_25CL, dos);

				// String

				writeString(this.VERRE_BG_25CL, dos);

				// String

				writeString(this.VERRE_BG_Unknown, dos);

				// String

				writeString(this.VERRE_ICETHE_25CL, dos);

				// String

				writeString(this.VERRE_ICETHE_Unknown, dos);

				// String

				writeString(this.CANNETTE_SODA_33CL, dos);

				// String

				writeString(this.CANNETTE_JUS_33CL, dos);

				// String

				writeString(this.CANNETTE_ENERGY_25CL, dos);

				// String

				writeString(this.CANNETTE_SODACOLA_25CL, dos);

				// String

				writeString(this.CANNETTE_BG_25CL, dos);

				// String

				writeString(this.Routes, dos);

				// String

				writeString(this.Univers, dos);

				// String

				writeString(this.Nb_visites, dos);

				// String

				writeString(this.Nb_visites_achat, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("ID=" + String.valueOf(ID));
			sb.append(",WEEK=" + WEEK);
			sb.append(",DAY=" + DAY);
			sb.append(",Date=" + Date);
			sb.append(",Circuit=" + Circuit);
			sb.append(",Van=" + Van);
			sb.append(",PET_EMN_33CL=" + PET_EMN_33CL);
			sb.append(",PET_EMN_33CL_B_S_Junior=" + PET_EMN_33CL_B_S_Junior);
			sb.append(",PET_EMN_50CL=" + PET_EMN_50CL);
			sb.append(",PET_EMN_50CL_B_S=" + PET_EMN_50CL_B_S);
			sb.append(",PET_EMN_150CL=" + PET_EMN_150CL);
			sb.append(",PET_EMG_33CL=" + PET_EMG_33CL);
			sb.append(",PET_EMG_50CL=" + PET_EMG_50CL);
			sb.append(",PET_EMG_100CL=" + PET_EMG_100CL);
			sb.append(",PET_SODA_PREMIUM_33CL=" + PET_SODA_PREMIUM_33CL);
			sb.append(",PET_SODA_PREMIUM_100CL=" + PET_SODA_PREMIUM_100CL);
			sb.append(",PET_SODA_PREMIUM_150CL=" + PET_SODA_PREMIUM_150CL);
			sb.append(",PET_SODA_PREMIUM_200CL=" + PET_SODA_PREMIUM_200CL);
			sb.append(",PET_PET_SODA_COLA_33CL=" + PET_PET_SODA_COLA_33CL);
			sb.append(",PET_SODA_COLA_100CL=" + PET_SODA_COLA_100CL);
			sb.append(",PET_SODA_COLA_150CL=" + PET_SODA_COLA_150CL);
			sb.append(",PET_SODA_COLA_200CL=" + PET_SODA_COLA_200CL);
			sb.append(",PET_EF_P_tifruit_20CL=" + PET_EF_P_tifruit_20CL);
			sb.append(",PET_EF_33CL=" + PET_EF_33CL);
			sb.append(",PET_EF_100CL=" + PET_EF_100CL);
			sb.append(",PET_EF_150CL=" + PET_EF_150CL);
			sb.append(",PET_EF_200CL=" + PET_EF_200CL);
			sb.append(",PET_EF_Unknown=" + PET_EF_Unknown);
			sb.append(",PET_EFL_P_tifruit_20CL=" + PET_EFL_P_tifruit_20CL);
			sb.append(",PET_EFL_20CL=" + PET_EFL_20CL);
			sb.append(",PET_EFL_33CL=" + PET_EFL_33CL);
			sb.append(",PET_EFL_100CL=" + PET_EFL_100CL);
			sb.append(",PET_EFL_150CL=" + PET_EFL_150CL);
			sb.append(",PET_SPORTDRINK_50CL=" + PET_SPORTDRINK_50CL);
			sb.append(",PET_SPORTDRINK_Unknown=" + PET_SPORTDRINK_Unknown);
			sb.append(",PET_JUSPUR_20CL=" + PET_JUSPUR_20CL);
			sb.append(",PET_JUSPUR_100CL=" + PET_JUSPUR_100CL);
			sb.append(",PET_BEIZEM_33CL=" + PET_BEIZEM_33CL);
			sb.append(",PET_BEIZEM_Unknown=" + PET_BEIZEM_Unknown);
			sb.append(",PET_EFG_25CL=" + PET_EFG_25CL);
			sb.append(",PET_EFG_33CL=" + PET_EFG_33CL);
			sb.append(",PET_EFG_100CL=" + PET_EFG_100CL);
			sb.append(",PET_EFG_150CL=" + PET_EFG_150CL);
			sb.append(",PET_ICETHE_25CL=" + PET_ICETHE_25CL);
			sb.append(",PET_ICETHE_100CL=" + PET_ICETHE_100CL);
			sb.append(",PET_ICETHE_150CL=" + PET_ICETHE_150CL);
			sb.append(",VERRE_EMN_25CL=" + VERRE_EMN_25CL);
			sb.append(",VERRE_EMN_50CL=" + VERRE_EMN_50CL);
			sb.append(",VERRE_EMN_100CL=" + VERRE_EMN_100CL);
			sb.append(",VERRE_EMG_25CL=" + VERRE_EMG_25CL);
			sb.append(",VERRE_EMG_50CL=" + VERRE_EMG_50CL);
			sb.append(",VERRE_EMG_100CL=" + VERRE_EMG_100CL);
			sb.append(",VERRE_SODA_25CL=" + VERRE_SODA_25CL);
			sb.append(",VERRE_SODA_100CL=" + VERRE_SODA_100CL);
			sb.append(",VERRE_SODACOLA_25CL=" + VERRE_SODACOLA_25CL);
			sb.append(",VERRE_SODACOLA_100CL=" + VERRE_SODACOLA_100CL);
			sb.append(",VERRE_EF_25CL=" + VERRE_EF_25CL);
			sb.append(",VERRE_EF_Unknown=" + VERRE_EF_Unknown);
			sb.append(",VERRE_EFL_25CL=" + VERRE_EFL_25CL);
			sb.append(",VERRE_EFL_Unknown=" + VERRE_EFL_Unknown);
			sb.append(",VERRE_CF_25CL=" + VERRE_CF_25CL);
			sb.append(",VERRE_CF_Unknown=" + VERRE_CF_Unknown);
			sb.append(",VERRE_BOISSON_25CL=" + VERRE_BOISSON_25CL);
			sb.append(",VERRE_BOISSON_Unknown=" + VERRE_BOISSON_Unknown);
			sb.append(",VERRE_IZEM_25CL=" + VERRE_IZEM_25CL);
			sb.append(",VERRE_BG_25CL=" + VERRE_BG_25CL);
			sb.append(",VERRE_BG_Unknown=" + VERRE_BG_Unknown);
			sb.append(",VERRE_ICETHE_25CL=" + VERRE_ICETHE_25CL);
			sb.append(",VERRE_ICETHE_Unknown=" + VERRE_ICETHE_Unknown);
			sb.append(",CANNETTE_SODA_33CL=" + CANNETTE_SODA_33CL);
			sb.append(",CANNETTE_JUS_33CL=" + CANNETTE_JUS_33CL);
			sb.append(",CANNETTE_ENERGY_25CL=" + CANNETTE_ENERGY_25CL);
			sb.append(",CANNETTE_SODACOLA_25CL=" + CANNETTE_SODACOLA_25CL);
			sb.append(",CANNETTE_BG_25CL=" + CANNETTE_BG_25CL);
			sb.append(",Routes=" + Routes);
			sb.append(",Univers=" + Univers);
			sb.append(",Nb_visites=" + Nb_visites);
			sb.append(",Nb_visites_achat=" + Nb_visites_achat);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(out10Struct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public static class row1Struct implements routines.system.IPersistableRow<row1Struct> {
		final static byte[] commonByteArrayLock_KEYRUS_ReadFile_V04_2 = new byte[0];
		static byte[] commonByteArray_KEYRUS_ReadFile_V04_2 = new byte[0];

		public String Sem;

		public String getSem() {
			return this.Sem;
		}

		public String Day;

		public String getDay() {
			return this.Day;
		}

		public String Date;

		public String getDate() {
			return this.Date;
		}

		public String Van;

		public String getVan() {
			return this.Van;
		}

		public String PET_EMN_33CL;

		public String getPET_EMN_33CL() {
			return this.PET_EMN_33CL;
		}

		public String PET_EMN_33CL_B_S_Junior;

		public String getPET_EMN_33CL_B_S_Junior() {
			return this.PET_EMN_33CL_B_S_Junior;
		}

		public String PET_EMN_50CL;

		public String getPET_EMN_50CL() {
			return this.PET_EMN_50CL;
		}

		public String PET_EMN_50CL_B_S;

		public String getPET_EMN_50CL_B_S() {
			return this.PET_EMN_50CL_B_S;
		}

		public String PET_EMN_150CL;

		public String getPET_EMN_150CL() {
			return this.PET_EMN_150CL;
		}

		public String Eau_Minerale_Naturelle;

		public String getEau_Minerale_Naturelle() {
			return this.Eau_Minerale_Naturelle;
		}

		public String PET_EMG_33CL;

		public String getPET_EMG_33CL() {
			return this.PET_EMG_33CL;
		}

		public String PET_EMG_50CL;

		public String getPET_EMG_50CL() {
			return this.PET_EMG_50CL;
		}

		public String PET_EMG_100CL;

		public String getPET_EMG_100CL() {
			return this.PET_EMG_100CL;
		}

		public String Eau_Minerale_Gazifiee;

		public String getEau_Minerale_Gazifiee() {
			return this.Eau_Minerale_Gazifiee;
		}

		public String PET_SODA_PREMIUM_33CL;

		public String getPET_SODA_PREMIUM_33CL() {
			return this.PET_SODA_PREMIUM_33CL;
		}

		public String PET_SODA_PREMIUM_100CL;

		public String getPET_SODA_PREMIUM_100CL() {
			return this.PET_SODA_PREMIUM_100CL;
		}

		public String PET_SODA_PREMIUM_150CL;

		public String getPET_SODA_PREMIUM_150CL() {
			return this.PET_SODA_PREMIUM_150CL;
		}

		public String PET_SODA_PREMIUM_200CL;

		public String getPET_SODA_PREMIUM_200CL() {
			return this.PET_SODA_PREMIUM_200CL;
		}

		public String IFRI_GAZOUZ;

		public String getIFRI_GAZOUZ() {
			return this.IFRI_GAZOUZ;
		}

		public String PET_SODA_COLA_33CL;

		public String getPET_SODA_COLA_33CL() {
			return this.PET_SODA_COLA_33CL;
		}

		public String PET_SODA_COLA_100CL;

		public String getPET_SODA_COLA_100CL() {
			return this.PET_SODA_COLA_100CL;
		}

		public String PET_SODA_COLA_150CL;

		public String getPET_SODA_COLA_150CL() {
			return this.PET_SODA_COLA_150CL;
		}

		public String PET_SODA_COLA_200CL;

		public String getPET_SODA_COLA_200CL() {
			return this.PET_SODA_COLA_200CL;
		}

		public String SODA_COLA;

		public String getSODA_COLA() {
			return this.SODA_COLA;
		}

		public String PET_EF_P_tifruit_20CL;

		public String getPET_EF_P_tifruit_20CL() {
			return this.PET_EF_P_tifruit_20CL;
		}

		public String PET_EF_33CL;

		public String getPET_EF_33CL() {
			return this.PET_EF_33CL;
		}

		public String PET_EF_100CL;

		public String getPET_EF_100CL() {
			return this.PET_EF_100CL;
		}

		public String PET_EF_150CL;

		public String getPET_EF_150CL() {
			return this.PET_EF_150CL;
		}

		public String PET_EF_200CL;

		public String getPET_EF_200CL() {
			return this.PET_EF_200CL;
		}

		public String PET_EF_Unknown;

		public String getPET_EF_Unknown() {
			return this.PET_EF_Unknown;
		}

		public String Eaux_Fruites;

		public String getEaux_Fruites() {
			return this.Eaux_Fruites;
		}

		public String PET_EFL_P_tifruit_20CL;

		public String getPET_EFL_P_tifruit_20CL() {
			return this.PET_EFL_P_tifruit_20CL;
		}

		public String PET_EFL_20CL;

		public String getPET_EFL_20CL() {
			return this.PET_EFL_20CL;
		}

		public String PET_EFL_33CL;

		public String getPET_EFL_33CL() {
			return this.PET_EFL_33CL;
		}

		public String PET_EFL_100CL;

		public String getPET_EFL_100CL() {
			return this.PET_EFL_100CL;
		}

		public String PET_EFL_150CL;

		public String getPET_EFL_150CL() {
			return this.PET_EFL_150CL;
		}

		public String Eaux_Fruites_au_Lait;

		public String getEaux_Fruites_au_Lait() {
			return this.Eaux_Fruites_au_Lait;
		}

		public String PET_SPORTDRINK_50CL;

		public String getPET_SPORTDRINK_50CL() {
			return this.PET_SPORTDRINK_50CL;
		}

		public String PET_SPORTDRINK_Unknown;

		public String getPET_SPORTDRINK_Unknown() {
			return this.PET_SPORTDRINK_Unknown;
		}

		public String SPORT_Drink;

		public String getSPORT_Drink() {
			return this.SPORT_Drink;
		}

		public String PET_JUSPUR_20CL;

		public String getPET_JUSPUR_20CL() {
			return this.PET_JUSPUR_20CL;
		}

		public String PET_JUSPUR_100CL;

		public String getPET_JUSPUR_100CL() {
			return this.PET_JUSPUR_100CL;
		}

		public String JUS_PUR;

		public String getJUS_PUR() {
			return this.JUS_PUR;
		}

		public String PET_BEIZEM_33CL;

		public String getPET_BEIZEM_33CL() {
			return this.PET_BEIZEM_33CL;
		}

		public String PET_BEIZEM_Unknown;

		public String getPET_BEIZEM_Unknown() {
			return this.PET_BEIZEM_Unknown;
		}

		public String Boisson_Energisante_IZEM;

		public String getBoisson_Energisante_IZEM() {
			return this.Boisson_Energisante_IZEM;
		}

		public String PET_EFG_25CL;

		public String getPET_EFG_25CL() {
			return this.PET_EFG_25CL;
		}

		public String PET_EFG_33CL;

		public String getPET_EFG_33CL() {
			return this.PET_EFG_33CL;
		}

		public String PET_EFG_100CL;

		public String getPET_EFG_100CL() {
			return this.PET_EFG_100CL;
		}

		public String PET_EFG_150CL;

		public String getPET_EFG_150CL() {
			return this.PET_EFG_150CL;
		}

		public String EAUX_FRUITEES_GAZEIFIEES;

		public String getEAUX_FRUITEES_GAZEIFIEES() {
			return this.EAUX_FRUITEES_GAZEIFIEES;
		}

		public String PET_ICETHE_25CL;

		public String getPET_ICETHE_25CL() {
			return this.PET_ICETHE_25CL;
		}

		public String PET_ICETHE_100CL;

		public String getPET_ICETHE_100CL() {
			return this.PET_ICETHE_100CL;
		}

		public String PET_ICETHE_150CL;

		public String getPET_ICETHE_150CL() {
			return this.PET_ICETHE_150CL;
		}

		public String ICE_THE_PET;

		public String getICE_THE_PET() {
			return this.ICE_THE_PET;
		}

		public String PET;

		public String getPET() {
			return this.PET;
		}

		public String VERRE_EMN_25CL;

		public String getVERRE_EMN_25CL() {
			return this.VERRE_EMN_25CL;
		}

		public String VERRE_EMN_50CL;

		public String getVERRE_EMN_50CL() {
			return this.VERRE_EMN_50CL;
		}

		public String VERRE_EMN_100CL;

		public String getVERRE_EMN_100CL() {
			return this.VERRE_EMN_100CL;
		}

		public String Eau_Minerale_Verre;

		public String getEau_Minerale_Verre() {
			return this.Eau_Minerale_Verre;
		}

		public String VERRE_EMG_25CL;

		public String getVERRE_EMG_25CL() {
			return this.VERRE_EMG_25CL;
		}

		public String VERRE_EMG_50CL;

		public String getVERRE_EMG_50CL() {
			return this.VERRE_EMG_50CL;
		}

		public String VERRE_EMG_100CL;

		public String getVERRE_EMG_100CL() {
			return this.VERRE_EMG_100CL;
		}

		public String Eau_Minerale_Gazifiee_Verre;

		public String getEau_Minerale_Gazifiee_Verre() {
			return this.Eau_Minerale_Gazifiee_Verre;
		}

		public String VERRE_SODA_25CL;

		public String getVERRE_SODA_25CL() {
			return this.VERRE_SODA_25CL;
		}

		public String VERRE_SODA_100CL;

		public String getVERRE_SODA_100CL() {
			return this.VERRE_SODA_100CL;
		}

		public String SODA_Verre;

		public String getSODA_Verre() {
			return this.SODA_Verre;
		}

		public String VERRE_SODACOLA_25CL;

		public String getVERRE_SODACOLA_25CL() {
			return this.VERRE_SODACOLA_25CL;
		}

		public String VERRE_SODACOLA_100CL;

		public String getVERRE_SODACOLA_100CL() {
			return this.VERRE_SODACOLA_100CL;
		}

		public String SODA_COLA_Verre;

		public String getSODA_COLA_Verre() {
			return this.SODA_COLA_Verre;
		}

		public String VERRE_EF_25CL;

		public String getVERRE_EF_25CL() {
			return this.VERRE_EF_25CL;
		}

		public String VERRE_EF_Unknown;

		public String getVERRE_EF_Unknown() {
			return this.VERRE_EF_Unknown;
		}

		public String Eaux_Fruitees_Verre;

		public String getEaux_Fruitees_Verre() {
			return this.Eaux_Fruitees_Verre;
		}

		public String VERRE_EFL_25CL;

		public String getVERRE_EFL_25CL() {
			return this.VERRE_EFL_25CL;
		}

		public String VERRE_EFL_Unknown;

		public String getVERRE_EFL_Unknown() {
			return this.VERRE_EFL_Unknown;
		}

		public String Eaux_Fruitees_Au_LaitVerre;

		public String getEaux_Fruitees_Au_LaitVerre() {
			return this.Eaux_Fruitees_Au_LaitVerre;
		}

		public String VERRE_CF_25CL;

		public String getVERRE_CF_25CL() {
			return this.VERRE_CF_25CL;
		}

		public String VERRE_CF_Unknown;

		public String getVERRE_CF_Unknown() {
			return this.VERRE_CF_Unknown;
		}

		public String Cocktail_de_Fruits_Verre;

		public String getCocktail_de_Fruits_Verre() {
			return this.Cocktail_de_Fruits_Verre;
		}

		public String VERRE_BOISSON_25CL;

		public String getVERRE_BOISSON_25CL() {
			return this.VERRE_BOISSON_25CL;
		}

		public String VERRE_BOISSON_Unknown;

		public String getVERRE_BOISSON_Unknown() {
			return this.VERRE_BOISSON_Unknown;
		}

		public Integer Boisson_Verre;

		public Integer getBoisson_Verre() {
			return this.Boisson_Verre;
		}

		public String VERRE_IZEM_25CL;

		public String getVERRE_IZEM_25CL() {
			return this.VERRE_IZEM_25CL;
		}

		public Integer IZEM_Verre;

		public Integer getIZEM_Verre() {
			return this.IZEM_Verre;
		}

		public String VERRE_BG_25CL;

		public String getVERRE_BG_25CL() {
			return this.VERRE_BG_25CL;
		}

		public String VERRE_BG_Unknown;

		public String getVERRE_BG_Unknown() {
			return this.VERRE_BG_Unknown;
		}

		public Integer BOISSON_GAZEIFIEE_VERRE;

		public Integer getBOISSON_GAZEIFIEE_VERRE() {
			return this.BOISSON_GAZEIFIEE_VERRE;
		}

		public String VERRE_ICETHE_25CL;

		public String getVERRE_ICETHE_25CL() {
			return this.VERRE_ICETHE_25CL;
		}

		public String VERRE_ICETHE_Unknown;

		public String getVERRE_ICETHE_Unknown() {
			return this.VERRE_ICETHE_Unknown;
		}

		public String ICE_THE_VERRE;

		public String getICE_THE_VERRE() {
			return this.ICE_THE_VERRE;
		}

		public String Verre;

		public String getVerre() {
			return this.Verre;
		}

		public String CANNETTE_SODA_33CL;

		public String getCANNETTE_SODA_33CL() {
			return this.CANNETTE_SODA_33CL;
		}

		public String CANNETTE_JUS_33CL;

		public String getCANNETTE_JUS_33CL() {
			return this.CANNETTE_JUS_33CL;
		}

		public String CANNETTE_ENERGY_25CL;

		public String getCANNETTE_ENERGY_25CL() {
			return this.CANNETTE_ENERGY_25CL;
		}

		public String CANNETTE_SODACOLA_25CL;

		public String getCANNETTE_SODACOLA_25CL() {
			return this.CANNETTE_SODACOLA_25CL;
		}

		public String CANNETTE_BG_25CL;

		public String getCANNETTE_BG_25CL() {
			return this.CANNETTE_BG_25CL;
		}

		public String Canette;

		public String getCanette() {
			return this.Canette;
		}

		public String CU;

		public String getCU() {
			return this.CU;
		}

		public String CV;

		public String getCV() {
			return this.CV;
		}

		public String CW;

		public String getCW() {
			return this.CW;
		}

		public String CX;

		public String getCX() {
			return this.CX;
		}

		public String CY;

		public String getCY() {
			return this.CY;
		}

		public String CZ;

		public String getCZ() {
			return this.CZ;
		}

		public String DA;

		public String getDA() {
			return this.DA;
		}

		public String DB;

		public String getDB() {
			return this.DB;
		}

		public String DC;

		public String getDC() {
			return this.DC;
		}

		public String DD;

		public String getDD() {
			return this.DD;
		}

		public String DE;

		public String getDE() {
			return this.DE;
		}

		public String DF;

		public String getDF() {
			return this.DF;
		}

		public String DG;

		public String getDG() {
			return this.DG;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_KEYRUS_ReadFile_V04_2.length) {
					if (length < 1024 && commonByteArray_KEYRUS_ReadFile_V04_2.length == 0) {
						commonByteArray_KEYRUS_ReadFile_V04_2 = new byte[1024];
					} else {
						commonByteArray_KEYRUS_ReadFile_V04_2 = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_KEYRUS_ReadFile_V04_2, 0, length);
				strReturn = new String(commonByteArray_KEYRUS_ReadFile_V04_2, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_KEYRUS_ReadFile_V04_2.length) {
					if (length < 1024 && commonByteArray_KEYRUS_ReadFile_V04_2.length == 0) {
						commonByteArray_KEYRUS_ReadFile_V04_2 = new byte[1024];
					} else {
						commonByteArray_KEYRUS_ReadFile_V04_2 = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_KEYRUS_ReadFile_V04_2, 0, length);
				strReturn = new String(commonByteArray_KEYRUS_ReadFile_V04_2, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		private Integer readInteger(ObjectInputStream dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException {
			if (intNum == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeInt(intNum);
			}
		}

		private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (intNum == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeInt(intNum);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_KEYRUS_ReadFile_V04_2) {

				try {

					int length = 0;

					this.Sem = readString(dis);

					this.Day = readString(dis);

					this.Date = readString(dis);

					this.Van = readString(dis);

					this.PET_EMN_33CL = readString(dis);

					this.PET_EMN_33CL_B_S_Junior = readString(dis);

					this.PET_EMN_50CL = readString(dis);

					this.PET_EMN_50CL_B_S = readString(dis);

					this.PET_EMN_150CL = readString(dis);

					this.Eau_Minerale_Naturelle = readString(dis);

					this.PET_EMG_33CL = readString(dis);

					this.PET_EMG_50CL = readString(dis);

					this.PET_EMG_100CL = readString(dis);

					this.Eau_Minerale_Gazifiee = readString(dis);

					this.PET_SODA_PREMIUM_33CL = readString(dis);

					this.PET_SODA_PREMIUM_100CL = readString(dis);

					this.PET_SODA_PREMIUM_150CL = readString(dis);

					this.PET_SODA_PREMIUM_200CL = readString(dis);

					this.IFRI_GAZOUZ = readString(dis);

					this.PET_SODA_COLA_33CL = readString(dis);

					this.PET_SODA_COLA_100CL = readString(dis);

					this.PET_SODA_COLA_150CL = readString(dis);

					this.PET_SODA_COLA_200CL = readString(dis);

					this.SODA_COLA = readString(dis);

					this.PET_EF_P_tifruit_20CL = readString(dis);

					this.PET_EF_33CL = readString(dis);

					this.PET_EF_100CL = readString(dis);

					this.PET_EF_150CL = readString(dis);

					this.PET_EF_200CL = readString(dis);

					this.PET_EF_Unknown = readString(dis);

					this.Eaux_Fruites = readString(dis);

					this.PET_EFL_P_tifruit_20CL = readString(dis);

					this.PET_EFL_20CL = readString(dis);

					this.PET_EFL_33CL = readString(dis);

					this.PET_EFL_100CL = readString(dis);

					this.PET_EFL_150CL = readString(dis);

					this.Eaux_Fruites_au_Lait = readString(dis);

					this.PET_SPORTDRINK_50CL = readString(dis);

					this.PET_SPORTDRINK_Unknown = readString(dis);

					this.SPORT_Drink = readString(dis);

					this.PET_JUSPUR_20CL = readString(dis);

					this.PET_JUSPUR_100CL = readString(dis);

					this.JUS_PUR = readString(dis);

					this.PET_BEIZEM_33CL = readString(dis);

					this.PET_BEIZEM_Unknown = readString(dis);

					this.Boisson_Energisante_IZEM = readString(dis);

					this.PET_EFG_25CL = readString(dis);

					this.PET_EFG_33CL = readString(dis);

					this.PET_EFG_100CL = readString(dis);

					this.PET_EFG_150CL = readString(dis);

					this.EAUX_FRUITEES_GAZEIFIEES = readString(dis);

					this.PET_ICETHE_25CL = readString(dis);

					this.PET_ICETHE_100CL = readString(dis);

					this.PET_ICETHE_150CL = readString(dis);

					this.ICE_THE_PET = readString(dis);

					this.PET = readString(dis);

					this.VERRE_EMN_25CL = readString(dis);

					this.VERRE_EMN_50CL = readString(dis);

					this.VERRE_EMN_100CL = readString(dis);

					this.Eau_Minerale_Verre = readString(dis);

					this.VERRE_EMG_25CL = readString(dis);

					this.VERRE_EMG_50CL = readString(dis);

					this.VERRE_EMG_100CL = readString(dis);

					this.Eau_Minerale_Gazifiee_Verre = readString(dis);

					this.VERRE_SODA_25CL = readString(dis);

					this.VERRE_SODA_100CL = readString(dis);

					this.SODA_Verre = readString(dis);

					this.VERRE_SODACOLA_25CL = readString(dis);

					this.VERRE_SODACOLA_100CL = readString(dis);

					this.SODA_COLA_Verre = readString(dis);

					this.VERRE_EF_25CL = readString(dis);

					this.VERRE_EF_Unknown = readString(dis);

					this.Eaux_Fruitees_Verre = readString(dis);

					this.VERRE_EFL_25CL = readString(dis);

					this.VERRE_EFL_Unknown = readString(dis);

					this.Eaux_Fruitees_Au_LaitVerre = readString(dis);

					this.VERRE_CF_25CL = readString(dis);

					this.VERRE_CF_Unknown = readString(dis);

					this.Cocktail_de_Fruits_Verre = readString(dis);

					this.VERRE_BOISSON_25CL = readString(dis);

					this.VERRE_BOISSON_Unknown = readString(dis);

					this.Boisson_Verre = readInteger(dis);

					this.VERRE_IZEM_25CL = readString(dis);

					this.IZEM_Verre = readInteger(dis);

					this.VERRE_BG_25CL = readString(dis);

					this.VERRE_BG_Unknown = readString(dis);

					this.BOISSON_GAZEIFIEE_VERRE = readInteger(dis);

					this.VERRE_ICETHE_25CL = readString(dis);

					this.VERRE_ICETHE_Unknown = readString(dis);

					this.ICE_THE_VERRE = readString(dis);

					this.Verre = readString(dis);

					this.CANNETTE_SODA_33CL = readString(dis);

					this.CANNETTE_JUS_33CL = readString(dis);

					this.CANNETTE_ENERGY_25CL = readString(dis);

					this.CANNETTE_SODACOLA_25CL = readString(dis);

					this.CANNETTE_BG_25CL = readString(dis);

					this.Canette = readString(dis);

					this.CU = readString(dis);

					this.CV = readString(dis);

					this.CW = readString(dis);

					this.CX = readString(dis);

					this.CY = readString(dis);

					this.CZ = readString(dis);

					this.DA = readString(dis);

					this.DB = readString(dis);

					this.DC = readString(dis);

					this.DD = readString(dis);

					this.DE = readString(dis);

					this.DF = readString(dis);

					this.DG = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_KEYRUS_ReadFile_V04_2) {

				try {

					int length = 0;

					this.Sem = readString(dis);

					this.Day = readString(dis);

					this.Date = readString(dis);

					this.Van = readString(dis);

					this.PET_EMN_33CL = readString(dis);

					this.PET_EMN_33CL_B_S_Junior = readString(dis);

					this.PET_EMN_50CL = readString(dis);

					this.PET_EMN_50CL_B_S = readString(dis);

					this.PET_EMN_150CL = readString(dis);

					this.Eau_Minerale_Naturelle = readString(dis);

					this.PET_EMG_33CL = readString(dis);

					this.PET_EMG_50CL = readString(dis);

					this.PET_EMG_100CL = readString(dis);

					this.Eau_Minerale_Gazifiee = readString(dis);

					this.PET_SODA_PREMIUM_33CL = readString(dis);

					this.PET_SODA_PREMIUM_100CL = readString(dis);

					this.PET_SODA_PREMIUM_150CL = readString(dis);

					this.PET_SODA_PREMIUM_200CL = readString(dis);

					this.IFRI_GAZOUZ = readString(dis);

					this.PET_SODA_COLA_33CL = readString(dis);

					this.PET_SODA_COLA_100CL = readString(dis);

					this.PET_SODA_COLA_150CL = readString(dis);

					this.PET_SODA_COLA_200CL = readString(dis);

					this.SODA_COLA = readString(dis);

					this.PET_EF_P_tifruit_20CL = readString(dis);

					this.PET_EF_33CL = readString(dis);

					this.PET_EF_100CL = readString(dis);

					this.PET_EF_150CL = readString(dis);

					this.PET_EF_200CL = readString(dis);

					this.PET_EF_Unknown = readString(dis);

					this.Eaux_Fruites = readString(dis);

					this.PET_EFL_P_tifruit_20CL = readString(dis);

					this.PET_EFL_20CL = readString(dis);

					this.PET_EFL_33CL = readString(dis);

					this.PET_EFL_100CL = readString(dis);

					this.PET_EFL_150CL = readString(dis);

					this.Eaux_Fruites_au_Lait = readString(dis);

					this.PET_SPORTDRINK_50CL = readString(dis);

					this.PET_SPORTDRINK_Unknown = readString(dis);

					this.SPORT_Drink = readString(dis);

					this.PET_JUSPUR_20CL = readString(dis);

					this.PET_JUSPUR_100CL = readString(dis);

					this.JUS_PUR = readString(dis);

					this.PET_BEIZEM_33CL = readString(dis);

					this.PET_BEIZEM_Unknown = readString(dis);

					this.Boisson_Energisante_IZEM = readString(dis);

					this.PET_EFG_25CL = readString(dis);

					this.PET_EFG_33CL = readString(dis);

					this.PET_EFG_100CL = readString(dis);

					this.PET_EFG_150CL = readString(dis);

					this.EAUX_FRUITEES_GAZEIFIEES = readString(dis);

					this.PET_ICETHE_25CL = readString(dis);

					this.PET_ICETHE_100CL = readString(dis);

					this.PET_ICETHE_150CL = readString(dis);

					this.ICE_THE_PET = readString(dis);

					this.PET = readString(dis);

					this.VERRE_EMN_25CL = readString(dis);

					this.VERRE_EMN_50CL = readString(dis);

					this.VERRE_EMN_100CL = readString(dis);

					this.Eau_Minerale_Verre = readString(dis);

					this.VERRE_EMG_25CL = readString(dis);

					this.VERRE_EMG_50CL = readString(dis);

					this.VERRE_EMG_100CL = readString(dis);

					this.Eau_Minerale_Gazifiee_Verre = readString(dis);

					this.VERRE_SODA_25CL = readString(dis);

					this.VERRE_SODA_100CL = readString(dis);

					this.SODA_Verre = readString(dis);

					this.VERRE_SODACOLA_25CL = readString(dis);

					this.VERRE_SODACOLA_100CL = readString(dis);

					this.SODA_COLA_Verre = readString(dis);

					this.VERRE_EF_25CL = readString(dis);

					this.VERRE_EF_Unknown = readString(dis);

					this.Eaux_Fruitees_Verre = readString(dis);

					this.VERRE_EFL_25CL = readString(dis);

					this.VERRE_EFL_Unknown = readString(dis);

					this.Eaux_Fruitees_Au_LaitVerre = readString(dis);

					this.VERRE_CF_25CL = readString(dis);

					this.VERRE_CF_Unknown = readString(dis);

					this.Cocktail_de_Fruits_Verre = readString(dis);

					this.VERRE_BOISSON_25CL = readString(dis);

					this.VERRE_BOISSON_Unknown = readString(dis);

					this.Boisson_Verre = readInteger(dis);

					this.VERRE_IZEM_25CL = readString(dis);

					this.IZEM_Verre = readInteger(dis);

					this.VERRE_BG_25CL = readString(dis);

					this.VERRE_BG_Unknown = readString(dis);

					this.BOISSON_GAZEIFIEE_VERRE = readInteger(dis);

					this.VERRE_ICETHE_25CL = readString(dis);

					this.VERRE_ICETHE_Unknown = readString(dis);

					this.ICE_THE_VERRE = readString(dis);

					this.Verre = readString(dis);

					this.CANNETTE_SODA_33CL = readString(dis);

					this.CANNETTE_JUS_33CL = readString(dis);

					this.CANNETTE_ENERGY_25CL = readString(dis);

					this.CANNETTE_SODACOLA_25CL = readString(dis);

					this.CANNETTE_BG_25CL = readString(dis);

					this.Canette = readString(dis);

					this.CU = readString(dis);

					this.CV = readString(dis);

					this.CW = readString(dis);

					this.CX = readString(dis);

					this.CY = readString(dis);

					this.CZ = readString(dis);

					this.DA = readString(dis);

					this.DB = readString(dis);

					this.DC = readString(dis);

					this.DD = readString(dis);

					this.DE = readString(dis);

					this.DF = readString(dis);

					this.DG = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.Sem, dos);

				// String

				writeString(this.Day, dos);

				// String

				writeString(this.Date, dos);

				// String

				writeString(this.Van, dos);

				// String

				writeString(this.PET_EMN_33CL, dos);

				// String

				writeString(this.PET_EMN_33CL_B_S_Junior, dos);

				// String

				writeString(this.PET_EMN_50CL, dos);

				// String

				writeString(this.PET_EMN_50CL_B_S, dos);

				// String

				writeString(this.PET_EMN_150CL, dos);

				// String

				writeString(this.Eau_Minerale_Naturelle, dos);

				// String

				writeString(this.PET_EMG_33CL, dos);

				// String

				writeString(this.PET_EMG_50CL, dos);

				// String

				writeString(this.PET_EMG_100CL, dos);

				// String

				writeString(this.Eau_Minerale_Gazifiee, dos);

				// String

				writeString(this.PET_SODA_PREMIUM_33CL, dos);

				// String

				writeString(this.PET_SODA_PREMIUM_100CL, dos);

				// String

				writeString(this.PET_SODA_PREMIUM_150CL, dos);

				// String

				writeString(this.PET_SODA_PREMIUM_200CL, dos);

				// String

				writeString(this.IFRI_GAZOUZ, dos);

				// String

				writeString(this.PET_SODA_COLA_33CL, dos);

				// String

				writeString(this.PET_SODA_COLA_100CL, dos);

				// String

				writeString(this.PET_SODA_COLA_150CL, dos);

				// String

				writeString(this.PET_SODA_COLA_200CL, dos);

				// String

				writeString(this.SODA_COLA, dos);

				// String

				writeString(this.PET_EF_P_tifruit_20CL, dos);

				// String

				writeString(this.PET_EF_33CL, dos);

				// String

				writeString(this.PET_EF_100CL, dos);

				// String

				writeString(this.PET_EF_150CL, dos);

				// String

				writeString(this.PET_EF_200CL, dos);

				// String

				writeString(this.PET_EF_Unknown, dos);

				// String

				writeString(this.Eaux_Fruites, dos);

				// String

				writeString(this.PET_EFL_P_tifruit_20CL, dos);

				// String

				writeString(this.PET_EFL_20CL, dos);

				// String

				writeString(this.PET_EFL_33CL, dos);

				// String

				writeString(this.PET_EFL_100CL, dos);

				// String

				writeString(this.PET_EFL_150CL, dos);

				// String

				writeString(this.Eaux_Fruites_au_Lait, dos);

				// String

				writeString(this.PET_SPORTDRINK_50CL, dos);

				// String

				writeString(this.PET_SPORTDRINK_Unknown, dos);

				// String

				writeString(this.SPORT_Drink, dos);

				// String

				writeString(this.PET_JUSPUR_20CL, dos);

				// String

				writeString(this.PET_JUSPUR_100CL, dos);

				// String

				writeString(this.JUS_PUR, dos);

				// String

				writeString(this.PET_BEIZEM_33CL, dos);

				// String

				writeString(this.PET_BEIZEM_Unknown, dos);

				// String

				writeString(this.Boisson_Energisante_IZEM, dos);

				// String

				writeString(this.PET_EFG_25CL, dos);

				// String

				writeString(this.PET_EFG_33CL, dos);

				// String

				writeString(this.PET_EFG_100CL, dos);

				// String

				writeString(this.PET_EFG_150CL, dos);

				// String

				writeString(this.EAUX_FRUITEES_GAZEIFIEES, dos);

				// String

				writeString(this.PET_ICETHE_25CL, dos);

				// String

				writeString(this.PET_ICETHE_100CL, dos);

				// String

				writeString(this.PET_ICETHE_150CL, dos);

				// String

				writeString(this.ICE_THE_PET, dos);

				// String

				writeString(this.PET, dos);

				// String

				writeString(this.VERRE_EMN_25CL, dos);

				// String

				writeString(this.VERRE_EMN_50CL, dos);

				// String

				writeString(this.VERRE_EMN_100CL, dos);

				// String

				writeString(this.Eau_Minerale_Verre, dos);

				// String

				writeString(this.VERRE_EMG_25CL, dos);

				// String

				writeString(this.VERRE_EMG_50CL, dos);

				// String

				writeString(this.VERRE_EMG_100CL, dos);

				// String

				writeString(this.Eau_Minerale_Gazifiee_Verre, dos);

				// String

				writeString(this.VERRE_SODA_25CL, dos);

				// String

				writeString(this.VERRE_SODA_100CL, dos);

				// String

				writeString(this.SODA_Verre, dos);

				// String

				writeString(this.VERRE_SODACOLA_25CL, dos);

				// String

				writeString(this.VERRE_SODACOLA_100CL, dos);

				// String

				writeString(this.SODA_COLA_Verre, dos);

				// String

				writeString(this.VERRE_EF_25CL, dos);

				// String

				writeString(this.VERRE_EF_Unknown, dos);

				// String

				writeString(this.Eaux_Fruitees_Verre, dos);

				// String

				writeString(this.VERRE_EFL_25CL, dos);

				// String

				writeString(this.VERRE_EFL_Unknown, dos);

				// String

				writeString(this.Eaux_Fruitees_Au_LaitVerre, dos);

				// String

				writeString(this.VERRE_CF_25CL, dos);

				// String

				writeString(this.VERRE_CF_Unknown, dos);

				// String

				writeString(this.Cocktail_de_Fruits_Verre, dos);

				// String

				writeString(this.VERRE_BOISSON_25CL, dos);

				// String

				writeString(this.VERRE_BOISSON_Unknown, dos);

				// Integer

				writeInteger(this.Boisson_Verre, dos);

				// String

				writeString(this.VERRE_IZEM_25CL, dos);

				// Integer

				writeInteger(this.IZEM_Verre, dos);

				// String

				writeString(this.VERRE_BG_25CL, dos);

				// String

				writeString(this.VERRE_BG_Unknown, dos);

				// Integer

				writeInteger(this.BOISSON_GAZEIFIEE_VERRE, dos);

				// String

				writeString(this.VERRE_ICETHE_25CL, dos);

				// String

				writeString(this.VERRE_ICETHE_Unknown, dos);

				// String

				writeString(this.ICE_THE_VERRE, dos);

				// String

				writeString(this.Verre, dos);

				// String

				writeString(this.CANNETTE_SODA_33CL, dos);

				// String

				writeString(this.CANNETTE_JUS_33CL, dos);

				// String

				writeString(this.CANNETTE_ENERGY_25CL, dos);

				// String

				writeString(this.CANNETTE_SODACOLA_25CL, dos);

				// String

				writeString(this.CANNETTE_BG_25CL, dos);

				// String

				writeString(this.Canette, dos);

				// String

				writeString(this.CU, dos);

				// String

				writeString(this.CV, dos);

				// String

				writeString(this.CW, dos);

				// String

				writeString(this.CX, dos);

				// String

				writeString(this.CY, dos);

				// String

				writeString(this.CZ, dos);

				// String

				writeString(this.DA, dos);

				// String

				writeString(this.DB, dos);

				// String

				writeString(this.DC, dos);

				// String

				writeString(this.DD, dos);

				// String

				writeString(this.DE, dos);

				// String

				writeString(this.DF, dos);

				// String

				writeString(this.DG, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.Sem, dos);

				// String

				writeString(this.Day, dos);

				// String

				writeString(this.Date, dos);

				// String

				writeString(this.Van, dos);

				// String

				writeString(this.PET_EMN_33CL, dos);

				// String

				writeString(this.PET_EMN_33CL_B_S_Junior, dos);

				// String

				writeString(this.PET_EMN_50CL, dos);

				// String

				writeString(this.PET_EMN_50CL_B_S, dos);

				// String

				writeString(this.PET_EMN_150CL, dos);

				// String

				writeString(this.Eau_Minerale_Naturelle, dos);

				// String

				writeString(this.PET_EMG_33CL, dos);

				// String

				writeString(this.PET_EMG_50CL, dos);

				// String

				writeString(this.PET_EMG_100CL, dos);

				// String

				writeString(this.Eau_Minerale_Gazifiee, dos);

				// String

				writeString(this.PET_SODA_PREMIUM_33CL, dos);

				// String

				writeString(this.PET_SODA_PREMIUM_100CL, dos);

				// String

				writeString(this.PET_SODA_PREMIUM_150CL, dos);

				// String

				writeString(this.PET_SODA_PREMIUM_200CL, dos);

				// String

				writeString(this.IFRI_GAZOUZ, dos);

				// String

				writeString(this.PET_SODA_COLA_33CL, dos);

				// String

				writeString(this.PET_SODA_COLA_100CL, dos);

				// String

				writeString(this.PET_SODA_COLA_150CL, dos);

				// String

				writeString(this.PET_SODA_COLA_200CL, dos);

				// String

				writeString(this.SODA_COLA, dos);

				// String

				writeString(this.PET_EF_P_tifruit_20CL, dos);

				// String

				writeString(this.PET_EF_33CL, dos);

				// String

				writeString(this.PET_EF_100CL, dos);

				// String

				writeString(this.PET_EF_150CL, dos);

				// String

				writeString(this.PET_EF_200CL, dos);

				// String

				writeString(this.PET_EF_Unknown, dos);

				// String

				writeString(this.Eaux_Fruites, dos);

				// String

				writeString(this.PET_EFL_P_tifruit_20CL, dos);

				// String

				writeString(this.PET_EFL_20CL, dos);

				// String

				writeString(this.PET_EFL_33CL, dos);

				// String

				writeString(this.PET_EFL_100CL, dos);

				// String

				writeString(this.PET_EFL_150CL, dos);

				// String

				writeString(this.Eaux_Fruites_au_Lait, dos);

				// String

				writeString(this.PET_SPORTDRINK_50CL, dos);

				// String

				writeString(this.PET_SPORTDRINK_Unknown, dos);

				// String

				writeString(this.SPORT_Drink, dos);

				// String

				writeString(this.PET_JUSPUR_20CL, dos);

				// String

				writeString(this.PET_JUSPUR_100CL, dos);

				// String

				writeString(this.JUS_PUR, dos);

				// String

				writeString(this.PET_BEIZEM_33CL, dos);

				// String

				writeString(this.PET_BEIZEM_Unknown, dos);

				// String

				writeString(this.Boisson_Energisante_IZEM, dos);

				// String

				writeString(this.PET_EFG_25CL, dos);

				// String

				writeString(this.PET_EFG_33CL, dos);

				// String

				writeString(this.PET_EFG_100CL, dos);

				// String

				writeString(this.PET_EFG_150CL, dos);

				// String

				writeString(this.EAUX_FRUITEES_GAZEIFIEES, dos);

				// String

				writeString(this.PET_ICETHE_25CL, dos);

				// String

				writeString(this.PET_ICETHE_100CL, dos);

				// String

				writeString(this.PET_ICETHE_150CL, dos);

				// String

				writeString(this.ICE_THE_PET, dos);

				// String

				writeString(this.PET, dos);

				// String

				writeString(this.VERRE_EMN_25CL, dos);

				// String

				writeString(this.VERRE_EMN_50CL, dos);

				// String

				writeString(this.VERRE_EMN_100CL, dos);

				// String

				writeString(this.Eau_Minerale_Verre, dos);

				// String

				writeString(this.VERRE_EMG_25CL, dos);

				// String

				writeString(this.VERRE_EMG_50CL, dos);

				// String

				writeString(this.VERRE_EMG_100CL, dos);

				// String

				writeString(this.Eau_Minerale_Gazifiee_Verre, dos);

				// String

				writeString(this.VERRE_SODA_25CL, dos);

				// String

				writeString(this.VERRE_SODA_100CL, dos);

				// String

				writeString(this.SODA_Verre, dos);

				// String

				writeString(this.VERRE_SODACOLA_25CL, dos);

				// String

				writeString(this.VERRE_SODACOLA_100CL, dos);

				// String

				writeString(this.SODA_COLA_Verre, dos);

				// String

				writeString(this.VERRE_EF_25CL, dos);

				// String

				writeString(this.VERRE_EF_Unknown, dos);

				// String

				writeString(this.Eaux_Fruitees_Verre, dos);

				// String

				writeString(this.VERRE_EFL_25CL, dos);

				// String

				writeString(this.VERRE_EFL_Unknown, dos);

				// String

				writeString(this.Eaux_Fruitees_Au_LaitVerre, dos);

				// String

				writeString(this.VERRE_CF_25CL, dos);

				// String

				writeString(this.VERRE_CF_Unknown, dos);

				// String

				writeString(this.Cocktail_de_Fruits_Verre, dos);

				// String

				writeString(this.VERRE_BOISSON_25CL, dos);

				// String

				writeString(this.VERRE_BOISSON_Unknown, dos);

				// Integer

				writeInteger(this.Boisson_Verre, dos);

				// String

				writeString(this.VERRE_IZEM_25CL, dos);

				// Integer

				writeInteger(this.IZEM_Verre, dos);

				// String

				writeString(this.VERRE_BG_25CL, dos);

				// String

				writeString(this.VERRE_BG_Unknown, dos);

				// Integer

				writeInteger(this.BOISSON_GAZEIFIEE_VERRE, dos);

				// String

				writeString(this.VERRE_ICETHE_25CL, dos);

				// String

				writeString(this.VERRE_ICETHE_Unknown, dos);

				// String

				writeString(this.ICE_THE_VERRE, dos);

				// String

				writeString(this.Verre, dos);

				// String

				writeString(this.CANNETTE_SODA_33CL, dos);

				// String

				writeString(this.CANNETTE_JUS_33CL, dos);

				// String

				writeString(this.CANNETTE_ENERGY_25CL, dos);

				// String

				writeString(this.CANNETTE_SODACOLA_25CL, dos);

				// String

				writeString(this.CANNETTE_BG_25CL, dos);

				// String

				writeString(this.Canette, dos);

				// String

				writeString(this.CU, dos);

				// String

				writeString(this.CV, dos);

				// String

				writeString(this.CW, dos);

				// String

				writeString(this.CX, dos);

				// String

				writeString(this.CY, dos);

				// String

				writeString(this.CZ, dos);

				// String

				writeString(this.DA, dos);

				// String

				writeString(this.DB, dos);

				// String

				writeString(this.DC, dos);

				// String

				writeString(this.DD, dos);

				// String

				writeString(this.DE, dos);

				// String

				writeString(this.DF, dos);

				// String

				writeString(this.DG, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("Sem=" + Sem);
			sb.append(",Day=" + Day);
			sb.append(",Date=" + Date);
			sb.append(",Van=" + Van);
			sb.append(",PET_EMN_33CL=" + PET_EMN_33CL);
			sb.append(",PET_EMN_33CL_B_S_Junior=" + PET_EMN_33CL_B_S_Junior);
			sb.append(",PET_EMN_50CL=" + PET_EMN_50CL);
			sb.append(",PET_EMN_50CL_B_S=" + PET_EMN_50CL_B_S);
			sb.append(",PET_EMN_150CL=" + PET_EMN_150CL);
			sb.append(",Eau_Minerale_Naturelle=" + Eau_Minerale_Naturelle);
			sb.append(",PET_EMG_33CL=" + PET_EMG_33CL);
			sb.append(",PET_EMG_50CL=" + PET_EMG_50CL);
			sb.append(",PET_EMG_100CL=" + PET_EMG_100CL);
			sb.append(",Eau_Minerale_Gazifiee=" + Eau_Minerale_Gazifiee);
			sb.append(",PET_SODA_PREMIUM_33CL=" + PET_SODA_PREMIUM_33CL);
			sb.append(",PET_SODA_PREMIUM_100CL=" + PET_SODA_PREMIUM_100CL);
			sb.append(",PET_SODA_PREMIUM_150CL=" + PET_SODA_PREMIUM_150CL);
			sb.append(",PET_SODA_PREMIUM_200CL=" + PET_SODA_PREMIUM_200CL);
			sb.append(",IFRI_GAZOUZ=" + IFRI_GAZOUZ);
			sb.append(",PET_SODA_COLA_33CL=" + PET_SODA_COLA_33CL);
			sb.append(",PET_SODA_COLA_100CL=" + PET_SODA_COLA_100CL);
			sb.append(",PET_SODA_COLA_150CL=" + PET_SODA_COLA_150CL);
			sb.append(",PET_SODA_COLA_200CL=" + PET_SODA_COLA_200CL);
			sb.append(",SODA_COLA=" + SODA_COLA);
			sb.append(",PET_EF_P_tifruit_20CL=" + PET_EF_P_tifruit_20CL);
			sb.append(",PET_EF_33CL=" + PET_EF_33CL);
			sb.append(",PET_EF_100CL=" + PET_EF_100CL);
			sb.append(",PET_EF_150CL=" + PET_EF_150CL);
			sb.append(",PET_EF_200CL=" + PET_EF_200CL);
			sb.append(",PET_EF_Unknown=" + PET_EF_Unknown);
			sb.append(",Eaux_Fruites=" + Eaux_Fruites);
			sb.append(",PET_EFL_P_tifruit_20CL=" + PET_EFL_P_tifruit_20CL);
			sb.append(",PET_EFL_20CL=" + PET_EFL_20CL);
			sb.append(",PET_EFL_33CL=" + PET_EFL_33CL);
			sb.append(",PET_EFL_100CL=" + PET_EFL_100CL);
			sb.append(",PET_EFL_150CL=" + PET_EFL_150CL);
			sb.append(",Eaux_Fruites_au_Lait=" + Eaux_Fruites_au_Lait);
			sb.append(",PET_SPORTDRINK_50CL=" + PET_SPORTDRINK_50CL);
			sb.append(",PET_SPORTDRINK_Unknown=" + PET_SPORTDRINK_Unknown);
			sb.append(",SPORT_Drink=" + SPORT_Drink);
			sb.append(",PET_JUSPUR_20CL=" + PET_JUSPUR_20CL);
			sb.append(",PET_JUSPUR_100CL=" + PET_JUSPUR_100CL);
			sb.append(",JUS_PUR=" + JUS_PUR);
			sb.append(",PET_BEIZEM_33CL=" + PET_BEIZEM_33CL);
			sb.append(",PET_BEIZEM_Unknown=" + PET_BEIZEM_Unknown);
			sb.append(",Boisson_Energisante_IZEM=" + Boisson_Energisante_IZEM);
			sb.append(",PET_EFG_25CL=" + PET_EFG_25CL);
			sb.append(",PET_EFG_33CL=" + PET_EFG_33CL);
			sb.append(",PET_EFG_100CL=" + PET_EFG_100CL);
			sb.append(",PET_EFG_150CL=" + PET_EFG_150CL);
			sb.append(",EAUX_FRUITEES_GAZEIFIEES=" + EAUX_FRUITEES_GAZEIFIEES);
			sb.append(",PET_ICETHE_25CL=" + PET_ICETHE_25CL);
			sb.append(",PET_ICETHE_100CL=" + PET_ICETHE_100CL);
			sb.append(",PET_ICETHE_150CL=" + PET_ICETHE_150CL);
			sb.append(",ICE_THE_PET=" + ICE_THE_PET);
			sb.append(",PET=" + PET);
			sb.append(",VERRE_EMN_25CL=" + VERRE_EMN_25CL);
			sb.append(",VERRE_EMN_50CL=" + VERRE_EMN_50CL);
			sb.append(",VERRE_EMN_100CL=" + VERRE_EMN_100CL);
			sb.append(",Eau_Minerale_Verre=" + Eau_Minerale_Verre);
			sb.append(",VERRE_EMG_25CL=" + VERRE_EMG_25CL);
			sb.append(",VERRE_EMG_50CL=" + VERRE_EMG_50CL);
			sb.append(",VERRE_EMG_100CL=" + VERRE_EMG_100CL);
			sb.append(",Eau_Minerale_Gazifiee_Verre=" + Eau_Minerale_Gazifiee_Verre);
			sb.append(",VERRE_SODA_25CL=" + VERRE_SODA_25CL);
			sb.append(",VERRE_SODA_100CL=" + VERRE_SODA_100CL);
			sb.append(",SODA_Verre=" + SODA_Verre);
			sb.append(",VERRE_SODACOLA_25CL=" + VERRE_SODACOLA_25CL);
			sb.append(",VERRE_SODACOLA_100CL=" + VERRE_SODACOLA_100CL);
			sb.append(",SODA_COLA_Verre=" + SODA_COLA_Verre);
			sb.append(",VERRE_EF_25CL=" + VERRE_EF_25CL);
			sb.append(",VERRE_EF_Unknown=" + VERRE_EF_Unknown);
			sb.append(",Eaux_Fruitees_Verre=" + Eaux_Fruitees_Verre);
			sb.append(",VERRE_EFL_25CL=" + VERRE_EFL_25CL);
			sb.append(",VERRE_EFL_Unknown=" + VERRE_EFL_Unknown);
			sb.append(",Eaux_Fruitees_Au_LaitVerre=" + Eaux_Fruitees_Au_LaitVerre);
			sb.append(",VERRE_CF_25CL=" + VERRE_CF_25CL);
			sb.append(",VERRE_CF_Unknown=" + VERRE_CF_Unknown);
			sb.append(",Cocktail_de_Fruits_Verre=" + Cocktail_de_Fruits_Verre);
			sb.append(",VERRE_BOISSON_25CL=" + VERRE_BOISSON_25CL);
			sb.append(",VERRE_BOISSON_Unknown=" + VERRE_BOISSON_Unknown);
			sb.append(",Boisson_Verre=" + String.valueOf(Boisson_Verre));
			sb.append(",VERRE_IZEM_25CL=" + VERRE_IZEM_25CL);
			sb.append(",IZEM_Verre=" + String.valueOf(IZEM_Verre));
			sb.append(",VERRE_BG_25CL=" + VERRE_BG_25CL);
			sb.append(",VERRE_BG_Unknown=" + VERRE_BG_Unknown);
			sb.append(",BOISSON_GAZEIFIEE_VERRE=" + String.valueOf(BOISSON_GAZEIFIEE_VERRE));
			sb.append(",VERRE_ICETHE_25CL=" + VERRE_ICETHE_25CL);
			sb.append(",VERRE_ICETHE_Unknown=" + VERRE_ICETHE_Unknown);
			sb.append(",ICE_THE_VERRE=" + ICE_THE_VERRE);
			sb.append(",Verre=" + Verre);
			sb.append(",CANNETTE_SODA_33CL=" + CANNETTE_SODA_33CL);
			sb.append(",CANNETTE_JUS_33CL=" + CANNETTE_JUS_33CL);
			sb.append(",CANNETTE_ENERGY_25CL=" + CANNETTE_ENERGY_25CL);
			sb.append(",CANNETTE_SODACOLA_25CL=" + CANNETTE_SODACOLA_25CL);
			sb.append(",CANNETTE_BG_25CL=" + CANNETTE_BG_25CL);
			sb.append(",Canette=" + Canette);
			sb.append(",CU=" + CU);
			sb.append(",CV=" + CV);
			sb.append(",CW=" + CW);
			sb.append(",CX=" + CX);
			sb.append(",CY=" + CY);
			sb.append(",CZ=" + CZ);
			sb.append(",DA=" + DA);
			sb.append(",DB=" + DB);
			sb.append(",DC=" + DC);
			sb.append(",DD=" + DD);
			sb.append(",DE=" + DE);
			sb.append(",DF=" + DF);
			sb.append(",DG=" + DG);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row1Struct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public void tFileList_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tFileList_1_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;
		String currentVirtualComponent = null;

		String iterateId = "";

		String currentComponent = "";
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				row1Struct row1 = new row1Struct();
				out10Struct out10 = new out10Struct();
				row2Struct row2 = new row2Struct();
				row6Struct row6 = new row6Struct();
				row7Struct row7 = new row7Struct();
				row8Struct row8 = new row8Struct();
				row3Struct row3 = new row3Struct();

				/**
				 * [tFileList_1 begin ] start
				 */

				int NB_ITERATE_tFileInputExcel_1 = 0; // for statistics

				ok_Hash.put("tFileList_1", false);
				start_Hash.put("tFileList_1", System.currentTimeMillis());

				currentComponent = "tFileList_1";

				int tos_count_tFileList_1 = 0;

				String directory_tFileList_1 = context.pathFile + "V04";
				final java.util.List<String> maskList_tFileList_1 = new java.util.ArrayList<String>();
				final java.util.List<java.util.regex.Pattern> patternList_tFileList_1 = new java.util.ArrayList<java.util.regex.Pattern>();
				maskList_tFileList_1.add("Pilotage*");
				for (final String filemask_tFileList_1 : maskList_tFileList_1) {
					String filemask_compile_tFileList_1 = filemask_tFileList_1;

					filemask_compile_tFileList_1 = org.apache.oro.text.GlobCompiler.globToPerl5(
							filemask_tFileList_1.toCharArray(), org.apache.oro.text.GlobCompiler.DEFAULT_MASK);

					java.util.regex.Pattern fileNamePattern_tFileList_1 = java.util.regex.Pattern
							.compile(filemask_compile_tFileList_1, java.util.regex.Pattern.CASE_INSENSITIVE);

					patternList_tFileList_1.add(fileNamePattern_tFileList_1);
				}
				int NB_FILEtFileList_1 = 0;

				final boolean case_sensitive_tFileList_1 = false;

				final java.util.List<java.io.File> list_tFileList_1 = new java.util.ArrayList<java.io.File>();
				final java.util.Set<String> filePath_tFileList_1 = new java.util.HashSet<String>();
				java.io.File file_tFileList_1 = new java.io.File(directory_tFileList_1);

				file_tFileList_1.listFiles(new java.io.FilenameFilter() {
					public boolean accept(java.io.File dir, String name) {
						java.io.File file = new java.io.File(dir, name);

						if (!file.isDirectory()) {

							String fileName_tFileList_1 = file.getName();
							for (final java.util.regex.Pattern fileNamePattern_tFileList_1 : patternList_tFileList_1) {
								if (fileNamePattern_tFileList_1.matcher(fileName_tFileList_1).matches()) {
									if (!filePath_tFileList_1.contains(file.getAbsolutePath())) {
										list_tFileList_1.add(file);
										filePath_tFileList_1.add(file.getAbsolutePath());
									}
								}
							}
							return true;
						} else {
							file.listFiles(this);
						}

						return false;
					}
				});
				java.util.Collections.sort(list_tFileList_1);

				for (int i_tFileList_1 = 0; i_tFileList_1 < list_tFileList_1.size(); i_tFileList_1++) {
					java.io.File files_tFileList_1 = list_tFileList_1.get(i_tFileList_1);
					String fileName_tFileList_1 = files_tFileList_1.getName();

					String currentFileName_tFileList_1 = files_tFileList_1.getName();
					String currentFilePath_tFileList_1 = files_tFileList_1.getAbsolutePath();
					String currentFileDirectory_tFileList_1 = files_tFileList_1.getParent();
					String currentFileExtension_tFileList_1 = null;

					if (files_tFileList_1.getName().contains(".") && files_tFileList_1.isFile()) {
						currentFileExtension_tFileList_1 = files_tFileList_1.getName()
								.substring(files_tFileList_1.getName().lastIndexOf(".") + 1);
					} else {
						currentFileExtension_tFileList_1 = "";
					}

					NB_FILEtFileList_1++;
					globalMap.put("tFileList_1_CURRENT_FILE", currentFileName_tFileList_1);
					globalMap.put("tFileList_1_CURRENT_FILEPATH", currentFilePath_tFileList_1);
					globalMap.put("tFileList_1_CURRENT_FILEDIRECTORY", currentFileDirectory_tFileList_1);
					globalMap.put("tFileList_1_CURRENT_FILEEXTENSION", currentFileExtension_tFileList_1);
					globalMap.put("tFileList_1_NB_FILE", NB_FILEtFileList_1);

					/**
					 * [tFileList_1 begin ] stop
					 */

					/**
					 * [tFileList_1 main ] start
					 */

					currentComponent = "tFileList_1";

					tos_count_tFileList_1++;

					/**
					 * [tFileList_1 main ] stop
					 */

					/**
					 * [tFileList_1 process_data_begin ] start
					 */

					currentComponent = "tFileList_1";

					/**
					 * [tFileList_1 process_data_begin ] stop
					 */
					NB_ITERATE_tFileInputExcel_1++;

					if (execStat) {
						runStat.updateStatOnConnection("row7", 3, 0);
					}

					if (execStat) {
						runStat.updateStatOnConnection("row6", 3, 0);
					}

					if (execStat) {
						runStat.updateStatOnConnection("OnRowsEnd", 3, 0);
					}

					if (execStat) {
						runStat.updateStatOnConnection("row1", 3, 0);
					}

					if (execStat) {
						runStat.updateStatOnConnection("row2", 3, 0);
					}

					if (execStat) {
						runStat.updateStatOnConnection("row3", 3, 0);
					}

					if (execStat) {
						runStat.updateStatOnConnection("out10", 3, 0);
					}

					if (execStat) {
						runStat.updateStatOnConnection("row8", 3, 0);
					}

					if (execStat) {
						runStat.updateStatOnConnection("iterate1", 1, "exec" + NB_ITERATE_tFileInputExcel_1);
						// Thread.sleep(1000);
					}

					/**
					 * [tSortRow_2_SortOut begin ] start
					 */

					ok_Hash.put("tSortRow_2_SortOut", false);
					start_Hash.put("tSortRow_2_SortOut", System.currentTimeMillis());

					currentVirtualComponent = "tSortRow_2";

					currentComponent = "tSortRow_2_SortOut";

					if (execStat) {
						runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row2");
					}

					int tos_count_tSortRow_2_SortOut = 0;

					class Comparablerow2Struct extends row2Struct implements Comparable<Comparablerow2Struct> {

						public int compareTo(Comparablerow2Struct other) {

							if (this.ID == null && other.ID != null) {
								return -1;

							} else if (this.ID != null && other.ID == null) {
								return 1;

							} else if (this.ID != null && other.ID != null) {
								if (!this.ID.equals(other.ID)) {
									return this.ID.compareTo(other.ID);
								}
							}
							if (this.Van == null && other.Van != null) {
								return 1;

							} else if (this.Van != null && other.Van == null) {
								return -1;

							} else if (this.Van != null && other.Van != null) {
								if (!this.Van.equals(other.Van)) {
									return other.Van.compareTo(this.Van);
								}
							}
							return 0;
						}
					}

					java.util.List<Comparablerow2Struct> list_tSortRow_2_SortOut = new java.util.ArrayList<Comparablerow2Struct>();

					/**
					 * [tSortRow_2_SortOut begin ] stop
					 */

					/**
					 * [tJavaFlex_3 begin ] start
					 */

					ok_Hash.put("tJavaFlex_3", false);
					start_Hash.put("tJavaFlex_3", System.currentTimeMillis());

					currentComponent = "tJavaFlex_3";

					if (execStat) {
						runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "out10");
					}

					int tos_count_tJavaFlex_3 = 0;

// start part of your Java code
					int id = 0;
					String Weekd = "";
					String Vand = "";

					/**
					 * [tJavaFlex_3 begin ] stop
					 */

					/**
					 * [tMap_2 begin ] start
					 */

					ok_Hash.put("tMap_2", false);
					start_Hash.put("tMap_2", System.currentTimeMillis());

					currentComponent = "tMap_2";

					if (execStat) {
						runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row1");
					}

					int tos_count_tMap_2 = 0;

// ###############################
// # Lookup's keys initialization
// ###############################        

// ###############################
// # Vars initialization
					class Var__tMap_2__Struct {
					}
					Var__tMap_2__Struct Var__tMap_2 = new Var__tMap_2__Struct();
// ###############################

// ###############################
// # Outputs initialization
					out10Struct out10_tmp = new out10Struct();
// ###############################

					/**
					 * [tMap_2 begin ] stop
					 */

					/**
					 * [tFileInputExcel_1 begin ] start
					 */

					ok_Hash.put("tFileInputExcel_1", false);
					start_Hash.put("tFileInputExcel_1", System.currentTimeMillis());

					currentComponent = "tFileInputExcel_1";

					int tos_count_tFileInputExcel_1 = 0;

					final String decryptedPassword_tFileInputExcel_1 = routines.system.PasswordEncryptUtil
							.decryptPassword("enc:routine.encryption.key.v1:xClQLbs1wLb+J3F5Mz6ZyQBe2+UAuc2iZnH3Aw==");
					String password_tFileInputExcel_1 = decryptedPassword_tFileInputExcel_1;
					if (password_tFileInputExcel_1.isEmpty()) {
						password_tFileInputExcel_1 = null;
					}
					class RegexUtil_tFileInputExcel_1 {

						public java.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> getSheets(
								org.apache.poi.xssf.usermodel.XSSFWorkbook workbook, String oneSheetName,
								boolean useRegex) {

							java.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> list = new java.util.ArrayList<org.apache.poi.xssf.usermodel.XSSFSheet>();

							if (useRegex) {// this part process the regex issue

								java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(oneSheetName);
								for (org.apache.poi.ss.usermodel.Sheet sheet : workbook) {
									String sheetName = sheet.getSheetName();
									java.util.regex.Matcher matcher = pattern.matcher(sheetName);
									if (matcher.matches()) {
										if (sheet != null) {
											list.add((org.apache.poi.xssf.usermodel.XSSFSheet) sheet);
										}
									}
								}

							} else {
								org.apache.poi.xssf.usermodel.XSSFSheet sheet = (org.apache.poi.xssf.usermodel.XSSFSheet) workbook
										.getSheet(oneSheetName);
								if (sheet != null) {
									list.add(sheet);
								}

							}

							return list;
						}

						public java.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> getSheets(
								org.apache.poi.xssf.usermodel.XSSFWorkbook workbook, int index, boolean useRegex) {
							java.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> list = new java.util.ArrayList<org.apache.poi.xssf.usermodel.XSSFSheet>();
							org.apache.poi.xssf.usermodel.XSSFSheet sheet = (org.apache.poi.xssf.usermodel.XSSFSheet) workbook
									.getSheetAt(index);
							if (sheet != null) {
								list.add(sheet);
							}
							return list;
						}

					}
					RegexUtil_tFileInputExcel_1 regexUtil_tFileInputExcel_1 = new RegexUtil_tFileInputExcel_1();

					Object source_tFileInputExcel_1 = ((String) globalMap.get("tFileList_1_CURRENT_FILEPATH"));
					org.apache.poi.xssf.usermodel.XSSFWorkbook workbook_tFileInputExcel_1 = null;

					if (source_tFileInputExcel_1 instanceof String) {
						workbook_tFileInputExcel_1 = (org.apache.poi.xssf.usermodel.XSSFWorkbook) org.apache.poi.ss.usermodel.WorkbookFactory
								.create(new java.io.File((String) source_tFileInputExcel_1), password_tFileInputExcel_1,
										true);
					} else if (source_tFileInputExcel_1 instanceof java.io.InputStream) {
						workbook_tFileInputExcel_1 = (org.apache.poi.xssf.usermodel.XSSFWorkbook) org.apache.poi.ss.usermodel.WorkbookFactory
								.create((java.io.InputStream) source_tFileInputExcel_1, password_tFileInputExcel_1);
					} else {
						workbook_tFileInputExcel_1 = null;
						throw new java.lang.Exception(
								"The data source should be specified as Inputstream or File Path!");
					}
					try {

						java.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> sheetList_tFileInputExcel_1 = new java.util.ArrayList<org.apache.poi.xssf.usermodel.XSSFSheet>();
						sheetList_tFileInputExcel_1.addAll(regexUtil_tFileInputExcel_1
								.getSheets(workbook_tFileInputExcel_1, "Saisie Ventes DD & Moderne", false));
						sheetList_tFileInputExcel_1.addAll(
								regexUtil_tFileInputExcel_1.getSheets(workbook_tFileInputExcel_1, "Gros", false));
						if (sheetList_tFileInputExcel_1.size() <= 0) {
							throw new RuntimeException("Special sheets not exist!");
						}

						java.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> sheetList_FilterNull_tFileInputExcel_1 = new java.util.ArrayList<org.apache.poi.xssf.usermodel.XSSFSheet>();
						for (org.apache.poi.xssf.usermodel.XSSFSheet sheet_FilterNull_tFileInputExcel_1 : sheetList_tFileInputExcel_1) {
							if (sheet_FilterNull_tFileInputExcel_1 != null
									&& sheetList_FilterNull_tFileInputExcel_1.iterator() != null
									&& sheet_FilterNull_tFileInputExcel_1.iterator().hasNext()) {
								sheetList_FilterNull_tFileInputExcel_1.add(sheet_FilterNull_tFileInputExcel_1);
							}
						}
						sheetList_tFileInputExcel_1 = sheetList_FilterNull_tFileInputExcel_1;
						if (sheetList_tFileInputExcel_1.size() > 0) {
							int nb_line_tFileInputExcel_1 = 0;

							int begin_line_tFileInputExcel_1 = 4;

							int footer_input_tFileInputExcel_1 = 0;

							int end_line_tFileInputExcel_1 = 0;
							for (org.apache.poi.xssf.usermodel.XSSFSheet sheet_tFileInputExcel_1 : sheetList_tFileInputExcel_1) {
								end_line_tFileInputExcel_1 += (sheet_tFileInputExcel_1.getLastRowNum() + 1);
							}
							end_line_tFileInputExcel_1 -= footer_input_tFileInputExcel_1;
							int limit_tFileInputExcel_1 = -1;
							int start_column_tFileInputExcel_1 = 2 - 1;
							int end_column_tFileInputExcel_1 = -1;
							Integer lastColumn_tFileInputExcel_1 = 111;
							if (lastColumn_tFileInputExcel_1 != null) {
								end_column_tFileInputExcel_1 = lastColumn_tFileInputExcel_1.intValue();
							}

							org.apache.poi.xssf.usermodel.XSSFRow row_tFileInputExcel_1 = null;
							org.apache.poi.xssf.usermodel.XSSFSheet sheet_tFileInputExcel_1 = sheetList_tFileInputExcel_1
									.get(0);
							int rowCount_tFileInputExcel_1 = 0;
							int sheetIndex_tFileInputExcel_1 = 0;
							int currentRows_tFileInputExcel_1 = (sheetList_tFileInputExcel_1.get(0).getLastRowNum()
									+ 1);

							// for the number format
							java.text.DecimalFormat df_tFileInputExcel_1 = new java.text.DecimalFormat(
									"#.####################################");
							char decimalChar_tFileInputExcel_1 = df_tFileInputExcel_1.getDecimalFormatSymbols()
									.getDecimalSeparator();

							for (int i_tFileInputExcel_1 = begin_line_tFileInputExcel_1; i_tFileInputExcel_1 < end_line_tFileInputExcel_1; i_tFileInputExcel_1++) {

								int emptyColumnCount_tFileInputExcel_1 = 0;

								if (limit_tFileInputExcel_1 != -1
										&& nb_line_tFileInputExcel_1 >= limit_tFileInputExcel_1) {
									break;
								}

								while (i_tFileInputExcel_1 >= rowCount_tFileInputExcel_1
										+ currentRows_tFileInputExcel_1) {
									rowCount_tFileInputExcel_1 += currentRows_tFileInputExcel_1;
									sheet_tFileInputExcel_1 = sheetList_tFileInputExcel_1
											.get(++sheetIndex_tFileInputExcel_1);
									currentRows_tFileInputExcel_1 = (sheet_tFileInputExcel_1.getLastRowNum() + 1);
								}
								globalMap.put("tFileInputExcel_1_CURRENT_SHEET",
										sheet_tFileInputExcel_1.getSheetName());
								if (rowCount_tFileInputExcel_1 <= i_tFileInputExcel_1
										&& i_tFileInputExcel_1
												- rowCount_tFileInputExcel_1 >= (begin_line_tFileInputExcel_1)
										&& currentRows_tFileInputExcel_1
												- footer_input_tFileInputExcel_1 > i_tFileInputExcel_1
														- rowCount_tFileInputExcel_1) {
									row_tFileInputExcel_1 = sheet_tFileInputExcel_1
											.getRow(i_tFileInputExcel_1 - rowCount_tFileInputExcel_1);
								} else {
									continue;
								}
								row1 = null;
								int tempRowLength_tFileInputExcel_1 = 110;

								int columnIndex_tFileInputExcel_1 = 0;

								String[] temp_row_tFileInputExcel_1 = new String[tempRowLength_tFileInputExcel_1];
								List<Boolean> datelist_tFileInputExcel_1 = new java.util.ArrayList<Boolean>();
								List<String> patternlist_tFileInputExcel_1 = new java.util.ArrayList<String>();
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(true);
								patternlist_tFileInputExcel_1.add("dd/MM/yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								datelist_tFileInputExcel_1.add(false);
								patternlist_tFileInputExcel_1.add("MM-dd-yyyy");
								int excel_end_column_tFileInputExcel_1;
								if (row_tFileInputExcel_1 == null) {
									excel_end_column_tFileInputExcel_1 = 0;
								} else {
									excel_end_column_tFileInputExcel_1 = row_tFileInputExcel_1.getLastCellNum();
								}
								int actual_end_column_tFileInputExcel_1;
								if (end_column_tFileInputExcel_1 == -1) {
									actual_end_column_tFileInputExcel_1 = excel_end_column_tFileInputExcel_1;
								} else {
									actual_end_column_tFileInputExcel_1 = end_column_tFileInputExcel_1 > excel_end_column_tFileInputExcel_1
											? excel_end_column_tFileInputExcel_1
											: end_column_tFileInputExcel_1;
								}
								org.apache.poi.ss.formula.eval.NumberEval ne_tFileInputExcel_1 = null;
								for (int i = 0; i < tempRowLength_tFileInputExcel_1; i++) {
									if (i + start_column_tFileInputExcel_1 < actual_end_column_tFileInputExcel_1) {
										org.apache.poi.ss.usermodel.Cell cell_tFileInputExcel_1 = row_tFileInputExcel_1
												.getCell(i + start_column_tFileInputExcel_1);
										if (cell_tFileInputExcel_1 != null) {
											switch (cell_tFileInputExcel_1.getCellType()) {
											case STRING:
												temp_row_tFileInputExcel_1[i] = cell_tFileInputExcel_1
														.getRichStringCellValue().getString();
												break;
											case NUMERIC:
												if (org.apache.poi.ss.usermodel.DateUtil
														.isCellDateFormatted(cell_tFileInputExcel_1)) {
													int dateColIndex_tFileInputExcel_1 = i;
													if (datelist_tFileInputExcel_1
															.get(dateColIndex_tFileInputExcel_1)) {
														temp_row_tFileInputExcel_1[i] = FormatterUtils.format_Date(
																cell_tFileInputExcel_1.getDateCellValue(),
																patternlist_tFileInputExcel_1
																		.get(dateColIndex_tFileInputExcel_1));
													} else {
														temp_row_tFileInputExcel_1[i] = cell_tFileInputExcel_1
																.getDateCellValue().toString();
													}
												} else {
													temp_row_tFileInputExcel_1[i] = df_tFileInputExcel_1
															.format(cell_tFileInputExcel_1.getNumericCellValue());
												}
												break;
											case BOOLEAN:
												temp_row_tFileInputExcel_1[i] = String
														.valueOf(cell_tFileInputExcel_1.getBooleanCellValue());
												break;
											case FORMULA:
												switch (cell_tFileInputExcel_1.getCachedFormulaResultType()) {
												case STRING:
													temp_row_tFileInputExcel_1[i] = cell_tFileInputExcel_1
															.getRichStringCellValue().getString();
													break;
												case NUMERIC:
													if (org.apache.poi.ss.usermodel.DateUtil
															.isCellDateFormatted(cell_tFileInputExcel_1)) {
														int dateColIndex_tFileInputExcel_1 = i;
														if (datelist_tFileInputExcel_1
																.get(dateColIndex_tFileInputExcel_1)) {
															temp_row_tFileInputExcel_1[i] = FormatterUtils.format_Date(
																	cell_tFileInputExcel_1.getDateCellValue(),
																	patternlist_tFileInputExcel_1
																			.get(dateColIndex_tFileInputExcel_1));
														} else {
															temp_row_tFileInputExcel_1[i] = cell_tFileInputExcel_1
																	.getDateCellValue().toString();
														}
													} else {
														ne_tFileInputExcel_1 = new org.apache.poi.ss.formula.eval.NumberEval(
																cell_tFileInputExcel_1.getNumericCellValue());
														temp_row_tFileInputExcel_1[i] = ne_tFileInputExcel_1
																.getStringValue();
													}
													break;
												case BOOLEAN:
													temp_row_tFileInputExcel_1[i] = String
															.valueOf(cell_tFileInputExcel_1.getBooleanCellValue());
													break;
												default:
													temp_row_tFileInputExcel_1[i] = "";
												}
												break;
											default:
												temp_row_tFileInputExcel_1[i] = "";
											}
										} else {
											temp_row_tFileInputExcel_1[i] = "";
										}

									} else {
										temp_row_tFileInputExcel_1[i] = "";
									}
								}
								boolean whetherReject_tFileInputExcel_1 = false;
								row1 = new row1Struct();
								int curColNum_tFileInputExcel_1 = -1;
								String curColName_tFileInputExcel_1 = "";
								try {
									columnIndex_tFileInputExcel_1 = 0;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "Sem";

										row1.Sem = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim();
									} else {
										row1.Sem = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 1;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "Day";

										row1.Day = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim();
									} else {
										row1.Day = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 2;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "Date";

										row1.Date = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim();
									} else {
										row1.Date = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 3;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "Van";

										row1.Van = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim();
									} else {
										row1.Van = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 4;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "PET_EMN_33CL";

										row1.PET_EMN_33CL = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1]
												.trim();
									} else {
										row1.PET_EMN_33CL = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 5;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "PET_EMN_33CL_B_S_Junior";

										row1.PET_EMN_33CL_B_S_Junior = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1]
												.trim();
									} else {
										row1.PET_EMN_33CL_B_S_Junior = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 6;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "PET_EMN_50CL";

										row1.PET_EMN_50CL = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1]
												.trim();
									} else {
										row1.PET_EMN_50CL = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 7;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "PET_EMN_50CL_B_S";

										row1.PET_EMN_50CL_B_S = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1]
												.trim();
									} else {
										row1.PET_EMN_50CL_B_S = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 8;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "PET_EMN_150CL";

										row1.PET_EMN_150CL = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1]
												.trim();
									} else {
										row1.PET_EMN_150CL = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 9;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "Eau_Minerale_Naturelle";

										row1.Eau_Minerale_Naturelle = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1]
												.trim();
									} else {
										row1.Eau_Minerale_Naturelle = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 10;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "PET_EMG_33CL";

										row1.PET_EMG_33CL = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1]
												.trim();
									} else {
										row1.PET_EMG_33CL = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 11;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "PET_EMG_50CL";

										row1.PET_EMG_50CL = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1]
												.trim();
									} else {
										row1.PET_EMG_50CL = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 12;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "PET_EMG_100CL";

										row1.PET_EMG_100CL = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1]
												.trim();
									} else {
										row1.PET_EMG_100CL = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 13;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "Eau_Minerale_Gazifiee";

										row1.Eau_Minerale_Gazifiee = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1]
												.trim();
									} else {
										row1.Eau_Minerale_Gazifiee = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 14;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "PET_SODA_PREMIUM_33CL";

										row1.PET_SODA_PREMIUM_33CL = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1]
												.trim();
									} else {
										row1.PET_SODA_PREMIUM_33CL = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 15;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "PET_SODA_PREMIUM_100CL";

										row1.PET_SODA_PREMIUM_100CL = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1]
												.trim();
									} else {
										row1.PET_SODA_PREMIUM_100CL = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 16;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "PET_SODA_PREMIUM_150CL";

										row1.PET_SODA_PREMIUM_150CL = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1]
												.trim();
									} else {
										row1.PET_SODA_PREMIUM_150CL = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 17;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "PET_SODA_PREMIUM_200CL";

										row1.PET_SODA_PREMIUM_200CL = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1]
												.trim();
									} else {
										row1.PET_SODA_PREMIUM_200CL = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 18;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "IFRI_GAZOUZ";

										row1.IFRI_GAZOUZ = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1]
												.trim();
									} else {
										row1.IFRI_GAZOUZ = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 19;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "PET_SODA_COLA_33CL";

										row1.PET_SODA_COLA_33CL = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1]
												.trim();
									} else {
										row1.PET_SODA_COLA_33CL = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 20;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "PET_SODA_COLA_100CL";

										row1.PET_SODA_COLA_100CL = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1]
												.trim();
									} else {
										row1.PET_SODA_COLA_100CL = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 21;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "PET_SODA_COLA_150CL";

										row1.PET_SODA_COLA_150CL = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1]
												.trim();
									} else {
										row1.PET_SODA_COLA_150CL = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 22;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "PET_SODA_COLA_200CL";

										row1.PET_SODA_COLA_200CL = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1]
												.trim();
									} else {
										row1.PET_SODA_COLA_200CL = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 23;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "SODA_COLA";

										row1.SODA_COLA = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1]
												.trim();
									} else {
										row1.SODA_COLA = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 24;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "PET_EF_P_tifruit_20CL";

										row1.PET_EF_P_tifruit_20CL = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1]
												.trim();
									} else {
										row1.PET_EF_P_tifruit_20CL = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 25;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "PET_EF_33CL";

										row1.PET_EF_33CL = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1]
												.trim();
									} else {
										row1.PET_EF_33CL = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 26;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "PET_EF_100CL";

										row1.PET_EF_100CL = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1]
												.trim();
									} else {
										row1.PET_EF_100CL = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 27;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "PET_EF_150CL";

										row1.PET_EF_150CL = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1]
												.trim();
									} else {
										row1.PET_EF_150CL = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 28;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "PET_EF_200CL";

										row1.PET_EF_200CL = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1]
												.trim();
									} else {
										row1.PET_EF_200CL = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 29;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "PET_EF_Unknown";

										row1.PET_EF_Unknown = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1]
												.trim();
									} else {
										row1.PET_EF_Unknown = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 30;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "Eaux_Fruites";

										row1.Eaux_Fruites = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1]
												.trim();
									} else {
										row1.Eaux_Fruites = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 31;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "PET_EFL_P_tifruit_20CL";

										row1.PET_EFL_P_tifruit_20CL = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1]
												.trim();
									} else {
										row1.PET_EFL_P_tifruit_20CL = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 32;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "PET_EFL_20CL";

										row1.PET_EFL_20CL = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1]
												.trim();
									} else {
										row1.PET_EFL_20CL = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 33;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "PET_EFL_33CL";

										row1.PET_EFL_33CL = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1]
												.trim();
									} else {
										row1.PET_EFL_33CL = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 34;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "PET_EFL_100CL";

										row1.PET_EFL_100CL = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1]
												.trim();
									} else {
										row1.PET_EFL_100CL = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 35;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "PET_EFL_150CL";

										row1.PET_EFL_150CL = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1]
												.trim();
									} else {
										row1.PET_EFL_150CL = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 36;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "Eaux_Fruites_au_Lait";

										row1.Eaux_Fruites_au_Lait = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1]
												.trim();
									} else {
										row1.Eaux_Fruites_au_Lait = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 37;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "PET_SPORTDRINK_50CL";

										row1.PET_SPORTDRINK_50CL = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1]
												.trim();
									} else {
										row1.PET_SPORTDRINK_50CL = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 38;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "PET_SPORTDRINK_Unknown";

										row1.PET_SPORTDRINK_Unknown = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1]
												.trim();
									} else {
										row1.PET_SPORTDRINK_Unknown = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 39;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "SPORT_Drink";

										row1.SPORT_Drink = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1]
												.trim();
									} else {
										row1.SPORT_Drink = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 40;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "PET_JUSPUR_20CL";

										row1.PET_JUSPUR_20CL = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1]
												.trim();
									} else {
										row1.PET_JUSPUR_20CL = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 41;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "PET_JUSPUR_100CL";

										row1.PET_JUSPUR_100CL = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1]
												.trim();
									} else {
										row1.PET_JUSPUR_100CL = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 42;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "JUS_PUR";

										row1.JUS_PUR = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim();
									} else {
										row1.JUS_PUR = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 43;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "PET_BEIZEM_33CL";

										row1.PET_BEIZEM_33CL = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1]
												.trim();
									} else {
										row1.PET_BEIZEM_33CL = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 44;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "PET_BEIZEM_Unknown";

										row1.PET_BEIZEM_Unknown = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1]
												.trim();
									} else {
										row1.PET_BEIZEM_Unknown = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 45;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "Boisson_Energisante_IZEM";

										row1.Boisson_Energisante_IZEM = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1]
												.trim();
									} else {
										row1.Boisson_Energisante_IZEM = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 46;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "PET_EFG_25CL";

										row1.PET_EFG_25CL = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1]
												.trim();
									} else {
										row1.PET_EFG_25CL = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 47;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "PET_EFG_33CL";

										row1.PET_EFG_33CL = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1]
												.trim();
									} else {
										row1.PET_EFG_33CL = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 48;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "PET_EFG_100CL";

										row1.PET_EFG_100CL = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1]
												.trim();
									} else {
										row1.PET_EFG_100CL = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 49;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "PET_EFG_150CL";

										row1.PET_EFG_150CL = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1]
												.trim();
									} else {
										row1.PET_EFG_150CL = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 50;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "EAUX_FRUITEES_GAZEIFIEES";

										row1.EAUX_FRUITEES_GAZEIFIEES = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1]
												.trim();
									} else {
										row1.EAUX_FRUITEES_GAZEIFIEES = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 51;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "PET_ICETHE_25CL";

										row1.PET_ICETHE_25CL = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1]
												.trim();
									} else {
										row1.PET_ICETHE_25CL = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 52;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "PET_ICETHE_100CL";

										row1.PET_ICETHE_100CL = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1]
												.trim();
									} else {
										row1.PET_ICETHE_100CL = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 53;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "PET_ICETHE_150CL";

										row1.PET_ICETHE_150CL = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1]
												.trim();
									} else {
										row1.PET_ICETHE_150CL = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 54;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "ICE_THE_PET";

										row1.ICE_THE_PET = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1]
												.trim();
									} else {
										row1.ICE_THE_PET = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 55;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "PET";

										row1.PET = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim();
									} else {
										row1.PET = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 56;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "VERRE_EMN_25CL";

										row1.VERRE_EMN_25CL = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1]
												.trim();
									} else {
										row1.VERRE_EMN_25CL = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 57;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "VERRE_EMN_50CL";

										row1.VERRE_EMN_50CL = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1]
												.trim();
									} else {
										row1.VERRE_EMN_50CL = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 58;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "VERRE_EMN_100CL";

										row1.VERRE_EMN_100CL = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1]
												.trim();
									} else {
										row1.VERRE_EMN_100CL = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 59;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "Eau_Minerale_Verre";

										row1.Eau_Minerale_Verre = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1]
												.trim();
									} else {
										row1.Eau_Minerale_Verre = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 60;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "VERRE_EMG_25CL";

										row1.VERRE_EMG_25CL = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1]
												.trim();
									} else {
										row1.VERRE_EMG_25CL = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 61;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "VERRE_EMG_50CL";

										row1.VERRE_EMG_50CL = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1]
												.trim();
									} else {
										row1.VERRE_EMG_50CL = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 62;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "VERRE_EMG_100CL";

										row1.VERRE_EMG_100CL = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1]
												.trim();
									} else {
										row1.VERRE_EMG_100CL = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 63;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "Eau_Minerale_Gazifiee_Verre";

										row1.Eau_Minerale_Gazifiee_Verre = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1]
												.trim();
									} else {
										row1.Eau_Minerale_Gazifiee_Verre = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 64;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "VERRE_SODA_25CL";

										row1.VERRE_SODA_25CL = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1]
												.trim();
									} else {
										row1.VERRE_SODA_25CL = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 65;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "VERRE_SODA_100CL";

										row1.VERRE_SODA_100CL = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1]
												.trim();
									} else {
										row1.VERRE_SODA_100CL = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 66;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "SODA_Verre";

										row1.SODA_Verre = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1]
												.trim();
									} else {
										row1.SODA_Verre = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 67;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "VERRE_SODACOLA_25CL";

										row1.VERRE_SODACOLA_25CL = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1]
												.trim();
									} else {
										row1.VERRE_SODACOLA_25CL = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 68;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "VERRE_SODACOLA_100CL";

										row1.VERRE_SODACOLA_100CL = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1]
												.trim();
									} else {
										row1.VERRE_SODACOLA_100CL = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 69;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "SODA_COLA_Verre";

										row1.SODA_COLA_Verre = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1]
												.trim();
									} else {
										row1.SODA_COLA_Verre = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 70;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "VERRE_EF_25CL";

										row1.VERRE_EF_25CL = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1]
												.trim();
									} else {
										row1.VERRE_EF_25CL = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 71;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "VERRE_EF_Unknown";

										row1.VERRE_EF_Unknown = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1]
												.trim();
									} else {
										row1.VERRE_EF_Unknown = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 72;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "Eaux_Fruitees_Verre";

										row1.Eaux_Fruitees_Verre = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1]
												.trim();
									} else {
										row1.Eaux_Fruitees_Verre = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 73;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "VERRE_EFL_25CL";

										row1.VERRE_EFL_25CL = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1]
												.trim();
									} else {
										row1.VERRE_EFL_25CL = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 74;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "VERRE_EFL_Unknown";

										row1.VERRE_EFL_Unknown = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1]
												.trim();
									} else {
										row1.VERRE_EFL_Unknown = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 75;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "Eaux_Fruitees_Au_LaitVerre";

										row1.Eaux_Fruitees_Au_LaitVerre = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1]
												.trim();
									} else {
										row1.Eaux_Fruitees_Au_LaitVerre = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 76;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "VERRE_CF_25CL";

										row1.VERRE_CF_25CL = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1]
												.trim();
									} else {
										row1.VERRE_CF_25CL = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 77;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "VERRE_CF_Unknown";

										row1.VERRE_CF_Unknown = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1]
												.trim();
									} else {
										row1.VERRE_CF_Unknown = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 78;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "Cocktail_de_Fruits_Verre";

										row1.Cocktail_de_Fruits_Verre = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1]
												.trim();
									} else {
										row1.Cocktail_de_Fruits_Verre = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 79;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "VERRE_BOISSON_25CL";

										row1.VERRE_BOISSON_25CL = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1]
												.trim();
									} else {
										row1.VERRE_BOISSON_25CL = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 80;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "VERRE_BOISSON_Unknown";

										row1.VERRE_BOISSON_Unknown = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1]
												.trim();
									} else {
										row1.VERRE_BOISSON_Unknown = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 81;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "Boisson_Verre";

										row1.Boisson_Verre = ParserUtils.parseTo_Integer(ParserUtils.parseTo_Number(
												temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim(), null,
												'.' == decimalChar_tFileInputExcel_1 ? null
														: decimalChar_tFileInputExcel_1));
									} else {
										row1.Boisson_Verre = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 82;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "VERRE_IZEM_25CL";

										row1.VERRE_IZEM_25CL = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1]
												.trim();
									} else {
										row1.VERRE_IZEM_25CL = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 83;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "IZEM_Verre";

										row1.IZEM_Verre = ParserUtils.parseTo_Integer(ParserUtils.parseTo_Number(
												temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim(), null,
												'.' == decimalChar_tFileInputExcel_1 ? null
														: decimalChar_tFileInputExcel_1));
									} else {
										row1.IZEM_Verre = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 84;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "VERRE_BG_25CL";

										row1.VERRE_BG_25CL = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1]
												.trim();
									} else {
										row1.VERRE_BG_25CL = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 85;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "VERRE_BG_Unknown";

										row1.VERRE_BG_Unknown = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1]
												.trim();
									} else {
										row1.VERRE_BG_Unknown = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 86;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "BOISSON_GAZEIFIEE_VERRE";

										row1.BOISSON_GAZEIFIEE_VERRE = ParserUtils
												.parseTo_Integer(ParserUtils.parseTo_Number(
														temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1]
																.trim(),
														null, '.' == decimalChar_tFileInputExcel_1 ? null
																: decimalChar_tFileInputExcel_1));
									} else {
										row1.BOISSON_GAZEIFIEE_VERRE = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 87;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "VERRE_ICETHE_25CL";

										row1.VERRE_ICETHE_25CL = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1]
												.trim();
									} else {
										row1.VERRE_ICETHE_25CL = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 88;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "VERRE_ICETHE_Unknown";

										row1.VERRE_ICETHE_Unknown = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1]
												.trim();
									} else {
										row1.VERRE_ICETHE_Unknown = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 89;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "ICE_THE_VERRE";

										row1.ICE_THE_VERRE = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1]
												.trim();
									} else {
										row1.ICE_THE_VERRE = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 90;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "Verre";

										row1.Verre = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim();
									} else {
										row1.Verre = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 91;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "CANNETTE_SODA_33CL";

										row1.CANNETTE_SODA_33CL = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1]
												.trim();
									} else {
										row1.CANNETTE_SODA_33CL = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 92;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "CANNETTE_JUS_33CL";

										row1.CANNETTE_JUS_33CL = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1]
												.trim();
									} else {
										row1.CANNETTE_JUS_33CL = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 93;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "CANNETTE_ENERGY_25CL";

										row1.CANNETTE_ENERGY_25CL = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1]
												.trim();
									} else {
										row1.CANNETTE_ENERGY_25CL = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 94;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "CANNETTE_SODACOLA_25CL";

										row1.CANNETTE_SODACOLA_25CL = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1]
												.trim();
									} else {
										row1.CANNETTE_SODACOLA_25CL = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 95;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "CANNETTE_BG_25CL";

										row1.CANNETTE_BG_25CL = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1]
												.trim();
									} else {
										row1.CANNETTE_BG_25CL = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 96;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "Canette";

										row1.Canette = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim();
									} else {
										row1.Canette = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 97;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "CU";

										row1.CU = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim();
									} else {
										row1.CU = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 98;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "CV";

										row1.CV = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim();
									} else {
										row1.CV = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 99;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "CW";

										row1.CW = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim();
									} else {
										row1.CW = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 100;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "CX";

										row1.CX = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim();
									} else {
										row1.CX = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 101;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "CY";

										row1.CY = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim();
									} else {
										row1.CY = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 102;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "CZ";

										row1.CZ = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim();
									} else {
										row1.CZ = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 103;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "DA";

										row1.DA = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim();
									} else {
										row1.DA = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 104;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "DB";

										row1.DB = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim();
									} else {
										row1.DB = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 105;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "DC";

										row1.DC = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim();
									} else {
										row1.DC = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 106;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "DD";

										row1.DD = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim();
									} else {
										row1.DD = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 107;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "DE";

										row1.DE = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim();
									} else {
										row1.DE = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 108;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "DF";

										row1.DF = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim();
									} else {
										row1.DF = null;
										emptyColumnCount_tFileInputExcel_1++;
									}
									columnIndex_tFileInputExcel_1 = 109;

									if (temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim().length() > 0) {
										curColNum_tFileInputExcel_1 = columnIndex_tFileInputExcel_1
												+ start_column_tFileInputExcel_1 + 1;
										curColName_tFileInputExcel_1 = "DG";

										row1.DG = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].trim();
									} else {
										row1.DG = null;
										emptyColumnCount_tFileInputExcel_1++;
									}

									nb_line_tFileInputExcel_1++;

								} catch (java.lang.Exception e) {
									globalMap.put("tFileInputExcel_1_ERROR_MESSAGE", e.getMessage());
									whetherReject_tFileInputExcel_1 = true;
									System.err.println(e.getMessage());
									row1 = null;
								}

								/**
								 * [tFileInputExcel_1 begin ] stop
								 */

								/**
								 * [tFileInputExcel_1 main ] start
								 */

								currentComponent = "tFileInputExcel_1";

								tos_count_tFileInputExcel_1++;

								/**
								 * [tFileInputExcel_1 main ] stop
								 */

								/**
								 * [tFileInputExcel_1 process_data_begin ] start
								 */

								currentComponent = "tFileInputExcel_1";

								/**
								 * [tFileInputExcel_1 process_data_begin ] stop
								 */
// Start of branch "row1"
								if (row1 != null) {

									/**
									 * [tMap_2 main ] start
									 */

									currentComponent = "tMap_2";

									if (execStat) {
										runStat.updateStatOnConnection(iterateId, 1, 1

												, "row1"

										);
									}

									boolean hasCasePrimitiveKeyWithNull_tMap_2 = false;

									// ###############################
									// # Input tables (lookups)
									boolean rejectedInnerJoin_tMap_2 = false;
									boolean mainRowRejected_tMap_2 = false;

									if (

									(

									row1.Day != null && (!"Vendredi".equals(row1.Day))
											&& StringHandling.IS_ALPHA(row1.Day)
											|| (row1.Sem != null && (row1.Sem.contains("Tot"))
													&& (!"Vendredi".equals(row1.Day)))

									)

									) { // G_TM_M_280

										// CALL close main tMap filter for table 'row1'
										// ###############################
										{ // start of Var scope

											// ###############################
											// # Vars tables

											Var__tMap_2__Struct Var = Var__tMap_2;// ###############################
											// ###############################
											// # Output tables

											out10 = null;

// # Output table : 'out10'
											out10_tmp.ID = 0;
											out10_tmp.WEEK = row1.Sem;
											out10_tmp.DAY = row1.Day;
											out10_tmp.Date = row1.Date;
											out10_tmp.Circuit = ((String) globalMap
													.get("tFileInputExcel_1_CURRENT_SHEET"));
											out10_tmp.Van = row1.Sem != null && row1.Sem.contains("Tot") ? row1.Sem
													: null;
											out10_tmp.PET_EMN_33CL = row1.PET_EMN_33CL;
											out10_tmp.PET_EMN_33CL_B_S_Junior = row1.PET_EMN_33CL_B_S_Junior;
											out10_tmp.PET_EMN_50CL = row1.PET_EMN_50CL;
											out10_tmp.PET_EMN_50CL_B_S = row1.PET_EMN_50CL_B_S;
											out10_tmp.PET_EMN_150CL = row1.PET_EMN_150CL;
											out10_tmp.PET_EMG_33CL = row1.PET_EMG_33CL;
											out10_tmp.PET_EMG_50CL = row1.PET_EMG_50CL;
											out10_tmp.PET_EMG_100CL = row1.PET_EMG_100CL;
											out10_tmp.PET_SODA_PREMIUM_33CL = row1.PET_SODA_PREMIUM_33CL;
											out10_tmp.PET_SODA_PREMIUM_100CL = row1.PET_SODA_PREMIUM_100CL;
											out10_tmp.PET_SODA_PREMIUM_150CL = row1.PET_SODA_PREMIUM_150CL;
											out10_tmp.PET_SODA_PREMIUM_200CL = row1.PET_SODA_PREMIUM_200CL;
											out10_tmp.PET_PET_SODA_COLA_33CL = row1.PET_SODA_COLA_33CL;
											out10_tmp.PET_SODA_COLA_100CL = row1.PET_SODA_COLA_100CL;
											out10_tmp.PET_SODA_COLA_150CL = row1.PET_SODA_COLA_150CL;
											out10_tmp.PET_SODA_COLA_200CL = row1.PET_SODA_COLA_200CL;
											out10_tmp.PET_EF_P_tifruit_20CL = row1.PET_EF_P_tifruit_20CL;
											out10_tmp.PET_EF_33CL = row1.PET_EF_33CL;
											out10_tmp.PET_EF_100CL = row1.PET_EF_100CL;
											out10_tmp.PET_EF_150CL = row1.PET_EF_150CL;
											out10_tmp.PET_EF_200CL = row1.PET_EF_200CL;
											out10_tmp.PET_EF_Unknown = row1.PET_EF_Unknown;
											out10_tmp.PET_EFL_P_tifruit_20CL = row1.PET_EFL_P_tifruit_20CL;
											out10_tmp.PET_EFL_20CL = row1.PET_EFL_20CL;
											out10_tmp.PET_EFL_33CL = row1.PET_EFL_33CL;
											out10_tmp.PET_EFL_100CL = row1.PET_EFL_100CL;
											out10_tmp.PET_EFL_150CL = row1.PET_EFL_150CL;
											out10_tmp.PET_SPORTDRINK_50CL = row1.PET_SPORTDRINK_50CL;
											out10_tmp.PET_SPORTDRINK_Unknown = row1.PET_SPORTDRINK_Unknown;
											out10_tmp.PET_JUSPUR_20CL = row1.PET_JUSPUR_20CL;
											out10_tmp.PET_JUSPUR_100CL = row1.PET_JUSPUR_100CL;
											out10_tmp.PET_BEIZEM_33CL = row1.PET_BEIZEM_33CL;
											out10_tmp.PET_BEIZEM_Unknown = row1.PET_BEIZEM_Unknown;
											out10_tmp.PET_EFG_25CL = row1.PET_EFG_25CL;
											out10_tmp.PET_EFG_33CL = row1.PET_EFG_33CL;
											out10_tmp.PET_EFG_100CL = row1.PET_EFG_100CL;
											out10_tmp.PET_EFG_150CL = row1.PET_EFG_150CL;
											out10_tmp.PET_ICETHE_25CL = row1.PET_ICETHE_25CL;
											out10_tmp.PET_ICETHE_100CL = row1.PET_ICETHE_100CL;
											out10_tmp.PET_ICETHE_150CL = row1.PET_ICETHE_150CL;
											out10_tmp.VERRE_EMN_25CL = row1.VERRE_EMN_25CL;
											out10_tmp.VERRE_EMN_50CL = row1.VERRE_EMN_50CL;
											out10_tmp.VERRE_EMN_100CL = row1.VERRE_EMN_100CL;
											out10_tmp.VERRE_EMG_25CL = row1.VERRE_EMG_25CL;
											out10_tmp.VERRE_EMG_50CL = row1.VERRE_EMG_50CL;
											out10_tmp.VERRE_EMG_100CL = row1.VERRE_EMG_100CL;
											out10_tmp.VERRE_SODA_25CL = row1.VERRE_SODA_25CL;
											out10_tmp.VERRE_SODA_100CL = row1.VERRE_SODA_100CL;
											out10_tmp.VERRE_SODACOLA_25CL = row1.VERRE_SODACOLA_25CL;
											out10_tmp.VERRE_SODACOLA_100CL = row1.VERRE_SODACOLA_100CL;
											out10_tmp.VERRE_EF_25CL = row1.VERRE_EF_25CL;
											out10_tmp.VERRE_EF_Unknown = row1.VERRE_EF_Unknown;
											out10_tmp.VERRE_EFL_25CL = row1.VERRE_EFL_25CL;
											out10_tmp.VERRE_EFL_Unknown = row1.VERRE_EFL_Unknown;
											out10_tmp.VERRE_CF_25CL = row1.VERRE_CF_25CL;
											out10_tmp.VERRE_CF_Unknown = row1.VERRE_CF_Unknown;
											out10_tmp.VERRE_BOISSON_25CL = row1.VERRE_BOISSON_25CL;
											out10_tmp.VERRE_BOISSON_Unknown = row1.VERRE_BOISSON_Unknown;
											out10_tmp.VERRE_IZEM_25CL = row1.VERRE_IZEM_25CL;
											out10_tmp.VERRE_BG_25CL = row1.VERRE_BG_25CL;
											out10_tmp.VERRE_BG_Unknown = row1.VERRE_BG_Unknown;
											out10_tmp.VERRE_ICETHE_25CL = row1.VERRE_ICETHE_25CL;
											out10_tmp.VERRE_ICETHE_Unknown = row1.VERRE_ICETHE_Unknown;
											out10_tmp.CANNETTE_SODA_33CL = row1.CANNETTE_SODA_33CL;
											out10_tmp.CANNETTE_JUS_33CL = row1.CANNETTE_JUS_33CL;
											out10_tmp.CANNETTE_ENERGY_25CL = row1.CANNETTE_ENERGY_25CL;
											out10_tmp.CANNETTE_SODACOLA_25CL = row1.CANNETTE_SODACOLA_25CL;
											out10_tmp.CANNETTE_BG_25CL = row1.CANNETTE_BG_25CL;
											out10_tmp.Routes = row1.DD;
											out10_tmp.Univers = row1.DE;
											out10_tmp.Nb_visites = row1.DF;
											out10_tmp.Nb_visites_achat = row1.DG;
											out10 = out10_tmp;
// ###############################

										} // end of Var scope

										rejectedInnerJoin_tMap_2 = false;

										tos_count_tMap_2++;

										/**
										 * [tMap_2 main ] stop
										 */

										/**
										 * [tMap_2 process_data_begin ] start
										 */

										currentComponent = "tMap_2";

										/**
										 * [tMap_2 process_data_begin ] stop
										 */
// Start of branch "out10"
										if (out10 != null) {

											/**
											 * [tJavaFlex_3 main ] start
											 */

											currentComponent = "tJavaFlex_3";

											if (execStat) {
												runStat.updateStatOnConnection(iterateId, 1, 1

														, "out10"

												);
											}

											row2.ID = out10.ID;
											row2.WEEK = out10.WEEK;
											row2.DAY = out10.DAY;
											row2.Date = out10.Date;
											row2.Circuit = out10.Circuit;
											row2.Van = out10.Van;
											row2.PET_EMN_33CL = out10.PET_EMN_33CL;
											row2.PET_EMN_33CL_B_S_Junior = out10.PET_EMN_33CL_B_S_Junior;
											row2.PET_EMN_50CL = out10.PET_EMN_50CL;
											row2.PET_EMN_50CL_B_S = out10.PET_EMN_50CL_B_S;
											row2.PET_EMN_150CL = out10.PET_EMN_150CL;
											row2.PET_EMG_33CL = out10.PET_EMG_33CL;
											row2.PET_EMG_50CL = out10.PET_EMG_50CL;
											row2.PET_EMG_100CL = out10.PET_EMG_100CL;
											row2.PET_SODA_PREMIUM_33CL = out10.PET_SODA_PREMIUM_33CL;
											row2.PET_SODA_PREMIUM_100CL = out10.PET_SODA_PREMIUM_100CL;
											row2.PET_SODA_PREMIUM_150CL = out10.PET_SODA_PREMIUM_150CL;
											row2.PET_SODA_PREMIUM_200CL = out10.PET_SODA_PREMIUM_200CL;
											row2.PET_PET_SODA_COLA_33CL = out10.PET_PET_SODA_COLA_33CL;
											row2.PET_SODA_COLA_100CL = out10.PET_SODA_COLA_100CL;
											row2.PET_SODA_COLA_150CL = out10.PET_SODA_COLA_150CL;
											row2.PET_SODA_COLA_200CL = out10.PET_SODA_COLA_200CL;
											row2.PET_EF_P_tifruit_20CL = out10.PET_EF_P_tifruit_20CL;
											row2.PET_EF_33CL = out10.PET_EF_33CL;
											row2.PET_EF_100CL = out10.PET_EF_100CL;
											row2.PET_EF_150CL = out10.PET_EF_150CL;
											row2.PET_EF_200CL = out10.PET_EF_200CL;
											row2.PET_EF_Unknown = out10.PET_EF_Unknown;
											row2.PET_EFL_P_tifruit_20CL = out10.PET_EFL_P_tifruit_20CL;
											row2.PET_EFL_20CL = out10.PET_EFL_20CL;
											row2.PET_EFL_33CL = out10.PET_EFL_33CL;
											row2.PET_EFL_100CL = out10.PET_EFL_100CL;
											row2.PET_EFL_150CL = out10.PET_EFL_150CL;
											row2.PET_SPORTDRINK_50CL = out10.PET_SPORTDRINK_50CL;
											row2.PET_SPORTDRINK_Unknown = out10.PET_SPORTDRINK_Unknown;
											row2.PET_JUSPUR_20CL = out10.PET_JUSPUR_20CL;
											row2.PET_JUSPUR_100CL = out10.PET_JUSPUR_100CL;
											row2.PET_BEIZEM_33CL = out10.PET_BEIZEM_33CL;
											row2.PET_BEIZEM_Unknown = out10.PET_BEIZEM_Unknown;
											row2.PET_EFG_25CL = out10.PET_EFG_25CL;
											row2.PET_EFG_33CL = out10.PET_EFG_33CL;
											row2.PET_EFG_100CL = out10.PET_EFG_100CL;
											row2.PET_EFG_150CL = out10.PET_EFG_150CL;
											row2.PET_ICETHE_25CL = out10.PET_ICETHE_25CL;
											row2.PET_ICETHE_100CL = out10.PET_ICETHE_100CL;
											row2.PET_ICETHE_150CL = out10.PET_ICETHE_150CL;
											row2.VERRE_EMN_25CL = out10.VERRE_EMN_25CL;
											row2.VERRE_EMN_50CL = out10.VERRE_EMN_50CL;
											row2.VERRE_EMN_100CL = out10.VERRE_EMN_100CL;
											row2.VERRE_EMG_25CL = out10.VERRE_EMG_25CL;
											row2.VERRE_EMG_50CL = out10.VERRE_EMG_50CL;
											row2.VERRE_EMG_100CL = out10.VERRE_EMG_100CL;
											row2.VERRE_SODA_25CL = out10.VERRE_SODA_25CL;
											row2.VERRE_SODA_100CL = out10.VERRE_SODA_100CL;
											row2.VERRE_SODACOLA_25CL = out10.VERRE_SODACOLA_25CL;
											row2.VERRE_SODACOLA_100CL = out10.VERRE_SODACOLA_100CL;
											row2.VERRE_EF_25CL = out10.VERRE_EF_25CL;
											row2.VERRE_EF_Unknown = out10.VERRE_EF_Unknown;
											row2.VERRE_EFL_25CL = out10.VERRE_EFL_25CL;
											row2.VERRE_EFL_Unknown = out10.VERRE_EFL_Unknown;
											row2.VERRE_CF_25CL = out10.VERRE_CF_25CL;
											row2.VERRE_CF_Unknown = out10.VERRE_CF_Unknown;
											row2.VERRE_BOISSON_25CL = out10.VERRE_BOISSON_25CL;
											row2.VERRE_BOISSON_Unknown = out10.VERRE_BOISSON_Unknown;
											row2.VERRE_IZEM_25CL = out10.VERRE_IZEM_25CL;
											row2.VERRE_BG_25CL = out10.VERRE_BG_25CL;
											row2.VERRE_BG_Unknown = out10.VERRE_BG_Unknown;
											row2.VERRE_ICETHE_25CL = out10.VERRE_ICETHE_25CL;
											row2.VERRE_ICETHE_Unknown = out10.VERRE_ICETHE_Unknown;
											row2.CANNETTE_SODA_33CL = out10.CANNETTE_SODA_33CL;
											row2.CANNETTE_JUS_33CL = out10.CANNETTE_JUS_33CL;
											row2.CANNETTE_ENERGY_25CL = out10.CANNETTE_ENERGY_25CL;
											row2.CANNETTE_SODACOLA_25CL = out10.CANNETTE_SODACOLA_25CL;
											row2.CANNETTE_BG_25CL = out10.CANNETTE_BG_25CL;
											row2.Routes = out10.Routes;
											row2.Univers = out10.Univers;
											row2.Nb_visites = out10.Nb_visites;
											row2.Nb_visites_achat = out10.Nb_visites_achat;

// here is the main part of the component,
// a piece of code executed in the row
// loop
											if (out10.WEEK != null && !(out10.WEEK.contains("S.Total"))
													&& out10.WEEK.contains("S")) {
												Weekd = out10.WEEK;
											}
											row2.WEEK = Weekd;
											if (out10.WEEK != null && out10.WEEK.equals("S1")) {

												id = id + 1;

											}
											row2.ID = id;
											if (out10.Van == null || !(out10.Van.contains("Van"))) {
												Vand = "";
											} else {
												Vand = out10.Van;
											}
											row2.Van = Vand;

											tos_count_tJavaFlex_3++;

											/**
											 * [tJavaFlex_3 main ] stop
											 */

											/**
											 * [tJavaFlex_3 process_data_begin ] start
											 */

											currentComponent = "tJavaFlex_3";

											/**
											 * [tJavaFlex_3 process_data_begin ] stop
											 */

											/**
											 * [tSortRow_2_SortOut main ] start
											 */

											currentVirtualComponent = "tSortRow_2";

											currentComponent = "tSortRow_2_SortOut";

											if (execStat) {
												runStat.updateStatOnConnection(iterateId, 1, 1

														, "row2"

												);
											}

											Comparablerow2Struct arrayRowtSortRow_2_SortOut = new Comparablerow2Struct();

											arrayRowtSortRow_2_SortOut.ID = row2.ID;
											arrayRowtSortRow_2_SortOut.WEEK = row2.WEEK;
											arrayRowtSortRow_2_SortOut.DAY = row2.DAY;
											arrayRowtSortRow_2_SortOut.Date = row2.Date;
											arrayRowtSortRow_2_SortOut.Circuit = row2.Circuit;
											arrayRowtSortRow_2_SortOut.Van = row2.Van;
											arrayRowtSortRow_2_SortOut.PET_EMN_33CL = row2.PET_EMN_33CL;
											arrayRowtSortRow_2_SortOut.PET_EMN_33CL_B_S_Junior = row2.PET_EMN_33CL_B_S_Junior;
											arrayRowtSortRow_2_SortOut.PET_EMN_50CL = row2.PET_EMN_50CL;
											arrayRowtSortRow_2_SortOut.PET_EMN_50CL_B_S = row2.PET_EMN_50CL_B_S;
											arrayRowtSortRow_2_SortOut.PET_EMN_150CL = row2.PET_EMN_150CL;
											arrayRowtSortRow_2_SortOut.PET_EMG_33CL = row2.PET_EMG_33CL;
											arrayRowtSortRow_2_SortOut.PET_EMG_50CL = row2.PET_EMG_50CL;
											arrayRowtSortRow_2_SortOut.PET_EMG_100CL = row2.PET_EMG_100CL;
											arrayRowtSortRow_2_SortOut.PET_SODA_PREMIUM_33CL = row2.PET_SODA_PREMIUM_33CL;
											arrayRowtSortRow_2_SortOut.PET_SODA_PREMIUM_100CL = row2.PET_SODA_PREMIUM_100CL;
											arrayRowtSortRow_2_SortOut.PET_SODA_PREMIUM_150CL = row2.PET_SODA_PREMIUM_150CL;
											arrayRowtSortRow_2_SortOut.PET_SODA_PREMIUM_200CL = row2.PET_SODA_PREMIUM_200CL;
											arrayRowtSortRow_2_SortOut.PET_PET_SODA_COLA_33CL = row2.PET_PET_SODA_COLA_33CL;
											arrayRowtSortRow_2_SortOut.PET_SODA_COLA_100CL = row2.PET_SODA_COLA_100CL;
											arrayRowtSortRow_2_SortOut.PET_SODA_COLA_150CL = row2.PET_SODA_COLA_150CL;
											arrayRowtSortRow_2_SortOut.PET_SODA_COLA_200CL = row2.PET_SODA_COLA_200CL;
											arrayRowtSortRow_2_SortOut.PET_EF_P_tifruit_20CL = row2.PET_EF_P_tifruit_20CL;
											arrayRowtSortRow_2_SortOut.PET_EF_33CL = row2.PET_EF_33CL;
											arrayRowtSortRow_2_SortOut.PET_EF_100CL = row2.PET_EF_100CL;
											arrayRowtSortRow_2_SortOut.PET_EF_150CL = row2.PET_EF_150CL;
											arrayRowtSortRow_2_SortOut.PET_EF_200CL = row2.PET_EF_200CL;
											arrayRowtSortRow_2_SortOut.PET_EF_Unknown = row2.PET_EF_Unknown;
											arrayRowtSortRow_2_SortOut.PET_EFL_P_tifruit_20CL = row2.PET_EFL_P_tifruit_20CL;
											arrayRowtSortRow_2_SortOut.PET_EFL_20CL = row2.PET_EFL_20CL;
											arrayRowtSortRow_2_SortOut.PET_EFL_33CL = row2.PET_EFL_33CL;
											arrayRowtSortRow_2_SortOut.PET_EFL_100CL = row2.PET_EFL_100CL;
											arrayRowtSortRow_2_SortOut.PET_EFL_150CL = row2.PET_EFL_150CL;
											arrayRowtSortRow_2_SortOut.PET_SPORTDRINK_50CL = row2.PET_SPORTDRINK_50CL;
											arrayRowtSortRow_2_SortOut.PET_SPORTDRINK_Unknown = row2.PET_SPORTDRINK_Unknown;
											arrayRowtSortRow_2_SortOut.PET_JUSPUR_20CL = row2.PET_JUSPUR_20CL;
											arrayRowtSortRow_2_SortOut.PET_JUSPUR_100CL = row2.PET_JUSPUR_100CL;
											arrayRowtSortRow_2_SortOut.PET_BEIZEM_33CL = row2.PET_BEIZEM_33CL;
											arrayRowtSortRow_2_SortOut.PET_BEIZEM_Unknown = row2.PET_BEIZEM_Unknown;
											arrayRowtSortRow_2_SortOut.PET_EFG_25CL = row2.PET_EFG_25CL;
											arrayRowtSortRow_2_SortOut.PET_EFG_33CL = row2.PET_EFG_33CL;
											arrayRowtSortRow_2_SortOut.PET_EFG_100CL = row2.PET_EFG_100CL;
											arrayRowtSortRow_2_SortOut.PET_EFG_150CL = row2.PET_EFG_150CL;
											arrayRowtSortRow_2_SortOut.PET_ICETHE_25CL = row2.PET_ICETHE_25CL;
											arrayRowtSortRow_2_SortOut.PET_ICETHE_100CL = row2.PET_ICETHE_100CL;
											arrayRowtSortRow_2_SortOut.PET_ICETHE_150CL = row2.PET_ICETHE_150CL;
											arrayRowtSortRow_2_SortOut.VERRE_EMN_25CL = row2.VERRE_EMN_25CL;
											arrayRowtSortRow_2_SortOut.VERRE_EMN_50CL = row2.VERRE_EMN_50CL;
											arrayRowtSortRow_2_SortOut.VERRE_EMN_100CL = row2.VERRE_EMN_100CL;
											arrayRowtSortRow_2_SortOut.VERRE_EMG_25CL = row2.VERRE_EMG_25CL;
											arrayRowtSortRow_2_SortOut.VERRE_EMG_50CL = row2.VERRE_EMG_50CL;
											arrayRowtSortRow_2_SortOut.VERRE_EMG_100CL = row2.VERRE_EMG_100CL;
											arrayRowtSortRow_2_SortOut.VERRE_SODA_25CL = row2.VERRE_SODA_25CL;
											arrayRowtSortRow_2_SortOut.VERRE_SODA_100CL = row2.VERRE_SODA_100CL;
											arrayRowtSortRow_2_SortOut.VERRE_SODACOLA_25CL = row2.VERRE_SODACOLA_25CL;
											arrayRowtSortRow_2_SortOut.VERRE_SODACOLA_100CL = row2.VERRE_SODACOLA_100CL;
											arrayRowtSortRow_2_SortOut.VERRE_EF_25CL = row2.VERRE_EF_25CL;
											arrayRowtSortRow_2_SortOut.VERRE_EF_Unknown = row2.VERRE_EF_Unknown;
											arrayRowtSortRow_2_SortOut.VERRE_EFL_25CL = row2.VERRE_EFL_25CL;
											arrayRowtSortRow_2_SortOut.VERRE_EFL_Unknown = row2.VERRE_EFL_Unknown;
											arrayRowtSortRow_2_SortOut.VERRE_CF_25CL = row2.VERRE_CF_25CL;
											arrayRowtSortRow_2_SortOut.VERRE_CF_Unknown = row2.VERRE_CF_Unknown;
											arrayRowtSortRow_2_SortOut.VERRE_BOISSON_25CL = row2.VERRE_BOISSON_25CL;
											arrayRowtSortRow_2_SortOut.VERRE_BOISSON_Unknown = row2.VERRE_BOISSON_Unknown;
											arrayRowtSortRow_2_SortOut.VERRE_IZEM_25CL = row2.VERRE_IZEM_25CL;
											arrayRowtSortRow_2_SortOut.VERRE_BG_25CL = row2.VERRE_BG_25CL;
											arrayRowtSortRow_2_SortOut.VERRE_BG_Unknown = row2.VERRE_BG_Unknown;
											arrayRowtSortRow_2_SortOut.VERRE_ICETHE_25CL = row2.VERRE_ICETHE_25CL;
											arrayRowtSortRow_2_SortOut.VERRE_ICETHE_Unknown = row2.VERRE_ICETHE_Unknown;
											arrayRowtSortRow_2_SortOut.CANNETTE_SODA_33CL = row2.CANNETTE_SODA_33CL;
											arrayRowtSortRow_2_SortOut.CANNETTE_JUS_33CL = row2.CANNETTE_JUS_33CL;
											arrayRowtSortRow_2_SortOut.CANNETTE_ENERGY_25CL = row2.CANNETTE_ENERGY_25CL;
											arrayRowtSortRow_2_SortOut.CANNETTE_SODACOLA_25CL = row2.CANNETTE_SODACOLA_25CL;
											arrayRowtSortRow_2_SortOut.CANNETTE_BG_25CL = row2.CANNETTE_BG_25CL;
											arrayRowtSortRow_2_SortOut.Routes = row2.Routes;
											arrayRowtSortRow_2_SortOut.Univers = row2.Univers;
											arrayRowtSortRow_2_SortOut.Nb_visites = row2.Nb_visites;
											arrayRowtSortRow_2_SortOut.Nb_visites_achat = row2.Nb_visites_achat;
											list_tSortRow_2_SortOut.add(arrayRowtSortRow_2_SortOut);

											tos_count_tSortRow_2_SortOut++;

											/**
											 * [tSortRow_2_SortOut main ] stop
											 */

											/**
											 * [tSortRow_2_SortOut process_data_begin ] start
											 */

											currentVirtualComponent = "tSortRow_2";

											currentComponent = "tSortRow_2_SortOut";

											/**
											 * [tSortRow_2_SortOut process_data_begin ] stop
											 */

											/**
											 * [tSortRow_2_SortOut process_data_end ] start
											 */

											currentVirtualComponent = "tSortRow_2";

											currentComponent = "tSortRow_2_SortOut";

											/**
											 * [tSortRow_2_SortOut process_data_end ] stop
											 */

											/**
											 * [tJavaFlex_3 process_data_end ] start
											 */

											currentComponent = "tJavaFlex_3";

											/**
											 * [tJavaFlex_3 process_data_end ] stop
											 */

										} // End of branch "out10"

									} // G_TM_M_280 close main tMap filter for table 'row1'

									/**
									 * [tMap_2 process_data_end ] start
									 */

									currentComponent = "tMap_2";

									/**
									 * [tMap_2 process_data_end ] stop
									 */

								} // End of branch "row1"

								/**
								 * [tFileInputExcel_1 process_data_end ] start
								 */

								currentComponent = "tFileInputExcel_1";

								/**
								 * [tFileInputExcel_1 process_data_end ] stop
								 */

								/**
								 * [tFileInputExcel_1 end ] start
								 */

								currentComponent = "tFileInputExcel_1";

							}

							globalMap.put("tFileInputExcel_1_NB_LINE", nb_line_tFileInputExcel_1);

						}

					} finally {

						if (!(source_tFileInputExcel_1 instanceof java.io.InputStream)) {
							workbook_tFileInputExcel_1.getPackage().revert();
						}

					}

					ok_Hash.put("tFileInputExcel_1", true);
					end_Hash.put("tFileInputExcel_1", System.currentTimeMillis());

					/**
					 * [tFileInputExcel_1 end ] stop
					 */

					/**
					 * [tMap_2 end ] start
					 */

					currentComponent = "tMap_2";

// ###############################
// # Lookup hashes releasing
// ###############################      

					if (execStat) {
						runStat.updateStat(resourceMap, iterateId, 2, 0, "row1");
					}

					ok_Hash.put("tMap_2", true);
					end_Hash.put("tMap_2", System.currentTimeMillis());

					/**
					 * [tMap_2 end ] stop
					 */

					/**
					 * [tJavaFlex_3 end ] start
					 */

					currentComponent = "tJavaFlex_3";

// end of the component, outside/closing the loop

					if (execStat) {
						runStat.updateStat(resourceMap, iterateId, 2, 0, "out10");
					}

					ok_Hash.put("tJavaFlex_3", true);
					end_Hash.put("tJavaFlex_3", System.currentTimeMillis());

					/**
					 * [tJavaFlex_3 end ] stop
					 */

					/**
					 * [tSortRow_2_SortOut end ] start
					 */

					currentVirtualComponent = "tSortRow_2";

					currentComponent = "tSortRow_2_SortOut";

					row2Struct[] array_tSortRow_2_SortOut = list_tSortRow_2_SortOut
							.toArray(new Comparablerow2Struct[0]);

					java.util.Arrays.sort(array_tSortRow_2_SortOut);

					globalMap.put("tSortRow_2", array_tSortRow_2_SortOut);

					if (execStat) {
						runStat.updateStat(resourceMap, iterateId, 2, 0, "row2");
					}

					ok_Hash.put("tSortRow_2_SortOut", true);
					end_Hash.put("tSortRow_2_SortOut", System.currentTimeMillis());

					/**
					 * [tSortRow_2_SortOut end ] stop
					 */

					/**
					 * [tLogRow_1 begin ] start
					 */

					ok_Hash.put("tLogRow_1", false);
					start_Hash.put("tLogRow_1", System.currentTimeMillis());

					currentComponent = "tLogRow_1";

					if (execStat) {
						runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row3");
					}

					int tos_count_tLogRow_1 = 0;

					///////////////////////

					class Util_tLogRow_1 {

						String[] des_top = { ".", ".", "-", "+" };

						String[] des_head = { "|=", "=|", "-", "+" };

						String[] des_bottom = { "'", "'", "-", "+" };

						String name = "";

						java.util.List<String[]> list = new java.util.ArrayList<String[]>();

						int[] colLengths = new int[12];

						public void addRow(String[] row) {

							for (int i = 0; i < 12; i++) {
								if (row[i] != null) {
									colLengths[i] = Math.max(colLengths[i], row[i].length());
								}
							}
							list.add(row);
						}

						public void setTableName(String name) {

							this.name = name;
						}

						public StringBuilder format() {

							StringBuilder sb = new StringBuilder();

							sb.append(print(des_top));

							int totals = 0;
							for (int i = 0; i < colLengths.length; i++) {
								totals = totals + colLengths[i];
							}

							// name
							sb.append("|");
							int k = 0;
							for (k = 0; k < (totals + 11 - name.length()) / 2; k++) {
								sb.append(' ');
							}
							sb.append(name);
							for (int i = 0; i < totals + 11 - name.length() - k; i++) {
								sb.append(' ');
							}
							sb.append("|\n");

							// head and rows
							sb.append(print(des_head));
							for (int i = 0; i < list.size(); i++) {

								String[] row = list.get(i);

								java.util.Formatter formatter = new java.util.Formatter(new StringBuilder());

								StringBuilder sbformat = new StringBuilder();
								sbformat.append("|%1$-");
								sbformat.append(colLengths[0]);
								sbformat.append("s");

								sbformat.append("|%2$-");
								sbformat.append(colLengths[1]);
								sbformat.append("s");

								sbformat.append("|%3$-");
								sbformat.append(colLengths[2]);
								sbformat.append("s");

								sbformat.append("|%4$-");
								sbformat.append(colLengths[3]);
								sbformat.append("s");

								sbformat.append("|%5$-");
								sbformat.append(colLengths[4]);
								sbformat.append("s");

								sbformat.append("|%6$-");
								sbformat.append(colLengths[5]);
								sbformat.append("s");

								sbformat.append("|%7$-");
								sbformat.append(colLengths[6]);
								sbformat.append("s");

								sbformat.append("|%8$-");
								sbformat.append(colLengths[7]);
								sbformat.append("s");

								sbformat.append("|%9$-");
								sbformat.append(colLengths[8]);
								sbformat.append("s");

								sbformat.append("|%10$-");
								sbformat.append(colLengths[9]);
								sbformat.append("s");

								sbformat.append("|%11$-");
								sbformat.append(colLengths[10]);
								sbformat.append("s");

								sbformat.append("|%12$-");
								sbformat.append(colLengths[11]);
								sbformat.append("s");

								sbformat.append("|\n");

								formatter.format(sbformat.toString(), (Object[]) row);

								sb.append(formatter.toString());
								if (i == 0)
									sb.append(print(des_head)); // print the head
							}

							// end
							sb.append(print(des_bottom));
							return sb;
						}

						private StringBuilder print(String[] fillChars) {
							StringBuilder sb = new StringBuilder();
							// first column
							sb.append(fillChars[0]);
							for (int i = 0; i < colLengths[0] - fillChars[0].length() + 1; i++) {
								sb.append(fillChars[2]);
							}
							sb.append(fillChars[3]);

							for (int i = 0; i < colLengths[1] - fillChars[3].length() + 1; i++) {
								sb.append(fillChars[2]);
							}
							sb.append(fillChars[3]);
							for (int i = 0; i < colLengths[2] - fillChars[3].length() + 1; i++) {
								sb.append(fillChars[2]);
							}
							sb.append(fillChars[3]);
							for (int i = 0; i < colLengths[3] - fillChars[3].length() + 1; i++) {
								sb.append(fillChars[2]);
							}
							sb.append(fillChars[3]);
							for (int i = 0; i < colLengths[4] - fillChars[3].length() + 1; i++) {
								sb.append(fillChars[2]);
							}
							sb.append(fillChars[3]);
							for (int i = 0; i < colLengths[5] - fillChars[3].length() + 1; i++) {
								sb.append(fillChars[2]);
							}
							sb.append(fillChars[3]);
							for (int i = 0; i < colLengths[6] - fillChars[3].length() + 1; i++) {
								sb.append(fillChars[2]);
							}
							sb.append(fillChars[3]);
							for (int i = 0; i < colLengths[7] - fillChars[3].length() + 1; i++) {
								sb.append(fillChars[2]);
							}
							sb.append(fillChars[3]);
							for (int i = 0; i < colLengths[8] - fillChars[3].length() + 1; i++) {
								sb.append(fillChars[2]);
							}
							sb.append(fillChars[3]);
							for (int i = 0; i < colLengths[9] - fillChars[3].length() + 1; i++) {
								sb.append(fillChars[2]);
							}
							sb.append(fillChars[3]);
							for (int i = 0; i < colLengths[10] - fillChars[3].length() + 1; i++) {
								sb.append(fillChars[2]);
							}
							sb.append(fillChars[3]);

							// last column
							for (int i = 0; i < colLengths[11] - fillChars[1].length() + 1; i++) {
								sb.append(fillChars[2]);
							}
							sb.append(fillChars[1]);
							sb.append("\n");
							return sb;
						}

						public boolean isTableEmpty() {
							if (list.size() > 1)
								return false;
							return true;
						}
					}
					Util_tLogRow_1 util_tLogRow_1 = new Util_tLogRow_1();
					util_tLogRow_1.setTableName("tLogRow_1");
					util_tLogRow_1.addRow(new String[] { "ID", "WEEK", "DAY", "Date", "Circuit", "Van", "pivot_key",
							"pivot_value", "Routes", "Univers", "Nb_visites", "Nb_visites_achat", });
					StringBuilder strBuffer_tLogRow_1 = null;
					int nb_line_tLogRow_1 = 0;
///////////////////////    			

					/**
					 * [tLogRow_1 begin ] stop
					 */

					/**
					 * [tUnpivotRow_1 begin ] start
					 */

					ok_Hash.put("tUnpivotRow_1", false);
					start_Hash.put("tUnpivotRow_1", System.currentTimeMillis());

					currentComponent = "tUnpivotRow_1";

					if (execStat) {
						runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row8");
					}

					int tos_count_tUnpivotRow_1 = 0;

					/**
					 * [tUnpivotRow_1 begin ] stop
					 */

					/**
					 * [tReplace_1 begin ] start
					 */

					ok_Hash.put("tReplace_1", false);
					start_Hash.put("tReplace_1", System.currentTimeMillis());

					currentComponent = "tReplace_1";

					if (execStat) {
						runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row7");
					}

					int tos_count_tReplace_1 = 0;

					int nb_line_tReplace_1 = 0;

					/**
					 * [tReplace_1 begin ] stop
					 */

					/**
					 * [tJavaFlex_4 begin ] start
					 */

					ok_Hash.put("tJavaFlex_4", false);
					start_Hash.put("tJavaFlex_4", System.currentTimeMillis());

					currentComponent = "tJavaFlex_4";

					if (execStat) {
						runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row6");
					}

					int tos_count_tJavaFlex_4 = 0;

// start part of your Java code
					String van = "";

					/**
					 * [tJavaFlex_4 begin ] stop
					 */

					/**
					 * [tSortRow_2_SortIn begin ] start
					 */

					ok_Hash.put("tSortRow_2_SortIn", false);
					start_Hash.put("tSortRow_2_SortIn", System.currentTimeMillis());

					currentVirtualComponent = "tSortRow_2";

					currentComponent = "tSortRow_2_SortIn";

					int tos_count_tSortRow_2_SortIn = 0;

					row2Struct[] array_tSortRow_2_SortIn = (row2Struct[]) globalMap.remove("tSortRow_2");

					int nb_line_tSortRow_2_SortIn = 0;

					row2Struct current_tSortRow_2_SortIn = null;

					for (int i_tSortRow_2_SortIn = 0; i_tSortRow_2_SortIn < array_tSortRow_2_SortIn.length; i_tSortRow_2_SortIn++) {
						current_tSortRow_2_SortIn = array_tSortRow_2_SortIn[i_tSortRow_2_SortIn];
						row6.ID = current_tSortRow_2_SortIn.ID;
						row6.WEEK = current_tSortRow_2_SortIn.WEEK;
						row6.DAY = current_tSortRow_2_SortIn.DAY;
						row6.Date = current_tSortRow_2_SortIn.Date;
						row6.Circuit = current_tSortRow_2_SortIn.Circuit;
						row6.Van = current_tSortRow_2_SortIn.Van;
						row6.PET_EMN_33CL = current_tSortRow_2_SortIn.PET_EMN_33CL;
						row6.PET_EMN_33CL_B_S_Junior = current_tSortRow_2_SortIn.PET_EMN_33CL_B_S_Junior;
						row6.PET_EMN_50CL = current_tSortRow_2_SortIn.PET_EMN_50CL;
						row6.PET_EMN_50CL_B_S = current_tSortRow_2_SortIn.PET_EMN_50CL_B_S;
						row6.PET_EMN_150CL = current_tSortRow_2_SortIn.PET_EMN_150CL;
						row6.PET_EMG_33CL = current_tSortRow_2_SortIn.PET_EMG_33CL;
						row6.PET_EMG_50CL = current_tSortRow_2_SortIn.PET_EMG_50CL;
						row6.PET_EMG_100CL = current_tSortRow_2_SortIn.PET_EMG_100CL;
						row6.PET_SODA_PREMIUM_33CL = current_tSortRow_2_SortIn.PET_SODA_PREMIUM_33CL;
						row6.PET_SODA_PREMIUM_100CL = current_tSortRow_2_SortIn.PET_SODA_PREMIUM_100CL;
						row6.PET_SODA_PREMIUM_150CL = current_tSortRow_2_SortIn.PET_SODA_PREMIUM_150CL;
						row6.PET_SODA_PREMIUM_200CL = current_tSortRow_2_SortIn.PET_SODA_PREMIUM_200CL;
						row6.PET_PET_SODA_COLA_33CL = current_tSortRow_2_SortIn.PET_PET_SODA_COLA_33CL;
						row6.PET_SODA_COLA_100CL = current_tSortRow_2_SortIn.PET_SODA_COLA_100CL;
						row6.PET_SODA_COLA_150CL = current_tSortRow_2_SortIn.PET_SODA_COLA_150CL;
						row6.PET_SODA_COLA_200CL = current_tSortRow_2_SortIn.PET_SODA_COLA_200CL;
						row6.PET_EF_P_tifruit_20CL = current_tSortRow_2_SortIn.PET_EF_P_tifruit_20CL;
						row6.PET_EF_33CL = current_tSortRow_2_SortIn.PET_EF_33CL;
						row6.PET_EF_100CL = current_tSortRow_2_SortIn.PET_EF_100CL;
						row6.PET_EF_150CL = current_tSortRow_2_SortIn.PET_EF_150CL;
						row6.PET_EF_200CL = current_tSortRow_2_SortIn.PET_EF_200CL;
						row6.PET_EF_Unknown = current_tSortRow_2_SortIn.PET_EF_Unknown;
						row6.PET_EFL_P_tifruit_20CL = current_tSortRow_2_SortIn.PET_EFL_P_tifruit_20CL;
						row6.PET_EFL_20CL = current_tSortRow_2_SortIn.PET_EFL_20CL;
						row6.PET_EFL_33CL = current_tSortRow_2_SortIn.PET_EFL_33CL;
						row6.PET_EFL_100CL = current_tSortRow_2_SortIn.PET_EFL_100CL;
						row6.PET_EFL_150CL = current_tSortRow_2_SortIn.PET_EFL_150CL;
						row6.PET_SPORTDRINK_50CL = current_tSortRow_2_SortIn.PET_SPORTDRINK_50CL;
						row6.PET_SPORTDRINK_Unknown = current_tSortRow_2_SortIn.PET_SPORTDRINK_Unknown;
						row6.PET_JUSPUR_20CL = current_tSortRow_2_SortIn.PET_JUSPUR_20CL;
						row6.PET_JUSPUR_100CL = current_tSortRow_2_SortIn.PET_JUSPUR_100CL;
						row6.PET_BEIZEM_33CL = current_tSortRow_2_SortIn.PET_BEIZEM_33CL;
						row6.PET_BEIZEM_Unknown = current_tSortRow_2_SortIn.PET_BEIZEM_Unknown;
						row6.PET_EFG_25CL = current_tSortRow_2_SortIn.PET_EFG_25CL;
						row6.PET_EFG_33CL = current_tSortRow_2_SortIn.PET_EFG_33CL;
						row6.PET_EFG_100CL = current_tSortRow_2_SortIn.PET_EFG_100CL;
						row6.PET_EFG_150CL = current_tSortRow_2_SortIn.PET_EFG_150CL;
						row6.PET_ICETHE_25CL = current_tSortRow_2_SortIn.PET_ICETHE_25CL;
						row6.PET_ICETHE_100CL = current_tSortRow_2_SortIn.PET_ICETHE_100CL;
						row6.PET_ICETHE_150CL = current_tSortRow_2_SortIn.PET_ICETHE_150CL;
						row6.VERRE_EMN_25CL = current_tSortRow_2_SortIn.VERRE_EMN_25CL;
						row6.VERRE_EMN_50CL = current_tSortRow_2_SortIn.VERRE_EMN_50CL;
						row6.VERRE_EMN_100CL = current_tSortRow_2_SortIn.VERRE_EMN_100CL;
						row6.VERRE_EMG_25CL = current_tSortRow_2_SortIn.VERRE_EMG_25CL;
						row6.VERRE_EMG_50CL = current_tSortRow_2_SortIn.VERRE_EMG_50CL;
						row6.VERRE_EMG_100CL = current_tSortRow_2_SortIn.VERRE_EMG_100CL;
						row6.VERRE_SODA_25CL = current_tSortRow_2_SortIn.VERRE_SODA_25CL;
						row6.VERRE_SODA_100CL = current_tSortRow_2_SortIn.VERRE_SODA_100CL;
						row6.VERRE_SODACOLA_25CL = current_tSortRow_2_SortIn.VERRE_SODACOLA_25CL;
						row6.VERRE_SODACOLA_100CL = current_tSortRow_2_SortIn.VERRE_SODACOLA_100CL;
						row6.VERRE_EF_25CL = current_tSortRow_2_SortIn.VERRE_EF_25CL;
						row6.VERRE_EF_Unknown = current_tSortRow_2_SortIn.VERRE_EF_Unknown;
						row6.VERRE_EFL_25CL = current_tSortRow_2_SortIn.VERRE_EFL_25CL;
						row6.VERRE_EFL_Unknown = current_tSortRow_2_SortIn.VERRE_EFL_Unknown;
						row6.VERRE_CF_25CL = current_tSortRow_2_SortIn.VERRE_CF_25CL;
						row6.VERRE_CF_Unknown = current_tSortRow_2_SortIn.VERRE_CF_Unknown;
						row6.VERRE_BOISSON_25CL = current_tSortRow_2_SortIn.VERRE_BOISSON_25CL;
						row6.VERRE_BOISSON_Unknown = current_tSortRow_2_SortIn.VERRE_BOISSON_Unknown;
						row6.VERRE_IZEM_25CL = current_tSortRow_2_SortIn.VERRE_IZEM_25CL;
						row6.VERRE_BG_25CL = current_tSortRow_2_SortIn.VERRE_BG_25CL;
						row6.VERRE_BG_Unknown = current_tSortRow_2_SortIn.VERRE_BG_Unknown;
						row6.VERRE_ICETHE_25CL = current_tSortRow_2_SortIn.VERRE_ICETHE_25CL;
						row6.VERRE_ICETHE_Unknown = current_tSortRow_2_SortIn.VERRE_ICETHE_Unknown;
						row6.CANNETTE_SODA_33CL = current_tSortRow_2_SortIn.CANNETTE_SODA_33CL;
						row6.CANNETTE_JUS_33CL = current_tSortRow_2_SortIn.CANNETTE_JUS_33CL;
						row6.CANNETTE_ENERGY_25CL = current_tSortRow_2_SortIn.CANNETTE_ENERGY_25CL;
						row6.CANNETTE_SODACOLA_25CL = current_tSortRow_2_SortIn.CANNETTE_SODACOLA_25CL;
						row6.CANNETTE_BG_25CL = current_tSortRow_2_SortIn.CANNETTE_BG_25CL;
						row6.Routes = current_tSortRow_2_SortIn.Routes;
						row6.Univers = current_tSortRow_2_SortIn.Univers;
						row6.Nb_visites = current_tSortRow_2_SortIn.Nb_visites;
						row6.Nb_visites_achat = current_tSortRow_2_SortIn.Nb_visites_achat;
						// increase number of line sorted
						nb_line_tSortRow_2_SortIn++;

						/**
						 * [tSortRow_2_SortIn begin ] stop
						 */

						/**
						 * [tSortRow_2_SortIn main ] start
						 */

						currentVirtualComponent = "tSortRow_2";

						currentComponent = "tSortRow_2_SortIn";

						tos_count_tSortRow_2_SortIn++;

						/**
						 * [tSortRow_2_SortIn main ] stop
						 */

						/**
						 * [tSortRow_2_SortIn process_data_begin ] start
						 */

						currentVirtualComponent = "tSortRow_2";

						currentComponent = "tSortRow_2_SortIn";

						/**
						 * [tSortRow_2_SortIn process_data_begin ] stop
						 */

						/**
						 * [tJavaFlex_4 main ] start
						 */

						currentComponent = "tJavaFlex_4";

						if (execStat) {
							runStat.updateStatOnConnection(iterateId, 1, 1

									, "row6"

							);
						}

						row7.ID = row6.ID;
						row7.WEEK = row6.WEEK;
						row7.DAY = row6.DAY;
						row7.Date = row6.Date;
						row7.Circuit = row6.Circuit;
						row7.Van = row6.Van;
						row7.PET_EMN_33CL = row6.PET_EMN_33CL;
						row7.PET_EMN_33CL_B_S_Junior = row6.PET_EMN_33CL_B_S_Junior;
						row7.PET_EMN_50CL = row6.PET_EMN_50CL;
						row7.PET_EMN_50CL_B_S = row6.PET_EMN_50CL_B_S;
						row7.PET_EMN_150CL = row6.PET_EMN_150CL;
						row7.PET_EMG_33CL = row6.PET_EMG_33CL;
						row7.PET_EMG_50CL = row6.PET_EMG_50CL;
						row7.PET_EMG_100CL = row6.PET_EMG_100CL;
						row7.PET_SODA_PREMIUM_33CL = row6.PET_SODA_PREMIUM_33CL;
						row7.PET_SODA_PREMIUM_100CL = row6.PET_SODA_PREMIUM_100CL;
						row7.PET_SODA_PREMIUM_150CL = row6.PET_SODA_PREMIUM_150CL;
						row7.PET_SODA_PREMIUM_200CL = row6.PET_SODA_PREMIUM_200CL;
						row7.PET_PET_SODA_COLA_33CL = row6.PET_PET_SODA_COLA_33CL;
						row7.PET_SODA_COLA_100CL = row6.PET_SODA_COLA_100CL;
						row7.PET_SODA_COLA_150CL = row6.PET_SODA_COLA_150CL;
						row7.PET_SODA_COLA_200CL = row6.PET_SODA_COLA_200CL;
						row7.PET_EF_P_tifruit_20CL = row6.PET_EF_P_tifruit_20CL;
						row7.PET_EF_33CL = row6.PET_EF_33CL;
						row7.PET_EF_100CL = row6.PET_EF_100CL;
						row7.PET_EF_150CL = row6.PET_EF_150CL;
						row7.PET_EF_200CL = row6.PET_EF_200CL;
						row7.PET_EF_Unknown = row6.PET_EF_Unknown;
						row7.PET_EFL_P_tifruit_20CL = row6.PET_EFL_P_tifruit_20CL;
						row7.PET_EFL_20CL = row6.PET_EFL_20CL;
						row7.PET_EFL_33CL = row6.PET_EFL_33CL;
						row7.PET_EFL_100CL = row6.PET_EFL_100CL;
						row7.PET_EFL_150CL = row6.PET_EFL_150CL;
						row7.PET_SPORTDRINK_50CL = row6.PET_SPORTDRINK_50CL;
						row7.PET_SPORTDRINK_Unknown = row6.PET_SPORTDRINK_Unknown;
						row7.PET_JUSPUR_20CL = row6.PET_JUSPUR_20CL;
						row7.PET_JUSPUR_100CL = row6.PET_JUSPUR_100CL;
						row7.PET_BEIZEM_33CL = row6.PET_BEIZEM_33CL;
						row7.PET_BEIZEM_Unknown = row6.PET_BEIZEM_Unknown;
						row7.PET_EFG_25CL = row6.PET_EFG_25CL;
						row7.PET_EFG_33CL = row6.PET_EFG_33CL;
						row7.PET_EFG_100CL = row6.PET_EFG_100CL;
						row7.PET_EFG_150CL = row6.PET_EFG_150CL;
						row7.PET_ICETHE_25CL = row6.PET_ICETHE_25CL;
						row7.PET_ICETHE_100CL = row6.PET_ICETHE_100CL;
						row7.PET_ICETHE_150CL = row6.PET_ICETHE_150CL;
						row7.VERRE_EMN_25CL = row6.VERRE_EMN_25CL;
						row7.VERRE_EMN_50CL = row6.VERRE_EMN_50CL;
						row7.VERRE_EMN_100CL = row6.VERRE_EMN_100CL;
						row7.VERRE_EMG_25CL = row6.VERRE_EMG_25CL;
						row7.VERRE_EMG_50CL = row6.VERRE_EMG_50CL;
						row7.VERRE_EMG_100CL = row6.VERRE_EMG_100CL;
						row7.VERRE_SODA_25CL = row6.VERRE_SODA_25CL;
						row7.VERRE_SODA_100CL = row6.VERRE_SODA_100CL;
						row7.VERRE_SODACOLA_25CL = row6.VERRE_SODACOLA_25CL;
						row7.VERRE_SODACOLA_100CL = row6.VERRE_SODACOLA_100CL;
						row7.VERRE_EF_25CL = row6.VERRE_EF_25CL;
						row7.VERRE_EF_Unknown = row6.VERRE_EF_Unknown;
						row7.VERRE_EFL_25CL = row6.VERRE_EFL_25CL;
						row7.VERRE_EFL_Unknown = row6.VERRE_EFL_Unknown;
						row7.VERRE_CF_25CL = row6.VERRE_CF_25CL;
						row7.VERRE_CF_Unknown = row6.VERRE_CF_Unknown;
						row7.VERRE_BOISSON_25CL = row6.VERRE_BOISSON_25CL;
						row7.VERRE_BOISSON_Unknown = row6.VERRE_BOISSON_Unknown;
						row7.VERRE_IZEM_25CL = row6.VERRE_IZEM_25CL;
						row7.VERRE_BG_25CL = row6.VERRE_BG_25CL;
						row7.VERRE_BG_Unknown = row6.VERRE_BG_Unknown;
						row7.VERRE_ICETHE_25CL = row6.VERRE_ICETHE_25CL;
						row7.VERRE_ICETHE_Unknown = row6.VERRE_ICETHE_Unknown;
						row7.CANNETTE_SODA_33CL = row6.CANNETTE_SODA_33CL;
						row7.CANNETTE_JUS_33CL = row6.CANNETTE_JUS_33CL;
						row7.CANNETTE_ENERGY_25CL = row6.CANNETTE_ENERGY_25CL;
						row7.CANNETTE_SODACOLA_25CL = row6.CANNETTE_SODACOLA_25CL;
						row7.CANNETTE_BG_25CL = row6.CANNETTE_BG_25CL;
						row7.Routes = row6.Routes;
						row7.Univers = row6.Univers;
						row7.Nb_visites = row6.Nb_visites;
						row7.Nb_visites_achat = row6.Nb_visites_achat;

// here is the main part of the component,
// a piece of code executed in the row
// loop
						if (row6.Van != null && row6.Van.contains("Van")) {
							van = row6.Van;

						}
						row7.Van = van;

						tos_count_tJavaFlex_4++;

						/**
						 * [tJavaFlex_4 main ] stop
						 */

						/**
						 * [tJavaFlex_4 process_data_begin ] start
						 */

						currentComponent = "tJavaFlex_4";

						/**
						 * [tJavaFlex_4 process_data_begin ] stop
						 */

						/**
						 * [tReplace_1 main ] start
						 */

						currentComponent = "tReplace_1";

						if (execStat) {
							runStat.updateStatOnConnection(iterateId, 1, 1

									, "row7"

							);
						}

						String searchStr_tReplace_1_1 = "Sous.Totaux Mois " + "";
						row7.Van = StringUtils.replaceAllStrictly(row7.Van, searchStr_tReplace_1_1, "" + "", false,
								false);
						String searchStr_tReplace_1_2 = "Total " + "";
						row7.Van = StringUtils.replaceAllStrictly(row7.Van, searchStr_tReplace_1_2, "" + "", false,
								false);
						String searchStr_tReplace_1_3 = "(" + "";
						row7.Van = StringUtils.replaceAllStrictly(row7.Van, searchStr_tReplace_1_3, "" + "", false,
								false);
						String searchStr_tReplace_1_4 = ")" + "";
						row7.Van = StringUtils.replaceAllStrictly(row7.Van, searchStr_tReplace_1_4, "" + "", false,
								false);
						String searchStr_tReplace_1_5 = "DD" + "";
						row7.Van = StringUtils.replaceAllStrictly(row7.Van, searchStr_tReplace_1_5, "" + "", false,
								false);
						String searchStr_tReplace_1_6 = "odern M" + "";
						row7.Van = StringUtils.replaceAllStrictly(row7.Van, searchStr_tReplace_1_6, "" + "", false,
								false);
						String searchStr_tReplace_1_7 = "oderne M" + "";
						row7.Van = StringUtils.replaceAllStrictly(row7.Van, searchStr_tReplace_1_7, "" + "", false,
								false);
						String searchStr_tReplace_1_8 = "oderne D" + "";
						row7.Van = StringUtils.replaceAllStrictly(row7.Van, searchStr_tReplace_1_8, "" + "", false,
								false);
						String searchStr_tReplace_1_9 = "ros " + "";
						row7.Van = StringUtils.replaceAllStrictly(row7.Van, searchStr_tReplace_1_9, "" + "", false,
								false);
						String searchStr_tReplace_1_10 = "  " + "";
						row7.Van = StringUtils.replaceAllStrictly(row7.Van, searchStr_tReplace_1_10, " " + "", false,
								false);
						row8.ID = row7.ID;

						row8.WEEK = row7.WEEK;

						row8.DAY = row7.DAY;

						row8.Date = row7.Date;

						row8.Circuit = row7.Circuit;

						row8.Van = row7.Van;

						row8.PET_EMN_33CL = row7.PET_EMN_33CL;

						row8.PET_EMN_33CL_B_S_Junior = row7.PET_EMN_33CL_B_S_Junior;

						row8.PET_EMN_50CL = row7.PET_EMN_50CL;

						row8.PET_EMN_50CL_B_S = row7.PET_EMN_50CL_B_S;

						row8.PET_EMN_150CL = row7.PET_EMN_150CL;

						row8.PET_EMG_33CL = row7.PET_EMG_33CL;

						row8.PET_EMG_50CL = row7.PET_EMG_50CL;

						row8.PET_EMG_100CL = row7.PET_EMG_100CL;

						row8.PET_SODA_PREMIUM_33CL = row7.PET_SODA_PREMIUM_33CL;

						row8.PET_SODA_PREMIUM_100CL = row7.PET_SODA_PREMIUM_100CL;

						row8.PET_SODA_PREMIUM_150CL = row7.PET_SODA_PREMIUM_150CL;

						row8.PET_SODA_PREMIUM_200CL = row7.PET_SODA_PREMIUM_200CL;

						row8.PET_PET_SODA_COLA_33CL = row7.PET_PET_SODA_COLA_33CL;

						row8.PET_SODA_COLA_100CL = row7.PET_SODA_COLA_100CL;

						row8.PET_SODA_COLA_150CL = row7.PET_SODA_COLA_150CL;

						row8.PET_SODA_COLA_200CL = row7.PET_SODA_COLA_200CL;

						row8.PET_EF_P_tifruit_20CL = row7.PET_EF_P_tifruit_20CL;

						row8.PET_EF_33CL = row7.PET_EF_33CL;

						row8.PET_EF_100CL = row7.PET_EF_100CL;

						row8.PET_EF_150CL = row7.PET_EF_150CL;

						row8.PET_EF_200CL = row7.PET_EF_200CL;

						row8.PET_EF_Unknown = row7.PET_EF_Unknown;

						row8.PET_EFL_P_tifruit_20CL = row7.PET_EFL_P_tifruit_20CL;

						row8.PET_EFL_20CL = row7.PET_EFL_20CL;

						row8.PET_EFL_33CL = row7.PET_EFL_33CL;

						row8.PET_EFL_100CL = row7.PET_EFL_100CL;

						row8.PET_EFL_150CL = row7.PET_EFL_150CL;

						row8.PET_SPORTDRINK_50CL = row7.PET_SPORTDRINK_50CL;

						row8.PET_SPORTDRINK_Unknown = row7.PET_SPORTDRINK_Unknown;

						row8.PET_JUSPUR_20CL = row7.PET_JUSPUR_20CL;

						row8.PET_JUSPUR_100CL = row7.PET_JUSPUR_100CL;

						row8.PET_BEIZEM_33CL = row7.PET_BEIZEM_33CL;

						row8.PET_BEIZEM_Unknown = row7.PET_BEIZEM_Unknown;

						row8.PET_EFG_25CL = row7.PET_EFG_25CL;

						row8.PET_EFG_33CL = row7.PET_EFG_33CL;

						row8.PET_EFG_100CL = row7.PET_EFG_100CL;

						row8.PET_EFG_150CL = row7.PET_EFG_150CL;

						row8.PET_ICETHE_25CL = row7.PET_ICETHE_25CL;

						row8.PET_ICETHE_100CL = row7.PET_ICETHE_100CL;

						row8.PET_ICETHE_150CL = row7.PET_ICETHE_150CL;

						row8.VERRE_EMN_25CL = row7.VERRE_EMN_25CL;

						row8.VERRE_EMN_50CL = row7.VERRE_EMN_50CL;

						row8.VERRE_EMN_100CL = row7.VERRE_EMN_100CL;

						row8.VERRE_EMG_25CL = row7.VERRE_EMG_25CL;

						row8.VERRE_EMG_50CL = row7.VERRE_EMG_50CL;

						row8.VERRE_EMG_100CL = row7.VERRE_EMG_100CL;

						row8.VERRE_SODA_25CL = row7.VERRE_SODA_25CL;

						row8.VERRE_SODA_100CL = row7.VERRE_SODA_100CL;

						row8.VERRE_SODACOLA_25CL = row7.VERRE_SODACOLA_25CL;

						row8.VERRE_SODACOLA_100CL = row7.VERRE_SODACOLA_100CL;

						row8.VERRE_EF_25CL = row7.VERRE_EF_25CL;

						row8.VERRE_EF_Unknown = row7.VERRE_EF_Unknown;

						row8.VERRE_EFL_25CL = row7.VERRE_EFL_25CL;

						row8.VERRE_EFL_Unknown = row7.VERRE_EFL_Unknown;

						row8.VERRE_CF_25CL = row7.VERRE_CF_25CL;

						row8.VERRE_CF_Unknown = row7.VERRE_CF_Unknown;

						row8.VERRE_BOISSON_25CL = row7.VERRE_BOISSON_25CL;

						row8.VERRE_BOISSON_Unknown = row7.VERRE_BOISSON_Unknown;

						row8.VERRE_IZEM_25CL = row7.VERRE_IZEM_25CL;

						row8.VERRE_BG_25CL = row7.VERRE_BG_25CL;

						row8.VERRE_BG_Unknown = row7.VERRE_BG_Unknown;

						row8.VERRE_ICETHE_25CL = row7.VERRE_ICETHE_25CL;

						row8.VERRE_ICETHE_Unknown = row7.VERRE_ICETHE_Unknown;

						row8.CANNETTE_SODA_33CL = row7.CANNETTE_SODA_33CL;

						row8.CANNETTE_JUS_33CL = row7.CANNETTE_JUS_33CL;

						row8.CANNETTE_ENERGY_25CL = row7.CANNETTE_ENERGY_25CL;

						row8.CANNETTE_SODACOLA_25CL = row7.CANNETTE_SODACOLA_25CL;

						row8.CANNETTE_BG_25CL = row7.CANNETTE_BG_25CL;

						row8.Routes = row7.Routes;

						row8.Univers = row7.Univers;

						row8.Nb_visites = row7.Nb_visites;

						row8.Nb_visites_achat = row7.Nb_visites_achat;

						nb_line_tReplace_1++;

						tos_count_tReplace_1++;

						/**
						 * [tReplace_1 main ] stop
						 */

						/**
						 * [tReplace_1 process_data_begin ] start
						 */

						currentComponent = "tReplace_1";

						/**
						 * [tReplace_1 process_data_begin ] stop
						 */

						/**
						 * [tUnpivotRow_1 main ] start
						 */

						currentComponent = "tUnpivotRow_1";

						if (execStat) {
							runStat.updateStatOnConnection(iterateId, 1, 1

									, "row8"

							);
						}

						/*
						 * &copy; British Telecommunications plc, 2009, All Rights Reserved. Licensed
						 * for general use under the terms of GPL v2.
						 */
						String[] pivotKeysArray = { "PET_EMN_33CL", "PET_EMN_33CL_B_S_Junior", "PET_EMN_50CL",
								"PET_EMN_50CL_B_S", "PET_EMN_150CL", "PET_EMG_33CL", "PET_EMG_50CL", "PET_EMG_100CL",
								"PET_SODA_PREMIUM_33CL", "PET_SODA_PREMIUM_100CL", "PET_SODA_PREMIUM_150CL",
								"PET_SODA_PREMIUM_200CL", "PET_PET_SODA_COLA_33CL", "PET_SODA_COLA_100CL",
								"PET_SODA_COLA_150CL", "PET_SODA_COLA_200CL", "PET_EF_P_tifruit_20CL", "PET_EF_33CL",
								"PET_EF_100CL", "PET_EF_150CL", "PET_EF_200CL", "PET_EF_Unknown",
								"PET_EFL_P_tifruit_20CL", "PET_EFL_20CL", "PET_EFL_33CL", "PET_EFL_100CL",
								"PET_EFL_150CL", "PET_SPORTDRINK_50CL", "PET_SPORTDRINK_Unknown", "PET_JUSPUR_20CL",
								"PET_JUSPUR_100CL", "PET_BEIZEM_33CL", "PET_BEIZEM_Unknown", "PET_EFG_25CL",
								"PET_EFG_33CL", "PET_EFG_100CL", "PET_EFG_150CL", "PET_ICETHE_25CL", "PET_ICETHE_100CL",
								"PET_ICETHE_150CL", "VERRE_EMN_25CL", "VERRE_EMN_50CL", "VERRE_EMN_100CL",
								"VERRE_EMG_25CL", "VERRE_EMG_50CL", "VERRE_EMG_100CL", "VERRE_SODA_25CL",
								"VERRE_SODA_100CL", "VERRE_SODACOLA_25CL", "VERRE_SODACOLA_100CL", "VERRE_EF_25CL",
								"VERRE_EF_Unknown", "VERRE_EFL_25CL", "VERRE_EFL_Unknown", "VERRE_CF_25CL",
								"VERRE_CF_Unknown", "VERRE_BOISSON_25CL", "VERRE_BOISSON_Unknown", "VERRE_IZEM_25CL",
								"VERRE_BG_25CL", "VERRE_BG_Unknown", "VERRE_ICETHE_25CL", "VERRE_ICETHE_Unknown",
								"CANNETTE_SODA_33CL", "CANNETTE_JUS_33CL", "CANNETTE_ENERGY_25CL",
								"CANNETTE_SODACOLA_25CL", "CANNETTE_BG_25CL" };

						for (String field : pivotKeysArray) {
							row3.ID = row8.ID;
							row3.WEEK = row8.WEEK;
							row3.DAY = row8.DAY;
							row3.Date = row8.Date;
							row3.Circuit = row8.Circuit;
							row3.Van = row8.Van;
							row3.Routes = row8.Routes;
							row3.Univers = row8.Univers;
							row3.Nb_visites = row8.Nb_visites;
							row3.Nb_visites_achat = row8.Nb_visites_achat;

							row3.pivot_key = field;
							try {
								row3.pivot_value = row8.getClass().getDeclaredField(field).get(row8).toString();
							} catch (Exception e) {
								row3.pivot_value = null;
							}

							tos_count_tUnpivotRow_1++;

							/**
							 * [tUnpivotRow_1 main ] stop
							 */

							/**
							 * [tUnpivotRow_1 process_data_begin ] start
							 */

							currentComponent = "tUnpivotRow_1";

							/**
							 * [tUnpivotRow_1 process_data_begin ] stop
							 */

							/**
							 * [tLogRow_1 main ] start
							 */

							currentComponent = "tLogRow_1";

							if (execStat) {
								runStat.updateStatOnConnection(iterateId, 1, 1

										, "row3"

								);
							}

///////////////////////		

							String[] row_tLogRow_1 = new String[12];

							if (row3.ID != null) { //
								row_tLogRow_1[0] = String.valueOf(row3.ID);

							} //

							if (row3.WEEK != null) { //
								row_tLogRow_1[1] = String.valueOf(row3.WEEK);

							} //

							if (row3.DAY != null) { //
								row_tLogRow_1[2] = String.valueOf(row3.DAY);

							} //

							if (row3.Date != null) { //
								row_tLogRow_1[3] = String.valueOf(row3.Date);

							} //

							if (row3.Circuit != null) { //
								row_tLogRow_1[4] = String.valueOf(row3.Circuit);

							} //

							if (row3.Van != null) { //
								row_tLogRow_1[5] = String.valueOf(row3.Van);

							} //

							if (row3.pivot_key != null) { //
								row_tLogRow_1[6] = String.valueOf(row3.pivot_key);

							} //

							if (row3.pivot_value != null) { //
								row_tLogRow_1[7] = String.valueOf(row3.pivot_value);

							} //

							if (row3.Routes != null) { //
								row_tLogRow_1[8] = String.valueOf(row3.Routes);

							} //

							if (row3.Univers != null) { //
								row_tLogRow_1[9] = String.valueOf(row3.Univers);

							} //

							if (row3.Nb_visites != null) { //
								row_tLogRow_1[10] = String.valueOf(row3.Nb_visites);

							} //

							if (row3.Nb_visites_achat != null) { //
								row_tLogRow_1[11] = String.valueOf(row3.Nb_visites_achat);

							} //

							util_tLogRow_1.addRow(row_tLogRow_1);
							nb_line_tLogRow_1++;
//////

//////                    

///////////////////////    			

							tos_count_tLogRow_1++;

							/**
							 * [tLogRow_1 main ] stop
							 */

							/**
							 * [tLogRow_1 process_data_begin ] start
							 */

							currentComponent = "tLogRow_1";

							/**
							 * [tLogRow_1 process_data_begin ] stop
							 */

							/**
							 * [tLogRow_1 process_data_end ] start
							 */

							currentComponent = "tLogRow_1";

							/**
							 * [tLogRow_1 process_data_end ] stop
							 */
							// end for
						}

						/**
						 * [tUnpivotRow_1 process_data_end ] start
						 */

						currentComponent = "tUnpivotRow_1";

						/**
						 * [tUnpivotRow_1 process_data_end ] stop
						 */

						/**
						 * [tReplace_1 process_data_end ] start
						 */

						currentComponent = "tReplace_1";

						/**
						 * [tReplace_1 process_data_end ] stop
						 */

						/**
						 * [tJavaFlex_4 process_data_end ] start
						 */

						currentComponent = "tJavaFlex_4";

						/**
						 * [tJavaFlex_4 process_data_end ] stop
						 */

						/**
						 * [tSortRow_2_SortIn process_data_end ] start
						 */

						currentVirtualComponent = "tSortRow_2";

						currentComponent = "tSortRow_2_SortIn";

						/**
						 * [tSortRow_2_SortIn process_data_end ] stop
						 */

						/**
						 * [tSortRow_2_SortIn end ] start
						 */

						currentVirtualComponent = "tSortRow_2";

						currentComponent = "tSortRow_2_SortIn";

					}

					globalMap.put("tSortRow_2_SortIn_NB_LINE", nb_line_tSortRow_2_SortIn);

					ok_Hash.put("tSortRow_2_SortIn", true);
					end_Hash.put("tSortRow_2_SortIn", System.currentTimeMillis());

					/**
					 * [tSortRow_2_SortIn end ] stop
					 */

					/**
					 * [tJavaFlex_4 end ] start
					 */

					currentComponent = "tJavaFlex_4";

// end of the component, outside/closing the loop

					if (execStat) {
						runStat.updateStat(resourceMap, iterateId, 2, 0, "row6");
					}

					ok_Hash.put("tJavaFlex_4", true);
					end_Hash.put("tJavaFlex_4", System.currentTimeMillis());

					/**
					 * [tJavaFlex_4 end ] stop
					 */

					/**
					 * [tReplace_1 end ] start
					 */

					currentComponent = "tReplace_1";

					globalMap.put("tReplace_1_NB_LINE", nb_line_tReplace_1);
					if (execStat) {
						runStat.updateStat(resourceMap, iterateId, 2, 0, "row7");
					}

					ok_Hash.put("tReplace_1", true);
					end_Hash.put("tReplace_1", System.currentTimeMillis());

					/**
					 * [tReplace_1 end ] stop
					 */

					/**
					 * [tUnpivotRow_1 end ] start
					 */

					currentComponent = "tUnpivotRow_1";

					if (execStat) {
						runStat.updateStat(resourceMap, iterateId, 2, 0, "row8");
					}

					ok_Hash.put("tUnpivotRow_1", true);
					end_Hash.put("tUnpivotRow_1", System.currentTimeMillis());

					/**
					 * [tUnpivotRow_1 end ] stop
					 */

					/**
					 * [tLogRow_1 end ] start
					 */

					currentComponent = "tLogRow_1";

//////

					java.io.PrintStream consoleOut_tLogRow_1 = null;
					if (globalMap.get("tLogRow_CONSOLE") != null) {
						consoleOut_tLogRow_1 = (java.io.PrintStream) globalMap.get("tLogRow_CONSOLE");
					} else {
						consoleOut_tLogRow_1 = new java.io.PrintStream(new java.io.BufferedOutputStream(System.out));
						globalMap.put("tLogRow_CONSOLE", consoleOut_tLogRow_1);
					}

					consoleOut_tLogRow_1.println(util_tLogRow_1.format().toString());
					consoleOut_tLogRow_1.flush();
//////
					globalMap.put("tLogRow_1_NB_LINE", nb_line_tLogRow_1);

///////////////////////    			

					if (execStat) {
						runStat.updateStat(resourceMap, iterateId, 2, 0, "row3");
					}

					ok_Hash.put("tLogRow_1", true);
					end_Hash.put("tLogRow_1", System.currentTimeMillis());

					/**
					 * [tLogRow_1 end ] stop
					 */

					if (execStat) {
						runStat.updateStatOnConnection("iterate1", 2, "exec" + NB_ITERATE_tFileInputExcel_1);
					}

					/**
					 * [tFileList_1 process_data_end ] start
					 */

					currentComponent = "tFileList_1";

					/**
					 * [tFileList_1 process_data_end ] stop
					 */

					/**
					 * [tFileList_1 end ] start
					 */

					currentComponent = "tFileList_1";

				}
				globalMap.put("tFileList_1_NB_FILE", NB_FILEtFileList_1);

				if (NB_FILEtFileList_1 == 0)
					throw new RuntimeException("No file found in directory " + directory_tFileList_1);

				ok_Hash.put("tFileList_1", true);
				end_Hash.put("tFileList_1", System.currentTimeMillis());

				/**
				 * [tFileList_1 end ] stop
				 */
			} // end the resume

		} catch (java.lang.Exception e) {

			TalendException te = new TalendException(e, currentComponent, globalMap);

			te.setVirtualComponentName(currentVirtualComponent);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			// free memory for "tSortRow_2_SortIn"
			globalMap.remove("tSortRow_2");

			try {

				/**
				 * [tFileList_1 finally ] start
				 */

				currentComponent = "tFileList_1";

				/**
				 * [tFileList_1 finally ] stop
				 */

				/**
				 * [tFileInputExcel_1 finally ] start
				 */

				currentComponent = "tFileInputExcel_1";

				/**
				 * [tFileInputExcel_1 finally ] stop
				 */

				/**
				 * [tMap_2 finally ] start
				 */

				currentComponent = "tMap_2";

				/**
				 * [tMap_2 finally ] stop
				 */

				/**
				 * [tJavaFlex_3 finally ] start
				 */

				currentComponent = "tJavaFlex_3";

				/**
				 * [tJavaFlex_3 finally ] stop
				 */

				/**
				 * [tSortRow_2_SortOut finally ] start
				 */

				currentVirtualComponent = "tSortRow_2";

				currentComponent = "tSortRow_2_SortOut";

				/**
				 * [tSortRow_2_SortOut finally ] stop
				 */

				/**
				 * [tSortRow_2_SortIn finally ] start
				 */

				currentVirtualComponent = "tSortRow_2";

				currentComponent = "tSortRow_2_SortIn";

				/**
				 * [tSortRow_2_SortIn finally ] stop
				 */

				/**
				 * [tJavaFlex_4 finally ] start
				 */

				currentComponent = "tJavaFlex_4";

				/**
				 * [tJavaFlex_4 finally ] stop
				 */

				/**
				 * [tReplace_1 finally ] start
				 */

				currentComponent = "tReplace_1";

				/**
				 * [tReplace_1 finally ] stop
				 */

				/**
				 * [tUnpivotRow_1 finally ] start
				 */

				currentComponent = "tUnpivotRow_1";

				/**
				 * [tUnpivotRow_1 finally ] stop
				 */

				/**
				 * [tLogRow_1 finally ] start
				 */

				currentComponent = "tLogRow_1";

				/**
				 * [tLogRow_1 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tFileList_1_SUBPROCESS_STATE", 1);
	}

	public String resuming_logs_dir_path = null;
	public String resuming_checkpoint_path = null;
	public String parent_part_launcher = null;
	private String resumeEntryMethodName = null;
	private boolean globalResumeTicket = false;

	public boolean watch = false;
	// portStats is null, it means don't execute the statistics
	public Integer portStats = null;
	public int portTraces = 4334;
	public String clientHost;
	public String defaultClientHost = "localhost";
	public String contextStr = "Default";
	public boolean isDefaultContext = true;
	public String pid = "0";
	public String rootPid = null;
	public String fatherPid = null;
	public String fatherNode = null;
	public long startTime = 0;
	public boolean isChildJob = false;
	public String log4jLevel = "";

	private boolean enableLogStash;

	private boolean execStat = true;

	private ThreadLocal<java.util.Map<String, String>> threadLocal = new ThreadLocal<java.util.Map<String, String>>() {
		protected java.util.Map<String, String> initialValue() {
			java.util.Map<String, String> threadRunResultMap = new java.util.HashMap<String, String>();
			threadRunResultMap.put("errorCode", null);
			threadRunResultMap.put("status", "");
			return threadRunResultMap;
		};
	};

	protected PropertiesWithType context_param = new PropertiesWithType();
	public java.util.Map<String, Object> parentContextMap = new java.util.HashMap<String, Object>();

	public String status = "";

	public static void main(String[] args) {
		final ReadFile_V04_2 ReadFile_V04_2Class = new ReadFile_V04_2();

		int exitCode = ReadFile_V04_2Class.runJobInTOS(args);

		System.exit(exitCode);
	}

	public String[][] runJob(String[] args) {

		int exitCode = runJobInTOS(args);
		String[][] bufferValue = new String[][] { { Integer.toString(exitCode) } };

		return bufferValue;
	}

	public boolean hastBufferOutputComponent() {
		boolean hastBufferOutput = false;

		return hastBufferOutput;
	}

	public int runJobInTOS(String[] args) {
		// reset status
		status = "";

		String lastStr = "";
		for (String arg : args) {
			if (arg.equalsIgnoreCase("--context_param")) {
				lastStr = arg;
			} else if (lastStr.equals("")) {
				evalParam(arg);
			} else {
				evalParam(lastStr + " " + arg);
				lastStr = "";
			}
		}
		enableLogStash = "true".equalsIgnoreCase(System.getProperty("audit.enabled"));

		if (clientHost == null) {
			clientHost = defaultClientHost;
		}

		if (pid == null || "0".equals(pid)) {
			pid = TalendString.getAsciiRandomString(6);
		}

		if (rootPid == null) {
			rootPid = pid;
		}
		if (fatherPid == null) {
			fatherPid = pid;
		} else {
			isChildJob = true;
		}

		if (portStats != null) {
			// portStats = -1; //for testing
			if (portStats < 0 || portStats > 65535) {
				// issue:10869, the portStats is invalid, so this client socket can't open
				System.err.println("The statistics socket port " + portStats + " is invalid.");
				execStat = false;
			}
		} else {
			execStat = false;
		}
		boolean inOSGi = routines.system.BundleUtils.inOSGi();

		if (inOSGi) {
			java.util.Dictionary<String, Object> jobProperties = routines.system.BundleUtils.getJobProperties(jobName);

			if (jobProperties != null && jobProperties.get("context") != null) {
				contextStr = (String) jobProperties.get("context");
			}
		}

		try {
			// call job/subjob with an existing context, like: --context=production. if
			// without this parameter, there will use the default context instead.
			java.io.InputStream inContext = ReadFile_V04_2.class.getClassLoader()
					.getResourceAsStream("keyrus/readfile_v04_2_0_1/contexts/" + contextStr + ".properties");
			if (inContext == null) {
				inContext = ReadFile_V04_2.class.getClassLoader()
						.getResourceAsStream("config/contexts/" + contextStr + ".properties");
			}
			if (inContext != null) {
				try {
					// defaultProps is in order to keep the original context value
					if (context != null && context.isEmpty()) {
						defaultProps.load(inContext);
						context = new ContextProperties(defaultProps);
					}
				} finally {
					inContext.close();
				}
			} else if (!isDefaultContext) {
				// print info and job continue to run, for case: context_param is not empty.
				System.err.println("Could not find the context " + contextStr);
			}

			if (!context_param.isEmpty()) {
				context.putAll(context_param);
				// set types for params from parentJobs
				for (Object key : context_param.keySet()) {
					String context_key = key.toString();
					String context_type = context_param.getContextType(context_key);
					context.setContextType(context_key, context_type);

				}
			}
			class ContextProcessing {
				private void processContext_0() {
					context.setContextType("pathFile", "id_String");
					if (context.getStringValue("pathFile") == null) {
						context.pathFile = null;
					} else {
						context.pathFile = (String) context.getProperty("pathFile");
					}
					context.setContextType("Logs", "id_String");
					if (context.getStringValue("Logs") == null) {
						context.Logs = null;
					} else {
						context.Logs = (String) context.getProperty("Logs");
					}
					context.setContextType("ODS_IFRI1_Login", "id_String");
					if (context.getStringValue("ODS_IFRI1_Login") == null) {
						context.ODS_IFRI1_Login = null;
					} else {
						context.ODS_IFRI1_Login = (String) context.getProperty("ODS_IFRI1_Login");
					}
					context.setContextType("ODS_IFRI1_AdditionalParams", "id_String");
					if (context.getStringValue("ODS_IFRI1_AdditionalParams") == null) {
						context.ODS_IFRI1_AdditionalParams = null;
					} else {
						context.ODS_IFRI1_AdditionalParams = (String) context.getProperty("ODS_IFRI1_AdditionalParams");
					}
					context.setContextType("ODS_IFRI1_Port", "id_String");
					if (context.getStringValue("ODS_IFRI1_Port") == null) {
						context.ODS_IFRI1_Port = null;
					} else {
						context.ODS_IFRI1_Port = (String) context.getProperty("ODS_IFRI1_Port");
					}
					context.setContextType("ODS_IFRI1_Server", "id_String");
					if (context.getStringValue("ODS_IFRI1_Server") == null) {
						context.ODS_IFRI1_Server = null;
					} else {
						context.ODS_IFRI1_Server = (String) context.getProperty("ODS_IFRI1_Server");
					}
					context.setContextType("ODS_IFRI1_Schema", "id_String");
					if (context.getStringValue("ODS_IFRI1_Schema") == null) {
						context.ODS_IFRI1_Schema = null;
					} else {
						context.ODS_IFRI1_Schema = (String) context.getProperty("ODS_IFRI1_Schema");
					}
					context.setContextType("ODS_IFRI1_Database", "id_String");
					if (context.getStringValue("ODS_IFRI1_Database") == null) {
						context.ODS_IFRI1_Database = null;
					} else {
						context.ODS_IFRI1_Database = (String) context.getProperty("ODS_IFRI1_Database");
					}
					context.setContextType("ODS_IFRI1_Password", "id_Password");
					if (context.getStringValue("ODS_IFRI1_Password") == null) {
						context.ODS_IFRI1_Password = null;
					} else {
						String pwd_ODS_IFRI1_Password_value = context.getProperty("ODS_IFRI1_Password");
						context.ODS_IFRI1_Password = null;
						if (pwd_ODS_IFRI1_Password_value != null) {
							if (context_param.containsKey("ODS_IFRI1_Password")) {// no need to decrypt if it come from
																					// program argument or parent job
																					// runtime
								context.ODS_IFRI1_Password = pwd_ODS_IFRI1_Password_value;
							} else if (!pwd_ODS_IFRI1_Password_value.isEmpty()) {
								try {
									context.ODS_IFRI1_Password = routines.system.PasswordEncryptUtil
											.decryptPassword(pwd_ODS_IFRI1_Password_value);
									context.put("ODS_IFRI1_Password", context.ODS_IFRI1_Password);
								} catch (java.lang.RuntimeException e) {
									// do nothing
								}
							}
						}
					}
				}

				public void processAllContext() {
					processContext_0();
				}
			}

			new ContextProcessing().processAllContext();
		} catch (java.io.IOException ie) {
			System.err.println("Could not load context " + contextStr);
			ie.printStackTrace();
		}

		// get context value from parent directly
		if (parentContextMap != null && !parentContextMap.isEmpty()) {
			if (parentContextMap.containsKey("pathFile")) {
				context.pathFile = (String) parentContextMap.get("pathFile");
			}
			if (parentContextMap.containsKey("Logs")) {
				context.Logs = (String) parentContextMap.get("Logs");
			}
			if (parentContextMap.containsKey("ODS_IFRI1_Login")) {
				context.ODS_IFRI1_Login = (String) parentContextMap.get("ODS_IFRI1_Login");
			}
			if (parentContextMap.containsKey("ODS_IFRI1_AdditionalParams")) {
				context.ODS_IFRI1_AdditionalParams = (String) parentContextMap.get("ODS_IFRI1_AdditionalParams");
			}
			if (parentContextMap.containsKey("ODS_IFRI1_Port")) {
				context.ODS_IFRI1_Port = (String) parentContextMap.get("ODS_IFRI1_Port");
			}
			if (parentContextMap.containsKey("ODS_IFRI1_Server")) {
				context.ODS_IFRI1_Server = (String) parentContextMap.get("ODS_IFRI1_Server");
			}
			if (parentContextMap.containsKey("ODS_IFRI1_Schema")) {
				context.ODS_IFRI1_Schema = (String) parentContextMap.get("ODS_IFRI1_Schema");
			}
			if (parentContextMap.containsKey("ODS_IFRI1_Database")) {
				context.ODS_IFRI1_Database = (String) parentContextMap.get("ODS_IFRI1_Database");
			}
			if (parentContextMap.containsKey("ODS_IFRI1_Password")) {
				context.ODS_IFRI1_Password = (java.lang.String) parentContextMap.get("ODS_IFRI1_Password");
			}
		}

		// Resume: init the resumeUtil
		resumeEntryMethodName = ResumeUtil.getResumeEntryMethodName(resuming_checkpoint_path);
		resumeUtil = new ResumeUtil(resuming_logs_dir_path, isChildJob, rootPid);
		resumeUtil.initCommonInfo(pid, rootPid, fatherPid, projectName, jobName, contextStr, jobVersion);

		List<String> parametersToEncrypt = new java.util.ArrayList<String>();
		parametersToEncrypt.add("ODS_IFRI1_Password");
		// Resume: jobStart
		resumeUtil.addLog("JOB_STARTED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "",
				"", "", "", "", resumeUtil.convertToJsonText(context, parametersToEncrypt));

		if (execStat) {
			try {
				runStat.openSocket(!isChildJob);
				runStat.setAllPID(rootPid, fatherPid, pid, jobName);
				runStat.startThreadStat(clientHost, portStats);
				runStat.updateStatOnJob(RunStat.JOBSTART, fatherNode);
			} catch (java.io.IOException ioException) {
				ioException.printStackTrace();
			}
		}

		java.util.concurrent.ConcurrentHashMap<Object, Object> concurrentHashMap = new java.util.concurrent.ConcurrentHashMap<Object, Object>();
		globalMap.put("concurrentHashMap", concurrentHashMap);

		long startUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		long endUsedMemory = 0;
		long end = 0;

		startTime = System.currentTimeMillis();

		this.globalResumeTicket = true;// to run tPreJob

		this.globalResumeTicket = false;// to run others jobs

		try {
			errorCode = null;
			tFileList_1Process(globalMap);
			if (!"failure".equals(status)) {
				status = "end";
			}
		} catch (TalendException e_tFileList_1) {
			globalMap.put("tFileList_1_SUBPROCESS_STATE", -1);

			e_tFileList_1.printStackTrace();

		}

		this.globalResumeTicket = true;// to run tPostJob

		end = System.currentTimeMillis();

		if (watch) {
			System.out.println((end - startTime) + " milliseconds");
		}

		endUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		if (false) {
			System.out.println(
					(endUsedMemory - startUsedMemory) + " bytes memory increase when running : ReadFile_V04_2");
		}

		if (execStat) {
			runStat.updateStatOnJob(RunStat.JOBEND, fatherNode);
			runStat.stopThreadStat();
		}
		int returnCode = 0;

		if (errorCode == null) {
			returnCode = status != null && status.equals("failure") ? 1 : 0;
		} else {
			returnCode = errorCode.intValue();
		}
		resumeUtil.addLog("JOB_ENDED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "", "",
				"" + returnCode, "", "", "");

		return returnCode;

	}

	// only for OSGi env
	public void destroy() {

	}

	private java.util.Map<String, Object> getSharedConnections4REST() {
		java.util.Map<String, Object> connections = new java.util.HashMap<String, Object>();

		return connections;
	}

	private void evalParam(String arg) {
		if (arg.startsWith("--resuming_logs_dir_path")) {
			resuming_logs_dir_path = arg.substring(25);
		} else if (arg.startsWith("--resuming_checkpoint_path")) {
			resuming_checkpoint_path = arg.substring(27);
		} else if (arg.startsWith("--parent_part_launcher")) {
			parent_part_launcher = arg.substring(23);
		} else if (arg.startsWith("--watch")) {
			watch = true;
		} else if (arg.startsWith("--stat_port=")) {
			String portStatsStr = arg.substring(12);
			if (portStatsStr != null && !portStatsStr.equals("null")) {
				portStats = Integer.parseInt(portStatsStr);
			}
		} else if (arg.startsWith("--trace_port=")) {
			portTraces = Integer.parseInt(arg.substring(13));
		} else if (arg.startsWith("--client_host=")) {
			clientHost = arg.substring(14);
		} else if (arg.startsWith("--context=")) {
			contextStr = arg.substring(10);
			isDefaultContext = false;
		} else if (arg.startsWith("--father_pid=")) {
			fatherPid = arg.substring(13);
		} else if (arg.startsWith("--root_pid=")) {
			rootPid = arg.substring(11);
		} else if (arg.startsWith("--father_node=")) {
			fatherNode = arg.substring(14);
		} else if (arg.startsWith("--pid=")) {
			pid = arg.substring(6);
		} else if (arg.startsWith("--context_type")) {
			String keyValue = arg.substring(15);
			int index = -1;
			if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
				if (fatherPid == null) {
					context_param.setContextType(keyValue.substring(0, index),
							replaceEscapeChars(keyValue.substring(index + 1)));
				} else { // the subjob won't escape the especial chars
					context_param.setContextType(keyValue.substring(0, index), keyValue.substring(index + 1));
				}

			}

		} else if (arg.startsWith("--context_param")) {
			String keyValue = arg.substring(16);
			int index = -1;
			if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
				if (fatherPid == null) {
					context_param.put(keyValue.substring(0, index), replaceEscapeChars(keyValue.substring(index + 1)));
				} else { // the subjob won't escape the especial chars
					context_param.put(keyValue.substring(0, index), keyValue.substring(index + 1));
				}
			}
		} else if (arg.startsWith("--log4jLevel=")) {
			log4jLevel = arg.substring(13);
		} else if (arg.startsWith("--audit.enabled") && arg.contains("=")) {// for trunjob call
			final int equal = arg.indexOf('=');
			final String key = arg.substring("--".length(), equal);
			System.setProperty(key, arg.substring(equal + 1));
		}
	}

	private static final String NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY = "<TALEND_NULL>";

	private final String[][] escapeChars = { { "\\\\", "\\" }, { "\\n", "\n" }, { "\\'", "\'" }, { "\\r", "\r" },
			{ "\\f", "\f" }, { "\\b", "\b" }, { "\\t", "\t" } };

	private String replaceEscapeChars(String keyValue) {

		if (keyValue == null || ("").equals(keyValue.trim())) {
			return keyValue;
		}

		StringBuilder result = new StringBuilder();
		int currIndex = 0;
		while (currIndex < keyValue.length()) {
			int index = -1;
			// judege if the left string includes escape chars
			for (String[] strArray : escapeChars) {
				index = keyValue.indexOf(strArray[0], currIndex);
				if (index >= 0) {

					result.append(keyValue.substring(currIndex, index + strArray[0].length()).replace(strArray[0],
							strArray[1]));
					currIndex = index + strArray[0].length();
					break;
				}
			}
			// if the left string doesn't include escape chars, append the left into the
			// result
			if (index < 0) {
				result.append(keyValue.substring(currIndex));
				currIndex = currIndex + keyValue.length();
			}
		}

		return result.toString();
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public String getStatus() {
		return status;
	}

	ResumeUtil resumeUtil = null;
}
/************************************************************************************************
 * 484766 characters generated by Talend Open Studio for Data Integration on the
 * 31 mars 2022 à 23:36:12 CEST
 ************************************************************************************************/