import edu.cmu.sphinx.api.*;
import com.sun.speech.freetts.*;

public class VoiceCalculator {

    private static final String VOICE_NAME = "kevin16";

    public static void main(String[] args) {
        try {
            // Set up speech recognizer
            Configuration configuration = new Configuration();
            configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
            configuration.setDictionaryPath("resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict");
            configuration.setLanguageModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us.lm.bin");

            LiveSpeechRecognizer recognizer = new LiveSpeechRecognizer(configuration);
            recognizer.startRecognition(true);

            Voice voice;
            VoiceManager voiceManager = VoiceManager.getInstance();
            voice = voiceManager.getVoice(VOICE_NAME);
            voice.allocate();

            System.out.println("🎙️ Say something like: 'Add 5 and 6' or 'Multiply 4 and 9'");

            while (true) {
                SpeechResult result = recognizer.getResult();

                if (result != null) {
                    String speech = result.getHypothesis();
                    System.out.println("Heard: " + speech);

                    String response = CalculatorLogic.calculate(speech);
                    System.out.println(response);
                    voice.speak(response);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
