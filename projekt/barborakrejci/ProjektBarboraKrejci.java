/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projekt.barborakrejci;

/**
 * @author User
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProjektBarboraKrejci {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {

    List<Otazka> list = new ArrayList<Otazka>();
    String line;

    try {
      BufferedReader reader =
          new BufferedReader(new FileReader("projekt/barborakrejci/projekt-BarboraKrejci.txt"));
      line = reader.readLine();

      while (line != null) {
        String[] splitline = line.split(":");
        while (splitline[0].charAt(0) == '#') {
          if ((line = reader.readLine()) == null) {
            break;
          } else {
            splitline = line.split(":");
          }
        }
        // Kontrola správného formátu otázky
        if (!splitline[0].equals("Otázka 1zN")) {
          throw new IOException("Expected Otázka 1zN, got " + splitline[0]);
        }
        // Vytvoření nové otázky
        Otazka otazka = new Otazka();
        otazka.text = splitline[1];

        // Načtení řádku s body
        if ((line = reader.readLine()) == null) {
          throw new IOException("Unexpected end of file");
        }
        splitline = line.split(":");
        while (splitline[0].charAt(0) == '#') {
          if ((line = reader.readLine()) == null) {
            throw new IOException("Unexpected end of file");
          } else {
            splitline = line.split(":");
          }
        }

        // Kontrola správného formátu bodů
        if (!splitline[0].equals("Hodnota")) {
          throw new IOException("Expected Hodnota, got " + splitline[0]);
        }
        otazka.body = Integer.parseInt(splitline[1]);

        List<String> odpovedi = new ArrayList<String>();

        // Načtení odpovědí
        while ((line = reader.readLine()) != null) {
          splitline = line.split(":");
          while (splitline[0].charAt(0) == '#') {
            if ((line = reader.readLine()) == null) {
              throw new IOException("Unexpected end of file");
            } else {
              splitline = line.split(":");
            }
          }

          if (splitline[0].equals("Otázka 1zN")) {
            break;
          }

          switch (splitline[0]) {
            case "Správně":
              if (otazka.Rodpoved != null) {
                throw new IOException("Multiple correct answers for question " + otazka.text);
              }

              otazka.Rodpoved = splitline[1];
              break;

            case "Špatně":
              odpovedi.add(splitline[1]);
              break;

            default:
              throw new IOException("Expected Správně or Špatně, got " + splitline[0]);
          }
        }

        if (otazka.Rodpoved == null) {
          throw new IOException("No correct answer for question " + otazka.text);
        }

        otazka.Wodpovedi = odpovedi;
        list.add(otazka);
      }
      reader.close();
    } catch (IOException e) {
      System.err.println("Error reading file: " + e.getMessage());
      return;
    }

    Collections.shuffle(list);
    for (Otazka otazka : list) {
      System.out.println(
          "Otazka "
              + (list.indexOf(otazka) + 1)
              + " z 10:"
              + otazka.text
              + "\n"
              + "body:"
              + otazka.body);

      List<String> vsechnyOdpovedi = new ArrayList<String>();
      vsechnyOdpovedi.add("Správně:" + otazka.Rodpoved);
      for (String odpoved : otazka.Wodpovedi) {
        vsechnyOdpovedi.add("Špatně:" + odpoved);
      }
      Collections.shuffle(vsechnyOdpovedi);
      for (String odpoved : vsechnyOdpovedi) {
        System.out.println(odpoved);
      }
    }
  }
}
