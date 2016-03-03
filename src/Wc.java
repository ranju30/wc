package src;

public class Wc {
	public int countLines(String text){
		return (text.split("\\n\r?")).length;
	};
	public int countWords(String text){
		return (text.split("\\s+")).length;
	};
	public int countBytes(String text){
		return (text.split("")).length-1;
	};
	public String countAll(String text){
		return "\t"+countLines(text)+"\t"+countWords(text)+"\t"+countBytes(text);
	};
}
