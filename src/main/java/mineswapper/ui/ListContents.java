package mineswapper.ui;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.nio.file.Path;


public class ListContents extends JFrame{
  public List<Path> pathsToList;
  private final int xsize = 500;
  private final int ysize = 600;

  public ListContents(List<Path> paths){
    this.pathsToList = paths;

    JButton btn = new JButton("teste");
    btn.setBounds(130, 200, 40, 40);
    add(btn);

    setSize(xsize, ysize);
    setVisible(true);
  }

  public void setPathsList(String[] paths){
    pathsToList.clear();
    for (String path : paths) {
      pathsToList.add(Path.of(path));
    }
  }
}