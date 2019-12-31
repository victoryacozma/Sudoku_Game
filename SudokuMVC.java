import javax.swing.*;
public class SudokuMVC {
// ... Creeaza modelul, vizulizarea, si controlorul. Aceste sunt
// create aici o data si transmise partilor care au
// nevoie de ele astfel ca exista o singura copie din fiecare.
public static void main(String[] args) {
    SudokuModel model = new SudokuModel();
    SudokuView view = new SudokuView(model);
    SudokuController controller = new SudokuController(model, view);
  //  view.setVisible(true);
}
}