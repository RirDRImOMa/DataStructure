package com.sf.datastructure.imageUtil;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.FileWriterWithEncoding;
import org.apache.commons.lang.math.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sf.framework.util.StringUtils;

/**
 * 文件处理工具类
 *
 */
public class FilesUtils {
	
	private FilesUtils() {}
    /**
     * logger
     */
	private static final Logger logger = LoggerFactory.getLogger(FilesUtils.class);

    /**
     * 缓冲区大小
     */
	public static final int FLUSH_BUFFER_SIZE = 10240; // buffer size=10K
    /**
     * 标准UNIX路径分隔符
     */
	private static final String UNIX_FILE_SEPARATOR = "/";
    /**
     * Windows路径分隔符
     */
	private static final String UNIX_WINDOWS_SEPARATOR = "\\";
	
	
	/**
	 * 文件另存为  字节流
	 */
	public static void FileCopy(String readfile,String writeFile) { 
		FileInputStream input = null;
		FileOutputStream output = null;
		try { 
	        input = new FileInputStream(readfile); 
	        output = new FileOutputStream(writeFile);
	        int read = input.read();         
	        while ( read != -1 ) { 
	            output.write(read);  
	            read = input.read(); 
	        }            
	        input.close(); 
	        output.close(); 
	    } catch (IOException e) { 
	        logger.error("文件另存为发生异常-字节流", e); 
	    } finally {
	    	try {
				if (input!=null) {
					input.close();
				}
			} catch (IOException e) {
				logger.error("关闭input发生异常-字节流", e); 
			}
	    	try {
				if (output!=null) {
					output.close();
				}
			} catch (IOException e) {
				logger.error("关闭output发生异常-字节流", e); 
			}
	    }
	}
	
	/**
	 * 文件复制 字符流
	 * @param readfile
	 * @param writeFile
	 */
	public static void FileCopyChar(String readfile,String writeFile) { 
		FileReader input = null;
		FileWriter output = null;
		try { 
	        input = new FileReader(readfile); 
	        output = new FileWriter(writeFile); 
	        int read = input.read();         
	        while ( read != -1 ) { 
	            output.write(read);  
	            read = input.read(); 
	        }            
	        input.close(); 
	        output.close(); 
	    } catch (IOException e) { 
	    	logger.error("文件另存为发生异常", e); 
	    } finally {
	    	try {
				if (input!=null) {
					input.close();
				}
			} catch (IOException e) {
				logger.error("关闭input发生异常", e); 
			}
	    	try {
				if (output!=null) {
					output.close();
				}
			} catch (IOException e) {
				logger.error("关闭output发生异常", e); 
			}
	    }
	} 
	
	/**
	 * 文件复制 字符流 UTF8
	 * @param readfile
	 * @param writeFile
	 */
	public static void FileCopyCharUTF8(String readfile,String writeFile) { 
		BufferedReader input = null;
		FileWriterWithEncoding output = null;
		try { 
			input = new BufferedReader(new InputStreamReader(new FileInputStream(readfile), "GBK"));
			output = new FileWriterWithEncoding(new File(writeFile), "UTF8"); 
			
			int read = input.read();         
			while ( read != -1 ) { 
				output.write(read);  
				read = input.read(); 
			}            
			input.close(); 
			output.close(); 
		} catch (IOException e) { 
	    	logger.error("文件另存为发生异常", e); 
	    } finally {
	    	try {
				if (input!=null) {
					input.close();
				}
			} catch (IOException e) {
				logger.error("关闭input发生异常", e); 
			}
	    	try {
				if (output!=null) {
					output.close();
				}
			} catch (IOException e) {
				logger.error("关闭output发生异常", e); 
			}
	    }
	} 

