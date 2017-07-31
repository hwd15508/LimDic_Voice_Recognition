//Test Project for CMUSphinx limited dictionary Speech Recognition
//2 External Jar Files Required
//English Acoustic Model provided by CMUSphinx Jar Files
/*Use Sphinx Knowledge Base Tool to create new Language Models and Dictionaries:
 *http://www.speech.cs.cmu.edu/tools/lmtool-new.html */


import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import java.io.IOException;

public class voiceLauncher {
	public static void main(String[] args) throws IOException{
		Configuration configuration = new Configuration();
		configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
		configuration.setDictionaryPath("resource/test.dic");
		configuration.setLanguageModelPath("resource/test.lm");

		LiveSpeechRecognizer recognize = new LiveSpeechRecognizer(configuration);
		recognize.startRecognition(true);

		SpeechResult result;
		while((result=recognize.getResult())!=null){
			String command = result.getHypothesis();
			if(command.equalsIgnoreCase("open file manager")){
				System.out.println("File Manager Opened!");
			}else if(command.equalsIgnoreCase("close file manager")){
				System.out.println("File Manager Closed!");
			}else if (command.equalsIgnoreCase("open browser")) {
                System.out.println("Browser Opened!");
            } else if (command.equalsIgnoreCase("close browser")) {
                System.out.println("Browser Closed!");
            }
		}
	}
}
