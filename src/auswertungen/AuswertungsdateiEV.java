package auswertungen;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import android.os.Build;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

public class AuswertungsdateiEV {

	public static void erstelle(String l01, String l02, String l03, String l04,
			String l05, String l06, String l07, String l08, String l09,
			String l010, String l011, String l012, String l013, String l014) {

		String FolderDir = " ";
		/*
		 * Pruefung der Android Version wegen unterschiedlicher Speicherort
		 */
		if (Build.VERSION.SDK_INT == Build.VERSION_CODES.JELLY_BEAN_MR1) {
			FolderDir = "/storage/emulated/0/Steuerberechnung/";
		}
		if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR1) {
			FolderDir = "R.string._sdcard_steuerberechnung";
		}
		/*
		 * Pruefung ob Ordner verhanden ist, wenn nicht Ordner erstellen
		 */
		try {
			File newDir = new File(FolderDir);
			if (!newDir.exists()) {
				newDir.mkdir();
				Toast.makeText(null, "Folder wurde erstellt",
						Toast.LENGTH_SHORT).show();
			}
			/*
			 * Auswertungsdatei erstellen
			 */
			File root = Environment.getExternalStorageDirectory();
			if (root.canWrite()) {
				File txtfile = new File(FolderDir, "Auswertung.txt");
				FileWriter txtwriter = new FileWriter(txtfile);
				BufferedWriter out = new BufferedWriter(txtwriter);
				out.write("----------------------------------------------------");
				out.newLine();
				out.write(l01);
				out.newLine();
				out.write(l02);
				out.newLine();
				out.write("----------------------------------------------------");
				out.newLine();
				out.write(l03);
				out.newLine();
				out.write("----------------------------------------------------");
				out.newLine();
				out.write(l04);
				out.newLine();
				out.write("----------------------------------------------------");
				out.newLine();
				out.write(l05);
				out.newLine();
				out.write(l06);
				out.newLine();
				out.write(l07);
				out.newLine();
				out.write("----------------------------------------------------");
				out.newLine();
				out.write(l08);
				out.newLine();
				out.write("----------------------------------------------------");
				out.newLine();
				out.write(l09);
				out.newLine();
				out.write(l010);
				out.newLine();
				out.write("----------------------------------------------------");
				out.newLine();
				out.write(l011);
				out.newLine();
				out.write(l012);
				out.newLine();
				out.write("----------------------------------------------------");
				out.newLine();
				out.write(l013);
				out.newLine();
				out.write("----------------------------------------------------");
				out.newLine();
				out.write(l014);
				out.newLine();
				out.write("----------------------------------------------------");
				out.close();
			}
		} catch (IOException e) {
			Log.e("Could not write file " + e.getMessage(), null, e);
		}
	}

}
