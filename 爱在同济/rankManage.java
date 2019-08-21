package servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import beans.Tag;
import daos.TagDao;

public class rankManage {
	private List<String> importantword = new ArrayList<String>();
	private List<String> redpeople = new ArrayList<String>();
	rankManage() throws IOException, InterruptedException
	{
        String exe = "python";
        String command = "biaobaimatch.py";
        String tags = " ";
        List<Tag> tag=(new TagDao()).getTaglast300();
        for(int i =0 ; i<tag.size();i++)
        {
        	tags += tag.get(i).getText();
        }
        String[] cmdArr = new String[] {exe, command,tags};
        Process process = Runtime.getRuntime().exec(cmdArr);
        
        InputStream is = process.getInputStream();
        int wf =process.waitFor();
        System.out.println(wf);
        BufferedReader dis = new BufferedReader(new InputStreamReader(is));
        
        InputStream error = process.getErrorStream(); //得到命令执行的错误流
        BufferedReader errorbr = new BufferedReader(new InputStreamReader(error));
        String lineStr;
        while ((lineStr = errorbr.readLine()) != null) {
            System.out.println("error:"+lineStr);
        }
        errorbr.close();
        error.close();

        
        int flag =0;
        String inputLine;
        while((inputLine=dis.readLine())!=null)
        {
        	//System.out.println(inputLine);
        	if (inputLine.equals("红人"))
        		{flag=1;
        		continue;
        		}
        	
        	if (flag==0)
        		importantword.add(inputLine);
        	else
        		redpeople.add(inputLine);	
        }
	}
	public List<String> getRedpeople() {
		return redpeople;
	}
	public List<String> getImportantword() {
		return importantword;
	}
}
