/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projekt.barborakrejci;

import java.util.List;

/**
 * @author Barbora Krejci
 */
public class Otazka {
  String text;
  int body;
  List<String> Wodpovedi;
  String Rodpoved;

  public Otazka() {}

  public void Vypis() {
    System.out.println(text + "\n" + body + "\n" + Rodpoved);
    for (String s : Wodpovedi) {
      System.out.println(s);
    }
  }
}