	/**
	 * 指定编码写文件
	 * @param path:文件绝对路径，需指定文件名
	 * @param content:文件文本内容
	 * @param encoding:编码格式
	 * @author wang zhong fu
	 * */
	public static void write(String path, String content, String encoding)throws IOException {  
		BufferedWriter writer = null;
		try {
			File file = new File(path);  
			file.delete();  
			file.createNewFile();  
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), encoding));  
			writer.write(content);  
			writer.close();
		} catch (Exception e) {
			logger.error("指定编码写文件，发生异常", e);
		} finally {
			if (writer!=null) {
				writer.close();
			}
		}
    }

    /**
     * 自动检测文件编码格式读取文件内容
     * @param filePpath
     * @return
     * @author wang zhogn fu
     */
    public static String readFileContentAutoEncoding(String filePpath){

        try {
            BufferedInputStream bin = new BufferedInputStream(new FileInputStream(filePpath));
            int p = (bin.read() << 8) + bin.read();
            String code;

            switch (p) {
                case 0xefbb:
                    code = "UTF-8";
                    break;
                case 0xfffe:
                    code = "Unicode";
                    break;
                case 0xfeff:
                    code = "UTF-16BE";
                    break;
                default:
                    code = "GBK";
            }
            return readFileContent(filePpath,code);
        } catch (IOException e) {
          logger.error("读取文件出现错误",e);
        }
        return "";
    }

	/**
	 * 指定编码格式读取文件
	 * @param filePath:文件绝对路径
	 * @param encoding:文件编码
	 * @author wang zhong fu
	 * */
	public static String readFileContent(String filePath,String encoding) {
		File wordFile = new File(filePath);
		
		Long filelength = wordFile.length();
		byte[] filecontent = new byte[filelength.intValue()];
		FileInputStream in = null;
		try {
			in = new FileInputStream(wordFile);
			in.read(filecontent);
			in.close();
		} catch (Exception e) {
			logger.error("指定编码格式读取文件", e);
		} finally {
			try {
				if (in!=null) {
					in.close();
				}
			}catch(Exception e) {
				logger.error(e.getMessage(),e);
			}
		}
		
		try {
			String wordsContent = new String(filecontent, encoding);
			return wordsContent;
		}catch(Exception e) {
			logger.error(e.getMessage(),e);
		}
		return "";
	}

	/**
	 * 获取文件类型描述
	 */
	public static String getFileType(File file) {
		if (file == null) {
			return "";
		}
		if (file.isDirectory()) {
			return "文件夹";
		}
		String ext = getFileExt(file.getName());
		return FileType.getFileType(ext);
	}

	/**
	 * 取文件扩展名
	 */
	public static String getFileExt(String clientFileName) {
		String shortFileName = getShortFileName(clientFileName);
		if (clientFileName == null || clientFileName.equals("") || !StringUtils.isNotEmpty(shortFileName)
		        || shortFileName.indexOf(".") == -1) {
			return "";
		}
		String[] arrFile = clientFileName.split("\\x2E"); // "\\x2E" == "."
		return arrFile[arrFile.length - 1].toLowerCase();
	}

	/**
	 * 获取短文件名及包含文件名及扩展名
	 */
	public static String getShortFileName(String fileName) {
		if (fileName == null || fileName.equals("")) {
			return "";
		}
		int index = indexOfLastSeparator(fileName);
		return fileName.substring(index + 1);
	}

	/**
	 * 获取简单文件名, 不包括扩展名
	 *
	 * @param fileName
	 * @return
	 */
	public static String getSimpleFileNameExceptExt(String fileName) {
		if (fileName == null || fileName.length() == 0) {
			return "";
		}
		fileName = getShortFileName(fileName);
		int index = fileName.lastIndexOf(".");
		if(index>-1){
			return fileName.substring(0, index);
		} else {
			return fileName.substring(0);
		}
	}

	/**
	 * 返回文件路径最后一个"/" 或 "\" 的索引位置
	 * */
	public static int indexOfLastSeparator(String filename) {
		if (filename == null) {
			return -1;
		} else {
			int lastUnixPos = filename.lastIndexOf('/');
			int lastWindowsPos = filename.lastIndexOf('\\');
			return Math.max(lastUnixPos, lastWindowsPos);
		}
	}

	/**
	 * 获取文件的大小
	 */
	public static String getFileSize(long filesize) {
		double size = filesize * 1.0d;
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(2);
		nf.setMinimumFractionDigits(0);

		double sizeGB = size / 1024 / 1024 / 1024;
		if (sizeGB >= 1) {
			return nf.format(sizeGB) + " GB";
		}

		double sizeMB = size / 1024 / 1024;
		if (sizeMB >= 1) {
			return nf.format(sizeMB) + " MB";
		}

		double sizeKB = size / 1024;
		if (sizeKB >= 1) {
			return nf.format(sizeKB) + " KB";
		}
		return filesize + " bytes";
	}

	/**
	 * 获取文件的大小
	 */
	public static String getFileSize(File file) {
		return getFileSize(file.length());
	}

	/**
	 * 拷贝文件从目录source到目录target，包括文件名selectedFileNames中的文件
	 *
	 * @throws IOException
	 */
	public static void copyFile(File source, File target, String[] fileNames) throws IOException {
		Arrays.sort(fileNames);
		File[] files = source.listFiles();
		for (int i = 0; i < files.length; i++) {
			File f = files[i];
			if (Arrays.binarySearch(fileNames, f.getName()) >= 0) {
				FileInputStream in = new FileInputStream(f);
				File t = new File(target.getAbsolutePath() + File.separator + f.getName());
				FileOutputStream out = new FileOutputStream(t);
				int c;
				int buffsize = 0;
				while ((c = in.read()) != -1) {
					out.write(c);
					if (buffsize++ == FLUSH_BUFFER_SIZE) {
						out.flush();
						buffsize = 0;
					}
				}
				out.flush();
				out.close();
				in.close();
			}
		}
	}

	/**
	 * 拷贝文件
	 *
	 * @param srcFile
	 *            源文件
	 * @param destFile
	 *            目标文件
	 * @throws IOException
	 *             IO异常
	 */
	public static void copyFile(File srcFile, File destFile) throws IOException {
		copyFile(srcFile, destFile, true);
	}

	/**
	 * 拷贝文件
	 *
	 * @param srcFile
	 *            源文件
	 * @param destFile
	 *            目标文件
	 * @param preserveFileDate
	 *            是否保持时间戳
	 * @throws IOException
	 *             IO异常
	 */
	public static void copyFile(File srcFile, File destFile, boolean preserveFileDate) throws IOException {
		if (srcFile == null) {
			throw new NullPointerException("Source must not be null");
		}
		if (destFile == null) {
			throw new NullPointerException("Destination must not be null");
		}
		if (!srcFile.exists()) {
			throw new IOException("Source '" + srcFile + "' does not exist");
		}
		if (srcFile.isDirectory()) {
			throw new IOException("Source '" + srcFile + "' exists but is a directory");
		}
		if (srcFile.getCanonicalPath().equals(destFile.getCanonicalPath())) {
			throw new IOException("Source '" + srcFile + "' and destination '" + destFile + "' are the same");
		}
		if (destFile.getParentFile() != null && !destFile.getParentFile().exists() && !destFile.getParentFile().mkdirs()) {
			throw new IOException("Destination '" + destFile + "' directory cannot be created");
		}
		if (destFile.exists() && !destFile.canWrite()) {
			throw new IOException("Destination '" + destFile + "' exists but is read-only");
		} else {
			doCopyFile(srcFile, destFile, preserveFileDate);
		}
	}

	// 拷贝文件
	private static void doCopyFile(File srcFile, File destFile, boolean preserveFileDate) throws IOException {
		if (destFile.exists() && destFile.isDirectory()) {
			throw new IOException("Destination '" + destFile + "' exists but is a directory");
		}
		FileInputStream input = new FileInputStream(srcFile);
		try {
			FileOutputStream output = new FileOutputStream(destFile);
			try {
				IOUtils.copy(input, output);
			} finally {
				IOUtils.closeQuietly(output);
			}
		} finally {
			IOUtils.closeQuietly(input);
		}
		if (srcFile.length() != destFile.length()) {
			throw new IOException("Failed to copy full contents from '" + srcFile + "' to '" + destFile + "'");
		}
		if (preserveFileDate) {
			destFile.setLastModified(srcFile.lastModified());
		}
	}

	/**
	 * 默认方式清理指定目录下的文件：文件时间超过24小时者删除
	 *
	 * @param directory
	 */
	public static void defaultClean(File directory) {
		if (!directory.exists()) {
			return;
		}
		long limit = 24 * 60 * 60 * 1000L; // 最大时限24小时
		File[] files = directory.listFiles();
		for (int i = 0; i < files.length; i++) {
			File f = files[i];
			long time = System.currentTimeMillis() - f.lastModified() - limit;
			if (time >= 0) {
				if (f.isDirectory()) {
					defaultClean(f);
				}
				f.delete();
			}
		}
	}

	/**
	 * 删除目录下的超过时限的文件（不含目录）,并且文件的后缀为fileExt中的一个
	 *
	 * @param directory
	 * @param andSubFolder
	 *            是否删除子目录下的文件
	 * @param fileExt
	 *            如"txt,exe,xls"
	 * @throws IOException
	 */
	public static void cleanDir(File directory, boolean andSubFolder, String fileExt) {
		long limit = 24 * 60 * 60 * 1000L; // 最大时限24小时
		String fileext = fileExt.toLowerCase();
		File[] files = directory.listFiles();
		for (int i = 0; i < files.length; i++) {
			File f = files[i];
			long time = System.currentTimeMillis() - f.lastModified() - limit;
			if (time >= 0) {
				if (f.isDirectory() && andSubFolder) {
					cleanDir(f, andSubFolder, fileext);
				}
				String ext = getFileExt(f.getName()).toLowerCase();
				if (f.isFile() && !"".equals(ext) && fileext.indexOf(ext) >= 0) {
					f.delete();
				}
			}
		}
	}

	/**
	 * 判断目录及其子目录下是否有文件
	 *
	 * @param directory
	 * @throws IOException
	 */
	public static boolean containFiles(File directory) throws IOException {
		if (directory == null || !directory.exists()) {
			return false;
		}
		File[] files = directory.listFiles();
		for (int i = 0; i < files.length; i++) {
			File f = files[i];
			if (f.isFile()) {
				return true;
			}
			if (f.isDirectory()) {
				return containFiles(f);
			}
		}
		return false;
	}

	/**
	 * 生成服务器文件名。注意：文件名不能确定唯一性，需要后续判断。
	 *
	 * @param filename
	 *            当前文件名
	 * @return 服务器文件名
	 */
	public static String getServerFilename(String filename) {
		String name = FormatUtils.formatDate(new Date(), "yyyyMMdd") + "_";
		String ext = getFileExt(filename);
		for (int i = 0; i < 5; i++) {
			name += Integer.toString(RandomUtils.nextInt(10));
		}
		if (!"".equals(ext)) {
			name += "." + ext;
		}
		return name;
	}

	/**
	 * 删除目录下的所有文件或目录
	 *
	 * @param directory
	 *            需要删除的目录
	 * @throws IOException
	 *             删除操作异常
	 */
	public static void deleteFiles(File directory) throws IOException {
		File[] files = directory.listFiles();
		for (int i = 0; files != null && i < files.length; i++) {
			File f = files[i];
			if (f.isDirectory()) {
				deleteFiles(f);
			}
			f.delete();
		}
		directory.delete();
	}

	/**
	 * 删除目录下的所有文件
	 *
	 * @param directory
	 *            需要删除文件所属的目录
	 * @throws IOException
	 *             删除操作异常
	 */
	public static void cleanFiles(File directory) throws IOException {
		File[] files = directory.listFiles();
		for (int i = 0; files != null && i < files.length; i++) {
			File f = files[i];
			if (f.isDirectory()) {
				deleteFiles(f);
			}
			f.delete();
		}
	}

	/**
	 * 删除绝对路径文件
	 *
	 * @param file
	 *            需要删除文件所属的目录
	 * @throws IOException
	 *             删除操作异常
	 */
	public static void deleteFile(File file) {
		if (file.isFile()) {
			file.delete();
		}
	}

	/**
	 * 删除绝对路径文件
	 *
	 * @param filePath
	 *            需要删除文件所属的目录
	 * @throws IOException
	 *             删除操作异常
	 */
	public static void deleteFile(String filePath) {
		deleteFile(new File(filePath));
	}

	/**
	 * 删除目录下所有文件（不含目录）,并且文件的后缀为fileExt中的一个
	 *
	 * @param directory
	 *            需要删除的目录
	 * @param alsoSubFolder
	 *            是否删除子目录下的文件
	 * @param fileExt
	 *            文件后缀，用逗号分割，如"txt,exe,xls"
	 * @throws IOException
	 *             删除操作异常
	 */
	public static void deleteFiles(File directory, boolean alsoSubFolder, String fileExt) {
		String fileext = fileExt.toLowerCase();
		File[] files = directory.listFiles();
		for (int i = 0; files != null && i < files.length; i++) {
			File f = files[i];
			if (f.isDirectory() && alsoSubFolder) {
				deleteFiles(f, alsoSubFolder, fileext);
			}
			String ext = getFileExt(f.getName()).toLowerCase();
			if (f.isFile() && !"".equals(ext) && fileext.indexOf(ext) >= 0) {
				f.delete();
			}
		}
	}

	/**
	 * 创建一个指定编码的文件Writer
	 *
	 * @param out
	 *            输出
	 * @param enc
	 *            编码
	 * @return Writer
	 * @throws UnsupportedEncodingException
	 *             不支持的编码
	 */
	public static Writer makeWriter(OutputStream out, String enc) throws UnsupportedEncodingException {
		if ("UTF-8".equals(enc)) {
			enc = "UTF8";
		}
		Writer writer = new BufferedWriter(new OutputStreamWriter(new BufferedOutputStream(out), enc));
		return writer;
	}

	/**
	 * 创建一个指定编码的文件Reader
	 *
	 * @param in
	 *            输入
	 * @param enc
	 *            编码
	 * @return Reader
	 * @throws UnsupportedEncodingException
	 *             不支持的编码
	 */
	public static Reader makeReader(InputStream in, String enc) throws UnsupportedEncodingException {
		if ("UTF-8".equals(enc)) {
			enc = "UTF8";
		}
		Reader reader = new BufferedReader(new InputStreamReader(new BufferedInputStream(in), enc));
		return reader;
	}

	/**
	 * 创建整个目录
	 *
	 * @param path
	 *            目录路径
	 * @return 目录存在否
	 */
	public static boolean createDir(String path) {
		File file = new File(path);
		return file.exists() ? true : file.mkdirs();
	}

	/**
	 *
	 * @param inputFileName
	 *            输入一个文件夹
	 * @param zipFileName
	 *            输出一个压缩文件夹，打包后文件名字
	 * @throws Exception
	 */
	/*
	  public static void zip(String inputFileName, String zipFileName) throws
	 Exception { zip(zipFileName, new File(inputFileName)); }
	 */

	/*
	  private static void zip(String zipFileName, File inputFile) throws
	  Exception { ZipOutputStream out = new ZipOutputStream(new
	 FileOutputStream(zipFileName)); String base = ""; if (inputFile.isFile())
	  { base = inputFile.getName(); } zip(out, inputFile, base, new
	  File(zipFileName)); out.close(); }
	 */

	/*
	  private static void zip(ZipOutputStream out, File f, String base, File
	 zipFile) throws Exception { if (f.isDirectory()) { // 判断是否为目录 File[] fl =
	 f.listFiles(); out.putNextEntry(new org.apache.tools.zip.ZipEntry(base +
	 "/")); base = base.length() == 0 ? "" : base + "/"; for (int i = 0; i <
	  fl.length; i++) { zip(out, fl[i], base + fl[i].getName(), zipFile); } }
	  else { // 压缩目录中的所有文件 if (f.equals(zipFile)) { return; }
	  out.putNextEntry(new org.apache.tools.zip.ZipEntry(base));
	  BufferedInputStream bin = new BufferedInputStream(new FileInputStream(f),
	  FLUSH_BUFFER_SIZE); int count; byte[] data = new byte[FLUSH_BUFFER_SIZE];
	  while ((count = bin.read(data, 0, FLUSH_BUFFER_SIZE)) != -1) {
	  out.write(data, 0, count); } bin.close(); } }
	 */

	/**
	 * 文件解压缩
	 *
	 * @param inputFile
	 *            压缩文件
	 * @param outputPath
	 *            输出路径
	 * @throws Exception
	 */
	public static List<File> unzip(File inputFile, String outputPath) {
		ZipFile zipFile;
		try{
			zipFile = new ZipFile(inputFile);
			ZipInputStream zis = new ZipInputStream(new FileInputStream(inputFile));
			ZipEntry zipEntry;
			List<File> files = new ArrayList<File>();
			while ((zipEntry = zis.getNextEntry()) != null) {
				String fileName = zipEntry.getName();
				File temp = new File(outputPath + fileName);
				if (zipEntry.isDirectory()) {
					createDir(temp);
					continue;
				}
				if (!temp.getParentFile().exists()) {
					temp.getParentFile().mkdirs();
				}
				OutputStream os = new FileOutputStream(temp, true);
				InputStream is = zipFile.getInputStream(zipEntry);
				BufferedInputStream bis = new BufferedInputStream(is, FLUSH_BUFFER_SIZE);
				int len;
				byte[] buffer = new byte[FLUSH_BUFFER_SIZE];
				while ((len = bis.read(buffer, 0, FLUSH_BUFFER_SIZE)) > 0) {
					os.write(buffer, 0, len);
				}
				os.close();
				bis.close();
				if(temp.isFile()){
					files.add(temp);
				}
			}
			zis.closeEntry();
			zis.close();
			zipFile.close();
			return files;
		}catch(Exception e){
			logger.error(e.getMessage(),e);
		}
		return  Collections.emptyList();
		
	}

	private static void createDir(File file){
		file.mkdirs();
	}
	/**
	 *(生成文件名用)
	 * @param @return
	 * @return String
	 * @throws
	 */
	public static String generateDirPathByTimestamp() {
		StringBuilder sb = new StringBuilder();
		Date date = new Date();
		Long stamp = date.getTime();
		String formatStamp = String.format("%015d", stamp);
		for (int i = 0; i < formatStamp.length() / 3; i++) {
			sb.append(UNIX_FILE_SEPARATOR).append(formatStamp.substring(3 * i, 3 * (i + 1)));
		}
		return sb.toString();
	}

    /**
     * 获取最后一个路径分隔符的位置
     * @param filePath
     * @return
     */
	public static int lastFileSeparator(String filePath) {
		int i = filePath.lastIndexOf(File.separator);
		if (i == -1)
			i = filePath.lastIndexOf(UNIX_FILE_SEPARATOR);
		if (i == -1)
			i = filePath.lastIndexOf(UNIX_WINDOWS_SEPARATOR);
		return i;
	}

    /**
     * 获取文件所在的文件夹名字
     * @param filePath
     * @return
     */
	public static String getFileDir(String filePath) {
		int i = lastFileSeparator(filePath);
		if (i > 0)
			return filePath.substring(0, i + 1);
		return filePath;
	}

    /**
     * 初始化文件
     * @param fullFilePath
     * @return
     * @throws IOException
     */
	public static File initFile(String fullFilePath) throws IOException {
		File file = new File(fullFilePath);
		if (!file.exists()) {
			initDirPath(getFileDir(fullFilePath));
			file.createNewFile();
		}
		return file;
	}

    /**
     * 初始化目录
     * @param path
     * @return
     */
	public static String initDirPath(String path) {
		if (path == null)
			throw new IllegalArgumentException("Please initialize incoming message source folder path!");
		if (!path.endsWith(File.separator))
			path += File.separator;
		File file = new File(path);
		if (!file.exists())
			file.mkdirs();
		return path;
	}

    /**
     * 拷贝文件
     * @param sourceFilePath
     * @param destFilePath
     * @throws IOException
     */
	public static void copyTo(String sourceFilePath, String destFilePath) throws IOException {
		InputStream is = null;
		OutputStream fs = null;
		try {
			is = new FileInputStream(sourceFilePath);
			initFile(destFilePath);
			fs = new FileOutputStream(destFilePath);
			int byteread;
			byte[] buffer = new byte[1444];
			while ((byteread = is.read(buffer)) != -1) {
				fs.write(buffer, 0, byteread);
			}
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					logger.error(e.getMessage(),e);
				}
			}
			if (fs != null) {
				try {
					fs.close();
				} catch (IOException e) {
					logger.error(e.getMessage(),e);
				}
			}
		}
	}

	/**
	 * copy 文件夹
	 * @param sourceDir
	 * @param targetDir
	 * @throws IOException
	 */
	 public static void copyDirectiory(String sourceDir, String targetDir) throws IOException {
	        // 新建目标目录
	        (new File(targetDir)).mkdirs();
	        // 获取源文件夹当前下的文件或目录
	        File[] file = (new File(sourceDir)).listFiles();
	        for (int i = 0; i < file.length; i++) {
	            if (file[i].isFile()) {
	                // 源文件
	                File sourceFile = file[i];
	                // 目标文件
	                File targetFile = new File(new File(targetDir).getAbsolutePath() + File.separator + file[i].getName());
	                copyFile(sourceFile, targetFile);
	            }
	            if (file[i].isDirectory()) {
	                // 准备复制的源文件夹
	                String dir1 = sourceDir + "/" + file[i].getName();
	                // 准备复制的目标文件夹
	                String dir2 = targetDir + "/" + file[i].getName();
	                copyDirectiory(dir1, dir2);
	            }
	        }
	    }
	 
	/**
	 * 合并文件，将filesForMerge数组中的文件添加到outfile的结尾
	 * @param outFile 合并的主文件（所有文件添加到此文件的末尾）
	 * @param filesForMerge 待合并的文件数组
	 * @author weiliang.mao
	 */
	public static void mergeFiles(File outFile, File... filesForMerge) {
		FileChannel outChannel = null;
		FileOutputStream output = null;
		FileInputStream input = null;
		FileChannel fc = null;
		try {
			output = new FileOutputStream(outFile,true);
			outChannel = output.getChannel();
			for (File f : filesForMerge) {
				input = new FileInputStream(f);
				fc = input.getChannel();
				ByteBuffer bb = ByteBuffer.allocate(1024 * 8);
				while (fc.read(bb) != -1) {
					bb.flip();
					outChannel.write(bb);
					bb.clear();
				}
				output.flush();
			}
		} catch (IOException ioe) {
			logger.error(ioe.getMessage(),ioe);
		} finally {
			IOUtils.closeQuietly(output);
			IOUtils.closeQuietly(outChannel);
			IOUtils.closeQuietly(input);
			IOUtils.closeQuietly(fc);
		}
	}
	 
	/*
	public static void main(String[] args) {
		FileCopyCharUTF8("D:\\temp\\conv\\test.txt", "D:\\temp\\conv\\test1.txt");
	}*/
}
