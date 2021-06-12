import java.io.*;
import java.net.*;
public class client
{
	public static void main(String[] args) 
	{
		try
		{
			Socket s = new Socket("192.168.56.1",6666);
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			DataOutputStream dout = new DataOutputStream(s.getOutputStream());
			DataInputStream dis = new DataInputStream(s.getInputStream());
			String str="",str1="";
			while(!str.equalsIgnoreCase("exit"))
			{
				str = br.readLine();
				dout.writeUTF(str);
				dout.flush();
				str1 = dis.readUTF();
				System.out.println("Server = "+str1);
			}
			dout.close();
			s.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}