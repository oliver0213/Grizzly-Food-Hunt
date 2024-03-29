/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webcrawler;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;




/**
 *
 * @author yunfa
 */
public class Webcrawler {
static String SendGet(String url)
	{
		// 定义一个字符串用来存储网页内容 resulr to save website content
		String result = "";
		// 定义一个缓冲字符输入流 
		BufferedReader in = null;
		try
		{
			// 将string转成url对象     string->url
			URL realUrl = new URL(url);
			// 初始化一个链接到那个url的连接 create a link to url
			URLConnection connection = realUrl.openConnection();
			// 开始实际的连接 connect
			connection.connect();
			// 初始化 BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			// 用来临时存储抓取到的每一行的数据
			String line;
			while ((line = in.readLine()) != null)
			{
				// 遍历抓取到的每一行并将其存储到result里面
				result += line;
			}
		} catch (Exception e)
		{
			System.out.println("error for sending GET request！" + e);
			e.printStackTrace();
		}
		// 使用finally来关闭输入流  close input
		finally
		{
			try
			{
				if (in != null)
				{
					in.close();
				}
			} catch (Exception e2)
			{
				e2.printStackTrace();
			}
		}
		return result;
	}

	static String RegexString(String targetStr, String patternStr)
	{
		// 定义一个样式模板，此中使用正则表达式，括号中是要抓的内容
		// 相当于埋好了陷阱匹配的地方就会掉下去
		Pattern pattern = Pattern.compile(patternStr);
		// 定义一个matcher用来做匹配  create a matcher to match
		Matcher matcher = pattern.matcher(targetStr);
		// 如果找到了   if find it 
		if (matcher.find())
		{
			// 打印出结果
			return matcher.group(0);
		}
		return "Nothing";
	}

	public static void main(String[] args)
	{
		// 定义即将访问的链接  website link
		String url = "https://www.subway.com/en-US/MenuNutrition/Menu/All";
		// 访问链接并获取页面内容 get the website content
		String result = SendGet(url);
		// 使用正则匹配图片的src内容  use regular expression
		String imgSrc = RegexString(result,".*");
		// 打印结果
		System.out.println(imgSrc);
	}
}