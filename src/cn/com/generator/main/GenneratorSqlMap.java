package cn.com.generator.main;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

public class GenneratorSqlMap {
	public void generator() throws IOException, XMLParserException, InvalidConfigurationException, SQLException, InterruptedException{
		//warningsΪ���ڷ������ɹ����о�����Ϣ�ļ��϶���
		List<String> warnings = new ArrayList<String>();
		
		//ָ��DefaultShellCallback�Ƿ񸲸������ļ�
		boolean overwrite = true;
		
		//���������ļ�
		File configFile = new File("generatorConfig.xml");
		
		//���ý�����
		ConfigurationParser cp = new ConfigurationParser(warnings);

		//���ý�������������ļ�������Configuration���ö���
		Configuration config = cp.parseConfiguration(configFile);
		
		//DefaultShellCallback������δ����ظ��ļ�
		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		
		//���򹤳̶���
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
		
		//ִ�������ļ����ɲ���
		myBatisGenerator.generate(null);
	}
	public static void main(String[] args) throws Exception{
		GenneratorSqlMap genneratorSqlMap = new GenneratorSqlMap();
		genneratorSqlMap.generator();
	}
}
