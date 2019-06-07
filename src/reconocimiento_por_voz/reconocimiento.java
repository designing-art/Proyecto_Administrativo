package reconocimiento_por_voz;
 
import javax.speech.Central;
import javax.speech.recognition.*;
import java.io.FileReader;
import java.util.Locale;
 
public class reconocimiento extends ResultAdapter {
  static Recognizer recognizer;
  public void resultAccepted(ResultEvent resultEvent) {
    Result result = (Result)(resultEvent.getSource());
    ResultToken resultToken[] = result.getBestTokens();
    for (int nIndex = 0; nIndex < resultToken.length; nIndex++){
        System.out.print(resultToken[nIndex].getSpokenText() + " ");
    }
    try {      
         // Deallocate the recognizer
         recognizer.forceFinalize(true);          
         recognizer.deallocate();
        }catch (Exception exception) {
         exception.printStackTrace();
        }
       System.exit(0);
    }
 
    public static void main(String args[]) {
    try {
          Central.registerEngineCentral 
             ("com.cloudgarden.speech.CGEngineCentral");
          RecognizerModeDesc desc = 
              new RecognizerModeDesc(Locale.ENGLISH,Boolean.TRUE);
         // Create a recognizer that supports US English.
         recognizer = Central.createRecognizer(desc);
         // Start up the recognizer
         recognizer.allocate();
         // Load the grammar from a file, and enable it
         FileReader fileReader =  
             new FileReader("C:\\Users\\hp\\Documents\\GitHub\\Proyecto_Administrativo\\diccionario.gram");
         RuleGrammar grammar = recognizer.loadJSGF(fileReader);
         grammar.setEnabled(true);
         // Add the listener to get results
         recognizer.addResultListener(new reconocimiento());
         // Commit the grammar
         recognizer.commitChanges();
         recognizer.waitEngineState(Recognizer.LISTENING);
         // Request focus and start listening
         recognizer.requestFocus();
         recognizer.resume();
         recognizer.waitEngineState(Recognizer.FOCUS_ON);
         recognizer.forceFinalize(true);               
         recognizer.waitEngineState(Recognizer.DEALLOCATED);
        } catch (Exception e) {
          e.printStackTrace();
          System.exit(0);
         }
   }
}