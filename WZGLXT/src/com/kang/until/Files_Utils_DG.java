package com.kang.until;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

public final class Files_Utils_DG {
	/**
	 * private constructor method that make class can not be instantiation
	 */
	private Files_Utils_DG() {
		throw new Error("The class Cannot be instance !");
	}

	/**
	 * spring mvc files Upload method (transferTo method) MultipartFile use
	 * TransferTo method upload
	 *
	 * @param request
	 *            HttpServletRequest
	 * @param multipartFile
	 *            MultipartFile(spring)
	 * @param filePath
	 *            filePath example "/files/Upload"
	 * @return
	 */
	public static String FilesUpload_transferTo_spring(HttpServletRequest request, MultipartFile multipartFile,
			String filePath) {
		if (multipartFile != null) {
			// get files suffix
			String suffix = multipartFile.getOriginalFilename()
					.substring(multipartFile.getOriginalFilename().lastIndexOf("."));
			// filePath+fileName the complex file Name
			String absolutePath = getAndSetAbsolutePath(request, filePath, suffix);
			// return relative Path
			String relativePath = getRelativePath(filePath, suffix);
			try {
				// save file
				multipartFile.transferTo(new File(absolutePath));
				// return relative Path
				return relativePath;
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
		} else
			return null;
	}

	/**
	 * user stream type save files
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @param multipartFile
	 *            MultipartFile support CommonsMultipartFile file
	 * @param filePath
	 *            filePath example "/files/Upload"
	 * @return
	 */
	
	/**
	 * 文件重命名
	 */
	private static String rename(String name) {

		Long now = Long.parseLong(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
		Long random = (long) (Math.random() * now);
		String fileName = now + "" + random;

		if (name.indexOf(".") != -1) {
			fileName += name.substring(name.lastIndexOf("."));
		}

		return fileName;
	}

	public static String FilesUpload_stream(HttpServletRequest request, MultipartFile multipartFile, String filePath) {
		if (multipartFile != null) {
			// get files suffix
			String suffix = multipartFile.getOriginalFilename()
					.substring(multipartFile.getOriginalFilename().lastIndexOf("."));
			// filePath+fileName the complex file Name
//			String absolutePath = getAndSetAbsolutePath(request, filePath, suffix);
			String getpaths = getPath(request, filePath); 
			// return relative Path
			String relativePath = getRelativePath("", suffix);
			try {
				InputStream inputStream = multipartFile.getInputStream();
				FileOutputStream fileOutputStream = new FileOutputStream(getpaths + relativePath);
//				FileOutputStream fileOutputStream = new FileOutputStream("/usr/local/files" + relativePath);
				byte buffer[] = new byte[4096]; // create a buffer
				long fileSize = multipartFile.getSize();
				if (fileSize <= buffer.length) {// if fileSize < buffer
					buffer = new byte[(int) fileSize];
				}
				int line = 0;
				while ((line = inputStream.read(buffer)) > 0) {
					fileOutputStream.write(buffer, 0, line);
				}
				fileOutputStream.close();
				inputStream.close();
				return relativePath;
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else
			return null;
		return null;
	}

	/**
	 * @param request
	 *            HttpServletRequest
	 * @param response
	 *            HttpServletResponse
	 * @param filePath
	 *            example "/filesOut/Download/mst.txt"
	 * @return
	 */
	public static boolean FilesDownload_stream(HttpServletRequest request, HttpServletResponse response, String filePath) {
		// get server path (real path)
//		String realPath = request.getSession().getServletContext().getRealPath(filePath);
		String realPath = "/usr/local/files"+filePath;
		File file = new File(realPath);
		String filenames = file.getName();
		InputStream inputStream;
		try {
			inputStream = new BufferedInputStream(new FileInputStream(file));
			byte[] buffer = new byte[inputStream.available()];
			inputStream.read(buffer);
			inputStream.close();
			response.reset();
			// 先去掉文件名称中的空格,然后转换编码格式为utf-8,保证不出现乱码,这个文件名称用于浏览器的下载框中自动显示的文件名
			response.addHeader("Content-Disposition",
					"attachment;filename=" + new String(filenames.replaceAll(" ", "").getBytes("utf-8"), "iso8859-1"));
			response.addHeader("Content-Length", "" + file.length());
			OutputStream os = new BufferedOutputStream(response.getOutputStream());
			response.setContentType("application/octet-stream");
			os.write(buffer);// 输出文件
			os.flush();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	// -------------------------------------------------------------------------------
	// return server absolute path（real path）
	public static String getServerPath(HttpServletRequest request, String filePath) {
//		return request.getSession().getServletContext().getRealPath(filePath);
		return "/usr/local/files";
	}

	// return a dir that named date of today ;
	public static String getDataPath() {
		return new SimpleDateFormat("yyyyMMdd").format(new Date());
	}

	// check if the path has exist if not create it
	public static void checkDir(String savePath) {
		File dir = new File(savePath);
		if (!dir.exists() || !dir.isDirectory()) {
			dir.mkdir();
		}
	}

	// return an UUID Name parameter (suffix cover '.') example： ".jpg"、".txt"
	public static String getUUIDName(String suffix) {
		return UUID.randomUUID().toString() + suffix;// make new file name
	}

	// return server absolute path（real path） the style is “server absolute
	// path/DataPath/UUIDName”filePath example "/files/Upload"
	public static String getAndSetAbsolutePath(HttpServletRequest request, String filePath, String suffix) {
		String savePath = getServerPath(request, filePath) + File.separator + getDataPath() + File.separator;// example:F:/qixiao/files/Upload/20160912/
		checkDir(savePath);// check if the path has exist if not create it
		return savePath + getUUIDName(suffix);
	}

	public static String getPath(HttpServletRequest request, String filePath) {
		String savePath = getServerPath(request, filePath);// example:F:/qixiao/files/Upload/20160912/
//		checkDir(savePath);// check if the path has exist if not create it
		return savePath;
	}

	// get the relative path of files style is
	// “/filePath/DataPath/UUIDName”filePath example "/files/Upload"
	public static String getRelativePath(String filePath, String suffix) {
		return filePath + File.separator + File.separator + getUUIDName(suffix);// example:/files/Upload/20160912/
	}
}
