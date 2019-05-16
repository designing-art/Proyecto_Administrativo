package reconocimiento_por_voz;

import javax.speech.*;
import javax.speech.recognition.*;
import java.io.FileReader;
import java.util.Locale;

public class Escuchar extends ResultAdapter {

	static Recognizer recognizer;
	String gst;

	@Override
	public void resultAccepted(ResultEvent re) {
		try {
			Result res = (Result) (re.getSource());
			ResultToken tokens[] = res.getBestTokens();

			String args[] = new String[1];
			args[0] = "";
			for (int i = 0; i < tokens.length; i++) {
				gst = tokens[i].getSpokenText();
				args[0] += gst + " ";
				System.out.print(gst + " ");
			}
			System.out.println();
			if (gst.equals("Salir")) {
				recognizer.deallocate();
				args[0] = "Hasta luego!";
				System.out.println(args[0]);
				System.exit(0);
			} else {
				recognizer.suspend();
				recognizer.resume();
			}
		} catch (Exception ex) {
			System.out.println("Ha ocurrido algo inesperado " + ex);
		}
	}

	public static void main(String args[]) {
		try {
			recognizer = Central.createRecognizer(new EngineModeDesc(Locale.ROOT));
			recognizer.allocate();

			FileReader grammar1 = new FileReader("C:\\Users\\hp\\Documents\\GitHub\\Proyecto_Administrativo\\librerias\\diccionario.txt");

			RuleGrammar rg = recognizer.loadJSGF(grammar1);
			rg.setEnabled(true);

			recognizer.addResultListener(new Escuchar());

			System.out.println("Empieze Dictado");
			recognizer.commitChanges();

			recognizer.requestFocus();
			recognizer.resume();
		} catch (Exception e) {
			System.out.println("Exception en " + e.toString());
			e.printStackTrace();
			System.exit(0);
		}
	}
}