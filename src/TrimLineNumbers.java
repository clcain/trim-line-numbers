import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Text-based utility to trim line numbers from the beginning of lines of a text file.
 * 
 * @author Chandler Cain (chandler@clcain.com)
 * @version 2015.09.04
 *
 */
public class TrimLineNumbers
{

	/**
	 * Launch the application via command-line.
	 * 
	 * @param args
	 *            command-line arguments
	 */
	public static void main(String[] args)
	{
		try
		{
			if (args[0].equals("--help"))
			{
				System.out.println(
						"Utility for trimming line numbers from the beginning of a text file.\nUsage syntax: [input file path] [output file path]");
			}
			else
			{
				Scanner fileScanner = new Scanner(new File(args[0]));
				PrintWriter outputWriter = new PrintWriter(new File(args[1]));
				while (fileScanner.hasNextLine())
				{
					String currentLine = fileScanner.nextLine();
					int i = 0;
					while (i < currentLine.length())
					{
						int currentChar = (int) currentLine.charAt(i);
						System.out.println(currentChar);
						if (currentChar < 48 || currentChar > 57)
						{
							break;
						}
						i++;
					}
					outputWriter.println(currentLine.substring(i, currentLine.length()));
				}
				fileScanner.close();
				outputWriter.close();
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.out.println("Invalid switch or syntax. Type --help for more info.");
			System.exit(1);
		}
	}
}
