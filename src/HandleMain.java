import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.File;

public class HandleMain {
  Wc wc = new Wc();
  private static String readAFile(String fileName) throws IOException,FileNotFoundException{
    File file = new File(fileName);
    int size = (int)file.length();
    FileReader reader = new FileReader(file);
    char[] buffer = new char[size];
    reader.read(buffer, 0,size);
    String text = new String(buffer);
    reader.close();
    return text;
  };

  private String getAllDetail(String fileName) throws IOException,FileNotFoundException{
    String text = readAFile(fileName);
    return wc.countAll(text)+" "+fileName+"\n";
  };
  
  private String getAllWords(String fileName) throws IOException,FileNotFoundException{
    String text = readAFile(fileName);
    return "\t"+wc.countWords(text)+" "+fileName+"\n";
  };
  
  private String getAllLines(String fileName) throws IOException,FileNotFoundException{
    String text = readAFile(fileName);
    return "\t"+wc.countLines(text)+" "+fileName+"\n";
  };
  
  private String getAllBytes(String fileName) throws IOException,FileNotFoundException{
    String text = readAFile(fileName);
    return "\t"+wc.countBytes(text)+" "+fileName+"\n";
  };

  public String handleArgs(String[] input) throws IOException,FileNotFoundException{
    String answer = "";
    int result;
    if(input.length == 1){
      return getAllDetail(input[0]);
    }
    else if(input[0].split("")[1].equals("-")){
      int total=0;
      String command = input[0];
//      String command = input[0].split("")[2];
      for(int i=1;i<input.length;i++){
        if(command.contains("w")){
          answer += getAllWords(input[i]);
          total += wc.countWords(readAFile(input[i]));
        }
        else if(command.contains("l")){
          answer += getAllLines(input[i]);
          total += wc.countLines(readAFile(input[i]));
        }
        else if(command.contains("c") || command.equals("m")){
          answer += getAllBytes(input[i]);
          total += wc.countBytes(readAFile(input[i]));
        }
        else{
          return "wc: illegal option -- "+command+"\n"+"usage: wc [-clmw] [file ...]";
        }
      }
      if(input.length > 2){
        answer += "\t"+total+" total";
      }
      return answer;
    }
    else{
      int totalLines=0,totalWords=0,totalBytes=0;
      for(int i=0;i<input.length;i++){
        answer += getAllDetail(input[i]);
        totalLines += wc.countLines(readAFile(input[i]));
        totalWords += wc.countWords(readAFile(input[i]));
        totalBytes += wc.countBytes(readAFile(input[i]));
      }
      answer += "\t"+totalLines+"\t"+totalWords+"\t"+totalBytes+" total";
    }
    return answer;
  }
}
