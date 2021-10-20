import java.awt.*;

class FolderFactory
{
   Folder unselected, selected;
   public FolderFactory()
      {
      Color brown = new Color(0x5f5f1c);
      selected =  new Folder(brown);
      unselected = new Folder(Color.yellow);
      }
//-------------------------------  
   public Folder getFolder(boolean isSelected)
   {
      if (isSelected) 
         return selected;
      else
         return unselected;
   }

}
