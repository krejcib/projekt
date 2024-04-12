/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projekt.barborakrejci;

/**
 *
 * @author User
 */
public class Otazky {
    String text;
    int body;
    String Wodpovedi[];
    String Rodpoved;
    public Otazky(String text, int body, String Wodpovedi[], String Rodpoved) {
    this.text=text;
    this.body=body;
    this.Wodpovedi=Wodpovedi;
    this.Rodpoved=Rodpoved;
}
    public void Vypis(int delka) {
        System.out.println(text+"\n"+body+"\n"+Rodpoved);
        for (int i=0;i<delka;i++) {
            System.out.println(Wodpovedi[i]);
        }
    }
}
