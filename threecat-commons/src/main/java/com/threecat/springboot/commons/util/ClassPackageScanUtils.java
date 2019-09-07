package com.threecat.springboot.commons.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ClassPackageScanUtils
{
	private static Logger logger = LoggerFactory.getLogger(PropertiesUtils.class);

	/**
	 * 扫描指定路径下的class文件
	 * @param packagePath
	 * @return
	 */
	public static List<String> scanPackage(String packagePath)
	{
		if (CommonUtils.isEmptyStr(packagePath))
		{
			logger.error("Empty package path!");
			return null;
		}
		List<String> classCompleteNames = new ArrayList<>();
		//将所有.替换为/，并加上/
		packagePath = packagePath.replace(".", "/");
		//去掉第一个"/"
		packagePath = packagePath.startsWith("/") ? packagePath.substring(1) : packagePath;
		URL url = ClassPackageScanUtils.class.getClassLoader().getResource(packagePath);
		listFiles(url.getFile(), classCompleteNames);
		return classCompleteNames;
	}

	/**
	 * 递归遍历该目录下所有class文件
	 * @param path
	 * @param classCompleteNames
	 */
	private static void listFiles(String path, List<String> classCompleteNames)
	{
		File classFile = new File(path);
		for (File file : classFile.listFiles())
		{
			// 是文件夹就继续往子目录冲
			if (file.isDirectory())
			{
				listFiles(path + "/" + file.getName(), classCompleteNames);
			}
			else if (file.getName().endsWith(".class"))
			{
				classCompleteNames.add(path + "/" + file.getName());
			}
		}
	}
}
